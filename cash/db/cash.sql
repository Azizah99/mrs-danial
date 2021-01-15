-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 02, 2013 at 07:02 
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cash`
--
CREATE DATABASE `cash` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `cash`;

-- --------------------------------------------------------

--
-- Table structure for table `currency`
--

CREATE TABLE IF NOT EXISTS `currency` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `symbol` varchar(10) NOT NULL,
  `status` varchar(10) NOT NULL DEFAULT 'active',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=0 ;

--
-- Dumping data for table `currency`
--


-- --------------------------------------------------------

--
-- Table structure for table `requestcash`
--

CREATE TABLE IF NOT EXISTS `requestcash` (
  `requestid` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(10) NOT NULL DEFAULT '',
  `amount` varchar(10) NOT NULL DEFAULT '',
  `status` varchar(15) NOT NULL DEFAULT '',
  `currency_id` int(11) NOT NULL,
  PRIMARY KEY (`requestid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=0 ;

--
-- Dumping data for table `requestcash`
--


-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
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
('q', 'q', 'client', 'mr user', 'default.jpg'),
('admin', 'q', 'admin', 'mr admin', 'default.jpg');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
