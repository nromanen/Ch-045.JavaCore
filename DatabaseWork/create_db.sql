create database students;
use students;

CREATE TABLE mentor (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50), 
    last_name VARCHAR(200),
    PRIMARY KEY(id)
)   ;

CREATE TABLE academic_group (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255),
	  mentor_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (mentor_id)
      REFERENCES mentor(id)
)   ;

CREATE TABLE student(
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50), 
    last_name VARCHAR(200),
    birth_day DATE,
	  book_number INT NOT NULL DEFAULT 0,
    group_id INT NOT NULL,
   
    PRIMARY KEY(id),
    INDEX (first_name, last_name),
    INDEX (birth_day),

    FOREIGN KEY (group_id)
      REFERENCES academic_group(id)
      ON UPDATE CASCADE ON DELETE RESTRICT
)   ;
