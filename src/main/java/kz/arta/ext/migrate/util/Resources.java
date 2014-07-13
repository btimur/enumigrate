package kz.arta.ext.migrate.util;


import org.apache.log4j.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by timur on 09/07/2014 14:23.
 */
public class Resources {
    @SuppressWarnings("unused")
    @Produces
    @PersistenceContext
    private EntityManager em;

    @Produces
    public Logger produceLog(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

}
