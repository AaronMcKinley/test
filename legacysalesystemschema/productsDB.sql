-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema productsdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema productsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `productsdb` DEFAULT CHARACTER SET utf8 ;
USE `productsdb` ;

-- -----------------------------------------------------
-- Table `productsdb`.`listings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `productsdb`.`listings` (
  `orderId` INT(11) NOT NULL AUTO_INCREMENT,
  `customerId` VARCHAR(255) NULL DEFAULT NULL,
  `productId` VARCHAR(255) NULL DEFAULT NULL,
  `productName` VARCHAR(255) NULL DEFAULT NULL,
  `quantity` INT(11) NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`orderId`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `productsdb`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `productsdb`.`orders` (
  `orderId` INT(11) NOT NULL AUTO_INCREMENT,
  `customerId` VARCHAR(255) NULL DEFAULT NULL,
  `productId` VARCHAR(255) NULL DEFAULT NULL,
  `productName` VARCHAR(255) NULL DEFAULT NULL,
  `quantity` INT(11) NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`orderId`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `productsdb`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `productsdb`.`products` (
  `productId` INT(11) NOT NULL,
  `productName` VARCHAR(100) NULL DEFAULT NULL,
  `description` VARCHAR(250) NULL DEFAULT NULL,
  `price` DECIMAL(10,0) NULL DEFAULT NULL,
  `quantity` INT(11) NULL DEFAULT NULL,
  `category` VARCHAR(45) NULL DEFAULT NULL,
  `subCategory` VARCHAR(45) NULL DEFAULT NULL,
  `bought` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`productId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `productsdb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `productsdb`.`users` (
  `customerId` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`customerId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



-- -----------------------------------------------------
-- Data for table `productsDB`.`Products`
-- -----------------------------------------------------
START TRANSACTION;
USE `productsDB`;
INSERT INTO `productsDB`.`Products` (`productId`, `productName`, `description`, `price`, `quantity`, `category`, `subCategory`, `bought`) VALUES (1, 'iPhone X', 'The phone comes with a 5.80-inch touchscreen display with a resolution of 1125 pixels by 2436 pixels.', 999.99, 10, 'Electronics', 'Phones', NULL);
INSERT INTO `productsDB`.`Products` (`productId`, `productName`, `description`, `price`, `quantity`, `category`, `subCategory`, `bought`) VALUES (2, 'Lenovo IdeaPad 520s laptop', '14-inch Laptop Intel Core i3-7100U 2.40 GHz Processor, 8GB RAM, 128GB SSD', 649.99, 5, 'Electronics', 'Laptops', NULL);
INSERT INTO `productsDB`.`Products` (`productId`, `productName`, `description`, `price`, `quantity`, `category`, `subCategory`, `bought`) VALUES (3, 'SanDisk Ultra USB Flash Drive', '32GB USB 3.0 enabled (USB 2.0 compatible) -up to 10x faster than standard USB 2.0', 9.99, 50, 'Electronics', 'Memory', NULL);
INSERT INTO `productsDB`.`Products` (`productId`, `productName`, `description`, `price`, `quantity`, `category`, `subCategory`, `bought`) VALUES (4, 'Mpow IPX7 Waterproof Bluetooth 4.1 headphones', 'Running Headphones In-ear Earbuds, Noise Cancelling Wireless Sports Earphones for Gym Cycling Workout for iPhone,iPad, Samsung, HTC, Siri with Built-in Mic, Carrying Case -- 7-9 Hours Long Battery Life', 18.49, 13, 'Electronics', 'Headphones', NULL);
INSERT INTO `productsDB`.`Products` (`productId`, `productName`, `description`, `price`, `quantity`, `category`, `subCategory`, `bought`) VALUES (5, 'HP Deskjet 2630 All-in-One Printer', 'Print, copy and scan while saving space with a wireless all-in-one printer', 28.99, 21, 'Electronics', 'Printers', NULL);

COMMIT;