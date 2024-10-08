CREATE DATABASE DLGV 
GO
  USE DLGV 
GO
  CREATE TABLE tbGiangvien (
    MaDD VARCHAR ( 36 ) PRIMARY KEY,
    Hoten NVARCHAR ( 100 ),
    GT NVARCHAR ( 3 ),
    Donvi NVARCHAR ( 100 ),
  Soct INT 
  )
  GO
	INSERT INTO tbGiangvien (MaDD, Hoten, GT, Donvi, Soct) VALUES
	('6f1e9f67-2e8d-4b45-bbcd-2b3b1e7c09c5', N'Nguyễn Văn A', N'Nam', N'Công nghệ Thông tin', 10),
	('b18d0d83-4ed0-4193-9f6b-d1be4a0b3a02', N'Trần Thị B', N'Nữ', N'Khoa học Môi trường', 12),
	('e0d2a4ff-3013-40b4-bc15-857894d24a7c', N'Lê Văn C', N'Nam', N'Toán ứng dụng', 8),
	('8c1a4319-ece1-49a5-a0c9-11e79f2b844b', N'Phạm Thị D', N'Nữ', N'Văn học', 15),
	('ac12b48b-e420-45d3-8d8b-bd2f1946e6f5', N'Nguyễn Văn E', N'Nam', N'Hóa học', 5),
	('d5b317d1-cd96-461c-bae1-54b1d5b462d7', N'Trần Văn F', N'Nam', N'Sinh học', 20),
	('7cfae19e-e6bb-4904-8ab7-feb7c528e478', N'Lê Thị G', N'Nữ', N'Vật lý', 7),
	('d0074e34-d5e6-4e58-85a7-f14e07c742b2', N'Nguyễn Văn H', N'Nam', N'Khoa học máy tính', 14),
	('4b7cf6ed-7c89-44ed-931e-9c99c37a4e31', N'Phạm Thị I', N'Nữ', N'Kinh tế', 6),
	('59f3a6ff-90e9-405f-9223-5673e76bdb4e', N'Trần Văn J', N'Nam', N'Quản trị kinh doanh', 11);
