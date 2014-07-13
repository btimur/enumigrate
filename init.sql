SET NAMES utf8;

CREATE TABLE migrate_status  ( 
	code	varchar(25) NOT NULL,
	val 	int(11) NULL,
	PRIMARY KEY(code)
)
;
ALTER TABLE migrate_status
	COMMENT = 'статусы миграции в Synergy';

ALTER TABLE migrate_status MODIFY COLUMN code varchar(25) NOT NULL COMMENT 'код' ;
ALTER TABLE migrate_status MODIFY COLUMN val int(11) NULL COMMENT 'значения' ;

INSERT INTO migrate_status(code, val)
	VALUES('status', 0);
INSERT INTO migrate_status(code, val) 
	VALUES('orders', 0);

ALTER TABLE orderdocs
	ADD COLUMN migrateUUID varchar(100) NULL COMMENT 'UUID смигрированной записи',
	ADD COLUMN errorInfo varchar(4000) NULL COMMENT 'ошибка миграции';
