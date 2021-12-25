CREATE TABLE category (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO category (name) values ('leisure');
INSERT INTO category (name) values ('food');
INSERT INTO category (name) values ('supermarket');
INSERT INTO category (name) values ('drugstore');
INSERT INTO category (name) values ('others');