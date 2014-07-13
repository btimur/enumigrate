enu migrate
=============
![logo](src/main/webapp/img/arta.png)

##Настройка

* Апдейт БД. Провести скрипт [init.sql](init.sql) на БД books
* Настройки JBOSS
 * Добавить датасорс к БД books 
    * Name - **BookDS**
    * JNDI - **java:jboss/datasources/BookDS**
 * Добавить JMS Queue
    * Name - **MigrateWorkerQueue**
    * JNDI - **java:jboss/queues/Synergy/MigrateWorkerQueue**
* Задеплоить war в JBOSS
 
##Запуск
Запустить приложение в бразере [migrate](http://localhost:8080/migrate/)
