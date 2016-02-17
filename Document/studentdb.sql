# MySQL-Front 5.1  (Build 2.7)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: studentdb
# ------------------------------------------------------
# Server version 5.6.24

DROP DATABASE IF EXISTS `studentdb`;
CREATE DATABASE `studentdb` /*!40100 DEFAULT CHARACTER SET gbk */;
USE `studentdb`;

#
# Source for table grade
#

DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(255) DEFAULT NULL,
  `chinese` decimal(10,2) DEFAULT '0.00',
  `english` decimal(10,2) DEFAULT '0.00',
  `maths` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

#
# Dumping data for table grade
#
LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;

INSERT INTO `grade` VALUES (1,'1',111,3333,222);
INSERT INTO `grade` VALUES (2,'2',50,60,30);
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table students
#

DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `userclassid` int(11) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '1为老师2为学生',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

#
# Dumping data for table students
#
LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;

INSERT INTO `students` VALUES (1,'adc','ddd','ddd222',56,'2016-01-29 10:04:41',0);
INSERT INTO `students` VALUES (2,'d','d','ddd',46,'2016-01-29 14:38:51',1);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table userclass
#

DROP TABLE IF EXISTS `userclass`;
CREATE TABLE `userclass` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Teacher` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `CreateDate` datetime DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=gbk;

#
# Dumping data for table userclass
#
LOCK TABLES `userclass` WRITE;
/*!40000 ALTER TABLE `userclass` DISABLE KEYS */;

INSERT INTO `userclass` VALUES (46,'5','55','555','2016-01-12 20:50:16');
INSERT INTO `userclass` VALUES (47,'dfd','dfd','df','2016-01-19 15:35:59');
INSERT INTO `userclass` VALUES (48,'asdf','asdfas','fasdf','2016-01-19 15:45:27');
INSERT INTO `userclass` VALUES (49,'dd','d','dfdf','2016-01-19 15:56:39');
INSERT INTO `userclass` VALUES (50,'df','sdfas','fasd','2016-01-19 15:56:56');
INSERT INTO `userclass` VALUES (51,'xxxx','xxxxxxxx','xxxxxxxxx','2016-01-19 16:05:09');
INSERT INTO `userclass` VALUES (52,'asdfasdf','asdfasdf','asdfasdfasdf','2016-01-19 16:22:36');
INSERT INTO `userclass` VALUES (53,'1111','232323','2323','2016-01-21 15:19:59');
INSERT INTO `userclass` VALUES (54,'dddd','dd','dd','2016-01-21 15:29:51');
INSERT INTO `userclass` VALUES (55,'2323','232323','2323','2016-01-21 15:40:53');
INSERT INTO `userclass` VALUES (56,'阿士大夫撒','撒地方','士大夫撒旦法','2016-01-21 15:45:25');
INSERT INTO `userclass` VALUES (57,'d2','d1','d3','2016-01-22 19:03:44');
INSERT INTO `userclass` VALUES (58,'13','14','15','2016-01-22 19:08:28');
INSERT INTO `userclass` VALUES (59,'d','d','d','2016-01-22 19:36:01');
INSERT INTO `userclass` VALUES (60,'00011','00011','000011','2016-01-22 19:37:19');
INSERT INTO `userclass` VALUES (61,'dfd','dfds','fsdf','2016-01-27 17:53:52');
INSERT INTO `userclass` VALUES (62,'ss','ss','ss','2016-01-27 17:53:58');
INSERT INTO `userclass` VALUES (63,'343','434','3434','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (64,'343','434','34','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (65,'5555',NULL,NULL,'0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (66,'555','555','555','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (67,'fsafd','dfdfd','fdfdfdf','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (68,'dfdf','dfdfdf','dfdffdf','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (69,'dfdfd','ffdfd','fdfdfdf','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (70,'dfdf','dfdf','dfdfd','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (71,'111','111','1111','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (72,'222','222','22','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (73,'333','444333','3333','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (74,'4444','4444','444','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (75,'6666','66666','6666','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (76,'555','555','5555','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (77,'777','888','888','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (78,'8888','888','88888','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (79,'99999','99','0999','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (80,'999','999','9999','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (81,'999','999','9999','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (82,'333','33','333','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (83,'333','333','33333','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (84,'333','333','3333','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (85,'444','555','6666','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (86,'444','44','4444','0000-00-00 00:00:00');
INSERT INTO `userclass` VALUES (87,'555','555','5555','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `userclass` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
