DROP DATABASE IF EXISTS CS3560;
CREATE DATABASE IF NOT EXISTS CS3560;
USE CS3560;

-- Create Employee Table
CREATE TABLE `employee` (
	`employeeID` int (6),
	`name` VARCHAR (50),
    `username` VARCHAR (50),
    `password` VARCHAR (50),

	PRIMARY KEY(`employeeID`)
);
-- Add values
INSERT INTO `employee` VALUES (123456, 'name', 'user', 'pass');
SELECT * FROM `employee`;

-- Create Driver Table
CREATE TABLE `driver` (
	`driverID` int (6),
    `vehiclePlateNumber` VARCHAR (7),
    `employeeID` int (6),
	FOREIGN KEY (`employeeID`) REFERENCES `employee`(`employeeID`),
    PRIMARY KEY(`driverID`)
);
-- Add values
INSERT INTO `driver` VALUES ('123456', '1234567', '123456');
SELECT * FROM `driver`;

-- Create Customer Table
CREATE TABLE `customer` (
	`customerID` int (6),
    `username` VARCHAR (50),
    `password` VARCHAR (50),
	`name` VARCHAR (50),
	`deliveryAddress` VARCHAR (50),
	`emailAddress` VARCHAR (50),
    `billingInformation` VARCHAR (50),
	PRIMARY KEY(`customerID`)
);
-- Add values
INSERT INTO `customer` VALUES ('123456', 'user', 'pass', 'name', '123 E Street', 'email', '123 E Street');
SELECT * FROM `customer`;

-- Create Order Table
CREATE TABLE `order` (
	`orderID` int (6),
    `dateOrdered` DATE,
    `tip` DECIMAL,
    `customerID` int (6),
    FOREIGN KEY (`customerID`) REFERENCES `customer`(`customerID`),
    PRIMARY KEY(`orderID`)
);
-- Add values
INSERT INTO `order` VALUES ('666666', '23-11-17', '1.00', '123456');
SELECT * FROM `order`;

-- Create Delivery Table
CREATE TABLE `delivery` (
	`deliveryID` int (6),
    `estimatedTime` int,
    `deliveryStatus` VARCHAR (200),
    `deliveryDate` DATE,
    PRIMARY KEY(`deliveryID`)
);
-- Add values
INSERT INTO `delivery` VALUES ('999999', '200', 'done', '23-11-17');
SELECT * FROM `delivery`;

-- Create Item Table
CREATE TABLE `item` (
	`itemID` int (6),
    `name` VARCHAR (50),
    `price` DECIMAL,
    `orderID` int (6),
    FOREIGN KEY (`orderID`) REFERENCES `order`(`orderID`),
    PRIMARY KEY(`itemID`)
);
-- Add values
INSERT INTO `item` VALUES ('777777', 'cheese pizza', '1.00', '666666');
SELECT * FROM `item`;