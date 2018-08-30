-- --------------------------------------------------------
-- Хост:                         localhost
-- Версия сервера:               5.7.20-log - MySQL Community Server (GPL)
-- Операционная система:         Win64
-- HeidiSQL Версия:              9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных subway
CREATE DATABASE IF NOT EXISTS `subway` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `subway`;

-- Дамп структуры для таблица subway.edges
CREATE TABLE IF NOT EXISTS `edges` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `st1` int(11) NOT NULL DEFAULT '0',
  `st2` int(11) NOT NULL DEFAULT '0',
  `line_chng` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `fk_st1` (`st1`),
  KEY `fk_st2` (`st2`),
  CONSTRAINT `fk_st1` FOREIGN KEY (`st1`) REFERENCES `stations` (`id`),
  CONSTRAINT `fk_st2` FOREIGN KEY (`st2`) REFERENCES `stations` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=307 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы subway.edges: ~306 rows (приблизительно)
/*!40000 ALTER TABLE `edges` DISABLE KEYS */;
REPLACE INTO `edges` (`id`, `st1`, `st2`, `line_chng`) VALUES
	(1, 1, 2, 1),
	(2, 2, 3, 1),
	(3, 3, 4, 1),
	(4, 4, 5, 1),
	(5, 5, 6, 1),
	(6, 6, 7, 1),
	(7, 7, 8, 1),
	(8, 8, 9, 1),
	(9, 9, 10, 1),
	(10, 10, 11, 1),
	(11, 11, 12, 1),
	(12, 12, 13, 1),
	(13, 13, 14, 1),
	(14, 14, 15, 1),
	(15, 15, 16, 1),
	(16, 16, 17, 1),
	(17, 17, 18, 1),
	(18, 18, 19, 1),
	(19, 19, 20, 1),
	(20, 20, 21, 1),
	(21, 21, 22, 1),
	(22, 23, 24, 1),
	(23, 24, 25, 1),
	(24, 25, 26, 1),
	(25, 26, 27, 1),
	(26, 27, 28, 1),
	(27, 28, 29, 1),
	(28, 29, 30, 1),
	(29, 30, 31, 1),
	(30, 31, 32, 1),
	(31, 32, 33, 1),
	(32, 33, 34, 1),
	(33, 34, 35, 1),
	(34, 35, 36, 1),
	(35, 36, 37, 1),
	(36, 37, 38, 1),
	(37, 38, 39, 1),
	(38, 39, 40, 1),
	(39, 40, 41, 1),
	(40, 41, 42, 1),
	(41, 42, 43, 1),
	(42, 43, 44, 1),
	(43, 44, 45, 1),
	(44, 46, 47, 1),
	(45, 47, 48, 1),
	(46, 48, 49, 1),
	(47, 49, 50, 1),
	(48, 50, 51, 1),
	(49, 51, 52, 1),
	(50, 52, 53, 1),
	(51, 53, 54, 1),
	(52, 54, 55, 1),
	(53, 55, 56, 1),
	(54, 56, 57, 1),
	(55, 57, 58, 1),
	(56, 58, 59, 1),
	(57, 59, 60, 1),
	(58, 60, 61, 1),
	(59, 61, 62, 1),
	(60, 62, 63, 1),
	(61, 63, 64, 1),
	(62, 64, 65, 1),
	(63, 65, 66, 1),
	(64, 66, 67, 1),
	(65, 68, 69, 1),
	(66, 69, 70, 1),
	(67, 70, 71, 1),
	(68, 71, 72, 1),
	(69, 72, 73, 1),
	(70, 73, 74, 1),
	(71, 74, 75, 1),
	(72, 75, 76, 1),
	(73, 76, 77, 1),
	(74, 77, 78, 1),
	(75, 78, 79, 1),
	(76, 79, 80, 1),
	(77, 81, 82, 1),
	(78, 82, 83, 1),
	(79, 83, 84, 1),
	(80, 84, 85, 1),
	(81, 85, 86, 1),
	(82, 86, 87, 1),
	(83, 87, 88, 1),
	(84, 88, 89, 1),
	(85, 89, 90, 1),
	(86, 90, 91, 1),
	(87, 91, 92, 1),
	(88, 93, 94, 1),
	(89, 94, 95, 1),
	(90, 95, 96, 1),
	(91, 96, 97, 1),
	(92, 97, 98, 1),
	(93, 98, 99, 1),
	(94, 99, 100, 1),
	(95, 100, 101, 1),
	(96, 101, 102, 1),
	(97, 102, 103, 1),
	(98, 103, 104, 1),
	(99, 104, 105, 1),
	(100, 105, 106, 1),
	(101, 106, 107, 1),
	(102, 107, 108, 1),
	(103, 108, 109, 1),
	(104, 109, 110, 1),
	(105, 110, 111, 1),
	(106, 111, 112, 1),
	(107, 112, 113, 1),
	(108, 113, 114, 1),
	(109, 114, 115, 1),
	(110, 115, 116, 1),
	(111, 117, 118, 1),
	(112, 118, 119, 1),
	(113, 119, 120, 1),
	(114, 120, 121, 1),
	(115, 121, 122, 1),
	(116, 122, 123, 1),
	(117, 123, 124, 1),
	(118, 124, 125, 1),
	(119, 125, 126, 1),
	(120, 126, 127, 1),
	(121, 127, 128, 1),
	(122, 128, 129, 1),
	(123, 129, 130, 1),
	(124, 130, 131, 1),
	(125, 131, 132, 1),
	(126, 132, 133, 1),
	(127, 133, 134, 1),
	(128, 134, 135, 1),
	(129, 135, 136, 1),
	(130, 136, 137, 1),
	(131, 137, 138, 1),
	(132, 138, 139, 1),
	(133, 140, 141, 1),
	(134, 141, 142, 1),
	(135, 142, 143, 1),
	(136, 143, 144, 1),
	(137, 145, 146, 1),
	(138, 146, 147, 1),
	(139, 147, 148, 1),
	(140, 148, 149, 1),
	(141, 149, 150, 1),
	(142, 150, 151, 1),
	(143, 151, 152, 1),
	(144, 153, 154, 1),
	(145, 154, 155, 1),
	(146, 155, 156, 1),
	(147, 156, 157, 1),
	(148, 157, 158, 1),
	(149, 158, 159, 1),
	(150, 159, 160, 1),
	(151, 160, 161, 1),
	(152, 161, 162, 1),
	(153, 162, 163, 1),
	(154, 163, 164, 1),
	(155, 164, 165, 1),
	(156, 165, 166, 1),
	(157, 166, 167, 1),
	(158, 167, 168, 1),
	(159, 168, 169, 1),
	(160, 169, 170, 1),
	(161, 170, 171, 1),
	(162, 171, 172, 1),
	(163, 172, 173, 1),
	(164, 173, 174, 1),
	(165, 174, 175, 1),
	(166, 175, 176, 1),
	(167, 176, 177, 1),
	(168, 178, 179, 1),
	(169, 179, 180, 1),
	(170, 180, 181, 1),
	(171, 181, 182, 1),
	(172, 182, 183, 1),
	(173, 183, 184, 1),
	(174, 184, 185, 1),
	(175, 185, 186, 1),
	(176, 186, 187, 1),
	(177, 187, 188, 1),
	(178, 188, 189, 1),
	(179, 189, 190, 1),
	(180, 190, 191, 1),
	(181, 191, 192, 1),
	(182, 192, 193, 1),
	(183, 193, 194, 1),
	(184, 194, 195, 1),
	(185, 195, 196, 1),
	(186, 196, 197, 1),
	(187, 198, 199, 1),
	(188, 199, 200, 1),
	(189, 200, 201, 1),
	(190, 201, 202, 1),
	(191, 203, 204, 1),
	(192, 204, 205, 1),
	(193, 206, 207, 1),
	(194, 207, 208, 1),
	(195, 208, 209, 1),
	(196, 209, 210, 1),
	(197, 210, 211, 1),
	(198, 211, 212, 1),
	(199, 213, 214, 1),
	(200, 214, 215, 1),
	(201, 215, 216, 1),
	(202, 216, 217, 1),
	(203, 217, 218, 1),
	(204, 219, 220, 1),
	(205, 220, 221, 1),
	(206, 221, 222, 1),
	(207, 222, 223, 1),
	(208, 223, 224, 1),
	(209, 224, 225, 1),
	(210, 225, 226, 1),
	(211, 226, 227, 1),
	(212, 227, 228, 1),
	(213, 228, 229, 1),
	(214, 229, 230, 1),
	(215, 230, 231, 1),
	(216, 231, 232, 1),
	(217, 232, 233, 1),
	(218, 233, 234, 1),
	(219, 234, 235, 1),
	(220, 235, 236, 1),
	(221, 236, 237, 1),
	(222, 237, 238, 1),
	(223, 238, 239, 1),
	(224, 239, 240, 1),
	(225, 240, 241, 1),
	(226, 241, 242, 1),
	(227, 242, 243, 1),
	(228, 243, 244, 1),
	(229, 244, 245, 1),
	(230, 245, 246, 1),
	(231, 246, 247, 1),
	(232, 247, 248, 1),
	(233, 248, 249, 1),
	(234, 249, 219, 1),
	(235, 92, 81, 1),
	(236, 2, 224, 1),
	(237, 3, 225, 1),
	(238, 6, 87, 1),
	(239, 8, 184, 1),
	(240, 8, 102, 1),
	(241, 184, 102, 1),
	(242, 9, 128, 1),
	(243, 10, 33, 1),
	(244, 10, 59, 1),
	(245, 33, 59, 1),
	(246, 11, 164, 1),
	(247, 11, 80, 1),
	(248, 11, 58, 1),
	(249, 164, 58, 1),
	(250, 164, 80, 1),
	(251, 80, 58, 1),
	(252, 13, 81, 1),
	(253, 82, 105, 1),
	(254, 83, 166, 1),
	(255, 35, 84, 1),
	(256, 91, 126, 1),
	(257, 30, 90, 1),
	(258, 88, 100, 1),
	(259, 146, 85, 1),
	(260, 146, 130, 1),
	(261, 85, 130, 1),
	(262, 60, 185, 1),
	(263, 86, 185, 1),
	(264, 60, 86, 1),
	(265, 161, 89, 1),
	(266, 56, 80, 1),
	(267, 77, 92, 1),
	(268, 92, 56, 1),
	(269, 103, 129, 1),
	(270, 145, 104, 1),
	(271, 104, 34, 1),
	(272, 34, 145, 1),
	(273, 32, 127, 1),
	(274, 127, 163, 1),
	(275, 163, 32, 1),
	(276, 162, 183, 1),
	(277, 186, 147, 1),
	(278, 187, 131, 1),
	(279, 157, 178, 1),
	(280, 221, 96, 1),
	(281, 226, 64, 1),
	(282, 149, 228, 1),
	(283, 188, 233, 1),
	(284, 36, 234, 1),
	(285, 168, 236, 1),
	(286, 205, 171, 1),
	(287, 39, 203, 1),
	(288, 44, 197, 1),
	(289, 177, 208, 1),
	(290, 116, 206, 1),
	(291, 238, 107, 1),
	(292, 239, 15, 1),
	(293, 73, 240, 1),
	(294, 55, 143, 1),
	(295, 53, 68, 1),
	(296, 241, 75, 1),
	(297, 76, 198, 1),
	(298, 220, 156, 1),
	(299, 26, 247, 1),
	(300, 122, 245, 1),
	(301, 199, 242, 1),
	(302, 144, 76, 1),
	(303, 200, 243, 1),
	(304, 123, 200, 1),
	(305, 123, 243, 1),
	(306, 202, 29, 1);
/*!40000 ALTER TABLE `edges` ENABLE KEYS */;

-- Дамп структуры для таблица subway.stations
CREATE TABLE IF NOT EXISTS `stations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '0',
  `line_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `kf_line_id` (`line_id`),
  CONSTRAINT `kf_line_id` FOREIGN KEY (`line_id`) REFERENCES `subway_lines` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=250 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы subway.stations: ~249 rows (приблизительно)
/*!40000 ALTER TABLE `stations` DISABLE KEYS */;
REPLACE INTO `stations` (`id`, `name`, `line_id`) VALUES
	(1, 'Бульвар Рокоссовского', 1),
	(2, 'Черкизовская', 1),
	(3, 'Преображенская площадь', 1),
	(4, 'Сокольники', 1),
	(5, 'Красносельская', 1),
	(6, 'Комсомольская', 1),
	(7, 'Красные Ворота', 1),
	(8, 'Чистые пруды', 1),
	(9, 'Лубянка', 1),
	(10, 'Охотный Ряд', 1),
	(11, 'Библиотека имени Ленина', 1),
	(12, 'Кропоткинская', 1),
	(13, 'Парк культуры', 1),
	(14, 'Фрунзенская', 1),
	(15, 'Спортивная', 1),
	(16, 'Воробьёвы горы', 1),
	(17, 'Университет', 1),
	(18, 'Проспект Вернадского', 1),
	(19, 'Юго-Западная', 1),
	(20, 'Тропарёво', 1),
	(21, 'Румянцево', 1),
	(22, 'Саларьево', 1),
	(23, 'Ховрино', 2),
	(24, 'Речной вокзал', 2),
	(25, 'Водный стадион', 2),
	(26, 'Войковская', 2),
	(27, 'Сокол', 2),
	(28, 'Аэропорт', 2),
	(29, 'Динамо', 2),
	(30, 'Белорусская', 2),
	(31, 'Маяковская', 2),
	(32, 'Тверская', 2),
	(33, 'Театральная', 2),
	(34, 'Новокузнецкая', 2),
	(35, 'Павелецкая', 2),
	(36, 'Автозаводская', 2),
	(37, 'Технопарк', 2),
	(38, 'Коломенская', 2),
	(39, 'Каширская', 2),
	(40, 'Кантемировская', 2),
	(41, 'Царицыно', 2),
	(42, 'Орехово', 2),
	(43, 'Домодедовская', 2),
	(44, 'Красногвардейская', 2),
	(45, 'Алма-Атинская', 2),
	(46, 'Пятницкое шоссе', 3),
	(47, 'Митино', 3),
	(48, 'Волоколамская', 3),
	(49, 'Мякинино', 3),
	(50, 'Строгино', 3),
	(51, 'Крылатское', 3),
	(52, 'Молодёжная', 3),
	(53, 'Кунцевская', 3),
	(54, 'Славянский бульвар', 3),
	(55, 'Парк Победы', 3),
	(56, 'Киевская', 3),
	(57, 'Смоленская', 3),
	(58, 'Арбатская', 3),
	(59, 'Площадь Революции', 3),
	(60, 'Курская', 3),
	(61, 'Бауманская', 3),
	(62, 'Электрозаводская', 3),
	(63, 'Семёновская', 3),
	(64, 'Партизанская', 3),
	(65, 'Измайловская', 3),
	(66, 'Первомайская', 3),
	(67, 'Щёлковская', 3),
	(68, 'Кунцевская', 4),
	(69, 'Пионерская', 4),
	(70, 'Филёвский парк', 4),
	(71, 'Багратионовская', 4),
	(72, 'Фили', 4),
	(73, 'Кутузовская', 4),
	(74, 'Студенческая', 4),
	(75, 'Международная', 4),
	(76, 'Выставочная', 4),
	(77, 'Киевская', 4),
	(78, 'Смоленская', 4),
	(79, 'Арбатская', 4),
	(80, 'Александровский сад', 4),
	(81, 'Парк культуры', 5),
	(82, 'Октябрьская', 5),
	(83, 'Добрынинская', 5),
	(84, 'Павелецкая', 5),
	(85, 'Таганская', 5),
	(86, 'Курская', 5),
	(87, 'Комсомольская', 5),
	(88, 'Проспект Мира', 5),
	(89, 'Новослободская', 5),
	(90, 'Белорусская', 5),
	(91, 'Краснопресненская', 5),
	(92, 'Киевская', 5),
	(93, 'Медведково', 6),
	(94, 'Бабушкинская', 6),
	(95, 'Свиблово', 6),
	(96, 'Ботанический сад', 6),
	(97, 'ВДНХ', 6),
	(98, 'Алексеевская', 6),
	(99, 'Рижская', 6),
	(100, 'Проспект Мира', 6),
	(101, 'Сухаревская', 6),
	(102, 'Тургеневская', 6),
	(103, 'Китай-город', 6),
	(104, 'Третьяковская', 6),
	(105, 'Октябрьская', 6),
	(106, 'Шаболовская', 6),
	(107, 'Ленинский проспект', 6),
	(108, 'Академическая', 6),
	(109, 'Профсоюзная', 6),
	(110, 'Новые Черёмушки', 6),
	(111, 'Калужская', 6),
	(112, 'Беляево', 6),
	(113, 'Коньково', 6),
	(114, 'Тёплый Стан', 6),
	(115, 'Ясенево', 6),
	(116, 'Новоясеневская', 6),
	(117, 'Планерная', 7),
	(118, 'Сходненская', 7),
	(119, 'Тушинская', 7),
	(120, 'Спартак', 7),
	(121, 'Щукинская', 7),
	(122, 'Октябрьское Поле', 7),
	(123, 'Полежаевская', 7),
	(124, 'Беговая', 7),
	(125, 'Улица 1905 года', 7),
	(126, 'Баррикадная', 7),
	(127, 'Пушкинская', 7),
	(128, 'Кузнецкий Мост', 7),
	(129, 'Китай-город', 7),
	(130, 'Таганская', 7),
	(131, 'Пролетарская', 7),
	(132, 'Волгоградский проспект', 7),
	(133, 'Текстильщики', 7),
	(134, 'Кузьминки', 7),
	(135, 'Рязанский проспект', 7),
	(136, 'Выхино', 7),
	(137, 'Лермонтовский проспект', 7),
	(138, 'Жулебино', 7),
	(139, 'Котельники', 7),
	(140, 'Раменки', 8),
	(141, 'Ломоносовский проспект', 8),
	(142, 'Минская', 8),
	(143, 'Парк Победы', 8),
	(144, 'Деловой центр', 8),
	(145, 'Третьяковская', 9),
	(146, 'Марксистская', 9),
	(147, 'Площадь Ильича', 9),
	(148, 'Авиамоторная', 9),
	(149, 'Шоссе Энтузиастов', 9),
	(150, 'Перово', 9),
	(151, 'Новогиреево', 9),
	(152, 'Новокосино', 9),
	(153, 'Алтуфьево', 10),
	(154, 'Бибирево', 10),
	(155, 'Отрадное', 10),
	(156, 'Владыкино', 10),
	(157, 'Петровско-Разумовская', 10),
	(158, 'Тимирязевская', 10),
	(159, 'Дмитровская', 10),
	(160, 'Савёловская', 10),
	(161, 'Менделеевская', 10),
	(162, 'Цветной бульвар', 10),
	(163, 'Чеховская', 10),
	(164, 'Боровицкая', 10),
	(165, 'Полянка', 10),
	(166, 'Серпуховская', 10),
	(167, 'Тульская', 10),
	(168, 'Нагатинская', 10),
	(169, 'Нагорная', 10),
	(170, 'Нахимовский проспект', 10),
	(171, 'Севастопольская', 10),
	(172, 'Чертановская', 10),
	(173, 'Южная', 10),
	(174, 'Пражская', 10),
	(175, 'Улица Академика Янгеля', 10),
	(176, 'Аннино', 10),
	(177, 'Бульвар Дмитрия Донского', 10),
	(178, 'Петровско-Разумовская', 11),
	(179, 'Фонвизинская', 11),
	(180, 'Бутырская', 11),
	(181, 'Марьина роща', 11),
	(182, 'Достоевская', 11),
	(183, 'Трубная', 11),
	(184, 'Сретенский бульвар', 11),
	(185, 'Чкаловская', 11),
	(186, 'Римская', 11),
	(187, 'Крестьянская застава', 11),
	(188, 'Дубровка', 11),
	(189, 'Кожуховская', 11),
	(190, 'Печатники', 11),
	(191, 'Волжская', 11),
	(192, 'Люблино', 11),
	(193, 'Братиславская', 11),
	(194, 'Марьино', 11),
	(195, 'Борисово', 11),
	(196, 'Шипиловская', 11),
	(197, 'Зябликово', 11),
	(198, 'Деловой центр', 12),
	(199, 'Шелепиха', 12),
	(200, 'Хорошёвская', 12),
	(201, 'ЦСКА', 12),
	(202, 'Петровский парк', 12),
	(203, 'Каширская', 13),
	(204, 'Варшавская', 13),
	(205, 'Каховская', 13),
	(206, 'Битцевский парк', 14),
	(207, 'Лесопарковая', 14),
	(208, 'Улица Старокачаловская', 14),
	(209, 'Улица Скобелевская', 14),
	(210, 'Бульвар Адмирала Ушакова', 14),
	(211, 'Улица Горчакова', 14),
	(212, 'Бунинская аллея', 14),
	(213, 'Тимирязевская	', 15),
	(214, 'Улица Милашенкова', 15),
	(215, 'Телецентр', 15),
	(216, 'Улица Академика Королёва', 15),
	(217, 'Выставочный центр', 15),
	(218, 'Улица Сергея Эйзенштейна', 15),
	(219, 'Окружная', 16),
	(220, 'Владыкино', 16),
	(221, 'Ботанический сад', 16),
	(222, 'Ростокино', 16),
	(223, 'Белокаменная', 16),
	(224, 'Бульвар Рокоссовского', 16),
	(225, 'Локомотив', 16),
	(226, 'Измайлово', 16),
	(227, 'Соколиная Гора', 16),
	(228, 'Шоссе Энтузиастов', 16),
	(229, 'Андроновка', 16),
	(230, 'Нижегородская', 16),
	(231, 'Новохохловская', 16),
	(232, 'Угрешская', 16),
	(233, 'Дубровка', 16),
	(234, 'Автозаводская', 16),
	(235, 'ЗИЛ', 16),
	(236, 'Верхние Котлы', 16),
	(237, 'Крымская', 16),
	(238, 'Площадь Гагарина', 16),
	(239, 'Лужники', 16),
	(240, 'Кутузовская', 16),
	(241, 'Деловой центр', 16),
	(242, 'Шелепиха', 16),
	(243, 'Хорошёво', 16),
	(244, 'Зорге', 16),
	(245, 'Панфиловская', 16),
	(246, 'Стрешнево', 16),
	(247, 'Балтийская', 16),
	(248, 'Коптево', 16),
	(249, 'Лихоборы', 16);
/*!40000 ALTER TABLE `stations` ENABLE KEYS */;

-- Дамп структуры для таблица subway.subway_lines
CREATE TABLE IF NOT EXISTS `subway_lines` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '0',
  `line_num` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `line_num` (`line_num`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы subway.subway_lines: ~16 rows (приблизительно)
/*!40000 ALTER TABLE `subway_lines` DISABLE KEYS */;
REPLACE INTO `subway_lines` (`id`, `name`, `line_num`) VALUES
	(1, 'Сокольническая', 1),
	(2, 'Замоскворецкая', 2),
	(3, 'Арбатско-Покровская', 3),
	(4, 'Филёвская', 4),
	(5, 'Кольцевая', 5),
	(6, 'Калужско-Рижская', 6),
	(7, 'Таганско-Краснопресненская', 7),
	(8, 'Калининский радиус Калининско-Солнцевской', 8),
	(9, 'Солнцевский радиус Калининско-Солнцевской', 9),
	(10, 'Серпуховско-Тимирязевская', 10),
	(11, 'Люблинско-Дмитровская', 11),
	(12, 'Большая кольцевая линия', 12),
	(13, 'Каховская линия 	Каховская', 13),
	(14, 'Бутовская', 14),
	(15, 'Монорельс', 15),
	(16, 'Московское центральное кольцо', 16);
/*!40000 ALTER TABLE `subway_lines` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;