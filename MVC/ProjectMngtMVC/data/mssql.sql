-- Drop tables
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS project;

-- Create tables
CREATE TABLE project(
  id int PRIMARY KEY IDENTITY,
  name nvarchar(50),
  deadline date
);

CREATE TABLE employee(
  id int PRIMARY KEY IDENTITY,
  fullname nvarchar(50),
  gen tinyint,
  project_id int,
  FOREIGN KEY (project_id) REFERENCES project(id) ON DELETE CASCADE
);

-- Insert rows
INSERT INTO project(name, deadline) VALUES
(N'Hệ thống Quản lý Bán lẻ Omnichannel', '2026-08-15'),
(N'Ứng dụng Ví điện tử Mobile Banking', '2026-10-20'),
(N'Nền tảng Đào tạo trực tuyến LMS', '2026-07-30'),
(N'Phần mềm Tối ưu Chuỗi cung ứng', '2026-12-10'),
(N'Hệ thống Chăm sóc khách hàng CRM', '2026-09-05');

INSERT INTO employee(fullname, gen, project_id) VALUES
(N'Nguyễn Minh Triết', 0, 1),
(N'Trần Lê Phương Thảo', 1, 1),
(N'Phạm Hoàng Gia Bảo', 0, 1),
(N'Lê Thị Tuyết Mai', 1, 2),
(N'Đặng Văn Quang', 0, 2),
(N'Bùi Hồng Hạnh', 1, 2),
(N'Vũ Anh Tuấn', 0, 2),
(N'Hoàng Thanh Trúc', 1, 3),
(N'Ngô Quốc Khánh', 0, 3),
(N'Đỗ Hùng Dũng', 0, 4),
(N'Trịnh Thu Hà', 1, 4),
(N'Lý Minh Khôi', 0, 4),
(N'Nguyễn Bích Ngọc', 1, 4),
(N'Phan Văn Đức', 0, 4),
(N'Trần Thị Diễm Hương', 1, 5),
(N'Nguyễn Thế Vinh', 0, 5),
(N'Lâm Mỹ Anh', 1, 5);