CREATE TABLE `companydb`.`department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `disposition` varchar(45),
  `description` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `title_UNIQUE` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;


CREATE TABLE `companydb`.`position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`,`name`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


CREATE TABLE `companydb`.`employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `position` int(11) DEFAULT '1',
  `department` int(11) DEFAULT '1',
  `ssn` int(11) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `bDay` date DEFAULT NULL,
  `characteristic` text,
  `rate` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `id_idx` (`position`),
  KEY `id_idx1` (`department`),
  CONSTRAINT `department` FOREIGN KEY (`department`) REFERENCES `department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `position` FOREIGN KEY (`position`) REFERENCES `position` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `companydb`.`department`
(`id`,
`title`,
`disposition`,
`description`)
VALUES
('1',
'No department',
'no disposition',
'no description');

INSERT INTO `companydb`.`department`
(`id`,
`title`,
`disposition`,
`description`)
VALUES
('2',
'Devepopment Department',
'Chernivtsi, Holovna str. 246, 6 stage, 605',
'Create the programs.  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum cumque dolores facilis odio, optio quaerat repellendus rerum tenetur totam voluptatibus? Excepturi laboriosam praesentium quod? Beatae esse ipsam saepe sint! Facere?');

INSERT INTO `companydb`.`department`
(`id`,
`title`,
`disposition`,
`description`)
VALUES
('3',
'Testing Department',
'Chernivtsi, Holovna str. 246, 13 stage',
'Testing the programs.  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum cumque dolores facilis odio, optio quaerat repellendus rerum tenetur totam voluptatibus? Excepturi laboriosam praesentium quod? Beatae esse ipsam saepe sint! Facere?');

INSERT INTO `companydb`.`department`
(`id`,
`title`,
`disposition`,
`description`)
VALUES
('4',
'Marketing Department',
'Chernivtsi, Holovna, 88/123',
'Sold the programs.  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum cumque dolores facilis odio, optio quaerat repellendus rerum tenetur totam voluptatibus? Excepturi laboriosam praesentium quod? Beatae esse ipsam saepe sint! Facere?');

INSERT INTO `companydb`.`position`
(`id`,
`name`)
VALUES
('1',
'TRAINEE');

INSERT INTO `companydb`.`position`
(`id`,
`name`)
VALUES
('2',
'BEGINNER');

INSERT INTO `companydb`.`position`
(`id`,
`name`)
VALUES
('3',
'MIDDLE_DEVELOPER');

INSERT INTO `companydb`.`position`
(`id`,
`name`)
VALUES
('4',
'SENIOR_DEVELOPER');

INSERT INTO `companydb`.`position`
(`id`,
`name`)
VALUES
('5',
'ARCHITECT_DEVELOPER');

INSERT INTO `companydb`.`position`
(`id`,
`name`)
VALUES
('6',
'TEAM_LEADER');

INSERT INTO `companydb`.`employee`
(`firstName`,
`lastName`,
`position`,
`department`,
`ssn`,
`email`,
`bDay`,
`characteristic`,
`rate`)
VALUES
('Ivan',
'Palagniuk',
'1',
'1',
'545666',
'ivan@mail.com',
'19880819',
'A good employee',
'400');

INSERT INTO `companydb`.`employee`
(`firstName`,
`lastName`,
`position`,
`department`,
`ssn`,
`email`,
`bDay`,
`characteristic`,
`rate`)
VALUES
('Igor',
'Dudiv',
'3',
'3',
'575666',
'igor@mail.com',
'19900104',
'A very good employee',
'800');

INSERT INTO `companydb`.`employee`
(`firstName`,
`lastName`,
`position`,
`department`,
`ssn`,
`email`,
`bDay`,
`characteristic`,
`rate`)
VALUES
('Roma',
'Mocherniuk',
'2',
'2',
'555666',
'roma@mail.com',
'19850513',
'Try no study english and Java',
'300');


