enu migrate
=============
![logo](src/main/webapp/img/arta.png)

##Настройка

* Апдейт БД. 
 * Провести скрипт [init.sql](init.sql) на БД books
 * Провести скрипт students.sql на БД books
* 
* Настройки JBOSS
 * Добавить датасорс к БД books 
    * Name - **BookDS**
    * JNDI - **java:jboss/datasources/BookDS**
 * Добавить JMS Queue
    * Name - **MigrateWorkerQueue**
    * JNDI - **java:jboss/queues/Synergy/MigrateWorkerQueue**
* Настроить конфиг [конфиг](esot.properties)
 * Выставить правильные настройки по подключению к серверу _synergy.address_, _user.login_, _user.password_
 * Выставить правильные идентифкаторы **Реестра заказов** _order.registry.uuid_, _order.form.uuid_
 * Скопировать файл настроек в jboss в конфигурации _(по умолчанию standalone/configuration)_
* Задеплоить war в JBOSS

 
##Запуск
Запустить приложение в бразере [migrate](http://localhost:8080/migrate/)
