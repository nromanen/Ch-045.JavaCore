DROP DATABASE IF EXISTS students;

CREATE DATABASE students DEFAULT CHARACTER SET 'utf8';

USE students;

CREATE TABLE mentor (
  id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50)  NOT NULL,
  last_name VARCHAR(200)  NOT NULL,
  group_id INT  NOT NULL,
  PRIMARY KEY(id)
)  engine=InnoDB ;

CREATE TABLE academic_group (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(255)  NOT NULL,
  mentor_id INT  NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (mentor_id)
  REFERENCES mentor(id)
)  engine=InnoDB ;

CREATE TABLE student(
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
  REFERENCES academic_group(id)
    ON UPDATE CASCADE ON DELETE RESTRICT
)  engine=InnoDB ;


