CREATE DATABASE `fbmsDB` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `fbmsDB`;

CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `booking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `startDate` datetime NOT NULL,
  `endDate` datetime NOT NULL,
  `locationId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `locationId_idx` (`locationId`),
  CONSTRAINT `locationId` FOREIGN KEY (`locationId`) REFERENCES `location` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `person_booking` (
  `personId` int(11) NOT NULL,
  `bookingId` int(11) NOT NULL,
  PRIMARY KEY (`personId`,`bookingId`),
  KEY `bookingId_idx` (`bookingId`),
  CONSTRAINT `bookingId` FOREIGN KEY (`bookingId`) REFERENCES `booking` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `personId` FOREIGN KEY (`personId`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `person` (email, password, role) VALUES ('admin@colorado.edu', 'adminpass', 'admin');
INSERT INTO `person` (email, password, role) VALUES ('mary@colorado.edu', 'marypass', 'admin');
INSERT INTO `person` (email, password, role) VALUES ('student@colorado.edu', 'studentpass', 'student');
INSERT INTO `person` (email, password, role) VALUES ('tom@colorado.edu', 'tompass', 'student');

INSERT INTO `location` (name) VALUES ('Gemmill Library Rm 1');
INSERT INTO `location` (name) VALUES ('Gemmill Library Rm 2');
INSERT INTO `location` (name) VALUES ('Gemmill Library Rm 3');
INSERT INTO `location` (name) VALUES ('Gemmill Library Rm 4');
INSERT INTO `location` (name) VALUES ('Gemmill Library Rm 5');