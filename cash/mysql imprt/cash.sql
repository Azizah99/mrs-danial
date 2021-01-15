-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 20, 2017 at 08:36 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cash`
--
CREATE DATABASE IF NOT EXISTS `cash` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `cash`;

-- --------------------------------------------------------

--
-- Table structure for table `cashrequest`
--

CREATE TABLE `cashrequest` (
  `requestid` int(11) NOT NULL,
  `login` varchar(10) NOT NULL DEFAULT '',
  `amount` varchar(10) NOT NULL DEFAULT '',
  `status` varchar(15) NOT NULL DEFAULT '',
  `currency_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `currency`
--

CREATE TABLE `currency` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `symbol` varchar(10) NOT NULL,
  `status` varchar(10) NOT NULL DEFAULT 'active'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `login` varchar(10) NOT NULL DEFAULT '',
  `password` varchar(10) NOT NULL DEFAULT '',
  `usertype` varchar(6) NOT NULL DEFAULT '',
  `fullname` varchar(25) NOT NULL DEFAULT '',
  `image` varchar(30) NOT NULL DEFAULT ''
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`login`, `password`, `usertype`, `fullname`, `image`) VALUES
('q', 'q', 'client', 'Mr Queue', 'default.jpg'),
('admin', 'q', 'admin', 'mr admin', 'default.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cashrequest`
--
ALTER TABLE `cashrequest`
  ADD PRIMARY KEY (`requestid`);

--
-- Indexes for table `currency`
--
ALTER TABLE `currency`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cashrequest`
--
ALTER TABLE `cashrequest`
  MODIFY `requestid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `currency`
--
ALTER TABLE `currency`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
