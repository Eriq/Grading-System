CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
	user_name varchar(50) NOT NULL,
	password varchar(100) NOT NULL,
	user_type integer NOT NULL,
	user_status integer DEFAULT 1 -- "1" for active users and "0" for deleted users
);

CREATE TABLE teacher_subjects (
	id SERIAL PRIMARY KEY,
	user_id integer NOT NULL,
	subject_name varchar(20) NOT NULL,
	form integer NOT NULL,
	stream varchar(1) NOT NULL,
	year integer NOT NULL,
	FOREIGN KEY (user_id) REFERENCES users(user_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE class_teachers (
	id SERIAL PRIMARY KEY,
	user_id integer NOT NULL,
	form integer NOT NULL,
	stream varchar(1) NOT NULL,
	year integer NOT NULL,
	FOREIGN KEY (user_id) REFERENCES users(user_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE students (
	reg_no SERIAL PRIMARY KEY,
	name varchar(100) NOT NULL,
	dob DATE NOT NULL,
	form integer NOT NULL,
	stream varchar(1) NOT NULL,
	year integer NOT NULL,
	status integer DEFAULT 1
);

CREATE TABLE exams (
	exam_id SERIAL PRIMARY KEY,
	exam_type integer NOT NULL, --opener,cat1,midterm,cat2
	term integer NOT NULL,
	form integer NOT NULL,
	year integer NOT NULL,
	reg_no integer NOT NULL,
	maths varchar(3),
	english varchar(3), 
	kiswahili varchar(3),
	chemistry varchar(3),
	physics varchar(3),
	biology varchar(3),
	history varchar(3),
	geography varchar(3),
	cre varchar(3),
	computer varchar(3),
	business varchar(3),
	agriculture varchar(3),
	french varchar(3),
	german varchar(3),
	FOREIGN KEY (reg_no) REFERENCES students(reg_no) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO users (user_name, password, user_type) VALUES
('admin', '123', 0);