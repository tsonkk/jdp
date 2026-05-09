-- Drop tables
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS project;

-- Create tables
CREATE TABLE project(
  id int PRIMARY KEY AUTO_INCREMENT,
  name varchar(50),
  deadline date
);

CREATE TABLE employee(
  id int PRIMARY KEY AUTO_INCREMENT,
  fullname varchar(50),
  gen tinyint(1),
  project_id int,
  FOREIGN KEY (project_id) REFERENCES project(id) ON DELETE CASCADE
);

-- Insert rows
INSERT INTO project(name, deadline) VALUES
('Hệ thống Quản lý Bán lẻ Omnichannel', '2026-08-15'),
('Ứng dụng Ví điện tử Mobile Banking', '2026-10-20'),
('Nền tảng Đào tạo trực tuyến LMS', '2026-07-30'),
('Phần mềm Tối ưu Chuỗi cung ứng', '2026-12-10'),
('Hệ thống Chăm sóc khách hàng CRM', '2026-09-05');

INSERT INTO employee(fullname, gen, project_id) VALUES
('Nguyễn Minh Triết', 0, 1),
('Trần Lê Phương Thảo', 1, 1),
('Phạm Hoàng Gia Bảo', 0, 1),
('Lê Thị Tuyết Mai', 1, 2),
('Đặng Văn Quang', 0, 2),
('Bùi Hồng Hạnh', 1, 2),
('Vũ Anh Tuấn', 0, 2),
('Hoàng Thanh Trúc', 1, 3),
('Ngô Quốc Khánh', 0, 3),
('Đỗ Hùng Dũng', 0, 4),
('Trịnh Thu Hà', 1, 4),
('Lý Minh Khôi', 0, 4),
('Nguyễn Bích Ngọc', 1, 4),
('Phan Văn Đức', 0, 4),
('Trần Thị Diễm Hương', 1, 5),
('Nguyễn Thế Vinh', 0, 5),
('Lâm Mỹ Anh', 1, 5);