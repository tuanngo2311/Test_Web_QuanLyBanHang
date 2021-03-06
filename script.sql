USE [demoASMJV4]
GO
/****** Object:  Table [dbo].[categories]    Script Date: 24/04/2021 10:02:14 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[categories](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NULL,
	[note] [varchar](200) NULL,
 CONSTRAINT [PK_categories] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[products]    Script Date: 24/04/2021 10:02:14 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[products](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](200) NULL,
	[price] [int] NULL,
	[note] [varchar](200) NULL,
	[image] [varchar](200) NULL,
	[category_id] [int] NULL,
 CONSTRAINT [PK_product_1] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user]    Script Date: 24/04/2021 10:02:14 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](200) NULL,
	[password] [varchar](200) NULL,
	[fullname] [varchar](200) NULL,
	[email] [varchar](200) NULL,
	[phone] [varchar](50) NULL,
	[role] [int] NULL,
 CONSTRAINT [PK_user] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[categories] ON 

INSERT [dbo].[categories] ([id], [name], [note]) VALUES (1, N'Dien Thoai', N'Chinh Hang')
INSERT [dbo].[categories] ([id], [name], [note]) VALUES (2, N'May Tinh', N'Chinh Hang')
INSERT [dbo].[categories] ([id], [name], [note]) VALUES (3, N'Tay Nghe', N'Chinh Hang')
INSERT [dbo].[categories] ([id], [name], [note]) VALUES (4, N'Phu Kien', N'Chinh Hang')
INSERT [dbo].[categories] ([id], [name], [note]) VALUES (5, N'TiVi', N'Chinh Hang')
INSERT [dbo].[categories] ([id], [name], [note]) VALUES (6, N'May Lanh', N'Chinh Hang')
INSERT [dbo].[categories] ([id], [name], [note]) VALUES (7, N'Tu Lanh', N'Chinh Hang')
SET IDENTITY_INSERT [dbo].[categories] OFF
GO
SET IDENTITY_INSERT [dbo].[products] ON 

INSERT [dbo].[products] ([id], [name], [price], [note], [image], [category_id]) VALUES (44, N'Tu Lanh SHARP', 5190000, N'Thai Lan', N'tivi.jpg', 7)
INSERT [dbo].[products] ([id], [name], [price], [note], [image], [category_id]) VALUES (45, N'May Lanh Asanzo ', 4199000, N'Dieu hoa 1 chieu', N'maylanh.jpg', 6)
INSERT [dbo].[products] ([id], [name], [price], [note], [image], [category_id]) VALUES (46, N'Tu Lanh Inverter  ', 6779000, N'Thai Lan', N'pmaylanh.png', 7)
INSERT [dbo].[products] ([id], [name], [price], [note], [image], [category_id]) VALUES (47, N'LapTop Dell', 6000000, N'Chinh Hang', N'laptop.jpg', 2)
INSERT [dbo].[products] ([id], [name], [price], [note], [image], [category_id]) VALUES (48, N'Iphone12', 12000, N'Apple', N'iphone12.jpg', 1)
INSERT [dbo].[products] ([id], [name], [price], [note], [image], [category_id]) VALUES (50, N'Iphone12', 12000, N'Apple', N'iphone12.jpg', 1)
SET IDENTITY_INSERT [dbo].[products] OFF
GO
SET IDENTITY_INSERT [dbo].[user] ON 

INSERT [dbo].[user] ([id], [username], [password], [fullname], [email], [phone], [role]) VALUES (81, N'ngoanhtuan', N'1', N'Ngo Anh Tuan', N'cutrongxoay141@yahoo.com', N'0337997540', 1)
INSERT [dbo].[user] ([id], [username], [password], [fullname], [email], [phone], [role]) VALUES (82, N'tuannhanvien', N'1', N'Ngo Anh Tuan', N'tymom1801@gmail.com', N'0337997540', 0)
INSERT [dbo].[user] ([id], [username], [password], [fullname], [email], [phone], [role]) VALUES (83, N'vantoan', N'vantoan1', N'cao van toan', N'toanvc@gmail.com', N'0123456789', 0)
INSERT [dbo].[user] ([id], [username], [password], [fullname], [email], [phone], [role]) VALUES (84, N'tuan', N'tuan', N'ngo anh tuan', N'abc@gmail.com', N'0154544546', 1)
INSERT [dbo].[user] ([id], [username], [password], [fullname], [email], [phone], [role]) VALUES (85, N'', N'', N'', N'', N'', 0)
INSERT [dbo].[user] ([id], [username], [password], [fullname], [email], [phone], [role]) VALUES (86, N'teovan123Up', N'vanteo123up', N'Nguyen Van Teo', N'teo@gmail.com', N'0123456789', 0)
INSERT [dbo].[user] ([id], [username], [password], [fullname], [email], [phone], [role]) VALUES (87, N'teovan123Up', N'vanteo123up', N'Nguyen Van Teo', N'teo@gmail.com', N'0123456789', 0)
INSERT [dbo].[user] ([id], [username], [password], [fullname], [email], [phone], [role]) VALUES (88, N'vantoan', N'vantoan1', N'cao van toan', N'toanvc@gmail.com', N'0123456789', 0)
INSERT [dbo].[user] ([id], [username], [password], [fullname], [email], [phone], [role]) VALUES (89, NULL, N'1234567', NULL, NULL, NULL, 0)
SET IDENTITY_INSERT [dbo].[user] OFF
GO
ALTER TABLE [dbo].[products]  WITH CHECK ADD  CONSTRAINT [FK_products_categories] FOREIGN KEY([category_id])
REFERENCES [dbo].[categories] ([id])
GO
ALTER TABLE [dbo].[products] CHECK CONSTRAINT [FK_products_categories]
GO
