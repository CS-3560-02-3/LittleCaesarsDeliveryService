DROP DATABASE IF EXISTS CS3560;
CREATE DATABASE CS3560;
USE CS3560;
    
CREATE TABLE `employee` (
	`employeeID` int (6),
    `username` VARCHAR (50),
    `password` VARCHAR (50),
	`name` VARCHAR (50),
	PRIMARY KEY(`employeeID`)
);

CREATE TABLE `driver` (
	`driverID` int (6),
    `vehiclePlateNumber` int (7),
    `employeeID` int (6),
	FOREIGN KEY (`employeeID`) REFERENCES `employee`(`employeeID`),
    PRIMARY KEY(`driverID`)
);

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

CREATE TABLE `order` (
	`orderID` int (6),
    `dateOrdered` DATE,
    `tip` DECIMAL,
    `customerID` int (6),
    FOREIGN KEY (`customerID`) REFERENCES `customer`(`customerID`),
    PRIMARY KEY(`orderID`)
);

CREATE TABLE `delivery` (
	`deliveryID` int (6),
    `estimatedTime` int,
    `deliveryStatus` VARCHAR (200),
    `deliveryDate` DATE,
    PRIMARY KEY(`deliveryID`)
);

CREATE TABLE `item` (
	`itemID` int (6),
    `name` VARCHAR (50),
    `price` DECIMAL,
    `orderID` int (6),
    FOREIGN KEY (`orderID`) REFERENCES `order`(`orderID`),
    PRIMARY KEY(`itemID`)
);