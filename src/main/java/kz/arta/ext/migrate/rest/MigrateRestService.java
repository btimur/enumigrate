package kz.arta.ext.migrate.rest;

import kz.arta.ext.migrate.model.MigrateStatusEntity;
import kz.arta.ext.migrate.service.OrdersMigrateRepository;
import kz.arta.ext.migrate.util.CodeConstants;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by timur on 09/07/2014 15:05.
 */
@Path("/jurnal")
public class MigrateRestService {
    @Inject
    private Logger log;

    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = CodeConstants.JMS_DESTINATION)
    private Destination destination;

    @Inject
    private OrdersMigrateRepository repository;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/process/{flag}")
    public String startMigrate(@PathParam("flag") Integer flag) {

        try {
            //создаем подключение
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage();
//            //добавим в JMS сообщение собственное свойство в поле сообщения со свойствами
//            message.setStringProperty("clientType", "web clien");
            //добавляем payload в сообщение
            message.setText(flag.toString());
            //отправляем сообщение
            producer.send(message);
            log.info("message sent");
            //закрываем соединения
            session.close();
            connection.close();

        } catch (JMSException ex) {
            log.error(ex);
            return "error " + ex.getMessage();
        }
        return "start";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/status")
    public MigrateStatusWrapper getStatus()
    {
        return repository.getMigrateStatusWrapper();
    }
}
