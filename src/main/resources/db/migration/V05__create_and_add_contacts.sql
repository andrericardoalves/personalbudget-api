CREATE TABLE contact (
  id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  person_id BIGINT(20) NOT NULL,
  name VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL,
  phone VARCHAR(20) NOT NULL,
  FOREIGN KEY (person_id) REFERENCES person(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into contact (id, person_id, name, email, phone) values (1, 1, 'Alex Lifeson', 'alexlifesonn@personalbudget.com', '31 91234-9876');
insert into contact (id, person_id, name, email, phone) values (2, 1, 'Geddy Lee', 'geddylee@personalbudget.com', '31 91234-9876');
insert into contact (id, person_id, name, email, phone) values (3, 1, 'Neil Peart', 'neilpeart@personalbudget.com', '31 91234-9876');
insert into contact (id, person_id, name, email, phone) values (4, 2, 'Ozzy Osbourne', 'ozzyosbourne@personalbudget.com', '31 91234-9876');
