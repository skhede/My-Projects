/*
SQLyog Enterprise v9.32 GA
MySQL - 5.6.27-log : Database - datamart_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`datamart_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `datamart_db`;

/*Table structure for table `dim_program` */

DROP TABLE IF EXISTS datamart_db.`dim_program`;

CREATE TABLE `dim_program` (
  `program_id` int(8) NOT NULL AUTO_INCREMENT,
  `program_code` varchar(128) NOT NULL DEFAULT '',
  `department_code` char(7) NOT NULL DEFAULT '',
  `department_name` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`program_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


/*Table structure for table `dim_college` */

DROP TABLE IF EXISTS `dim_college`;

CREATE TABLE `dim_college` (
  `college_id` INT(10) UNSIGNED NOT NULL DEFAULT '0',
  `applicant_client_id` VARCHAR(7) DEFAULT NULL,
  `type` INT(4) DEFAULT NULL,
  `college_name` VARCHAR(128) DEFAULT NULL,
  `college_degree` VARCHAR(32) DEFAULT NULL,
  `college_country` VARCHAR(64) DEFAULT NULL,
  PRIMARY KEY (`college_id`),
  KEY `idx_dim_college_appid` (`applicant_client_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;


/*Table Ethnicity */
DROP TABLE IF EXISTS datamart_db.`dim_ethnicity`;

CREATE TABLE datamart_db.`dim_ethnicity` (
  `ethnicity_id` INT(12) PRIMARY KEY,
  `juke_id` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL,
  `ethnicity_indian` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL,
  `ethnicity_asian` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL,
  `ethnicity_black` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL,
  `ethnicity_hawaiian` VARCHAR(64) CHARACTER SET utf8 DEFAULT NULL,
  `ethnicity_white` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL,
  `ethnicity_hispanic` VARCHAR(8) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=MYISAM;

DROP TABLE IF EXISTS datamart_db.`dim_payment`;

CREATE TABLE datamart_db.`dim_payment` (
  `fee_payment_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `fee_payment_type` varchar(16) DEFAULT NULL,
  `payment_card_type` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`fee_payment_type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8


/*DIM DATE */

CREATE TABLE datamart_db.`dim_date` (
  `date_tk` int(11) NOT NULL,
  `the_date` date DEFAULT NULL,
  `the_year` smallint(6) DEFAULT NULL,
  `the_quarter` tinyint(4) DEFAULT NULL,
  `the_month` tinyint(4) DEFAULT NULL,
  `the_week` tinyint(4) DEFAULT NULL,
  `day_of_year` smallint(6) DEFAULT NULL,
  `day_of_month` tinyint(4) DEFAULT NULL,
  `day_of_week` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`date_tk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

/*Table structure for table `dim_applicant` */

DROP TABLE IF EXISTS datamart_db.`dim_applicant`;

CREATE TABLE datamart_db.`dim_applicant` (
  `applicant_client_id` VARCHAR(7) NOT NULL,
  `printed_date` CHAR(10) DEFAULT NULL,
  `submitted_date` CHAR(10) DEFAULT NULL,
  `last_accessed_date` CHAR(10) DEFAULT NULL,
  `fee_status` VARCHAR(32) DEFAULT NULL,
  `fee_payment_type` VARCHAR(16) DEFAULT NULL,
  `payment_card_type` VARCHAR(16) DEFAULT NULL,
  `applicant_last_name` VARCHAR(32) DEFAULT NULL,
  `applicant_first_name` VARCHAR(32) DEFAULT NULL,
  `applicant_middle_name` VARCHAR(32) DEFAULT NULL,
  `current_state_province` VARCHAR(32) DEFAULT NULL,
  `current_country` VARCHAR(128) DEFAULT NULL,
  `province` VARCHAR(32) DEFAULT NULL,
  `country_of_citizenship` VARCHAR(32) DEFAULT NULL,
  `rec_response_1` VARCHAR(32) DEFAULT NULL,
  `rec_response_2` VARCHAR(32) DEFAULT NULL,
  
  PRIMARY KEY (`applicant_client_id`)
  
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `fact_admission_details` */

DROP TABLE IF EXISTS fact_admission_details;
  
CREATE TABLE datamart_db.`fact_admission_details` (
application_id INT (10) REFERENCES dim_applicant(application_id),
program_id INT (12) REFERENCES program_raw(program_id),
fee_payment_type_id INT(11) REFERENCES dim_payment(fee_payment_type_id),
college_id INT(11) REFERENCES  dim_college(college_id) ,
ethnicity_id INT(12) REFERENCES dim_ethnicity(ethnicity_id),
citizenship_response VARCHAR(64)DEFAULT NULL,
application_last_name VARCHAR(64) REFERENCES dim_applicant(application_last_name),
application_first_name VARCHAR(64) REFERENCES dim_applicant(application_first_name),
application_middle_name VARCHAR(64) REFERENCES dim_applicant(application_middle_name),
current_state_province VARCHAR(64) REFERENCES dim_applicant(current_state_province),
current_country VARCHAR(64) REFERENCES dim_applicant(current_country),
printed_date INT(11) REFERENCES dim_date(date_key),
submitted_date INT(11) REFERENCES dim_date(date_key),
last_accessed_date INT(11) REFERENCES dim_date(date_key),
college_degree VARCHAR(64) REFERENCES dim_college(college_degree),
`Is_Applied` INT(7) NOT NULL DEFAULT 1,
`Is_Admitted` INT(7) NOT NULL DEFAULT 0,
`Is_Accepted` INT(7) NOT NULL DEFAULT 0
);