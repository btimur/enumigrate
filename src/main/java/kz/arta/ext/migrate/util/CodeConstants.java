package kz.arta.ext.migrate.util;

/**
 * Created by timur on 10/07/2014 11:47.
 */
public class CodeConstants {

    public static final String ORDER_FORM_UUID = "order.form.uuid";
    public static final String ORDER_REGISTRY_UUID = "order.registry.uuid";
    public static final String FORMAT_DATE = "format.date";
    public static final String FORMAT_DATETIME = "format.datetime";


    public static final String JMS_DESTINATION = "java:jboss/queues/Synergy/MigrateWorkerQueue";
    public static final String MIGRATE_STATUS_CODE = "status";
    public static final String MIGRATE_ORDERS_CODE = "orders";
    public static final Integer MIGRATE_WORK = 1;
    public static final Integer MIGRATE_STOP = 0;
}
