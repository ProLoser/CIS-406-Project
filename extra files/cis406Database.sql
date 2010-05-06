
CREATE TABLE users
(
	users_id              INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	password             VARCHAR(20) ,
	status               INTEGER ,
	clearance            INTEGER ,
	user_name            SMALLINT ,
	first_name           VARCHAR(25) ,
	last_name            VARCHAR(25) ,
	email                VARCHAR(50) ,
	PRIMARY KEY (users_id)
);



CREATE TABLE question_key
(
	question_key_id      INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	question             VARCHAR(255) ,
	PRIMARY KEY (question_key_id)
);



CREATE TABLE answer
(
	answer_id            INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	question_key_id      INTEGER NOT NULL,
	users_id              INTEGER NOT NULL,
	answer               VARCHAR(20),
	PRIMARY KEY (answer_id)
);



CREATE TABLE user_log
(
	user_log_id          INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	date                 DATE ,
	description          VARCHAR(255) ,
	users_id              INTEGER ,
	PRIMARY KEY (user_log_id)
);



CREATE TABLE industry
(
	industry_id          INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	industry_name        VARCHAR(50) ,
	PRIMARY KEY (industry_id)
);



CREATE TABLE company
(
	company_id           INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	industry_id          INTEGER NOT NULL,
	phone                int ,
	name                 VARCHAR(50) ,
	PRIMARY KEY (company_id)
);



CREATE TABLE contact_person
(
	contact_id           INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	first_name           VARCHAR(25) ,
	last_name            VARCHAR(25) ,
	phone                VARCHAR(15) ,
	email                VARCHAR(40) ,
	company_id           INTEGER ,
	position             VARCHAR(40) ,
	preferred_contact    VARCHAR(20) ,
	initial_contact_description LONG VARCHAR ,
	street               VARCHAR(25) ,
	city                 VARCHAR(20) ,
	zip                  INTEGER ,
	state                CHAR(2) ,
	PRIMARY KEY (contact_id)
);



CREATE TABLE career_path
(
	career_path_id       INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	name                 VARCHAR(100) ,
	description          LONG VARCHAR ,
	PRIMARY KEY (career_path_id)
);



CREATE TABLE internship
(
	internship_id        INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	company_id           INTEGER NOT NULL,
	title                VARCHAR(50) ,
	description          VARCHAR(255) ,
	post_date            DATE ,
	expiration           DATE ,
	quantity             int ,
	attachment           CHAR(18) ,
	career_path_id       INTEGER ,
	PRIMARY KEY (internship_id)
);



CREATE TABLE correspondence
(
	correspondence_id    INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	date                 DATE ,
	type                 VARCHAR(20) ,
	note                 VARCHAR(255) ,
	contact_id           INTEGER ,
	internship_id        INTEGER ,
	users_id              INTEGER ,
	PRIMARY KEY (correspondence_id)
);



CREATE TABLE task
(
	task_id              INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	description          VARCHAR(255) ,
	start_date           DATE ,
	due_date             DATE ,
	complete_date        DATE ,
	contact_id           INTEGER ,
	correspondence_id    INTEGER ,
	PRIMARY KEY (task_id)
);



CREATE TABLE student
(
	student_id           INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	bronco_id            INTEGER ,
	last_name            VARCHAR(25) ,
	first_name           VARCHAR(25) ,
	email                VARCHAR(40) ,
	phone                VARCHAR(15) ,
	class_standing       VARCHAR(10) ,
	relocate             VARCHAR(3) ,
	expected_graduation_year DATE ,
	last_update          DATE ,
	interest             LONG VARCHAR ,
	missa_club           SMALLINT ,
	fast_club            SMALLINT ,
	iwdsa_club           SMALLINT ,
	swift_club           SMALLINT ,
	other_club           SMALLINT ,
	PRIMARY KEY (student_id)
);



CREATE TABLE student_internship
(
	student_internship_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	student_id           INTEGER NOT NULL,
	internship_id        INTEGER NOT NULL,
	date_secured         DATE ,
	course_credit        VARCHAR(100) ,
	PRIMARY KEY (student_internship_id)
);