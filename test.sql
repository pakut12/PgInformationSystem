-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:4306
-- Generation Time: Nov 07, 2022 at 03:56 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `is_os`
--

CREATE TABLE `is_os` (
  `os_id` varchar(10) NOT NULL,
  `os_name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `is_program`
--

CREATE TABLE `is_program` (
  `program_id` varchar(10) NOT NULL,
  `program_name` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `is_systamuser`
--

CREATE TABLE `is_systamuser` (
  `is_id` int(11) NOT NULL,
  `is_userid` varchar(7) DEFAULT NULL,
  `is_computer` varchar(20) DEFAULT NULL,
  `is_ip` varchar(20) DEFAULT NULL,
  `os_id` varchar(10) DEFAULT NULL,
  `program_id` varchar(10) DEFAULT NULL,
  `program_key` varchar(50) DEFAULT NULL,
  `os_key` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `is_os`
--
ALTER TABLE `is_os`
  ADD PRIMARY KEY (`os_id`);

--
-- Indexes for table `is_program`
--
ALTER TABLE `is_program`
  ADD PRIMARY KEY (`program_id`);

--
-- Indexes for table `is_systamuser`
--
ALTER TABLE `is_systamuser`
  ADD PRIMARY KEY (`is_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `is_systamuser`
--
ALTER TABLE `is_systamuser`
  MODIFY `is_id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
