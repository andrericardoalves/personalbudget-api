ALTER TABLE person DROP COLUMN city;
ALTER TABLE person DROP COLUMN state;
ALTER TABLE person ADD COLUMN city_id int(20);
ALTER TABLE person ADD CONSTRAINT fk_person_city FOREIGN KEY(city_id) REFERENCES city(id);
UPDATE person SET city_id = 2;