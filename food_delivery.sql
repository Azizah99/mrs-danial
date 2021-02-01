-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 01, 2021 at 01:48 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `food_delivery`
--

-- --------------------------------------------------------

--
-- Table structure for table `dishes`
--

CREATE TABLE `dishes` (
  `id` int(11) NOT NULL,
  `menu` varchar(300) NOT NULL,
  `price` double NOT NULL,
  `photo` varchar(300) NOT NULL DEFAULT '0',
  `category` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dishes`
--

INSERT INTO `dishes` (`id`, `menu`, `price`, `photo`, `category`, `status`) VALUES
(1, 'Nasi goreng kampung', 9, '0', 'Food', 'active'),
(2, 'mee goreng', 7, '0', 'Food', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `orderdish`
--

CREATE TABLE `orderdish` (
  `orderID` int(11) NOT NULL,
  `userName` varchar(100) NOT NULL,
  `menu` int(11) NOT NULL,
  `quantity` int(100) NOT NULL,
  `status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orderdish`
--

INSERT INTO `orderdish` (`orderID`, `userName`, `menu`, `quantity`, `status`) VALUES
(1, 'we', 2, 2, 'Delivered'),
(2, 'we', 2, 4, 'Rejected'),
(4, 'q', 2, 2, 'Delivered'),
(5, 'q', 1, 1, 'not confirm');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userName` varchar(200) NOT NULL,
  `password` varchar(100) NOT NULL,
  `userType` varchar(50) NOT NULL,
  `fullName` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userName`, `password`, `userType`, `fullName`) VALUES
('q', 'q', 'client', 'umi haiza'),
('umi', 'wq', 'admin', 'Umi haiza binti mahamud'),
('we', 'we', 'client', 'wewewe');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dishes`
--
ALTER TABLE `dishes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `menu` (`menu`);

--
-- Indexes for table `orderdish`
--
ALTER TABLE `orderdish`
  ADD PRIMARY KEY (`orderID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userName`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dishes`
--
ALTER TABLE `dishes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `orderdish`
--
ALTER TABLE `orderdish`
  MODIFY `orderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
