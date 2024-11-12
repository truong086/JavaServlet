CREATE DATABASE  IF NOT EXISTS `quanlyquantrasua` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `quanlyquantrasua`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlyquantrasua
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `isSell` int DEFAULT NULL,
  `isAdmin` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'abc','123',1,1),(2,'asp','123',1,0),(3,'akl','123',0,0);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categry`
--

DROP TABLE IF EXISTS `categry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categry` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tenloai` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `ngaytao` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categry`
--

LOCK TABLES `categry` WRITE;
/*!40000 ALTER TABLE `categry` DISABLE KEYS */;
INSERT INTO `categry` VALUES (1,'Quần áo nam','2022-10-10'),(3,'Quần áo thời trang','2022-10-10');
/*!40000 ALTER TABLE `categry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oder`
--

DROP TABLE IF EXISTS `oder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `createDate` date DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `tongtien` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `oder_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oder`
--

LOCK TABLES `oder` WRITE;
/*!40000 ALTER TABLE `oder` DISABLE KEYS */;
INSERT INTO `oder` VALUES (1,'2023-03-26',1,0),(2,'2023-03-26',1,240000),(3,'2023-03-26',1,240000),(4,'2023-03-26',1,240000),(5,'2023-03-30',2,960000),(6,'2023-05-10',2,480000),(7,'2023-06-05',1,240000),(8,'2023-09-19',1,2147483647),(9,'2023-09-19',1,1440000),(10,'2023-09-19',1,738),(11,'2023-09-25',1,2147483647),(12,'2023-10-04',1,240000),(13,'2023-10-26',1,480000),(14,'2023-10-26',1,240000),(15,'2023-10-26',1,2147483647),(16,'2023-10-26',1,0),(17,'2023-10-26',1,240147),(18,'2023-10-26',1,480147),(19,'2024-03-31',1,960000),(20,'2024-04-01',1,1440000),(21,'2024-04-01',1,960442),(22,'2024-04-02',1,480295),(23,'2024-05-26',1,442),(24,'2024-06-05',1,240442),(25,'2024-11-12',1,240147);
/*!40000 ALTER TABLE `oder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderline`
--

DROP TABLE IF EXISTS `orderline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderline` (
  `oder_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `price` float DEFAULT NULL,
  KEY `oder_id` (`oder_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `orderline_ibfk_1` FOREIGN KEY (`oder_id`) REFERENCES `oder` (`id`),
  CONSTRAINT `orderline_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderline`
--

LOCK TABLES `orderline` WRITE;
/*!40000 ALTER TABLE `orderline` DISABLE KEYS */;
INSERT INTO `orderline` VALUES (2,1,1,240000),(3,1,1,240000),(4,1,1,240000),(5,1,1,240000),(6,1,1,240000),(7,1,1,240000),(9,1,6,240000),(18,1,1,240000),(19,1,4,240000),(20,1,6,240000),(21,10,3,147.6),(21,1,4,240000),(22,10,2,147.6),(22,1,2,240000),(23,10,3,147.6),(24,10,3,147.6),(24,1,1,240000),(25,1,1,240000),(25,10,1,147.6);
/*!40000 ALTER TABLE `orderline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `image` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `description` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `catID` int DEFAULT NULL,
  `sell_ID` int DEFAULT NULL,
  `account_ID` int DEFAULT NULL,
  `soluong` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `catID` (`catID`),
  KEY `sell_ID` (`sell_ID`),
  KEY `account_ID` (`account_ID`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`catID`) REFERENCES `categry` (`id`),
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`sell_ID`) REFERENCES `account` (`id`),
  CONSTRAINT `product_ibfk_3` FOREIGN KEY (`account_ID`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Quần áo nam','Quần áo thời trang','https://tse3.mm.bing.net/th?id=OIP.3cD6lnxemUlqOgiBRuueoAHaHa&pid=Api&P=0&h=220',200000,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime dolorem illum aut eum ullam nobis quidem asperiores tempora quas laboriosam?',3,1,1,1),(10,'Quần áo mùa đông','Quần áo đông','https://aokhoacnam.vn/upload/images/views/aokhoacnam/phoi-do-quan-au-nam-2.jpg',123,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime dolorem illum aut eum ullam nobis quidem asperiores tempora quas laboriosam?',1,NULL,1,1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-12 19:37:53
