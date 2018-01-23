-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.24-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.2.0.4947
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for xboxlive_akdm
DROP DATABASE IF EXISTS `xboxlive_akdm`;
CREATE DATABASE IF NOT EXISTS `xboxlive_akdm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `xboxlive_akdm`;


-- Dumping structure for table xboxlive_akdm.areas
DROP TABLE IF EXISTS `areas`;
CREATE TABLE IF NOT EXISTS `areas` (
  `area_id` int(11) NOT NULL AUTO_INCREMENT,
  `area_title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`area_id`),
  KEY `area_id` (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table xboxlive_akdm.areas: ~20 rows (approximately)
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


-- Dumping structure for table xboxlive_akdm.attendance
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE IF NOT EXISTS `attendance` (
  `attendance_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `sabha_id` int(11) NOT NULL,
  `is_attended` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table xboxlive_akdm.attendance: ~0 rows (approximately)
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` (`attendance_id`, `user_id`, `sabha_id`, `is_attended`) VALUES
	(1, 515, 1, 1);
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;


-- Dumping structure for table xboxlive_akdm.blood_groups
DROP TABLE IF EXISTS `blood_groups`;
CREATE TABLE IF NOT EXISTS `blood_groups` (
  `blood_group_id` int(11) NOT NULL AUTO_INCREMENT,
  `blood_group_title` varchar(20) NOT NULL,
  PRIMARY KEY (`blood_group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Dumping data for table xboxlive_akdm.blood_groups: ~8 rows (approximately)
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


-- Dumping structure for table xboxlive_akdm.countries
DROP TABLE IF EXISTS `countries`;
CREATE TABLE IF NOT EXISTS `countries` (
  `countries_id` int(11) NOT NULL AUTO_INCREMENT,
  `countries_name` varchar(64) NOT NULL DEFAULT '',
  `countries_iso_code` varchar(2) NOT NULL,
  `countries_isd_code` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`countries_id`)
) ENGINE=InnoDB AUTO_INCREMENT=258 DEFAULT CHARSET=utf8;

-- Dumping data for table xboxlive_akdm.countries: ~251 rows (approximately)
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


-- Dumping structure for table xboxlive_akdm.email_format
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

-- Dumping data for table xboxlive_akdm.email_format: ~2 rows (approximately)
/*!40000 ALTER TABLE `email_format` DISABLE KEYS */;
INSERT INTO `email_format` (`id`, `title`, `subject`, `body`, `status`, `created_at`, `updated_at`) VALUES
	(1, 'forgot_password', 'Social App : Forgot Password', '<table cellpadding="0" cellspacing="0" border="0" width="100%">\n    <tbody>\n        <tr>\n            <td style="padding:20px 0 20px 0" align="center" valign="top"><!-- [ header starts here] -->\n            <table style="border:1px solid #E0E0E0;" cellpadding="10" cellspacing="0" bgcolor="FFFFFF" border="0" width="650">\n                <tbody>\n                    <tr>\n                        <td style="background: #444444; " bgcolor="#EAEAEA" valign="top"><p style="font-size:12px; margin:0;"><a href="{logo_front_url}"><img style="" src="{logo_img_url}" alt="SocialApp" title="SocialApp"></a></p><p></p><p></p></td>\n                    </tr>\n                    <!-- [ middle starts here] -->\n                    <tr>\n                        <td valign="top">\n                        <p>Dear  {username},</p>\n                        <p><strong>Your Email address is:</strong> {email}<br></p>                       \n                        <p>Follow the link below to reset your password.<br></p>\n                        <p><a href="reset_link" target="_blank" title="Click to reset password">reset_link</a><br></p>\n                        </p><p>&nbsp;</p>\n                        </td>\n                    </tr>\n                   <tr>\n                        <td style="background: #444444; text-align:center;color: white;" align="center" bgcolor="#EAEAEA"><center>\n                        <p style="font-size:12px; margin:0;">Social Application Team</p>\n                        </center></td>\n                    </tr>\n                </tbody>\n            </table>\n            </td>\n        </tr>\n    </tbody>\n</table>', 1, '2013-09-08 00:00:00', '0000-00-00 00:00:00'),
	(2, 'welcome', 'Social App : New Registration', '<table cellpadding="0" cellspacing="0" border="0" width="100%">\n    <tbody>\n        <tr>\n            <td style="padding:20px 0 20px 0" align="center" valign="top"><!-- [ header starts here] -->\n            <table style="border:1px solid #E0E0E0;" cellpadding="10" cellspacing="0" bgcolor="FFFFFF" border="0" width="650">\n                <tbody>\n                    <tr>\n                        <td style="background: #444444; " bgcolor="#EAEAEA" valign="top"><p><a href="{logo_front_url}"><img style="" src="{logo_img_url}" alt="SocialApp" title="SocialApp"></a></p><p></p><p></p></td>\n                    </tr>\n                    <!-- [ middle starts here] -->\n                    <tr>\n                        <td valign="top">\n                        <p>Dear  {username},</p>  \n                        <p>Your New Password is :<br></p><p><strong>E-mail:</strong> {email}<br>     \n                         </p><p><strong>Password:</strong> {password}<br>    \n                        \n                        </p><p>&nbsp;</p>\n                        </td>\n                    </tr>\n                   <tr>\n                        <td style="background: #444444; text-align:center;color: white;" align="center" bgcolor="#EAEAEA"><center>\n                        <p style="font-size:12px; margin:0;">Social Application Team</p>\n                        </center></td>\n                    </tr>\n                </tbody>\n            </table>\n            </td>\n        </tr>\n    </tbody>\n</table>', 1, '2013-09-08 00:00:00', '0000-00-00 00:00:00');
/*!40000 ALTER TABLE `email_format` ENABLE KEYS */;


-- Dumping structure for table xboxlive_akdm.mandals
DROP TABLE IF EXISTS `mandals`;
CREATE TABLE IF NOT EXISTS `mandals` (
  `mandal_id` int(11) NOT NULL AUTO_INCREMENT,
  `mandal_title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`mandal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table xboxlive_akdm.mandals: ~4 rows (approximately)
/*!40000 ALTER TABLE `mandals` DISABLE KEYS */;
INSERT INTO `mandals` (`mandal_id`, `mandal_title`) VALUES
	(1, 'Sector 6'),
	(2, 'Sector 20'),
	(3, 'Coba'),
	(4, 'Pethapur');
/*!40000 ALTER TABLE `mandals` ENABLE KEYS */;


-- Dumping structure for table xboxlive_akdm.myguests
DROP TABLE IF EXISTS `myguests`;
CREATE TABLE IF NOT EXISTS `myguests` (
  `id` int(6) unsigned NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table xboxlive_akdm.myguests: ~0 rows (approximately)
/*!40000 ALTER TABLE `myguests` DISABLE KEYS */;
/*!40000 ALTER TABLE `myguests` ENABLE KEYS */;


-- Dumping structure for table xboxlive_akdm.push_notification
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

-- Dumping data for table xboxlive_akdm.push_notification: ~0 rows (approximately)
/*!40000 ALTER TABLE `push_notification` DISABLE KEYS */;
/*!40000 ALTER TABLE `push_notification` ENABLE KEYS */;


-- Dumping structure for table xboxlive_akdm.sabhas
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

-- Dumping data for table xboxlive_akdm.sabhas: ~0 rows (approximately)
/*!40000 ALTER TABLE `sabhas` DISABLE KEYS */;
INSERT INTO `sabhas` (`sabha_id`, `sabha_title`, `mandal_id`, `date`, `start_time`, `end_time`, `status`, `created_date`, `updated_date`) VALUES
	(1, 'Ravi Sabha', 1, '2017-12-17', '17:00:00', '19:00:00', 1, 1513153579, 1513153579);
/*!40000 ALTER TABLE `sabhas` ENABLE KEYS */;


-- Dumping structure for table xboxlive_akdm.skills
DROP TABLE IF EXISTS `skills`;
CREATE TABLE IF NOT EXISTS `skills` (
  `skill_id` int(11) NOT NULL AUTO_INCREMENT,
  `skill_title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table xboxlive_akdm.skills: ~5 rows (approximately)
/*!40000 ALTER TABLE `skills` DISABLE KEYS */;
INSERT INTO `skills` (`skill_id`, `skill_title`) VALUES
	(1, 'singer'),
	(2, 'anchor'),
	(3, 'instrument player'),
	(4, 'drama'),
	(5, 'multimidia');
/*!40000 ALTER TABLE `skills` ENABLE KEYS */;


-- Dumping structure for table xboxlive_akdm.ssp
DROP TABLE IF EXISTS `ssp`;
CREATE TABLE IF NOT EXISTS `ssp` (
  `ssp_id` int(11) NOT NULL AUTO_INCREMENT,
  `ssp_title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ssp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table xboxlive_akdm.ssp: ~7 rows (approximately)
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


-- Dumping structure for table xboxlive_akdm.study
DROP TABLE IF EXISTS `study`;
CREATE TABLE IF NOT EXISTS `study` (
  `study_id` int(11) NOT NULL AUTO_INCREMENT,
  `study_title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`study_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table xboxlive_akdm.study: ~12 rows (approximately)
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


-- Dumping structure for table xboxlive_akdm.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'auto_increment id',
  `role_id` int(11) NOT NULL COMMENT 'Role id',
  `user_name` varchar(255) NOT NULL COMMENT 'Username',
  `email` varchar(255) NOT NULL COMMENT 'UserEmail',
  `password` varchar(255) NOT NULL COMMENT 'UserPassword',
  `phone` varchar(255) NOT NULL COMMENT 'Phone number of user',
  `whatsapp_number` varchar(255) NOT NULL,
  `email_verified` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'User is verified or not 1 or 0',
  `birth_date` date NOT NULL COMMENT 'User birth date',
  `user_image` varchar(255) DEFAULT NULL,
  `latitude` decimal(11,8) NOT NULL,
  `longitude` decimal(11,8) NOT NULL,
  `address` varchar(255) NOT NULL,
  `area_id` int(11) NOT NULL,
  `mandal_id` int(11) NOT NULL,
  `auth_token` varchar(255) NOT NULL,
  `relationship_status` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL COMMENT 'User Created at',
  `updated_at` datetime NOT NULL COMMENT 'User Updated at',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'block status',
  `device_type` int(11) NOT NULL COMMENT '0-iphone,1-android',
  `device_token` varchar(255) NOT NULL,
  `badge_count` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `USER_UNIQUEID` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `role_id_2` (`role_id`),
  KEY `area_id` (`area_id`),
  KEY `mandal_id` (`mandal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6028 DEFAULT CHARSET=utf8;

-- Dumping data for table xboxlive_akdm.users: ~171 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `role_id`, `user_name`, `email`, `password`, `phone`, `whatsapp_number`, `email_verified`, `birth_date`, `user_image`, `latitude`, `longitude`, `address`, `area_id`, `mandal_id`, `auth_token`, `relationship_status`, `created_at`, `updated_at`, `status`, `device_type`, `device_token`, `badge_count`, `username`, `USER_UNIQUEID`) VALUES
	(5857, 3, 'Hiren d. Chhayani 12 ', 'hiren d. chhayani 12 @gmail.com', 'hiren d. chhayani 12 ', '919624660131', '9979042180', 1, '1996-11-13', '0', 0.00000000, 0.00000000, 'Medical Hostel', 5, 6, 'c68b009d161146bf940e949a3291ea94', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5858, 3, 'Ish R dhaduk 12. B ', 'ish r dhaduk 12. b @gmail.com', 'ish r dhaduk 12. b ', '917203974570', '919427530504', 1, '1998-10-09', '0', 0.00000000, 0.00000000, 'GMERS MEDICAL COLLEGE BOY\'S HOSTEL', 5, 6, '42c32099ef8b4cadb8ceb8474b59afbe', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5859, 3, 'Kush patel 12 c ', 'kush patel 12 c @gmail.com', 'kush patel 12 c ', '918292340655', '', 1, '1996-07-14', '0', 0.00000000, 0.00000000, '349/1 ', 5, 4, '60cf128e8f5e47c28e7aab7256787df3', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5860, 3, 'Nagpal Parmar 12 ', 'nagpal parmar 12 @gmail.com', 'nagpal parmar 12 ', '918460713611', '919714806592', 1, '1997-12-01', '0', 0.00000000, 0.00000000, 'CBI Block 12', 5, 6, '53b9d027869f4205bb7ac4625e9975a7', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5861, 3, 'Parth dave 12.b ', 'parth dave 12.b @gmail.com', 'parth dave 12.b ', '918511124075', '918155885781', 1, '1997-02-10', '0', 0.00000000, 0.00000000, 'GMERS MEDICAL COLLEGE BOY\'S HOSTEL', 5, 6, 'effe8155f57845c3b544a468c54f26fd', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5862, 3, 'Parth tholiya 12 ', 'parth tholiya 12 @gmail.com', 'parth tholiya 12 ', '919824842943', '9904624479', 1, '1996-07-22', '0', 0.00000000, 0.00000000, 'Samadhiyala', 5, 6, 'c125c8b3574248dba2f34ac236874d53', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5863, 3, 'Samir j dhandhaliya 12. B ', 'samir j dhandhaliya 12. b @gmail.com', 'samir j dhandhaliya 12. b ', '91 820 093 4095', '919426149504', 1, '1997-07-23', '0', 0.00000000, 0.00000000, 'GMERS MEDICAL COLLEGE BOY\'S HOSTEL', 5, 6, 'c4b64ac8f0b44c1b8ccc67fc6c310bd1', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5864, 3, 'Sujit Thakor 12 ', 'sujit thakor 12 @gmail.com', 'sujit thakor 12 ', '918000273902', '919879166689', 1, '1990-11-27', '0', 0.00000000, 0.00000000, '410/1 12-B', 5, 6, '180d750107c24e15b58e37b0c635f403', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5865, 3, 'Divyaraj S Chavda New 13 ', 'divyaraj s chavda new 13 @gmail.com', 'divyaraj s chavda new 13 ', '91 77 79 050632', '919104874583', 1, '2001-12-07', '0', 0.00000000, 0.00000000, '582/1 Sec 13 A', 5, 6, '3d5c526e79894cc48a32e67fd5f5c21f', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5866, 3, 'Jaydip Gangarav 13  Junagardh', 'jaydip gangarav 13  junagardh@gmail.com', 'jaydip gangarav 13  junagardh', '91 97 24 040334', '', 1, '1993-05-20', '0', 0.00000000, 0.00000000, '83, Sec 13 C', 5, 6, 'c25091386e7947a28c63b5d447f6e747', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5867, 3, 'Kashyap raval 13.b ', 'kashyap raval 13.b @gmail.com', 'kashyap raval 13.b ', '919898953780', '', 1, '2001-07-05', '0', 0.00000000, 0.00000000, 'M5/58, vavol road, sector 13', 5, 6, 'd8d70069e6444468ba45140c8a7c5613', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5868, 3, 'Krunal parekh 13.b ', 'krunal parekh 13.b @gmail.com', 'krunal parekh 13.b ', '919974146468', '91 96 01 015217', 1, '2000-10-04', '0', 0.00000000, 0.00000000, 'B 861/2,', 5, 6, '8b85a6ee61d94759908fe6518dae671d', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5869, 3, 'Sahil Mukeshbhai Prajapati 13.a ', 'sahil mukeshbhai prajapati 13.a @gmail.com', 'sahil mukeshbhai prajapati 13.a ', '91 99 98 629298', '91 80 00 982242', 1, '2000-09-14', '0', 0.00000000, 0.00000000, '568/1', 5, 6, '99d4558c57e84f9e94bb9e1ae53ba1b1', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5870, 3, 'Yashvant Dabhi 13 ', 'yashvant dabhi 13 @gmail.com', 'yashvant dabhi 13 ', '918733025150', '919726986668', 1, '2002-09-01', '0', 0.00000000, 0.00000000, '546/1', 5, 6, '1bdd896a165e4a1085ec9cbe02bb55b5', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5871, 3, 'Dhairya A Patel 14 ', 'dhairya a patel 14 @gmail.com', 'dhairya a patel 14 ', '91 99 24 328112', '91 84 60 990112', 1, '2003-07-13', '0', 0.00000000, 0.00000000, '67/1, Sec 14', 5, 6, 'f5a83ebb12734df4aa910d85f7e73a3e', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5872, 3, 'Gopal Patel 14 ', 'gopal patel 14 @gmail.com', 'gopal patel 14 ', '918401466680', '919427053576', 1, '1996-08-09', '0', 0.00000000, 0.00000000, '228/1', 5, 6, '6d80ac89f5ff424db123f06c815f6423', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5873, 3, 'Jayraj Padhiyar 14', 'jayraj padhiyar 14@gmail.com', 'jayraj padhiyar 14', '918758200098', '919924012026', 1, '2000-10-09', '0', 0.00000000, 0.00000000, '67/6, HiG, guj. Housing board', 5, 6, '185001bff90840048fff4323f19e9f64', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5874, 3, 'Parth Valera 14 ', 'parth valera 14 @gmail.com', 'parth valera 14 ', '918401142415', '919998314671', 1, '1997-11-26', '0', 0.00000000, 0.00000000, '72/6 HIG, ghb Sec-14', 5, 6, '23b411dc198146f29aead71dcd821cce', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5875, 3, 'Yashrajsinh n 14 ', 'yashrajsinh n 14 @gmail.com', 'yashrajsinh n 14 ', '8758699954', '9198985643321', 1, '1997-01-22', '0', 0.00000000, 0.00000000, 'M7/82, sardar patel housing board', 5, 6, 'a07f58c6934f4b4592de1e742f5a960f', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5876, 3, 'Anandkumar Aman 15 ', 'anandkumar aman 15 @gmail.com', 'anandkumar aman 15 ', '91 95 37 692859', '', 1, '1995-06-10', '0', 0.00000000, 0.00000000, 'LDRP Hostel', 5, 6, '0c3b203d7a984be2bd1b408f9fbcf8bc', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5877, 3, 'Ankit thakor 15 ', 'ankit thakor 15 @gmail.com', 'ankit thakor 15 ', '919687155997', '7600546576', 1, '1998-02-03', '0', 0.00000000, 0.00000000, 'C-14/ Kailashdham sector 15', 5, 6, 'fade8c42dfa54bdf85fafc6a1e37ae9e', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5878, 3, 'Darshan Patel 15 ', 'darshan patel 15 @gmail.com', 'darshan patel 15 ', '919157275070', '', 1, '1998-02-03', '0', 0.00000000, 0.00000000, '', 5, 6, '7c30be0848bf40adb27df101305eeeb7', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5879, 3, 'Dhaval K Amlani 15 ', 'dhaval k amlani 15 @gmail.com', 'dhaval k amlani 15 ', '91 94 29 081498', '91 88 66 798915', 1, '1996-09-29', '0', 0.00000000, 0.00000000, 'B 42 LDRP Hostel Kh 5', 5, 6, '1f95d87a698a434eb8b2fb869864a715', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5880, 3, 'Dishant modi 15 ', 'dishant modi 15 @gmail.com', 'dishant modi 15 ', '919913092420', '8485989752', 1, '2000-01-05', '0', 0.00000000, 0.00000000, '641/2, kisannagar', 5, 6, 'ba691747d1994453a07cf184ad4a779f', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5881, 3, 'Hardik Nenuji 15 ', 'hardik nenuji 15 @gmail.com', 'hardik nenuji 15 ', '919714239708', '', 1, '1993-11-10', '0', 0.00000000, 0.00000000, 'B-1 GJTI', 5, 6, 'aadb4f2df5ab4581ae7c092f50521261', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5882, 3, 'Jainil K Patel 15 ', 'jainil k patel 15 @gmail.com', 'jainil k patel 15 ', '919904452801', '9909752583', 1, '2000-03-03', '0', 0.00000000, 0.00000000, 'LDRP Hostel', 5, 6, 'ad33290ef0de4892a8d2ae1d19f0ef2e', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5883, 3, 'Jay Jani 15 ', 'jay jani 15 @gmail.com', 'jay jani 15 ', '918469334185', '919879190523', 1, '1996-03-15', '0', 0.00000000, 0.00000000, 'LDRP Hostel', 5, 6, '106460034b4a49b9a1047cae07f55e29', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5884, 3, 'Keval Khambhadiya 15 LDRP ', 'keval khambhadiya 15 ldrp @gmail.com', 'keval khambhadiya 15 ldrp ', '917878108106', '9426966660', 1, '1998-08-03', '0', 0.00000000, 0.00000000, 'LDRP Hostel', 5, 6, '1bdb5e29628148e1bf9689b5a29f569f', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5885, 3, 'Kishan Patel 15 idar', 'kishan patel 15 idar@gmail.com', 'kishan patel 15 idar', '919409024945', '', 1, '1993-04-26', '0', 0.00000000, 0.00000000, 'B-2 GJTI', 5, 6, '730a1e0bcd274bbab16190947d9190d4', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5886, 3, 'Paras Mehta  New 15 ', 'paras mehta  new 15 @gmail.com', 'paras mehta  new 15 ', '91 94 08 742465', '91 94 29 269914', 1, '1996-07-21', '0', 0.00000000, 0.00000000, 'B 14 LDRP Hostel Kh 5', 5, 6, '965d9931a89c40baa93cb631e5744f8d', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5887, 3, 'Pratik Prajapati 15 Edar', 'pratik prajapati 15 edar@gmail.com', 'pratik prajapati 15 edar', '919725359417', '919979415789', 1, '1995-09-06', '0', 0.00000000, 0.00000000, 'LDRP Hostel', 5, 6, '86497f468dac471db2453ceef8df639f', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5888, 3, 'Rajni Popatbhai Thakor 15 ', 'rajni popatbhai thakor 15 @gmail.com', 'rajni popatbhai thakor 15 ', '9157937592', '919924008890', 1, '2000-12-27', '0', 0.00000000, 0.00000000, 'C/16 Ambika Dham 2', 5, 6, 'b9dd8c1c3fea4cd18425199b4986ba88', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5889, 3, 'Yogesh m sadat 15 ', 'yogesh m sadat 15 @gmail.com', 'yogesh m sadat 15 ', '917359452715', '', 1, '2000-12-27', '0', 0.00000000, 0.00000000, '', 5, 6, 'd63d6b6961e34b7bbdf376bdb246aa97', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5890, 3, 'Nilesh Devulkar Sec 6 ni sabhama', 'nilesh devulkar sec 6 ni sabhama@gmail.com', 'nilesh devulkar sec 6 ni sabhama', '917878060966', '91 98 98 977724', 1, '2000-12-27', '0', 0.00000000, 0.00000000, 'Sec 17', 5, 6, 'fc50abb9124f48d1a9e1d1568ba28c55', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5891, 3, 'Pankaj Dineshbhai Rathod 17 ', 'pankaj dineshbhai rathod 17 @gmail.com', 'pankaj dineshbhai rathod 17 ', '91 99 09 993364', '', 1, '2000-06-23', '0', 0.00000000, 0.00000000, '38/3 CHH Type', 5, 1, '58fcc01d03c64966b5577569c5d1d51a', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5892, 3, 'Parth Vasantbhai Parmar 17 ', 'parth vasantbhai parmar 17 @gmail.com', 'parth vasantbhai parmar 17 ', '919104370083', '919408635047', 1, '2000-01-09', '0', 0.00000000, 0.00000000, '38/2, Chh Type', 5, 6, '33001695331b47a1a57d2e54d73ecdba', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5893, 3, 'Sharad Patel 17 ', 'sharad patel 17 @gmail.com', 'sharad patel 17 ', '919714595790', '', 1, '1999-12-14', '0', 0.00000000, 0.00000000, 'Uvarshad, Mahakali road', 5, 6, 'aa8d44aee64c4440a06badb64d1c3d2d', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5894, 3, 'Amit Bharatbhai Gohil 19 ', 'amit bharatbhai gohil 19 @gmail.com', 'amit bharatbhai gohil 19 ', '91 95 58 326268', '', 1, '2002-09-24', '0', 0.00000000, 0.00000000, 'Kh 2/6', 5, 6, '0f28c19bd11e4f1db204aef321f71755', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5895, 3, 'Ankit Detroja 19 ', 'ankit detroja 19 @gmail.com', 'ankit detroja 19 ', '917600008354', '7227917377', 1, '1992-06-26', '0', 0.00000000, 0.00000000, '274/3 , Gh Type', 5, 2, '5bf89afd97154016ab8b21cb422f8698', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5896, 3, 'Harshnil Mukeshbhai chaudhry 19 ', 'harshnil mukeshbhai chaudhry 19 @gmail.com', 'harshnil mukeshbhai chaudhry 19 ', '91 98 79 201486', '91 96 87 209392', 1, '1999-10-27', '0', 0.00000000, 0.00000000, 'Aishwarya I', 5, 6, '58da880df99b4c26b1c6bcf4c6a549a3', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5897, 3, 'Het patel 19 ', 'het patel 19 @gmail.com', 'het patel 19 ', '919898991524', '919426401524', 1, '2000-07-06', '0', 0.00000000, 0.00000000, 'Shopping same, aishvarya flat pachhal, 125 block', 5, 6, '96cd388df8b140f296a59d9dda76f929', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5898, 3, 'Tarun Katariya 19 ', 'tarun katariya 19 @gmail.com', 'tarun katariya 19 ', '919426326928', '919998999889', 1, '2000-09-30', '0', 0.00000000, 0.00000000, 'Plot 20/a, 2/a block, prayosha flat', 5, 6, 'accb8ba1e89d40fc8fed93220bc551fc', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5899, 1, 'Vatsal D Modi New 19 ', 'vatsalmodi@gmail.com', 'vatsalm', '91 90 99 003999', '9428474748', 1, '1997-02-15', '0', 0.00000000, 0.00000000, 'Gh 273/3', 5, 6, '09688485131140a6b01d5abe08045712', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5900, 3, 'Vijay bal madhyastha 19 ', 'vijay bal madhyastha 19 @gmail.com', 'vijay bal madhyastha 19 ', '919998026091', '', 1, '1986-09-25', '0', 0.00000000, 0.00000000, '', 5, 6, 'f310c07870974ab3bfea84c121fcb1ed', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5901, 3, 'Chintan barot 20 ', 'chintan barot 20 @gmail.com', 'chintan barot 20 ', '919924678256', '9327601154', 1, '1997-11-03', '0', 0.00000000, 0.00000000, '46/2, chh type', 5, 6, '1d730832f411431793c6db291d7d83f8', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5902, 3, 'Deepvardhan Patel 20 ', 'deepvardhan patel 20 @gmail.com', 'deepvardhan patel 20 ', '919898672005', '', 1, '2000-09-03', '0', 0.00000000, 0.00000000, '312, Infront of Rajshree Cinema', 5, 6, 'e77346901b3a45518c907e010c9be059', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5903, 3, 'Dhanrajsinh u chauhan 20 ', 'dhanrajsinh u chauhan 20 @gmail.com', 'dhanrajsinh u chauhan 20 ', '919427526031', '9909807789', 1, '1994-04-29', '0', 0.00000000, 0.00000000, '49/1, chh type', 5, 6, '84b956d4afcb429cb83b889bfbed4a12', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5904, 3, 'Dhrumil chauhan 20 ', 'dhrumil chauhan 20 @gmail.com', 'dhrumil chauhan 20 ', '91 99 13 764357', '919825765981', 1, '2000-10-02', '0', 0.00000000, 0.00000000, '17/4, gh type govt. Qvatet, near rangmanch', 5, 6, 'd014056389ba415c96c907b9e79d9e87', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5905, 3, 'Dhruvik Chandulal Chavda 20 ', 'dhruvik chandulal chavda 20 @gmail.com', 'dhruvik chandulal chavda 20 ', '91 94 29 615513', '91 94 29 615513', 1, '2000-10-31', '0', 0.00000000, 0.00000000, '108/1, J Type', 5, 6, 'e8155780c7f64c96a2e9f7936f6fa193', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5906, 3, 'Harikrishna zala 20 ', 'harikrishna zala 20 @gmail.com', 'harikrishna zala 20 ', '917567818257', '', 1, '2000-03-16', '0', 0.00000000, 0.00000000, '20, chhapra', 5, 6, '781cf43619c2452b8fe022843f0241ec', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5907, 3, 'Krutarth Jani 20 ', 'krutarth jani 20 @gmail.com', 'krutarth jani 20 ', '919825019331', '917923262164', 1, '1999-11-07', '0', 0.00000000, 0.00000000, '234/B Sujata Appt.', 5, 6, 'ddd6ed29243c47daa23b9342ffc57564', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5908, 3, 'Naman j joshi 20 ', 'naman j joshi 20 @gmail.com', 'naman j joshi 20 ', '919725423825', '', 1, '2001-08-27', '0', 0.00000000, 0.00000000, '', 5, 3, '5e8d3420a8f8435a97634dc8ccbef1af', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5909, 3, 'Nrupvardhan Patel 20 ', 'nrupvardhan patel 20 @gmail.com', 'nrupvardhan patel 20 ', '919944917194', '', 1, '1997-10-08', '0', 0.00000000, 0.00000000, '312, Infront of Rajshree Cinema', 5, 6, '9caf5a5493e54055a55be86473267788', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5910, 3, 'Param Desai 20 ', 'param desai 20 @gmail.com', 'param desai 20 ', '919998996196', '', 1, '1999-08-10', '0', 0.00000000, 0.00000000, '355, b/h nigam petrolpump', 5, 6, '4d8dadde60ef442087ceb129ab5010bc', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5911, 3, 'Pranaysinh rana 20 ', 'pranaysinh rana 20 @gmail.com', 'pranaysinh rana 20 ', '919925186366', '', 1, '1999-11-09', '0', 0.00000000, 0.00000000, '89/6, ch type', 5, 6, '3ac6ac1eb60e43b69902268d326e63bf', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5912, 3, 'Smit Nautambhai Modi 20 ', 'smit nautambhai modi 20 @gmail.com', 'smit nautambhai modi 20 ', '91 94 26 282929', '91 94 29 068520', 1, '2001-12-21', '0', 0.00000000, 0.00000000, '294, Pramukh Apt', 5, 6, '158726d6fb9540f28b1b159e6ebd6e3d', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5913, 3, 'Yuvrajsinh Dashrathsinh Chavda 20 ', 'yuvrajsinh dashrathsinh chavda 20 @gmail.com', 'yuvrajsinh dashrathsinh chavda 20 ', '91 99 25 721371', '', 1, '2001-10-20', '0', 0.00000000, 0.00000000, '48/2 Chh Type', 5, 6, 'b01b4a19c2344061b06a24f9270f39dd', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5914, 3, 'Akshar bhavsar 21 ', 'akshar bhavsar 21 @gmail.com', 'akshar bhavsar 21 ', '919724727678', '919099385838', 1, '1988-05-15', '0', 0.00000000, 0.00000000, '534/2,Vastunirman Society, Sector-22', 5, 6, 'f6196adc12394f1eb05d157127f79ee9', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5915, 3, 'Akshar Parshottambhai Parmar 21 ', 'akshar parshottambhai parmar 21 @gmail.com', 'akshar parshottambhai parmar 21 ', '919723172372', '', 1, '1999-09-09', '0', 0.00000000, 0.00000000, 'Pramukh Residency, Panchshil Park Soc', 5, 6, '46dc55eca9604a5a91719903b000c11c', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5916, 3, 'Ashvin Gurjar 21 ', 'ashvin gurjar 21 @gmail.com', 'ashvin gurjar 21 ', '919998011072', '919998914891', 1, '1990-10-09', '0', 0.00000000, 0.00000000, '38/1,Chh type', 5, 5, '66118f102a7e4a7a87182a4d51ae2f5c', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5917, 3, 'Ayush Borad 21 New ', 'ayush borad 21 new @gmail.com', 'ayush borad 21 new ', '919727143203', '919824193307', 1, '2001-04-01', '0', 0.00000000, 0.00000000, '767 ; Panchshil Park', 5, 6, '58d83398b73c4be0817fbdb77bf8b6b1', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5918, 3, 'Devarsh patel 21 ', 'devarsh patel 21 @gmail.com', 'devarsh patel 21 ', '919099962946', '', 1, '1995-06-22', '0', 0.00000000, 0.00000000, 'Panchshil park', 5, 6, '0a7c67d271654e658e707cbb9ac16637', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5919, 3, 'Dhruvil Bhatt 21 Maheshbhai ', 'dhruvil bhatt 21 maheshbhai @gmail.com', 'dhruvil bhatt 21 maheshbhai ', '919427968354', '919825722365', 1, '2001-09-06', '0', 0.00000000, 0.00000000, '529/1,Aavkar Tenament, nr. Housing board quarters', 5, 6, 'da21d9916153446fa70f5fc4db8c74cd', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5920, 3, 'Gautam aasundra 21 ', 'gautam aasundra 21 @gmail.com', 'gautam aasundra 21 ', '919624836720', '919429026378', 1, '1992-11-09', '0', 0.00000000, 0.00000000, '46/2,Chh type', 5, 6, '2b2bf2c427c74600a99f843a9567b884', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5921, 3, 'Indraraj Raol 21 ', 'indraraj raol 21 @gmail.com', 'indraraj raol 21 ', '919054011652', '919723066138', 1, '1997-09-19', '0', 0.00000000, 0.00000000, '30,Guj Housing Board', 5, 6, '6667452932894d7187f5f271bd318451', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5922, 3, 'Mahideepsinh Harvijaysinh Sarvaiya 21 ', 'mahideepsinh harvijaysinh sarvaiya 21 @gmail.com', 'mahideepsinh harvijaysinh sarvaiya 21 ', '91 99 24 577911', '91 95 86 800567', 1, '1999-12-28', '0', 0.00000000, 0.00000000, '40/6, Chh Type', 5, 6, 'b2ac3abe861b48e180f61a5cfcbfc37d', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5923, 3, 'Manmeetsinh H Vaghela 21 ', 'manmeetsinh h vaghela 21 @gmail.com', 'manmeetsinh h vaghela 21 ', '91 99 78 920777', '', 1, '2001-08-20', '0', 0.00000000, 0.00000000, '744, Panchshil Park', 5, 3, '5fcca7bb8fac4c81a8427b4cd981844b', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5924, 3, 'Mohit Manral 21 ', 'mohit manral 21 @gmail.com', 'mohit manral 21 ', '919427702330', '', 1, '2000-09-27', '0', 0.00000000, 0.00000000, '93/14, J Type', 5, 6, 'ee04d95aa00a41cd91f5c8d3807ea5ec', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5925, 3, 'Nandish Desai 21 ', 'nandish desai 21 @gmail.com', 'nandish desai 21 ', '918980947474', '', 1, '1999-09-15', '0', 0.00000000, 0.00000000, '669, Panchsil Park', 5, 6, '1fe8f510afdd4748b20bd8c83f4e9e74', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5926, 3, 'Parth R Parekh 21 ', 'parth r parekh 21 @gmail.com', 'parth r parekh 21 ', '91 97 23 013501', '', 1, '2001-09-19', '0', 0.00000000, 0.00000000, 'Panchshilpark Soc.', 5, 6, '900c81c976a74c8c9611878fd337edea', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5927, 3, 'Rajveer Raol 21 ', 'rajveer raol 21 @gmail.com', 'rajveer raol 21 ', '919033016215', '919824161215', 1, '1996-06-27', '0', 0.00000000, 0.00000000, '763/2,Panchsheel Park Soc.', 5, 6, 'a5cee1fefd6e45caa7bbc3c7ccc32875', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5928, 3, 'Sudip Raval 21 ', 'sudip raval 21 @gmail.com', 'sudip raval 21 ', '919558051250', '919426769094', 1, '1996-06-27', '0', 0.00000000, 0.00000000, '771/2, panchsil park', 5, 6, 'e95ada89a1274712bd9e1be0b5e5ad91', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5929, 3, 'Vandan Bakulbhai Patel 21 ', 'vandan bakulbhai patel 21 @gmail.com', 'vandan bakulbhai patel 21 ', '919426769616', '919924136891', 1, '2002-01-25', '0', 0.00000000, 0.00000000, '597/7, Chh Type, Category III', 5, 6, '7fb8e3eab7eb4103906a5998ee695c27', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5930, 3, 'Vatsal Vyas 21 ', 'vatsal vyas 21 @gmail.com', 'vatsal vyas 21 ', '919824144036', '919558994844', 1, '1997-11-15', '0', 0.00000000, 0.00000000, '722/2A, Panchshil Park', 5, 6, '0f05919c4ec84a2a9e8b54d129ac1e85', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5931, 3, 'Vishvaraj Raol 21 ', 'vishvaraj raol 21 @gmail.com', 'vishvaraj raol 21 ', '919574707667', '919879998465', 1, '1996-10-28', '0', 0.00000000, 0.00000000, '534/2 vastunirman society', 5, 6, 'a226e5f52d684d3f8408ffe63034fda8', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5932, 3, 'Yash Prajapati 21 ', 'yash prajapati 21 @gmail.com', 'yash prajapati 21 ', '919409561335', '9427318096', 1, '2000-04-22', '0', 0.00000000, 0.00000000, '599/11, j-1 category', 5, 6, '788880b4858543689360a1ea64977ecb', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5933, 3, 'Yatindra Solanki 21 ', 'yatindra solanki 21 @gmail.com', 'yatindra solanki 21 ', '917383025408', '919824013719', 1, '1991-11-06', '0', 0.00000000, 0.00000000, '126/3 GH Type', 5, 6, '334fd94c575640548040fedda91c7023', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5934, 3, 'Aniruddhsinh Rathod 22 ', 'aniruddhsinh rathod 22 @gmail.com', 'aniruddhsinh rathod 22 ', '919925944292', '', 1, '2001-01-10', '0', 0.00000000, 0.00000000, '105 /10 "chh" type', 5, 6, '833ad1afd56d4d3fa77cf13aa79ad625', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5935, 3, 'Ayush Dipesh Chauhan 22 ', 'ayush dipesh chauhan 22 @gmail.com', 'ayush dipesh chauhan 22 ', '91 94 27 010222', '91 94 29 700606', 1, '2002-03-18', '0', 0.00000000, 0.00000000, '468/2, Indraprastha Soc.', 5, 6, 'ef28658b76ec4df4a331353048ce9653', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5936, 3, 'Bhargav Patel 22 ', 'bhargav patel 22 @gmail.com', 'bhargav patel 22 ', '8128448414', '9724838272', 1, '2001-01-23', '0', 0.00000000, 0.00000000, '70/1, J Type Near Aiyurvedik Hospital', 5, 6, 'a92dffbca6a64df5a90dc2a3902470fd', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5937, 3, 'Chirag Trivedi 22 ', 'chirag trivedi 22 @gmail.com', 'chirag trivedi 22 ', '917698389570', '919662502919', 1, '2000-06-24', '0', 0.00000000, 0.00000000, '427/1, Kalpana Society', 5, 6, '1f7e13254235409ca618503696a1ddea', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5938, 3, 'Darshil Prajapati 22 ', 'darshil prajapati 22 @gmail.com', 'darshil prajapati 22 ', '919898541076', '9725668113', 1, '2000-10-13', '0', 0.00000000, 0.00000000, '104/8,\\"Chh\\"Type', 5, 6, 'a5938c3f81534c28b411b929a3ee690c', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5939, 3, 'Dhruvanshu Patel 22 ', 'dhruvanshu patel 22 @gmail.com', 'dhruvanshu patel 22 ', '919687638473', '', 1, '1997-12-09', '0', 0.00000000, 0.00000000, '403/1, yogibhuvan, nr police choki', 5, 6, '6739b9adec5841efb5c96d779df24609', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5940, 3, 'Digvirajsinh Prahladsinh Jadeja 22 ', 'digvirajsinh prahladsinh jadeja 22 @gmail.com', 'digvirajsinh prahladsinh jadeja 22 ', '91 99 04 823698', '91 94 28 405790', 1, '1999-10-22', '0', 0.00000000, 0.00000000, '112/10, Chh Type', 5, 6, 'fb6616d119d34059b38d000d375651fa', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5941, 3, 'Gautam Patel 22 ', 'gautam patel 22 @gmail.com', 'gautam patel 22 ', '919409611027', '918347323773', 1, '1999-10-22', '0', 0.00000000, 0.00000000, '84/1 \'J\' type', 5, 6, 'bf028c2fa6df4b2b92321afdbdb18533', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5942, 3, 'Hardik Suthar 22 ', 'hardik suthar 22 @gmail.com', 'hardik suthar 22 ', '919409542465', '', 1, '1998-01-18', '0', 0.00000000, 0.00000000, '183/5Manan App.', 5, 6, '3f37434b3bff4432b75a0c857b2cd2c7', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5943, 3, 'Harshal Patel 22 ', 'harshal patel 22 @gmail.com', 'harshal patel 22 ', '919429633322', '', 1, '1996-07-18', '0', 0.00000000, 0.00000000, 'Plot No.-286, shreyas society', 5, 6, 'e310ac12ccad4b6c8b0fbdafd68e0306', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5944, 3, 'Hit j kapadiya 22 ', 'hit j kapadiya 22 @gmail.com', 'hit j kapadiya 22 ', '919173530766', '', 1, '1996-07-18', '0', 0.00000000, 0.00000000, '', 5, 6, '3d34387ab6e44a828185d48cd154791b', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5945, 3, 'Hitarth Mayurbhai Jani 22 ', 'hitarth mayurbhai jani 22 @gmail.com', 'hitarth mayurbhai jani 22 ', '919737661246', '919879155038', 1, '2000-03-16', '0', 0.00000000, 0.00000000, '9, Indraprastha society', 5, 6, '8c0b88042f39439e9db7facb454c24c9', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5946, 3, 'Javal Dave 22 ', 'javal dave 22 @gmail.com', 'javal dave 22 ', '919998444409', '918401100789', 1, '1996-08-27', '0', 0.00000000, 0.00000000, '147/2,Anand Vatika soc. Nr panchdev temple', 5, 6, '28f7aa8ef06b453c91afb0c906e48b7d', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5947, 3, 'Jay V Patel 22 ', 'jay v patel 22 @gmail.com', 'jay v patel 22 ', '918690093009', '919722239898', 1, '1994-12-30', '0', 0.00000000, 0.00000000, '446/2,Rachna', 5, 6, '4dd8f158ab1946afaa5490fa975dc786', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5948, 3, 'Jaykishan Brahmbhatt 22 ', 'jaykishan brahmbhatt 22 @gmail.com', 'jaykishan brahmbhatt 22 ', '919924044991', '919998992466', 1, '2000-04-27', '0', 0.00000000, 0.00000000, '301/4, shreyash society', 5, 6, '75303a30dc1f437c92b82bc695c8c146', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5949, 3, 'Keyur I Chaudhry 22 ', 'keyur i chaudhry 22 @gmail.com', 'keyur i chaudhry 22 ', '91 76 00 807820', '', 1, '1997-11-08', '0', 0.00000000, 0.00000000, '414/1, Nr. Policechoki', 5, 6, 'f95c9b27fe4545dcb36eeaad94d7b049', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5950, 3, 'Kunj Patel', 'kunj patel@gmail.com', 'kunj patel', '7878255179', '', 1, '1997-11-08', '0', 0.00000000, 0.00000000, '', 5, 6, 'dab2ebe417bc4900a6f3b3a2b9a1922d', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5951, 3, 'Krunal Patel 22 New ', 'krunal patel 22 new @gmail.com', 'krunal patel 22 new ', '919998995306', '7600810446', 1, '1985-04-28', '0', 0.00000000, 0.00000000, '119/5 ; \\"CH\\" Type ; SEC 22', 5, 6, '0e438ed3801f46dcba6be913eec8e6ca', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5952, 3, 'Kuldipsingh Jadeja 22 ', 'kuldipsingh jadeja 22 @gmail.com', 'kuldipsingh jadeja 22 ', '919427026966', '919904866936', 1, '1999-01-30', '0', 0.00000000, 0.00000000, '91/2 chh type', 5, 4, '601776b147bb43a8ba5e7a40418b871f', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5953, 3, 'Mayank Mehta 22 ', 'mayank mehta 22 @gmail.com', 'mayank mehta 22 ', '919428814493', '', 1, '1999-05-01', '0', 0.00000000, 0.00000000, '66/7, J-TYPE', 5, 6, '52db090a8826403a8b8ec9bfa1c28bfe', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5954, 3, 'Mayur khoda 22 ', 'mayur khoda 22 @gmail.com', 'mayur khoda 22 ', '919904790280', '919979431459', 1, '2000-02-08', '0', 0.00000000, 0.00000000, '102/6 chh type', 5, 6, 'f28b3a2309b348258e8f0708565fa740', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5955, 3, 'Meet Chaudhary 22 ', 'meet chaudhary 22 @gmail.com', 'meet chaudhary 22 ', '919929107297', '', 1, '1999-07-17', '0', 0.00000000, 0.00000000, '414/1, front of poice station', 5, 6, 'ee7446d289ce478bb8d9380a02696bef', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5956, 3, 'Milan chauhan 22 ', 'milan chauhan 22 @gmail.com', 'milan chauhan 22 ', '919033804759', '', 1, '1999-07-17', '0', 0.00000000, 0.00000000, '', 5, 6, '54d51afc65a84e1eac307a343bf5b762', '0', '2018-01-15 21:57:56', '2018-01-15 21:57:56', 0, 0, '0', 0, NULL, ''),
	(5957, 3, 'Nishith Suthar 22 ', 'nishith suthar 22 @gmail.com', 'nishith suthar 22 ', '919409542465', '917923241700', 1, '1997-03-28', '0', 0.00000000, 0.00000000, '183 S-2 Manan Aepartment', 5, 6, 'ab19654fb5694696bd8e6741e92d35a7', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5958, 3, 'Pranshu k Patel 22 ', 'pranshu k patel 22 @gmail.com', 'pranshu k patel 22 ', '919537696969', '919898064608', 1, '1997-10-29', '0', 0.00000000, 0.00000000, '378, shreyas society', 5, 6, 'ab3d63ab247141a4a271b14b8218dbaf', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5959, 1, 'Rajat Patel 22 ', 'rajatpatel@gmail.com', 'rajat', '919157792416', '7923246803', 1, '1997-12-07', '0', 0.00000000, 0.00000000, '546/1 Nandavan Society, Nr.Harimandir', 5, 6, 'e2de36eb1e9d41998d60c6b6ae914e2e', '0', '2018-01-15 21:58:03', '2018-01-17 23:27:51', 0, 0, '0', 0, NULL, ''),
	(5960, 3, 'Rakesh Valand 22 ', 'rakesh valand 22 @gmail.com', 'rakesh valand 22 ', '919904658728', '', 1, '1990-10-20', '0', 0.00000000, 0.00000000, '100/5,\\"Chh\\"Type', 5, 6, 'a75acfdd21d740f4b356ba624fef4a07', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5961, 3, 'Rushil m patel 22 ', 'rushil m patel 22 @gmail.com', 'rushil m patel 22 ', '919824507884', '917600000722', 1, '1999-06-24', '0', 0.00000000, 0.00000000, '538/2, nr. G6, nandanvan society', 5, 6, 'bb49db524e704ac19db61b903b3e1179', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5962, 3, 'Snehalsinh Rathod 22 ', 'snehalsinh rathod 22 @gmail.com', 'snehalsinh rathod 22 ', '918141005229', '919724264616', 1, '1997-07-03', '0', 0.00000000, 0.00000000, '105/7,\\"Chh\\"Type', 5, 6, '1b25a0cb3f1847e896f0b849a22608c5', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5963, 3, 'Ujjaval Sandesara 22 ', 'ujjaval sandesara 22 @gmail.com', 'ujjaval sandesara 22 ', '918141851099', '919426272873', 1, '1997-12-14', '0', 0.00000000, 0.00000000, '57/6, J Type', 5, 6, 'd524df37c33f4499a606499f3f4384ab', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5964, 3, 'Vatsal jani 22 ', 'vatsal jani 22 @gmail.com', 'vatsal jani 22 ', '1 302-235-3644', '919427272455', 1, '1995-01-13', '0', 0.00000000, 0.00000000, '461/1 indraprasth society', 5, 1, '5a8fd31cd439440bbb0421a1ec257057', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5965, 3, 'Vikram N Kharadi New 22 ', 'vikram n kharadi new 22 @gmail.com', 'vikram n kharadi new 22 ', '91 96 87 969412', '91 97 27 003193', 1, '2001-09-09', '0', 0.00000000, 0.00000000, '112/6 , Chh Type', 5, 6, '92f0f71fc49845dcae2ce3e587474736', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5966, 3, 'Vipul patel 22 ', 'vipul patel 22 @gmail.com', 'vipul patel 22 ', '918460509867', '919909393358', 1, '1997-04-25', '0', 0.00000000, 0.00000000, '351/2, Ahreyash Sos', 5, 6, '6e3bff04c4fb4b7ba5cdf8b5ad195061', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5967, 3, 'Vishva Gajjar New 22 ', 'vishva gajjar new 22 @gmail.com', 'vishva gajjar new 22 ', '91 84 60 488785', '91 99 24 850676', 1, '2000-05-05', '0', 0.00000000, 0.00000000, '112/5, Chh Type', 5, 6, '78c60f98ee8d459bad1be5a4e8ee3ff5', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5968, 3, 'Vishvajeetsinh Pravinsinh Solanki 22 ', 'vishvajeetsinh pravinsinh solanki 22 @gmail.com', 'vishvajeetsinh pravinsinh solanki 22 ', '91 99 24 850463', '91 99 04 336855', 1, '1999-12-06', '0', 0.00000000, 0.00000000, '618/b, Vastunirman Soc.', 5, 4, '6256ed2fc58a4d0fa45199d6c1431b68', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5969, 3, 'Yogesh Pareshbhai Rathod 22 ', 'yogesh pareshbhai rathod 22 @gmail.com', 'yogesh pareshbhai rathod 22 ', '91 94 29 524241', '', 1, '2001-08-25', '0', 0.00000000, 0.00000000, '19/3, Gh Type', 5, 6, '679932c1000a4ea49fed4eb7ed9accc0', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5970, 3, 'Akash m patel 29  ', 'akash m patel 29  @gmail.com', 'akash m patel 29  ', '917405763196', '', 1, '2001-08-25', '0', 0.00000000, 0.00000000, '', 5, 6, 'dc5bd805450443e492b9c234c3ca5529', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5971, 3, 'Avinash Bhatt 29 ', 'avinash bhatt 29 @gmail.com', 'avinash bhatt 29 ', '919427307555', '9909979655', 1, '1997-07-27', '0', 0.00000000, 0.00000000, '188/a,Aksharniketan,Near yuvachetna', 5, 6, '89c254f3933b4675825379d5da217268', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5972, 3, 'Deep Patel 29 ', 'deep patel 29 @gmail.com', 'deep patel 29 ', '919998058633', '', 1, '1999-02-08', '0', 0.00000000, 0.00000000, '', 5, 6, '7ccfe60fcda54facafdffe83183396eb', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5973, 3, 'Devarshi Dave 29 ', 'devarshi dave 29 @gmail.com', 'devarshi dave 29 ', '919408492456', '919428355996', 1, '1997-05-31', '0', 0.00000000, 0.00000000, '272/6,Shree Hari Park', 5, 6, '96acf8bebcd04c77bc0d6479483c2751', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5974, 3, 'Dilipsinh m rajput 29 ', 'dilipsinh m rajput 29 @gmail.com', 'dilipsinh m rajput 29 ', '919687314478', '', 1, '1997-05-31', '0', 0.00000000, 0.00000000, '', 5, 6, 'e33ea89ffd834ff2b09830182d8d4515', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5975, 3, 'Divyaraj Rajendrasinh Sagar 29 ', 'divyaraj rajendrasinh sagar 29 @gmail.com', 'divyaraj rajendrasinh sagar 29 ', '91 99 98 363800', '', 1, '2000-05-30', '0', 0.00000000, 0.00000000, '8/6, Chh Type, ', 5, 6, '01c258eab5dc469cbecfffe0ef5beeb9', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5976, 3, 'Jiten Parmar 29 ', 'jiten parmar 29 @gmail.com', 'jiten parmar 29 ', '919157134508', '918401943411', 1, '1997-10-01', '0', 0.00000000, 0.00000000, '7003/2,Near Cha-7 Circle', 5, 6, 'c5604cc4faa54ed8ad8f0e05648598cd', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5977, 3, 'Krunal Desai 29 ', 'krunal desai 29 @gmail.com', 'krunal desai 29 ', '918490907520', '917874808651', 1, '1996-04-10', '0', 0.00000000, 0.00000000, '168, sweet home, g2,', 5, 6, '39efd2fb71e64b6aa248ba3ce6d0a13e', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5978, 3, 'Mayur M Patel 29 ', 'mayur m patel 29 @gmail.com', 'mayur m patel 29 ', '919662391636', '', 1, '2001-09-16', '0', 0.00000000, 0.00000000, '210/6, Harikrupa Flat', 5, 6, '67cc3f3b325d4ea0b3d4281b2bf2b34a', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5979, 3, 'Parth thakar 29 ', 'parth thakar 29 @gmail.com', 'parth thakar 29 ', '918866138138', '', 1, '2001-09-16', '0', 0.00000000, 0.00000000, '', 5, 6, '851200fbfd184330869ec6e6f9cedb77', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5980, 3, 'Pruthvirajsinh Vaghela 29 ', 'pruthvirajsinh vaghela 29 @gmail.com', 'pruthvirajsinh vaghela 29 ', '919033880399', '', 1, '2001-09-16', '0', 0.00000000, 0.00000000, '', 5, 6, 'e5fb21d76d314732af2b730d62305e46', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5981, 3, 'Rushil j patel 29 ', 'rushil j patel 29 @gmail.com', 'rushil j patel 29 ', '919825848002', '', 1, '2001-03-05', '0', 0.00000000, 0.00000000, '400,  janki apt', 5, 4, '60172788037a457bbe053be8c7706962', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5982, 3, 'Sagar Parsana Gondal 29 ', 'sagar parsana gondal 29 @gmail.com', 'sagar parsana gondal 29 ', '91 7285 070 007', '91 90 33 351076', 1, '2001-03-05', '0', 0.00000000, 0.00000000, '257/1', 5, 6, '98a85e298b454b558e0e86d4e87c764d', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5983, 3, 'Saumya s joshi 29 ', 'saumya s joshi 29 @gmail.com', 'saumya s joshi 29 ', '919426705258', '917923210027', 1, '2000-05-11', '0', 0.00000000, 0.00000000, '\'Matrusadan\', Pramukh Residency, Citypulse', 5, 6, 'c3d5053b4a7a4a0e99a32307382ed335', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5984, 3, 'Shubham Parekh 29 ', 'shubham parekh 29 @gmail.com', 'shubham parekh 29 ', '919574306028', '', 1, '1994-07-27', '0', 0.00000000, 0.00000000, 'School No.-2,Near Police choky', 5, 6, '80154122c3a442cbb6cf30e7ed74cd16', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5985, 3, 'Yash Patel 29 ', 'yash patel 29 @gmail.com', 'yash patel 29 ', '91 77 78 080234', '', 1, '1997-04-11', '0', 0.00000000, 0.00000000, '285/4/A', 5, 6, '1ce912858d2648c087de0c63b1164b93', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5986, 3, 'Archan Solanki 30 Rameshbhai ', 'archan solanki 30 rameshbhai @gmail.com', 'archan solanki 30 rameshbhai ', '919904095933', '7046159030', 1, '1999-01-09', '0', 0.00000000, 0.00000000, 'Akshardham STAFF QUARTER 439/2', 5, 6, 'd33c9744a83d41d9880be9dbb99aceb4', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5987, 3, 'Brijesh makwana 30 ', 'brijesh makwana 30 @gmail.com', 'brijesh makwana 30 ', '918866142589', '', 1, '1994-09-25', '0', 0.00000000, 0.00000000, '576/2, pramukhkrupa flat, blok no 5', 5, 6, 'e2a4a7046b51497692141544747d0358', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5988, 3, 'Dakshil Rathod 30 ', 'dakshil rathod 30 @gmail.com', 'dakshil rathod 30 ', '91 93 75 413199', '', 1, '1994-09-25', '0', 0.00000000, 0.00000000, '99, Gujarat Housing Board Sarvodaynagar', 5, 6, 'e201b790291a466fbf166424fb1e50d6', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5989, 3, 'Darshan y patel 30 ', 'darshan y patel 30 @gmail.com', 'darshan y patel 30 ', '919426171568', '9825061568', 1, '1994-09-25', '0', 0.00000000, 0.00000000, '24, g.h.b. Sarvodaynagar', 5, 6, 'e8ff15ff49bf40ad93d8ca98fc747d25', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5990, 3, 'Dharmesh G keshur 30 ', 'dharmesh g keshur 30 @gmail.com', 'dharmesh g keshur 30 ', '1 609-373-9037', '918758121646', 1, '1991-07-04', '0', 0.00000000, 0.00000000, '439, D-3', 5, 6, '4a20423f9b034033b5291dfa287e1d73', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5991, 3, 'Dhruv Patel 30 ', 'dhruv patel 30 @gmail.com', 'dhruv patel 30 ', '917041354150', '917923260611', 1, '1999-11-03', '0', 0.00000000, 0.00000000, '680/2, Golden Park', 5, 6, 'd246c715aae547269fc719785deccb67', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5992, 3, 'Dhruv Yogesh Gajjar 30 ', 'dhruv yogesh gajjar 30 @gmail.com', 'dhruv yogesh gajjar 30 ', '919157033930', '91 98 25 012096', 1, '2001-08-28', '0', 0.00000000, 0.00000000, '80 Sarvodaynagar ', 5, 6, '77435ce261784d5f96c60aadc141c563', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5993, 3, 'Dron desai 30 ', 'dron desai 30 @gmail.com', 'dron desai 30 ', '919898967001', '', 1, '2000-01-14', '0', 0.00000000, 0.00000000, '575/2, satyam, Beside of Kendriya Vidhyalay', 5, 6, '6d28428b13b44797af71a358a18a8dca', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5994, 3, 'Hardevsinh Zala 30 ', 'hardevsinh zala 30 @gmail.com', 'hardevsinh zala 30 ', '919067694807', '', 1, '1996-03-11', '0', 0.00000000, 0.00000000, '48/a, near circuit house', 5, 6, 'f6d49c6818394398a6516d6c60a5eab8', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5995, 3, 'Harsh Patel 30 ', 'harsh patel 30 @gmail.com', 'harsh patel 30 ', '61 468 313 211', '919662668783', 1, '1994-03-09', '0', 0.00000000, 0.00000000, '213 ,Guj.Ho.Board', 5, 6, 'd427871539534ec682032528ab36a33a', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5996, 3, 'Harshil Patolia 30 ', 'harshil patolia 30 @gmail.com', 'harshil patolia 30 ', '917016401657', '917698459950', 1, '1993-08-16', '0', 0.00000000, 0.00000000, '576/2,Pramukhkrupa Flat', 5, 6, '1f10630ececb408681bc2314e2a650ce', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5997, 3, 'Hasit mehta 30 ', 'hasit mehta 30 @gmail.com', 'hasit mehta 30 ', '919033091129', '919925047798', 1, '1999-11-27', '0', 0.00000000, 0.00000000, '3/1 ch type,', 5, 6, 'e2c88db3554549cdb9d3e46b1aeef1b3', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5998, 3, 'Jaimin Chauhan 30 ', 'jaimin chauhan 30 @gmail.com', 'jaimin chauhan 30 ', '919409534111', '', 1, '1994-05-29', '0', 0.00000000, 0.00000000, '23, Sarvoday Nagar', 5, 6, '75c5461c053f47028dcf962c62ad44a3', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(5999, 3, 'Jay pandya 30 ', 'jay pandya 30 @gmail.com', 'jay pandya 30 ', '918460401404', '', 1, '1993-10-24', '0', 0.00000000, 0.00000000, '576/2', 5, 6, '860ea7a0253e4fcba8238429bdda8011', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(6000, 3, 'Jayrajsinh jadav 30 ', 'jayrajsinh jadav 30 @gmail.com', 'jayrajsinh jadav 30 ', '919898704537', '9106622835', 1, '2000-05-02', '0', 0.00000000, 0.00000000, '438, suryavandana, Gurudwara road', 5, 6, '313f2d1534184c7785bfa7da80897de8', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(6001, 3, 'Kashyap Pandya 30 ', 'kashyap pandya 30 @gmail.com', 'kashyap pandya 30 ', '918141619217', '919725194370', 1, '1998-09-11', '0', 0.00000000, 0.00000000, '575/1, shivam flat', 5, 6, 'a07b630c171e4ee8b4027fe9ccee0713', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(6002, 3, 'Kashyap Patel 30 ', 'kashyap patel 30 @gmail.com', 'kashyap patel 30 ', '919979971199', '', 1, '2000-09-22', '0', 0.00000000, 0.00000000, 'Por village', 5, 6, '8c2da11ea0d243028147429f0b6bddae', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(6003, 3, 'Keyur patel 30 ', 'keyur patel 30 @gmail.com', 'keyur patel 30 ', '91 884 901 3760', '918347555401', 1, '1986-02-19', '0', 0.00000000, 0.00000000, 'Block 25, Sarvodaynagar', 5, 6, '945f78d3a5c04d05ab11f228e0e8952c', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(6004, 3, 'Kinjalbhai darji 30 ', 'kinjalbhai darji 30 @gmail.com', 'kinjalbhai darji 30 ', '919724346523', '919428998055', 1, '1983-10-07', '0', 0.00000000, 0.00000000, 'Block 90, Sarvodaynagar', 5, 2, '5d45135dafb543159adc8bd600948dc9', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(6005, 3, 'Kirtan Patolia 30 ', 'kirtan patolia 30 @gmail.com', 'kirtan patolia 30 ', '91 95 74 711476', '91 95 86 729950', 1, '1998-05-26', '0', 0.00000000, 0.00000000, '576/2,Pramukhkrupa Flat', 5, 6, '1b373aeab1b04e399caee78602846402', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(6006, 3, 'Kuldip Bihola 30 ', 'kuldip bihola 30 @gmail.com', 'kuldip bihola 30 ', '919924129926', '919924444124', 1, '1999-05-18', '0', 0.00000000, 0.00000000, 'plot 633/2, Shantivan Soc.', 5, 6, 'cd7d0caae7524b088b3fe3c3b32c3a4f', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(6007, 3, 'Kuldip Pandya 30 ', 'kuldip pandya 30 @gmail.com', 'kuldip pandya 30 ', '919723355577', '917600013381', 1, '2000-11-16', '0', 0.00000000, 0.00000000, '852/5, j type,', 5, 6, '2b743352c750437a803adf756b3e8756', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(6008, 3, 'Mihirsinh Zala 30 ', 'mihirsinh zala 30 @gmail.com', 'mihirsinh zala 30 ', '91 96 24 608640', '', 1, '2002-01-11', '0', 0.00000000, 0.00000000, '439/c/2, Sec 30', 5, 6, '2b09763886ca47538e81aa5c73224a73', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(6009, 3, 'Mukund Bharodiya 30 ', 'mukund bharodiya 30 @gmail.com', 'mukund bharodiya 30 ', '919909581177', '', 1, '1999-01-03', '0', 0.00000000, 0.00000000, '189/5 Opp.Government Hospital', 5, 6, '6d4bae9b24cf46b3bed09c88d0d050e0', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(6010, 3, 'Narendra Sindha 30 ', 'narendra sindha 30 @gmail.com', 'narendra sindha 30 ', '919375421619', '918401579388', 1, '1999-01-03', '0', 0.00000000, 0.00000000, 'Plot No.-439/2,Opp. Shree Yogi Flat', 5, 6, 'aad8b0f4e2f44e16b6bbd8078d6db155', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(6011, 3, 'Nilkanth M Patel 30 ', 'nilkanth m patel 30 @gmail.com', 'nilkanth m patel 30 ', '91 77 78 842395', '91 84 90 028181', 1, '2002-12-09', '0', 0.00000000, 0.00000000, '342/4 Akshar Avenue Sec 30', 5, 6, '4bac96cadad74ca1ab2bc3c8a8db9687', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(6012, 3, 'Parth Jitendrabhai Shah 30 ', 'parth jitendrabhai shah 30 @gmail.com', 'parth jitendrabhai shah 30 ', '91 816 090 3591', '', 1, '1999-01-12', '0', 0.00000000, 0.00000000, '439/c3, staff quarters', 5, 6, '4bb11dc732df44e9881c63a2b1ac7c15', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(6013, 3, 'Pratik Patel 30 ', 'pratik patel 30 @gmail.com', 'pratik patel 30 ', '919737045505', '7990049795', 1, '1996-07-11', '0', 0.00000000, 0.00000000, 'Block no 17,Sarvoday  ', 5, 6, 'f2f910e85f3241479cc2dbf2f8aec5fd', '0', '2018-01-15 21:58:03', '2018-01-15 21:58:03', 0, 0, '0', 0, NULL, ''),
	(6014, 3, 'Preet Jiteshbhai Vanjara 30 ', 'preet jiteshbhai vanjara 30 @gmail.com', 'preet jiteshbhai vanjara 30 ', '91 99 09 555784', '91 99 98 999891', 1, '2001-09-18', '0', 0.00000000, 0.00000000, '345/4b, ', 5, 6, 'a5d8cbb34e0343bb96b78cfc207ff77a', '0', '2018-01-15 21:58:04', '2018-01-15 21:58:04', 0, 0, '0', 0, NULL, ''),
	(6015, 3, 'Priyank chauhan 30 ', 'priyank chauhan 30 @gmail.com', 'priyank chauhan 30 ', '918511888369', '919409514111', 1, '1993-10-11', '0', 0.00000000, 0.00000000, '92/1, chh type, near central university', 5, 6, 'f0d05aa1b31a4538aceb09be91941f57', '0', '2018-01-15 21:58:04', '2018-01-15 21:58:04', 0, 0, '0', 0, NULL, ''),
	(6016, 3, 'Malay Chauhan 30', 'malay chauhan 30@gmail.com', 'malay chauhan 30', '', '', 1, '1993-10-11', '0', 0.00000000, 0.00000000, '', 5, 6, '45b780ad1b7e4bf287239133843afe2d', '0', '2018-01-15 21:58:04', '2018-01-15 21:58:04', 0, 0, '0', 0, NULL, ''),
	(6017, 3, 'Rahul Thakor 30 ', 'rahul thakor 30 @gmail.com', 'rahul thakor 30 ', '919016573177', '919825299041', 1, '1993-11-03', '0', 0.00000000, 0.00000000, '195, g.h.b. Sarvodaynagar, sec 30', 5, 6, '6c9af34b5f2545cf83e2f71d3ffaf578', '0', '2018-01-15 21:58:04', '2018-01-15 21:58:04', 0, 0, '0', 0, NULL, ''),
	(6018, 3, 'Rushi dave 30 ', 'rushi dave 30 @gmail.com', 'rushi dave 30 ', '919379809191', '919924236606', 1, '1996-09-17', '0', 0.00000000, 0.00000000, 'B/2, sec 30 hardevsinh no friend', 5, 6, 'aa8e42afe6b6436981a14d7240330dda', '0', '2018-01-15 21:58:04', '2018-01-15 21:58:04', 0, 0, '0', 0, NULL, ''),
	(6019, 3, 'Sagar Darji 30 ', 'sagar darji 30 @gmail.com', 'sagar darji 30 ', '919537398301', '', 1, '1996-01-22', '0', 0.00000000, 0.00000000, '87 Sarvoday Society', 5, 6, '835472fe4ae146c3a2922254a04cb31e', '0', '2018-01-15 21:58:04', '2018-01-15 21:58:04', 0, 0, '0', 0, NULL, ''),
	(6020, 3, 'Sahil Dilipbhai Patel 30 ', 'sahil dilipbhai patel 30 @gmail.com', 'sahil dilipbhai patel 30 ', '91 99 98 966138', '', 1, '2001-09-30', '0', 0.00000000, 0.00000000, '171', 5, 6, '8c72e1c6d73a40b1b9cd7ae10969d573', '0', '2018-01-15 21:58:04', '2018-01-15 21:58:04', 0, 0, '0', 0, NULL, ''),
	(6021, 3, 'Shubham V Chauhan 30 ', 'shubham v chauhan 30 @gmail.com', 'shubham v chauhan 30 ', '91 98 24 999576', '', 1, '2001-12-21', '0', 0.00000000, 0.00000000, '797', 5, 6, 'c650b3f178da41098edff626a0e232f4', '0', '2018-01-15 21:58:04', '2018-01-15 21:58:04', 0, 0, '0', 0, NULL, ''),
	(6022, 3, 'Smit Chandrakant Patel 30 ', 'smit chandrakant patel 30 @gmail.com', 'smit chandrakant patel 30 ', '91 98 79 922564', '', 1, '1999-11-17', '0', 0.00000000, 0.00000000, '172, Sarvodaynagar', 5, 6, '423824bb240145c189f024b9b18ba333', '0', '2018-01-15 21:58:04', '2018-01-15 21:58:04', 0, 0, '0', 0, NULL, ''),
	(6023, 3, 'Tirth Patel 30 ', 'tirth patel 30 @gmail.com', 'tirth patel 30 ', '919904919325', '919374019325', 1, '1998-08-28', '0', 0.00000000, 0.00000000, '667/1, golden park', 5, 6, 'fbe12baff1ca4060a69cb1d555965049', '0', '2018-01-15 21:58:04', '2018-01-15 21:58:04', 0, 0, '0', 0, NULL, ''),
	(6024, 3, 'Vraj A Patel 30 ', 'vraj a patel 30 @gmail.com', 'vraj a patel 30 ', '919737296942', '917698811399', 1, '1998-08-15', '0', 0.00000000, 0.00000000, '758/1 Jagrutipark Society', 5, 6, '48789deb3a5d4fc1a270915777ebfc48', '0', '2018-01-15 21:58:04', '2018-01-15 21:58:04', 0, 0, '0', 0, NULL, ''),
	(6025, 3, 'Yogesh n dumaniya 30 ', 'yogesh n dumaniya 30 @gmail.com', 'yogesh n dumaniya 30 ', '918128261555', '', 1, '1991-01-13', '0', 0.00000000, 0.00000000, 'Central university of gujarat', 5, 6, '2f01f4a6dd344c938a5676d88f46bdb0', '0', '2018-01-15 21:58:04', '2018-01-15 21:58:04', 0, 0, '0', 0, NULL, ''),
	(6026, 3, 'Yuvraj Zala 30 ', 'yuvraj zala 30 @gmail.com', 'yuvraj zala 30 ', '919374563616', '919427979163', 1, '1999-08-20', '0', 0.00000000, 0.00000000, 'P 48a, opp. circuit house', 5, 6, '1f30499f2af147319a6b5142d1ca0b3d', '0', '2018-01-15 21:58:04', '2018-01-15 21:58:04', 0, 0, '0', 0, NULL, ''),
	(6027, 3, 'Aditya Trivedi', 'aditya trivedi@gmail.com', 'aditya trivedi', '8469132791', '9825448314', 1, '2003-02-04', '0', 0.00000000, 0.00000000, '677/2, Golden park sos.', 5, 6, 'e1ce72d1f674403093b4a30f375fb094', '0', '2018-01-15 21:58:04', '2018-01-15 21:58:04', 0, 0, '0', 0, NULL, '');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


-- Dumping structure for table xboxlive_akdm.userstatus
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

-- Dumping data for table xboxlive_akdm.userstatus: ~0 rows (approximately)
/*!40000 ALTER TABLE `userstatus` DISABLE KEYS */;
/*!40000 ALTER TABLE `userstatus` ENABLE KEYS */;


-- Dumping structure for table xboxlive_akdm.userstatushistory
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

-- Dumping data for table xboxlive_akdm.userstatushistory: ~0 rows (approximately)
/*!40000 ALTER TABLE `userstatushistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `userstatushistory` ENABLE KEYS */;


-- Dumping structure for table xboxlive_akdm.user_normal_details
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

-- Dumping data for table xboxlive_akdm.user_normal_details: 7 rows
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


-- Dumping structure for table xboxlive_akdm.user_permission
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

-- Dumping data for table xboxlive_akdm.user_permission: ~0 rows (approximately)
/*!40000 ALTER TABLE `user_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_permission` ENABLE KEYS */;


-- Dumping structure for table xboxlive_akdm.user_roles
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  `role_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table xboxlive_akdm.user_roles: ~3 rows (approximately)
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` (`id`, `role_name`, `role_description`) VALUES
	(1, 'Admin Users', 'Admin'),
	(2, 'app_user', 'application user'),
	(3, 'app_santo', 'Santo');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;


-- Dumping structure for table xboxlive_akdm.user_rules
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

-- Dumping data for table xboxlive_akdm.user_rules: ~8 rows (approximately)
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


-- Dumping structure for table xboxlive_akdm.user_rules_menu
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

-- Dumping data for table xboxlive_akdm.user_rules_menu: ~6 rows (approximately)
/*!40000 ALTER TABLE `user_rules_menu` DISABLE KEYS */;
INSERT INTO `user_rules_menu` (`id`, `category`, `parent_id`, `user_rules_id`, `label`, `class`, `url`, `position`, `status`) VALUES
	(1, 'admin', 0, 1, 'Dashboard', 'icon-home', 'site/index', 1, 1),
	(2, 'admin', 0, 2, 'Users', 'icon-home', 'users/index', 2, 1),
	(3, 'admin', 0, 3, 'Post', 'icon-home', 'post/index', 3, 1),
	(4, 'admin', 0, 3, 'Location', 'icon-home', 'maps/index', 3, 1),
	(5, 'admin', 0, 3, 'Category', 'icon-category', 'category/index', 3, 1),
	(6, 'admin', 0, 8, 'Gii', 'icon-home', 'gii/index', 4, 1);
/*!40000 ALTER TABLE `user_rules_menu` ENABLE KEYS */;


-- Dumping structure for table xboxlive_akdm.user_satsang_details
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

-- Dumping data for table xboxlive_akdm.user_satsang_details: ~7 rows (approximately)
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


-- Dumping structure for table xboxlive_akdm.user_skills
DROP TABLE IF EXISTS `user_skills`;
CREATE TABLE IF NOT EXISTS `user_skills` (
  `user_skill_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  PRIMARY KEY (`user_skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table xboxlive_akdm.user_skills: ~0 rows (approximately)
/*!40000 ALTER TABLE `user_skills` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_skills` ENABLE KEYS */;


-- Dumping structure for table xboxlive_akdm.yuva_attendance
DROP TABLE IF EXISTS `yuva_attendance`;
CREATE TABLE IF NOT EXISTS `yuva_attendance` (
  `sabha_id` int(11) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `is_attended` tinyint(4) DEFAULT NULL,
  `mandal_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table xboxlive_akdm.yuva_attendance: ~0 rows (approximately)
/*!40000 ALTER TABLE `yuva_attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `yuva_attendance` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

