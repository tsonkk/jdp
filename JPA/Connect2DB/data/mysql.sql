-- Drop tables
DROP TABLE IF EXISTS Customer;
-- Create tables
CREATE TABLE Customer(ID INT PRIMARY KEY AUTO_INCREMENT, Name TEXT, Age INT);
INSERT INTO Customer(Name, Age) VALUES('Hồ Đình Khả', 50);
INSERT INTO Customer(Name, Age) VALUES('Lương An Vinh', 26);
INSERT INTO Customer(Name, Age) VALUES('Lê Triệu Ngọc Đức', 40);
INSERT INTO Customer(Name, Age) VALUES('Trần Văn Thắng', 52);
INSERT INTO Customer(Name, Age) VALUES('Lê Thị Chung', 40);
INSERT INTO Customer(Name, Age) VALUES('MySQL', 8);