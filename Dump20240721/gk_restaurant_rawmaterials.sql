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
-- Table structure for table `rawmaterials`
--

DROP TABLE IF EXISTS `rawmaterials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rawmaterials` (
  `RawMaterialID` int NOT NULL AUTO_INCREMENT,
  `RawMaterialName` varchar(255) NOT NULL,
  `QuantityAvailable` float NOT NULL,
  `Unit` varchar(50) NOT NULL,
  `ReorderLevel` float NOT NULL,
  `PricePerUnit` decimal(10,2) NOT NULL,
  PRIMARY KEY (`RawMaterialID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rawmaterials`
--

LOCK TABLES `rawmaterials` WRITE;
/*!40000 ALTER TABLE `rawmaterials` DISABLE KEYS */;
INSERT INTO `rawmaterials` VALUES (1,'Potato',30,'kg',20,20.00),(2,'Tomato',78,'kg',15,25.00),(3,'Onion',100,'kg',20,30.00),(4,'Wheat Flour',199,'kg',50,40.00),(5,'Rice',300,'kg',100,50.00),(6,'Oil',150,'liters',30,100.00),(7,'Butter',50,'kg',10,300.00),(8,'Paneer',100,'kg',20,400.00),(9,'Cauliflower',50,'kg',10,35.00),(10,'Peas',80,'kg',20,60.00),(11,'Spinach',60,'kg',15,20.00),(12,'Coconut Milk',40,'liters',10,120.00),(13,'Gram Flour',100,'kg',25,50.00),(14,'Chickpeas',100,'kg',25,70.00),(15,'Kidney Beans',100,'kg',25,80.00),(16,'Okra',60,'kg',15,45.00),(17,'Fenugreek Leaves',40,'kg',10,30.00),(18,'Cumin Seeds',20,'kg',5,200.00),(19,'Red Lentils',150,'kg',30,70.00),(20,'Black Lentils',100,'kg',25,80.00),(21,'Coriander Powder',30,'kg',5,150.00),(22,'Turmeric Powder',25,'kg',5,100.00),(23,'Garam Masala',20,'kg',5,250.00),(24,'Green Chilies',50,'kg',10,60.00),(25,'Ginger',40,'kg',10,80.00),(26,'Garlic',50,'kg',15,90.00),(27,'Salt',200,'kg',50,10.00),(28,'Sugar',150,'kg',40,40.00),(29,'Curd',80,'kg',20,50.00),(30,'Saffron',5,'kg',1,150000.00),(31,'Dry Fruits',50,'kg',10,800.00);
/*!40000 ALTER TABLE `rawmaterials` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-21 14:07:06
