use world;
CREATE TABLE teacher (
    id INT(11) AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(30) NOT NULL,
    lastname VARCHAR(30) NOT NULL,
    gender INT(1) NOT NULL,
    subject_name VARCHAR(30) NOT NULL
);

CREATE TABLE pupil (
    id INT(11) AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(30) NOT NULL,
    lastname VARCHAR(30) NOT NULL,
    gender INT(1) NOT NULL,
    class INT(2) NOT NULL
);

CREATE TABLE subject_enrolment (
    subject_enrolment_id INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    teacher_id INT NOT NULL,
    pupil_id INT NOT NULL,
    FOREIGN KEY (teacher_id) REFERENCES teacher (id),
    FOREIGN KEY (pupil_id) REFERENCES pupil (id)
);

insert into teacher(firstname, lastname, gender, subject_name)
values ('Martine','Gilmore',0,'Math');
insert into teacher(firstname, lastname, gender, subject_name)
values ('Megan','West',1,'Physics');
insert into teacher(firstname, lastname, gender, subject_name)
values ('Kara','Ryder',1,'Biology');
insert into teacher(firstname, lastname, gender, subject_name)
values ('Jakob','Pitts',0,'Chemistry');

insert into pupil(firstname, lastname, gender, class)
value ('Giorgi','Giorgishvili',0,10);
insert into pupil(firstname, lastname, gender, class)
value ('Giorgi','Giorgidze',0,8);
insert into pupil(firstname, lastname, gender, class)
value ('Dimitri','Turner',0,12);
insert into pupil(firstname, lastname, gender, class)
value ('Sara','Rose',1,11);
insert into pupil(firstname, lastname, gender, class)
value ('Amy','Robinson',1,9);

insert into subject_enrolment(teacher_id, pupil_id)
value(2,1);
insert into subject_enrolment(teacher_id, pupil_id)
value(4,1);
insert into subject_enrolment(teacher_id, pupil_id)
value(1,2);
insert into subject_enrolment(teacher_id, pupil_id)
value(1,3);
insert into subject_enrolment(teacher_id, pupil_id)
value(2,3);
insert into subject_enrolment(teacher_id, pupil_id)
value(4,3);
insert into subject_enrolment(teacher_id, pupil_id)
value(3,4);
insert into subject_enrolment(teacher_id, pupil_id)
value(3,5);

SELECT teacher.* FROM teacher
INNER JOIN subject_enrolment on teacher.id=subject_enrolment.teacher_id
INNER JOIN pupil on pupil.id=subject_enrolment.pupil_id
WHERE pupil.firstname='Giorgi'



