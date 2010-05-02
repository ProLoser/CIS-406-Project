CREATE TABLE user
(
	user_id              INTEGER NOT NULL,
	password             VARCHAR(20) NULL,
	status               INTEGER NULL,
	clearance            INTEGER NULL,
	user_name            VARCHAR(20) NULL,
	first_name           VARCHAR(25) NULL,
	last_name            VARCHAR(25) NULL,
	email                VARCHAR(35) NULL,
	PRIMARY KEY (user_id)
);



CREATE TABLE question_key
(
	question_key_id      INTEGER NOT NULL,
	question             TEXT NULL,
	PRIMARY KEY (question_key_id)
);



CREATE TABLE answer
(
	answer_id            INTEGER NOT NULL,
	question_key_id      INTEGER NOT NULL,
	user_id              INTEGER NOT NULL,
	answer               VARCHAR(20) NULL,
	PRIMARY KEY (answer_id),
	FOREIGN KEY R_58 (user_id) REFERENCES user (user_id),
	FOREIGN KEY R_59 (question_key_id) REFERENCES question_key (question_key_id)
);



CREATE TABLE user_log
(
	user_log_id          INTEGER NOT NULL,
	date                 DATE NULL,
	description          TEXT NULL,
	user_id              INTEGER NULL,
	PRIMARY KEY (user_log_id),
	FOREIGN KEY R_39 (user_id) REFERENCES user (user_id)
);



CREATE TABLE industry
(
	industry_id          INTEGER NOT NULL,
	industry_name        VARCHAR(50) NULL,
	PRIMARY KEY (industry_id)
);



CREATE TABLE company
(
	company_id           INTEGER NOT NULL,
	industry_id          INTEGER NOT NULL,
	phone                int NULL,
	name                 VARCHAR(50) NULL,
	PRIMARY KEY (company_id),
	FOREIGN KEY R_65 (industry_id) REFERENCES industry (industry_id)
);



CREATE TABLE contact_person
(
	contact_id           VARCHAR(20) NOT NULL,
	first_name           VARCHAR(25) NULL,
	last_name            VARCHAR(25) NULL,
	phone                VARCHAR(15) NULL,
	email                VARCHAR(40) NULL,
	company_id           INTEGER NULL,
	position             VARCHAR(40) NULL,
	preferred_contact    VARCHAR(20) NULL,
	initial_contact_description TEXT NULL,
	PRIMARY KEY (contact_id),
	FOREIGN KEY R_31 (company_id) REFERENCES company (company_id)
);



CREATE TABLE internship
(
	internship_id        INTEGER NOT NULL,
	company_id           INTEGER NOT NULL,
	title                VARCHAR(50) NULL,
	description          VARCHAR(255) NULL,
	post_date            DATE NULL,
	expiration           DATE NULL,
	quantity             int NULL,
	attachment           CHAR(18) NULL,
	PRIMARY KEY (internship_id),
	FOREIGN KEY R_60 (company_id) REFERENCES company (company_id)
);



CREATE TABLE correspondence
(
	correspondence_id    VARCHAR(20) NOT NULL,
	date                 DATE NULL,
	type                 VARCHAR(20) NULL,
	note                 VARCHAR(255) NULL,
	contact_id           VARCHAR(20) NULL,
	internship_id        INTEGER NULL,
	user_id              INTEGER NULL,
	PRIMARY KEY (correspondence_id),
	FOREIGN KEY R_35 (contact_id) REFERENCES contact_person (contact_id),
	FOREIGN KEY R_61 (internship_id) REFERENCES internship (internship_id),
	FOREIGN KEY R_64 (user_id) REFERENCES user (user_id)
);



CREATE TABLE task
(
	task_id              VARCHAR(20) NOT NULL,
	description          VARCHAR(255) NULL,
	start_date           DATE NULL,
	due_date             DATE NULL,
	complete_date        DATE NULL,
	contact_id           VARCHAR(20) NULL,
	correspondence_id    VARCHAR(20) NULL,
	PRIMARY KEY (task_id),
	FOREIGN KEY R_36 (contact_id) REFERENCES contact_person (contact_id),
	FOREIGN KEY R_37 (correspondence_id) REFERENCES correspondence (correspondence_id)
);



CREATE TABLE address
(
	address_id           INTEGER NOT NULL,
	company_id           INTEGER NOT NULL,
	address_type         INTEGER NULL,
	street               VARCHAR(25) NULL,
	city                 VARCHAR(15) NULL,
	zip                  int NULL,
	state                CHAR(2) NULL,
	PRIMARY KEY (address_id),
	FOREIGN KEY R_66 (company_id) REFERENCES company (company_id)
);



CREATE TABLE minor
(
	minor_id             INTEGER NOT NULL,
	minor_name           VARCHAR(35) NULL,
	PRIMARY KEY (minor_id)
);



CREATE TABLE cis_club
(
	cis_club_id          INTEGER NOT NULL,
	cis_club_name        VARCHAR(20) NULL,
	PRIMARY KEY (cis_club_id)
);



CREATE TABLE student
(
	student_id           int NOT NULL,
	cis_club_id          INTEGER NOT NULL,
	minor_id             INTEGER NOT NULL,
	last_name            VARCHAR(25) NULL,
	first_name           VARCHAR(25) NULL,
	email                VARCHAR(40) NULL,
	phone                VARCHAR(15) NULL,
	class_standing       VARCHAR(10) NULL,
	relocate             VARCHAR(3) NULL,
	graduation_year      YEAR NULL,
	last_update          DATE NULL,
	interest             TEXT NULL,
	PRIMARY KEY (student_id),
	FOREIGN KEY R_67 (minor_id) REFERENCES minor (minor_id),
	FOREIGN KEY R_68 (cis_club_id) REFERENCES cis_club (cis_club_id)
);



CREATE TABLE student_internship
(
	student_internship_id CHAR(18) NOT NULL,
	student_id           int NOT NULL,
	internship_id        INTEGER NOT NULL,
	date_secured         DATE NULL,
	course_credit        VARCHAR(100) NULL,
	PRIMARY KEY (student_internship_id),
	FOREIGN KEY R_2 (student_id) REFERENCES student (student_id),
	FOREIGN KEY R_5 (internship_id) REFERENCES internship (internship_id)
);


