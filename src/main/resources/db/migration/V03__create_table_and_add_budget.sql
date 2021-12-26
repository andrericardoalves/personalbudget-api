CREATE TABLE budget (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	description VARCHAR(50) NOT NULL,
	due_date DATE NOT NULL,
	payment_date DATE,
	price DECIMAL(10,2) NOT NULL,
	observation VARCHAR(100),
	kind VARCHAR(20) NOT NULL,
	category_id BIGINT(20) NOT NULL,
	person_id BIGINT(20) NOT NULL,
	FOREIGN KEY (category_id) REFERENCES category(id),
	FOREIGN KEY (person_id) REFERENCES person(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO budget (description, due_date, payment_date, price, observation, kind, category_id, person_id) values ('Salary Moth', '2021-06-10', null, 6500.00, 'Profit Sharing', 'INCOME', 1, 1);
INSERT INTO budget (description, due_date, payment_date, price, observation, kind, category_id, person_id) values ('Bahamas', '2021-02-10', '2021-02-10', 100.32, null, 'EXPENSE', 2, 2);
INSERT INTO budget (description, due_date, payment_date, price, observation, kind, category_id, person_id) values ('Top Club', '2021-06-10', null, 120, null, 'INCOME', 3, 3);
INSERT INTO budget (description, due_date, payment_date, price, observation, kind, category_id, person_id) values ('Electrical Power', '2021-02-10', '2021-02-10', 110.44, 'Geração', 'INCOME', 3, 4);
INSERT INTO budget (description, due_date, payment_date, price, observation, kind, category_id, person_id) values ('Water', '2021-06-10', null, 200.30, null, 'EXPENSE', 3, 5);
INSERT INTO budget (description, due_date, payment_date, price, observation, kind, category_id, person_id) values ('Extra', '2021-03-10', '2021-03-10', 1010.32, null, 'INCOME', 4, 6);
INSERT INTO budget (description, due_date, payment_date, price, observation, kind, category_id, person_id) values ('Bahamas', '2021-06-10', null, 500, null, 'INCOME', 1, 7);
INSERT INTO budget (description, due_date, payment_date, price, observation, kind, category_id, person_id) values ('Top Club', '2021-03-10', '2021-03-10', 400.32, null, 'EXPENSE', 4, 8);
INSERT INTO budget (description, due_date, payment_date, price, observation, kind, category_id, person_id) values ('Forwarding Agent', '2021-06-10', null, 123.64, 'Multas', 'EXPENSE', 3, 9);
INSERT INTO budget (description, due_date, payment_date, price, observation, kind, category_id, person_id) values ('Tires', '2021-04-10', '2021-04-10', 665.33, null, 'INCOME', 5, 10);
INSERT INTO budget (description, due_date, payment_date, price, observation, kind, category_id, person_id) values ('Coofe', '2021-06-10', null, 8.32, null, 'EXPENSE', 1, 5);
INSERT INTO budget (description, due_date, payment_date, price, observation, kind, category_id, person_id) values ('Electronics', '2021-04-10', '2021-04-10', 2100.32, null, 'EXPENSE', 5, 4);
INSERT INTO budget (description, due_date, payment_date, price, observation, kind, category_id, person_id) values ('Guitar', '2021-06-10', null, 1040.32, null, 'EXPENSE', 4, 3);
INSERT INTO budget (description, due_date, payment_date, price, observation, kind, category_id, person_id) values ('Coofe', '2021-04-10', '2021-04-10', 4.32, null, 'EXPENSE', 4, 2);
INSERT INTO budget (description, due_date, payment_date, price, observation, kind, category_id, person_id) values ('Breakfast', '2021-06-10', null, 10.20, null, 'EXPENSE', 4, 1);