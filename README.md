enu migrate
=============
![logo](src/main/webapp/img/arta.png)

##Настройка

1. Апдейт БД. Провести скрипт [init.sql](init.sql) на БД books
2. Настройки JBOSS
⋅⋅2. Добавить датасорс к БД books 
⋅⋅*Name -  **BookDS**
⋅⋅*JNDI - **java:jboss/datasources/BookDS**
⋅⋅3. Добавить JMS Queue
⋅⋅*Name - **MigrateWorkerQueue**
⋅⋅*JNDI - **java:jboss/queues/Synergy/MigrateWorkerQueue**
⋅⋅4. Задеплоить war в JBOSS
 
##Запуск
Запустить приложение в бразере [migrate](http://localhost:8080/migrate/)