-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: alavadeira
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id_address` int(11) NOT NULL AUTO_INCREMENT,
  `cep` varchar(15) NOT NULL,
  `city` varchar(45) NOT NULL,
  `complement` varchar(100) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `neighborhood` varchar(50) NOT NULL,
  `number` bigint(20) NOT NULL,
  `state` varchar(35) NOT NULL,
  `street` varchar(100) NOT NULL,
  PRIMARY KEY (`id_address`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'01311911','São Paulo','Conjunto 1211',-23.568149,-46.6492278,'Bela Vista',575,'SP','Avenida Paulista'),(2,'01311911','São Paulo','Conjunto 1711',-23.568149,-46.6492278,'Bela Vista',575,'SP','Avenida Paulista'),(3,'01202-001','São Paulo','Escola SENAI de Informática',-23.5365517,-46.6463026,'Santa Cecilia',539,'SP','Alameda Barão de Limeira');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth`
--

DROP TABLE IF EXISTS `auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth` (
  `id_auth` int(11) NOT NULL AUTO_INCREMENT,
  `expire_date` datetime NOT NULL,
  `id_driver` int(11) NOT NULL,
  `token` varchar(300) NOT NULL,
  PRIMARY KEY (`id_auth`),
  UNIQUE KEY `UK_kg0eplnee56hybxcjtwq6l56v` (`id_driver`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth`
--

LOCK TABLES `auth` WRITE;
/*!40000 ALTER TABLE `auth` DISABLE KEYS */;
INSERT INTO `auth` VALUES (1,'2017-03-03 19:16:36',1,'eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJici5jb20uYWxhdmFkZWlyYWFwaS5kb21haW4uRHJpdmVyQDVkNWQzOGZlIn0.BPQmHgLn0DsTX3ZOdJbVlu8D19WuwjAY0D011f1lWjQ');
/*!40000 ALTER TABLE `auth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id_customer` int(11) NOT NULL AUTO_INCREMENT,
  `delivery_notes` varchar(250) NOT NULL,
  `name` varchar(60) NOT NULL,
  `phone` varchar(20) NOT NULL,
  PRIMARY KEY (`id_customer`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Informações importantes','Cliente A','(00) 1234-5678'),(2,'Informações importantes','Cliente B','(00) 98765-4321'),(3,'Informações importantes','Cliente C','(00) 4321-5678');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deliverable`
--

DROP TABLE IF EXISTS `deliverable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deliverable` (
  `id_deliverable` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(50) NOT NULL,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id_deliverable`),
  UNIQUE KEY `UK_6e1aqryai8276bpfoodluxn8m` (`barcode`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deliverable`
--

LOCK TABLES `deliverable` WRITE;
/*!40000 ALTER TABLE `deliverable` DISABLE KEYS */;
INSERT INTO `deliverable` VALUES (1,'0000000001','bag'),(2,'0000000010','hanger'),(3,'0000000100','bag'),(4,'0000000101','hanger'),(5,'0000000110','bag');
/*!40000 ALTER TABLE `deliverable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `driver` (
  `id_driver` int(11) NOT NULL AUTO_INCREMENT,
  `car_plate` varchar(8) NOT NULL,
  `email` varchar(50) NOT NULL,
  `name` varchar(75) NOT NULL,
  `password` varchar(400) NOT NULL,
  PRIMARY KEY (`id_driver`),
  UNIQUE KEY `UK_fchuyotq64tagkwktlh4qttyy` (`email`),
  UNIQUE KEY `UK_rlpaanwmkvh2kltgmoyj4d85x` (`car_plate`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
INSERT INTO `driver` VALUES (1,'ABC1234','motorista@email.com','Motorista','123456789');
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver_trajectories`
--

DROP TABLE IF EXISTS `driver_trajectories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `driver_trajectories` (
  `drivers` int(11) NOT NULL,
  `trajectories` int(11) NOT NULL,
  KEY `FK_32sxlsonf4tr7g5q25ye9gmib` (`trajectories`),
  KEY `FK_p1c4e32ox71hsxvypa3091yr8` (`drivers`),
  CONSTRAINT `FK_32sxlsonf4tr7g5q25ye9gmib` FOREIGN KEY (`trajectories`) REFERENCES `trajectory` (`id_trajec`),
  CONSTRAINT `FK_p1c4e32ox71hsxvypa3091yr8` FOREIGN KEY (`drivers`) REFERENCES `driver` (`id_driver`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver_trajectories`
--

LOCK TABLES `driver_trajectories` WRITE;
/*!40000 ALTER TABLE `driver_trajectories` DISABLE KEYS */;
INSERT INTO `driver_trajectories` VALUES (1,1),(1,2);
/*!40000 ALTER TABLE `driver_trajectories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trajectory`
--

DROP TABLE IF EXISTS `trajectory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trajectory` (
  `id_trajec` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id_trajec`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trajectory`
--

LOCK TABLES `trajectory` WRITE;
/*!40000 ALTER TABLE `trajectory` DISABLE KEYS */;
INSERT INTO `trajectory` VALUES (1,'A0'),(2,'B0');
/*!40000 ALTER TABLE `trajectory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visit`
--

DROP TABLE IF EXISTS `visit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `visit` (
  `id_visit` int(11) NOT NULL AUTO_INCREMENT,
  `priority` int(11) NOT NULL,
  `schedule_for` date NOT NULL,
  `trajectory` varchar(5) NOT NULL,
  `visited_at` datetime DEFAULT NULL,
  `id_address` int(11) NOT NULL,
  `id_customer` int(11) NOT NULL,
  `id_driver` int(11) NOT NULL,
  PRIMARY KEY (`id_visit`),
  KEY `FK_gmpesa49ownmeugm1w2cumfjf` (`id_address`),
  KEY `FK_pbu7vxxl9hwjouctnowws8dj6` (`id_customer`),
  KEY `FK_9qwbhnec4c5jclkoi79hngj6m` (`id_driver`),
  CONSTRAINT `FK_9qwbhnec4c5jclkoi79hngj6m` FOREIGN KEY (`id_driver`) REFERENCES `driver` (`id_driver`),
  CONSTRAINT `FK_gmpesa49ownmeugm1w2cumfjf` FOREIGN KEY (`id_address`) REFERENCES `address` (`id_address`),
  CONSTRAINT `FK_pbu7vxxl9hwjouctnowws8dj6` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_customer`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visit`
--

LOCK TABLES `visit` WRITE;
/*!40000 ALTER TABLE `visit` DISABLE KEYS */;
INSERT INTO `visit` VALUES (1,1,'2017-03-02','A0','2017-03-02 09:45:00',1,1,1),(2,1,'2017-03-02','A2',NULL,2,2,1),(3,1,'2017-03-02','A2',NULL,3,3,1);
/*!40000 ALTER TABLE `visit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visit_deliverables`
--

DROP TABLE IF EXISTS `visit_deliverables`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `visit_deliverables` (
  `visits` int(11) NOT NULL,
  `deliverables` int(11) NOT NULL,
  KEY `FK_iwwf1olxffnwetrgu2fecxlty` (`deliverables`),
  KEY `FK_gigg2my5x4ds74elmbd4my0m3` (`visits`),
  CONSTRAINT `FK_gigg2my5x4ds74elmbd4my0m3` FOREIGN KEY (`visits`) REFERENCES `visit` (`id_visit`),
  CONSTRAINT `FK_iwwf1olxffnwetrgu2fecxlty` FOREIGN KEY (`deliverables`) REFERENCES `deliverable` (`id_deliverable`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visit_deliverables`
--

LOCK TABLES `visit_deliverables` WRITE;
/*!40000 ALTER TABLE `visit_deliverables` DISABLE KEYS */;
INSERT INTO `visit_deliverables` VALUES (1,1),(1,2),(2,3),(2,4),(2,5);
/*!40000 ALTER TABLE `visit_deliverables` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-02 19:31:54
