DROP SCHEMA IF EXISTS `oltp_admission_stage`;
CREATE SCHEMA oltp_admission_stage;
USE oltp_admission_stage;
DROP TABLE IF EXISTS `admission_details`;

CREATE TABLE `admission_details`(
  `application_id` INT(10) UNSIGNED NOT NULL DEFAULT '0',
  `creation_date` VARCHAR(20) CHARACTER SET utf8 DEFAULT NULL,
  `last_update_date` VARCHAR(20) CHARACTER SET utf8 DEFAULT NULL,
  `submit_date` VARCHAR(20) CHARACTER SET utf8 DEFAULT NULL,
  `fee_payment_type` VARCHAR(16) CHARACTER SET utf8 DEFAULT NULL,
  `payment_card_type` VARCHAR(16) CHARACTER SET utf8 DEFAULT NULL,
  `applicant_last_name` VARCHAR(19) NOT NULL DEFAULT '',
  `applicant_first_name` VARCHAR(20) NOT NULL DEFAULT '',
  `applicant_middle_name` VARCHAR(21) NOT NULL DEFAULT '',
  `current_city` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL,
  `current_state_province` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL,
  `current_country` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL,
  `province` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL,
  `current_zipcode` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL,
  `current_address_expiry` VARCHAR(20) CHARACTER SET utf8 DEFAULT NULL,
  `email_address` VARCHAR(25) NOT NULL DEFAULT '',
  `residence_city` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL,
  `residence_zipcode` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL,
  `residence_province` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL,
  `residence_country` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL,
  `country_of_citizenship` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL,
  `ethnicity_indian` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL,
  `ethnicity_asian` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL,
  `ethnicity_black` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL,
  `ethnicity_hawaiian` VARCHAR(64) CHARACTER SET utf8 DEFAULT NULL,
  `ethnicity_white` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL,
  `ethnicity_hispanic` VARCHAR(8) CHARACTER SET utf8 DEFAULT NULL,
  `gender` VARCHAR(16) CHARACTER SET utf8 DEFAULT NULL,
  `date_of_birth` VARCHAR(20) CHARACTER SET utf8 DEFAULT NULL,
  `department_name` VARCHAR(64) CHARACTER SET utf8 DEFAULT NULL,
  `approx_stay_time` VARCHAR(16) CHARACTER SET utf8 DEFAULT NULL,
  `program_name` VARCHAR(64) CHARACTER SET utf8 DEFAULT NULL,
  `citizenship_response` VARCHAR(64) CHARACTER SET utf8 DEFAULT NULL,
  `residency_response` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL,
  `first_language` VARCHAR(64) CHARACTER SET utf8 DEFAULT NULL,
  `financial_support` VARCHAR(8) CHARACTER SET utf8 DEFAULT NULL,
  `gre_quant_perc` INT(8) DEFAULT NULL,
  `gre_verbal_perc` INT(8) DEFAULT NULL,
  `toefl_reading_perc` INT(8) DEFAULT NULL,
  `toefl_writing_perc` INT(8) DEFAULT NULL,
  `toefl_listening_perc` INT(8) DEFAULT NULL,
  `toefl_speaking_perc` INT(8) DEFAULT NULL,
  `institute_name_1` VARCHAR(128) CHARACTER SET utf8 DEFAULT NULL,
  `institute_country_1` VARCHAR(64) CHARACTER SET utf8 DEFAULT NULL,
  `international_1` VARCHAR(1) DEFAULT NULL,
  `institute_name_2` VARCHAR(128) CHARACTER SET utf8 DEFAULT NULL,
  `institute_country_2` VARCHAR(64) CHARACTER SET utf8 DEFAULT NULL,
  `international_2` VARCHAR(1) DEFAULT NULL,
  `institute_name_3` VARCHAR(128) CHARACTER SET utf8 DEFAULT NULL,
  `institute_country_3` VARCHAR(64) CHARACTER SET utf8 DEFAULT NULL,
  `international_3` VARCHAR(1) DEFAULT NULL,
  `rec_firstname_1` VARCHAR(17) DEFAULT NULL,
  `rec_lastname_1` VARCHAR(16) DEFAULT NULL,
  `rec_country_1` VARCHAR(64) CHARACTER SET utf8 DEFAULT NULL,
  `rec_letter_received_date_1` VARCHAR(20) CHARACTER SET utf8 DEFAULT NULL,
  `rec_firstname_2` VARCHAR(17) DEFAULT NULL,
  `rec_lastname_2` VARCHAR(16) DEFAULT NULL,
  `rec_country_2` VARCHAR(64) CHARACTER SET utf8 DEFAULT NULL,
  `rec_letter_received_date_2` VARCHAR(20) CHARACTER SET utf8 DEFAULT NULL,
  `rec_firstname_3` VARCHAR(17) DEFAULT NULL,
  `rec_lastname_3` VARCHAR(16) DEFAULT NULL,
  `rec_country_3` VARCHAR(64) CHARACTER SET utf8 DEFAULT NULL,
  `rec_letter_received_date_3` VARCHAR(20) CHARACTER SET utf8 DEFAULT NULL,
  `final_verdict` VARCHAR(8) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=INNODB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS datamart_db.dim_ethnicity;

CREATE TABLE datamart_db.dim_ethnicity
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
  
INSERT
INTO dim_ethnicity
  (
    junk_id,
    ethnicity_indian,
    ethnicity_asian,
    ethnicity_black,
    ethnicity_hawaiian,
    ethnicity_white,
    ethnicity_hispanic
  )
SELECT 
  SUBSTRING(MD5(CONCAT(TRIM(a.indian),TRIM(a.asian), TRIM(a.black),TRIM(a.hawaiian),TRIM(a.white),TRIM(a.hispanic))),1,5) group_key,
  a.indian,
  a.asian,
  a.black,
  a.hawaiian,
  a.white,
  a.hispanic
FROM
  (SELECT DISTINCT IFNULL(ethnicity_indian,' ')    AS indian,
    IFNULL(ethnicity_asian,' ')                    AS asian,
    IFNULL(ethnicity_black,' ')                    AS black,
    IFNULL(ethnicity_hawaiian, ' ')                AS hawaiian,
    IFNULL(ethnicity_white, ' ')                   AS white,
    IF(hispanic_ethnicity = 'No', ' ', 'Hispanic') AS hispanic
  FROM oltp_admission.app_profile
  ) a;
-- POC query for surrogate key pipeline
SELECT e.ethnicity_skey, p.*
  FROM (
        SELECT 
               SUBSTRING( MD5(CONCAT(
                                     TRIM(IFNULL(ethnicity_indian,' ')),
                                     TRIM(IFNULL(ethnicity_asian,' ')), 
                                     TRIM(IFNULL(ethnicity_black,' ')),
                                     TRIM(IFNULL(ethnicity_hawaiian, ' ')),
                                     TRIM(IFNULL(ethnicity_white, ' ')),
                                     TRIM(IF(hispanic_ethnicity = 'No', ' ', 'Hispanic'))
                                    )
                             )
                          ,1,5
                        ) group_key,
               ethnicity_indian,
               ethnicity_asian,
               ethnicity_black,
               ethnicity_hawaiian,
               ethnicity_white,
               hispanic_ethnicity,
               applicant_client_id
          FROM oltp_admission.app_profile  
       ) p
  LEFT OUTER JOIN datamart_db.dim_ethnicity e
    ON p.group_key = e.junk_id
;