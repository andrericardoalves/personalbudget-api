CREATE TABLE person (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	address VARCHAR(30),
	address_number VARCHAR(30),
	complement VARCHAR(30),
	district VARCHAR(30),
	zip_code VARCHAR(30),
	city VARCHAR(30),
	state VARCHAR(30),
	active BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO person (name, address, address_number, complement, district, zip_code, city, state, active) values ('John Write', 'Rua do Abacaxi', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', true);
INSERT INTO person (name, address, address_number, complement, district, zip_code, city, state, active) values ('Mary Rose', 'Rua do Sabiá', '110', 'Apto 101', 'Colina', '11.400-12', 'Ribeirão Preto', 'SP', true);
INSERT INTO person (name, address, address_number, complement, district, zip_code, city, state, active) values ('Piter Sant', 'Rua da Bateria', '23', null, 'Morumbi', '54.212-12', 'Goiânia', 'GO', true);
INSERT INTO person (name, address, address_number, complement, district, zip_code, city, state, active) values ('Ricard Bold', 'Rua do Motorista', '123', 'Apto 302', 'Aparecida', '38.400-12', 'Salvador', 'BA', true);
INSERT INTO person (name, address, address_number, complement, district, zip_code, city, state, active) values ('Joseph Sea', 'Av Rio Branco', '321', null, 'Jardins', '56.400-12', 'Natal', 'RN', true);
INSERT INTO person (name, address, address_number, complement, district, zip_code, city, state, active) values ('John Mayer', 'Av Brasil', '100', null, 'Tubalina', '77.400-12', 'Porto Alegre', 'RS', true);
INSERT INTO person (name, address, address_number, complement, district, zip_code, city, state, active) values ('Usan Bold', 'Rua do Sapo', '1120', 'Apto 201', 'Centro', '12.400-12', 'Rio de Janeiro', 'RJ', true);
INSERT INTO person (name, address, address_number, complement, district, zip_code, city, state, active) values ('Leonardo de Caprio', 'Rua da Manga', '433', null, 'Centro', '31.400-12', 'Belo Horizonte', 'MG', true);
INSERT INTO person (name, address, address_number, complement, district, zip_code, city, state, active) values ('Angelina Jolie', 'Rua do Músico', '566', null, 'Segismundo Pereira', '38.400-00', 'Uberlândia', 'MG', true);
INSERT INTO person (name, address, address_number, complement, district, zip_code, city, state, active) values ('Max Will', 'Rua da Terra', '1233', 'Apto 10', 'Vigilato', '99.400-12', 'Manaus', 'AM', true);

