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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `role` varchar(8) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(15) NOT NULL,
  `lastName` varchar(15) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `dob` date NOT NULL,
  `phone` varchar(10) NOT NULL,
  `email` varchar(35) NOT NULL,
  `address1` longtext,
  `address2` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('Customer',1,'Sarthak','Chourey','sarthak69','sarthak69','2004-07-05','8889387940','sarthak@gmail.com','69 IPS Academy','Indore, MP'),('Customer',2,'Himanshu','Parihar','himu','himu69','2004-08-17','1234567890','himanshu@gmail.com','67 Ram Nagar','Indore, MP'),('Customer',3,'Rahul','Sharma','rahul_sharma3','Rahul1234','1990-04-12','9876543201','rahul.sharma@example.com','45 MG Road','Indore, MP'),('Customer',4,'Priya','Verma','priya_verma4','Priya1234','1992-08-21','9876543202','priya.verma@example.com','78 Palasia','Indore, MP'),('Customer',5,'Sanjay','Kumar','sanjay_kumar5','Sanjay1234','1988-11-30','9876543203','sanjay.kumar@example.com','12 Vijay Nagar','Indore, MP'),('Customer',6,'Anita','Singh','anita_singh6','Anita1234','1995-01-15','9876543204','anita.singh@example.com','34 Sapna Sangeeta','Indore, MP'),('Customer',7,'Deepak','Rao','deepak_rao7','Deepak1234','1991-07-23','9876543205','deepak.rao@example.com','67 Rajwada','Indore, MP'),('Customer',8,'Kiran','Patel','kiran_patel8','Kiran1234','1985-12-05','9876543206','kiran.patel@example.com','90 AB Road','Indore, MP'),('Customer',9,'Aakash','Desai','aakash_desai9','Aakash1234','1993-03-18','9876543207','aakash.desai@example.com','56 Old Palasia','Indore, MP'),('Customer',10,'Pooja','Gupta','pooja_gupta10','Pooja1234','1989-06-27','9876543208','pooja.gupta@example.com','23 New Palasia','Indore, MP'),('Customer',11,'Ravi','Mehta','ravi_mehta11','Ravi1234','1990-09-10','9876543209','ravi.mehta@example.com','101 BRTS Road','Indore, MP'),('Customer',12,'Sneha','Joshi','sneha_joshi12','Sneha1234','1994-05-19','9876543210','sneha.joshi@example.com','47 Annapurna','Indore, MP'),('Customer',13,'Nitin','Kapoor','nitin_kapoor13','Nitin1234','1986-02-22','9876543211','nitin.kapoor@example.com','88 Usha Nagar','Indore, MP'),('Customer',14,'Ritika','Agarwal','ritika_agarwal14','Ritika1234','1993-10-30','9876543212','ritika.agarwal@example.com','56 Sudama Nagar','Indore, MP'),('Customer',15,'Arjun','Bansal','arjun_bansal15','Arjun1234','1991-12-14','9876543213','arjun.bansal@example.com','78 Scheme No 54','Indore, MP'),('Customer',16,'Shreya','Rathore','shreya_rathore16','Shreya1234','1988-04-25','9876543214','shreya.rathore@example.com','23 Saket Nagar','Indore, MP'),('Customer',17,'Vikas','Chauhan','vikas_chauhan17','Vikas1234','1990-11-17','9876543215','vikas.chauhan@example.com','44 Rau Road','Indore, MP'),('Customer',18,'Preeti','Soni','preeti_soni18','Preeti1234','1992-08-08','9876543216','preeti.soni@example.com','90 Khajrana','Indore, MP'),('Customer',19,'Amit','Mishra','amit_mishra19','Amit1234','1987-03-11','9876543217','amit.mishra@example.com','67 Musakhedi','Indore, MP'),('Customer',20,'Rashmi','Dixit','rashmi_dixit20','Rashmi1234','1991-05-02','9876543218','rashmi.dixit@example.com','12 Nanda Nagar','Indore, MP'),('Customer',21,'Gaurav','Jain','gaurav_jain21','Gaurav1234','1989-07-16','9876543219','gaurav.jain@example.com','23 RNT Marg','Indore, MP'),('Customer',22,'Neha','Shah','neha_shah22','Neha1234','1994-11-25','9876543220','neha.shah@example.com','56 Tukoganj','Indore, MP'),('Customer',23,'Kunal','Tiwari','kunal_tiwari23','Kunal1234','1990-09-07','9876543221','kunal.tiwari@example.com','78 Pardesipura','Indore, MP'),('Customer',24,'Meena','Pandey','meena_pandey24','Meena1234','1986-06-20','9876543222','meena.pandey@example.com','34 Kanadia Road','Indore, MP'),('Customer',25,'Sandeep','Dubey','sandeep_dubey25','Sandeep1234','1988-02-29','9876543223','sandeep.dubey@example.com','23 Mhow Naka','Indore, MP'),('Customer',26,'Divya','Shinde','divya_shinde26','Divya1234','1992-12-10','9876543224','divya.shinde@example.com','45 Narmada Nagar','Indore, MP'),('Customer',27,'Manish','Rana','manish_rana27','Manish1234','1991-01-19','9876543225','manish.rana@example.com','67 Bhawarkua','Indore, MP'),('Customer',28,'Swati','Choudhary','swati_choudhary28','Swati1234','1993-03-05','9876543226','swati.choudhary@example.com','78 Ring Road','Indore, MP'),('Customer',29,'Abhishek','Patidar','abhishek_patidar29','Abhishek1234','1990-07-11','9876543227','abhishek.patidar@example.com','12 Mahalaxmi Nagar','Indore, MP'),('Customer',30,'Rekha','Trivedi','rekha_trivedi30','Rekha1234','1989-10-01','9876543228','rekha.trivedi@example.com','34 Kesar Bagh','Indore, MP'),('Customer',31,'Pankaj','Kothari','pankaj_kothari31','Pankaj1234','1991-02-24','9876543229','pankaj.kothari@example.com','45 Malwa Mill','Indore, MP'),('Customer',32,'sarthak','chourey','sarthak90','sarthak90','2004-05-07','456767','sarhak@gmail.com','sge','thet'),('Customer',33,'Khushboo','Dubey','KD','kd1234','2024-06-12','1234567','kd123@gmial.com','annpoorna','indore'),('Customer',34,'Nikant','Yadav','nikantyadav1','8871929735@1','2004-06-02','8871929735','nikantyadav1@gmail.com','rajendra nagar','indore'),('Customer',35,'Nikant','Yadav','Nikk','8871929735','2024-04-09','1234567890','qw123@gmial.com','vidisha','vidisha');
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

-- Dump completed on 2024-07-21 14:07:05
