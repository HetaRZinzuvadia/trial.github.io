-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 17, 2017 at 07:47 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pgh`
--

-- --------------------------------------------------------

--
-- Table structure for table `grocery`
--

CREATE TABLE `grocery` (
  `Area_ID` int(20) NOT NULL,
  `Gos_ID` int(20) NOT NULL,
  `Gos_Name` varchar(50) NOT NULL,
  `Gos_Address` varchar(50) NOT NULL,
  `Area1` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grocery`
--

INSERT INTO `grocery` (`Area_ID`, `Gos_ID`, `Gos_Name`, `Gos_Address`, `Area1`) VALUES
(1, 1, 'promod prov. store.', 'behind bob bank,atlanatic tower', 'Gorwa'),
(1, 2, 'Santi prov. store.', 'Nr. Lisa park .soc', 'SubhanaPura'),
(1, 3, 'Spencer Daily', 'Nr urmi soc,bpc road', 'Alkapuri'),
(1, 4, 'MahaLaxmi Pro. ', '1-2,shetal apr. R C Dutt road', 'Alkapuri'),
(1, 5, 'Mahesh Super Market', 'Santkrupa apr.', 'Akota'),
(1, 6, 'Banasal super market', '8,pranam complex', 'Akota'),
(1, 7, 'Rudrakasha Super Market', 'Devpushpa complex', 'Manjalpur'),
(1, 8, 'Jay provision store', '26,dream land complex', 'Manjalpur'),
(1, 9, 'Hyper City', 'Inrobit Mall', 'Gorwa'),
(1, 10, 'New Ganesh Super Markert', '6,Madresh complex ', 'Gorwa');

-- --------------------------------------------------------

--
-- Table structure for table `order_table`
--

CREATE TABLE `order_table` (
  `Order_ID` int(3) NOT NULL,
  `Property_ID` int(3) NOT NULL,
  `Email_ID` varchar(50) NOT NULL,
  `Food_ID` int(3) NOT NULL,
  `Water_ID` int(3) NOT NULL,
  `Taxi_ID` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_table`
--

INSERT INTO `order_table` (`Order_ID`, `Property_ID`, `Email_ID`, `Food_ID`, `Water_ID`, `Taxi_ID`) VALUES
(1, 3, 'heta@gmail.com', 0, 0, 0),
(9, 0, 'heta@gmail.com', 1, 0, 0),
(11, 0, 'heta@gmail.com', 0, 2, 0),
(12, 2, 'heta@gmail.com', 0, 0, 0),
(13, 0, 'heta@gmail.com', 1, 0, 0),
(14, 0, 'heta@gmail.com', 0, 1, 0),
(15, 0, 'heta@gmail.com', 1, 0, 0),
(16, 5, 'heta@gmail.com', 0, 0, 0),
(17, 3, 'heta@gmail.com', 0, 0, 0),
(18, 3, 'heta@gmail.com', 0, 0, 0),
(19, 0, 'heta@gmail.com', 0, 0, 0),
(20, 0, 'heta@gmail.com', 0, 0, 0),
(21, 0, 'heta@gmail.com', 0, 0, 0),
(22, 4, 'heta@gmail.com', 0, 0, 0),
(23, 0, 'heta@gmail.com', 2, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `pharmcy`
--

CREATE TABLE `pharmcy` (
  `Area_ID` int(20) NOT NULL,
  `Pha_ID` int(20) NOT NULL,
  `Pha_Name` varchar(50) NOT NULL,
  `Pha_Address` varchar(50) NOT NULL,
  `Area1` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pharmcy`
--

INSERT INTO `pharmcy` (`Area_ID`, `Pha_ID`, `Pha_Name`, `Pha_Address`, `Area1`) VALUES
(1, 1, 'Shree medicine ', 'Akot ground,bh tulsi tower', 'Alkapuri'),
(1, 2, 'Vidhya Medicine Store', 'Kala vati char rasta,', 'Akota'),
(1, 3, 'Doctor Pharma', '3,darpan Apratment ,R C DUTT road', 'Alkapuri'),
(1, 4, 'Vedant Phramcy', 'GF-19,Shrejee Complex Rc dutt road', 'Alkapuri'),
(1, 5, 'Apollo Pharmcy', 'G-1,Pursharth Avenu ', 'Akota'),
(1, 6, 'Sun Pharma ', 'Nr R C PATEL estate', 'Akota'),
(1, 7, 'Sheetal pharmcy', 'silver ork complex', 'Manjalpur'),
(1, 8, 'Bansi Chemist', 'E-9,vikundham apt', 'Manjalpur');

-- --------------------------------------------------------

--
-- Table structure for table `restaurant`
--

CREATE TABLE `restaurant` (
  `Area_ID` int(20) NOT NULL,
  `Res_ID` int(20) NOT NULL,
  `Res_Name` varchar(50) NOT NULL,
  `Res_Address` varchar(50) NOT NULL,
  `Area1` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `restaurant`
--

INSERT INTO `restaurant` (`Area_ID`, `Res_ID`, `Res_Name`, `Res_Address`, `Area1`) VALUES
(1, 1, 'Barbeque Nation', 'Shreem Shalini Mall , 3rd Floor. Vadodara', 'Alkapuri'),
(1, 2, 'Little Italy', 'Shop 11,11 , Arun Complex , Vadodara', 'Alkapuri'),
(2, 3, 'Alka res.', 'Natubhai circle,nr lalita tower', 'SubhanPura'),
(1, 4, 'Little Italy', 'Shop 43, Arun Complex .', 'Alkapuri'),
(1, 5, 'Lazeez', 'Vishal Chamber,34,RC dutt Road', 'Alkapuri'),
(1, 6, 'South Indian Restauran', 'NBCC Plaza,Nr L&T Circle', 'KareliBaug'),
(1, 7, 'Pizza Bell', 'opp. gorwardhan complex', 'KareliBaug'),
(1, 8, 'Kuality Food', 'Shree Krishna Appartment, Pani Tanki Rd', 'KareliBaug'),
(1, 9, 'Saffron', 'Indresprath complex', 'Akota');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_area`
--

CREATE TABLE `tbl_area` (
  `Area_ID` int(11) NOT NULL,
  `Area_Name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_area`
--

INSERT INTO `tbl_area` (`Area_ID`, `Area_Name`) VALUES
(1, 'Alkapuri'),
(2, 'Karelibaug'),
(3, 'Gorva'),
(4, 'Mandvi'),
(5, 'Makarpura'),
(6, 'Manjalpur');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_food_adv`
--

CREATE TABLE `tbl_food_adv` (
  `Food_ID` int(11) NOT NULL,
  `User_ID` varchar(4) NOT NULL,
  `Title` varchar(30) NOT NULL,
  `Description` varchar(100) NOT NULL,
  `Type` varchar(100) NOT NULL,
  `Area` varchar(4) NOT NULL,
  `Rate` varchar(5) NOT NULL,
  `Contact` varchar(10) NOT NULL,
  `Status` varchar(10) NOT NULL,
  `Image1` varchar(100) NOT NULL,
  `Image2` varchar(100) NOT NULL,
  `Image3` varchar(100) NOT NULL,
  `Image4` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_food_adv`
--

INSERT INTO `tbl_food_adv` (`Food_ID`, `User_ID`, `Title`, `Description`, `Type`, `Area`, `Rate`, `Contact`, `Status`, `Image1`, `Image2`, `Image3`, `Image4`) VALUES
(1, '2', 'Gujarati Thali', 'Unlimited Thali  with one sweet', 'Daily', '1', '60', '9878909989', 'Active', 'upload/food/f3.png', 'upload/food/f4.png', '', ''),
(2, '6', 'Priya tiffen service', 'door step delivery !', 'Daily', '2', '40', '7851678156', 'Active', 'upload/food/f2.png', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_food_order`
--

CREATE TABLE `tbl_food_order` (
  `Food_Order_ID` int(11) NOT NULL,
  `Adv_ID` varchar(4) NOT NULL,
  `User_ID` varchar(4) NOT NULL,
  `Owner_ID` varchar(4) NOT NULL,
  `Order_Date` varchar(20) NOT NULL,
  `Order_Time` varchar(20) NOT NULL,
  `Order_Address` varchar(60) NOT NULL,
  `Status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_food_order`
--

INSERT INTO `tbl_food_order` (`Food_Order_ID`, `Adv_ID`, `User_ID`, `Owner_ID`, `Order_Date`, `Order_Time`, `Order_Address`, `Status`) VALUES
(9, '2', '3', '6', 'so', 'so', 'so', ''),
(10, '2', '3', '6', 'an', 'an', 'an', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_food_pac`
--

CREATE TABLE `tbl_food_pac` (
  `FPac_ID` int(3) NOT NULL,
  `title` varchar(15) NOT NULL,
  `service` varchar(15) NOT NULL,
  `rate` int(3) NOT NULL,
  `number` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_food_pac`
--

INSERT INTO `tbl_food_pac` (`FPac_ID`, `title`, `service`, `rate`, `number`) VALUES
(1, 'nabtha', 'ajsn', 12, '14'),
(2, 'hello', 'monthly', 300, '9824160051');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_property_adv`
--

CREATE TABLE `tbl_property_adv` (
  `Property_ID` int(11) NOT NULL,
  `User_ID` varchar(4) NOT NULL,
  `Title` varchar(30) NOT NULL,
  `Description` varchar(100) NOT NULL,
  `Facility` varchar(100) NOT NULL,
  `Area` varchar(4) NOT NULL,
  `Rent` varchar(5) NOT NULL,
  `Contact` varchar(10) NOT NULL,
  `Status` varchar(10) NOT NULL,
  `Image1` varchar(100) NOT NULL,
  `Image2` varchar(100) NOT NULL,
  `Image3` varchar(100) NOT NULL,
  `Image4` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_property_adv`
--

INSERT INTO `tbl_property_adv` (`Property_ID`, `User_ID`, `Title`, `Description`, `Facility`, `Area`, `Rent`, `Contact`, `Status`, `Image1`, `Image2`, `Image3`, `Image4`) VALUES
(1, '2', 'Flat On Rent', 'Nice Condition', 'Lift and parking available', '1', '6000', '9898009890', 'Active', 'upload/property/p2.png', 'upload/property/p5.png', '', ''),
(2, '2', 'Flat On Rent', 'Nice Codition', 'Lift Parking', '1', '5000', '9876567765', 'Active', 'upload/property/p4.png', '', '', ''),
(3, '5', 'Room in rent', 'perfect in condition', '24*7 water service', '5', '3500', '9628156789', 'Active', 'upload/property/p4.png', 'upload/property/p1.png', '', ''),
(4, '2', 'flat', 'freee', 'water', '1', '10', '7815791567', 'Active', '', '', '', ''),
(5, '2', 'ew', 'de', 'ds', '1', '100', '937383', 'Image', '', '', '', ''),
(6, '6', 'd', 'd', 'd', '1', 'f', 'd', 'Active', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_taxi_images`
--

CREATE TABLE `tbl_taxi_images` (
  `Entry_ID` int(11) NOT NULL,
  `Taxi_ID` varchar(40) NOT NULL,
  `Type1_1` varchar(100) NOT NULL,
  `Type1_2` varchar(100) NOT NULL,
  `Type1_3` varchar(100) NOT NULL,
  `Type1_4` varchar(100) NOT NULL,
  `Type2_1` varchar(100) NOT NULL,
  `Type2_2` varchar(100) NOT NULL,
  `Type2_3` varchar(100) NOT NULL,
  `Type2_4` varchar(100) NOT NULL,
  `Type3_1` varchar(100) NOT NULL,
  `Type3_2` varchar(100) NOT NULL,
  `Type3_3` varchar(100) NOT NULL,
  `Type3_4` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_taxi_images`
--

INSERT INTO `tbl_taxi_images` (`Entry_ID`, `Taxi_ID`, `Type1_1`, `Type1_2`, `Type1_3`, `Type1_4`, `Type2_1`, `Type2_2`, `Type2_3`, `Type2_4`, `Type3_1`, `Type3_2`, `Type3_3`, `Type3_4`) VALUES
(1, '1', 'upload/taxi/IMG_20170114_094415.jpg', '', '', '', 'upload/taxi/IMG_20170114_094415.jpg', '', '', '', 'upload/taxi/t3.png', '', '', ''),
(2, '4', 'upload/taxi/t2.png', '', '', '', '', '', '', '', 'upload/taxi/t3.png', '', '', ''),
(3, '7', '', '', '', '', '', '', '', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_taxi_order`
--

CREATE TABLE `tbl_taxi_order` (
  `TaxiOrder_ID` int(3) NOT NULL,
  `Taxi_ID` int(3) NOT NULL,
  `User_ID` varchar(50) NOT NULL,
  `Type` varchar(10) NOT NULL,
  `Capacity` varchar(20) NOT NULL,
  `Order_Date` varchar(10) NOT NULL,
  `Order_Time` varchar(10) NOT NULL,
  `Order_Address` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_taxi_order`
--

INSERT INTO `tbl_taxi_order` (`TaxiOrder_ID`, `Taxi_ID`, `User_ID`, `Type`, `Capacity`, `Order_Date`, `Order_Time`, `Order_Address`) VALUES
(18, 1, '3', 'AC', 'Upto 4 people', 'so', 'do', 'do');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_taxi_rate`
--

CREATE TABLE `tbl_taxi_rate` (
  `Entry_ID` int(11) NOT NULL,
  `Taxi_ID` varchar(10) NOT NULL,
  `Type1` varchar(10) NOT NULL,
  `Type1_AC` varchar(10) NOT NULL,
  `Type1_AC_Rate` varchar(10) NOT NULL,
  `Type1_NonAC` varchar(10) NOT NULL,
  `Type1_NonAC_Rate` varchar(10) NOT NULL,
  `Type2` varchar(10) NOT NULL,
  `Type2_AC` varchar(10) NOT NULL,
  `Type2_AC_Rate` varchar(10) NOT NULL,
  `Type2_NonAC` varchar(10) NOT NULL,
  `Type2_NonAC_Rate` varchar(10) NOT NULL,
  `Type3` varchar(10) NOT NULL,
  `Type3_AC` varchar(10) NOT NULL,
  `Type3_AC_Rate` varchar(10) NOT NULL,
  `Type3_NonAC` varchar(10) NOT NULL,
  `Type3_NonAC_Rate` varchar(10) NOT NULL,
  `Status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_taxi_rate`
--

INSERT INTO `tbl_taxi_rate` (`Entry_ID`, `Taxi_ID`, `Type1`, `Type1_AC`, `Type1_AC_Rate`, `Type1_NonAC`, `Type1_NonAC_Rate`, `Type2`, `Type2_AC`, `Type2_AC_Rate`, `Type2_NonAC`, `Type2_NonAC_Rate`, `Type3`, `Type3_AC`, `Type3_AC_Rate`, `Type3_NonAC`, `Type3_NonAC_Rate`, `Status`) VALUES
(1, '1', 'Yes', 'Yes', '53', 'No', '-', 'No', 'No', '-', 'No', '-', 'No', 'No', '-', 'No', '-', 'Yes'),
(2, '4', 'Yes', 'No', '-', 'Yes', '12', 'No', 'No', '-', 'No', '-', 'Yes', 'Yes', '25', 'No', '-', 'Yes'),
(3, '7', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'No');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_water_adv`
--

CREATE TABLE `tbl_water_adv` (
  `Water_ID` int(11) NOT NULL,
  `User_ID` varchar(4) NOT NULL,
  `Title` varchar(30) NOT NULL,
  `Description` varchar(100) NOT NULL,
  `Type` varchar(100) NOT NULL,
  `Area` varchar(4) NOT NULL,
  `Rate` varchar(5) NOT NULL,
  `Contact` varchar(10) NOT NULL,
  `Status` varchar(10) NOT NULL,
  `Image1` varchar(100) NOT NULL,
  `Image2` varchar(100) NOT NULL,
  `Image3` varchar(100) NOT NULL,
  `Image4` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_water_adv`
--

INSERT INTO `tbl_water_adv` (`Water_ID`, `User_ID`, `Title`, `Description`, `Type`, `Area`, `Rate`, `Contact`, `Status`, `Image1`, `Image2`, `Image3`, `Image4`) VALUES
(1, '3', 'Daily Water supply Service', '20 ltr', 'Daily', '1', '30', '9087890989', 'Active', 'upload/water/w2.png', 'upload/water/w1.png', '', ''),
(2, '5', 'mihir water-can service', 'for daily life..', 'Daily', '3', '40', '9671345789', 'Active', 'upload/water/w2.png', '', '', ''),
(3, '10', 'RO water purifier', 'RO water purifier available', 'Weekly', '4', '200', '9898121232', 'Active', 'upload/water/Screenshot_2017-04-03-10-35-02-694.jpeg', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_water_order`
--

CREATE TABLE `tbl_water_order` (
  `Water_Order_ID` int(11) NOT NULL,
  `Adv_ID` varchar(4) NOT NULL,
  `User_ID` varchar(4) NOT NULL,
  `Owner_ID` varchar(4) NOT NULL,
  `Order_Date` varchar(20) NOT NULL,
  `Order_Time` varchar(20) NOT NULL,
  `Order_Address` varchar(60) NOT NULL,
  `Status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_water_order`
--

INSERT INTO `tbl_water_order` (`Water_Order_ID`, `Adv_ID`, `User_ID`, `Owner_ID`, `Order_Date`, `Order_Time`, `Order_Address`, `Status`) VALUES
(6, '3', '3', '10', 'ask', 'all', 'all', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_water_pac`
--

CREATE TABLE `tbl_water_pac` (
  `WPac_ID` int(3) NOT NULL,
  `title` varchar(15) NOT NULL,
  `service` varchar(15) NOT NULL,
  `rate` int(3) NOT NULL,
  `number` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_water_pac`
--

INSERT INTO `tbl_water_pac` (`WPac_ID`, `title`, `service`, `rate`, `number`) VALUES
(1, 'heta', 'heta', 0, 0),
(2, 'show', 'monthly', 700, 2147483647);

-- --------------------------------------------------------

--
-- Table structure for table `user_reg`
--

CREATE TABLE `user_reg` (
  `User_ID` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Mobile` varchar(10) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Address` text NOT NULL,
  `Role` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_reg`
--

INSERT INTO `user_reg` (`User_ID`, `Name`, `Email`, `Mobile`, `Password`, `Address`, `Role`) VALUES
(1, 'Priya', 'priya@gmail.com', '9634852126', '123pr', 'B-128,Santi Park,Vadodara', 'User'),
(2, 'Mayank Patel', 'mayank@gmail.com', '9809878987', '1234', 'A-125,Santi-Nagra ,vadodara', 'Property'),
(3, 'heta', 'heta@gmail.com', '9867245789', 'he123', 'C-9,Ratan Nagar , nr mother school , vadodara', 'User'),
(4, 'manthan patwala', 'manthanpatwala51@gmail.com', '9638345836', 'he123', 'A-12,Lisa park,vaodara', 'User'),
(5, 'kandarp bhai', 'kan@gmail.com', '9815345876', '1234', 'C-12,Monalisa soc, vaodara', 'Property'),
(6, 'vaidehi', 'va@gmail.com', '8678156797', '1234', 'a-9,Nisha Soc, vaodara', 'Property'),
(7, 'Sahanaj', 'sahanaj@gmail.com', '9898124224', 'sa123', '', 'Property'),
(8, 'poonam', 'poonamshah.ce@bitseducampus.ac', '9909519114', '123', '', 'User'),
(9, 'poonam', 'poonamshah.ce@bitseducampus.ac', '9909519114', '123', '', 'User'),
(10, 'Helly Zinzuvadia', 'helly@', '9876644211', 'hellu', '', 'User'),
(11, 'Helly', 'hell@', 'nvchvsbb', 'hhhh', '', 'Property'),
(12, 'kunal', 'kunal@gmail.com', '7815678468', 'kun123', '', 'User');

-- --------------------------------------------------------

--
-- Table structure for table `user_reg1`
--

CREATE TABLE `user_reg1` (
  `User_ID` int(11) NOT NULL,
  `Title` varchar(50) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Mobile` varchar(10) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Role` varchar(15) NOT NULL,
  `Status` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_reg1`
--

INSERT INTO `user_reg1` (`User_ID`, `Title`, `Name`, `Email`, `Mobile`, `Password`, `Role`, `Status`) VALUES
(1, 'Vijay Taxi', 'Sanjay Patil', 'sanjay@gmail.com', '8989009864', '1234', 'Taxi', 'Active'),
(2, 'Saurastra Food', 'Ravi Jadeja', 'ravi@gmail.com', '9092345640', '1234', 'Food', 'Active'),
(3, 'Nilkant Water Supply', 'Ramesh Sharma', 'ramesh@gmail.com', '9878789809', '1234', 'Water', 'Active'),
(4, 'jay ganesh taxi service', 'manthan', 'manthan@gmail.com', '9638341678', '1234', 'Taxi', 'Active'),
(5, 'mihir water-can service', 'mihir patel', 'mihir@gmail.com', '9678342678', '1234', 'Water', 'Active'),
(6, 'Priya tiffen service', 'priya patel', 'priyapatel@yahoo.com', '8914567156', '1234', 'Food', 'Active'),
(7, 'jagruti taxi service', 'jagruti', 'jagruti@gmail.com', '1756785467', '1234', 'Taxi', 'Active'),
(8, 'Nikita water service', 'Nikita Rathod', 'niki@gmail.com', '9635586243', '1234', 'Water', 'Active'),
(10, 'Panini Suvitha', 'Panini', 'pani@gmail.com', '9898121232', '1234', 'Water', 'Active'),
(11, 'santi water service', 'rahul', 'rahul@gmail.com', '8678156753', '1234', 'Water', 'Active'),
(12, 'Kalaniketan', 'vaidehi', 'vai@gmail.com', '6815685578', '', 'Food', 'Pending');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `grocery`
--
ALTER TABLE `grocery`
  ADD UNIQUE KEY `Gos_ID` (`Gos_ID`);

--
-- Indexes for table `order_table`
--
ALTER TABLE `order_table`
  ADD PRIMARY KEY (`Order_ID`);

--
-- Indexes for table `pharmcy`
--
ALTER TABLE `pharmcy`
  ADD UNIQUE KEY `Pha_ID` (`Pha_ID`);

--
-- Indexes for table `restaurant`
--
ALTER TABLE `restaurant`
  ADD UNIQUE KEY `Res_ID` (`Res_ID`);

--
-- Indexes for table `tbl_area`
--
ALTER TABLE `tbl_area`
  ADD PRIMARY KEY (`Area_ID`);

--
-- Indexes for table `tbl_food_adv`
--
ALTER TABLE `tbl_food_adv`
  ADD PRIMARY KEY (`Food_ID`);

--
-- Indexes for table `tbl_food_order`
--
ALTER TABLE `tbl_food_order`
  ADD PRIMARY KEY (`Food_Order_ID`);

--
-- Indexes for table `tbl_food_pac`
--
ALTER TABLE `tbl_food_pac`
  ADD PRIMARY KEY (`FPac_ID`);

--
-- Indexes for table `tbl_property_adv`
--
ALTER TABLE `tbl_property_adv`
  ADD PRIMARY KEY (`Property_ID`);

--
-- Indexes for table `tbl_taxi_images`
--
ALTER TABLE `tbl_taxi_images`
  ADD PRIMARY KEY (`Entry_ID`);

--
-- Indexes for table `tbl_taxi_order`
--
ALTER TABLE `tbl_taxi_order`
  ADD PRIMARY KEY (`TaxiOrder_ID`);

--
-- Indexes for table `tbl_taxi_rate`
--
ALTER TABLE `tbl_taxi_rate`
  ADD PRIMARY KEY (`Entry_ID`);

--
-- Indexes for table `tbl_water_adv`
--
ALTER TABLE `tbl_water_adv`
  ADD PRIMARY KEY (`Water_ID`);

--
-- Indexes for table `tbl_water_order`
--
ALTER TABLE `tbl_water_order`
  ADD PRIMARY KEY (`Water_Order_ID`);

--
-- Indexes for table `tbl_water_pac`
--
ALTER TABLE `tbl_water_pac`
  ADD PRIMARY KEY (`WPac_ID`);

--
-- Indexes for table `user_reg`
--
ALTER TABLE `user_reg`
  ADD PRIMARY KEY (`User_ID`);

--
-- Indexes for table `user_reg1`
--
ALTER TABLE `user_reg1`
  ADD PRIMARY KEY (`User_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `order_table`
--
ALTER TABLE `order_table`
  MODIFY `Order_ID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `tbl_area`
--
ALTER TABLE `tbl_area`
  MODIFY `Area_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_food_adv`
--
ALTER TABLE `tbl_food_adv`
  MODIFY `Food_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_food_order`
--
ALTER TABLE `tbl_food_order`
  MODIFY `Food_Order_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `tbl_food_pac`
--
ALTER TABLE `tbl_food_pac`
  MODIFY `FPac_ID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_property_adv`
--
ALTER TABLE `tbl_property_adv`
  MODIFY `Property_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_taxi_images`
--
ALTER TABLE `tbl_taxi_images`
  MODIFY `Entry_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbl_taxi_order`
--
ALTER TABLE `tbl_taxi_order`
  MODIFY `TaxiOrder_ID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `tbl_taxi_rate`
--
ALTER TABLE `tbl_taxi_rate`
  MODIFY `Entry_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbl_water_adv`
--
ALTER TABLE `tbl_water_adv`
  MODIFY `Water_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbl_water_order`
--
ALTER TABLE `tbl_water_order`
  MODIFY `Water_Order_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_water_pac`
--
ALTER TABLE `tbl_water_pac`
  MODIFY `WPac_ID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user_reg`
--
ALTER TABLE `user_reg`
  MODIFY `User_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `user_reg1`
--
ALTER TABLE `user_reg1`
  MODIFY `User_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
