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

-- Data exporting was unselected.
-- Dumping structure for table akshardh_ms.attendance
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE IF NOT EXISTS `attendance` (
  `attendance_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `sabha_id` int(11) NOT NULL,
  `is_attended` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table akshardh_ms.blood_groups
DROP TABLE IF EXISTS `blood_groups`;
CREATE TABLE IF NOT EXISTS `blood_groups` (
  `blood_group_id` int(11) NOT NULL AUTO_INCREMENT,
  `blood_group_title` varchar(20) NOT NULL,
  PRIMARY KEY (`blood_group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table akshardh_ms.countries
DROP TABLE IF EXISTS `countries`;
CREATE TABLE IF NOT EXISTS `countries` (
  `countries_id` int(11) NOT NULL AUTO_INCREMENT,
  `countries_name` varchar(64) NOT NULL DEFAULT '',
  `countries_iso_code` varchar(2) NOT NULL,
  `countries_isd_code` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`countries_id`)
) ENGINE=InnoDB AUTO_INCREMENT=258 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
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

-- Data exporting was unselected.
-- Dumping structure for table akshardh_ms.mandals
DROP TABLE IF EXISTS `mandals`;
CREATE TABLE IF NOT EXISTS `mandals` (
  `mandal_id` int(11) NOT NULL AUTO_INCREMENT,
  `mandal_title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`mandal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Data exporting was unselected.
-- Dumping structure for table akshardh_ms.myguests
DROP TABLE IF EXISTS `myguests`;
CREATE TABLE IF NOT EXISTS `myguests` (
  `id` int(6) unsigned NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
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

-- Data exporting was unselected.
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

-- Data exporting was unselected.
-- Dumping structure for table akshardh_ms.skills
DROP TABLE IF EXISTS `skills`;
CREATE TABLE IF NOT EXISTS `skills` (
  `skill_id` int(11) NOT NULL AUTO_INCREMENT,
  `skill_title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Data exporting was unselected.
-- Dumping structure for table akshardh_ms.ssp
DROP TABLE IF EXISTS `ssp`;
CREATE TABLE IF NOT EXISTS `ssp` (
  `ssp_id` int(11) NOT NULL AUTO_INCREMENT,
  `ssp_title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ssp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Data exporting was unselected.
-- Dumping structure for table akshardh_ms.study
DROP TABLE IF EXISTS `study`;
CREATE TABLE IF NOT EXISTS `study` (
  `study_id` int(11) NOT NULL AUTO_INCREMENT,
  `study_title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`study_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Data exporting was unselected.
-- Dumping structure for table akshardh_ms.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'auto_increment id',
  `role_id` int(11) NOT NULL COMMENT 'Role id',
  `f_name` varchar(255) NOT NULL,
  `m_name` varchar(255) NOT NULL,
  `l_name` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT 'abc@gmail.com' COMMENT 'UserEmail',
  `password` varchar(255) DEFAULT NULL COMMENT 'UserPassword',
  `phone` varchar(255) NOT NULL COMMENT 'Phone number of user',
  `wtsp_number` varchar(255),
  `birth_date` date NOT NULL COMMENT 'User birth date',
  `user_image` varchar(255) DEFAULT NULL,
  `address` varchar(255) NOT NULL,
  `area_id` int(11) NOT NULL,
  `mandal_id` int(11) NOT NULL,
  `auth_token` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL COMMENT 'User Created at',
  `updated_at` datetime NOT NULL COMMENT 'User Updated at',
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `role_id_2` (`role_id`),
  KEY `area_id` (`area_id`),
  KEY `mandal_id` (`mandal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
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

-- Data exporting was unselected.
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

-- Data exporting was unselected.
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

-- Data exporting was unselected.
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

-- Data exporting was unselected.
-- Dumping structure for table akshardh_ms.user_roles
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  `role_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
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

-- Data exporting was unselected.
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

-- Data exporting was unselected.
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

-- Data exporting was unselected.
-- Dumping structure for table akshardh_ms.user_skills
DROP TABLE IF EXISTS `user_skills`;
CREATE TABLE IF NOT EXISTS `user_skills` (
  `user_skill_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  PRIMARY KEY (`user_skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Data exporting was unselected.
-- Dumping structure for table akshardh_ms.yuva_attendance
DROP TABLE IF EXISTS `yuva_attendance`;
CREATE TABLE IF NOT EXISTS `yuva_attendance` (
  `sabha_id` int(11) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `is_attended` tinyint(4) DEFAULT NULL,
  `mandal_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
