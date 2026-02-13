-- Drop tables
DROP TABLE IF EXISTS Customer;
-- Create tables
CREATE TABLE Customer(ID INT PRIMARY KEY IDENTITY, Name NTEXT, Age INT);
INSERT INTO Customer(Name, Age) VALUES(N'Hồ Đình Khả', 50);
INSERT INTO Customer(Name, Age) VALUES(N'Lương An Vinh', 26);
INSERT INTO Customer(Name, Age) VALUES(N'Lê Triệu Ngọc Đức', 40);
INSERT INTO Customer(Name, Age) VALUES(N'Trần Văn Thắng', 52);
INSERT INTO Customer(Name, Age) VALUES(N'Lê Thị Chung', 40);
INSERT INTO Customer(Name, Age) VALUES(N'MSSQL', 25);