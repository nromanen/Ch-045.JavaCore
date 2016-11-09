SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP DATABASE IF EXISTS students;
CREATE DATABASE students DEFAULT CHARACTER SET 'utf8';

USE students;
/*mentors table*/
DROP TABLE IF EXISTS students.mentor ;
CREATE TABLE mentor (
  id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50)  NOT NULL,
  last_name VARCHAR(200)  NOT NULL,
  PRIMARY KEY(id)
)  engine=InnoDB ;
/*academic groups table*/
DROP TABLE IF EXISTS students.academic_group ;
CREATE TABLE academic_group (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(255)  NOT NULL,
  mentor_id INT  NOT NULL,
  PRIMARY KEY (id),

  FOREIGN KEY (mentor_id)
  REFERENCES mentor(id) ON UPDATE CASCADE ON DELETE RESTRICT

)  engine=InnoDB ;
/*students table*/
DROP TABLE IF EXISTS students.student ;
CREATE TABLE student (
  id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50)  NOT NULL,
  last_name VARCHAR(200)  NOT NULL,
  birth_day DATE  NOT NULL,
  book_number INT NOT NULL DEFAULT 0,
  group_id INT NOT NULL,

  PRIMARY KEY(id),
  INDEX (first_name, last_name),
  INDEX (birth_day),

  FOREIGN KEY (group_id)
  REFERENCES academic_group(id) ON UPDATE CASCADE ON DELETE RESTRICT

)  engine=InnoDB ;
/*users table*/
DROP TABLE IF EXISTS students.user_account ;
CREATE TABLE user_account (
  id INT NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(30) not null,
  password  VARCHAR(30) not null,
  PRIMARY KEY (id),
  UNIQUE KEY unique_user_name (user_name)
) engine=InnoDB;

/*populate data*/

/*insert admin account*/
INSERT INTO students.user_account ( user_name, password) VALUES ( 'admin', '1234');
/*insert test mentors*/
INSERT INTO students.mentor ( first_name, last_name) VALUES ( 'Ivan', 'Ivanov');
INSERT INTO students.mentor ( first_name, last_name) VALUES ('Stepan', 'Petrov');
INSERT INTO students.mentor ( first_name, last_name) VALUES ( 'Ivan', 'Pritula');
INSERT INTO students.mentor ( first_name, last_name) VALUES ( 'Svetlana', 'Piddubna');
INSERT INTO students.mentor ( first_name, last_name) VALUES ('Roman', 'Petrov');
/*insert test academic group*/
INSERT INTO students.academic_group ( title, mentor_id) VALUES ( 'group1 group1', 1);
INSERT INTO students.academic_group ( title, mentor_id) VALUES ( 'group2 group2', 2);
INSERT INTO students.academic_group ( title, mentor_id) VALUES ( 'group3 group3', 3);
INSERT INTO students.academic_group ( title, mentor_id) VALUES ( 'group4 group4', 4);
INSERT INTO students.academic_group ( title, mentor_id) VALUES ( 'group5 group5', 5);
/*insert test students*/
INSERT INTO students.student ( first_name, last_name, birth_day, book_number, group_id) VALUES ( 'Igor', 'Gavrilyuk', '2010-10-24', 1000, 1);
INSERT INTO students.student ( first_name, last_name, birth_day, book_number, group_id) VALUES ( 'Ivan', 'Tarnavski', '2010-10-17', 1001, 2);
INSERT INTO students.student ( first_name, last_name, birth_day, book_number, group_id) VALUES ( 'Stepan', 'Pritula', '2010-10-05', 1002, 3);
INSERT INTO students.student ( first_name, last_name, birth_day, book_number, group_id) VALUES ( 'Mukola', 'Mukolaychuk', '2011-10-04', 1002, 4);
INSERT INTO students.student ( first_name, last_name, birth_day, book_number, group_id) VALUES ( 'Roman', 'Mukolaychuk', '2011-10-04', 1004, 5);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;