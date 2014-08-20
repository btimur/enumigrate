package kz.arta.ext.migrate.service;

import kz.arta.ext.api.config.ConfigUtils;
import kz.arta.ext.api.data.RegistryRecord;
import kz.arta.ext.migrate.model.MigrateStatusEntity;
import kz.arta.ext.migrate.model.OrderDocsEntity;
import kz.arta.ext.migrate.model.synergy.KeyObject;
import kz.arta.ext.migrate.model.synergy.Orders;
import kz.arta.ext.migrate.rest.api.OrdersReader;
import kz.arta.ext.migrate.rest.api.UserAdditionalReader;
import kz.arta.ext.migrate.util.CodeConstants;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by timur on 10/07/2014 11:42.
 */
@Stateless
public class OrdersMigrateService extends AMigrateService {


    @Inject
    private OrdersReader reader;

    @Inject
    private UserAdditionalReader userReader;

    @Inject
    private OrdersMigrateRepository repository;

    private Map<Integer, KeyObject> siglas;

    @Override
    public void startProcess(Integer startStatus) throws InterruptedException {
        log.info("Start migrate orders");
        MigrateStatusEntity migrateStatus = (MigrateStatusEntity) repository.find(MigrateStatusEntity.class, CodeConstants.MIGRATE_STATUS_CODE);
        if (startStatus.equals(CodeConstants.MIGRATE_WORK) && migrateStatus.getVal().equals(CodeConstants.MIGRATE_WORK)) {
            return;
        }
        migrateStatus.setVal(startStatus);
        repository.updateMigrateStatus(migrateStatus);
        if (startStatus.equals(CodeConstants.MIGRATE_STOP)) {
            return;
        }

        fillSigls();
        List<Integer> ordersIds = repository.getOrderIds();
        for (Integer orderId : ordersIds) {
            Orders order = repository.getOrder(orderId);
            if (order.getMigrateUUID() != null) {
                log.info("migrated in other mdb ");
                continue;
            }
            boolean res = saveOneOrder(order);
            if (res) {
                MigrateStatusEntity migrateCount = (MigrateStatusEntity) repository.find(MigrateStatusEntity.class, CodeConstants.MIGRATE_ORDERS_CODE);
                migrateCount.setVal(migrateCount.getVal() + 1);
                repository.updateMigrateStatus(migrateCount);
            }
            migrateStatus = (MigrateStatusEntity) repository.find(MigrateStatusEntity.class, CodeConstants.MIGRATE_STATUS_CODE);
            if (migrateStatus.getVal().equals(CodeConstants.MIGRATE_STOP)) {
                log.info("flag stop was notify ");
                break;
            } else {
//                Thread.sleep(10000);//[TODO] для тестирование
            }
        }
    }

    private boolean saveOneOrder(Orders order) {
        prepareOrder(order);
        loadToApi(order);
        if (order.getMigrateUUID() != null) {
            OrderDocsEntity orderDocsEntity = (OrderDocsEntity) repository.find(OrderDocsEntity.class, order.getId());
            orderDocsEntity.setMigrateUUID(order.getMigrateUUID());
//                orderDocsEntity.setErrorInfo(order.getErrorInfo());
            repository.updateOrderDocs(orderDocsEntity);
            log.info("load to Synergy order id = " + order.getId() + ", uuid = " + order.getMigrateUUID());
            return true;
        } else {
            log.info("error load to Synergy order id = " + order.getId());
            return false;
        }
    }

    private void prepareOrder(Orders order) {
        order.setSigla(getKeySigl(order.getSiglID()));
        order.setInformation2("Заказ смигирован из старой БД id = " + order.getId());
        updateStatus(order);
        if (order.getIin() == null){
            order.setIin(order.getIinplt());
        }
        if (order.getIin() != null) {
            updateFio(order);
        }
        if ((order.getUserid() == null || order.getUserid().trim().length() == 0)
                && order.getFio() != null ){
            order.setUserid(order.getFio());
        }
    }

    private void updateFio(Orders order) {
        order.setUserid(userReader.getUserIdByIin(ConfigUtils.getQueryContext(), order.getIin()));
    }

    private void updateStatus(Orders order) {
        Date now = new Date();
        if (order.getDateofsdacha() == null &&
                order.getSrokvozvrata() != null &&
                order.getSrokvozvrata().compareTo(now) < 0) {
            order.setStatus("2");//Просрочено
        } else if (order.getDateofsdacha() == null &&
                order.getSrokvozvrata() != null &&
                order.getSrokvozvrata().compareTo(now) > 0) {
            order.setStatus("1");//На руках
        } else if (order.getDateofsdacha() != null &&
                order.getSrokvozvrata() != null &&
                order.getSrokvozvrata().compareTo(order.getDateofsdacha()) < 0) {
            order.setStatus("3");//Вовремя
        }
    }


    private void fillSigls() {
        siglas = new HashMap<Integer, KeyObject>();
        siglas.put(6, new KeyObject(String.valueOf(19), "Иностранный абонемент"));
        siglas.put(16, new KeyObject(String.valueOf(31), "Информационно-библиографический отдел"));
        siglas.put(5, new KeyObject(String.valueOf(18), "Научный абонемент"));
        siglas.put(11, new KeyObject(String.valueOf(23), "Универсальный ч/з"));
        siglas.put(4, new KeyObject(String.valueOf(24), "Учебный абонемент"));
        siglas.put(7, new KeyObject(String.valueOf(27), "Аб. художественной литературы"));
        siglas.put(12, new KeyObject(String.valueOf(21), "Ч/з социально-экономической литературы"));

    }

    private KeyObject getKeySigl(Integer siglID) {
        return siglas.get(siglID);
    }

    private void loadToApi(Orders order) {
        try {
            boolean result = reader.saveOrder(order, ConfigUtils.getQueryContext());
            if (!result) {
                order.setMigrateUUID(null);
            } else {
                RegistryRecord record = reader.activateRecord(ConfigUtils.getQueryContext(), order.getMigrateUUID());
                if (!record.getErrorCode().equals("0")){
                    log.error("Error activate order " + order.getMigrateUUID() + " error code "
                            + record.getErrorCode() + " message " + record.getErrorMessage());
                    order.setMigrateUUID(null);

                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
//            order.setErrorInfo(e.getMessage());
            order.setMigrateUUID(null);
        }

    }

}
