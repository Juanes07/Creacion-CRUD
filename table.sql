-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS contact DEFAULT CHARACTER SET utf8 ;
USE contact ;

-- -----------------------------------------------------
-- Table `contact`.`email`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS contact.email (
  email_id INT NOT NULL AUTO_INCREMENT,
  mail VARCHAR(45) NOT NULL,
  PRIMARY KEY (email_id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contact`.`phone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS contact.phone (
  phone_id INT NOT NULL AUTO_INCREMENT,
  phnumber VARCHAR(20) NOT NULL,
  PRIMARY KEY (phone_id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contact`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS contact.user (
  user_id INT NOT NULL AUTO_INCREMENT,
  email_id INT NOT NULL,
  phonenumber INT NOT NULL,
  user_name VARCHAR(20) NOT NULL,
  user_lastname VARCHAR(25) NOT NULL,
  user_birthday DATE NOT NULL,
  PRIMARY KEY (user_id),
  INDEX email_id_idx (email_id ASC) VISIBLE,
  INDEX phoneNumber_idx (phonenumber ASC) VISIBLE,
  CONSTRAINT email_id
    FOREIGN KEY (email_id)
    REFERENCES contact.email (email_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT phoneNumber
    FOREIGN KEY (phonenumber)
    REFERENCES contact.phone (phone_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


