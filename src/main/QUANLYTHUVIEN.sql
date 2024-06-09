CREATE DATABASE QUANLYTHUVIEN
USE QUANLYTHUVIEN

SET DATEFORMAT DMY
--------------------------------------------------------------------
CREATE TABLE NHANVIEN
(
	MANV CHAR(10) PRIMARY KEY, 
	TENNV NVARCHAR(40),
	SDT VARCHAR(10)
)

--------------------------------------------------------------------
CREATE TABLE NGUOIMUON
(
	MASO CHAR(10) PRIMARY KEY, 
	HOTEN NVARCHAR(40),
	SDT VARCHAR(10),
	NGHENGHIEP NVARCHAR(50) 
)

--------------------------------------------------------------------
-- MAVT: 2 ký tự đầu: số phòng; 2 ký tự tiếp: so ke; 1 ký tự cuối: so ngan)
CREATE TABLE VITRI
(
	MAVT CHAR(5) PRIMARY KEY,
	SOPHONG INT,
	SOKE INT,
	SONGAN INT
)

--------------------------------------------------------------------
-- Loại tài liệu (dựa trên bảng phân loại DDC):
--- L00: Giao trinh
--- L01: Tai lieu tham khao
--- L02: Bai tap
--- L03: Luan van tot nghiep
--- L04: Tai lieu khac
CREATE TABLE LOAITL
(
	MALOAITL CHAR(3) PRIMARY KEY,
	TENLOAITL NVARCHAR(40),
	SONGAYMUON INT
)

--------------------------------------------------------------------
--TACGIA -> NVARCHAR
--NGONNGU -> NVARCHAR
--Them XUATBAN NVARCHAR(40)
--MALOAITL -> CHAR(3)
CREATE TABLE TAILIEU
(
	MATL CHAR(10) PRIMARY KEY,
	TENTL NVARCHAR(40),
	TACGIA NVARCHAR(40),
	NGONNGU NVARCHAR(40),
	XUATBAN NVARCHAR(40),
	SOTRANG INT,
	GIA MONEY,
	SOLUONG INT,
	MALOAITL CHAR(3) FOREIGN KEY (MALOAITL) REFERENCES LOAITL(MALOAITL),
	MAVT CHAR(5) FOREIGN KEY (MAVT) REFERENCES VITRI(MAVT)
)

--------------------------------------------------------------------
CREATE TABLE BANSAO
(
    MABANS CHAR(10) PRIMARY KEY,
    MATL CHAR(10) FOREIGN KEY (MATL) REFERENCES TAILIEU(MATL),
	TRANGTHAI NVARCHAR(40)
)

--------------------------------------------------------------------
CREATE TABLE MUON
(
	MAMUON CHAR(10) PRIMARY KEY,
	MASO CHAR(10) FOREIGN KEY (MASO) REFERENCES NGUOIMUON(MASO),
	MANV CHAR(10) FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV),
	NGAYMUON DATE
)

--------------------------------------------------------------------
CREATE TABLE CTMUON
(
	MAMUON CHAR(10) NOT NULL FOREIGN KEY (MAMUON) REFERENCES MUON(MAMUON),
	MABANS CHAR(10) NOT NULL FOREIGN KEY (MABANS) REFERENCES BANSAO(MABANS),
	HANTRA DATE NULL,
	TINHTRANG NVARCHAR(40)
)
ALTER TABLE CTMUON ADD CONSTRAINT PK_CTMUON PRIMARY KEY (MAMUON, MABANS);
 
--------------------------------------------------------------------
CREATE TABLE TRA
(
	MATRA CHAR(10) PRIMARY KEY,
	MASO CHAR(10) FOREIGN KEY (MASO) REFERENCES NGUOIMUON(MASO),
	MANV CHAR(10) FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV),
)

--------------------------------------------------------------------
CREATE TABLE CTTRA
(
	MATRA CHAR(10) NOT NULL FOREIGN KEY (MATRA) REFERENCES TRA(MATRA),
	MAMUON CHAR(10) NOT NULL FOREIGN KEY (MAMUON) REFERENCES MUON(MAMUON),
	MABANS CHAR(10) NOT NULL FOREIGN KEY (MABANS) REFERENCES BANSAO(MABANS),
	NGAYTRA DATE

)
ALTER TABLE CTTRA ADD CONSTRAINT PK_CTTRA PRIMARY KEY (MATRA, MABANS, MAMUON);

--------------------------------------------------------------------
CREATE TABLE PHIEUPHAT
(
	MAPH CHAR(10) PRIMARY KEY,
	NGPHAT DATE,
	SOTIEN MONEY,
	MAMUON CHAR(10) FOREIGN KEY (MAMUON) REFERENCES MUON(MAMUON),
	MABANS CHAR(10) NOT NULL FOREIGN KEY (MABANS) REFERENCES BANSAO(MABANS),
	LYDO NVARCHAR(40)
)


--------------------------------------------------------------------
--------------------------------------------------------------------
--INSERT DU LIEU
--NHANVIEN
INSERT INTO NHANVIEN (MANV, TENNV, SDT) VALUES
('NV00000001', N'Nguyễn Văn A', '0901234567'),
('NV00000002', N'Trần Thị B', '0912345678'),
('NV00000003', N'Phạm Văn C', '0923456789'),
('NV00000004', N'Hoàng Thị D', '0934567890'),
('NV00000005', N'Vũ Văn E', '0945678901'),
('NV00000006', N'Bùi Thị F', '0956789012'),
('NV00000007', N'Đặng Văn G', '0967890123'),
('NV00000008', N'Lê Thị H', '0978901234'),
('NV00000009', N'Ngô Văn I', '0989012345'),
('NV00000010', N'Huỳnh Thị K', '0990123456');

SELECT * FROM NHANVIEN

--NGUOIMUON
INSERT INTO NGUOIMUON (MASO, HOTEN, SDT, NGHENGHIEP) VALUES
('MS00000001', N'Nguyễn Văn A', '0901000001', N'giảng viên'),
('MS00000002', N'Trần Thị B', '0901000002', N'sinh viên'),
('MS00000003', N'Phạm Văn C', '0901000003', N'CBNV'),
('MS00000004', N'Hoàng Thị D', '0901000004', N'giảng viên'),
('MS00000005', N'Vũ Văn E', '0901000005', N'sinh viên'),
('MS00000006', N'Bùi Thị F', '0901000006', N'CBNV'),
('MS00000007', N'Đặng Văn G', '0901000007', N'giảng viên'),
('MS00000008', N'Lê Thị H', '0901000008', N'sinh viên'),
('MS00000009', N'Ngô Văn I', '0901000009', N'CBNV'),
('MS00000010', N'Huỳnh Thị K', '0901000010', N'giảng viên'),
('MS00000011', N'Nguyễn Văn L', '0901000011', N'giảng viên'),
('MS00000012', N'Trần Thị M', '0901000012', N'sinh viên'),
('MS00000013', N'Phạm Văn N', '0901000013', N'CBNV'),
('MS00000014', N'Hoàng Thị O', '0901000014', N'giảng viên'),
('MS00000015', N'Vũ Văn P', '0901000015', N'sinh viên'),
('MS00000016', N'Bùi Thị Q', '0901000016', N'CBNV'),
('MS00000017', N'Đặng Văn R', '0901000017', N'giảng viên'),
('MS00000018', N'Lê Thị S', '0901000018', N'sinh viên'),
('MS00000019', N'Ngô Văn T', '0901000019', N'CBNV'),
('MS00000020', N'Huỳnh Thị U', '0901000020', N'giảng viên'),
('MS00000021', N'Nguyễn Văn V', '0901000021', N'sinh viên'),
('MS00000022', N'Trần Thị W', '0901000022', N'CBNV'),
('MS00000023', N'Phạm Văn X', '0901000023', N'giảng viên'),
('MS00000024', N'Hoàng Thị Y', '0901000024', N'sinh viên'),
('MS00000025', N'Vũ Văn Z', '0901000025', N'CBNV'),
('MS00000026', N'Bùi Thị AA', '0901000026', N'giảng viên'),
('MS00000027', N'Đặng Văn BB', '0901000027', N'sinh viên'),
('MS00000028', N'Lê Thị CC', '0901000028', N'CBNV'),
('MS00000029', N'Ngô Văn DD', '0901000029', N'giảng viên'),
('MS00000030', N'Huỳnh Thị EE', '0901000030', N'sinh viên'),
('MS00000031', N'Nguyễn Văn FF', '0901000031', N'CBNV'),
('MS00000032', N'Trần Thị GG', '0901000032', N'giảng viên'),
('MS00000033', N'Phạm Văn HH', '0901000033', N'sinh viên'),
('MS00000034', N'Hoàng Thị II', '0901000034', N'CBNV'),
('MS00000035', N'Vũ Văn JJ', '0901000035', N'giảng viên'),
('MS00000036', N'Bùi Thị KK', '0901000036', N'sinh viên'),
('MS00000037', N'Đặng Văn LL', '0901000037', N'CBNV'),
('MS00000038', N'Lê Thị MM', '0901000038', N'giảng viên'),
('MS00000039', N'Ngô Văn NN', '0901000039', N'sinh viên'),
('MS00000040', N'Huỳnh Thị OO', '0901000040', N'CBNV'),
('MS00000041', N'Nguyễn Văn PP', '0901000041', N'giảng viên'),
('MS00000042', N'Trần Thị QQ', '0901000042', N'sinh viên'),
('MS00000043', N'Phạm Văn RR', '0901000043', N'CBNV'),
('MS00000044', N'Hoàng Thị SS', '0901000044', N'giảng viên'),
('MS00000045', N'Vũ Văn TT', '0901000045', N'sinh viên'),
('MS00000046', N'Bùi Thị UU', '0901000046', N'CBNV'),
('MS00000047', N'Đặng Văn VV', '0901000047', N'giảng viên'),
('MS00000048', N'Lê Thị WW', '0901000048', N'sinh viên'),
('MS00000049', N'Ngô Văn XX', '0901000049', N'CBNV'),
('MS00000050', N'Huỳnh Thị YY', '0901000050', N'giảng viên'),
('MS00000051', N'Nguyễn Văn ZZ', '0901000051', N'sinh viên'),
('MS00000052', N'Trần Thị AAA', '0901000052', N'CBNV'),
('MS00000053', N'Phạm Văn BBB', '0901000053', N'giảng viên'),
('MS00000054', N'Hoàng Thị CCC', '0901000054', N'sinh viên'),
('MS00000055', N'Vũ Văn DDD', '0901000055', N'CBNV'),
('MS00000056', N'Bùi Thị EEE', '0901000056', N'giảng viên'),
('MS00000057', N'Đặng Văn FFF', '0901000057', N'sinh viên'),
('MS00000058', N'Lê Thị GGG', '0901000058', N'CBNV'),
('MS00000059', N'Ngô Văn HHH', '0901000059', N'giảng viên'),
('MS00000060', N'Huỳnh Thị III', '0901000060', N'sinh viên'),
('MS00000061', N'Nguyễn Văn JJJ', '0901000061', N'CBNV'),
('MS00000062', N'Trần Thị KKK', '0901000062', N'giảng viên'),
('MS00000063', N'Phạm Văn LLL', '0901000063', N'sinh viên'),
('MS00000064', N'Hoàng Thị MMM', '0901000064', N'CBNV'),
('MS00000065', N'Vũ Văn NNN', '0901000065', N'giảng viên'),
('MS00000066', N'Bùi Thị OOO', '0901000066', N'sinh viên'),
('MS00000067', N'Đặng Văn PPP', '0901000067', N'CBNV'),
('MS00000068', N'Lê Thị QQQ', '0901000068', N'giảng viên'),
('MS00000069', N'Ngô Văn RRR', '0901000069', N'sinh viên'),
('MS00000070', N'Huỳnh Thị SSS', '0901000070', N'CBNV'),
('MS00000071', N'Nguyễn Văn TTT', '0901000071', N'giảng viên'),
('MS00000072', N'Trần Thị UUU', '0901000072', N'sinh viên'),
('MS00000073', N'Phạm Văn VVV', '0901000073', N'CBNV'),
('MS00000074', N'Hoàng Thị WWW', '0901000074', N'giảng viên'),
('MS00000075', N'Vũ Văn XXX', '0901000075', N'sinh viên'),
('MS00000076', N'Bùi Thị YYY', '0901000076', N'CBNV'),
('MS00000077', N'Đặng Văn ZZZ', '0901000077', N'giảng viên'),
('MS00000078', N'Lê Thị AAAA', '0901000078', N'sinh viên'),
('MS00000079', N'Ngô Văn BBBB', '0901000079', N'CBNV'),
('MS00000080', N'Huỳnh Thị CCCC', '0901000080', N'giảng viên'),
('MS00000081', N'Nguyễn Văn DDDD', '0901000081', N'sinh viên'),
('MS00000082', N'Trần Thị EEEE', '0901000082', N'CBNV'),
('MS00000083', N'Phạm Văn FFFF', '0901000083', N'giảng viên'),
('MS00000084', N'Hoàng Thị GGGG', '0901000084', N'sinh viên'),
('MS00000085', N'Vũ Văn HHHH', '0901000085', N'CBNV'),
('MS00000086', N'Bùi Thị IIII', '0901000086', N'giảng viên'),
('MS00000087', N'Đặng Văn JJJJ', '0901000087', N'sinh viên'),
('MS00000088', N'Lê Thị KKKK', '0901000088', N'CBNV'),
('MS00000089', N'Ngô Văn LLLL', '0901000089', N'giảng viên'),
('MS00000090', N'Huỳnh Thị MMMM', '0901000090', N'sinh viên'),
('MS00000091', N'Nguyễn Văn NNNN', '0901000091', N'CBNV'),
('MS00000092', N'Trần Thị OOOO', '0901000092', N'giảng viên'),
('MS00000093', N'Phạm Văn PPPP', '0901000093', N'sinh viên'),
('MS00000094', N'Hoàng Thị QQQQ', '0901000094', N'CBNV'),
('MS00000095', N'Vũ Văn RRRR', '0901000095', N'giảng viên'),
('MS00000096', N'Bùi Thị SSSS', '0901000096', N'sinh viên'),
('MS00000097', N'Đặng Văn TTTT', '0901000097', N'CBNV'),
('MS00000098', N'Lê Thị UUUU', '0901000098', N'giảng viên'),
('MS00000099', N'Ngô Văn VVVV', '0901000099', N'sinh viên'),
('MS00000100', N'Huỳnh Thị WWWW', '0901000100', N'CBNV');

SELECT * FROM NGUOIMUON

--VITRI
INSERT INTO VITRI (MAVT, SOPHONG, SOKE, SONGAN) VALUES
('01011', 1, 1, 1),
('01012', 1, 1, 2),
('01013', 1, 1, 3),
('01014', 1, 1, 4),
('01015', 1, 1, 5),
('01016', 1, 1, 6),
('01021', 1, 2, 1),
('01022', 1, 2, 2),
('01023', 1, 2, 3),
('01024', 1, 2, 4),
('01025', 1, 2, 5),
('01026', 1, 2, 6),
('01031', 1, 3, 1),
('01032', 1, 3, 2),
('01033', 1, 3, 3),
('01034', 1, 3, 4),
('01035', 1, 3, 5),
('01036', 1, 3, 6),
('01041', 1, 4, 1),
('01042', 1, 4, 2),
('01043', 1, 4, 3),
('01044', 1, 4, 4),
('01045', 1, 4, 5),
('01046', 1, 4, 6),
('01051', 1, 5, 1),
('01052', 1, 5, 2),
('01053', 1, 5, 3),
('01054', 1, 5, 4),
('01055', 1, 5, 5),
('01056', 1, 5, 6),
('01061', 1, 6, 1),
('01062', 1, 6, 2),
('01063', 1, 6, 3),
('01064', 1, 6, 4),
('01065', 1, 6, 5),
('01066', 1, 6, 6),
('02011', 2, 1, 1),
('02012', 2, 1, 2),
('02013', 2, 1, 3),
('02014', 2, 1, 4),
('02015', 2, 1, 5),
('02016', 2, 1, 6),
('02021', 2, 2, 1),
('02022', 2, 2, 2),
('02023', 2, 2, 3),
('02024', 2, 2, 4),
('02025', 2, 2, 5),
('02026', 2, 2, 6),
('02031', 2, 3, 1),
('02032', 2, 3, 2),
('02033', 2, 3, 3),
('02034', 2, 3, 4),
('02035', 2, 3, 5),
('02036', 2, 3, 6),
('02041', 2, 4, 1),
('02042', 2, 4, 2),
('02043', 2, 4, 3),
('02044', 2, 4, 4),
('02045', 2, 4, 5),
('02046', 2, 4, 6),
('02051', 2, 5, 1),
('02052', 2, 5, 2),
('02053', 2, 5, 3),
('02054', 2, 5, 4),
('02055', 2, 5, 5),
('02056', 2, 5, 6),
('02061', 2, 6, 1),
('02062', 2, 6, 2),
('02063', 2, 6, 3),
('02064', 2, 6, 4),
('02065', 2, 6, 5),
('02066', 2, 6, 6),
('03011', 3, 1, 1),
('03012', 3, 1, 2),
('03013', 3, 1, 3),
('03014', 3, 1, 4),
('03015', 3, 1, 5),
('03016', 3, 1, 6),
('03021', 3, 2, 1),
('03022', 3, 2, 2),
('03023', 3, 2, 3),
('03024', 3, 2, 4),
('03025', 3, 2, 5),
('03026', 3, 2, 6),
('03031', 3, 3, 1),
('03032', 3, 3, 2),
('03033', 3, 3, 3),
('03034', 3, 3, 4),
('03035', 3, 3, 5),
('03036', 3, 3, 6),
('03041', 3, 4, 1),
('03042', 3, 4, 2),
('03043', 3, 4, 3),
('03044', 3, 4, 4),
('03045', 3, 4, 5),
('03046', 3, 4, 6),
('03051', 3, 5, 1),
('03052', 3, 5, 2),
('03053', 3, 5, 3),
('03054', 3, 5, 4),
('03055', 3, 5, 5),
('03056', 3, 5, 6),
('03061', 3, 6, 1),
('03062', 3, 6, 2),
('03063', 3, 6, 3),
('03064', 3, 6, 4),
('03065', 3, 6, 5),
('03066', 3, 6, 6);

SELECT * FROM VITRI

--LOAITL
INSERT INTO LOAITL VALUES
('L00', N'Giáo trình', 90),
('L01', N'Tài liệu tham khảo', 60),
('L02', N'Bài tập', 90),
('L03', N'Luận văn tốt nghiệp', 30),
('L04', N'Tài liệu khác', 60);

SELECT * FROM LOAITL

--TAILIEU
INSERT INTO TAILIEU (MATL, MALOAITL, TENTL, TACGIA, NGONNGU, XUATBAN, SOTRANG, SOLUONG, GIA, MAVT) VALUES
('TL00000001', 'L00', N'Giáo trình Toán cao cấp', N'Nguyễn Văn A', N'Tiếng Việt', N'NXB Đại học Quốc Gia', 300, 10, 150000, '01011'),
('TL00000002', 'L00', N'Giáo trình Lập trình C++', N'Trần Thị B', N'Tiếng Việt', N'NXB Đại học Quốc Gia', 400, 10, 180000, '01012'),
('TL00000003', 'L00', N'Giáo trình Vật lý đại cương', N'Phạm Văn C', N'Tiếng Việt', N'NXB Đại học Quốc Gia', 350, 10, 160000, '01013'),
('TL00000004', 'L00', N'Giáo trình Hóa học hữu cơ', N'Lê Thị D', N'Tiếng Việt', N'NXB Đại học Quốc Gia', 320, 10, 140000, '01014'),
('TL00000005', 'L00', N'Giáo trình Kinh tế học', N'Vũ Văn E', N'Tiếng Việt', N'NXB Đại học Quốc Gia', 380, 10, 170000, '01015'),
('TL00000006', 'L01', N'Tài liệu tham khảo Toán cao cấp', N'John Smith', N'Tiếng Anh', N'Cambridge University Press', 350, 10, 200000, '01016'),
('TL00000007', 'L01', N'Tài liệu tham khảo Lập trình Java', N'Mary Johnson', N'Tiếng Anh', N'Oxford University Press', 450, 10, 220000, '01021'),
('TL00000008', 'L01', N'Tài liệu tham khảo Vật lý hạt nhân', N'Robert Williams', N'Tiếng Anh', N'Springer', 500, 10, 240000, '01022'),
('TL00000009', 'L01', N'Tài liệu tham khảo Hóa học hữu cơ', N'Jennifer Brown', N'Tiếng Anh', N'Elsevier', 400, 10, 210000, '01023'),
('TL00000010', 'L01', N'Tài liệu tham khảo Kinh tế học quốc tế', N'David Miller', N'Tiếng Anh', N'Palgrave Macmillan', 380, 10, 190000, '01024'),
('TL00000011', 'L02', N'Bài tập Toán cao cấp', N'Nguyễn Thị F', N'Tiếng Việt', N'NXB Giáo dục', 250, 10, 120000, '01025'),
('TL00000012', 'L02', N'Bài tập Lập trình Python', N'Trần Văn G', N'Tiếng Việt', N'NXB Giáo dục', 300, 10, 130000, '01026'),
('TL00000013', 'L02', N'Bài tập Vật lý lượng tử', N'Phạm Thị H', N'Tiếng Việt', N'NXB Giáo dục', 270, 10, 110000, '01031'),
('TL00000014', 'L02', N'Bài tập Hóa học hữu cơ', N'Lê Văn I', N'Tiếng Việt', N'NXB Giáo dục', 280, 10, 115000, '01032'),
('TL00000015', 'L02', N'Bài tập Kinh tế học phát triển', N'Vũ Thị K', N'Tiếng Việt', N'NXB Giáo dục', 320, 10, 125000, '01033'),
('TL00000016', 'L03', N'Luận văn tốt nghiệp Khoa học máy tính', N'Nguyễn Văn L', N'Tiếng Việt', N'Đại học Bách Khoa Hà Nội', 120, 10, 50000, '01034'),
('TL00000017', 'L03', N'Luận văn tốt nghiệp Kỹ thuật điện tử', N'Trần Thị M', N'Tiếng Việt', N'Đại học Công nghệ', 150, 10, 55000, '01035'),
('TL00000018', 'L03', N'Luận văn tốt nghiệp Khoa học xã hội', N'Phạm Văn N', N'Tiếng Việt', N'Đại học Khoa học Xã hội và Nhân văn', 130, 10, 52000, '01036'),
('TL00000019', 'L03', N'Luận văn tốt nghiệp Kinh doanh quốc tế', N'Lê Thị O', N'Tiếng Việt', N'Đại học Kinh doanh và Công nghệ', 140, 10, 53000, '01041'), 
('TL00000020', 'L03', N'Luận văn tốt nghiệp Quản trị kinh doanh', N'Vũ Văn P', N'Tiếng Việt', N'Đại học Ngoại Thương', 160, 10, 57000, '01042'),
('TL00000021', 'L04', N'Tài liệu Địa lý Việt Nam', N'John Doe', N'Tiếng Anh', N'National Geographic', 200, 10, 180000, '01043'),
('TL00000022', 'L04', N'Tài liệu Lịch sử thế giới', N'Jane Doe', N'Tiếng Anh', N'History Storage', 150, 10, 200000, '01044'),
('TL00000023', 'L04', N'Tài liệu Văn hóa các nước', N'Emily Johnson', N'Tiếng Anh', N'Lonely Planet', 180, 10, 170000, '01045'),
('TL00000024', 'L04', N'Tài liệu Lịch sử Việt Nam', N'Chris Brown', N'Tiếng Anh', N'Oxford University Press', 220, 10, 190000, '01046'),
('TL00000025', 'L00', N'Advanced Mathematics Textbook', N'James Smith', N'Tiếng Anh', N'Pearson', 400, 10, 200000, '01051'),
('TL00000026', 'L01', N'Java Programming Reference', N'Sarah Williams', N'Tiếng Anh', N'Wiley', 350, 10, 210000, '01052'),
('TL00000027', 'L02', N'Python Programming Exercises', N'Daniel Taylor', N'Tiếng Anh', N'Manning', 300, 10, 220000, '01053'),
('TL00000028', 'L03', N'Computer Science Thesis', N'Emma Johnson', N'Tiếng Anh', N'MIT Press', 150, 10, 230000, '01054'),
('TL00000029', 'L04', N'World History Documentation', N'Ryan Davis', N'Tiếng Anh', N'HarperCollins', 250, 10, 240000, '01055'),
('TL00000030', 'L00', N'Tiểu thuyết Đất Rừng', N'Trần Nhật Minh', N'Tiếng Việt', N'NXB Văn học', 350, 10, 150000, '01056'),
('TL00000031', 'L01', N'Java Programming Fundamentals', N'Hoàng Văn Đức', N'Tiếng Việt', N'NXB Giáo dục', 400, 10, 160000, '01061'),
('TL00000032', 'L02', N'Bài tập Toán Cao cấp', N'Nguyễn Thị Thu', N'Tiếng Việt', N'NXB Giáo dục', 300, 10, 170000, '01062'),
('TL00000033', 'L03', N'Luận văn tốt nghiệp Khoa học Máy tính', N'Lê Thanh Bình', N'Tiếng Việt', N'NXB Đại học Quốc Gia', 200, 10, 180000, '01063'),
('TL00000034', 'L04', N'Tài liệu Lịch sử thế giới', N'John Smith', N'Tiếng Anh', N'National Geographic', 300, 10, 190000, '01064'),
('TL00000035', 'L00', N'Tiểu thuyết Chí Phèo', N'Nam Cao', N'Tiếng Việt', N'NXB Văn học', 200, 10, 200000, '01065'),
('TL00000036', 'L01', N'Python Programming Reference', N'Adam Jones', N'Tiếng Anh', N'Oxford University Press', 350, 10, 210000, '01066'),
('TL00000037', 'L02', N'Bài tập Hóa học hữu cơ', N'Nguyễn Văn Hùng', N'Tiếng Việt', N'NXB Giáo dục', 250, 10, 220000, '02011'),
('TL00000038', 'L03', N'Luận văn tốt nghiệp Khoa học Môi trường', N'Nguyễn Thị Lan', N'Tiếng Việt', N'NXB Đại học Quốc Gia', 180, 10, 230000, '02012'),
('TL00000039', 'L04', N'Tài liệu Địa lý Việt Nam', N'Peter Clark', N'Tiếng Anh', N'Lonely Planet', 220, 10, 240000, '02013'),
('TL00000040', 'L00', N'Tiểu thuyết Số đỏ', N'Nguyễn Ngọc Ngạn', N'Tiếng Việt', N'NXB Văn học', 250, 10, 150000, '02014'),
('TL00000041', 'L01', N'C# Programming Reference', N'Jennifer Brown', N'Tiếng Anh', N'Wiley', 300, 10, 160000, '02015'),
('TL00000042', 'L02', N'Bài tập Toán học cao cấp', N'Phạm Thị Mai', N'Tiếng Việt', N'NXB Giáo dục', 350, 10, 170000, '02016'),
('TL00000043', 'L03', N'Luận văn tốt nghiệp Kỹ thuật Máy tính', N'Trần Văn Nam', N'Tiếng Việt', N'NXB Đại học Quốc Gia', 220, 10, 180000, '02021'),
('TL00000044', 'L04', N'World History Documentation', N'Michael Johnson', N'Tiếng Anh', N'HarperCollins', 200, 10, 190000, '02022'),
('TL00000045', 'L00', N'Tiểu thuyết Truyện Kiều', N'Nguyễn Du', N'Tiếng Việt', N'NXB Văn học', 300, 10, 200000, '02023'),
('TL00000046', 'L01', N'JavaScript Programming Reference', N'Jessica Taylor', N'Tiếng Anh', N'Oxford University Press', 350, 10, 210000, '02024'),
('TL00000047', 'L02', N'Bài tập Hóa học vô cơ', N'Nguyễn Thị Ngọc', N'Tiếng Việt', N'NXB Giáo dục', 100, 10, 25000, '02025'),
('TL00000048', 'L03', N'Luận văn tốt nghiệp Kinh tế Học', N'Lê Thị Hồng', N'Tiếng Việt', N'NXB Đại học Quốc Gia', 180, 10, 220000, '02026'),
('TL00000049', 'L04', N'History of Vietnam Documentation', N'Chris Brown', N'Tiếng Anh', N'HarperCollins', 200, 10, 230000, '02031'),
('TL00000050', 'L00', N'Tiểu thuyết Nhà Giả Kim', N'Paulo Coelho', N'Tiếng Anh', N'HarperCollins', 250, 10, 210000, '02032'),
('TL00000051', 'L01', N'PHP Programming Reference', N'David Miller', N'Tiếng Anh', N'Wiley', 300, 10, 220000, '02033'),
('TL00000052', 'L02', N'Bài tập Toán học cơ bản', N'Nguyễn Văn Tú', N'Tiếng Việt', N'NXB Giáo dục', 350, 10, 230000, '02034'),
('TL00000053', 'L03', N'Luận văn tốt nghiệp Hóa học', N'Phạm Thị Hà', N'Tiếng Việt', N'NXB Đại học Quốc Gia', 220, 10, 240000, '02035'),
('TL00000054', 'L04', N'Geography Documentation', N'Susan Johnson', N'Tiếng Anh', N'National Geographic', 250, 10, 250000, '02036'),
('TL00000055', 'L00', N'Tiểu thuyết Hồng Lâu Mộng', N'Cao Xương', N'Tiếng Việt', N'NXB Văn học', 350, 10, 220000, '02041'),
('TL00000056', 'L01', N'Ruby Programming Reference', N'Mary White', N'Tiếng Anh', N'Oxford University Press', 400, 10, 200000, '02042'),
('TL00000057', 'L02', N'Bài tập Sinh học phân tử', N'Nguyễn Thị Hương', N'Tiếng Việt', N'NXB Giáo dục', 250, 10, 220000, '02043'),
('TL00000058', 'L03', N'Luận văn tốt nghiệp Quản trị Kinh doanh', N'Lê Văn Dương', N'Tiếng Việt', N'NXB Đại học Quốc Gia', 200, 10, 230000, '02044'),
('TL00000059', 'L04', N'Travel Documentation', N'Jessica Taylor', N'Tiếng Anh', N'Lonely Planet', 300, 10, 240000, '02045'),
('TL00000060', 'L00', N'Tiểu thuyết Tam Quốc Diễn Nghĩa', N'Lưu Cầu', N'Tiếng Việt', N'NXB Văn học', 400, 10, 250000, '02046'),
('TL00000061', 'L01', N'Perl Programming Reference', N'Emily Johnson', N'Tiếng Anh', N'Wiley', 450, 10, 260000, '02051'),
('TL00000062', 'L02', N'Bài tập Toán học cơ bản', N'Nguyễn Văn Tú', N'Tiếng Việt', N'NXB Giáo dục', 350, 10, 270000, '02052'),
('TL00000063', 'L03', N'Luận văn tốt nghiệp Hóa học', N'Phạm Thị Hà', N'Tiếng Việt', N'NXB Đại học Quốc Gia', 220, 10, 280000, '02053'),
('TL00000064', 'L04', N'Geography Documentation', N'Susan Johnson', N'Tiếng Anh', N'National Geographic', 250, 10, 290000, '02054'),
('TL00000065', 'L00', N'Tiểu thuyết Hồng Lâu Mộng', N'Cao Xương', N'Tiếng Việt', N'NXB Văn học', 350, 10, 300000, '02055'),
('TL00000066', 'L01', N'Ruby Programming Reference', N'Mary White', N'Tiếng Anh', N'Oxford University Press', 400, 10, 310000, '02056'),
('TL00000067', 'L02', N'Bài tập Sinh học phân tử', N'Nguyễn Thị Hương', N'Tiếng Việt', N'NXB Giáo dục', 250, 10, 320000, '02061'),
('TL00000068', 'L03', N'Luận văn tốt nghiệp Quản trị Kinh doanh', N'Lê Văn Dương', N'Tiếng Việt', N'NXB Đại học Quốc Gia', 200, 10, 330000, '02062'),
('TL00000069', 'L04', N'Travel Documentation', N'Jessica Taylor', N'Tiếng Anh', N'Lonely Planet', 300, 10, 340000, '02063'),
('TL00000070', 'L00', N'Tiểu thuyết Tam Quốc Diễn Nghĩa', N'Lưu Cầu', N'Tiếng Việt', N'NXB Văn học', 400, 10, 350000, '02064'),
('TL00000071', 'L01', N'Perl Programming Reference', N'Emily Johnson', N'Tiếng Anh', N'Wiley', 450, 10, 360000, '02065'),
('TL00000072', 'L02', N'Bài tập Toán học cao cấp', N'Nguyễn Thị Thu', N'Tiếng Việt', N'NXB Giáo dục', 350, 10, 310000, '02066'),
('TL00000073', 'L03', N'Luận văn tốt nghiệp Khoa học Máy tính', N'Lê Thanh Bình', N'Tiếng Việt', N'NXB Đại học Quốc Gia', 200, 10, 320000, '03011'),
('TL00000074', 'L04', N'Tài liệu Lịch sử thế giới', N'John Smith', N'Tiếng Anh', N'National Geographic', 300, 10, 330000, '03012'),
('TL00000075', 'L00', N'Tiểu thuyết Chí Phèo', N'Nam Cao', N'Tiếng Việt', N'NXB Văn học', 200, 10, 340000, '03013'),
('TL00000076', 'L01', N'JavaScript Programming Reference', N'Jessica Taylor', N'Tiếng Anh', N'Oxford University Press', 350, 10, 350000, '03014'),
('TL00000077', 'L02', N'Bài tập Hóa học hữu cơ', N'Nguyễn Văn Hùng', N'Tiếng Việt', N'NXB Giáo dục', 250, 10, 360000, '03015'),
('TL00000078', 'L03', N'Luận văn tốt nghiệp Khoa học Môi trường', N'Nguyễn Thị Lan', N'Tiếng Việt', N'NXB Đại học Quốc Gia', 180, 10, 370000, '03016'),
('TL00000079', 'L04', N'World History Documentation', N'Michael Johnson', N'Tiếng Anh', N'HarperCollins', 200, 10, 380000, '03021'),
('TL00000080', 'L00', N'Tiểu thuyết Truyện Kiều', N'Nguyễn Du', N'Tiếng Việt', N'NXB Văn học', 300, 10, 390000, '03022'),
('TL00000081', 'L01', N'Perl Programming Reference', N'Emily Johnson', N'Tiếng Anh', N'Wiley', 450, 10, 400000, '03023'),
('TL00000082', 'L02', N'Bài tập Toán học cơ bản', N'Nguyễn Văn Tú', N'Tiếng Việt', N'NXB Giáo dục', 350, 10, 410000, '03024'),
('TL00000083', 'L03', N'Luận văn tốt nghiệp Hóa học', N'Phạm Thị Hà', N'Tiếng Việt', N'NXB Đại học Quốc Gia', 220, 10, 420000, '03025'),
('TL00000084', 'L04', N'Geography Documentation', N'Susan Johnson', N'Tiếng Anh', N'National Geographic', 250, 10, 430000, '03026'),
('TL00000085', 'L00', N'Tiểu thuyết Hồng Lâu Mộng', N'Cao Xương', N'Tiếng Việt', N'NXB Văn học', 350, 10, 440000, '03031'),
('TL00000086', 'L01', N'Ruby Programming Reference', N'Mary White', N'Tiếng Anh', N'Oxford University Press', 400, 10, 450000, '03032'),
('TL00000087', 'L02', N'Bài tập Sinh học phân tử', N'Nguyễn Thị Hương', N'Tiếng Việt', N'NXB Giáo dục', 250, 10, 460000, '03033'),
('TL00000088', 'L03', N'Luận văn tốt nghiệp Quản trị Kinh doanh', N'Lê Văn Dương', N'Tiếng Việt', N'NXB Đại học Quốc Gia', 200, 10, 470000, '03034'),
('TL00000089', 'L04', N'Travel Documentation', N'Jessica Taylor', N'Tiếng Anh', N'Lonely Planet', 300, 10, 480000, '03035'),
('TL00000090', 'L00', N'Tiểu thuyết Tam Quốc Diễn Nghĩa', N'Lưu Cầu', N'Tiếng Việt', N'Nha Nam', 267, 10, 90000, '03036'),
('TL00000091', 'L01', N'PHP Programming Reference', N'David Miller', N'Tiếng Anh', N'Wiley', 300, 10, 490000, '03041'),
('TL00000092', 'L02', N'Bài tập Toán học cao cấp', N'Nguyễn Thị Thu', N'Tiếng Việt', N'NXB Giáo dục', 350, 10, 500000, '03042'),
('TL00000093', 'L03', N'Luận văn tốt nghiệp Khoa học Máy tính', N'Lê Thanh Bình', N'Tiếng Việt', N'NXB Đại học Quốc Gia', 200, 10, 510000, '03043'),
('TL00000094', 'L04', N'Tài liệu Lịch sử thế giới', N'John Smith', N'Tiếng Anh', N'National Geographic', 300, 10, 520000, '03044'),
('TL00000095', 'L00', N'Tiểu thuyết Chí Phèo', N'Nam Cao', N'Tiếng Việt', N'NXB Văn học', 200, 10, 530000, '03045'),
('TL00000096', 'L01', N'JavaScript Programming Reference', N'Jessica Taylor', N'Tiếng Anh', N'Oxford University Press', 350, 10, 540000, '03046'),
('TL00000097', 'L02', N'Bài tập Hóa học hữu cơ', N'Nguyễn Văn Hùng', N'Tiếng Việt', N'NXB Giáo dục', 250, 10, 550000, '03051'),
('TL00000098', 'L03', N'Luận văn tốt nghiệp Khoa học Môi trường', N'Nguyễn Thị Lan', N'Tiếng Việt', N'NXB Đại học Quốc Gia', 180, 10, 560000, '03052'),
('TL00000099', 'L04', N'World History Documentation', N'Michael Johnson', N'Tiếng Anh', N'HarperCollins', 200, 10, 570000, '03053'),
('TL00000100', 'L00', N'Tiểu thuyết Truyện Kiều', N'Nguyễn Du', N'Tiếng Việt', N'NXB Văn học', 300, 10, 580000, '03054');

SELECT * FROM TAILIEU

--BAN SAO
INSERT INTO BANSAO (MABANS, MATL, TRANGTHAI) VALUES
('BS00100001', 'TL00000001', N'Có sẵn'),
('BS00100002', 'TL00000001', N'Có sẵn'),
('BS00100003', 'TL00000001', N'Có sẵn'),
('BS00100004', 'TL00000001', N'Có sẵn'),
('BS00100005', 'TL00000001', N'Có sẵn'),
('BS00100006', 'TL00000001', N'Có sẵn'),
('BS00100007', 'TL00000001', N'Có sẵn'),
('BS00100008', 'TL00000001', N'Có sẵn'),
('BS00100009', 'TL00000001', N'Có sẵn'),
('BS00100010', 'TL00000001', N'Có sẵn'),
('BS00200001', 'TL00000002', N'Có sẵn'),
('BS00200002', 'TL00000002', N'Có sẵn'),
('BS00200003', 'TL00000002', N'Có sẵn'),
('BS00200004', 'TL00000002', N'Có sẵn'),
('BS00200005', 'TL00000002', N'Có sẵn'),
('BS00200006', 'TL00000002', N'Có sẵn'),
('BS00200007', 'TL00000002', N'Có sẵn'),
('BS00200008', 'TL00000002', N'Có sẵn'),
('BS00200009', 'TL00000002', N'Có sẵn'),
('BS00200010', 'TL00000002', N'Có sẵn'),
('BS00300001', 'TL00000003', N'Có sẵn'),
('BS00300002', 'TL00000003', N'Có sẵn'),
('BS00300003', 'TL00000003', N'Có sẵn'),
('BS00300004', 'TL00000003', N'Có sẵn'),
('BS00300005', 'TL00000003', N'Có sẵn'),
('BS00300006', 'TL00000003', N'Có sẵn'),
('BS00300007', 'TL00000003', N'Có sẵn'),
('BS00300008', 'TL00000003', N'Có sẵn'),
('BS00300009', 'TL00000003', N'Có sẵn'),
('BS00300010', 'TL00000003', N'Có sẵn'),
('BS00400001', 'TL00000004', N'Có sẵn'),
('BS00400002', 'TL00000004', N'Có sẵn'),
('BS00400003', 'TL00000004', N'Có sẵn'),
('BS00400004', 'TL00000004', N'Có sẵn'),
('BS00400005', 'TL00000004', N'Có sẵn'),
('BS00400006', 'TL00000004', N'Có sẵn'),
('BS00400007', 'TL00000004', N'Có sẵn'),
('BS00400008', 'TL00000004', N'Có sẵn'),
('BS00400009', 'TL00000004', N'Có sẵn'),
('BS00400010', 'TL00000004', N'Có sẵn'),
('BS00500001', 'TL00000005', N'Có sẵn'),
('BS00500002', 'TL00000005', N'Có sẵn'),
('BS00500003', 'TL00000005', N'Có sẵn'),
('BS00500004', 'TL00000005', N'Có sẵn'),
('BS00500005', 'TL00000005', N'Có sẵn'),
('BS00500006', 'TL00000005', N'Có sẵn'),
('BS00500007', 'TL00000005', N'Có sẵn'),
('BS00500008', 'TL00000005', N'Có sẵn'),
('BS00500009', 'TL00000005', N'Có sẵn'),
('BS00500010', 'TL00000005', N'Có sẵn');
SELECT * FROM BANSAO

--TRIGGER
CREATE TRIGGER TRG_NGUOIMUON_INSERT
ON NGUOIMUON
INSTEAD OF INSERT -- Sử dụng INSTEAD OF để kiểm tra trước khi chèn
AS
BEGIN
    -- Lấy mã số người mượn từ bảng inserted (dữ liệu được chèn vào)
    DECLARE @MASO CHAR(10)
    SELECT @MASO = MASO FROM inserted

    -- Kiểm tra xem mã số đã tồn tại chưa
    IF EXISTS (SELECT 1 FROM NGUOIMUON WHERE MASO = @MASO)
    BEGIN
        RAISERROR (N'Mã số người mượn đã tồn tại!', 16, 1) -- Hiển thị thông báo lỗi
        ROLLBACK TRANSACTION -- Quay lại trạng thái trước khi chèn
    END
    ELSE
    BEGIN
        -- Nếu không trùng lặp, thực hiện chèn dữ liệu từ bảng inserted vào bảng NGUOIMUON
        INSERT INTO NGUOIMUON
        SELECT * FROM inserted
    END
END


CREATE TRIGGER TRG_NHANVIEN_INSERT
ON NHANVIEN
INSTEAD OF INSERT -- Sử dụng INSTEAD OF để kiểm tra trước khi chèn
AS
BEGIN
    -- Lấy mã số người mượn từ bảng inserted (dữ liệu được chèn vào)
    DECLARE @MANV CHAR(10)
    SELECT @MANV = MANV FROM inserted

    -- Kiểm tra xem mã số đã tồn tại chưa
    IF EXISTS (SELECT 1 FROM NHANVIEN WHERE MANV = @MANV)
    BEGIN
        RAISERROR (N'Mã số nhân viên đã tồn tại!', 16, 1) -- Hiển thị thông báo lỗi
        ROLLBACK TRANSACTION -- Quay lại trạng thái trước khi chèn
    END
    ELSE
    BEGIN
        -- Nếu không trùng lặp, thực hiện chèn dữ liệu từ bảng inserted vào bảng NGUOIMUON
        INSERT INTO NHANVIEN
        SELECT * FROM inserted
    END
END

CREATE TRIGGER TRG_TAILIEU_INSTEADOFINSERT
ON TAILIEU
INSTEAD OF INSERT
AS
BEGIN
    -- Kiểm tra xem mã tài liệu mới có tồn tại trong bảng TAILIEU hay không
    IF EXISTS (SELECT 1 FROM TAILIEU TL JOIN inserted i ON TL.MATL = i.MATL)
    BEGIN
        RAISERROR (N'Mã tài liệu đã tồn tại!', 16, 1);
        ROLLBACK TRANSACTION; -- Hoàn tác việc chèn nếu mã tài liệu trùng lặp
    END
    ELSE
    BEGIN
        -- Nếu mã tài liệu không trùng lặp, thực hiện chèn (không bao gồm MAVT)
        INSERT INTO TAILIEU (MATL, MALOAITL, TENTL, TACGIA, NGONNGU, XUATBAN, SOTRANG, SOLUONG, GIA, MAVT)
        SELECT MATL, MALOAITL, TENTL, TACGIA, NGONNGU, XUATBAN, SOTRANG, SOLUONG, GIA, MAVT
        FROM inserted;
    END
END;


CREATE TRIGGER TRG_BANSAO_INSTEADOFINSERT
ON BANSAO
INSTEAD OF INSERT
AS
BEGIN
    -- Kiểm tra xem bản sao mới có tồn tại trong bảng BANSAO hay không
    IF EXISTS (SELECT 1 FROM BANSAO BS JOIN inserted i ON BS.MATL = i.MATL)
    BEGIN
        RAISERROR (N'Bản sao đã tồn tại!', 16, 1);
        ROLLBACK TRANSACTION; -- Hoàn tác việc chèn nếu bản sao trùng lặp
    END
    ELSE
    BEGIN
        -- Nếu bản sao không trùng lặp, thực hiện chèn
        INSERT INTO BANSAO (MABANS, MATL, TRANGTHAI)
        SELECT MABANS, MATL, TRANGTHAI
        FROM inserted;
    END
END;


CREATE TRIGGER TRG_CTMUON_INSERT
ON CTMUON
AFTER INSERT
AS
BEGIN
    -- Cập nhật HANTRA cho các dòng mới được chèn
    UPDATE CT
    SET HANTRA = DATEADD(DAY,
                        (SELECT SONGAYMUON
                         FROM LOAITL LT
                         JOIN TAILIEU TL ON LT.MALOAITL = TL.MALOAITL
                         JOIN BANSAO BS ON TL.MATL = BS.MATL
                         WHERE BS.MABANS = inserted.MABANS),  -- Sử dụng MABANS từ inserted
                        (SELECT NGAYMUON FROM MUON WHERE MAMUON = inserted.MAMUON)
                       ),
		TINHTRANG = N'Đang mượn' -- Đặt trạng thái là "Đang mượn" khi mượn
    FROM CTMUON CT
    JOIN inserted ON CT.MAMUON = inserted.MAMUON AND CT.MABANS = inserted.MABANS;

	UPDATE BS
    SET TRANGTHAI = N'Đang được mượn'
    FROM BANSAO BS
    JOIN inserted ON BS.MABANS = inserted.MABANS;
END;

CREATE TRIGGER TRG_CTTRA_INSERT ON CTTRA
AFTER INSERT
AS
BEGIN
    -- Lấy thông tin từ bảng inserted (dữ liệu mới được chèn vào)
    DECLARE @MAMUON CHAR(10), @MABANS CHAR(10), @MASO CHAR(10);
    SELECT @MAMUON = MAMUON, @MABANS = MABANS, @MASO = (SELECT MASO FROM MUON WHERE MAMUON = @MAMUON) FROM inserted;

    -- Kiểm tra xem người mượn có đang mượn bản sao này không
    IF NOT EXISTS (
        SELECT * FROM CTMUON 
        WHERE MAMUON = @MAMUON AND MABANS = @MABANS AND TINHTRANG = N'Đang mượn'
    )
    BEGIN
        -- Nếu không, rollback transaction và báo lỗi
        RAISERROR (N'Người mượn không thể trả bản sao này vì họ không đang mượn nó.', 16, 1);
        ROLLBACK TRANSACTION;
        RETURN;
    END
END;


CREATE TRIGGER TRG_CAPNHAT_TRANGTHAI_KHITRA
ON CTTRA
AFTER INSERT
AS
BEGIN
    DECLARE @MAMUON CHAR(10), @MABANS CHAR(10);

    -- Lấy thông tin từ dòng mới được chèn
    SELECT @MAMUON = MAMUON, @MABANS = MABANS
    FROM inserted;

    -- Cập nhật trạng thái bản sao thành "Có sẵn"
    UPDATE BANSAO
    SET TRANGTHAI = N'Có sẵn'
    WHERE MABANS = @MABANS;

    -- Cập nhật trạng thái mượn thành "Đã trả"
    UPDATE CTMUON
    SET TINHTRANG = N'Đã trả'
    WHERE MAMUON = @MAMUON AND MABANS = @MABANS;
END;


CREATE SEQUENCE SEQ_MAPH
    START WITH 1
    INCREMENT BY 1;

CREATE TRIGGER TRG_CTTRA_INSERT_PHAT
ON CTTRA
AFTER INSERT
AS
BEGIN
    DECLARE @MAMUON CHAR(10), @MABANS CHAR(10), @NGAYTRA DATE, @HANTRA DATE, @SONGAYQUAHAN INT, @GIA MONEY;

    -- Lấy thông tin từ dòng mới được chèn
    SELECT @MAMUON = MAMUON, @MABANS = MABANS, @NGAYTRA = NGAYTRA 
    FROM inserted;

    -- Lấy hạn trả và giá tiền từ bảng CTMUON và TAILIEU
    SELECT @HANTRA = CT.HANTRA, @GIA = TL.GIA
    FROM CTMUON CT
    JOIN BANSAO BS ON CT.MABANS = BS.MABANS
    JOIN TAILIEU TL ON BS.MATL = TL.MATL
    WHERE CT.MAMUON = @MAMUON AND CT.MABANS = @MABANS;

    -- Kiểm tra quá hạn và tính số ngày quá hạn
    SET @SONGAYQUAHAN = DATEDIFF(DAY, @HANTRA, @NGAYTRA);
    IF @SONGAYQUAHAN > 0 -- Chỉ tạo phiếu phạt khi quá hạn
    BEGIN
        DECLARE @SOTIEN MONEY;

        -- Tính tiền phạt dựa trên lý do
        IF @SONGAYQUAHAN <= 30
        BEGIN 
            SET @SOTIEN = @SONGAYQUAHAN * 5000; -- Phạt trả muộn
            UPDATE CTMUON SET TINHTRANG = N'Đã trả' WHERE MAMUON = @MAMUON AND MABANS = @MABANS;
            UPDATE BANSAO SET TRANGTHAI = N'Có sẵn' WHERE MABANS = @MABANS;
        END
        ELSE
        BEGIN
            SET @SOTIEN = @GIA * 1.5; -- Phạt mất tài liệu
            UPDATE CTMUON SET TINHTRANG = N'Đã làm mất' WHERE MAMUON = @MAMUON AND MABANS = @MABANS;
            UPDATE BANSAO SET TRANGTHAI = N'Đã mất' WHERE MABANS = @MABANS;
        END

		DECLARE @MAPH CHAR(10);  -- Giả sử bạn muốn mã phạt có dạng PH000001
		SET @MAPH = CONCAT('PH', FORMAT(NEXT VALUE FOR SEQ_MAPH, '000000'));

        -- Chèn phiếu phạt vào bảng PHIEUPHAT
        INSERT INTO PHIEUPHAT (MAPH, NGPHAT, SOTIEN, MAMUON, MABANS, LYDO)
        VALUES (
            @MAPH, 
            GETDATE(), 
            @SOTIEN,
            @MAMUON,
            @MABANS,
            CASE 
                WHEN @SONGAYQUAHAN <= 30 THEN N'Trả muộn'
                ELSE N'Mất tài liệu'
            END
        );
    END
END;
--FUNCTION
-- Tra cuu tt tl

CREATE FUNCTION ThongTinTatCaTaiLieu()
RETURNS TABLE
AS
RETURN
(
    SELECT DISTINCT TL.MATL, TL.TENTL, TL.TACGIA, TL.NGONNGU, TL.SOTRANG, TL.MALOAITL, LTL.TENLOAITL, TL.GIA, TL.SOLUONG
    FROM TAILIEU TL JOIN LOAITL LTL ON TL.MALOAITL = LTL.MALOAITL
);

SELECT * FROM DBO.ThongTinTatCaTaiLieu()

CREATE FUNCTION LayThongTinBanSao(
    @MATL CHAR(10), 
    @TrangThai NVARCHAR(40) = NULL
)
RETURNS TABLE
AS
RETURN
(
    SELECT TL.MATL, BS.MABANS, BS.TRANGTHAI, VT.SOPHONG, VT.SOKE, VT.SONGAN
    FROM BANSAO BS 
    JOIN TAILIEU TL ON BS.MATL = TL.MATL
    JOIN VITRI VT ON TL.MAVT = VT.MAVT
    WHERE TL.MATL = @MATL
        AND (@TrangThai IS NULL OR BS.TRANGTHAI LIKE N'%' + CAST(@TrangThai AS NVARCHAR(40)) + N'%')
);


drop function dbo.LayThongTinBanSao

SELECT * FROM DBO.LayThongTinBanSao('TL00000005',' ');
SELECT * FROM DBO.LayThongTinBanSao('TL00000001', N'Có sẵn'); 
SELECT * FROM DBO.LayThongTinBanSao('TL00000001','Có sẵn'); -- không chạy đc 
SELECT * FROM DBO.LayThongTinBanSao('TL00000005', N'Đang được mượn'); 
SELECT * FROM DBO.LayThongTinBanSao('TL00000001', N'Đã mất'); 


CREATE FUNCTION TimKiemTaiLieu(@TuKhoa NVARCHAR(100))
RETURNS TABLE
AS
RETURN
(
    SELECT TL.MATL, TL.TENTL, TL.TACGIA, TL.NGONNGU, TL.SOTRANG, TL.MALOAITL, LTL.TENLOAITL, TL.GIA, TL.SOLUONG
    FROM TAILIEU TL 
    JOIN LOAITL LTL ON TL.MALOAITL = LTL.MALOAITL
    WHERE TL.TENTL LIKE N'%' + @TuKhoa + N'%'  -- Tìm kiếm theo tên tài liệu
       OR TL.TACGIA LIKE N'%' + @TuKhoa + N'%' -- Tìm kiếm theo tác giả
       OR TL.MATL LIKE N'%' + @TuKhoa + N'%'   -- Tìm kiếm theo mã tài liệu
       OR TL.NGONNGU LIKE N'%' + @TuKhoa + N'%' -- Tìm kiếm theo ngôn ngữ
       OR TL.XUATBAN LIKE N'%' + @TuKhoa + N'%' -- Tìm kiếm theo nhà xuất bản
       OR LTL.TENLOAITL LIKE N'%' + @TuKhoa + N'%' -- Tìm kiếm theo tên thể loại (thêm mới)
);

SELECT * FROM DBO.TimKiemTaiLieu('Giáo trình toán ')

--TRA CUU NGUOI MUON

CREATE FUNCTION LichSuMuonSachCuaNguoiMuon(
    @MASO CHAR(10), 
    @TINHTRANG NVARCHAR(40) = NULL 
)
RETURNS TABLE
AS
RETURN
(
    SELECT BS.MATL, TL.TENTL, BS.MABANS, CT.TINHTRANG, M.NGAYMUON, CT.HANTRA, CTTR.NGAYTRA -- Thêm cột NGAYTRA
    FROM MUON M
    JOIN CTMUON CT ON M.MAMUON = CT.MAMUON
    JOIN BANSAO BS ON CT.MABANS = BS.MABANS
    JOIN TAILIEU TL ON BS.MATL = TL.MATL
    LEFT JOIN CTTRA CTTR ON CT.MAMUON = CTTR.MAMUON AND CT.MABANS = CTTR.MABANS -- JOIN với CTTRA để lấy ngày trả
    WHERE M.MASO = @MASO
      AND (CT.TINHTRANG = @TINHTRANG OR @TINHTRANG IS NULL)
);

select * from dbo.LichSuMuonSachCuaNguoiMuon('MS00000010',DEFAULT)
select * from dbo.LichSuMuonSachCuaNguoiMuon('MS00000010',N'Đang mượn')
select * from dbo.LichSuMuonSachCuaNguoiMuon('MS00000010',N'Đã trả')
select * from dbo.LichSuMuonSachCuaNguoiMuon('MS00000010',N'Đã làm mất')


CREATE FUNCTION ThongTinPhatSinhVien(@MASO CHAR(10))
RETURNS TABLE
AS
RETURN
(
    SELECT M.MASO,SUM(P.SOTIEN) AS TongTienPhat, 
           STRING_AGG(CONCAT(P.MAPH, ': ', P.LYDO, ' (', P.SOTIEN, ' VND)'), CHAR(13) + CHAR(10)) AS DanhSachPhat
    FROM MUON M
    JOIN CTMUON CT ON M.MAMUON = CT.MAMUON
    JOIN PHIEUPHAT P ON P.MAMUON = M.MAMUON AND P.MABANS = CT.MABANS -- Thêm điều kiện join với bảng PHIEUPHAT
    WHERE M.MASO = @MASO
    GROUP BY M.MASO   -- Nhóm theo MASO để tính tổng tiền phạt
);

CREATE FUNCTION BaoCaoHoatDongTrongNgay (@Ngay DATE)
RETURNS TABLE
AS
RETURN
(
    -- Truy vấn 1: Lấy thông tin mượn (giữ nguyên)
    SELECT
        M.MANV AS MaNhanVien,
        NV.TENNV AS TenNhanVien,
        M.MASO AS MaNguoiMuon,
        NM.HOTEN AS TenNguoiMuon,
        BS.MATL AS MaTaiLieu,
        TL.TENTL AS TenTaiLieu,
        BS.MABANS AS MaBanSao,
        N'Mượn' AS HoatDong,
        NULL AS MaPhieuPhat,
        NULL AS SoTienPhat,
        NULL AS LyDoPhat
    FROM MUON M
    JOIN CTMUON CT ON M.MAMUON = CT.MAMUON
    JOIN BANSAO BS ON CT.MABANS = BS.MABANS
    JOIN TAILIEU TL ON BS.MATL = TL.MATL
    JOIN NGUOIMUON NM ON M.MASO = NM.MASO
    JOIN NHANVIEN NV ON M.MANV = NV.MANV
    WHERE M.NGAYMUON = @Ngay

    UNION ALL

    -- Truy vấn 2: Lấy thông tin trả/làm mất
    SELECT
        TR.MANV AS MaNhanVien,
        NV.TENNV AS TenNhanVien,
        TR.MASO AS MaNguoiMuon,
        NM.HOTEN AS TenNguoiMuon,
        BS.MATL AS MaTaiLieu,
        TL.TENTL AS TenTaiLieu,
        BS.MABANS AS MaBanSao,
        CASE 
            WHEN CT.TINHTRANG = N'Đã làm mất' THEN N'Làm mất' 
            ELSE N'Trả' 
        END AS HoatDong,
        PP.MAPH AS MaPhieuPhat,
        PP.SOTIEN AS SoTienPhat,
        PP.LYDO AS LyDoPhat
    FROM TRA TR
    JOIN CTTRA CTTR ON TR.MATRA = CTTR.MATRA
    JOIN CTMUON CT ON CTTR.MAMUON = CT.MAMUON AND CTTR.MABANS = CT.MABANS
    JOIN BANSAO BS ON CTTR.MABANS = BS.MABANS
    JOIN TAILIEU TL ON BS.MATL = TL.MATL
    JOIN NGUOIMUON NM ON TR.MASO = NM.MASO
    JOIN NHANVIEN NV ON TR.MANV = NV.MANV
    LEFT JOIN PHIEUPHAT PP ON CT.MAMUON = PP.MAMUON AND BS.MABANS = PP.MABANS
    WHERE CTTR.NGAYTRA = @Ngay
);

 select * from dbo.BaoCaoHoatDongTrongNgay('2024-06-08')

CREATE FUNCTION BaoCaoHoatDongNguoiMuonTrongNgay(@MASO CHAR(10), @Ngay DATE)
RETURNS TABLE
AS
RETURN
(
    SELECT *
    FROM BaoCaoHoatDongTrongNgay(@Ngay)
    WHERE MaNguoiMuon = @MASO
);

CREATE FUNCTION BaoCaoHoatDongNhanVienTrongNgay(@MANV CHAR(10), @Ngay DATE)
RETURNS TABLE
AS
RETURN
(
    SELECT *
    FROM BaoCaoHoatDongTrongNgay(@Ngay)
    WHERE MaNhanVien = @MANV
);

select * from dbo.BaoCaoHoatDongNhanVienTrongNgay('NV00000001','2024-06-08')

CREATE FUNCTION ThongKeMuonTheoLoaiTaiLieu()
RETURNS TABLE
AS
RETURN
(
    SELECT TL.MALOAITL, LTL.TENLOAITL, COUNT(*) AS SoLuongMuon
    FROM MUON M
    JOIN CTMUON CT ON M.MAMUON = CT.MAMUON
    JOIN BANSAO BS ON CT.MABANS = BS.MABANS
    JOIN TAILIEU TL ON BS.MATL = TL.MATL
    JOIN LOAITL LTL ON TL.MALOAITL = LTL.MALOAITL
    GROUP BY TL.MALOAITL, LTL.TENLOAITL
);

select * from dbo.ThongKeMuonTheoLoaiTaiLieu()

CREATE FUNCTION ThongKeTaiLieuTheoTheLoai()
RETURNS TABLE
AS
RETURN
(
    SELECT LTL.TENLOAITL, COUNT(*) AS SoLuong
    FROM TAILIEU TL
    JOIN LOAITL LTL ON TL.MALOAITL = LTL.MALOAITL
    GROUP BY LTL.TENLOAITL
);
SELECT * FROM DBO.ThongKeTaiLieuTheoTheLoai()


CREATE FUNCTION TaiLieuQuaHan()
RETURNS TABLE
AS
RETURN
(
    SELECT M.MASO, NM.HOTEN, BS.MATL, TL.TENTL, CT.HANTRA, DATEDIFF(DAY, CT.HANTRA, GETDATE()) AS SoNgayQuaHan
    FROM MUON M
    JOIN CTMUON CT ON M.MAMUON = CT.MAMUON
    JOIN BANSAO BS ON CT.MABANS = BS.MABANS
    JOIN TAILIEU TL ON BS.MATL = TL.MATL
    JOIN NGUOIMUON NM ON M.MASO = NM.MASO
    WHERE CT.TINHTRANG = N'Đang mượn' AND CT.HANTRA < GETDATE()
);

select * from dbo.TaiLieuQuaHan()

----PROCEDURE

CREATE SEQUENCE SEQ_MAMUON
    START WITH 1
    INCREMENT BY 1;

CREATE PROCEDURE MUONTAILIEU -- DÙng để Mượn tài liệu 
    @MASO CHAR(10),
    @LISTMABANS NVARCHAR(MAX),  -- Danh sách mã bản sao, cách nhau bởi dấu phẩy
	@NGAYMUON DATE
AS
BEGIN
    SET NOCOUNT ON;

    BEGIN TRY
        BEGIN TRANSACTION;

        -- Kiểm tra xem sinh viên có tồn tại không
        IF NOT EXISTS (SELECT 1 FROM NGUOIMUON WHERE MASO = @MASO)
        BEGIN
            RAISERROR (N'Mã số người mượn không tồn tại.', 16, 1);
            RETURN;
        END

        -- Tạo bảng tạm để lưu danh sách mã bản sao
        CREATE TABLE #tempMaBanSao (MABANS CHAR(10));
        INSERT INTO #tempMaBanSao (MABANS)
        SELECT value FROM STRING_SPLIT(@LISTMABANS, ',');

        -- Kiểm tra xem tất cả các mã bản sao có tồn tại không
        IF EXISTS (SELECT 1 FROM #tempMaBanSao WHERE MABANS NOT IN (SELECT MABANS FROM BANSAO))
        BEGIN
            RAISERROR (N'Một hoặc nhiều mã bản sao không tồn tại.', 16, 1);
            RETURN;
        END

        -- Tạo mã mượn mới
        DECLARE @MAMUON CHAR(10);
        SET @MAMUON = CONCAT('M', FORMAT(NEXT VALUE FOR SEQ_MAMUON, '000000'));

        -- Lấy mã nhân viên (bạn có thể thay đổi logic này tùy theo yêu cầu)
        DECLARE @MANV CHAR(10);
        SELECT TOP 1 @MANV = MANV 
		FROM NHANVIEN
		ORDER BY NEWID();

        -- Thêm vào bảng MUON
        INSERT INTO MUON (MAMUON, MASO, MANV, NGAYMUON)
        VALUES (@MAMUON, @MASO, @MANV, @NGAYMUON);

        -- Thêm vào bảng CTMUON và kích hoạt trigger để cập nhật hạn trả và trạng thái
        INSERT INTO CTMUON (MAMUON, MABANS)
        SELECT @MAMUON, MABANS FROM #tempMaBanSao;

        DROP TABLE #tempMaBanSao;  -- Xóa bảng tạm

        COMMIT TRANSACTION;
        PRINT N'Mượn tài liệu thành công.';
    END TRY
    BEGIN CATCH
        ROLLBACK TRANSACTION;
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE();
        RAISERROR (@ErrorMessage, 16, 1);
    END CATCH
END;

EXEC MUONTAILIEU 'MS00000010', 'BS00200009,BS00400004','2024-09-13'

select * from dbo.LayThongTinBanSao('TL00000002',N' ')
SELECT * FROM CTMUON

CREATE SEQUENCE SEQ_MATRA
    START WITH 1
    INCREMENT BY 1;

CREATE PROCEDURE TRATAILIEU --Dùng để trả tài liệu
    @MASO CHAR(10),
    @LISTBANS NVARCHAR(MAX),
    @NGAYTRA DATE
AS
BEGIN
    SET NOCOUNT ON;

    BEGIN TRY
        BEGIN TRANSACTION;

        -- Kiểm tra xem sinh viên có tồn tại không
        IF NOT EXISTS (SELECT 1 FROM NGUOIMUON WHERE MASO = @MASO)
        BEGIN
            RAISERROR (N'Mã số sinh viên không tồn tại.', 16, 1);
            RETURN;
        END

        -- Tạo bảng tạm để lưu danh sách mã bản sao
        CREATE TABLE #tempMaBanSao (MABANS CHAR(10));
        INSERT INTO #tempMaBanSao (MABANS)
        SELECT value FROM STRING_SPLIT(@LISTBANS, ',');

        -- Kiểm tra xem tất cả các mã bản sao có tồn tại không
        IF EXISTS (SELECT 1 FROM #tempMaBanSao WHERE MABANS NOT IN (SELECT MABANS FROM BANSAO))
        BEGIN
            RAISERROR (N'Một hoặc nhiều mã bản sao không tồn tại.', 16, 1);
            RETURN;
        END

        -- Lấy mã nhân viên (bạn có thể thay đổi logic này tùy theo yêu cầu)
        DECLARE @MANV CHAR(10);
        SELECT TOP 1 @MANV = MANV FROM NHANVIEN;

        -- Tạo mã trả mới
        DECLARE @MATRA CHAR(10);
        SET @MATRA = CONCAT('TR', FORMAT(NEXT VALUE FOR SEQ_MATRA, '000000'));

        -- Thêm vào bảng TRA
        INSERT INTO TRA (MATRA, MASO, MANV)
        VALUES (@MATRA, @MASO, @MANV);

        -- Thêm vào bảng CTTRA và kích hoạt các trigger
        DECLARE @MABANS CHAR(10);
        DECLARE cur CURSOR FOR SELECT MABANS FROM #tempMaBanSao;
        OPEN cur;
        FETCH NEXT FROM cur INTO @MABANS;
        WHILE @@FETCH_STATUS = 0
        BEGIN
            -- Lấy mã mượn tương ứng với bản sao
            DECLARE @MAMUON CHAR(10);
            SELECT @MAMUON = MAMUON FROM CTMUON WHERE MABANS = @MABANS;

            -- Thêm vào bảng CTTRA và kích hoạt trigger
            INSERT INTO CTTRA (MATRA, MAMUON, MABANS, NGAYTRA)
            VALUES (@MATRA, @maMuon, @MABANS, @NGAYTRA);

            FETCH NEXT FROM cur INTO @MABANS;
        END
        CLOSE cur;
        DEALLOCATE cur;

        DROP TABLE #tempMaBanSao;

        COMMIT TRANSACTION;
        PRINT N'Trả tài liệu thành công.';
    END TRY
    BEGIN CATCH
        ROLLBACK TRANSACTION;
        DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE();
        RAISERROR (@ErrorMessage, 16, 1);
    END CATCH
END;

EXEC TRATAILIEU 'MS00000010','BS00200008','2024-10-11'

---


select * from dbo.LichSuMuonSachCuaNguoiMuon('MS00000010',DEFAULT)
select * from dbo.LichSuMuonSachCuaNguoiMuon('MS00000010',N'Đã trả')
select * from dbo.LichSuMuonSachCuaNguoiMuon('MS00000010',N'Đã làm mất')

select * from dbo.BaoCaoHoatDongTrongNgay('2024-10-11')
select * from dbo.ThongTinPhatSinhVien('MS00000010')
select * from dbo.ThongTinTatCaTaiLieu()
select * from dbo.LayThongTinBanSao('TL00000002',N'Đã Mất')

select * from TAILIEU

use master
drop database QUANLYTHUVIEN