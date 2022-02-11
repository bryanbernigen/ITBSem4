-- MariaDB dump 10.19  Distrib 10.6.5-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: barokah_cafe
-- ------------------------------------------------------
-- Server version	10.6.5-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `barokah_cafe`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `barokah_cafe` /*!40100 DEFAULT CHARACTER SET utf8mb3 */;

USE `barokah_cafe`;

--
-- Temporary table structure for view `brazillian`
--

DROP TABLE IF EXISTS `brazillian`;
/*!50001 DROP VIEW IF EXISTS `brazillian`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `brazillian` (
  `member_id` tinyint NOT NULL,
  `nome` tinyint NOT NULL,
  `gender` tinyint NOT NULL,
  `card_number` tinyint NOT NULL,
  `saldo` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(25) NOT NULL,
  `address` text NOT NULL,
  `phone` varchar(25) NOT NULL,
  `gender` enum('Male','Female') NOT NULL,
  `nationality` varchar(25) NOT NULL,
  `birth_date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`id`, `employee_name`, `address`, `phone`, `gender`, `nationality`, `birth_date`) VALUES (1,'Wilhelmus Andrian','273 Sauthoff Drive','351-(315)589-9256','Male','Indonesia','1985-10-14'),(2,'Gifari Kautsar','54655 Bay Pass','86-(366)518-0188','Male','Indonesia','1987-01-18'),(3,'Hayyu Hanifah','9 Parkside Crossing','86-(852)864-7002','Female','Indonesia','1985-05-22'),(4,'Marco Orlando','784 Laurel Hill','62-(313)196-7317','Male','China','1980-02-18'),(5,'Nimas Putri','6620 School Center','86-(571)272-2430','Female','Indonesia','1986-07-08'),(6,'Tegar Aji Pangestu','0 Pierstorff Circle','86-(694)102-5992','Female','Indonesia','1980-10-23'),(7,'Willy Lie','0349 Express Point','62-(657)194-1663','Male','China','1988-09-02'),(8,'Felix Riady Tanamas','5 Meadow Vale Park','86-(532)646-0063','Female','China','1980-03-28'),(9,'Scott Jenkins','66 Lake View Point','386-(244)769-4101','Male','Slovenia','1981-11-13'),(10,'Eric Ellis','2 Elka Park','86-(112)258-0221','Male','China','1985-01-03'),(11,'Cheryl Chavez','5445 Blackbird Avenue','86-(539)880-4894','Female','China','1984-06-01'),(12,'Jacqueline Hughes','55 Coleman Hill','86-(884)930-9792','Female','China','1984-07-24'),(13,'Martha Bowman','8916 Riverside Place','55-(568)478-5454','Female','Brazil','1987-11-26'),(14,'Laura Williamson','41403 Cody Terrace','86-(252)987-8199','Female','China','1988-03-11'),(15,'Deborah Hughes','57 Scott Center','86-(602)638-0723','Female','China','1989-04-22'),(16,'Judy Burns','81731 Stang Plaza','84-(454)578-5233','Female','Vietnam','1980-11-06'),(17,'Kelly Hill','0325 Maywood Lane','27-(169)830-9283','Female','South Africa','1989-02-03'),(18,'Karen Morgan','02 Mccormick Place','62-(696)754-3136','Female','Indonesia','1983-02-17'),(19,'Deborah Lewis','878 Darwin Crossing','593-(313)841-4156','Female','Ecuador','1986-10-19'),(20,'Sandra Kelly','4 Spohn Way','86-(892)980-9269','Female','China','1986-07-15'),(21,'Linda Bennett','26 Maple Lane','55-(198)794-9751','Female','Brazil','1980-03-08'),(22,'Joe Fox','4 Homewood Avenue','7-(679)230-5994','Male','Russia','1987-12-17'),(23,'Jeffrey Nelson','17 Toban Place','7-(602)586-2120','Male','Russia','1984-12-03'),(24,'Samuel West','71 Arapahoe Court','7-(410)865-1624','Male','Russia','1985-03-30'),(25,'Janet Nguyen','04 Kenwood Pass','977-(722)503-5584','Female','Nepal','1989-07-02');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_salary`
--

DROP TABLE IF EXISTS `employee_salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_salary` (
  `employee_id` int(11) NOT NULL,
  `salary` int(11) NOT NULL,
  `start_date` date NOT NULL,
  UNIQUE KEY `employee_id` (`employee_id`),
  CONSTRAINT `employee_salary_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_salary`
--

LOCK TABLES `employee_salary` WRITE;
/*!40000 ALTER TABLE `employee_salary` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(25) NOT NULL,
  `price` int(11) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` (`id`, `item_name`, `price`, `description`) VALUES (1,'Nasi goreng',40000,'Nasi goreng adalah sebuah makanan berupa nasi yang digoreng dan diaduk dalam minyak goreng atau margarin, biasanya ditambah kecap manis, bawang merah, bawang putih, asam jawa, lada dan bumbu-bumbu lainnya, seperti telur, ayam, dan kerupuk.'),(2,'Hamburger',30000,'Hamburger (atau seringkali disebut dengan burger) adalah sejenis makanan berupa roti berbentuk bundar yang diiris dua dan ditengahnya diisi dengan patty yang biasanya diambil dari daging, kemudian sayur-sayuran berupa selada, tomat dan bawang bombay. Sebagai sausnya, burger diberi berbagai jenis saus seperti mayones, saus tomat dan sambal serta mustard. Beberapa varian burger juga dilengkapi dengan keju, asinan, serta bahan pelengkap lain seperti sosis dan ham.'),(3,'Siomay',18000,'Siomai atau siomay adalah salah satu jenis dim sum. Dalam bahasa Mandarin, makanan ini disebut shaomai.'),(4,'American Sandwich',30000,'Sandwich atau roti lapis adalah makanan berupa dua potong roti yang menjepit daging, sayuran, keju atau berbagai teman makan roti dan biasanya diberi bumbu atau saus sehingga rasanya menjadi lebih enak.'),(5,'Milk Tea',18000,'Milk tea refers to any form of beverage found in many cultures, containing some combination of tea and milk. Beverages vary based on the amount of each of these key ingredients, the method of preparation, and the inclusion of other ingredients (varying from sugar or honey to salt or cardamom).'),(6,'Vanilla Milkshake',30000,'A milkshake is a sweet, cold beverage which is usually made from milk, ice cream, or iced milk, and flavorings or sweeteners such as butterscotch, caramel sauce, chocolate sauce, or fruit syrup. Outside the United States, milkshakes using ice cream or iced milk are sometimes called a thick milkshake or thick shake or in New England (outside of Rhode Island) a frappe, to differentiate them from thinner forms of flavored milk.'),(7,'Pepperoni Pizza',66000,'Peperoni Pizzeria is an Italian restaurant serving rustic Italian cuisine such as wood fired thin crust pizzas and pastas.'),(8,'Vanilla Latte',30000,'Rich, full-bodied espresso blended with milk and vanilla syrup, served over ice.'),(9,'Pancake',24000,'Panekuk adalah kue dadar yang dibuat dari terigu, telur ayam, gula dan susu. Bahan-bahan dicampur dengan air membentuk adonan kental yang digoreng di atas wajan datar yang diolesi sedikit minyak.'),(10,'Mie goreng',30000,'Mi goreng berarti \"mi yang digoreng\" adalah makanan yang populer dan digemari di Indonesia, Malaysia, dan Singapura.'),(12,'Matcha Latte',27600,'-');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `member_id` int(11) NOT NULL AUTO_INCREMENT,
  `member_name` varchar(25) NOT NULL,
  `address` text NOT NULL,
  `phone` varchar(16) NOT NULL,
  `gender` enum('Male','Female') NOT NULL,
  `nationality` varchar(25) NOT NULL,
  `birth_date` date NOT NULL,
  `register_date` date NOT NULL,
  `card_number` int(25) NOT NULL,
  PRIMARY KEY (`member_id`),
  KEY `id` (`member_id`),
  KEY `card_number` (`card_number`),
  KEY `card_number_2` (`card_number`),
  KEY `card_number_3` (`card_number`)
) ENGINE=InnoDB AUTO_INCREMENT=501 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` (`member_id`, `member_name`, `address`, `phone`, `gender`, `nationality`, `birth_date`, `register_date`, `card_number`) VALUES (401,'Albert Tripo Adrian','98322 Mariners Cove Plaza','55-(330)225-3231','Male','China','1965-03-17','2016-04-05',513794342),(402,'Fick Ulya Astahta','3520 Heffernan Place','63-(669)430-2092','Male','Indonesia','1977-05-26','2015-11-10',393943402),(403,'Jose Phillips','818 2nd Center','86-(573)384-6469','Male','China','1982-09-17','2015-05-25',810979337),(404,'Thomas Tucker','810 Delaware Alley','48-(939)716-9852','Male','Poland','1965-09-28','2015-06-17',757985888),(405,'Rachel Powell','3 Ronald Regan Alley','86-(352)932-8929','Female','China','1976-03-19','2015-09-24',654251253),(406,'Henry Black','88043 Truax Parkway','63-(615)341-9767','Male','Philippines','1961-02-22','2015-05-09',918146289),(407,'Jennifer Chapman','9157 Victoria Avenue','53-(902)377-5164','Female','Cuba','1992-11-13','2015-04-05',605202403),(408,'Carl Washington','634 Loftsgordon Hill','63-(764)102-3349','Male','Philippines','1952-06-12','2015-08-19',981084768),(409,'Barbara Patterson','2292 Warbler Terrace','66-(844)445-2892','Female','Thailand','1971-04-25','2015-12-03',816252439),(410,'Ruth Grant','69 Trailsway Pass','420-(687)348-086','Female','Czech Republic','1955-12-31','2016-01-12',878346370),(411,'Walter Payne','62118 Sheridan Center','249-(136)628-367','Male','Sudan','1965-09-27','2015-12-28',886229915),(412,'Susan Ross','7 Colorado Terrace','62-(770)758-2801','Female','Indonesia','1994-05-22','2015-05-21',936178725),(413,'Carol Johnston','60597 Towne Court','351-(743)228-910','Female','Portugal','1956-02-28','2015-12-19',124532715),(414,'Marie Burns','2 Nevada Way','963-(538)749-435','Female','Syria','1988-08-20','2015-09-14',259811513),(415,'Nicholas Diaz','91353 Northland Place','86-(228)823-2240','Male','China','1952-12-21','2015-11-11',443919862),(416,'Frank Perez','752 Farragut Drive','51-(898)460-5916','Male','Peru','1963-04-30','2016-01-05',138245448),(417,'Jane Nguyen','4990 West Road','351-(868)804-801','Female','Portugal','1991-08-16','2015-06-06',866695398),(418,'Jacqueline Meyer','08923 Kennedy Circle','46-(205)432-1981','Female','Sweden','1982-12-21','2015-05-13',897263438),(419,'Wayne Rivera','7836 Sugar Plaza','7-(829)977-9754','Male','Kazakhstan','1992-10-19','2015-06-10',358347094),(420,'Todd Kelly','5 Morning Park','46-(481)413-8487','Male','Sweden','1991-11-22','2015-10-22',788955206),(421,'Irene Ryan','7 Buena Vista Street','389-(168)995-088','Female','Macedonia','1958-05-25','2015-05-14',945986678),(422,'Annie Banks','075 Grayhawk Drive','1-(249)516-7731','Female','Barbados','1981-11-07','2015-04-18',303484343),(423,'Martha Garza','44 Bashford Way','86-(756)887-6497','Female','China','1994-10-09','2015-04-06',174142721),(424,'Andrew Watson','1534 Hollow Ridge Crossing','351-(518)247-076','Male','Portugal','1985-12-27','2015-09-24',819218239),(425,'Eric Fisher','4847 Sullivan Pass','962-(956)262-729','Male','Jordan','1969-07-01','2015-11-09',305015766),(426,'Mark Hawkins','413 Barby Hill','381-(763)582-728','Male','Serbia','1989-07-13','2015-04-17',837895138),(427,'Debra Riley','738 Pond Way','33-(804)728-7790','Female','France','1984-01-08','2015-09-09',712169779),(428,'Shirley Cole','5 3rd Hill','62-(487)181-6764','Female','Indonesia','1983-11-10','2015-12-07',631310235),(429,'Jonathan Simmons','87782 Golf Course Way','62-(207)775-1908','Male','Indonesia','1990-11-22','2015-12-31',512375089),(430,'Stephanie Baker','47956 Vera Lane','86-(724)883-7162','Female','China','1970-11-18','2015-12-22',953195818),(431,'Justin Wells','43178 Fremont Drive','381-(344)529-650','Male','Serbia','1963-11-05','2015-04-28',658923807),(432,'Pamela Martin','86 Starling Lane','55-(924)760-7356','Female','Brazil','1982-02-21','2016-03-06',338018439),(433,'Virginia Sims','14971 Schurz Road','86-(172)921-7133','Female','China','1994-12-09','2016-02-11',213576952),(434,'Christina Carpenter','37709 Dwight Trail','32-(895)990-4624','Female','Belgium','1975-10-19','2015-12-19',449903518),(435,'Mark Kelly','58 Dawn Crossing','595-(959)600-138','Male','Paraguay','1970-07-18','2015-06-13',813187520),(436,'Sara Williams','9690 Melvin Point','63-(585)576-2175','Female','Philippines','1967-02-17','2015-04-24',783833750),(437,'Jane Mendoza','1 Rowland Park','212-(989)314-097','Female','Morocco','1961-02-17','2016-03-14',342457130),(438,'Maria Mcdonald','728 Elgar Street','224-(902)157-768','Female','Guinea','1985-11-30','2015-11-17',185962992),(439,'Maria Young','78966 Hagan Terrace','1-(156)499-6423','Female','Canada','1992-06-29','2015-06-28',891544960),(440,'Lori Price','6406 Oneill Trail','55-(174)320-0911','Female','Brazil','1967-09-06','2016-02-10',757478151),(441,'Jerry Davis','7424 Lakewood Lane','66-(838)731-2290','Male','Thailand','1957-01-18','2015-04-11',188994225),(442,'Joyce Powell','2 Division Parkway','86-(218)514-8586','Female','China','1971-05-08','2015-06-21',330916575),(443,'Timothy Snyder','146 Buena Vista Place','1-(320)762-5354','Male','Canada','1968-03-18','2015-05-20',328574592),(444,'Craig Wright','66124 Summerview Parkway','63-(942)556-4826','Male','Philippines','1971-01-06','2015-04-23',330959769),(445,'Mildred Burns','8667 Starling Court','55-(529)877-6263','Female','Brazil','1958-11-28','2015-05-02',164594981),(446,'Steve Day','87 Independence Street','591-(360)312-244','Male','Bolivia','1956-09-27','2015-08-31',341709841),(447,'Heather Banks','775 Surrey Center','81-(226)239-7408','Female','Japan','1975-06-04','2015-05-03',978293555),(448,'Dennis Wood','316 Welch Park','261-(976)345-076','Male','Madagascar','1993-05-13','2016-01-15',419825885),(449,'Jane Woods','0 Continental Road','1-(729)586-7925','Female','Saint Lucia','1973-12-31','2015-09-22',600576298),(450,'Billy Henry','8650 Bultman Trail','220-(595)479-519','Male','Gambia','1979-12-21','2015-05-16',312707677),(451,'Steve Green','07 Blue Bill Park Road','86-(977)625-0422','Male','China','1975-01-16','2015-10-15',298166976),(452,'Stephen Morales','73940 Meadow Vale Trail','86-(960)643-9152','Male','China','1973-12-27','2015-06-29',381010473),(453,'Emily Ford','34846 Packers Road','880-(954)523-553','Female','Bangladesh','1950-08-14','2015-11-18',981008565),(454,'Jesse Ross','592 Pennsylvania Terrace','86-(767)342-5663','Male','China','1955-03-23','2015-11-08',370022085),(455,'Tina Dean','07854 Holmberg Drive','84-(232)920-3030','Female','Vietnam','1994-05-01','2015-05-22',165298031),(456,'Raymond Reid','486 Swallow Parkway','98-(686)237-9936','Male','Iran','1952-06-27','2015-11-06',576556625),(457,'Kevin Hall','8773 4th Terrace','86-(271)990-1680','Male','China','1975-12-09','2015-06-23',503077188),(458,'Joseph Lewis','2724 Debra Park','389-(279)916-577','Male','Macedonia','1985-06-10','2015-05-09',836704410),(459,'Jane Rogers','6 Laurel Avenue','33-(822)130-0389','Female','France','1992-11-08','2015-12-22',996714926),(460,'Nicholas Garrett','129 Burning Wood Court','86-(256)770-6019','Male','China','1986-05-10','2015-09-08',757742814),(461,'Evelyn Ford','29 Scott Parkway','60-(887)858-2734','Female','Malaysia','1993-09-08','2016-02-07',232571347),(462,'Russell Morgan','18 Emmet Plaza','383-(650)486-363','Male','Kosovo','1955-11-26','2015-12-29',862382883),(463,'Maria Brown','546 Service Terrace','62-(491)326-7729','Female','Indonesia','1969-03-11','2015-10-30',932350153),(464,'Theresa Gomez','72 Bunting Hill','967-(290)933-405','Female','Yemen','1994-11-24','2015-04-14',640246625),(465,'Joyce Crawford','988 Lillian Terrace','7-(669)139-0134','Female','Kazakhstan','1978-07-13','2015-05-01',460786042),(466,'Willie Brown','124 Oneill Street','86-(938)760-7932','Male','China','1971-12-15','2015-04-10',150663240),(467,'Jennifer Meyer','25 Rockefeller Lane','57-(932)592-1636','Female','Colombia','1950-06-29','2016-01-09',468421704),(468,'Heather Bradley','6214 Kipling Crossing','7-(518)592-9877','Female','Russia','1951-07-11','2015-11-20',474122389),(469,'Jacqueline Shaw','4796 Marquette Plaza','1-(869)593-1653','Female','Canada','1959-05-22','2015-11-22',754377033),(470,'Gloria Berry','2269 John Wall Pass','963-(203)409-982','Female','Syria','1973-07-25','2015-05-16',347556810),(471,'Robert Sims','2141 Granby Plaza','7-(986)923-2390','Male','Russia','1977-06-07','2015-04-05',741578675),(472,'Maria Murray','04 Kim Crossing','36-(908)781-7805','Female','Hungary','1970-11-07','2015-10-12',661696307),(473,'Shirley Lawson','04 Arrowood Plaza','86-(436)353-5555','Female','China','1961-08-22','2015-07-13',790024246),(474,'Billy Greene','15914 Heath Pass','964-(425)959-707','Male','Iraq','1962-02-12','2015-04-18',245190503),(475,'Arthur Olson','1354 Donald Alley','229-(676)892-811','Male','Benin','1950-03-19','2015-07-15',876157374),(476,'James Allen','41 Messerschmidt Hill','387-(750)292-706','Male','Bosnia and Herzegovina','1993-04-09','2015-12-04',138643514),(477,'Jean Morgan','1 Carioca Drive','234-(725)254-631','Female','Nigeria','1972-09-23','2015-09-13',380524154),(478,'Daniel Spencer','8 Brickson Park Avenue','420-(201)663-309','Male','Czech Republic','1974-08-20','2016-03-23',687340391),(479,'Helen Weaver','47 Everett Lane','86-(771)208-6414','Female','China','1975-10-29','2016-02-14',660257127),(480,'Annie Oliver','46 Riverside Street','30-(108)277-6631','Female','Greece','1994-03-18','2015-06-01',559217271),(481,'Margaret Chavez','8 Clyde Gallagher Avenue','7-(877)643-9427','Female','Russia','1954-02-08','2015-10-10',964465566),(482,'Juan Gardner','31 Service Plaza','86-(329)949-4817','Male','China','1968-05-29','2015-12-07',184735548),(483,'Kelly Harvey','584 Twin Pines Court','62-(332)451-6122','Female','Indonesia','1986-03-20','2015-11-12',765557004),(484,'Scott Miller','9 Maple Wood Lane','66-(102)396-1262','Male','Thailand','1992-02-24','2015-08-30',338563206),(485,'Clarence Martinez','8146 Superior Way','237-(169)102-990','Male','Cameroon','1978-08-10','2015-04-23',718492371),(486,'Benjamin Patterson','4647 Nova Pass','62-(681)411-4070','Male','Indonesia','1958-05-05','2015-10-09',199780489),(487,'Aaron Long','2 Union Point','86-(203)926-0107','Male','China','1963-07-24','2015-07-25',277530072),(488,'Joan Hansen','21518 Loeprich Terrace','226-(397)503-714','Female','Burkina Faso','1982-07-14','2016-04-04',868692328),(489,'Roger Kelly','725 Michigan Crossing','54-(352)710-7604','Male','Argentina','1968-12-29','2015-09-01',643928321),(490,'Denise Cruz','76 Chinook Road','86-(238)145-3286','Female','China','1985-10-27','2015-11-13',620744137),(491,'Louise Washington','71705 Mariners Cove Alley','66-(615)101-6948','Female','Thailand','1971-07-18','2015-11-03',391055554),(492,'Linda Gordon','529 Autumn Leaf Court','51-(941)737-7634','Female','Peru','1980-03-03','2015-05-13',862008812),(493,'Rachel Bishop','99218 Judy Plaza','92-(392)539-9932','Female','Pakistan','1966-03-07','2015-05-12',720811197),(494,'Larry Ryan','032 Columbus Point','55-(336)914-2328','Male','Brazil','1960-02-14','2016-01-28',574410770),(495,'Larry Gray','5781 Declaration Junction','60-(599)939-7618','Male','Malaysia','1964-02-12','2016-01-24',708381725),(496,'Heather Spencer','5 Pearson Way','52-(463)172-5668','Female','Mexico','1953-08-01','2015-06-24',938926279),(497,'Phillip Dean','30795 Weeping Birch Lane','57-(456)670-9157','Male','Colombia','1963-10-10','2015-11-11',658456951),(498,'Justin Olson','961 Hallows Crossing','66-(207)693-5577','Male','Thailand','1962-04-11','2015-08-10',778135027),(499,'Kimberly Lawrence','69 Northfield Terrace','503-(417)695-714','Female','El Salvador','1976-12-09','2016-01-05',863496664),(500,'Frances Gray','3 Everett Crossing','385-(750)150-020','Female','Croatia','1963-04-04','2015-08-17',657059910);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_card`
--

DROP TABLE IF EXISTS `member_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member_card` (
  `card_number` int(25) NOT NULL,
  `balance` int(11) NOT NULL,
  `point` int(11) NOT NULL,
  PRIMARY KEY (`card_number`),
  KEY `card_number` (`card_number`),
  KEY `card_number_2` (`card_number`),
  KEY `card_number_3` (`card_number`),
  CONSTRAINT `member_card_ibfk_1` FOREIGN KEY (`card_number`) REFERENCES `member` (`card_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_card`
--

LOCK TABLES `member_card` WRITE;
/*!40000 ALTER TABLE `member_card` DISABLE KEYS */;
INSERT INTO `member_card` (`card_number`, `balance`, `point`) VALUES (124532715,40983002,67),(138245448,42445529,56),(138643514,15530669,100),(150663240,15255616,46),(164594981,86631359,58),(165298031,23671615,8),(174142721,48272131,21),(184735548,47633477,77),(185962992,6435275,50),(188994225,9565401,99),(199780489,70574253,96),(213576952,15233880,3),(232571347,20254341,31),(245190503,2995919,96),(259811513,79714978,35),(277530072,89275900,28),(298166976,87320211,18),(303484343,13311721,23),(305015766,41830403,9),(312707677,8065898,91),(328574592,78389508,46),(330916575,72721391,54),(330959769,1000000000,3),(338018439,47353849,55),(338563206,7271241,18),(341709841,50805636,83),(342457130,35619779,34),(347556810,40395375,2),(358347094,10917944,21),(370022085,89238935,67),(380524154,94202580,35),(381010473,6484460,22),(391055554,74074319,82),(393943402,69092219,35),(419825885,12451444,9),(443919862,85515182,89),(449903518,79279636,40),(460786042,99089300,46),(468421704,9245796,66),(474122389,46239489,12),(503077188,85187621,27),(512375089,62422037,76),(513794342,79048343,73),(559217271,85616714,43),(574410770,4904370,72),(576556625,43950489,52),(600576298,70360298,78),(605202403,73521284,97),(620744137,84486862,88),(631310235,91971582,30),(640246625,25926200,71),(643928321,37737542,23),(654251253,88441425,5),(657059910,42092858,31),(658456951,53907615,41),(658923807,92547769,10),(660257127,95582152,91),(661696307,95145346,29),(687340391,13430346,57),(708381725,63200716,93),(712169779,17404910,60),(718492371,81727424,22),(720811197,40315966,17),(741578675,6123350,100),(754377033,42947684,29),(757478151,54920690,33),(757742814,51895412,78),(757985888,67171323,53),(765557004,17025973,0),(778135027,52185308,21),(783833750,1000000000,78),(788955206,23140611,10),(790024246,12730119,95),(810979337,38245705,89),(813187520,14317030,9),(816252439,36713059,70),(819218239,40431449,28),(836704410,94861518,76),(837895138,56331059,59),(862008812,85498753,95),(862382883,24295248,96),(863496664,55425983,12),(866695398,15940538,90),(868692328,62666200,51),(876157374,82269891,1),(878346370,83791250,20),(886229915,66528241,6),(891544960,10154476,68),(897263438,27061224,9),(918146289,1000000000,56),(932350153,19570217,93),(936178725,88593277,97),(938926279,73065153,19),(945986678,54098270,8),(953195818,32870092,8),(964465566,79980887,68),(978293555,59963708,37),(981008565,72687911,64),(981084768,1000000000,49),(996714926,5957143,36);
/*!40000 ALTER TABLE `member_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `card_number` int(25) DEFAULT NULL,
  `cashier_id` int(11) NOT NULL,
  `payment_method` enum('CASH','CREDIT') NOT NULL,
  `no_table` int(11) NOT NULL,
  `order_date` date DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `card_number` (`card_number`),
  KEY `cashier_id` (`cashier_id`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`card_number`) REFERENCES `member_card` (`card_number`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_ibfk_2` FOREIGN KEY (`cashier_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` (`order_id`, `card_number`, `cashier_id`, `payment_method`, `no_table`, `order_date`) VALUES (1,513794342,4,'CASH',3,'2016-04-07'),(3,810979337,5,'CASH',5,'2016-04-07'),(4,757985888,22,'CASH',5,'2016-04-05'),(5,654251253,5,'CREDIT',4,'2016-04-07'),(6,918146289,21,'CREDIT',20,'2016-04-05'),(7,605202403,25,'CASH',20,'2016-04-05'),(8,981084768,20,'CASH',7,'2016-04-05'),(9,816252439,14,'CREDIT',13,NULL),(10,878346370,25,'CREDIT',18,'2016-04-05'),(11,886229915,22,'CREDIT',13,'2016-04-05'),(12,936178725,20,'CASH',10,'2016-04-05'),(13,124532715,21,'CASH',4,'2016-04-05'),(14,259811513,21,'CREDIT',20,'2016-04-05'),(15,443919862,9,'CASH',0,'2016-04-05'),(16,138245448,2,'CASH',15,'2016-04-07'),(17,866695398,24,'CREDIT',1,'2016-04-05'),(18,897263438,6,'CASH',4,'2016-04-07'),(19,358347094,12,'CASH',8,'2016-04-06'),(20,788955206,24,'CASH',19,'2016-04-05'),(21,945986678,15,'CASH',9,'2016-04-06'),(22,303484343,1,'CASH',3,'2016-04-07'),(23,174142721,20,'CASH',13,'2016-04-05'),(24,819218239,19,'CASH',13,'2016-04-05'),(25,305015766,4,'CASH',5,'2016-04-07'),(26,837895138,10,'CASH',2,NULL),(27,712169779,16,'CREDIT',19,NULL),(28,631310235,20,'CREDIT',6,'2016-04-05'),(29,512375089,19,'CASH',19,'2016-04-05'),(30,953195818,1,'CREDIT',5,'2016-04-07'),(31,658923807,10,'CASH',13,NULL),(32,338018439,5,'CREDIT',20,'2016-04-07'),(33,213576952,12,'CREDIT',20,NULL),(34,449903518,4,'CASH',0,'2016-04-07'),(35,813187520,3,'CASH',19,'2016-04-07'),(36,783833750,11,'CASH',8,NULL),(37,342457130,17,'CASH',18,NULL),(38,185962992,13,'CASH',19,NULL),(39,891544960,22,'CASH',17,'2016-04-05'),(40,757478151,12,'CASH',3,NULL),(41,188994225,12,'CREDIT',6,NULL),(42,330916575,15,'CASH',2,NULL),(43,328574592,11,'CASH',17,NULL),(44,330959769,12,'CASH',9,NULL),(45,164594981,19,'CASH',1,'2016-04-05'),(46,341709841,18,'CREDIT',14,'2016-04-05'),(47,978293555,15,'CASH',0,NULL),(48,419825885,23,'CASH',9,'2016-04-05'),(49,600576298,6,'CASH',8,'2016-04-07'),(50,312707677,7,'CASH',4,'2016-04-07'),(51,298166976,5,'CASH',1,'2016-04-07'),(52,381010473,9,'CASH',15,'2016-04-05'),(53,981008565,9,'CASH',3,'2016-04-05'),(54,370022085,3,'CASH',7,'2016-04-07'),(55,165298031,24,'CREDIT',4,'2016-04-05'),(56,576556625,17,'CASH',20,NULL),(57,503077188,3,'CASH',2,'2016-04-07'),(58,836704410,24,'CASH',5,'2016-04-05'),(59,996714926,1,'CASH',20,'2016-04-07'),(60,757742814,24,'CREDIT',1,'2016-04-05'),(61,232571347,21,'CASH',15,'2016-04-05'),(62,862382883,17,'CREDIT',16,NULL),(63,932350153,11,'CREDIT',3,NULL),(64,640246625,4,'CREDIT',6,'2016-04-07'),(65,460786042,17,'CREDIT',17,NULL),(66,150663240,11,'CASH',4,NULL),(67,468421704,11,'CASH',3,NULL),(68,474122389,4,'CASH',9,'2016-04-07'),(69,754377033,7,'CASH',7,'2016-04-07'),(70,347556810,20,'CREDIT',3,'2016-04-05'),(71,741578675,11,'CASH',12,NULL),(72,661696307,21,'CASH',6,'2016-04-05'),(73,790024246,9,'CREDIT',7,'2016-04-05'),(74,245190503,24,'CASH',14,'2016-04-05'),(75,876157374,6,'CASH',18,'2016-04-07'),(76,138643514,20,'CREDIT',19,'2016-04-05'),(77,380524154,6,'CASH',10,'2016-04-07'),(78,687340391,18,'CREDIT',6,'2016-04-05'),(79,660257127,3,'CASH',6,'2016-04-07'),(80,559217271,16,'CREDIT',6,NULL),(81,964465566,24,'CREDIT',5,'2016-04-05'),(82,184735548,19,'CASH',2,'2016-04-05'),(83,765557004,8,'CASH',14,'2016-04-07'),(84,338563206,23,'CREDIT',11,'2016-04-05'),(85,718492371,21,'CREDIT',11,'2016-04-05'),(86,199780489,5,'CASH',4,'2016-04-07'),(87,277530072,19,'CASH',10,'2016-04-05'),(88,868692328,23,'CREDIT',17,'2016-04-05'),(89,643928321,1,'CREDIT',16,'2016-04-07'),(90,620744137,16,'CASH',1,NULL),(91,391055554,15,'CASH',8,NULL),(92,862008812,1,'CREDIT',5,'2016-04-07'),(93,720811197,23,'CASH',10,'2016-04-05'),(94,574410770,12,'CREDIT',16,NULL),(95,708381725,10,'CASH',13,NULL),(96,938926279,4,'CASH',0,'2016-04-07'),(97,658456951,22,'CASH',6,'2016-04-05'),(98,778135027,3,'CREDIT',11,'2016-04-07'),(99,863496664,11,'CASH',16,NULL),(100,657059910,11,'CASH',7,NULL);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_list`
--

DROP TABLE IF EXISTS `order_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `item_id` int(25) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `item` (`item_id`),
  CONSTRAINT `order_list_ibfk_3` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`),
  CONSTRAINT `order_list_ibfk_4` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1328 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_list`
--

LOCK TABLES `order_list` WRITE;
/*!40000 ALTER TABLE `order_list` DISABLE KEYS */;
INSERT INTO `order_list` (`id`, `order_id`, `item_id`, `quantity`) VALUES (552,1,4,4),(553,82,4,2),(554,42,5,3),(555,49,8,2),(556,50,2,1),(557,49,3,4),(558,19,3,5),(559,68,3,3),(560,1,6,1),(561,15,9,4),(562,68,3,3),(564,14,4,4),(565,15,5,2),(1002,62,2,4),(1005,17,9,2),(1006,66,9,1),(1008,4,10,2),(1009,76,10,5),(1010,83,9,5),(1011,24,6,5),(1012,28,9,4),(1013,1,9,4),(1014,88,10,4),(1015,21,2,3),(1017,52,4,5),(1018,14,8,5),(1023,28,3,3),(1024,46,5,3),(1025,49,5,2),(1026,39,6,3),(1027,84,2,4),(1029,79,9,3),(1030,92,5,2),(1033,84,6,2),(1035,67,2,3),(1036,57,6,2),(1037,68,10,4),(1038,56,5,5),(1039,37,10,2),(1041,55,4,5),(1042,33,9,4),(1044,64,5,1),(1045,23,5,5),(1046,46,2,4),(1047,23,2,4),(1048,89,4,1),(1049,80,4,4),(1050,97,10,5),(1052,98,5,1),(1053,84,5,2),(1054,28,9,1),(1274,62,2,4),(1277,17,9,2),(1278,66,9,1),(1280,4,10,2),(1281,76,10,5),(1282,83,9,5),(1283,24,6,5),(1284,28,9,4),(1285,1,9,4),(1286,88,10,4),(1287,21,2,3),(1289,52,4,5),(1290,14,8,5),(1295,28,3,3),(1296,46,5,3),(1297,49,5,2),(1298,39,6,3),(1299,84,2,4),(1301,79,9,3),(1302,92,5,2),(1305,84,6,2),(1307,67,2,3),(1308,57,6,2),(1309,68,10,4),(1310,56,5,5),(1311,37,10,2),(1313,55,4,5),(1314,33,9,4),(1316,64,5,1),(1317,23,5,5),(1318,46,2,4),(1319,23,2,4),(1320,89,4,1),(1321,80,4,4),(1322,97,10,5),(1324,98,5,1),(1325,84,5,2),(1326,28,9,1);
/*!40000 ALTER TABLE `order_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `presence`
--

DROP TABLE IF EXISTS `presence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `presence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `start_datetime` datetime(6) NOT NULL,
  `end_datetime` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `employee_id` (`employee_id`),
  KEY `employee_id_2` (`employee_id`),
  CONSTRAINT `presence_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presence`
--

LOCK TABLES `presence` WRITE;
/*!40000 ALTER TABLE `presence` DISABLE KEYS */;
INSERT INTO `presence` (`id`, `employee_id`, `start_datetime`, `end_datetime`) VALUES (1,1,'2016-04-07 09:00:00.000000','2016-04-07 16:00:00.000000'),(2,2,'2016-04-07 09:00:00.000000','2016-04-07 18:00:00.000000'),(3,3,'2016-04-07 09:16:00.000000','2016-04-07 12:00:00.000000'),(4,4,'2016-04-07 09:17:00.000000','2016-04-07 12:20:00.000000'),(5,5,'2016-04-07 09:00:00.000000','2016-04-07 19:08:00.000000'),(6,6,'2016-04-07 11:00:00.000000','2016-04-07 15:00:00.000000'),(7,7,'2016-04-07 09:08:00.000000','2016-04-07 12:03:00.000000'),(8,8,'2016-04-07 09:08:00.000000','2016-04-07 20:10:00.000000');
/*!40000 ALTER TABLE `presence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `vanilla`
--

DROP TABLE IF EXISTS `vanilla`;
/*!50001 DROP VIEW IF EXISTS `vanilla`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vanilla` (
  `view_id` tinyint NOT NULL,
  `member_name` tinyint NOT NULL,
  `card_number` tinyint NOT NULL,
  `order_id` tinyint NOT NULL,
  `item_name` tinyint NOT NULL,
  `cashier_id` tinyint NOT NULL,
  `employee_name` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `wifi_spoof`
--

DROP TABLE IF EXISTS `wifi_spoof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wifi_spoof` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) NOT NULL,
  `target` varchar(50) NOT NULL,
  `data` text NOT NULL,
  `size` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `wifi_spoof_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `wifi_user` (`member_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wifi_spoof`
--

LOCK TABLES `wifi_spoof` WRITE;
/*!40000 ALTER TABLE `wifi_spoof` DISABLE KEYS */;
INSERT INTO `wifi_spoof` (`id`, `member_id`, `target`, `data`, `size`) VALUES (1,401,'http://facebook.com','Read: Haloo. Kita mau ngumpul kapan nih buat ngomongin OHL lagi? Kamis atau Jumat bisa? Read: Ayo Read: Wah bangga… Read: Waduh ijin telat bimbingan dulu. Write: Yuk!',17),(3,401,'https://mail.google.com/mail/u/0/#inbox','Write: Bu, ini tugas untuk hari Jumat sudah selesai dibuat. [Attachment excluded] Read: Terima kasih, Tripo. Nanti saya cek.',3012),(4,402,'http://line.me/en/mrx','Read: Bagaimana? Write: Rasanya ingin kubunuh saja.',85),(5,401,'https://drive.google.com/drive/u/2/folders/0B0vTg1','[Attachment excluded] Write: Nih fotonya.',55690),(7,402,'https://mail.google.com/mail/u/0/#inbox','Read: Selamat, Anda telah memenangkan hadiah undian berhadiah sebesar 50 juta rupiah. [Attachment excluded] Write: HA HA THX',57),(8,402,'http://facebook.com/','Read: Gimana KP? Write: Masih belum tau mau pilih yang mana. Read: WAH!',67),(9,404,'https://www.spotify.com/','Write: Big Bang - Bang Bang Bang Write: Study Write: Relax',21897),(11,401,'http://basisdata.if.itb.ac.id/adaapa','Read: Jadi ada apa di basdat? Write: Hmm coba buka link nya',-1),(12,402,'http://facebook.com/groups/919175836128/','Read: Gimana buat tanggal 22 april? Write: Sudah siap bos ditunggu saja.',27);
/*!40000 ALTER TABLE `wifi_spoof` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wifi_user`
--

DROP TABLE IF EXISTS `wifi_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wifi_user` (
  `member_id` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`member_id`),
  KEY `id` (`member_id`),
  CONSTRAINT `wifi_user_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wifi_user`
--

LOCK TABLES `wifi_user` WRITE;
/*!40000 ALTER TABLE `wifi_user` DISABLE KEYS */;
INSERT INTO `wifi_user` (`member_id`, `username`, `password`) VALUES (401,'triposukatypo','5cde9aad32f032f6'),(402,'fickfiqie','30bed70aebaf7cbd'),(403,'jhanson2','KBCiDz'),(404,'mowens3','R0L6BSlNbkf'),(405,'dcole4','eD0NtD3Z5'),(406,'mkim5','ZU42SJ'),(407,'hwarren6','OEI0jW'),(408,'jcruz7','pbzmLmKSa6i'),(409,'cfuller8','STjLnwgO'),(410,'canderson9','tkcawNw0Ew0z'),(411,'sramosa','XVVxJw'),(412,'skennedyb','1tHMYLgfM'),(413,'sruizc','fOoGG2'),(414,'mbrownd','VhtNXiSSw3v'),(415,'cbishope','pzko8oMoCoTg'),(416,'jlewisf','tfglDq43D2'),(417,'jbrowng','qgOueQ'),(418,'bcolemanh','xWPtUI5h'),(419,'pgranti','OQNiqoR'),(420,'mlynchj','yYt3MjtLU2'),(421,'mblackk','U4Ad4cqEr6'),(422,'acarrl','otVVyA'),(423,'hpricem','ovp6TLVz2'),(424,'jandersonn','QtWkQe'),(425,'kpriceo','b3cLVlNB'),(426,'bhernandezp','o4lNFuTkvt0'),(427,'awatsonq','I7dZ7DNImW4Z'),(428,'lfordr','tpiS3wslGd96'),(429,'kgordons','7iopqYkzM4'),(430,'mandrewst','DTHoLYJClk'),(431,'dwilsonu','SYtcBI24ybNk'),(432,'hstanleyv','FAj1UQWmQCM'),(433,'tolsonw','6yfCR2e'),(434,'waustinx','COzBkRsW4Kd'),(435,'fdunny','rhvUo8MtJvu'),(436,'lmontgomeryz','rQVJibq'),(437,'sfuller10','xqwVib'),(438,'hmendoza11','yKYacR'),(439,'prodriguez12','KSs6gM'),(440,'kwilson13','BI0btq'),(441,'sferguson14','xhZJmbFESq'),(442,'calexander15','iMCx6C'),(443,'parmstrong16','E2sfHuMn'),(444,'sgonzales17','xR10n3'),(445,'mtaylor18','tfheJjm5rI'),(446,'khernandez19','0yFoBzNd5J'),(447,'apierce1a','K7omO0E'),(448,'showell1b','y6RjvYiQ'),(449,'wmitchell1c','krP6iF'),(450,'mgreene1d','EepW2O'),(451,'kwilliamson1e','Qp47ga980'),(452,'jwatson1f','uTlxz8xkW9b'),(453,'aarmstrong1g','ZCngJC'),(454,'tcox1h','AEqERM1Yhfl'),(455,'bmills1i','XyiXdkoPwssT'),(456,'madams1j','9v9tI1EHJD'),(457,'smitchell1k','9hErsDm'),(458,'cgonzales1l','yKuDqEaEKy'),(459,'jkim1m','TuN6qHsSui'),(460,'slarson1n','Q9mD47IlMfdX'),(461,'nlopez1o','NtlcWF'),(462,'kjackson1p','xI2vnDTqBoY'),(463,'rrichardson1q','mMxKjB'),(464,'wsimpson1r','tCPGYVPKr10N'),(465,'cpayne1s','b2rFBX'),(466,'dbutler1t','VeQDFVlwf0'),(467,'sbarnes1u','lo2sMV'),(468,'kcunningham1v','GbzJue1Y5UqR'),(469,'cburton1w','tL9Ryb5cGls'),(470,'bkelley1x','jPkQ5ihI'),(471,'rsimmons1y','5gDgyBYHvn'),(472,'hbarnes1z','ChtDpm'),(473,'mporter20','NPJ2VdaZl0'),(474,'adaniels21','TohD0i0ruJT'),(475,'jcunningham22','7BddFWbOWjK'),(476,'rparker23','1vkQIpKUE1s'),(477,'rray24','IFbmXhzwfb'),(478,'lreynolds25','nd59Ys'),(479,'jchavez26','4zsMa2Km'),(480,'hward27','8dLZoT76gYwB'),(481,'sjackson28','TV4aDaKeH3qN'),(482,'dfrazier29','JLeVY6qZ'),(483,'mwilson2a','I2vmHLEtW2'),(484,'plewis2b','0Nxmf4AIAIs'),(485,'tmartinez2c','9RfhHvBs'),(486,'wlynch2d','se3b4ntpYKm'),(487,'dmyers2e','7mcieWV34Zl'),(488,'knichols2f','60hjDBbp5'),(489,'skelley2g','eu7TNHBp'),(490,'mburke2h','4tOVuBYUSvW'),(491,'rshaw2i','hHSfioa5baUH'),(492,'bmartinez2j','RV0b1CuAXGX'),(493,'jjacobs2k','DUG3YIc'),(494,'jtorres2l','Oma9uW7ygkeQ'),(495,'lphillips2m','d67tNR'),(496,'rjenkins2n','IFF3Xnt'),(497,'roliver2o','ZSjMvPY2w'),(498,'rdaniels2p','YcOjfcVocgM'),(499,'eolson2q','u2unlYEDOg4o'),(500,'bpierce2r','Ebzqd1');
/*!40000 ALTER TABLE `wifi_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `barokah_cafe`
--

USE `barokah_cafe`;

--
-- Final view structure for view `brazillian`
--

/*!50001 DROP TABLE IF EXISTS `brazillian`*/;
/*!50001 DROP VIEW IF EXISTS `brazillian`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `brazillian` AS (select `m`.`member_id` AS `member_id`,`m`.`member_name` AS `nome`,`m`.`gender` AS `gender`,`m`.`card_number` AS `card_number`,`mc`.`balance` AS `saldo` from (`member` `m` join `member_card` `mc` on(`m`.`card_number` = `mc`.`card_number`)) where `m`.`nationality` like 'Brazil' and `mc`.`point` > 50) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vanilla`
--

/*!50001 DROP TABLE IF EXISTS `vanilla`*/;
/*!50001 DROP VIEW IF EXISTS `vanilla`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vanilla` AS (select `ol`.`id` AS `view_id`,`m`.`member_name` AS `member_name`,`o`.`card_number` AS `card_number`,`o`.`order_id` AS `order_id`,`i`.`item_name` AS `item_name`,`o`.`cashier_id` AS `cashier_id`,`e`.`employee_name` AS `employee_name` from ((((`order_list` `ol` join `order` `o` on(`ol`.`order_id` = `o`.`order_id`)) join `item` `i` on(`ol`.`item_id` = `i`.`id`)) join (`member` `m` join `member_card` `mc` on(`m`.`card_number` = `mc`.`card_number`))) join `employee` `e`) where `o`.`cashier_id` = `e`.`id` and `o`.`card_number` = `mc`.`card_number` and `i`.`item_name` like 'Vanilla %' and `e`.`gender` like 'Female') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-11 18:01:03
