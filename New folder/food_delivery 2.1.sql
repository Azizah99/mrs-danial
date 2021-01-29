-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 24, 2021 at 09:11 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

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
(1, 'Nasi goreng kampung', 9, '0', 'Food', '');

-- --------------------------------------------------------

--
-- Table structure for table `orderdish`
--

CREATE TABLE `orderdish` (
  `orderID` int(11) NOT NULL,
  `customer` int(11) NOT NULL,
  `menu` int(11) NOT NULL,
  `quantity` int(100) NOT NULL,
  `status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `userName` varchar(200) NOT NULL,
  `password` varchar(100) NOT NULL,
  `userType` varchar(50) NOT NULL,
  `fullName` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  ADD PRIMARY KEY (`orderID`),
  ADD KEY `customer` (`customer`),
  ADD KEY `menu` (`menu`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dishes`
--
ALTER TABLE `dishes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `orderdish`
--
ALTER TABLE `orderdish`
  MODIFY `orderID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orderdish`
--
ALTER TABLE `orderdish`
  ADD CONSTRAINT `orderdish_ibfk_1` FOREIGN KEY (`customer`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `orderdish_ibfk_2` FOREIGN KEY (`menu`) REFERENCES `dishes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
