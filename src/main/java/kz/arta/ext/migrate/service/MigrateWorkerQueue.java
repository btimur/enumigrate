package kz.arta.ext.migrate.service;

import kz.arta.ext.migrate.util.CodeConstants;
import org.slf4j.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by timur on 12/07/2014 20:34.
 */
@MessageDriven(name = "MigrateWorkerQueue",
        activationConfig =
                {
                        @ActivationConfigProperty(propertyName = "destinationType",
                                propertyValue = "javax.jms.Queue"),
                        @ActivationConfigProperty(propertyName = "destination",
                                propertyValue = CodeConstants.JMS_DESTINATION)
                })
public class MigrateWorkerQueue implements MessageListener {
    @Inject
    protected Logger log;
    @Inject
    private OrdersMigrateService service;


    @Override
    public void onMessage(Message msg) {

        TextMessage message = (TextMessage) msg;
        try {
            log.info("get message " + message.getText());
            service.startProcess(Integer.valueOf(message.getText()));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
