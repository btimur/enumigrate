package kz.arta.ext.migrate.service;

import kz.arta.ext.migrate.model.MigrateStatusEntity;
import kz.arta.ext.migrate.model.OrderDocsEntity;
import kz.arta.ext.migrate.model.synergy.Orders;
import kz.arta.ext.migrate.rest.MigrateStatusWrapper;
import kz.arta.ext.migrate.util.CodeConstants;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by timur on 12/07/2014 23:45.
 */
@Stateless
public class OrdersMigrateRepository {

    @Inject
    protected EntityManager em;


    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void updateOrderDocs(OrderDocsEntity orderDocsEntity) {
        em.merge(orderDocsEntity);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void updateMigrateStatus(MigrateStatusEntity migrateStatusEntity) {
        em.merge(migrateStatusEntity);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object find(Class entityClass, Object id) {
        return em.find(entityClass, id);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Orders> getOrders() {
        return em.createNamedQuery("OrderQuery", Orders.class).getResultList();
    }
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Orders getOrder(Integer orderId) {
        return em.createNamedQuery("OrderQuery", Orders.class).setParameter(1, orderId).getSingleResult();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Integer> getOrderIds() {
        return em.createQuery("select o.id from OrderDocsEntity o where o.migrateUUID is null and o.idOrder > 0", Integer.class).getResultList();
    }
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public MigrateStatusWrapper getMigrateStatusWrapper() {

        MigrateStatusWrapper migrateStatusWrapper = new MigrateStatusWrapper();
        Integer val = em.find(MigrateStatusEntity.class, CodeConstants.MIGRATE_STATUS_CODE).getVal();
        migrateStatusWrapper.setIsStarted(val.equals(CodeConstants.MIGRATE_WORK));
        migrateStatusWrapper.setCountDid(em.find(MigrateStatusEntity.class, CodeConstants.MIGRATE_ORDERS_CODE).getVal());
        migrateStatusWrapper.setCountAll(
                (Long) em.createQuery("select count(id) from OrderDocsEntity").getSingleResult());
        migrateStatusWrapper.setProcent(migrateStatusWrapper.getCountDid()*100.0
                /
                (migrateStatusWrapper.getCountAll().intValue() + migrateStatusWrapper.getCountDid())
        );
        return migrateStatusWrapper;
    }

//    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
//    public List getOrdersId() {
//        return em.createQuery("select o.id from OrderDocsEntity o where o.migrateUUID is null").setMaxResults(1).getResultList();
//    }
//
//    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
//    public Orders getOrders(Integer id) {
//        return em.find(Orders.class, id);
//    }
}
