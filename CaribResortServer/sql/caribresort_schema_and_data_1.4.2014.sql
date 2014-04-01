-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 01, 2014 at 02:34 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `caribresort`
--
CREATE DATABASE IF NOT EXISTS `caribresort` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `caribresort`;

-- --------------------------------------------------------

--
-- Table structure for table `armband`
--

CREATE TABLE IF NOT EXISTS `armband` (
  `armBandId` int(11) NOT NULL AUTO_INCREMENT,
  `armBandName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`armBandId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `armband`
--

INSERT INTO `armband` (`armBandId`, `armBandName`) VALUES
(1, 'yellow'),
(2, 'orange');

-- --------------------------------------------------------

--
-- Table structure for table `customerorder`
--

CREATE TABLE IF NOT EXISTS `customerorder` (
  `customerOrderId` int(11) NOT NULL AUTO_INCREMENT,
  `guestId` int(11) DEFAULT NULL,
  `orderDate` datetime DEFAULT NULL,
  `servedby` int(11) DEFAULT NULL,
  PRIMARY KEY (`customerOrderId`),
  KEY `guestId` (`guestId`),
  KEY `servedby` (`servedby`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `customerorder`
--

INSERT INTO `customerorder` (`customerOrderId`, `guestId`, `orderDate`, `servedby`) VALUES
(1, 1, '2014-04-01 00:00:00', NULL),
(2, 2, '2014-04-01 00:00:00', NULL),
(3, 2, '2014-04-02 00:00:00', NULL),
(4, 2, '2014-04-03 00:00:00', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `customerorderitem`
--

CREATE TABLE IF NOT EXISTS `customerorderitem` (
  `customerOrderItemId` int(11) NOT NULL AUTO_INCREMENT,
  `customerOrderId` int(11) DEFAULT NULL,
  `drinkId` int(11) DEFAULT NULL,
  `orderQuantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`customerOrderItemId`),
  KEY `customerOrderId` (`customerOrderId`),
  KEY `drinkId` (`drinkId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `customerorderitem`
--

INSERT INTO `customerorderitem` (`customerOrderItemId`, `customerOrderId`, `drinkId`, `orderQuantity`) VALUES
(1, 1, 2, 3),
(2, 1, 2, 7),
(3, 2, 1, 9),
(4, 2, 4, 1),
(5, 3, 4, 5),
(6, 3, 2, 2),
(7, 4, 1, 12),
(8, 4, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `drink`
--

CREATE TABLE IF NOT EXISTS `drink` (
  `drinkId` int(11) NOT NULL AUTO_INCREMENT,
  `drinkName` varchar(100) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `drinkTypeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`drinkId`),
  KEY `drinkTypeId` (`drinkTypeId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `drink`
--

INSERT INTO `drink` (`drinkId`, `drinkName`, `createdDate`, `drinkTypeId`) VALUES
(1, 'smirnoff', '2014-04-09 00:00:00', 1),
(2, 'orange juice', '2014-04-09 00:00:00', 2),
(3, 'red stripe', '2014-04-01 01:19:07', 1),
(4, 'guinness', '2014-04-01 01:49:15', 1);

-- --------------------------------------------------------

--
-- Table structure for table `drinktype`
--

CREATE TABLE IF NOT EXISTS `drinktype` (
  `drinkTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `drinkTypeName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`drinkTypeId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `drinktype`
--

INSERT INTO `drinktype` (`drinkTypeId`, `drinkTypeName`) VALUES
(1, 'alcoholic'),
(2, 'non-alcoholic');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `employeeId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(100) DEFAULT NULL,
  `lastName` varchar(100) DEFAULT NULL,
  `userName` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `dateOfBirth` datetime DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastLoginDate` datetime DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`employeeId`),
  UNIQUE KEY `email` (`email`),
  KEY `roleId` (`roleId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employeeId`, `firstName`, `lastName`, `userName`, `password`, `email`, `dateOfBirth`, `createdDate`, `lastLoginDate`, `roleId`) VALUES
(1, 'Keric', 'Mcdonald', 'keric', '123456', 'keric@hotmail.com', '2013-12-03 00:00:00', '2013-12-03 00:00:00', '2013-12-03 00:00:00', 1),
(2, 'Luke', 'Mollahand', 'luke', '123456', 'luke@hotmail.com', '2013-12-03 00:00:00', '2013-12-03 00:00:00', '2013-12-03 00:00:00', 2);

-- --------------------------------------------------------

--
-- Table structure for table `guest`
--

CREATE TABLE IF NOT EXISTS `guest` (
  `guestId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(100) DEFAULT NULL,
  `lastName` varchar(100) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `dateOfBirth` datetime DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastLoginDate` datetime DEFAULT NULL,
  `armBandId` int(11) DEFAULT NULL,
  PRIMARY KEY (`guestId`),
  UNIQUE KEY `email` (`email`),
  KEY `armBandId` (`armBandId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `guest`
--

INSERT INTO `guest` (`guestId`, `firstName`, `lastName`, `email`, `dateOfBirth`, `createdDate`, `lastLoginDate`, `armBandId`) VALUES
(1, 'minor', NULL, NULL, NULL, NULL, NULL, 1),
(2, 'adult', NULL, NULL, NULL, NULL, NULL, 2);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`roleId`, `roleName`) VALUES
(1, 'Manager'),
(2, 'Bartender');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customerorder`
--
ALTER TABLE `customerorder`
  ADD CONSTRAINT `customerorder_ibfk_1` FOREIGN KEY (`guestId`) REFERENCES `guest` (`guestId`),
  ADD CONSTRAINT `customerorder_ibfk_2` FOREIGN KEY (`servedby`) REFERENCES `employee` (`employeeId`);

--
-- Constraints for table `customerorderitem`
--
ALTER TABLE `customerorderitem`
  ADD CONSTRAINT `customerorderitem_ibfk_1` FOREIGN KEY (`customerOrderId`) REFERENCES `customerorder` (`customerOrderId`),
  ADD CONSTRAINT `customerorderitem_ibfk_2` FOREIGN KEY (`drinkId`) REFERENCES `drink` (`drinkId`);

--
-- Constraints for table `drink`
--
ALTER TABLE `drink`
  ADD CONSTRAINT `drink_ibfk_1` FOREIGN KEY (`drinkTypeId`) REFERENCES `drinktype` (`drinkTypeId`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`);

--
-- Constraints for table `guest`
--
ALTER TABLE `guest`
  ADD CONSTRAINT `guest_ibfk_1` FOREIGN KEY (`armBandId`) REFERENCES `armband` (`armBandId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
