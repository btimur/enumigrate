package kz.arta.ext.migrate.rest.api;

import kz.arta.ext.api.config.ConfigReader;
import kz.arta.ext.api.data.FormData;
import kz.arta.ext.api.data.FormField;
import kz.arta.ext.api.data.FormFieldsWrapper;
import kz.arta.ext.api.data.RegistryRecord;
import kz.arta.ext.api.rest.AFormsReader;
import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.migrate.model.synergy.KeyObject;
import kz.arta.ext.migrate.model.synergy.Orders;
import kz.arta.ext.migrate.util.ApiFormField;
import kz.arta.ext.migrate.util.CodeConstants;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Created by timur on 12/07/2014 12:46.
 */
public class OrdersReader extends AFormsReader {
    private final String formUUID;
    private final String registryUUID;
    private SimpleDateFormat sfDate;
    private SimpleDateFormat sfDateTime;


    public OrdersReader() {
        formUUID = ConfigReader.getPropertyValue(CodeConstants.ORDER_FORM_UUID);
        registryUUID = ConfigReader.getPropertyValue(CodeConstants.ORDER_REGISTRY_UUID);
        sfDate = new SimpleDateFormat(ConfigReader.getPropertyValue(CodeConstants.FORMAT_DATE));
        sfDateTime = new SimpleDateFormat(ConfigReader.getPropertyValue(CodeConstants.FORMAT_DATETIME));
    }

    public boolean saveOrder(Orders order, RestQueryContext queryContext) throws Exception {
        boolean updateSuccess = false;
        boolean newRecord = true;
        if (order.getMigrateUUID() != null && order.getMigrateUUID().length() > 0) {
            newRecord = false;
        }
        if (newRecord) {
            RegistryRecord registryRecord = addNewRegistryRecord(queryContext,
                    registryUUID);
            if (registryRecord != null && registryRecord.getDataUUID() != null && registryRecord.getDataUUID().length() > 0) {
                order.setMigrateUUID(registryRecord.getDataUUID());
            } else {
                return false;
            }
        }
        FormData formData = readFormData(queryContext, order.getMigrateUUID());

        if (formData != null) {
            FormFieldsWrapper fieldsWrapper = formData.convertToWrapper();
            if (fieldsWrapper != null) {
                Map<String, FormField> fieldMap = fieldsWrapper.getFormFieldMap();
                fillFields(order, fieldsWrapper, fieldMap);
                String data = fieldsWrapper.convertToData();
                log.debug("data = " + data);
                formData.setData(data);
                writeData(queryContext, formData);
                updateSuccess = true;
            }
        }
        return updateSuccess;
    }

    private void fillFields(Orders order, FormFieldsWrapper fieldsWrapper, Map<String, FormField> fieldMap)
            throws IllegalAccessException, IntrospectionException, NoSuchFieldException, InvocationTargetException {
        for (PropertyDescriptor pd : Introspector.getBeanInfo(Orders.class).getPropertyDescriptors()){
            if(pd.getName().equals("class")) continue;
            if(Orders.class.getDeclaredField(pd.getName()).isAnnotationPresent(ApiFormField.class)) {
                if (!fieldMap.containsKey(pd.getName())) {
                    fieldsWrapper.addField(pd.getName(),
                            Orders.class.getDeclaredField(pd.getName())
                                    .getAnnotation(ApiFormField.class).typeField());
                }
                FormField formField = fieldMap.get(pd.getName());
                 Object o = pd.getReadMethod().invoke(order);
                if (pd.getPropertyType().equals(KeyObject.class)) {
                    formField.setValue(o != null ? ((KeyObject) o).getNameRu() : null);
                    formField.setKey(o != null ? ((KeyObject) o).getKey() : null);
                }else if(pd.getPropertyType().equals(Timestamp.class)){
                    Timestamp t = (Timestamp) o;
                    if (t != null) {
                        formField.setValue(sfDate.format(t));
                        formField.setKey(sfDateTime.format(t));
                        formField.setTimestamp(String.valueOf(t.getTime()));
                        formField.setValueDefault(sfDateTime.format(t));
                    }
                } else {
                    formField.setValue(o != null ? o.toString() : null);
                }

            }
        }
//        for (Field field : Orders.class.getDeclaredFields()) {
//            if (field.isAnnotationPresent(ApiFormField.class)) {
//                if (!fieldMap.containsKey(field.getName())) {
//                    fieldsWrapper.addField(field.getName(),
//                            field.getAnnotation(ApiFormField.class).typeField());
//                }
//                FormField formField = fieldMap.get(field.getName());
//                field.
//                Object o = field.get(order);
//                if (field.getType().equals(KeyObject.class)) {
//                    formField.setValue(o != null ? ((KeyObject) o).getNameRu() : null);
//                    formField.setKey(o != null ? ((KeyObject) o).getKey() : null);
//                } else {
//                    formField.setValue(o != null ? o.toString() : null);
//                }
//            }
//        }
    }




}
