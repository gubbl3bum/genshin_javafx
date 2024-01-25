-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 25 Sty 2024, 17:34
-- Wersja serwera: 10.4.24-MariaDB
-- Wersja PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `gemshim`
--
CREATE DATABASE IF NOT EXISTS `genshin_project` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `genshin_project`;


-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `banner`
--

CREATE TABLE `banner` (
  `idBanner` int(125) NOT NULL,
  `name` varchar(125) NOT NULL,
  `dateStart` date NOT NULL,
  `dateEnd` date NOT NULL,
  `character5` int(125) NOT NULL,
  `character4_1` int(125) NOT NULL,
  `character4_2` int(125) NOT NULL,
  `character4_3` int(125) NOT NULL,
  `version` varchar(125) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `banner`
--

INSERT INTO `banner` (`idBanner`, `name`, `dateStart`, `dateEnd`, `character5`, `character4_1`, `character4_2`, `character4_3`, `version`) VALUES
(1, 'Ballad In Goblets', '2020-09-28', '2020-10-18', 63, 8, 65, 21, '1.0'),
(2, 'Sparkling Steps', '2020-10-20', '2020-11-10', 38, 49, 59, 67, '1.0'),
(3, 'Farawell of Snezhnaya', '2020-11-11', '2020-12-01', 60, 9, 48, 17, '1.1'),
(4, 'Gentry of Hermitage', '2020-12-01', '2020-12-22', 87, 12, 52, 68, '1.1'),
(5, 'Secretum Secretorum', '2020-12-23', '2021-01-12', 2, 10, 21, 59, '1.2'),
(6, 'Adrift in The Harbor', '2021-01-12', '2021-02-02', 22, 49, 65, 67, '1.2'),
(7, 'Invitation To Mundane Life', '2021-02-03', '2021-02-17', 66, 17, 9, 68, '1.3'),
(8, 'Dance Of Lanterns', '2021-02-17', '2021-03-02', 36, 8, 10, 48, '1.3'),
(9, 'Moment of Bloom', '2021-03-02', '2021-03-16', 24, 12, 65, 67, '1.3'),
(10, 'Ballad In Goblets', '2021-03-17', '2021-04-06', 63, 49, 52, 59, '1.4'),
(11, 'Farawell Of Snezhnaya', '2021-04-06', '2021-04-27', 60, 53, 8, 21, '1.4'),
(12, 'Gentry of Hermitage', '2021-04-28', '2021-05-18', 87, 70, 17, 49, '1.5'),
(13, 'Born Of Ocean Swell', '2021-05-18', '2021-06-08', 19, 9, 67, 68, '1.5'),
(14, 'Sparkling Steps', '2021-06-09', '2021-06-29', 38, 8, 21, 59, '1.6'),
(15, 'Leaves In The Wind', '2021-06-29', '2021-07-20', 26, 10, 52, 53, '1.6'),
(16, 'The Heron\'s Court', '2021-07-21', '2021-08-10', 28, 12, 48, 70, '2.0'),
(17, 'Tapestry Of Golden Flames', '2021-08-10', '2021-08-31', 73, 55, 17, 68, '2.0'),
(18, 'Reign of Serenity', '2021-09-01', '2021-09-21', 51, 39, 59, 65, '2.1'),
(19, 'Drifting Luminescence', '2021-09-21', '2021-10-12', 54, 9, 53, 67, '2.1'),
(20, 'Farawell Of Snezhnaya', '2021-10-13', '2021-11-02', 60, 12, 48, 70, '2.2'),
(21, 'Moment Of Bloom', '2021-11-02', '2021-11-23', 24, 61, 55, 17, '2.2'),
(22, 'Born Of Ocean Swell', '2021-11-24', '2021-12-14', 19, 10, 53, 17, '2.3'),
(23, 'Secretum Secretorum', '2021-11-24', '2021-12-14', 2, 10, 53, 49, '2.3'),
(24, 'Oni\'s Royale', '2021-12-14', '2022-01-04', 6, 23, 65, 49, '2.3'),
(25, 'The Transcendent One Returns', '2022-01-05', '2022-01-25', 57, 12, 48, 74, '2.4'),
(26, 'Invitation To Mundane Life', '2022-01-05', '2022-01-25', 66, 12, 48, 74, '2.4'),
(27, 'Gentry Of Hermitage', '2022-01-25', '2022-02-15', 87, 67, 9, 70, '2.4'),
(28, 'Adrift In The Harbor', '2022-01-25', '2022-02-15', 22, 67, 9, 70, '2.4'),
(29, 'Everbloom Violet', '2022-02-15', '2022-03-08', 69, 61, 21, 17, '2.5'),
(30, 'Reign Of Serenity', '2022-03-08', '2022-03-29', 51, 10, 68, 39, '2.5'),
(31, 'Drifting Luminescence', '2022-03-08', '2022-03-29', 54, 10, 68, 39, '2.5'),
(32, 'Azure Excrusion ', '2022-03-30', '2022-04-19', 29, 59, 65, 74, '2.6'),
(33, 'Ballad in Goblets', '2022-03-30', '2022-04-19', 63, 59, 65, 74, '2.6'),
(34, 'The Heron\'s Court', '2022-04-19', '2022-05-30', 28, 53, 52, 55, '2.6'),
(35, 'Invitation To Mundane Life', '2022-05-31', '2022-06-21', 66, 70, 8, 49, '2.7'),
(36, 'Discerner Of Enigmas', '2022-05-31', '2022-06-21', 72, 70, 8, 49, '2.7'),
(37, 'Oni\'s Royale', '2022-06-21', '2022-07-21', 6, 40, 23, 12, '2.7'),
(38, 'Sparkling Steps', '2022-07-13', '2022-08-02', 38, 58, 61, 48, '2.8'),
(39, 'Leaves In The Wind', '2022-07-13', '2022-08-02', 26, 58, 61, 48, '2.8'),
(40, 'Tapestry Of Golden Flames', '2022-08-02', '2022-08-23', 73, 74, 68, 10, '2.8'),
(41, 'Oni\'s Royale', '2022-08-24', '2022-09-09', 6, 13, 17, 21, '3.0'),
(42, 'Viridiscent Vigil', '2022-08-24', '2022-09-09', 62, 13, 17, 21, '3.0'),
(43, 'Adrift In The Harbor', '2022-09-09', '2022-09-27', 22, 18, 67, 59, '3.0'),
(44, 'Drifting Luminescence', '2022-09-09', '2022-09-27', 54, 18, 67, 59, '3.0'),
(45, 'Twilight Amber', '2022-09-28', '2022-10-14', 14, 11, 40, 55, '3.1'),
(46, 'Ballad In Goblets', '2022-09-28', '2022-10-14', 63, 11, 40, 55, '3.1'),
(47, 'Secretum Secretorum', '2022-10-14', '2022-11-01', 2, 8, 65, 9, '3.1'),
(48, 'Twirlling Lotus', '2022-10-14', '2022-11-01', 47, 8, 65, 9, '3.1'),
(49, 'Tapestry Of Golden Flames', '2022-11-02', '2022-11-18', 73, 10, 52, 49, '3.2'),
(50, 'The Moongrass\' Enlightenment', '2022-11-02', '2022-11-18', 46, 10, 52, 49, '3.2'),
(51, 'Everbloom Violet', '2022-11-18', '2022-12-06', 69, 41, 61, 58, '3.2'),
(52, 'Farawell Of Snezhnaya', '2022-11-18', '2022-12-06', 60, 41, 61, 58, '3.2'),
(53, 'Oni\'s Royale', '2022-12-07', '2022-12-27', 6, 20, 23, 70, '3.3'),
(54, 'From Ashers Reborn', '2022-12-07', '2022-12-27', 64, 20, 23, 70, '3.3'),
(55, 'Azure Excrusion', '2022-12-27', '2023-01-17', 29, 39, 55, 53, '3.3'),
(56, 'Reign Of Serenity', '2022-12-27', '2023-01-17', 51, 39, 55, 53, '3.3'),
(57, 'Invitation To Mundane Life', '2023-01-18', '2023-02-07', 66, 71, 74, 68, '3.4'),
(58, 'Caution In Confidence', '2023-01-18', '2023-02-07', 3, 71, 74, 68, '3.4'),
(59, 'Discerner Of Enigmas', '2023-02-07', '2023-02-28', 72, 9, 48, 67, '3.4'),
(60, 'Moment Of Bloom', '2023-02-07', '2023-02-28', 24, 9, 48, 67, '3.4'),
(61, 'Twilight Arbitrer', '2023-03-01', '2023-03-21', 14, 10, 13, 8, '3.5'),
(62, 'Auric Blaze', '2023-03-01', '2023-03-21', 15, 10, 13, 8, '3.5'),
(63, 'The Heron\'s Court', '2023-03-21', '2023-04-11', 28, 44, 59, 17, '3.5'),
(64, 'The Transcendent One Returns', '2023-03-21', '2023-04-11', 57, 44, 59, 17, '3.5'),
(65, 'Twirling Lotus', '2023-04-12', '2023-05-02', 47, 40, 18, 41, '3.6'),
(66, 'The Moongrass\' Enlightenment', '2023-04-12', '2023-05-02', 46, 40, 18, 41, '3.6'),
(67, 'Immaculate Pulse', '2023-05-02', '2023-05-23', 7, 30, 11, 21, '3.6'),
(68, 'Adrift In Harbor', '2023-05-02', '2023-05-23', 22, 30, 11, 21, '3.6'),
(69, 'Everbloom Violet', '2023-05-24', '2023-06-13', 69, 37, 74, 12, '3.7'),
(70, 'Tapestry Of Golden Flames', '2023-05-24', '2023-06-13', 73, 37, 74, 12, '3.7'),
(71, 'Caution In Confidence', '2023-06-13', '2023-07-04', 3, 71, 58, 65, '3.7'),
(72, 'Leaves In The Wind', '2023-06-13', '2023-07-04', 26, 71, 58, 65, '3.7');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `characters`
--

CREATE TABLE `characters` (
  `name` varchar(125) NOT NULL,
  `element` varchar(125) NOT NULL,
  `region` varchar(125) NOT NULL,
  `gender` varchar(125) NOT NULL,
  `age` varchar(125) NOT NULL,
  `weapon` varchar(125) NOT NULL,
  `health` int(125) NOT NULL,
  `attack` int(125) NOT NULL,
  `defense` int(125) NOT NULL,
  `critRate` double(255,0) NOT NULL,
  `critDamage` double(255,0) NOT NULL,
  `quality` int(125) NOT NULL,
  `elemenDmgBonus` double(255,0) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `characters`
--

INSERT INTO `characters` (`name`, `element`, `region`, `gender`, `age`, `weapon`, `health`, `attack`, `defense`, `critRate`, `critDamage`, `quality`, `elemenDmgBonus`, `id`) VALUES
('Aether', 'None', 'None', 'Male', 'Teenager', 'Sword', 10875, 212, 683, 5, 50, 5, 0, 1),
('Albedo', 'Geo', 'Liyue', 'Male', 'Teenager', 'Sword', 13266, 25, 876, 5, 50, 5, 29, 2),
('Alhaitham', 'Dendro', 'Sumeru', 'Male', 'Adult', 'Sword', 13348, 313, 781, 5, 50, 5, 29, 3),
('Aloy', 'Cryo', 'None', 'Female', 'Teenager', 'Bow', 10898, 233, 676, 5, 50, 5, 29, 4),
('Amber', 'Pyro', 'Mondstadt', 'Female', 'Teenager', 'Bow', 9461, 223, 600, 5, 50, 4, 24, 5),
('Arataki Itto', 'Geo', 'Inazuma', 'Male', 'Adult', 'Claymore', 12858, 227, 959, 24, 50, 5, 0, 6),
('Baizhu', 'Dendro', 'Liyue', 'Male', 'Adult', 'Catalyst', 13348, 192, 449, 5, 50, 5, 0, 7),
('Barbara', 'Hydro', 'Mondstadt', 'Female', 'Teenager', 'Catalyst', 9787, 159, 668, 5, 50, 4, 0, 8),
('Beidou', 'Electro', 'Liyue', 'Female', 'Adult', 'Claymore', 13049, 225, 648, 5, 50, 4, 24, 9),
('Bennett', 'Pyro', 'Mondstadt', 'Male', 'Teenager', 'Sword', 12397, 191, 771, 5, 50, 4, 0, 10),
('Candance', 'Hydro', 'Sumeru', 'Female', 'Adult', 'Polearm', 10874, 212, 682, 5, 50, 4, 0, 11),
('Chongyun', 'Cryo', 'Liyue', 'Male', 'Teenager', 'Claymore', 10983, 223, 678, 5, 50, 4, 0, 12),
('Collei', 'Dendro', 'Sumeru', 'Female', 'Teenager', 'Bow', 9787, 199, 600, 5, 50, 4, 0, 13),
('Cyno', 'Electro', 'Sumeru', 'Male', 'Adult', 'Polearm', 12491, 318, 859, 5, 88, 5, 0, 14),
('Dehya', 'Pyro', 'Sumeru', 'Female', 'Adult', 'Claymore', 15674, 265, 627, 5, 50, 5, 0, 15),
('Diluc', 'Pyro', 'Mondstadt', 'Male', 'Adult', 'Claymore', 12981, 335, 784, 24, 50, 5, 0, 16),
('Diona', 'Cryo', 'Mondstadt', 'Female', 'Child', 'Bow', 9569, 212, 600, 5, 50, 4, 24, 17),
('Dori', 'Electro', 'Sumeru', 'Female', 'Child', 'Claymore', 12397, 223, 723, 5, 50, 4, 0, 18),
('Eula', 'Cryo', 'Mondstadt', 'Female', 'Adult', 'Claymore', 13225, 342, 750, 5, 88, 5, 0, 19),
('Faruzan', 'Anemo', 'Sumeru', 'Female', 'Adult', 'Bow', 9570, 196, 628, 5, 50, 4, 0, 20),
('Fischl', 'Electro', 'Mondstadt', 'Female', 'Teenager', 'Bow', 9189, 244, 594, 5, 50, 4, 0, 21),
('Ganyu', 'Cryo', 'Liyue', 'Female', 'Adult', 'Bow', 9797, 335, 630, 5, 88, 5, 0, 22),
('Gorou', 'Geo', 'Inazuma', 'Male', 'Teenager', 'Bow', 9570, 183, 648, 5, 50, 4, 24, 23),
('Hu Tao', 'Pyro', 'Liyue', 'Female', 'Teenager', 'Polearm', 15552, 106, 876, 5, 88, 5, 0, 24),
('Jean', 'Anemo', 'Mondstadt', 'Female', 'Adult', 'Sword', 14695, 239, 769, 5, 50, 5, 0, 25),
('Kaedahara Kazuha', 'Anemo', 'Inazuma', 'Male', 'Teenager', '', 13348, 297, 807, 5, 50, 5, 0, 26),
('Kaeya', 'Cryo', 'Mondstadt', 'Male', 'Adult', 'Sword', 11636, 223, 792, 5, 50, 4, 0, 27),
('Kamisato Ayaka', 'Cryo', 'Inazuma', 'Female', 'Teenager', '', 12858, 342, 784, 5, 88, 5, 0, 28),
('Kamisato Ayato', 'Hydro', 'Inazuma', 'Male', 'Adult', '', 13715, 299, 769, 5, 88, 5, 0, 29),
('Kaveh', 'Dendro', 'Sumeru', 'Male', 'Adult', 'Claymore', 11962, 234, 751, 5, 50, 4, 0, 30),
('Keqing', 'Electro', 'Liyue', 'Female', 'Adult', 'Sword', 13103, 323, 799, 5, 88, 5, 0, 36),
('Kirara', 'Dendro', 'Inazuma', 'Female', 'Teenager', 'Sword', 12180, 223, 546, 5, 50, 4, 0, 37),
('Klee', 'Pyro', 'Mondstadt', 'Female', 'Child', 'Catalyst', 10287, 311, 615, 5, 50, 5, 29, 38),
('Kujou Sara', 'Electro', 'Inazuma', 'Female', 'Adult', 'Bow', 9570, 195, 628, 5, 50, 4, 0, 39),
('Kuki Shinobu', 'Electro', 'Inazuma', 'Female', 'Teenager', 'Sword', 12289, 212, 751, 5, 50, 4, 0, 40),
('Layla', 'Cryo', 'Sumeru', 'Female', 'Teenager', 'Sword', 11092, 217, 655, 5, 50, 4, 0, 41),
('Lisa', 'Electro', 'Mondstadt', 'Female', 'Adult', 'Catalyst', 9570, 232, 573, 5, 50, 4, 0, 42),
('Lumine', 'None', 'None', 'Female', 'Teenager', 'Sword', 10874, 212, 682, 5, 50, 5, 0, 43),
('Mika', 'Cryo', 'Mondstadt', 'Male', 'Child', 'Polearm', 12506, 233, 713, 5, 50, 4, 0, 44),
('Mona', 'Hydro', 'Mondstadt', 'Female', 'Adult', 'Catalyst', 10409, 287, 653, 5, 50, 5, 0, 45),
('Nahida', 'Dendro', 'Sumeru', 'Female', 'Child', 'Catalyst', 10360, 299, 630, 5, 50, 5, 0, 46),
('Niolu', 'Hydro', 'Sumeru', 'Female', 'Teenager', 'Sword', 15185, 230, 729, 5, 50, 5, 0, 47),
('Ningguang', 'Geo', 'Liyue', 'Female', 'Adult', 'Catalyst', 9787, 212, 573, 5, 50, 4, 24, 48),
('Noelle', 'Geo', 'Mondstadt', 'Female', 'Teenager', 'Claymore', 12071, 191, 799, 5, 50, 4, 0, 49),
('Qiqi', 'Cryo', 'Liyue', 'Female', 'Child', 'Sword', 12368, 287, 922, 5, 50, 5, 0, 50),
('Raiden Shogun', 'Electro', 'Inazuma', 'Female', 'Adult', 'Polearm', 12907, 337, 789, 5, 50, 5, 0, 51),
('Razor', 'Electro', 'Mondstadt', 'Male', 'Teenager', 'Claymore', 11962, 234, 751, 5, 50, 4, 0, 52),
('Rosaria', 'Cryo', 'Mondstadt', 'Female', 'Adult', 'Polearm', 12289, 240, 710, 5, 50, 4, 0, 53),
('Sangonomiya Kokomi', 'Hydro', 'Inazuma', 'Female', 'Adult', 'Catalyst', 13471, 234, 657, -100, 50, 5, 29, 54),
('Sayu', 'Anemo', 'Inazuma', 'Female', 'Child', 'Claymore', 11854, 244, 745, 5, 50, 4, 0, 55),
('Shenhe', 'Cryo', 'Liyue', 'Female', 'Adult', 'Polearm', 12993, 304, 830, 5, 50, 5, 0, 57),
('Shikanoin Heizou', 'Anemo', 'Inazuma', 'Male', 'Teenager', 'Catalyst', 10657, 225, 684, 5, 50, 4, 24, 58),
('Sucrose', 'Anemo', 'Mondstadt', 'Female', 'Teenager', 'Catalyst', 9244, 170, 703, 5, 50, 4, 24, 59),
('Tartaglia', 'Hydro', 'Snezhnaya', 'Male', 'Adult', 'Bow', 13103, 301, 815, 5, 50, 5, 29, 60),
('Thoma', 'Pyro', 'Inazuma', 'Male', 'Adult', 'Polearm', 10331, 202, 751, 5, 50, 4, 0, 61),
('Tighanari', 'Dendro', 'Sumeru', 'Male', 'Adult', 'Bow', 10850, 268, 630, 5, 50, 5, 29, 62),
('Venti', 'Anemo', 'Mondstadt', 'Male', 'Adult', 'Bow', 10531, 263, 669, 5, 50, 5, 0, 63),
('Wanderer', 'Anemo', 'Sumeru', 'Male', 'Adult', 'Catalyst', 10164, 328, 607, 24, 50, 5, 0, 64),
('Xiangling', 'Pyro', 'Liyue', 'Female', 'Teenager', 'Polearm', 10875, 225, 669, 5, 50, 4, 0, 65),
('Xiao', 'Anemo', 'Liyue', 'Male', 'Adult', 'Polearm', 12736, 349, 799, 24, 50, 5, 0, 66),
('Xingqiu', 'Hydro', 'Liyue', 'Male', 'Teenager', 'Sword', 10222, 202, 758, 5, 50, 4, 0, 67),
('Xinyan', 'Pyro', 'Liyue', 'Female', 'Teenager', 'Claymore', 11201, 249, 799, 5, 50, 4, 0, 68),
('Yae Miko', 'Element', 'Inazuma', 'Female', 'Adult', 'Catalyst', 10372, 340, 569, 24, 50, 5, 0, 69),
('Yanfei', 'Pyro', 'Liyue', 'Female', 'Teenager', 'Catalyst', 9352, 240, 587, 5, 50, 4, 24, 70),
('Yaoyao', 'Dendro', 'Sumeru', 'Female', 'Child', 'Polearm', 12289, 212, 751, 5, 50, 4, 0, 71),
('Yelan', 'Hydro', 'Liyue', 'Female', 'Adult', 'Bow', 14450, 224, 548, 24, 50, 5, 0, 72),
('Yoimiya', 'Pyro', 'Inazuma', 'Female', 'Teenager', 'Bow', 10164, 323, 615, 24, 50, 5, 0, 73),
('Yun Jin', 'Geo', 'Liyue', 'Female', 'Teenager', 'Polearm', 10657, 191, 734, 5, 50, 0, 0, 74),
('Zhongli', 'Geo', 'Liyue', 'Male', 'Adult', 'Polearm', 14695, 251, 738, 5, 50, 5, 29, 87);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user_info`
--

CREATE TABLE `user_info` (
  `id` int(11) NOT NULL,
  `login` varchar(125) NOT NULL,
  `password` varchar(125) NOT NULL,
  `role` varchar(125) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `user_info`
--

INSERT INTO `user_info` (`id`, `login`, `password`, `role`) VALUES
(1, 'aa', '$2a$10$1.RQ.MElyGNzoKmvHzm7WuG0DQL4FMJAjrPFD.lzqr/p8yLIaOFKu', 'user'),
(2, 'aaaa', '$2a$10$eomO5FDUG/dafxsEDwAdq.UVXgm6WW/II1brhzfR5t9l/y2h5CMuC', 'user'),
(3, 'fomfel2137', '$2a$10$7RY1EGszRSeDNBElXsc0huTavlOF8VTbcIhbtabPQs539chzuhHTq', 'user'),
(4, 'bbb', '$2a$10$skrPiHply7tDxcDtoKZS1OE1BzjePnu/j4h2oEmv/TQGYFubBwWA.', 'user'),
(5, 'jonsulek123', '$2a$10$/srqaVBNYvnn8PK6mVIHEep9Hm.p1tPfo47mRnBjosjPf5O9yzKia', 'user'),
(6, 'aaaa', '$2a$10$2IuZwJCICXeEr7sjF/ZzBuI8/y0wxrlJnWSgiopLvMfY6Mbs.beMu', 'user'),
(8, 'admin', '$2a$10$YKZ2EQbqBaEBl8HJVXsAUeo.AQNZ8n/1tvIhZywLbURxHYdZvwulK', 'admin'),
(10, 'kotek', '$2a$10$7yTDJ/zuCobbnWb4L3H4NeW0GATwuOaeAxbG3tqmNKgQvzm0E0pJ.', 'user');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `user_info`
--
ALTER TABLE `user_info`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `user_info`
--
ALTER TABLE `user_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
