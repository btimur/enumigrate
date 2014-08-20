package kz.arta.ext.migrate.service;


import org.slf4j.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by timur on 10/07/2014 11:41.
 */
public abstract class AMigrateService implements IMigrateService {

    @Inject
    protected Logger log;

}
