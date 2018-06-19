CREATE TABLE `article` 
( `code` varchar(5) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `code_UNIQUE` (`code`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO article2 VALUES ("00001", "Chocolate", 5.2);
INSERT INTO article VALUES ("00002", "Bread", 3.1);
INSERT INTO article VALUES ("00003", "Water", 1.2);
INSERT INTO article VALUES ("00004", "Milk", 2.2);