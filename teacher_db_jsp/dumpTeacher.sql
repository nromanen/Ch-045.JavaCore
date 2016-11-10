-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: study
-- ------------------------------------------------------
-- Server version	5.7.16-log

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'primary'),(2,'middle'),(3,'high');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `position` enum('PHYSICS','MATH','GEOGRAPHY','CHEMISTRY','UKRAINIAN','ENGLISH','HISTORY','BIOLOGY') DEFAULT 'UKRAINIAN',
  `date_birthday` date NOT NULL DEFAULT '1970-01-01',
  `department` int(2) NOT NULL DEFAULT '1',
  `qualifying_cat` enum('SPECIALIST_H_CAT','SPECIALIST_1_CAT','SPECIALIST_2_CAT','SPECIALIST') NOT NULL DEFAULT 'SPECIALIST',
  `load` int(2) NOT NULL DEFAULT '18',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'Rtoytuty','Rotortyutyuty','PHYSICS','1985-02-17',1,'SPECIALIST_H_CAT',18),(2,'Tosaw','User','MATH','1990-03-18',2,'SPECIALIST_1_CAT',9),(3,'Fedir','Popovuchf','GEOGRAPHY','1988-11-15',3,'SPECIALIST_2_CAT',27),(4,'Goga','Bobotic','UKRAINIAN','1995-04-08',3,'SPECIALIST_1_CAT',18),(5,'Stepan','Hort','CHEMISTRY','1988-01-12',1,'SPECIALIST',18),(6,'Robert','Tomson6','MATH','1983-02-03',2,'SPECIALIST',18),(15,'asdas','asdasasd','UKRAINIAN','1970-01-01',1,'SPECIALIST',18),(17,'aa','asdadr','UKRAINIAN','1970-01-01',1,'SPECIALIST',18),(18,'test','asd','UKRAINIAN','1970-01-01',1,'SPECIALIST',18),(19,'test','asd','UKRAINIAN','1970-01-01',1,'SPECIALIST',18);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;


-- Dump completed on 2016-11-10 17:10:11
