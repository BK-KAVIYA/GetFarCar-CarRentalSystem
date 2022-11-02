-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 31, 2022 at 07:12 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `getfarcars`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `ID` varchar(10) NOT NULL,
  `Fname` varchar(100) NOT NULL,
  `Lname` varchar(100) NOT NULL,
  `Line1` varchar(100) NOT NULL,
  `Line2` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Telephone` int(11) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `NIC` varchar(15) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`ID`, `Fname`, `Lname`, `Line1`, `Line2`, `City`, `Gender`, `Telephone`, `Email`, `NIC`) VALUES
('Ad001', 'Sanjeewa ', 'Bandara', 'No.117', 'New town', 'Bandarawela.', 'Male', 715698436, 'sanjeewa@gmail.com', ' 992670657v '),
('Ad002', 'Koshika ', 'Dulanjana', 'No.315', 'waththe mawatha', 'Horana.', 'Male', 789854651, 'koshika@gmail.com', ' 657894152v ');

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
CREATE TABLE IF NOT EXISTS `booking` (
  `B_ID` varchar(10) NOT NULL,
  `Start_Date` date NOT NULL,
  `End_date` date NOT NULL,
  `Status` varchar(50) NOT NULL,
  `Deposite` int(10) NOT NULL,
  `Cus_ID` varchar(10) NOT NULL,
  `Car_ID` varchar(10) NOT NULL,
  `Dri_ID` varchar(10) NOT NULL,
  `Admin_ID` varchar(10) NOT NULL,
  PRIMARY KEY (`B_ID`),
  KEY `Cus_ID` (`Cus_ID`),
  KEY `Car_ID` (`Car_ID`),
  KEY `Dri_ID` (`Dri_ID`),
  KEY `Admin_ID` (`Admin_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`B_ID`, `Start_Date`, `End_date`, `Status`, `Deposite`, `Cus_ID`, `Car_ID`, `Dri_ID`, `Admin_ID`) VALUES
('B0001', '2022-10-22', '2022-10-23', 'T', 2000, 'Cus001', 'C0001', 'D0001', 'Ad001'),
('B0002', '2022-10-20', '2022-10-22', 'T', 4000, 'Cus002', 'C0002', 'D0002', 'Ad001'),
('aaaa', '2022-05-06', '2021-04-05', 'Pending', 5000, '4562', 'c001', 'aaa', 'Ad001'),
('01', '2022-10-05', '2022-10-20', 'Pending', 500, 'c01', 'c01', 'd01', 'a01');

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
CREATE TABLE IF NOT EXISTS `car` (
  `Car_ID` varchar(10) NOT NULL,
  `Cname` varchar(50) NOT NULL,
  `Car_type` varchar(50) NOT NULL,
  `Status` varchar(20) NOT NULL,
  `Price` int(10) NOT NULL,
  `No_of_seat` int(10) NOT NULL,
  `Number_Plate` varchar(100) NOT NULL,
  `Fuel_Type` varchar(100) NOT NULL,
  PRIMARY KEY (`Car_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`Car_ID`, `Cname`, `Car_type`, `Status`, `Price`, `No_of_seat`, `Number_Plate`, `Fuel_Type`) VALUES
('C0001', 'Car001', 'Wagan R', 'T', 4500, 4, 'CP CAZ 0284', 'Petrol'),
('C0002', 'Car002', 'Alto LXI', 'T', 4000, 5, 'WP CAK 3424', 'Petrol'),
('C0003', 'Car003', 'Premio', 'T', 6500, 4, 'SG KQ 4556', 'Petrol'),
('C0004', 'Car004', 'Allion', 'T', 6000, 4, 'WP KI 5885', 'Petrol'),
('C0005', 'Car005', 'Honda Grace', 'T', 6000, 4, 'WP CAC 3665', 'Petrol'),
('C0006', 'Car006', 'Prius', 'T', 6000, 4, 'WP CAC 1525', 'Petrol'),
('C0015', 'Car0054', 'Prsdf', 'T', 333, 5, 'we dfv 3456', 'Diesel');

-- --------------------------------------------------------

--
-- Table structure for table `caravailability`
--

DROP TABLE IF EXISTS `caravailability`;
CREATE TABLE IF NOT EXISTS `caravailability` (
  `Car_ID` varchar(10) NOT NULL,
  `Number_Of_Cars` int(5) NOT NULL,
  `Available_Cars` int(5) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `caravailability`
--

INSERT INTO `caravailability` (`Car_ID`, `Number_Of_Cars`, `Available_Cars`) VALUES
('C0001', 10, 5),
('C0002', 15, 7);

-- --------------------------------------------------------

--
-- Table structure for table `checkout`
--

DROP TABLE IF EXISTS `checkout`;
CREATE TABLE IF NOT EXISTS `checkout` (
  `Check_ID` int(10) NOT NULL AUTO_INCREMENT,
  `Amount` int(100) NOT NULL,
  `Date` date NOT NULL,
  `Cus_ID` varchar(10) NOT NULL,
  `Admin_ID` varchar(10) NOT NULL,
  `B_ID` varchar(20) NOT NULL,
  PRIMARY KEY (`Check_ID`),
  KEY `Cus_ID` (`Cus_ID`),
  KEY `Admin_ID` (`Admin_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `checkout`
--

INSERT INTO `checkout` (`Check_ID`, `Amount`, `Date`, `Cus_ID`, `Admin_ID`, `B_ID`) VALUES
(1, 4500, '2022-10-24', 'Cus001', 'Ad001', 'B0001'),
(2, 9000, '2022-10-23', 'Cus002', 'Ad001', 'B0002');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `ID` varchar(10) NOT NULL,
  `Fname` varchar(100) NOT NULL,
  `Lname` varchar(100) NOT NULL,
  `Line1` varchar(100) NOT NULL,
  `Line2` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Telephone` int(11) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `NIC` varchar(15) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`ID`, `Fname`, `Lname`, `Line1`, `Line2`, `City`, `Gender`, `Telephone`, `Email`, `NIC`) VALUES
('Cus001', 'Sanjeewa ', 'Bandara', 'No.117', 'New town', 'Bandarawela.', 'Male', 715698436, 'sanjeewa@gmail.com', ' 992670657v '),
('Cus002', 'Koshika ', 'Dulanjana', 'No.315', 'waththe mawatha', 'Horana.', 'Male', 789854651, 'koshika@gmail.com', ' 657894152v ');

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
CREATE TABLE IF NOT EXISTS `driver` (
  `ID` varchar(10) NOT NULL,
  `Fname` varchar(50) NOT NULL,
  `Lname` varchar(50) NOT NULL,
  `Line1` varchar(50) NOT NULL,
  `Line2` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `Gender` varchar(11) NOT NULL,
  `Telephone` int(11) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `NIC` varchar(15) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`ID`, `Fname`, `Lname`, `Line1`, `Line2`, `City`, `Gender`, `Telephone`, `Email`, `NIC`) VALUES
('D0001', 'Akila ', 'Dananjaya', 'No.52', 'Watareka Road', 'Piliyandala', 'Male', 758469871, 'akila@gmail.com', '992670657V'),
('D0002', 'Bhanuka ', 'Rajapakshe', 'No.315/1', 'Polgashowita', 'Colombo', 'Male', 773216542, 'bhanuka@gmail.com', '992670657V'),
('D003', 'dcd', 'deed', 'deed', 'deded', 'cddccd', 'Male', 1646, 'rfef', 'deded');

-- --------------------------------------------------------

--
-- Table structure for table `maintance`
--

DROP TABLE IF EXISTS `maintance`;
CREATE TABLE IF NOT EXISTS `maintance` (
  `M_ID` varchar(10) NOT NULL,
  `Reason` varchar(50) NOT NULL,
  `Parts` varchar(50) NOT NULL,
  `Cost` int(10) NOT NULL,
  `Car_ID` varchar(10) NOT NULL,
  `Invoice_no` int(11) NOT NULL,
  PRIMARY KEY (`M_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `maintance`
--

INSERT INTO `maintance` (`M_ID`, `Reason`, `Parts`, `Cost`, `Car_ID`, `Invoice_no`) VALUES
('M0001', 'Engine Repair', 'Piston', 10000, 'C0001', 1234),
('M0002', 'Patch', 'Tire', 4520, 'C0001', 456);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `ID` varchar(10) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Role` int(1) NOT NULL,
  `user_id` varchar(10) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `user_id` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ID`, `Password`, `Role`, `user_id`) VALUES
('1', '1234', 1, 'Ad001'),
('2', '1234', 3, 'Cus001'),
('D005', '123', 2, 'D005');

-- --------------------------------------------------------

--
-- Table structure for table `userrolle`
--

DROP TABLE IF EXISTS `userrolle`;
CREATE TABLE IF NOT EXISTS `userrolle` (
  `UserRolleID` int(20) NOT NULL,
  `UserType` varchar(20) NOT NULL,
  PRIMARY KEY (`UserRolleID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userrolle`
--

INSERT INTO `userrolle` (`UserRolleID`, `UserType`) VALUES
(1, 'admin'),
(2, 'driver'),
(3, 'customer');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
