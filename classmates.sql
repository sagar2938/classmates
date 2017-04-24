-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 07, 2015 at 11:48 AM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `classmates`
--

-- --------------------------------------------------------

--
-- Table structure for table `anouncements`
--

CREATE TABLE IF NOT EXISTS `anouncements` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `image` varchar(100) NOT NULL,
  `college` varchar(50) NOT NULL,
  `batch` varchar(50) NOT NULL,
  `branch` varchar(50) NOT NULL,
  `notice` varchar(1000) NOT NULL,
  `Date` date NOT NULL,
  `time_of` time NOT NULL,
  `subject` varchar(100) NOT NULL,
  `venue` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `anouncements`
--

INSERT INTO `anouncements` (`id`, `email`, `name`, `image`, `college`, `batch`, `branch`, `notice`, `Date`, `time_of`, `subject`, `venue`) VALUES
(1, 'bvsagar619@gmail.com', 'vidya sagar', '', 'RGUKT RKVALLEY', '2009', 'CSE', 'there is an internal lab exam', '0000-00-00', '05:30:00', 'OOSD EXAM', 'cse'),
(2, 'bvsagar619@gmail.com', 'vidya sagar', '', 'RGUKT RKVALLEY', '2009', 'CSE', 'our mue-7 farewell', '2015-04-26', '08:30:00', 'farewell', 's2'),
(3, 'bvsagar619@gmail.com', 'vidya sagar', '', 'RGUKT RKVALLEY', '2009', 'CSE', 'dfyddrr', '2012-05-01', '01:35:00', 'sad', 'dfgg'),
(4, 'bvsagar619@gmail.com', 'vidya sagar', '', 'RGUKT RKVALLEY', '2009', 'CSE', 'All the students need to show their project reports and have to give seminars on their project in consecutive days.', '0000-00-00', '00:00:09', 'Regarding project submission', 'Staff Room');

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE IF NOT EXISTS `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentid` text NOT NULL,
  `from_add` varchar(50) NOT NULL,
  `batch` varchar(50) NOT NULL,
  `branch` varchar(100) NOT NULL,
  `college` varchar(100) NOT NULL,
  `name` varchar(50) NOT NULL,
  `image` varchar(100) NOT NULL,
  `comment` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=40 ;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`id`, `parentid`, `from_add`, `batch`, `branch`, `college`, `name`, `image`, `comment`) VALUES
(1, '0', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'srikanth', 'nothing', 'this is my first comment'),
(2, '0', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'srikanth', 'nothing', 'this is my first comment'),
(3, '0', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'hari', 'nothing', 'tisfa'),
(4, '', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'hari', 'nothing', 'aasdasd'),
(5, '', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'hari', 'nothing', 'asdsa'),
(6, '', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'hari', 'nothing', 'asdsa'),
(7, '', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'hari', 'nothing', 'asdsa'),
(8, '3344', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'hari', 'nothing', 'adsas'),
(9, '3344', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'hari', 'nothing', 'adsasasdweeee'),
(10, '3344', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'hari', 'nothing', 'tis is my second post it tink but this is really aqesomsdflajsdfljalfjafaflasfasfasfsdfasf'),
(11, '3344', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'hari', 'nothing', 'asfasf'),
(12, '3344', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'hari', 'nothing', 'asfasf'),
(13, '3340', 'bvsagar619@gmail.com', 'asd', 'as', 'as', 'asd', 'asd', 'this is working'),
(14, '3344', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'hari', 'nothing', ''),
(15, '3344', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'hari', 'nothing', ''),
(16, '3344', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'hari', 'nothing', 'sdcds'),
(17, '3344', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'hari', 'nothing', 'sdcds'),
(18, '3353', 'srikanth@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'vidya sagar', 'nothing', 'awesome!!!'),
(19, '3353', 'srikanth@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'vidya sagar', 'nothing', 'superb......'),
(20, '3353', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'vidya sagar', 'nothing', ''),
(21, '3353', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'vidya sagar', 'nothing', ''),
(22, '3353', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'vidya sagar', 'nothing', 'this is sagar'),
(23, '3353', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'vidya sagar', 'nothing', 'yeahh this is working adnf'),
(24, '3353', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'vidya sagar', 'nothing', 'i hope this works'),
(25, '3354', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'vidya sagar', 'nothing', 'sure i can its a piece of work'),
(26, '3355', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'vidya sagar', 'nothing', 'here u go \n'),
(27, '3353', 'santa@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'vidya sagar', 'nothing', 'awefull'),
(28, '3351', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'vidya sagar', 'nothing', 'yeah\n'),
(29, '3351', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'vidya sagar', 'nothing', 'sssssssss'),
(30, '3358', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'vidya sagar', 'nothing', 'yes I can'),
(31, '3359', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'vidya sagar', 'nothing', 'this way'),
(32, '3353', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'vidya sagar', 'nothing', 'not the last'),
(33, '3351', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'vidya sagar', 'nothing', 'ushhhhhh'),
(34, '3353', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'vidya sagar', 'nothing', 'jgjhghj'),
(35, '3353', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'vidya sagar', 'nothing', 'fdd'),
(36, '3358', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'vidya sagar', 'nothing', 'dd'),
(37, '3353', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'vidya sagar', 'nothing', 'hey how u doing'),
(38, '3364', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'vidya sagar', 'nothing', 'ffasdfa'),
(39, '3366', 'bvsagar619@gmail.com', '2009', 'CSE', 'RGUKT RKVALLEY', 'vidya sagar', 'nothing', 'hi\n,');

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE IF NOT EXISTS `messages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from_addr` varchar(50) NOT NULL,
  `from_image` varchar(1000) NOT NULL,
  `from_name` varchar(50) NOT NULL,
  `to_addr` varchar(50) NOT NULL,
  `to_image` varchar(1000) NOT NULL,
  `to_name` varchar(50) NOT NULL,
  `message_body` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`id`, `from_addr`, `from_image`, `from_name`, `to_addr`, `to_image`, `to_name`, `message_body`) VALUES
(1, 'sdfa', '', 'sdfaf', 'sdf', '', 'sdf', 'sdf'),
(2, ' john@gmail.com ', 'fga', 'cena', 'bvsagar619@gmail.com', 'adfadf', 'sagar', 'this is the first message'),
(3, ' john@gmail.com ', 'fga', 'cena', 'bvsagar619@gmail.com', 'adfadf', 'sagar', 'this is sagar'),
(4, ' john@gmail.com ', 'fga', 'cena', 'bvsagar619@gmail.com', 'adfadf', 'sagar', 'fadsa'),
(5, 'vamsi@gmail.com', 'nothing', '', 'bvsagar619@gmail.com', 'nothing', 'vidya sagar', 'hi ra'),
(6, 'vamsi@gmail.com', 'nothing', '', 'bvsagar619@gmail.com', 'nothing', 'vidya sagar', 'hi ra'),
(7, 'vamsi@gmail.com', 'nothing', '', 'bvsagar619@gmail.com', 'nothing', 'vidya sagar', 'yes'),
(8, 'bvsagar619@gmail.com', 'nothing', 'vidya sagar', 'vamsi@gmail.com', 'nothing', 'vamsi', 'hi how r u?'),
(9, 'bvsagar619@gmail.com', 'nothing', 'vidya sagar', 'vamsi@gmail.com', 'nothing', 'vamsi', 'hello'),
(10, 'bvsagar619@gmail.com', 'nothing', '', 'haridd@gmail.com', 'nothing', 'hari', 'sdasd'),
(11, 'bvsagar619@gmail.com', 'nothing', '', 'haridd@gmail.com', 'nothing', 'hari', 'good'),
(12, 'bvsagar619@gmail.com', 'nothing', 'vidya sagar', 'john@gmail.com ', 'nothing', 'cena', 'this'),
(13, 'santa@gmail.com', 'nothing', 'santarao', 'bvsagar619@gmail.com', 'nothing', 'vidya sagar', 'hi sagar how ru ?'),
(14, 'haridd@gmail.com', 'nothing', 'hari', 'bvsagar619@gmail.com', 'nothing', 'vidya sagar', 'hi\n'),
(15, 'haridd@gmail.com', 'nothing', 'hari', 'bvsagar619@gmail.com', 'nothing', 'vidya sagar', 'good\n'),
(16, 'haridd@gmail.com', 'nothing', 'hari', 'bvsagar619@gmail.com', 'nothing', 'vidya sagar', 'fffgg'),
(17, 'bvsagar619@gmail.com', 'nothing', 'vidya sagar', 'bvsagar619@gmail.com', 'nothing', 'vidya sagar', 'srfdd'),
(18, 'bvsagar619@gmail.com', 'nothing', 'vidya sagar', 'john@gmail.com ', 'nothing', 'cena', 'rsr'),
(19, 'santa@gmail.com', 'nothing', 'santarao', 'bvsagar619@gmail.com', 'nothing', 'vidya sagar', 'Hi Sagar how r u we are having project submission on 02 May Come asap.'),
(20, 'apple@gmail.com', 'nothing', 'sagar', 'vamsi@gmail.com', 'nothing', 'vamsi', 'hi'),
(21, 'bala12352@gmail.com', 'nothing', 'Bala Konda Reddy', 'vamsi@gmail.com', 'nothing', 'vamsi', 'hi vamshi\n'),
(22, 'bvsagar619@gmail.com', 'nothing', 'vidya sagar', 'vamsi@gmail.com', 'nothing', 'vamsi', 'hi\n');

-- --------------------------------------------------------

--
-- Table structure for table `posts`
--

CREATE TABLE IF NOT EXISTS `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `image` varchar(100) DEFAULT NULL,
  `college` varchar(50) NOT NULL,
  `batch` varchar(50) NOT NULL,
  `branch` varchar(50) NOT NULL,
  `from_add` varchar(50) NOT NULL,
  `post` varchar(1000) NOT NULL,
  `discuss` varchar(5) NOT NULL,
  `challenge` varchar(5) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3370 ;

--
-- Dumping data for table `posts`
--

INSERT INTO `posts` (`id`, `name`, `image`, `college`, `batch`, `branch`, `from_add`, `post`, `discuss`, `challenge`) VALUES
(1, '', NULL, '', '', '', 'nrie', 'nrjn', '', ''),
(2, '', NULL, '', '', '', 'gflij', 'feki', '', ''),
(3, '', NULL, '', '', '', 'gflij', 'xzbdfg', '', ''),
(4, '', NULL, '', '', '', 'sas', 'as', '', ''),
(5, '', NULL, '', '', '', 'sada', 'sdf', '', ''),
(6, '', NULL, '', '', '', 'aaedas', 'sdfds', '', ''),
(8, '', NULL, '', '', '', 'sdf', 'vxc', '', ''),
(32, '', NULL, '', '', '', 'dsdf', 'sdf', '', ''),
(33, '', NULL, '', '', '', 'sdf', 'sdf', '', ''),
(311, '', NULL, '', '', '', 'dsdf', 'sdf', '', ''),
(334, '', NULL, '', '', '', 'ada', 'aa', '', ''),
(455, '', NULL, '', '', '', 'sdf', 'sdf', '', ''),
(1234, '', NULL, '', '', '', 'ad', 'd', '', ''),
(3333, '', NULL, '', '', '', 'sdsds', 'dsf', '', ''),
(3334, '', NULL, '', '', '', 'ADA', 'ASDAA', '', ''),
(3335, '', NULL, '', '', '', 'srikanth@gmail.com', 'this my first post', '', ''),
(3336, '', NULL, '', '', '', 'john@gmail.com', 'this is my second post', '', ''),
(3337, '', NULL, '', '', '', 'srikanth@gmail.com', 'this is my third post', '', ''),
(3338, '', NULL, 'a', '', 's', '', '', '', ''),
(3339, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'This is my first post', '', ''),
(3340, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'this is my second post', '', ''),
(3341, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'this is my third post', '', ''),
(3342, 'srikanth', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'srikanth@gmail.com', 'this is srikanth and his first post', '', ''),
(3343, 'srikanth', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'srikanth@gmail.com', 'this is srikanth and his second post', '', ''),
(3344, 'hari', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'haridd@gmail.com', 'this is hari first post', '', ''),
(3345, 'hari', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'haridd@gmail.com', 'this is hari second post', '', ''),
(3346, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'type to post', '', ''),
(3347, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'this is my post', '', ''),
(3348, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'this is my first discussion', 'no', 'no'),
(3349, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'this is my first challenge', 'no', 'yes'),
(3350, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', '', 'no', 'yes'),
(3351, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'this is my first discussion i think', 'no', 'no'),
(3352, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'this is my first correct discussion', 'yes', 'no'),
(3353, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'this is my post after modifying', 'no', 'no'),
(3354, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'can you do this', 'no', 'yes'),
(3355, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'this is my new challenge', 'no', 'yes'),
(3356, 'santarao', 'nothing', 'RGUKT-B', '2009', 'ECE', 'santa@gmail.com', 'this is my first post', 'no', 'no'),
(3357, 'santarao', 'nothing', 'RGUKT-B', '2009', 'ECE', 'santa@gmail.com', 'what is this', 'no', 'yes'),
(3358, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'can u beat me?', 'no', 'yes'),
(3359, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'how this works', 'yes', 'no'),
(3360, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'fggdf', 'no', 'no'),
(3361, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'tddd', 'no', 'yes'),
(3362, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'ftt', 'yes', 'no'),
(3363, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'type to post', 'no', 'no'),
(3364, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'Here we can post.\nThat will be visible in profiles', 'no', 'no'),
(3365, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'what is the difference between class and object?', 'no', 'yes'),
(3366, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'Can India beat Australia in Semi Final?', 'yes', 'no'),
(3367, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'type to post', 'no', 'no'),
(3368, 'Bala Konda Reddy', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bala12352@gmail.com', 'type to post', 'no', 'no'),
(3369, 'vidya sagar', 'nothing', 'RGUKT RKVALLEY', '2009', 'CSE', 'bvsagar619@gmail.com', 'this is my posts\n', 'no', 'no');

-- --------------------------------------------------------

--
-- Table structure for table `userinfo`
--

CREATE TABLE IF NOT EXISTS `userinfo` (
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `email` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `seqques` varchar(50) NOT NULL,
  `seqans` varchar(50) NOT NULL,
  `clgname` varchar(30) NOT NULL,
  `batch` varchar(20) NOT NULL,
  `branch` varchar(20) NOT NULL,
  `image` varchar(50) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userinfo`
--

INSERT INTO `userinfo` (`firstname`, `lastname`, `gender`, `email`, `password`, `seqques`, `seqans`, `clgname`, `batch`, `branch`, `image`) VALUES
('', '', '', '', '', 'What is favourite hero name?', '', 'RGUKT RKVALLEY', '', 'CSE', 'nothing'),
('sagar', 'vidya', 'male', 'apple@gmail.com', '123456789', 'What is favourite hero name?', 'aasdad', 'RGUKT RKVALLEY', '2009', 'CSE', 'nothing'),
('Bala Konda Reddy', 'M', 'male', 'bala12352@gmail.com', 'bala', 'What is your favourite hobbie?', 'singing', 'RGUKT RKVALLEY', '2009', 'CSE', 'nothing'),
('sagar', 'bula', 'male', 'bvdsagar619@gmail.co', 'sagar619', 'whosafa', 'adfas', 'sasdf', 'adad', 'adfa', 'adfa'),
('vidya sagar', 'bula', 'male', 'bvsagar619@gmail.com', 'google', 'What is your favourite sport?', 'cricket', 'RGUKT RKVALLEY', '2009', 'CSE', 'nothing'),
('sagar', 'bula', 'mail', 'daf@gmail.com', 'adaf', 'adfa', 'adfae', 'afead', 'afd', 'dafd', 'afa'),
('abc', 'def', 'female', 'dklke@GMAIL.COM', 'FMI#', 'What is favourite hero name?', 'FNEJE,', 'RGUKT RKVALLEY', '2009 ', 'CSE', 'nothing'),
('hari', 'krishna', 'male', 'haridd@gmail.com', 'hari', 'What is favourite hero name?', 'balayya', 'RGUKT RKVALLEY', '2009', 'CSE', 'nothing'),
('cena', 'john', 'male', 'john@gmail.com ', 'cena', 'What is your favourite sport?', 'wrestling', 'RGUKT RKVALLEY', '2009', 'CSE', 'nothing'),
('kane', 'undr', 'male', 'kane@gmail.com', 'kane', 'What is your favourite sport?', 'wresti', 'RGUKT RKVALLEY', '2009', 'CSE', 'nothing'),
('santarao', 'jaru', 'male', 'santa@gmail.com', 'santa', 'What is favourite hero name?', 'prabash', 'RGUKT-B', '2009', 'ECE', 'nothing'),
('srikanth', 'yerramati', 'male', 'srikanth@gmail.com', 'wer', 'What is your favourite sport?', 'cricket', 'RGUKT RKVALLEY', '2009', 'CSE', 'nothing'),
('vamsi', 'krishna', 'male', 'vamsi@gmail.com', 'vamsi', 'What is favourite hero name?', 'cena', 'RGUKT-N', '2009', 'MECH', 'nothing');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
