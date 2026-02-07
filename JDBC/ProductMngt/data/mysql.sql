-- Drop tables
DROP TABLE IF EXISTS Product;
DROP TABLE IF EXISTS Category;

-- Create tables
CREATE TABLE Category(ID INT PRIMARY KEY AUTO_INCREMENT, Name TEXT);
INSERT INTO Category(Name) VALUES('Laptop');
INSERT INTO Category(Name) VALUES('Smartphone');
INSERT INTO Category(Name) VALUES('Tablet');

CREATE TABLE Product(ID INT PRIMARY KEY AUTO_INCREMENT, Name TEXT, Price INT, CatID INT, FOREIGN KEY (CatID) REFERENCES Category(ID) ON DELETE CASCADE);
INSERT INTO Product(Name, Price, CatID) VALUES('Macbook Air', 10, 1);
INSERT INTO Product(Name, Price, CatID) VALUES('Macbook Pro', 20, 1);
INSERT INTO Product(Name, Price, CatID) VALUES('iPhone X', 30, 2);
INSERT INTO Product(Name, Price, CatID) VALUES('iPhone Xs', 40, 2);
INSERT INTO Product(Name, Price, CatID) VALUES('iPhone 11', 50, 2);
INSERT INTO Product(Name, Price, CatID) VALUES('iPad Air', 60, 3);
INSERT INTO Product(Name, Price, CatID) VALUES('iPad Mini', 70, 3);