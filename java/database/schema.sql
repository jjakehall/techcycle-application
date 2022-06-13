BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, equipment, activities;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	user_weight INT,
	user_age INT,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE equipment
(
	equipment_id SERIAL NOT NULL,
	user_id INT,
	nickname VARCHAR(50),
	bike_brand VARCHAR(50),
	bike_model VARCHAR(50),
	bike_weight INT,
	CONSTRAINT fk_users
		FOREIGN KEY (user_id)
		REFERENCES users(user_id)
		ON DELETE CASCADE
);

CREATE TABLE activities
(
	activity_id SERIAL NOT NULL,
	username VARCHAR(50),
	activity_name VARCHAR(50),
	user_id INT,
	description VARCHAR(250),
	activity_date DATE,
	distance_mi numeric,
	elevation_ft INT,
	isPublic BOOLEAN,
	elapsed_time DOUBLE PRECISION,
	power numeric,

	CONSTRAINT fk_users
		FOREIGN KEY (user_id)
		REFERENCES users(user_id)
		ON DELETE CASCADE
);

CREATE TABLE favorite_trails (
    trail_id serial NOT NULL,
    user_id INT,
    trail_name VARCHAR(50),
    trail_distance numeric,
    trail_description VARCHAR(200),
    trail_difficulty VARCHAR(20),
    trail_grade VARCHAR(20),
        CONSTRAINT FK_users
        FOREIGN KEY (user_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE,
    CONSTRAINT PK_favorite_trails PRIMARY KEY (trail_id));

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO activities (user_id, username, activity_name, activity_date, distance_mi, elevation_ft, isPublic, elapsed_time) VALUES (2, 'ride77', 'Spring Farm ride', '2022-05-18', 12.1, 1200, true, 95);
INSERT INTO activities (user_id, username, activity_name, activity_date, distance_mi, elevation_ft, isPublic, elapsed_time) VALUES (2, 'ride77', 'Lippman park evening ride', '2022-05-19', 30, 1800, true, 65);
INSERT INTO activities (user_id, username, activity_name, activity_date, distance_mi, elevation_ft, isPublic, elapsed_time) VALUES (2, 'ride77', 'Dug Road Climb', '2022-05-25', 42, 3000, true, 105);
INSERT INTO activities (user_id, username, activity_name, activity_date, distance_mi, elevation_ft, isPublic, elapsed_time) VALUES (2, 'ride77', 'Larsons Loop', '2022-04-18', 5.2, 800, true, 45);
INSERT INTO activities (user_id, username, activity_name, activity_date, distance_mi, elevation_ft, isPublic, elapsed_time) VALUES (2, 'ride77', 'Rail Trail day', '2022-05-20', 32, 1540, true, 195);
/*INSERT INTO activities (user_id, username, activity_name, activity_date, distance_mi, elevation_ft, isPublic, elapsed_time) VALUES (3, 'mcal8055', 'PCMR', '2022-06-04', 15.18, 1955, true, 99);
INSERT INTO activities (user_id, username, activity_name, activity_date, distance_mi, elevation_ft, isPublic, elapsed_time) VALUES (3, 'mcal8055', 'Ride for sanity', '2022-06-08', 14.75, 455, true, 45);
INSERT INTO activities (user_id, username, activity_name, activity_date, distance_mi, elevation_ft, isPublic, elapsed_time) VALUES (3, 'mcal8055', 'Urban gravel', '2022-06-02', 19.84, 89, true, 72);
INSERT INTO activities (user_id, username, activity_name, activity_date, distance_mi, elevation_ft, isPublic, elapsed_time) VALUES (3, 'mcal8055', 'Prime time', '2022-05-23', 12.88, 2095, true, 78);
INSERT INTO activities (user_id, username, activity_name, activity_date, distance_mi, elevation_ft, isPublic, elapsed_time) VALUES (3, 'mcal8055', 'CAAD ride', '2022-05-22', 20.19, 1414, true, 70);
INSERT INTO activities (user_id, username, activity_name, activity_date, distance_mi, elevation_ft, isPublic, elapsed_time) VALUES (3, 'mcal8055', 'Afternoon ride', '2022-05-20', 20.23, 368, true, 61);*/


INSERT INTO equipment (user_id, bike_model, bike_weight) VALUES (2, 'SuperSix Evo', 13);

COMMIT TRANSACTION;
