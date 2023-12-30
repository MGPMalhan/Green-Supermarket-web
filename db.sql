CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `confirm_password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `categories` (name) VALUES('Food');
INSERT INTO `categories` (name) VALUES('Non Food');
INSERT INTO `categories` (name) VALUES('Frozen Food');
INSERT INTO `categories` (name) VALUES('Fruites/Vegetables');
INSERT INTO `categories` (name) VALUES('Alcohol');

SELECT * FROM categories c ;

CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category` (`category`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`category`) REFERENCES `categories` (`id`)
);

CREATE TABLE `orders` (
  `orderId` varchar(100) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `orderDate` varchar(30) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  KEY `userId` (`userId`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`)
);

CREATE TABLE `orderDetails` (
  `orderDetailId` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` varchar(100) DEFAULT NULL,
  `productId` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `subTotal` double DEFAULT NULL,
  PRIMARY KEY (`orderDetailId`),
  KEY `orderId` (`orderId`),
  KEY `productId` (`productId`),
  CONSTRAINT `orderDetails_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `orders` (`orderId`),
  CONSTRAINT `orderDetails_ibfk_2` FOREIGN KEY (`productId`) REFERENCES `products` (`id`)
);
