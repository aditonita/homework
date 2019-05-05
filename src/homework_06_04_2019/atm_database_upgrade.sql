/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for atm
DROP DATABASE IF EXISTS `atm`;
CREATE DATABASE IF NOT EXISTS `atm` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `atm`;

-- Dumping structure for table atm.clients
DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `client_id` varchar(13) NOT NULL,
  `client_name` varchar(100) NOT NULL,
  `client_address` varchar(100) NOT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table atm.clients
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` (`client_id`, `client_name`, `client_address`) VALUES
	('1700101001002', 'Test,Client', 'str. Masked 1B, Masked City'),
	('1720807001003', 'Adi,Tonita', 'str. Primaverii 101, Bucuresti'),
	('1720823001003', 'Adi,Tonita', 'str. Primaverii 102, Bucuresti'),
	('2750930002004', 'Veronica,Ionescu', 'str. Carol 23, Iasi');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;

-- Dumping structure for table movie.acounts
DROP TABLE IF EXISTS `acounts`;
CREATE TABLE IF NOT EXISTS `acounts` (
  `account_id` int(11) not null,
  `client_id` varchar(13) NOT NULL,
  `account_number` varchar(100) NOT NULL,
  `amount` DOUBLE NOT NULL,
  `active` boolean not null,
  PRIMARY KEY (`account_id`),
  CONSTRAINT `acounts_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table atm.acounts
/*!40000 ALTER TABLE `acounts` DISABLE KEYS */;
INSERT INTO `acounts` (`account_id`, `client_id`, `account_number`, `amount`, `active`) VALUES
	(1, '1700101001002', 'R000TEST00U000000TTxx', 2.35, true),
	(2, '1720807001003', 'RO32BTRL00U78456TAA0000', 10, true),
	(3, '1720807001003', 'RO32BTRL00U45790TAA0000', 4.50, true),
	(4, '2750930002004', 'RO57INGB00896578xx', 12, true),
	(5, '2750930002004', 'RO57INGB00234534xx', 25.45, true);
/*!40000 ALTER TABLE `acounts` ENABLE KEYS */;

-- Dumping structure for table atm.cards_info
DROP TABLE IF EXISTS `cards_info`;
CREATE TABLE IF NOT EXISTS `cards_info` (
  `card_id` int(11) NOT NULL auto_increment,
  `acount_id` int(11) not null,
  `card_number` varchar(100) NOT NULL,
  `card_pin` varchar(100) NOT NULL,
  `active` boolean not null,
  PRIMARY KEY (`card_id`),
  CONSTRAINT `cards_ibfk_1` FOREIGN KEY (`acount_id`) REFERENCES `acounts` (`account_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table atm.cards_info
/*!40000 ALTER TABLE `cards_info` DISABLE KEYS */;
INSERT INTO `cards_info` (`acount_id`, `card_number`, `card_pin`, `active`) VALUES
	(1, '0000000000000000', '0000', true),
	(1, '1234567812345678', '1234', true),
	(2, '9876123498761234', '2000', true),
	(2, '1001100110011001', '9987', true),
	(3, '1212232345455656', '9987', true),
	(4, '8765432187654321', '1234', true),
	(5, '8765432187651234', '1234', true),
	(5, '8765432187654567', '1234', true);
/*!40000 ALTER TABLE `cards_info` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
