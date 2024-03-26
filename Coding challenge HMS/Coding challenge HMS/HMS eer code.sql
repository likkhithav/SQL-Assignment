-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema hospital_management_system
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hospital_management_system
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hospital_management_system` DEFAULT CHARACTER SET utf8 ;
USE `hospital_management_system` ;

-- -----------------------------------------------------
-- Table `hospital_management_system`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital_management_system`.`patient` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `dob` DATE NULL,
  `gender` VARCHAR(45) NULL,
  `contact_number` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital_management_system`.`doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital_management_system`.`doctor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `specialization` VARCHAR(45) NULL,
  `contact_number` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital_management_system`.`appointment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital_management_system`.`appointment` (
  `id` INT NULL AUTO_INCREMENT,
  `appointment_date` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `patient_id` INT NOT NULL,
  `doctor_id` INT NOT NULL,
  PRIMARY KEY (`id`, `patient_id`, `doctor_id`),
  INDEX `fk_appointment_patient_idx` (`patient_id` ASC) ,
  INDEX `fk_appointment_doctor1_idx` (`doctor_id` ASC) ,
  CONSTRAINT `fk_appointment_patient`
    FOREIGN KEY (`patient_id`)
    REFERENCES `hospital_management_system`.`patient` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_appointment_doctor1`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `hospital_management_system`.`doctor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


