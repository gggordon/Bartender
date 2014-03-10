
CREATE TABLE Role
(
	roleId int AUTO_INCREMENT,
	roleName varchar(100),
	
	primary key(roleId)
);
CREATE TABLE ArmBand
(
	armBandId int AUTO_INCREMENT,
	armBandName varchar(100),
	
	primary key(armBandId)	
);
CREATE TABLE DrinkType
(
	drinkTypeId int AUTO_INCREMENT,
	drinkTypeName  varchar(100),
	
	primary key(drinkTypeId)	
);
CREATE TABLE Drink
(
	drinkId int AUTO_INCREMENT,
	drinkName int,
	createdDate datetime,
	
	drinkTypeId int,
	
	primary key(drinkId),
	FOREIGN KEY (drinkTypeId) REFERENCES DrinkType(drinkTypeId)
);
CREATE TABLE Employee
(
	employeeId int AUTO_INCREMENT,
	firstName varchar(100),
	lastName varchar(100),
	
	userName varchar(100),
	password varchar(100),
	
	email varchar(150),
	dateOfBirth datetime,
	createdDate datetime,
	lastLoginDate datetime,	
	roleId int,
	
	unique(email),
	primary key(employeeId),		
	FOREIGN KEY (roleId) REFERENCES Role(roleId)
);
CREATE TABLE Guest
(
	guestId int AUTO_INCREMENT,
	firstName varchar(100),
	lastName varchar(100),
	
	email varchar(150),
	dateOfBirth datetime,
	createdDate datetime,
	lastLoginDate datetime,
	armBandId int,
	
	unique(email),
	primary key(guestId),
	FOREIGN KEY (armBandId) REFERENCES ArmBand(armBandId)
	
);
CREATE TABLE CustomerOrder
(
	customerOrderId int AUTO_INCREMENT,
	guestId int,
	orderDate datetime,
	servedby int,
	
	primary key(customerOrderId),
	FOREIGN KEY (guestId) REFERENCES Guest(guestId),
	FOREIGN KEY (servedby) REFERENCES Employee(employeeId)	
);
CREATE TABLE CustomerOrderItem
(
	customerOrderItemId int AUTO_INCREMENT,
	customerOrderId int,
	drinkId int,
	orderQuantity int,
	
	primary key(customerOrderItemId),
	FOREIGN KEY (customerOrderId) REFERENCES CustomerOrder(customerOrderId),
	FOREIGN KEY (drinkId) REFERENCES Drink(drinkId)	
);
