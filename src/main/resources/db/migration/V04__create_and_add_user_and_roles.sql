CREATE TABLE user (
	id BIGINT(20) PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE role (
	id BIGINT(20) PRIMARY KEY,
	description VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_role (
	user_id BIGINT(20) NOT NULL,
	role_id BIGINT(20) NOT NULL,
	PRIMARY KEY (user_id, role_id),
	FOREIGN KEY (user_id) REFERENCES user(id),
	FOREIGN KEY (role_id) REFERENCES role(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user (id, name, email, password) values (1, 'Administrador', 'admin@alves.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
INSERT INTO user (id, name, email, password) values (2, 'Mary White', 'mary@alves.com', '$2a$10$Zc3w6HyuPOPXamaMhh.PQOXvDnEsadztbfi6/RyZWJDzimE8WQjaq');

INSERT INTO role (id, description) values (1, 'ROLE_ADD_CATEGORY');
INSERT INTO role (id, description) values (2, 'ROLE_SEARCH_CATEGORY');

INSERT INTO role (id, description) values (3, 'ROLE_ADD_PERSON');
INSERT INTO role (id, description) values (4, 'ROLE_REMOVE_PERSON');
INSERT INTO role (id, description) values (5, 'ROLE_SEARCH_PESSOA');

INSERT INTO role (id, description) values (6, 'ROLE_ADD_BUDGET');
INSERT INTO role (id, description) values (7, 'ROLE_REMOVE_BUDGET');
INSERT INTO role (id, description) values (8, 'ROLE_SEARCH_BUDGET');

-- admin
INSERT INTO user_role (user_id, role_id) values (1, 1);
INSERT INTO user_role (user_id, role_id) values (1, 2);
INSERT INTO user_role (user_id, role_id) values (1, 3);
INSERT INTO user_role (user_id, role_id) values (1, 4);
INSERT INTO user_role (user_id, role_id) values (1, 5);
INSERT INTO user_role (user_id, role_id) values (1, 6);
INSERT INTO user_role (user_id, role_id) values (1, 7);
INSERT INTO user_role (user_id, role_id) values (1, 8);

-- mary
INSERT INTO user_role (user_id, role_id) values (2, 2);
INSERT INTO user_role (user_id, role_id) values (2, 5);
INSERT INTO user_role (user_id, role_id) values (2, 8);

