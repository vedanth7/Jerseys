-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: jerseys
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `custid` int NOT NULL AUTO_INCREMENT,
  `custname` varchar(50) NOT NULL,
  `custDOB` varchar(50) NOT NULL,
  `custusername` varchar(50) NOT NULL,
  `custpassword` varchar(50) NOT NULL,
  `custphone` varchar(11) DEFAULT NULL,
  `custemail` varchar(50) DEFAULT NULL,
  `custaddress` varchar(50) NOT NULL,
  PRIMARY KEY (`custid`)
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (102,'aaaa','null','aaaa','aaaaaaa','null','null','null'),(103,'aftab','null','aftab','null','null','null','null'),(105,'null','null','null','null','null','null','null'),(108,'ved','5-8-1999','ved','1d1234','8762727421','deepu@gmail.com','shimoga'),(109,'Thank you for visting!','null','Thank you for visting!','2','null','null','null'),(110,'Divya','null','Divya','null','null','null','null'),(111,'pbj','null','pbj','6','null','null','null'),(112,'null','null','null','null','null','null','null'),(113,'null','null','null','null','null','null','null'),(114,'null','null','null','null','null','null','null'),(115,'null','null','null','null','null','null','null'),(116,'null','null','null','null','null','null','null'),(117,'null','null','null','null','null','null','null'),(118,'null','null','null','null','null','null','null'),(119,'null','null','null','null','null','null','null'),(120,'null','null','null','null','null','null','null'),(121,'null','null','null','null','null','null','null'),(122,'null','null','null','null','null','null','null'),(123,'null','null','null','null','null','null','null'),(124,'null','null','null','null','null','null','null'),(125,'null','null','null','null','null','null','null'),(126,'null','null','null','null','null','null','null'),(127,'dfsdfsdf','null','dfsdfsdf','dsfdsf','dsfsd','fsdfsd','fsdsd'),(128,'Glenn','null','Glenn','1','12344','glenn@glenn.com','fhgiibsdifbihf'),(129,'Divya','null','Divya','null','null','null','null'),(130,'Divya','null','Divya','2104','9828641276','divya@2104','bangalore'),(131,'upasana','null','upasana','1234','54','uh','sdf'),(132,'abhi','null','abhi','1','52','dsf','dsf'),(133,'null','null','null','null','null','null','null'),(134,'ppppp','1999-12-09','ppppp','5858','8787','hb','mu'),(135,'pr','2021-11-10','pr','2','52','a@gmail.com','sdf'),(136,'null','null','null','null','null','null','null'),(137,'rashmi','2000-02-22','rashmi','rashmmm123','8660510908','rash@gmail.com','savadatti');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-07 10:27:50
