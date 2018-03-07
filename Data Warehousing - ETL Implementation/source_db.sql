/*
SQLyog Enterprise v9.32 GA
MySQL - 5.6.27-log : Database - source_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`source_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `source_db`;

/*Table structure for table `adm_decision` */

DROP TABLE IF EXISTS source_db.`adm_decision`;

CREATE TABLE source_db.`adm_decision` (
  `applicant_client_id` VARCHAR(8) NOT NULL DEFAULT '',
  `admission_decision` VARCHAR(12) DEFAULT NULL,
  `term_code_admitted_to` VARCHAR(4) DEFAULT NULL,
  PRIMARY KEY (`applicant_client_id`),
  KEY `FK_adm_decision_term` (`term_code_admitted_to`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `adm_department` */

DROP TABLE IF EXISTS source_db.`adm_department`;

CREATE TABLE source_db.`adm_department` (
  `department_code` CHAR(7) NOT NULL DEFAULT '',
  `department_name` VARCHAR(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`department_code`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `adm_messages` */

DROP TABLE IF EXISTS source_db.`adm_messages`;

CREATE TABLE source_db.`adm_messages` (
  `id` INT(11) UNSIGNED NOT NULL DEFAULT '0',
  `applicant_client_id` VARCHAR(8) NOT NULL DEFAULT '',
  `sender_type` CHAR(3) NOT NULL COMMENT 'APP:Sent by Applicant, SCH: Sent by School',
  `message_subject` VARCHAR(27) NOT NULL DEFAULT '',
  `message_body` VARCHAR(24) NOT NULL DEFAULT '',
  `reply_to_id` INT(11) UNSIGNED DEFAULT NULL,
  `datetime_message_sent` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `datetime_message_read` TIMESTAMP NULL DEFAULT NULL,
  KEY `idx_msg_appid` (`applicant_client_id`)
  ) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `adm_program` */

DROP TABLE IF EXISTS source_db.`adm_program`;

CREATE TABLE source_db.`adm_program` (
  `program_code` VARCHAR(128) NOT NULL DEFAULT '',
  `department_code` CHAR(7) NOT NULL,
  PRIMARY KEY (`program_code`),
  KEY `FK_adm_program_deptcode` (`department_code`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `adm_review` */

DROP TABLE IF EXISTS source_db.`adm_review`;

CREATE TABLE source_db.`adm_review` (
  `reviewer_id` VARCHAR(16) NOT NULL,
  `applicant_client_id` VARCHAR(8) NOT NULL,
  `review_score` FLOAT DEFAULT NULL,
  `review_complete` TINYINT(1) DEFAULT '0',
  PRIMARY KEY (`reviewer_id`,`applicant_client_id`),
  KEY `NewIndex1` (`applicant_client_id`),
  KEY `idx_adm_review_appid` (`applicant_client_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Table structure for table `adm_tag` */

DROP TABLE IF EXISTS source_db.`adm_tag`;

CREATE TABLE source_db.`adm_tag` (
  `applicant_client_id` VARCHAR(7) NOT NULL,
  `tag_name` VARCHAR(32) NOT NULL,
  KEY `idx_adm_tag_appid` (`applicant_client_id`)
  ) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `adm_term` */

DROP TABLE IF EXISTS source_db.`adm_term`;

CREATE TABLE source_db.`adm_term` (
  `term_code` VARCHAR(4) NOT NULL DEFAULT '',
  `term_name` VARCHAR(13) NOT NULL DEFAULT '',
  PRIMARY KEY (`term_code`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `app_college` */

DROP TABLE IF EXISTS source_db.`app_college`;

CREATE TABLE source_db.`app_college` (
  `id` INT(10) UNSIGNED NOT NULL DEFAULT '0',
  `applicant_client_id` VARCHAR(7) DEFAULT NULL,
  `type` INT(4) DEFAULT NULL,
  `college_name` VARCHAR(128) DEFAULT NULL,
  `college_degree` VARCHAR(32) DEFAULT NULL,
  `college_country` VARCHAR(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_app_college_appid` (`applicant_client_id`)
  ) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `app_profile` */

DROP TABLE IF EXISTS source_db.`app_profile`;

CREATE TABLE `app_profile` (
  `applicant_client_id` varchar(7) NOT NULL,
  `printed_date` date DEFAULT NULL,
  `submitted_date` date DEFAULT NULL,
  `last_accessed_date` date DEFAULT NULL,
  `fee_status` varchar(32) DEFAULT NULL,
  `fee_payment_type` varchar(16) DEFAULT NULL,
  `payment_card_type` varchar(16) DEFAULT NULL,
  `applicant_last_name` varchar(32) DEFAULT NULL,
  `applicant_first_name` varchar(32) DEFAULT NULL,
  `applicant_middle_name` varchar(32) DEFAULT NULL,
  `current_state_province` varchar(32) DEFAULT NULL,
  `current_country` varchar(128) DEFAULT NULL,
  `province` varchar(32) DEFAULT NULL,
  `country_of_citizenship` varchar(32) DEFAULT NULL,
  `hispanic_ethnicity` varchar(32) DEFAULT NULL,
  `ethnicity_indian` varchar(32) DEFAULT NULL,
  `ethnicity_asian` varchar(32) DEFAULT NULL,
  `ethnicity_black` varchar(32) DEFAULT NULL,
  `ethnicity_hawaiian` varchar(64) DEFAULT NULL,
  `ethnicity_white` varchar(32) DEFAULT NULL,
  `ethnicity` varchar(32) DEFAULT NULL,
  `gender` varchar(8) DEFAULT NULL,
  `attendance_status` varchar(16) DEFAULT NULL,
  `degree_objective` varchar(64) DEFAULT NULL,
  `program_code` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`applicant_client_id`),
  KEY `idx_app_profile_prgcode` (`program_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*Table structure for table `app_recommender` */

DROP TABLE IF EXISTS source_db.`app_recommender`;

CREATE TABLE source_db.`app_recommender` (
  `id` INT(10) UNSIGNED NOT NULL DEFAULT '0',
  `applicant_client_id` VARCHAR(8) DEFAULT NULL,
  `type` INT(4) DEFAULT NULL,
  `recommender_fname` VARCHAR(22) NOT NULL DEFAULT '',
  `recommender_lname` VARCHAR(21) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `idx_app_recommender_appid` (`applicant_client_id`)
  ) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
