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

/*Table structure for table `dim_program` */

DROP TABLE IF EXISTS datamart_db.`dim_program`;

CREATE TABLE datamart_db.`dim_program` (
  `program_skey` INT(8) NOT NULL AUTO_INCREMENT,
  `program_code` VARCHAR(128) NOT NULL DEFAULT '',
  `department_code` CHAR(7) NOT NULL DEFAULT '',
  `department_name` VARCHAR(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`program_skey`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;


/*Table structure for table `dim_college` */

DROP TABLE IF EXISTS datamart_db.`dim_college`;

CREATE TABLE datamart_db.`dim_college` (
  `college_skey` INT(10) UNSIGNED NOT NULL DEFAULT '0',
  `applicant_client_id` VARCHAR(7) DEFAULT NULL,
  `type` INT(4) DEFAULT NULL,
  `college_name` VARCHAR(128) DEFAULT NULL,
  `college_degree` VARCHAR(32) DEFAULT NULL,
  `college_country` VARCHAR(64) DEFAULT NULL,
  PRIMARY KEY (`college_skey`),
  KEY `id_app_client` (`applicant_client_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;


/*Table Ethnicity */
DROP TABLE IF EXISTS datamart_db.`dim_ethnicity`;

CREATE TABLE datamart_db.`dim_ethnicity`
  (
    ethnicity_skey     INT(50) NOT NULL AUTO_INCREMENT,
    junk_id           VARCHAR(50),
    ethnicity_indian   VARCHAR(50) NOT NULL DEFAULT ' ',
    ethnicity_asian    VARCHAR(50) NOT NULL DEFAULT ' ',
    ethnicity_black    VARCHAR(50) NOT NULL DEFAULT ' ',
    ethnicity_hawaiian VARCHAR(50) NOT NULL DEFAULT ' ',
    ethnicity_white    VARCHAR(50) NOT NULL DEFAULT ' ',
    ethnicity_hispanic VARCHAR(50) NOT NULL DEFAULT ' ',
    PRIMARY KEY (ethnicity_skey),
    UNIQUE KEY (junk_id)
  );

/*DIM payment */
DROP TABLE IF EXISTS datamart_db.`dim_payment`;

CREATE TABLE datamart_db.`dim_payment` (
  `fee_payment_type_skey` INT(11) NOT NULL AUTO_INCREMENT,
  `fee_payment_type` VARCHAR(16) DEFAULT NULL,
  `payment_card_type` VARCHAR(16) DEFAULT NULL,
  PRIMARY KEY (`fee_payment_type_skey`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;


/*DIM DATE */
DROP TABLE IF EXISTS datamart_db.`dim_date`;

CREATE TABLE datamart_db.`dim_date` (
  `date_skey` INT(11) NOT NULL,
  `the_date` DATE DEFAULT NULL,
  `the_year` SMALLINT(6) DEFAULT NULL,
  `the_quarter` TINYINT(4) DEFAULT NULL,
  `the_month` TINYINT(4) DEFAULT NULL,
  `the_week` TINYINT(4) DEFAULT NULL,
  `day_of_year` SMALLINT(6) DEFAULT NULL,
  `day_of_month` TINYINT(4) DEFAULT NULL,
  `day_of_week` TINYINT(4) DEFAULT NULL,
  PRIMARY KEY (`date_skey`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `dim_applicant` */

DROP TABLE IF EXISTS datamart_db.`dim_applicant`;

CREATE TABLE `dim_applicant` (
  `applicant_client_id` varchar(7) DEFAULT NULL,
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
  `program_code` varchar(64) DEFAULT NULL,
  `gender` varchar(8) DEFAULT NULL,
  `admission_decision` varchar(20) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `date_from` datetime DEFAULT NULL,
  `date_to` datetime DEFAULT NULL,
  `applicant_skey` int(20) NOT NULL,
  PRIMARY KEY (`applicant_skey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `fact_admission_details` */

DROP TABLE IF EXISTS datamart_db.`fact_admission_details`;
  
CREATE TABLE datamart_db.`fact_admission_details` (
  `applicant_skey` INT(10) NOT NULL,
  `program_code_skey` INT(20) DEFAULT NULL,
  `printed_date_skey` INT(11) DEFAULT NULL,
  `submitted_date_skey` INT(11) DEFAULT NULL,
  `last_accessed_date_skey` INT(11) DEFAULT NULL,
  `is_applied` INT(7) NOT NULL DEFAULT '1',
  `is_admitted` INT(7) NOT NULL DEFAULT '1',
  `is_accepted` INT(7) DEFAULT NULL,
  `num_email_by_app` INT(5) DEFAULT NULL,
  `num_email_by_sch` INT(5) DEFAULT NULL,
  `ethnicity_skey` INT(20) DEFAULT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8
