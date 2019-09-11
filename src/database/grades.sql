CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
	user_name varchar(50) NOT NULL,
	password varchar(100) NOT NULL,
	user_type integer NOT NULL,
	user_status integer DEFAULT 1 -- '1' for active users and '0' for deleted users
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
	sex varchar(1) DEFAULT 'M',
	form integer NOT NULL,
	stream varchar(1) NOT NULL,
	year integer NOT NULL,
	status integer DEFAULT 1
);

CREATE TABLE exams (
	exam_id SERIAL PRIMARY KEY,
	exam_type integer NOT NULL, --opener,cat1,midterm,cat2,endterm
	term integer NOT NULL,
	form integer NOT NULL,
	year integer NOT NULL,
	reg_no integer NOT NULL,
	maths integer,
	english integer, 
	kiswahili integer,
	chemistry integer,
	physics integer,
	biology integer,
	history integer,
	geography integer,
	cre integer,
	computer integer,
	business integer,
	agriculture integer,
	french integer,
	german integer,
	FOREIGN KEY (reg_no) REFERENCES students(reg_no) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO users (user_name, password, user_type) VALUES
('Admin', '123', 0),
('Lara Moses', '123', 1),
('Kaia Salazar', '123', 2),
('Natalya Carpenter', '123', 3);

 
INSERT INTO students (name, dob, sex, form, stream, year) VALUES
('Kailee Ellison', '2004-03-25', 'F', 1, 'A', 2019),
('Clark Becker', '2004-11-13', 'M', 1, 'A', 2019),
('Lydia Baxter', '2004-05-08', 'F', 1, 'B', 2019),
('Ryker Sherman', '2004-10-12', 'M', 1, 'C', 2019),
('Alison Mendez', '2004-08-26', 'F', 1, 'C', 2019),
('Melvin Ford', '2001-07-22', 'M', 4, 'A', 2019),
('Michaela Blackwell', '2001-09-14', 'F', 4, 'A', 2019),
('Michael Gonzales', '2001-12-24', 'M', 4, 'B', 2019),
('Jazlyn Nash', '2001-08-16', 'F', 4, 'C', 2019),
('Jonah Ford', '2001-01-23', 'M', 4, 'C', 2019);

INSERT INTO exams (exam_type, term, form, year, reg_no, maths, english, kiswahili, chemistry, physics, biology, history, geography, cre, computer, business, agriculture) VALUES
(1, 1, 1, 2019, 1, 80, 78, 79, 56, 67, 54, 40, 90, 34, 68, 90, 57),
(2, 1, 1, 2019, 1, 86, 61, 76, 91, 63, 88, 60, 56, 76, 53, 57, 87),
(3, 1, 1, 2019, 1, 53, 92, 50, 91, 69, 96, 83, 73, 98, 78, 75, 82),
(1, 1, 1, 2019, 2, 79, 93, 55, 82, 68, 94, 96, 71, 91, 84, 51, 83),
(2, 1, 1, 2019, 2, 68, 72, 69, 90, 74, 65, 72, 53, 74, 93, 98, 72),
(3, 1, 1, 2019, 2, 92, 94, 89, 59, 96, 73, 86, 60, 54, 76, 89, 80);

INSERT INTO exams (exam_type, term, form, year, reg_no, maths, english, kiswahili, chemistry, physics, biology, history, geography, cre, business, agriculture, german) VALUES
(1, 1, 1, 2019, 3, 59, 99, 86, 59, 56, 99, 78, 76, 92, 60, 54, 76),
(2, 1, 1, 2019, 3, 71, 64, 92, 78, 68, 52, 70, 97, 68, 83, 97, 57),
(3, 1, 1, 2019, 3, 58, 87, 96, 59, 63, 58, 58, 86, 94, 98, 81, 56);

INSERT INTO exams (exam_type, term, form, year, reg_no, maths, english, kiswahili, chemistry, physics, biology, history, geography, cre, business, agriculture, french) VALUES
(1, 1, 1, 2019, 4, 82, 54, 72, 61, 70, 97, 54, 90, 94, 66, 88, 95),
(2, 1, 1, 2019, 4, 55, 82, 84, 69, 53, 87, 89, 55, 65, 67, 78, 85),
(3, 1, 1, 2019, 4, 65, 84, 60, 79, 76, 94, 78, 78, 61, 99, 57, 80),
(1, 1, 1, 2019, 5, 71, 68, 77, 60, 97, 99, 90, 96, 65, 61, 55, 75),
(2, 1, 1, 2019, 5, 54, 74, 79, 75, 77, 71, 70, 55, 72, 60, 54, 80),
(3, 1, 1, 2019, 5, 88, 59, 82, 52, 51, 67, 92, 63, 53, 76, 79, 59);

INSERT INTO exams (exam_type, term, form, year, reg_no, maths, english, kiswahili, chemistry, physics, biology, history, cre) VALUES
(1, 1, 4, 2019, 6, 61, 69, 83, 65, 62, 68, 89, 88),
(2, 1, 4, 2019, 6, 83, 50, 60, 85, 51, 58, 92, 76),
(3, 1, 4, 2019, 6, 81, 98, 92, 92, 59, 66, 55, 98);

INSERT INTO exams (exam_type, term, form, year, reg_no, maths, english, kiswahili, chemistry, physics, biology, geography, agriculture) VALUES
(1, 1, 4, 2019, 7, 89, 50, 62, 79, 91, 59, 54, 94),
(2, 1, 4, 2019, 7, 54, 87, 99, 74, 74, 61, 93, 65),
(3, 1, 4, 2019, 7, 69, 52, 87, 93, 94, 92, 83, 89);

INSERT INTO exams (exam_type, term, form, year, reg_no, maths, english, kiswahili, chemistry, physics, history, cre, business) VALUES
(1, 1, 4, 2019, 8, 90, 68, 74, 84, 58, 62, 69, 61),
(2, 1, 4, 2019, 8, 72, 82, 83, 99, 65, 68, 66, 61),
(3, 1, 4, 2019, 8, 95, 52, 84, 59, 99, 54, 98, 77);

INSERT INTO exams (exam_type, term, form, year, reg_no, maths, english, kiswahili, chemistry, biology, history, geography, agriculture) VALUES
(1, 1, 4, 2019, 9, 70, 63, 58, 97, 52, 55, 76, 61),
(2, 1, 4, 2019, 9, 50, 58, 94, 95, 73, 57, 68, 81),
(3, 1, 4, 2019, 9, 89, 75, 60, 87, 88, 81, 51, 50);

INSERT INTO exams (exam_type, term, form, year, reg_no, maths, english, kiswahili, chemistry, biology, history, cre, business) VALUES
(1, 1, 4, 2019, 10, 72, 89, 99, 84, 84, 64, 62, 77),
(2, 1, 4, 2019, 10, 68, 52, 65, 80, 59, 71, 92, 56),
(3, 1, 4, 2019, 10, 85,	75,	80,	97,	78,	70,	69,	58);