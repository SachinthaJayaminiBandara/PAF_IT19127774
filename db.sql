-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: grant_management
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `grant_application`
--

DROP TABLE IF EXISTS `grant_application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grant_application` (
  `Grant_Application_ID` varchar(10) NOT NULL,
  `Title` varchar(45) NOT NULL,
  `Full_Name` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Phone` varchar(45) NOT NULL,
  `Research_category` varchar(45) NOT NULL,
  `Budget` varchar(45) NOT NULL,
  `Introduction` varchar(45) NOT NULL,
  PRIMARY KEY (`Grant_Application_ID`),
  UNIQUE KEY `Grant_Application_ID_UNIQUE` (`Grant_Application_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grant_application`
--

LOCK TABLES `grant_application` WRITE;
/*!40000 ALTER TABLE `grant_application` DISABLE KEYS */;
INSERT INTO `grant_application` VALUES ('G001','dengue vaccine part4','Sahan Bandara','sahan@gmail','0812415853','medical','5000000','Continueing the dendue vaccine development'),('G002','covid 19 1.1.6.H vaccine','Kamala Herath','kamalaherath@gmail.com','0712342325','medical','20000000','createing a solution for covid 19'),('G003',' A talking hearing aid','Sanath Gunathilaka','sanathgunathilaka@gmail.com','0709128473','medical','300000000','createing a hearing aid'),('G005','dengue vaccine part5','Sahan Bandara','sahan@gmail','0812415853','medical','5000000','Continueing the dendue vaccine development');
/*!40000 ALTER TABLE `grant_application` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-14 17:47:51
