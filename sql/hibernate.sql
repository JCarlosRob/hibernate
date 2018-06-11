DROP DATABASE IF EXISTS `hibernate`;
CREATE DATABASE `hibernate`;
USE `hibernate`;

DROP TABLE IF EXISTS `students`;
CREATE TABLE `students`(

	`id` int(9) not null,
    `name` varchar(50) not null,
    
    PRIMARY KEY (id)

);

DROP TABLE IF EXISTS `instructors`;
CREATE TABLE `instructors`(

	`id` int(9) not null,
    `name` varchar(50) not null,
    
    PRIMARY KEY (id)

);

DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses` (

	`id` int(9) not null,
    `title` varchar(50) not null,
    `id_instructor` int(9),
    
    PRIMARY KEY (id),
    FOREIGN KEY (id_instructor) REFERENCES instructors (id)

);

DROP TABLE IF EXISTS `courses_students`;
CREATE TABLE `courses_students`(

	`id_course` int(9) not null,
    `id_student` int(9) not null,
    
    PRIMARY KEY (id_course, id_student),
    
	FOREIGN KEY (id_course) REFERENCES courses (id),
    FOREIGN KEY (id_student) REFERENCES students (id)

);

INSERT INTO `students` VALUES
(1, 'Juan'),
(2, 'Pedro');

INSERT INTO `instructors` VALUES
(1,'Ana'),
(2, 'Eva');

INSERT INTO `courses` VALUES
(1, 'Curso de guitarra', 1),
(2, 'Curso de Inglés', 2);

INSERT INTO `courses_students` VALUES
(1,1),
(2,2);