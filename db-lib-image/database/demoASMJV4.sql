USE [demoASMJV4]
GO
/****** Object:  Table [dbo].[categories]    Script Date: 10/22/2020 23:11:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[categories](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NULL,
	[note] [varchar](200) NULL,
 CONSTRAINT [PK_categories] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[products]    Script Date: 10/22/2020 23:11:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[user]    Script Date: 10/22/2020 23:11:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
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
SET IDENTITY_INSERT [dbo].[products] ON 

INSERT [dbo].[products] ([id], [name], [price], [note], [image], [category_id]) VALUES (44, N'TiVi', 8390000, N'Viet Nam', N'tivi.jpg', 5)
INSERT [dbo].[products] ([id], [name], [price], [note], [image], [category_id]) VALUES (45, N'May Lanh Asanzo ', 4199000, N'Dieu hoa 1 chieu', N'maylanh.jpg', 6)
INSERT [dbo].[products] ([id], [name], [price], [note], [image], [category_id]) VALUES (46, N'Tu Lanh Inverter  ', 6779000, N'Thai Lan', N'pmaylanh.png', 7)
INSERT [dbo].[products] ([id], [name], [price], [note], [image], [category_id]) VALUES (47, N'LapTop Dell', 6000000, N'Chinh Hang', N'laptop.jpg', 2)
SET IDENTITY_INSERT [dbo].[products] OFF
SET IDENTITY_INSERT [dbo].[user] ON 

INSERT [dbo].[user] ([id], [username], [password], [fullname], [email], [phone], [role]) VALUES (46, N'manisha', N'manisha', N'manisha', N'manisha@gmail.com', N'0123456789', 0)
INSERT [dbo].[user] ([id], [username], [password], [fullname], [email], [phone], [role]) VALUES (47, N'teovan123Up', N'vanteo123up', N'Nguyen Van Teo', N'teo@gmail.com', N'0123456789', 0)
INSERT [dbo].[user] ([id], [username], [password], [fullname], [email], [phone], [role]) VALUES (53, N'khai', N'khai', N'Khai', N'khaih@gmail.com', N'0985678652', 1)
INSERT [dbo].[user] ([id], [username], [password], [fullname], [email], [phone], [role]) VALUES (60, N'sang', N'sang', N'Sang', N'sang@gmail.com', N'0123456789', 0)
INSERT [dbo].[user] ([id], [username], [password], [fullname], [email], [phone], [role]) VALUES (61, N'HoXuanNhi', N'HoXuanNhi', N'HoXuanNhi', N'hoxuannhi@gmail.com', N'0123456789', 0)
INSERT [dbo].[user] ([id], [username], [password], [fullname], [email], [phone], [role]) VALUES (62, N'vantoan', N'vantoan1', N'cao van toan', N'toanvc@gmail.com', N'0123456789', 0)
INSERT [dbo].[user] ([id], [username], [password], [fullname], [email], [phone], [role]) VALUES (79, N'caokhai', N'caokhai', N'Hoang Cao Khai', N'khaihcps10763@gmail.com', N'0985678652', 1)
INSERT [dbo].[user] ([id], [username], [password], [fullname], [email], [phone], [role]) VALUES (80, N'nguyensang', N'nguyensang', N'Nguyen Sang', N'sang@gmail.com', N'0123456789', 0)
SET IDENTITY_INSERT [dbo].[user] OFF
ALTER TABLE [dbo].[products]  WITH CHECK ADD  CONSTRAINT [FK_products_categories] FOREIGN KEY([category_id])
REFERENCES [dbo].[categories] ([id])
GO
ALTER TABLE [dbo].[products] CHECK CONSTRAINT [FK_products_categories]
GO
