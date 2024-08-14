-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: gk_restaurant
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `role` varchar(5) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `subRole` varchar(12) NOT NULL,
  `firstName` varchar(15) NOT NULL,
  `lastName` varchar(15) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `doj` date NOT NULL,
  `phone` varchar(10) NOT NULL,
  `email` varchar(35) NOT NULL,
  `salary` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES ('Staff',1,'Chef','Sarthak','Chourey','cheff_sarthak','sarthak69','2021-08-07','2345678910','cheffSarthak@gmail.com',35000.00),('Staff',2,'Waiter','Amit','Sharma','amit_sharma2','Amit1234','2023-01-15','9876543210','amit.sharma@example.com',25000.00),('Staff',3,'Chef','Rajesh','Kumar','rajesh_kumar3','Rajesh1234','2023-01-18','9876543211','rajesh.kumar@example.com',30000.00),('Staff',4,'Waiter','Vikas','Singh','vikas_singh4','Vikas1234','2023-01-22','9876543212','vikas.singh@example.com',25000.00),('Staff',5,'Chef','Sunil','Reddy','sunil_reddy5','Sunil1234','2023-02-10','9876543213','sunil.reddy@example.com',32000.00),('Staff',6,'Waiter','Pankaj','Verma','pankaj_verma6','Pankaj1234','2023-02-15','9876543214','pankaj.verma@example.com',26000.00),('Staff',7,'Cleaner','Suresh','Gupta','suresh_gupta7','Suresh1234','2023-03-01','9876543215','suresh.gupta@example.com',22000.00),('Staff',8,'Waiter','Anil','Yadav','anil_yadav8','Anil1234','2023-03-15','9876543216','anil.yadav@example.com',27000.00),('Staff',9,'Chef','Ravi','Patel','ravi_patel9','Ravi1234','2023-04-05','9876543217','ravi.patel@example.com',33000.00),('Staff',10,'Receptionist','Karan','Joshi','karan_joshi10','Karan1234','2023-04-18','9876543218','karan.joshi@example.com',28000.00),('Staff',11,'Cleaner','Deepak','Singh','deepak_singh11','Deepak1234','2023-05-01','9876543219','deepak.singh@example.com',23000.00),('Staff',12,'Chef','Nitin','Saxena','nitin_saxena12','Nitin1234','2023-05-15','9876543220','nitin.saxena@example.com',31000.00),('Staff',13,'Waiter','Arun','Pandey','arun_pandey13','Arun1234','2023-06-01','9876543221','arun.pandey@example.com',25000.00),('Staff',14,'Chef','Vivek','Desai','vivek_desai14','Vivek1234','2023-06-15','9876543222','vivek.desai@example.com',34000.00),('Staff',15,'Waiter','Manoj','Patil','manoj_patil15','Manoj1234','2023-07-01','9876543223','manoj.patil@example.com',26000.00),('Staff',16,'Cleaner','Prakash','Chopra','prakash_chopra16','Prakash1234','2023-07-15','9876543224','prakash.chopra@example.com',24000.00),('Staff',17,'Receptionist','Ashok','Goyal','ashok_goyal17','Ashok1234','2023-08-01','9876543225','ashok.goyal@example.com',29000.00),('Staff',18,'Chef','Rohit','Bhatia','rohit_bhatia18','Rohit1234','2023-08-15','9876543226','rohit.bhatia@example.com',35000.00),('Staff',19,'Waiter','Vishal','Shukla','vishal_shukla19','Vishal1234','2023-09-01','9876543227','vishal.shukla@example.com',28000.00),('Staff',20,'Manager','Naresh','Malhotra','naresh_malhotra20','Naresh1234','2023-09-15','9876543228','naresh.malhotra@example.com',48000.00),('Staff',21,'Cleaner','Rakesh','Singh','rakesh_singh21','Rakesh1234','2023-10-01','9876543229','rakesh.singh@example.com',24000.00);
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-21 14:07:09
