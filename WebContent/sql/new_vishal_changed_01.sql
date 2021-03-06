-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.21-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for akshardh_ms
DROP DATABASE IF EXISTS `akshardh_ms`;
CREATE DATABASE IF NOT EXISTS `akshardh_ms` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `akshardh_ms`;

-- Dumping structure for table akshardh_ms.areas
DROP TABLE IF EXISTS `areas`;
CREATE TABLE IF NOT EXISTS `areas` (
  `area_id` int(11) NOT NULL AUTO_INCREMENT,
  `area_title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`area_id`),
  KEY `area_id` (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table akshardh_ms.areas: ~20 rows (approximately)
DELETE FROM `areas`;
/*!40000 ALTER TABLE `areas` DISABLE KEYS */;
INSERT INTO `areas` (`area_id`, `area_title`) VALUES
	(1, 'Sector 1'),
	(2, 'Coba'),
	(3, 'Sector 2'),
	(4, 'Sector 3'),
	(5, 'Sector 4'),
	(6, 'Sector 5'),
	(7, 'Sector 6'),
	(8, 'Sector 7'),
	(9, 'Sector 8'),
	(10, 'Sector 9'),
	(11, 'Sector 10'),
	(12, 'Sector 11'),
	(13, 'Sector 12'),
	(14, 'Sector 13'),
	(15, 'Sector 14'),
	(16, 'Sector 15'),
	(17, 'Sector 16'),
	(18, 'Sector 17'),
	(19, 'Sector 18'),
	(20, 'Pethapur');
/*!40000 ALTER TABLE `areas` ENABLE KEYS */;

-- Dumping structure for table akshardh_ms.attendance
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE IF NOT EXISTS `attendance` (
  `attendance_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `sabha_id` int(11) NOT NULL,
  `is_attended` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table akshardh_ms.attendance: ~0 rows (approximately)
DELETE FROM `attendance`;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` (`attendance_id`, `user_id`, `sabha_id`, `is_attended`) VALUES
	(1, 515, 1, 1);
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;

-- Dumping structure for table akshardh_ms.blood_groups
DROP TABLE IF EXISTS `blood_groups`;
CREATE TABLE IF NOT EXISTS `blood_groups` (
  `blood_group_id` int(11) NOT NULL AUTO_INCREMENT,
  `blood_group_title` varchar(20) NOT NULL,
  PRIMARY KEY (`blood_group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Dumping data for table akshardh_ms.blood_groups: ~8 rows (approximately)
DELETE FROM `blood_groups`;
/*!40000 ALTER TABLE `blood_groups` DISABLE KEYS */;
INSERT INTO `blood_groups` (`blood_group_id`, `blood_group_title`) VALUES
	(1, 'A+'),
	(2, 'A-'),
	(3, 'B+'),
	(4, 'B-'),
	(5, 'O+'),
	(6, 'O-'),
	(7, 'AB+'),
	(8, 'AB-');
/*!40000 ALTER TABLE `blood_groups` ENABLE KEYS */;

-- Dumping structure for table akshardh_ms.countries
DROP TABLE IF EXISTS `countries`;
CREATE TABLE IF NOT EXISTS `countries` (
  `countries_id` int(11) NOT NULL AUTO_INCREMENT,
  `countries_name` varchar(64) NOT NULL DEFAULT '',
  `countries_iso_code` varchar(2) NOT NULL,
  `countries_isd_code` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`countries_id`)
) ENGINE=InnoDB AUTO_INCREMENT=258 DEFAULT CHARSET=utf8;

-- Dumping data for table akshardh_ms.countries: ~251 rows (approximately)
DELETE FROM `countries`;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO `countries` (`countries_id`, `countries_name`, `countries_iso_code`, `countries_isd_code`) VALUES
	(1, 'Afghanistan', 'AF', '93'),
	(2, 'Albania', 'AL', '355'),
	(3, 'Algeria', 'DZ', '213'),
	(4, 'American Samoa', 'AS', '684'),
	(5, 'Andorra', 'AD', '376'),
	(6, 'Angola', 'AO', '244'),
	(7, 'Anguilla', 'AI', '264'),
	(8, 'Antarctica', 'AQ', '672'),
	(9, 'Antigua and Barbuda', 'AG', '1-268'),
	(10, 'Argentina', 'AR', '54'),
	(11, 'Armenia', 'AM', '374'),
	(12, 'Aruba', 'AW', '297'),
	(13, 'Australia', 'AU', '61'),
	(14, 'Austria', 'AT', '43'),
	(15, 'Azerbaijan', 'AZ', '994'),
	(16, 'Bahamas', 'BS', '1-242'),
	(17, 'Bahrain', 'BH', '973'),
	(18, 'Bangladesh', 'BD', '880'),
	(19, 'Barbados', 'BB', '1-246'),
	(20, 'Belarus', 'BY', '375'),
	(21, 'Belgium', 'BE', '32'),
	(22, 'Belize', 'BZ', '501'),
	(23, 'Benin', 'BJ', '229'),
	(24, 'Bermuda', 'BM', '1-441'),
	(25, 'Bhutan', 'BT', '975'),
	(26, 'Bolivia', 'BO', '591'),
	(27, 'Bosnia and Herzegowina', 'BA', '387'),
	(28, 'Botswana', 'BW', '267'),
	(29, 'Bouvet Island', 'BV', '47'),
	(30, 'Brazil', 'BR', '55'),
	(31, 'British Indian Ocean Territory', 'IO', '246'),
	(32, 'Brunei Darussalam', 'BN', '673'),
	(33, 'Bulgaria', 'BG', '359'),
	(34, 'Burkina Faso', 'BF', '226'),
	(35, 'Burundi', 'BI', '257'),
	(36, 'Cambodia', 'KH', '855'),
	(37, 'Cameroon', 'CM', '237'),
	(38, 'Canada', 'CA', '1'),
	(39, 'Cape Verde', 'CV', '238'),
	(40, 'Cayman Islands', 'KY', '1-345'),
	(41, 'Central African Republic', 'CF', '236'),
	(42, 'Chad', 'TD', '235'),
	(43, 'Chile', 'CL', '56'),
	(44, 'China', 'CN', '86'),
	(45, 'Christmas Island', 'CX', '61'),
	(46, 'Cocos (Keeling) Islands', 'CC', '61'),
	(47, 'Colombia', 'CO', '57'),
	(48, 'Comoros', 'KM', '269'),
	(49, 'Congo Democratic Republic of', 'CG', '242'),
	(50, 'Cook Islands', 'CK', '682'),
	(51, 'Costa Rica', 'CR', '506'),
	(52, 'Cote D\'Ivoire', 'CI', '225'),
	(53, 'Croatia', 'HR', '385'),
	(54, 'Cuba', 'CU', '53'),
	(55, 'Cyprus', 'CY', '357'),
	(56, 'Czech Republic', 'CZ', '420'),
	(57, 'Denmark', 'DK', '45'),
	(58, 'Djibouti', 'DJ', '253'),
	(59, 'Dominica', 'DM', '1-767'),
	(60, 'Dominican Republic', 'DO', '1-809'),
	(61, 'Timor-Leste', 'TL', '670'),
	(62, 'Ecuador', 'EC', '593'),
	(63, 'Egypt', 'EG', '20'),
	(64, 'El Salvador', 'SV', '503'),
	(65, 'Equatorial Guinea', 'GQ', '240'),
	(66, 'Eritrea', 'ER', '291'),
	(67, 'Estonia', 'EE', '372'),
	(68, 'Ethiopia', 'ET', '251'),
	(69, 'Falkland Islands (Malvinas)', 'FK', '500'),
	(70, 'Faroe Islands', 'FO', '298'),
	(71, 'Fiji', 'FJ', '679'),
	(72, 'Finland', 'FI', '358'),
	(73, 'France', 'FR', '33'),
	(75, 'French Guiana', 'GF', '594'),
	(76, 'French Polynesia', 'PF', '689'),
	(77, 'French Southern Territories', 'TF', '260'),
	(78, 'Gabon', 'GA', '241'),
	(79, 'Gambia', 'GM', '220'),
	(80, 'Georgia', 'GE', '995'),
	(81, 'Germany', 'DE', '49'),
	(82, 'Ghana', 'GH', '233'),
	(83, 'Gibraltar', 'GI', '350'),
	(84, 'Greece', 'GR', '30'),
	(85, 'Greenland', 'GL', '299'),
	(86, 'Grenada', 'GD', '1-473'),
	(87, 'Guadeloupe', 'GP', '590'),
	(88, 'Guam', 'GU', '1-671'),
	(89, 'Guatemala', 'GT', '502'),
	(90, 'Guinea', 'GN', '224'),
	(91, 'Guinea-bissau', 'GW', '245'),
	(92, 'Guyana', 'GY', '592'),
	(93, 'Haiti', 'HT', '509'),
	(94, 'Heard Island and McDonald Islands', 'HM', '011'),
	(95, 'Honduras', 'HN', '504'),
	(96, 'Hong Kong', 'HK', '852'),
	(97, 'Hungary', 'HU', '36'),
	(98, 'Iceland', 'IS', '354'),
	(99, 'India', 'IN', '91'),
	(100, 'Indonesia', 'ID', '62'),
	(101, 'Iran (Islamic Republic of)', 'IR', '98'),
	(102, 'Iraq', 'IQ', '964'),
	(103, 'Ireland', 'IE', '353'),
	(104, 'Israel', 'IL', '972'),
	(105, 'Italy', 'IT', '39'),
	(106, 'Jamaica', 'JM', '1-876'),
	(107, 'Japan', 'JP', '81'),
	(108, 'Jordan', 'JO', '962'),
	(109, 'Kazakhstan', 'KZ', '7'),
	(110, 'Kenya', 'KE', '254'),
	(111, 'Kiribati', 'KI', '686'),
	(112, 'Korea, Democratic People\'s Republic of', 'KP', '850'),
	(113, 'South Korea', 'KR', '82'),
	(114, 'Kuwait', 'KW', '965'),
	(115, 'Kyrgyzstan', 'KG', '996'),
	(116, 'Lao People\'s Democratic Republic', 'LA', '856'),
	(117, 'Latvia', 'LV', '371'),
	(118, 'Lebanon', 'LB', '961'),
	(119, 'Lesotho', 'LS', '266'),
	(120, 'Liberia', 'LR', '231'),
	(121, 'Libya', 'LY', '218'),
	(122, 'Liechtenstein', 'LI', '423'),
	(123, 'Lithuania', 'LT', '370'),
	(124, 'Luxembourg', 'LU', '352'),
	(125, 'Macao', 'MO', '853'),
	(126, 'Macedonia, The Former Yugoslav Republic of', 'MK', '389'),
	(127, 'Madagascar', 'MG', '261'),
	(128, 'Malawi', 'MW', '265'),
	(129, 'Malaysia', 'MY', '60'),
	(130, 'Maldives', 'MV', '960'),
	(131, 'Mali', 'ML', '223'),
	(132, 'Malta', 'MT', '356'),
	(133, 'Marshall Islands', 'MH', '692'),
	(134, 'Martinique', 'MQ', '596'),
	(135, 'Mauritania', 'MR', '222'),
	(136, 'Mauritius', 'MU', '230'),
	(137, 'Mayotte', 'YT', '262'),
	(138, 'Mexico', 'MX', '52'),
	(139, 'Micronesia, Federated States of', 'FM', '691'),
	(140, 'Moldova', 'MD', '373'),
	(141, 'Monaco', 'MC', '377'),
	(142, 'Mongolia', 'MN', '976'),
	(143, 'Montserrat', 'MS', '1-664'),
	(144, 'Morocco', 'MA', '212'),
	(145, 'Mozambique', 'MZ', '258'),
	(146, 'Myanmar', 'MM', '95'),
	(147, 'Namibia', 'NA', '264'),
	(148, 'Nauru', 'NR', '674'),
	(149, 'Nepal', 'NP', '977'),
	(150, 'Netherlands', 'NL', '31'),
	(152, 'New Caledonia', 'NC', '687	'),
	(153, 'New Zealand', 'NZ', '64'),
	(154, 'Nicaragua', 'NI', '505'),
	(155, 'Niger', 'NE', '227'),
	(156, 'Nigeria', 'NG', '234'),
	(157, 'Niue', 'NU', '683'),
	(158, 'Norfolk Island', 'NF', '672'),
	(159, 'Northern Mariana Islands', 'MP', '1-670'),
	(160, 'Norway', 'NO', '47'),
	(161, 'Oman', 'OM', '968'),
	(162, 'Pakistan', 'PK', '92'),
	(163, 'Palau', 'PW', '680'),
	(164, 'Panama', 'PA', '507'),
	(165, 'Papua New Guinea', 'PG', '675'),
	(166, 'Paraguay', 'PY', '595'),
	(167, 'Peru', 'PE', '51'),
	(168, 'Philippines', 'PH', '63'),
	(169, 'Pitcairn', 'PN', '64'),
	(170, 'Poland', 'PL', '48'),
	(171, 'Portugal', 'PT', '351'),
	(172, 'Puerto Rico', 'PR', '1-787'),
	(173, 'Qatar', 'QA', '974'),
	(174, 'Reunion', 'RE', '262'),
	(175, 'Romania', 'RO', '40'),
	(176, 'Russian Federation', 'RU', '7'),
	(177, 'Rwanda', 'RW', '250'),
	(178, 'Saint Kitts and Nevis', 'KN', '1-869'),
	(179, 'Saint Lucia', 'LC', '1-758'),
	(180, 'Saint Vincent and the Grenadines', 'VC', '1-784'),
	(181, 'Samoa', 'WS', '685'),
	(182, 'San Marino', 'SM', '378'),
	(183, 'Sao Tome and Principe', 'ST', '239'),
	(184, 'Saudi Arabia', 'SA', '966'),
	(185, 'Senegal', 'SN', '221'),
	(186, 'Seychelles', 'SC', '248'),
	(187, 'Sierra Leone', 'SL', '232'),
	(188, 'Singapore', 'SG', '65'),
	(189, 'Slovakia (Slovak Republic)', 'SK', '421'),
	(190, 'Slovenia', 'SI', '386'),
	(191, 'Solomon Islands', 'SB', '677'),
	(192, 'Somalia', 'SO', '252'),
	(193, 'South Africa', 'ZA', '27'),
	(194, 'South Georgia and the South Sandwich Islands', 'GS', '500'),
	(195, 'Spain', 'ES', '34'),
	(196, 'Sri Lanka', 'LK', '94'),
	(197, 'Saint Helena, Ascension and Tristan da Cunha', 'SH', '290'),
	(198, 'St. Pierre and Miquelon', 'PM', '508'),
	(199, 'Sudan', 'SD', '249'),
	(200, 'Suriname', 'SR', '597'),
	(201, 'Svalbard and Jan Mayen Islands', 'SJ', '47'),
	(202, 'Swaziland', 'SZ', '268'),
	(203, 'Sweden', 'SE', '46'),
	(204, 'Switzerland', 'CH', '41'),
	(205, 'Syrian Arab Republic', 'SY', '963'),
	(206, 'Taiwan', 'TW', '886'),
	(207, 'Tajikistan', 'TJ', '992'),
	(208, 'Tanzania, United Republic of', 'TZ', '255'),
	(209, 'Thailand', 'TH', '66'),
	(210, 'Togo', 'TG', '228'),
	(211, 'Tokelau', 'TK', '690'),
	(212, 'Tonga', 'TO', '676'),
	(213, 'Trinidad and Tobago', 'TT', '1-868'),
	(214, 'Tunisia', 'TN', '216'),
	(215, 'Turkey', 'TR', '90'),
	(216, 'Turkmenistan', 'TM', '993'),
	(217, 'Turks and Caicos Islands', 'TC', '1-649'),
	(218, 'Tuvalu', 'TV', '688'),
	(219, 'Uganda', 'UG', '256'),
	(220, 'Ukraine', 'UA', '380'),
	(221, 'United Arab Emirates', 'AE', '971'),
	(222, 'United Kingdom', 'GB', '44'),
	(223, 'United States', 'US', '1'),
	(224, 'United States Minor Outlying Islands', 'UM', '246'),
	(225, 'Uruguay', 'UY', '598'),
	(226, 'Uzbekistan', 'UZ', '998'),
	(227, 'Vanuatu', 'VU', '678'),
	(228, 'Vatican City State (Holy See)', 'VA', '379'),
	(229, 'Venezuela', 'VE', '58'),
	(230, 'Vietnam', 'VN', '84'),
	(231, 'Virgin Islands (British)', 'VG', '1-284'),
	(232, 'Virgin Islands (U.S.)', 'VI', '1-340'),
	(233, 'Wallis and Futuna Islands', 'WF', '681'),
	(234, 'Western Sahara', 'EH', '212'),
	(235, 'Yemen', 'YE', '967'),
	(236, 'Serbia', 'RS', '381'),
	(238, 'Zambia', 'ZM', '260'),
	(239, 'Zimbabwe', 'ZW', '263'),
	(240, 'Aaland Islands', 'AX', '358'),
	(241, 'Palestine', 'PS', '970'),
	(242, 'Montenegro', 'ME', '382'),
	(243, 'Guernsey', 'GG', '44-1481'),
	(244, 'Isle of Man', 'IM', '44-1624'),
	(245, 'Jersey', 'JE', '44-1534'),
	(247, 'CuraÃ§ao', 'CW', '599'),
	(249, 'Kosovo', 'XK', '383'),
	(250, 'Abkhazia', 'AB', '840'),
	(251, 'Saint BarthÃ©lemy', 'BL', '590'),
	(252, 'Dutch Caribbean', 'BQ', '599'),
	(253, 'DR Congo', 'CD', '243'),
	(255, 'Saint Martin', 'MF', '590'),
	(256, 'South Sudan', 'SS', '211'),
	(257, 'Sint Maarten', 'SX', '1');
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;

-- Dumping structure for table akshardh_ms.email_format
DROP TABLE IF EXISTS `email_format`;
CREATE TABLE IF NOT EXISTS `email_format` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `body` text NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1=Active, 0=In-Active',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table akshardh_ms.email_format: ~2 rows (approximately)
DELETE FROM `email_format`;
/*!40000 ALTER TABLE `email_format` DISABLE KEYS */;
INSERT INTO `email_format` (`id`, `title`, `subject`, `body`, `status`, `created_at`, `updated_at`) VALUES
	(1, 'forgot_password', 'Social App : Forgot Password', '<table cellpadding="0" cellspacing="0" border="0" width="100%">\n    <tbody>\n        <tr>\n            <td style="padding:20px 0 20px 0" align="center" valign="top"><!-- [ header starts here] -->\n            <table style="border:1px solid #E0E0E0;" cellpadding="10" cellspacing="0" bgcolor="FFFFFF" border="0" width="650">\n                <tbody>\n                    <tr>\n                        <td style="background: #444444; " bgcolor="#EAEAEA" valign="top"><p style="font-size:12px; margin:0;"><a href="{logo_front_url}"><img style="" src="{logo_img_url}" alt="SocialApp" title="SocialApp"></a></p><p></p><p></p></td>\n                    </tr>\n                    <!-- [ middle starts here] -->\n                    <tr>\n                        <td valign="top">\n                        <p>Dear  {username},</p>\n                        <p><strong>Your Email address is:</strong> {email}<br></p>                       \n                        <p>Follow the link below to reset your password.<br></p>\n                        <p><a href="reset_link" target="_blank" title="Click to reset password">reset_link</a><br></p>\n                        </p><p>&nbsp;</p>\n                        </td>\n                    </tr>\n                   <tr>\n                        <td style="background: #444444; text-align:center;color: white;" align="center" bgcolor="#EAEAEA"><center>\n                        <p style="font-size:12px; margin:0;">Social Application Team</p>\n                        </center></td>\n                    </tr>\n                </tbody>\n            </table>\n            </td>\n        </tr>\n    </tbody>\n</table>', 1, '2013-09-08 00:00:00', '0000-00-00 00:00:00'),
	(2, 'welcome', 'Social App : New Registration', '<table cellpadding="0" cellspacing="0" border="0" width="100%">\n    <tbody>\n        <tr>\n            <td style="padding:20px 0 20px 0" align="center" valign="top"><!-- [ header starts here] -->\n            <table style="border:1px solid #E0E0E0;" cellpadding="10" cellspacing="0" bgcolor="FFFFFF" border="0" width="650">\n                <tbody>\n                    <tr>\n                        <td style="background: #444444; " bgcolor="#EAEAEA" valign="top"><p><a href="{logo_front_url}"><img style="" src="{logo_img_url}" alt="SocialApp" title="SocialApp"></a></p><p></p><p></p></td>\n                    </tr>\n                    <!-- [ middle starts here] -->\n                    <tr>\n                        <td valign="top">\n                        <p>Dear  {username},</p>  \n                        <p>Your New Password is :<br></p><p><strong>E-mail:</strong> {email}<br>     \n                         </p><p><strong>Password:</strong> {password}<br>    \n                        \n                        </p><p>&nbsp;</p>\n                        </td>\n                    </tr>\n                   <tr>\n                        <td style="background: #444444; text-align:center;color: white;" align="center" bgcolor="#EAEAEA"><center>\n                        <p style="font-size:12px; margin:0;">Social Application Team</p>\n                        </center></td>\n                    </tr>\n                </tbody>\n            </table>\n            </td>\n        </tr>\n    </tbody>\n</table>', 1, '2013-09-08 00:00:00', '0000-00-00 00:00:00');
/*!40000 ALTER TABLE `email_format` ENABLE KEYS */;

-- Dumping structure for table akshardh_ms.mandals
DROP TABLE IF EXISTS `mandals`;
CREATE TABLE IF NOT EXISTS `mandals` (
  `mandal_id` int(11) NOT NULL AUTO_INCREMENT,
  `mandal_title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`mandal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table akshardh_ms.mandals: ~4 rows (approximately)
DELETE FROM `mandals`;
/*!40000 ALTER TABLE `mandals` DISABLE KEYS */;
INSERT INTO `mandals` (`mandal_id`, `mandal_title`) VALUES
	(1, 'Sector 6'),
	(2, 'Sector 20'),
	(3, 'Coba'),
	(4, 'Pethapur');
/*!40000 ALTER TABLE `mandals` ENABLE KEYS */;

-- Dumping structure for table akshardh_ms.myguests
DROP TABLE IF EXISTS `myguests`;
CREATE TABLE IF NOT EXISTS `myguests` (
  `id` int(6) unsigned NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table akshardh_ms.myguests: ~0 rows (approximately)
DELETE FROM `myguests`;
/*!40000 ALTER TABLE `myguests` DISABLE KEYS */;
/*!40000 ALTER TABLE `myguests` ENABLE KEYS */;

-- Dumping structure for table akshardh_ms.push_notification
DROP TABLE IF EXISTS `push_notification`;
CREATE TABLE IF NOT EXISTS `push_notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message_id` int(11) NOT NULL,
  `from_user_id` text NOT NULL,
  `to_user_id` text NOT NULL,
  `message` text NOT NULL,
  `private_mode_endTime` text NOT NULL,
  `is_read` text NOT NULL,
  `thumb_image_url` text NOT NULL,
  `latest_message_id` text NOT NULL,
  `opponent_display_name` text NOT NULL,
  `is_deleted` text NOT NULL,
  `thumb_video_url` text NOT NULL,
  `message_type` text NOT NULL,
  `edited_image_url` text NOT NULL,
  `is_private_mode_on` text NOT NULL,
  `private_mode_time` text NOT NULL,
  `original_image_url` text NOT NULL,
  `video_url` text NOT NULL,
  `message_time` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `message_id` (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table akshardh_ms.push_notification: ~0 rows (approximately)
DELETE FROM `push_notification`;
/*!40000 ALTER TABLE `push_notification` DISABLE KEYS */;
/*!40000 ALTER TABLE `push_notification` ENABLE KEYS */;

-- Dumping structure for table akshardh_ms.sabhas
DROP TABLE IF EXISTS `sabhas`;
CREATE TABLE IF NOT EXISTS `sabhas` (
  `sabha_id` int(11) NOT NULL AUTO_INCREMENT,
  `sabha_title` varchar(255) NOT NULL,
  `mandal_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `status` int(11) NOT NULL,
  `created_date` int(14) NOT NULL,
  `updated_date` int(14) NOT NULL,
  PRIMARY KEY (`sabha_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table akshardh_ms.sabhas: ~0 rows (approximately)
DELETE FROM `sabhas`;
/*!40000 ALTER TABLE `sabhas` DISABLE KEYS */;
INSERT INTO `sabhas` (`sabha_id`, `sabha_title`, `mandal_id`, `date`, `start_time`, `end_time`, `status`, `created_date`, `updated_date`) VALUES
	(1, 'Ravi Sabha', 1, '2017-12-17', '17:00:00', '19:00:00', 1, 1513153579, 1513153579);
/*!40000 ALTER TABLE `sabhas` ENABLE KEYS */;

-- Dumping structure for table akshardh_ms.skills
DROP TABLE IF EXISTS `skills`;
CREATE TABLE IF NOT EXISTS `skills` (
  `skill_id` int(11) NOT NULL AUTO_INCREMENT,
  `skill_title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table akshardh_ms.skills: ~5 rows (approximately)
DELETE FROM `skills`;
/*!40000 ALTER TABLE `skills` DISABLE KEYS */;
INSERT INTO `skills` (`skill_id`, `skill_title`) VALUES
	(1, 'singer'),
	(2, 'anchor'),
	(3, 'instrument player'),
	(4, 'drama'),
	(5, 'multimidia');
/*!40000 ALTER TABLE `skills` ENABLE KEYS */;

-- Dumping structure for table akshardh_ms.ssp
DROP TABLE IF EXISTS `ssp`;
CREATE TABLE IF NOT EXISTS `ssp` (
  `ssp_id` int(11) NOT NULL AUTO_INCREMENT,
  `ssp_title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ssp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table akshardh_ms.ssp: ~7 rows (approximately)
DELETE FROM `ssp`;
/*!40000 ALTER TABLE `ssp` DISABLE KEYS */;
INSERT INTO `ssp` (`ssp_id`, `ssp_title`) VALUES
	(1, 'Prarambh'),
	(2, 'Pravesh'),
	(3, 'Parichay'),
	(4, 'Pravin'),
	(5, 'Pragn 1'),
	(6, 'Pragn 2'),
	(7, 'Pragn 3');
/*!40000 ALTER TABLE `ssp` ENABLE KEYS */;

-- Dumping structure for table akshardh_ms.study
DROP TABLE IF EXISTS `study`;
CREATE TABLE IF NOT EXISTS `study` (
  `study_id` int(11) NOT NULL AUTO_INCREMENT,
  `study_title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`study_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table akshardh_ms.study: ~12 rows (approximately)
DELETE FROM `study`;
/*!40000 ALTER TABLE `study` DISABLE KEYS */;
INSERT INTO `study` (`study_id`, `study_title`) VALUES
	(1, '9'),
	(2, '10'),
	(3, '11'),
	(4, '12'),
	(5, 'BA'),
	(6, 'MA'),
	(7, 'BE'),
	(8, 'ME'),
	(9, 'BCom'),
	(10, 'MCom'),
	(11, 'Diploma'),
	(12, 'MBBS');
/*!40000 ALTER TABLE `study` ENABLE KEYS */;

-- Dumping structure for table akshardh_ms.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'auto_increment id',
  `role_id` int(11) DEFAULT NULL COMMENT 'Role id',
  `f_name` varchar(255) NOT NULL,
  `m_name` varchar(255) NOT NULL,
  `l_name` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT 'abc@gmail.com' COMMENT 'UserEmail',
  `password` varchar(255) DEFAULT NULL COMMENT 'UserPassword',
  `phone` varchar(255) NOT NULL COMMENT 'Phone number of user',
  `wtsp_number` varchar(255) DEFAULT NULL,
  `birth_date` date NOT NULL COMMENT 'User birth date',
  `user_image` varchar(255) DEFAULT NULL,
  `address` varchar(255) NOT NULL,
  `area_id` int(11) NOT NULL,
  `mandal_id` int(11) DEFAULT NULL,
  `auth_token` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL COMMENT 'User Created at',
  `updated_at` datetime DEFAULT NULL COMMENT 'User Updated at',
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `role_id_2` (`role_id`),
  KEY `area_id` (`area_id`),
  KEY `mandal_id` (`mandal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table akshardh_ms.users: ~3 rows (approximately)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `role_id`, `f_name`, `m_name`, `l_name`, `email`, `password`, `phone`, `wtsp_number`, `birth_date`, `user_image`, `address`, `area_id`, `mandal_id`, `auth_token`, `created_at`, `updated_at`) VALUES
	(1, 2, 'Patel', 'Keyur', 'bhai', 'kpatel@gmail.com', 'kpatel', '7878009854', '9979042180', '1980-05-04', '0', 'Medical Hostel', 5, 6, 'c68b009d161146bf940e949a3291ea94', '2018-01-15 21:57:56', '2018-01-15 21:57:56'),
	(2, 1, 'patel', 'vishal', 'dineshenbhai', 'vishaptel@gmail.com', 'vishaptel', '9898008311', '9898088226', '1992-05-22', '0', 'G type sector 19', 2, 1, '42c32099ef8b4cadb8ceb8474b59afbe', '2018-01-15 21:57:56', '2018-01-15 21:57:56'),
	(3, 3, 'detroja', 'ankit', 'prabhubhai', 'ankitdetroja@gmail.com', 'ankitdet', '7600008354', '7600008354', '1992-06-26', '0', '274/3', 5, 4, '60cf128e8f5e47c28e7aab7256787df3', '2018-01-15 21:57:56', '2018-01-15 21:57:56'),
	(5, NULL, 'asdadsk', 'adaada', 'adasd', 'abc@gmail.com', NULL, '98989088', NULL, '2015-05-02', NULL, 'sectopr12121', 1, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Dumping structure for table akshardh_ms.userstatus
DROP TABLE IF EXISTS `userstatus`;
CREATE TABLE IF NOT EXISTS `userstatus` (
  `username` varchar(64) NOT NULL,
  `resource` varchar(64) NOT NULL,
  `online` tinyint(4) NOT NULL,
  `presence` char(15) DEFAULT NULL,
  `lastIpAddress` char(15) NOT NULL,
  `lastLoginDate` char(15) NOT NULL,
  `lastLogoffDate` char(15) DEFAULT NULL,
  PRIMARY KEY (`username`,`resource`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table akshardh_ms.userstatus: ~0 rows (approximately)
DELETE FROM `userstatus`;
/*!40000 ALTER TABLE `userstatus` DISABLE KEYS */;
/*!40000 ALTER TABLE `userstatus` ENABLE KEYS */;

-- Dumping structure for table akshardh_ms.userstatushistory
DROP TABLE IF EXISTS `userstatushistory`;
CREATE TABLE IF NOT EXISTS `userstatushistory` (
  `historyID` bigint(20) NOT NULL,
  `username` varchar(64) NOT NULL,
  `resource` varchar(64) NOT NULL,
  `lastIpAddress` char(15) NOT NULL,
  `lastLoginDate` char(15) NOT NULL,
  `lastLogoffDate` char(15) NOT NULL,
  PRIMARY KEY (`historyID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table akshardh_ms.userstatushistory: ~0 rows (approximately)
DELETE FROM `userstatushistory`;
/*!40000 ALTER TABLE `userstatushistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `userstatushistory` ENABLE KEYS */;

-- Dumping structure for table akshardh_ms.user_normal_details
DROP TABLE IF EXISTS `user_normal_details`;
CREATE TABLE IF NOT EXISTS `user_normal_details` (
  `user_normal_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `study_id` int(11) NOT NULL,
  `occupation` int(11) NOT NULL COMMENT '0=study,1=job,2=business',
  `notes` text COLLATE utf8_unicode_ci NOT NULL,
  `blood_group_id` int(11) NOT NULL,
  PRIMARY KEY (`user_normal_detail_id`),
  KEY `user_id` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table akshardh_ms.user_normal_details: 7 rows
DELETE FROM `user_normal_details`;
/*!40000 ALTER TABLE `user_normal_details` DISABLE KEYS */;
INSERT INTO `user_normal_details` (`user_normal_detail_id`, `user_id`, `study_id`, `occupation`, `notes`, `blood_group_id`) VALUES
	(1, 511, 1, 1, 'JSN', 1),
	(2, 512, 1, 1, 'JSN', 1),
	(3, 513, 1, 1, 'JSN', 1),
	(4, 514, 1, 1, 'JSN', 1),
	(5, 515, 1, 1, 'JSN', 1),
	(6, 516, 1, -1, 'I am good boy ', 1),
	(7, 517, 1, 1, 'JSN', 1);
/*!40000 ALTER TABLE `user_normal_details` ENABLE KEYS */;

-- Dumping structure for table akshardh_ms.user_permission
DROP TABLE IF EXISTS `user_permission`;
CREATE TABLE IF NOT EXISTS `user_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  `can_see_location` tinyint(1) NOT NULL COMMENT '1 yes 2 no',
  `can_see_relationship` tinyint(1) NOT NULL COMMENT '1 yes 2 no',
  `can_see_date_of_birth` tinyint(1) NOT NULL COMMENT '1 yes 2 no',
  `post_history_days` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `category_id` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table akshardh_ms.user_permission: ~0 rows (approximately)
DELETE FROM `user_permission`;
/*!40000 ALTER TABLE `user_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_permission` ENABLE KEYS */;

-- Dumping structure for table akshardh_ms.user_roles
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  `role_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table akshardh_ms.user_roles: ~3 rows (approximately)
DELETE FROM `user_roles`;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` (`id`, `role_name`, `role_description`) VALUES
	(1, 'Admin Users', 'Admin'),
	(2, 'app_user', 'application user'),
	(3, 'app_santo', 'Santo');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;

-- Dumping structure for table akshardh_ms.user_rules
DROP TABLE IF EXISTS `user_rules`;
CREATE TABLE IF NOT EXISTS `user_rules` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `privileges_controller` varchar(255) NOT NULL,
  `privileges_actions` text NOT NULL,
  `permission` enum('allow','deny') NOT NULL DEFAULT 'allow',
  `permission_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `role_id_2` (`role_id`),
  CONSTRAINT `user_rules_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `user_roles` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Dumping data for table akshardh_ms.user_rules: ~8 rows (approximately)
DELETE FROM `user_rules`;
/*!40000 ALTER TABLE `user_rules` DISABLE KEYS */;
INSERT INTO `user_rules` (`id`, `role_id`, `privileges_controller`, `privileges_actions`, `permission`, `permission_type`) VALUES
	(1, 1, 'siteController', 'index,logout,change-password,change-status,change-user-status,edit-profile', 'allow', 'admin'),
	(2, 1, 'usersController', 'index,update,delete', 'allow', 'admin'),
	(3, 1, 'postController', 'index,update,delete', 'allow', 'admin'),
	(4, 1, 'mapsController', 'index,update,delete,create,view', 'allow', 'admin'),
	(5, 1, 'categoryController', 'index,update,delete,create,view', 'allow', 'admin'),
	(6, 1, 'report-userController', 'index,update,delete,create', 'allow', 'admin'),
	(7, 1, 'report-postController', 'index,update,delete,create', 'allow', 'admin'),
	(8, 1, 'gii', 'index', 'allow', 'admin');
/*!40000 ALTER TABLE `user_rules` ENABLE KEYS */;

-- Dumping structure for table akshardh_ms.user_rules_menu
DROP TABLE IF EXISTS `user_rules_menu`;
CREATE TABLE IF NOT EXISTS `user_rules_menu` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `category` enum('admin','front-top','front-bottom','front-middle') NOT NULL DEFAULT 'admin',
  `parent_id` int(10) NOT NULL DEFAULT '0',
  `user_rules_id` int(11) NOT NULL,
  `label` varchar(255) NOT NULL,
  `class` varchar(255) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  `position` int(10) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '0 - inactive, 1 - active',
  PRIMARY KEY (`id`),
  KEY `user_rules_id` (`user_rules_id`),
  KEY `user_rules_id_2` (`user_rules_id`),
  CONSTRAINT `user_rules_menu_ibfk_1` FOREIGN KEY (`user_rules_id`) REFERENCES `user_rules` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table akshardh_ms.user_rules_menu: ~6 rows (approximately)
DELETE FROM `user_rules_menu`;
/*!40000 ALTER TABLE `user_rules_menu` DISABLE KEYS */;
INSERT INTO `user_rules_menu` (`id`, `category`, `parent_id`, `user_rules_id`, `label`, `class`, `url`, `position`, `status`) VALUES
	(1, 'admin', 0, 1, 'Dashboard', 'icon-home', 'site/index', 1, 1),
	(2, 'admin', 0, 2, 'Users', 'icon-home', 'users/index', 2, 1),
	(3, 'admin', 0, 3, 'Post', 'icon-home', 'post/index', 3, 1),
	(4, 'admin', 0, 3, 'Location', 'icon-home', 'maps/index', 3, 1),
	(5, 'admin', 0, 3, 'Category', 'icon-category', 'category/index', 3, 1),
	(6, 'admin', 0, 8, 'Gii', 'icon-home', 'gii/index', 4, 1);
/*!40000 ALTER TABLE `user_rules_menu` ENABLE KEYS */;

-- Dumping structure for table akshardh_ms.user_satsang_details
DROP TABLE IF EXISTS `user_satsang_details`;
CREATE TABLE IF NOT EXISTS `user_satsang_details` (
  `user_satsang_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `aarti` tinyint(1) NOT NULL,
  `puja` tinyint(1) NOT NULL,
  `tilak` tinyint(1) NOT NULL,
  `ekadasi` tinyint(1) NOT NULL,
  `vachnamrut` tinyint(1) NOT NULL,
  `swaminivato` tinyint(1) NOT NULL,
  `otherreading` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ssp_id` int(11) NOT NULL,
  `garshabha` tinyint(1) NOT NULL,
  `dharmado` tinyint(1) NOT NULL,
  PRIMARY KEY (`user_satsang_detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table akshardh_ms.user_satsang_details: ~7 rows (approximately)
DELETE FROM `user_satsang_details`;
/*!40000 ALTER TABLE `user_satsang_details` DISABLE KEYS */;
INSERT INTO `user_satsang_details` (`user_satsang_detail_id`, `user_id`, `aarti`, `puja`, `tilak`, `ekadasi`, `vachnamrut`, `swaminivato`, `otherreading`, `ssp_id`, `garshabha`, `dharmado`) VALUES
	(1, 511, 1, 1, 1, 1, 1, 1, 'JSN', 4, 1, 1),
	(2, 512, 1, 1, 1, 1, 1, 1, 'JSN', 4, 1, 1),
	(3, 513, 1, 1, 1, 1, 1, 1, 'JSN', 4, 1, 1),
	(4, 514, 1, 1, 1, 1, 1, 1, 'JSN', 4, 1, 1),
	(5, 515, 1, 1, 1, 1, 1, 1, 'JSN', 4, 1, 1),
	(6, 516, 0, 0, 0, 0, 0, 0, 'bhaktchintamani', 1, 0, 0),
	(7, 517, 1, 1, 1, 1, 1, 1, 'JSN', 4, 1, 1);
/*!40000 ALTER TABLE `user_satsang_details` ENABLE KEYS */;

-- Dumping structure for table akshardh_ms.user_skills
DROP TABLE IF EXISTS `user_skills`;
CREATE TABLE IF NOT EXISTS `user_skills` (
  `user_skill_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  PRIMARY KEY (`user_skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table akshardh_ms.user_skills: ~0 rows (approximately)
DELETE FROM `user_skills`;
/*!40000 ALTER TABLE `user_skills` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_skills` ENABLE KEYS */;

-- Dumping structure for table akshardh_ms.yuva_attendance
DROP TABLE IF EXISTS `yuva_attendance`;
CREATE TABLE IF NOT EXISTS `yuva_attendance` (
  `sabha_id` int(11) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `is_attended` tinyint(4) DEFAULT NULL,
  `mandal_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table akshardh_ms.yuva_attendance: ~0 rows (approximately)
DELETE FROM `yuva_attendance`;
/*!40000 ALTER TABLE `yuva_attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `yuva_attendance` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
