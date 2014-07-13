package kz.arta.ext.migrate.service;

/**
 * Created by timur on 10/07/2014 11:41.
 */
public interface IMigrateService {

    public void startProcess(Integer startStatus) throws InterruptedException;
}
