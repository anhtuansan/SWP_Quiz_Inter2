USE [master]
GO
/****** Object:  Database [SWP391_G6]    Script Date: 6/3/2024 5:42:07 PM ******/
CREATE DATABASE [SWP391_G6]
DROP database [SWP391_G6]
CREATE TABLE [dbo].[answers](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[answer_detail] [varchar](max) NULL,
	[created_at] [date] NULL,
	[update_at] [date] NULL,
	[creator_id] [int] NULL,
	[is_correct] [int] NULL,
 CONSTRAINT [PK_answers] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[blogs]    Script Date: 6/3/2024 5:42:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[blogs](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [varchar](max) NULL,
	[author_id] [int] NULL,
	[created_at] [date] NULL,
	[updated_at] [date] NULL,
	[content] [ntext] NULL,
	[status] [int] NULL,
	[thumbnail] [varchar](max) NULL,
	[briefinfo] [varchar](max) NULL,
 CONSTRAINT [PK_blogs] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[categories]    Script Date: 6/3/2024 5:42:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[categories](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NOT NULL,
	[created_at] [date] NULL,
	[updated_at] [date] NULL,
	[created_by] [int] NOT NULL,
	[updated_by] [int] NULL,
 CONSTRAINT [PK_categories] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[lesson_has_quiz]    Script Date: 6/3/2024 5:42:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[lesson_has_quiz](
	[lesson_id] [int] NULL,
	[quiz_id] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[lessons]    Script Date: 6/3/2024 5:42:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[lessons](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](max) NULL,
	[creator_id] [int] NULL,
	[update_at] [date] NULL,
	[created_at] [date] NULL,
	[status] [int] NULL,
	[content] [text] NULL,
	[media] [nvarchar](255) NULL,
 CONSTRAINT [PK_lessons] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[package_price]    Script Date: 6/3/2024 5:42:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[package_price](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](max) NULL,
	[duration] [int] NULL,
	[sale_price] [decimal](18, 2) NULL,
	[price] [decimal](18, 2) NULL,
	[original_price] [decimal](18, 2) NULL,
 CONSTRAINT [PK_package_price] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[payments]    Script Date: 6/3/2024 5:42:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[payments](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NULL,
	[method] [varchar](max) NULL,
	[payment_date] [date] NULL,
	[price] [float] NULL,
 CONSTRAINT [PK_payments] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[question_has_answer]    Script Date: 6/3/2024 5:42:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[question_has_answer](
	[question_id] [int] NULL,
	[answer_id] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[questions]    Script Date: 6/3/2024 5:42:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[questions](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[detail] [varchar](max) NULL,
 CONSTRAINT [PK_questions] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[quiz_has_question]    Script Date: 6/3/2024 5:42:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[quiz_has_question](
	[quiz_id] [int] NULL,
	[question_id] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[quizs]    Script Date: 6/3/2024 5:42:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[quizs](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [varchar](max) NULL,
	[created_at] [date] NULL,
	[update_ad] [date] NULL,
	[creator_id] [varchar](max) NULL,
	[score] [float] NULL,
	[time] [int] NULL,
 CONSTRAINT [PK_quizs] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[roles]    Script Date: 6/3/2024 5:42:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[roles](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](max) NULL,
 CONSTRAINT [PK_roles] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Slider]    Script Date: 6/3/2024 5:42:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Slider](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](max) NULL,
	[SubTitle] [nvarchar](max) NULL,
	[Content] [nvarchar](max) NULL,
	[Image] [nvarchar](max) NULL,
	[LinkUrl] [nvarchar](max) NULL,
	[CreatedAt] [date] NULL,
	[CreatedBy] [int] NULL,
	[Status] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[status]    Script Date: 6/3/2024 5:42:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[status](
	[id] [int] NOT NULL,
	[name] [varchar](max) NULL,
 CONSTRAINT [PK_status] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[subject_has_lesson]    Script Date: 6/3/2024 5:42:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[subject_has_lesson](
	[subject_id] [int] NULL,
	[lesson_id] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[subject_has_price_package]    Script Date: 6/3/2024 5:42:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[subject_has_price_package](
	[subject_id] [int] NOT NULL,
	[price_package_id] [int] NOT NULL,
 CONSTRAINT [PK_subject_has_price_package] PRIMARY KEY CLUSTERED 
(
	[subject_id] ASC,
	[price_package_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[subject_has_tag]    Script Date: 6/3/2024 5:42:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[subject_has_tag](
	[subject_id] [int] NOT NULL,
	[tag_id] [int] NOT NULL,
 CONSTRAINT [PK_subject_has_tag] PRIMARY KEY CLUSTERED 
(
	[subject_id] ASC,
	[tag_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[subjects]    Script Date: 6/3/2024 5:42:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[subjects](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](max) NULL,
	[creator_id] [int] NULL,
	[creater_at] [date] NULL,
	[update_at] [date] NULL,
	[status] [int] NULL,
	[img] [varchar](max) NULL,
	[description] [text] NULL,
 CONSTRAINT [PK_subjects] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tags]    Script Date: 6/3/2024 5:42:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tags](
	[id] [int] NOT NULL,
	[tag] [varchar](50) NULL,
 CONSTRAINT [PK_tags] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user_has_subject]    Script Date: 6/3/2024 5:42:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_has_subject](
	[user_id] [int] NULL,
	[subject_id] [int] NULL,
	[start_date] [nchar](10) NULL,
	[end_date] [nchar](10) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 6/3/2024 5:42:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[full_name] [varchar](max) NULL,
	[email] [varchar](max) NULL,
	[phone_number] [varchar](max) NULL,
	[gender] [int] NULL,
	[profile_img] [varchar](max) NULL,
	[password] [varchar](max) NULL,
	[created_at] [date] NULL,
	[updated_at] [date] NULL,
	[role_id] [int] NULL,
	[status_id] [int] NULL,
	[token] [varchar](30) NULL,
 CONSTRAINT [PK_users] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[blogs] ON 

INSERT [dbo].[blogs] ([id], [title], [author_id], [created_at], [updated_at], [content], [status], [thumbnail], [briefinfo]) VALUES (18, N'Exploring the Beauty of Mathematics', 3, CAST(N'2024-01-01' AS Date), CAST(N'2024-01-01' AS Date), N'Numbers and Operations: The foundations of mathematics include natural numbers, integers, fractions, decimals and real numbers. Basic calculations such as addition, subtraction, multiplication and division are essential tools.
Algebra: This branch is concerned with the study of symbols and rules for manipulating those symbols. It involves solving equations and understanding functions.
Geometry: Focuses on the properties and relationships of points, lines, surfaces, and solids. Key concepts include angle, shape, area, and volume.
Calculus: Explores changes and motions, dealing with derivatives and integration. It is fundamental in physics and engineering.
Statistics and Probability: Involves the analysis and interpretation of data and the likelihood of events occurring.
', 1, N'images/math_2.jpg', N'Mathematics is a field of study that explores numbers, quantities, ')
INSERT [dbo].[blogs] ([id], [title], [author_id], [created_at], [updated_at], [content], [status], [thumbnail], [briefinfo]) VALUES (19, N'Unveiling the World of Chemistry: Principles, Branches', 4, CAST(N'2022-01-03' AS Date), CAST(N'2022-01-03' AS Date), N'Numbers and Operations: The foundations of mathematics include natural numbers, integers, fractions, decimals and real numbers. Basic calculations such as addition, subtraction, multiplication and division are essential tools.
Algebra: This branch is concerned with the study of symbols and rules for manipulating those symbols. It involves solving equations and understanding functions.
Geometry: Focuses on the properties and relationships of points, lines, surfaces, and solids. Key concepts include angle, shape, area, and volume.
Calculus: Explores changes and motions, dealing with derivatives and integration. It is fundamental in physics and engineering.
Statistics and Probability: Involves the analysis and interpretation of data and the likelihood of events occurring.
', 1, N'images/math.jpg', N'Mathematics is a field of study that explores numbers, quantities, ')
INSERT [dbo].[blogs] ([id], [title], [author_id], [created_at], [updated_at], [content], [status], [thumbnail], [briefinfo]) VALUES (20, N'Exploring the Beauty of Mathematics', 5, CAST(N'2020-01-05' AS Date), CAST(N'2020-01-05' AS Date), N'Numbers and Operations: The foundations of mathematics include natural numbers, integers, fractions, decimals and real numbers. Basic calculations such as addition, subtraction, multiplication and division are essential tools.
Algebra: This branch is concerned with the study of symbols and rules for manipulating those symbols. It involves solving equations and understanding functions.
Geometry: Focuses on the properties and relationships of points, lines, surfaces, and solids. Key concepts include angle, shape, area, and volume.
Calculus: Explores changes and motions, dealing with derivatives and integration. It is fundamental in physics and engineering.
Statistics and Probability: Involves the analysis and interpretation of data and the likelihood of events occurring.
', 1, N'images/che.jpg', N'Mathematics is a field of study that explores numbers, quantities, ')
INSERT [dbo].[blogs] ([id], [title], [author_id], [created_at], [updated_at], [content], [status], [thumbnail], [briefinfo]) VALUES (21, N'Unveiling the World of Chemistry: Principles, Branches', 4, CAST(N'2021-08-07' AS Date), CAST(N'2021-08-07' AS Date), N'Numbers and Operations: The foundations of mathematics include natural numbers, integers, fractions, decimals and real numbers. Basic calculations such as addition, subtraction, multiplication and division are essential tools.
Algebra: This branch is concerned with the study of symbols and rules for manipulating those symbols. It involves solving equations and understanding functions.
Geometry: Focuses on the properties and relationships of points, lines, surfaces, and solids. Key concepts include angle, shape, area, and volume.
Calculus: Explores changes and motions, dealing with derivatives and integration. It is fundamental in physics and engineering.
Statistics and Probability: Involves the analysis and interpretation of data and the likelihood of events occurring.
', 1, N'images/che_2.jpg', N'Chemistry is the science of matter, its properties, and the changes it .')
INSERT [dbo].[blogs] ([id], [title], [author_id], [created_at], [updated_at], [content], [status], [thumbnail], [briefinfo]) VALUES (23, N'The Wonders of Biology: Life, Evolution, and Diversity', 8, CAST(N'2022-01-01' AS Date), CAST(N'2022-01-01' AS Date), N'Numbers and Operations: The foundations of mathematics include natural numbers, integers, fractions, decimals and real numbers. Basic calculations such as addition, subtraction, multiplication and division are essential tools.
Algebra: This branch is concerned with the study of symbols and rules for manipulating those symbols. It involves solving equations and understanding functions.
Geometry: Focuses on the properties and relationships of points, lines, surfaces, and solids. Key concepts include angle, shape, area, and volume.
Calculus: Explores changes and motions, dealing with derivatives and integration. It is fundamental in physics and engineering.
Statistics and Probability: Involves the analysis and interpretation of data and the likelihood of events occurring.
', 1, N'images/his.jpg', N'Chemistry is the science of matter, its properties, and the changes it .')
INSERT [dbo].[blogs] ([id], [title], [author_id], [created_at], [updated_at], [content], [status], [thumbnail], [briefinfo]) VALUES (26, N'The Beauty of English: Language, Literature...', 5, CAST(N'2023-04-17' AS Date), CAST(N'2023-04-17' AS Date), N'Numbers and Operations: The foundations of mathematics include natural numbers, integers, fractions, decimals and real numbers. Basic calculations such as addition, subtraction, multiplication and division are essential tools.
Algebra: This branch is concerned with the study of symbols and rules for manipulating those symbols. It involves solving equations and understanding functions.
Geometry: Focuses on the properties and relationships of points, lines, surfaces, and solids. Key concepts include angle, shape, area, and volume.
Calculus: Explores changes and motions, dealing with derivatives and integration. It is fundamental in physics and engineering.
Statistics and Probability: Involves the analysis and interpretation of data and the likelihood of events occurring.
', 1, N'images/eng_2.jpg', N'Chemistry is the science of matter, its properties, and the changes it .')
INSERT [dbo].[blogs] ([id], [title], [author_id], [created_at], [updated_at], [content], [status], [thumbnail], [briefinfo]) VALUES (28, N'Biology research topics on the environment are in great demand too. For example, climate change is becoming a more significant threat every day...', 8, CAST(N'2021-01-21' AS Date), CAST(N'2021-01-21' AS Date), N'Numbers and Operations: The foundations of mathematics include natural numbers, integers, fractions, decimals and real numbers. Basic calculations such as addition, subtraction, multiplication and division are essential tools.
Algebra: This branch is concerned with the study of symbols and rules for manipulating those symbols. It involves solving equations and understanding functions.
Geometry: Focuses on the properties and relationships of points, lines, surfaces, and solids. Key concepts include angle, shape, area, and volume.
Calculus: Explores changes and motions, dealing with derivatives and integration. It is fundamental in physics and engineering.
Statistics and Probability: Involves the analysis and interpretation of data and the likelihood of events occurring.
', 1, N'images/bio_2.jpg', N'History is the study of past events, particularly in human affairs')
INSERT [dbo].[blogs] ([id], [title], [author_id], [created_at], [updated_at], [content], [status], [thumbnail], [briefinfo]) VALUES (29, N'The Wonders of Biology: Life, Evolution, and Diversity', 4, CAST(N'2022-08-20' AS Date), CAST(N'2022-08-20' AS Date), N'Numbers and Operations: The foundations of mathematics include natural numbers, integers, fractions, decimals and real numbers. Basic calculations such as addition, subtraction, multiplication and division are essential tools.
Algebra: This branch is concerned with the study of symbols and rules for manipulating those symbols. It involves solving equations and understanding functions.
Geometry: Focuses on the properties and relationships of points, lines, surfaces, and solids. Key concepts include angle, shape, area, and volume.
Calculus: Explores changes and motions, dealing with derivatives and integration. It is fundamental in physics and engineering.
Statistics and Probability: Involves the analysis and interpretation of data and the likelihood of events occurring.
', 1, N'images/bio.jpg', N'History is the study of past events, particularly in human affairs')
INSERT [dbo].[blogs] ([id], [title], [author_id], [created_at], [updated_at], [content], [status], [thumbnail], [briefinfo]) VALUES (30, N'''The Beauty of English: Language, Literature...', 4, CAST(N'2022-08-20' AS Date), CAST(N'2022-08-20' AS Date), N'Numbers and Operations: The foundations of mathematics include natural numbers, integers, fractions, decimals and real numbers. Basic calculations such as addition, subtraction, multiplication and division are essential tools.
Algebra: This branch is concerned with the study of symbols and rules for manipulating those symbols. It involves solving equations and understanding functions.
Geometry: Focuses on the properties and relationships of points, lines, surfaces, and solids. Key concepts include angle, shape, area, and volume.
Calculus: Explores changes and motions, dealing with derivatives and integration. It is fundamental in physics and engineering.
Statistics and Probability: Involves the analysis and interpretation of data and the likelihood of events occurring.
', 1, N'images/bio.jpg', N'Chemistry is the science of matter, its properties, and the changes it .')
SET IDENTITY_INSERT [dbo].[blogs] OFF
GO
SET IDENTITY_INSERT [dbo].[categories] ON 

INSERT [dbo].[categories] ([id], [name], [created_at], [updated_at], [created_by], [updated_by]) VALUES (8, N'Technology', CAST(N'2024-05-01' AS Date), CAST(N'2024-05-01' AS Date), 3, 3)
INSERT [dbo].[categories] ([id], [name], [created_at], [updated_at], [created_by], [updated_by]) VALUES (9, N'Health', CAST(N'2024-05-02' AS Date), CAST(N'2024-05-02' AS Date), 4, 5)
INSERT [dbo].[categories] ([id], [name], [created_at], [updated_at], [created_by], [updated_by]) VALUES (15, N'Sciences', CAST(N'2024-05-30' AS Date), CAST(N'2024-05-30' AS Date), 5, 4)
INSERT [dbo].[categories] ([id], [name], [created_at], [updated_at], [created_by], [updated_by]) VALUES (16, N'Humanities', CAST(N'2024-05-30' AS Date), CAST(N'2024-05-30' AS Date), 6, 7)
INSERT [dbo].[categories] ([id], [name], [created_at], [updated_at], [created_by], [updated_by]) VALUES (17, N'Language', CAST(N'2024-05-30' AS Date), CAST(N'2024-05-30' AS Date), 7, 6)
INSERT [dbo].[categories] ([id], [name], [created_at], [updated_at], [created_by], [updated_by]) VALUES (23, N'Programming', CAST(N'2024-05-30' AS Date), CAST(N'2024-06-20' AS Date), 8, 8)
SET IDENTITY_INSERT [dbo].[categories] OFF
GO
SET IDENTITY_INSERT [dbo].[package_price] ON 

INSERT [dbo].[package_price] ([id], [name], [duration], [sale_price], [price], [original_price]) VALUES (1, N'3 months package', 3, CAST(800000.00 AS Decimal(18, 2)), CAST(1000000.00 AS Decimal(18, 2)), CAST(800000.00 AS Decimal(18, 2)))
INSERT [dbo].[package_price] ([id], [name], [duration], [sale_price], [price], [original_price]) VALUES (2, N'6 months package', 6, CAST(1000000.00 AS Decimal(18, 2)), CAST(1500000.00 AS Decimal(18, 2)), CAST(1000000.00 AS Decimal(18, 2)))
INSERT [dbo].[package_price] ([id], [name], [duration], [sale_price], [price], [original_price]) VALUES (3, N'Forever package', 1000000000, CAST(1900000.00 AS Decimal(18, 2)), CAST(2200000.00 AS Decimal(18, 2)), CAST(1900000.00 AS Decimal(18, 2)))
SET IDENTITY_INSERT [dbo].[package_price] OFF
GO
SET IDENTITY_INSERT [dbo].[roles] ON 

INSERT [dbo].[roles] ([id], [name]) VALUES (1, N'User')
INSERT [dbo].[roles] ([id], [name]) VALUES (2, N'Admin')
SET IDENTITY_INSERT [dbo].[roles] OFF
GO
SET IDENTITY_INSERT [dbo].[Slider] ON 

INSERT [dbo].[Slider] ([ID], [Title], [SubTitle], [Content], [Image], [LinkUrl], [CreatedAt], [CreatedBy], [Status]) VALUES (1, N'English', N'Learn Enlish ', N'content', N'images/english.jpg', N'http://localhost:8080/QuizPractice/subject/details?id=10', NULL, NULL, NULL)
INSERT [dbo].[Slider] ([ID], [Title], [SubTitle], [Content], [Image], [LinkUrl], [CreatedAt], [CreatedBy], [Status]) VALUES (2, N'History', N'Learn History', N'content', N'images/history.jpg', N'http://localhost:8080/QuizPractice/subject/details?id=9', NULL, NULL, NULL)
INSERT [dbo].[Slider] ([ID], [Title], [SubTitle], [Content], [Image], [LinkUrl], [CreatedAt], [CreatedBy], [Status]) VALUES (3, N'Math', N'Learn Math', N'content', N'images/math.jpg', N'http://localhost:8080/QuizPractice/subject/details?id=2', NULL, NULL, NULL)
INSERT [dbo].[Slider] ([ID], [Title], [SubTitle], [Content], [Image], [LinkUrl], [CreatedAt], [CreatedBy], [Status]) VALUES (4, N'Biology', N'Learn Biology', N'content', N'images/bio.jpg', N'http://localhost:8080/QuizPractice/subject/details?id=8', NULL, NULL, NULL)
INSERT [dbo].[Slider] ([ID], [Title], [SubTitle], [Content], [Image], [LinkUrl], [CreatedAt], [CreatedBy], [Status]) VALUES (5, N'Physics', N'Learn Physics', N'content', N'images/physics.jpeg', N'http://localhost:8080/QuizPractice/subject/details?id=6', NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Slider] OFF
GO
INSERT [dbo].[status] ([id], [name]) VALUES (1, N'Unactive')
INSERT [dbo].[status] ([id], [name]) VALUES (2, N'Active')
INSERT [dbo].[status] ([id], [name]) VALUES (3, N'Block')
GO
INSERT [dbo].[subject_has_price_package] ([subject_id], [price_package_id]) VALUES (2, 1)
INSERT [dbo].[subject_has_price_package] ([subject_id], [price_package_id]) VALUES (2, 2)
INSERT [dbo].[subject_has_price_package] ([subject_id], [price_package_id]) VALUES (2, 3)
INSERT [dbo].[subject_has_price_package] ([subject_id], [price_package_id]) VALUES (6, 1)
INSERT [dbo].[subject_has_price_package] ([subject_id], [price_package_id]) VALUES (6, 3)
INSERT [dbo].[subject_has_price_package] ([subject_id], [price_package_id]) VALUES (7, 1)
INSERT [dbo].[subject_has_price_package] ([subject_id], [price_package_id]) VALUES (7, 2)
INSERT [dbo].[subject_has_price_package] ([subject_id], [price_package_id]) VALUES (8, 1)
INSERT [dbo].[subject_has_price_package] ([subject_id], [price_package_id]) VALUES (8, 3)
INSERT [dbo].[subject_has_price_package] ([subject_id], [price_package_id]) VALUES (9, 3)
INSERT [dbo].[subject_has_price_package] ([subject_id], [price_package_id]) VALUES (10, 1)
INSERT [dbo].[subject_has_price_package] ([subject_id], [price_package_id]) VALUES (14, 1)
INSERT [dbo].[subject_has_price_package] ([subject_id], [price_package_id]) VALUES (14, 2)
INSERT [dbo].[subject_has_price_package] ([subject_id], [price_package_id]) VALUES (14, 3)
INSERT [dbo].[subject_has_price_package] ([subject_id], [price_package_id]) VALUES (15, 1)
INSERT [dbo].[subject_has_price_package] ([subject_id], [price_package_id]) VALUES (15, 2)
INSERT [dbo].[subject_has_price_package] ([subject_id], [price_package_id]) VALUES (15, 3)
GO
INSERT [dbo].[subject_has_tag] ([subject_id], [tag_id]) VALUES (2, 1)
INSERT [dbo].[subject_has_tag] ([subject_id], [tag_id]) VALUES (2, 3)
INSERT [dbo].[subject_has_tag] ([subject_id], [tag_id]) VALUES (2, 4)
INSERT [dbo].[subject_has_tag] ([subject_id], [tag_id]) VALUES (6, 1)
INSERT [dbo].[subject_has_tag] ([subject_id], [tag_id]) VALUES (6, 2)
INSERT [dbo].[subject_has_tag] ([subject_id], [tag_id]) VALUES (6, 5)
INSERT [dbo].[subject_has_tag] ([subject_id], [tag_id]) VALUES (7, 8)
INSERT [dbo].[subject_has_tag] ([subject_id], [tag_id]) VALUES (7, 9)
INSERT [dbo].[subject_has_tag] ([subject_id], [tag_id]) VALUES (8, 12)
INSERT [dbo].[subject_has_tag] ([subject_id], [tag_id]) VALUES (9, 14)
INSERT [dbo].[subject_has_tag] ([subject_id], [tag_id]) VALUES (10, 12)
INSERT [dbo].[subject_has_tag] ([subject_id], [tag_id]) VALUES (14, 13)
INSERT [dbo].[subject_has_tag] ([subject_id], [tag_id]) VALUES (14, 15)
INSERT [dbo].[subject_has_tag] ([subject_id], [tag_id]) VALUES (15, 15)
INSERT [dbo].[subject_has_tag] ([subject_id], [tag_id]) VALUES (15, 16)
GO
SET IDENTITY_INSERT [dbo].[subjects] ON 

INSERT [dbo].[subjects] ([id], [name], [creator_id], [creater_at], [update_at], [status], [img], [description]) VALUES (2, N'PRO192', 4, CAST(N'2024-04-10' AS Date), CAST(N'2024-04-15' AS Date), 1, N'images/pro192.webp', N'This course provides the knowledge and skills of Object Oriented Programming using the Java Programming Language.')
INSERT [dbo].[subjects] ([id], [name], [creator_id], [creater_at], [update_at], [status], [img], [description]) VALUES (6, N'PRJ301', 3, CAST(N'2024-05-25' AS Date), CAST(N'2024-05-25' AS Date), 1, N'images/prj301.webp', N'By the end of this course Students will be able to:
a) Knowledge: (what will students know?)
• Understand the core technologies of Java web programming:
- Servlet and JSP
- Scope of sharing state (session, application, request,page)
- JSP Tags, JSTL, Customtags
- Filtering
• Know how to develop and deploy your own websites using Java
• Understand and be able to apply MVC architecture for the web
b) Skills: (what will students be able to do?)
• Basic Web application development applying MVC Design Pattern using Servlet/Filter as Controller')
INSERT [dbo].[subjects] ([id], [name], [creator_id], [creater_at], [update_at], [status], [img], [description]) VALUES (7, N'DBI202', 4, CAST(N'2024-05-25' AS Date), CAST(N'2024-05-25' AS Date), 1, N'images/dbi202.webp', N'- Knowledge about database systems has become an essential part of an education in computer science because database management has evolved from a specialized computer application to a central component of a modern computing environment.
- The content of this course includes aspects of database management basic concepts, database design, database languages, and database-system implementation. Basing on these contents, the course emphasizes on how to organize, maintain and retrieve efficiently data and information from a DBMS.')
INSERT [dbo].[subjects] ([id], [name], [creator_id], [creater_at], [update_at], [status], [img], [description]) VALUES (8, N'MAE101', 3, CAST(N'2024-05-25' AS Date), CAST(N'2024-05-25' AS Date), 1, N'images/mae101.webp', N'• The basic concepts of single variable calculus: limit, derivative, integral.
• Concepts of linear system of equations, matrix and their applications
• The concepts of vector spaces, basis and dimension, linear transformations and their applications.')
INSERT [dbo].[subjects] ([id], [name], [creator_id], [creater_at], [update_at], [status], [img], [description]) VALUES (9, N'JPD113', 5, CAST(N'2024-05-25' AS Date), CAST(N'2024-05-25' AS Date), 1, N'images/jpd113.jpg', N'Can understand and use familiar expressions used in daily life to meet specific communication needs such as being able to introduce oneself (introducing name, nationality, occupation, interests, etc.). .); can ask for locations, can communicate with staff to ask prices, order food, etc.; Can talk about your daily activities and ask about the working hours of organizations.')
INSERT [dbo].[subjects] ([id], [name], [creator_id], [creater_at], [update_at], [status], [img], [description]) VALUES (10, N'MAS291', 5, CAST(N'2024-05-25' AS Date), CAST(N'2024-05-25' AS Date), 1, N'images/mas291.webp', N'The fundamental principles of probability and their applications')
INSERT [dbo].[subjects] ([id], [name], [creator_id], [creater_at], [update_at], [status], [img], [description]) VALUES (14, N'ENM492c', 3, CAST(N'2024-05-29' AS Date), CAST(N'2024-05-29' AS Date), 1, N'images/english.jpg', N'The skills taught in this Specialization will empower you to succeed in any college-level course or professional field. You’ll learn to conduct rigorous academic research and to express your ideas clearly in an academic format. In the final Capstone Project, all the knowledge that you’ve gained over the span of these courses will culminate into an academic research paper on an issue of your choice.')
INSERT [dbo].[subjects] ([id], [name], [creator_id], [creater_at], [update_at], [status], [img], [description]) VALUES (15, N'MNL111', 5, CAST(N'2024-05-29' AS Date), CAST(N'2024-05-29' AS Date), 1, N'images/mln111.jpg', N'Marxist-Leninist philosophy studies dialectical materialist perspectives on nature, society, and thought, and thereby proves that the materialist worldview becomes comprehensive and radical. Applying and expanding the materialist perspective on social research, Marx introduced the materialist concept of history, pointing out the path to studying the laws of social development, as well as the discovery of natural development. However, there is no need for subjective will, but objective rules make decisions. The birth of Marxist-Leninist Philosophy laid the basis for truly scientific research into history and social life.')
SET IDENTITY_INSERT [dbo].[subjects] OFF
GO
INSERT [dbo].[tags] ([id], [tag]) VALUES (1, N'#java')
INSERT [dbo].[tags] ([id], [tag]) VALUES (2, N'#javaweb')
INSERT [dbo].[tags] ([id], [tag]) VALUES (3, N'#javacore')
INSERT [dbo].[tags] ([id], [tag]) VALUES (4, N'#oop')
INSERT [dbo].[tags] ([id], [tag]) VALUES (5, N'#web')
INSERT [dbo].[tags] ([id], [tag]) VALUES (6, N'#csharp')
INSERT [dbo].[tags] ([id], [tag]) VALUES (7, N'#wpf')
INSERT [dbo].[tags] ([id], [tag]) VALUES (8, N'#database')
INSERT [dbo].[tags] ([id], [tag]) VALUES (9, N'#sqlserver')
INSERT [dbo].[tags] ([id], [tag]) VALUES (10, N'#testing')
INSERT [dbo].[tags] ([id], [tag]) VALUES (11, N'#require')
INSERT [dbo].[tags] ([id], [tag]) VALUES (12, N'#math')
INSERT [dbo].[tags] ([id], [tag]) VALUES (13, N'#english')
INSERT [dbo].[tags] ([id], [tag]) VALUES (14, N'#japanese')
INSERT [dbo].[tags] ([id], [tag]) VALUES (15, N'#softskill')
INSERT [dbo].[tags] ([id], [tag]) VALUES (16, N'#politics')
GO
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([id], [full_name], [email], [phone_number], [gender], [profile_img], [password], [created_at], [updated_at], [role_id], [status_id], [token]) VALUES (3, N'John', N'john.doe@example.com', N'1234567890', 1, N'images/pic-1.jpg', N'password123', CAST(N'2024-05-01' AS Date), CAST(N'2024-05-01' AS Date), 1, 2, N'token123')
INSERT [dbo].[users] ([id], [full_name], [email], [phone_number], [gender], [profile_img], [password], [created_at], [updated_at], [role_id], [status_id], [token]) VALUES (4, N'Jane', N'jane.smith@example.com', N'0987654321', 2, N'images/pic-1.jpg', N'password456', CAST(N'2024-05-02' AS Date), CAST(N'2024-05-02' AS Date), 2, 2, N'token456')
INSERT [dbo].[users] ([id], [full_name], [email], [phone_number], [gender], [profile_img], [password], [created_at], [updated_at], [role_id], [status_id], [token]) VALUES (5, N'John', N'john.doe@example.com', N'1234567890', 1, N'images/pic-1.jpg', N'password123', CAST(N'2024-05-01' AS Date), CAST(N'2024-05-01' AS Date), 1, 2, N'token123')
INSERT [dbo].[users] ([id], [full_name], [email], [phone_number], [gender], [profile_img], [password], [created_at], [updated_at], [role_id], [status_id], [token]) VALUES (6, N'Jane', N'jane.smith@example.com', N'0987654321', 2, N'images/pic-1.jpg', N'password456', CAST(N'2024-05-02' AS Date), CAST(N'2024-05-02' AS Date), 2, 2, N'token456')
INSERT [dbo].[users] ([id], [full_name], [email], [phone_number], [gender], [profile_img], [password], [created_at], [updated_at], [role_id], [status_id], [token]) VALUES (7, N'John', N'john.doe@example.com', N'1234567890', 1, N'images/pic-1.jpg', N'password123', CAST(N'2024-05-01' AS Date), CAST(N'2024-05-01' AS Date), 1, 2, N'token123')
INSERT [dbo].[users] ([id], [full_name], [email], [phone_number], [gender], [profile_img], [password], [created_at], [updated_at], [role_id], [status_id], [token]) VALUES (8, N'Jane', N'jane.smith@example.com', N'0987654321', 2, N'images/pic-1.jpg', N'password456', CAST(N'2024-05-02' AS Date), CAST(N'2024-05-02' AS Date), 2, 2, N'token456')
INSERT [dbo].[users] ([id], [full_name], [email], [phone_number], [gender], [profile_img], [password], [created_at], [updated_at], [role_id], [status_id], [token]) VALUES (22, N'     ', N'NghiNVHE176303@fpt.edu.vn', N'', 1, N'images/pic-1.jpg', N'6361614211bff9a6d7d432cc7c29a15b63f18e519aa846f6262e6771bb3fcf9a35bcece7ad325dc0d84bf6ab2781e37cbfc2bc1c2fcd27e4c8e62beecbf133b0', CAST(N'2024-06-01' AS Date), CAST(N'2024-06-01' AS Date), 1, 2, N'XiHcwx9wvIcOIYZPWTN8RBQB579ErU')
INSERT [dbo].[users] ([id], [full_name], [email], [phone_number], [gender], [profile_img], [password], [created_at], [updated_at], [role_id], [status_id], [token]) VALUES (26, N'Teddy Smith', N'vannghibg03@gmail.com', N'0364920299', 1, N'images/pic-1.jpg', N'6361614211bff9a6d7d432cc7c29a15b63f18e519aa846f6262e6771bb3fcf9a35bcece7ad325dc0d84bf6ab2781e37cbfc2bc1c2fcd27e4c8e62beecbf133b0', CAST(N'2024-06-03' AS Date), CAST(N'2024-06-03' AS Date), 1, 2, N'sv9aVa7bUCCTTMqyBCzE56cOh56a5S')
SET IDENTITY_INSERT [dbo].[users] OFF
GO
ALTER TABLE [dbo].[blogs]  WITH CHECK ADD  CONSTRAINT [FK_blogs_users] FOREIGN KEY([author_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[blogs] CHECK CONSTRAINT [FK_blogs_users]
GO
ALTER TABLE [dbo].[categories]  WITH CHECK ADD  CONSTRAINT [FK_categories_users] FOREIGN KEY([created_by])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[categories] CHECK CONSTRAINT [FK_categories_users]
GO
ALTER TABLE [dbo].[categories]  WITH CHECK ADD  CONSTRAINT [FK_categories_users1] FOREIGN KEY([updated_by])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[categories] CHECK CONSTRAINT [FK_categories_users1]
GO
ALTER TABLE [dbo].[lesson_has_quiz]  WITH CHECK ADD  CONSTRAINT [FK_lesson_has_quiz_lessons] FOREIGN KEY([lesson_id])
REFERENCES [dbo].[lessons] ([id])
GO
ALTER TABLE [dbo].[lesson_has_quiz] CHECK CONSTRAINT [FK_lesson_has_quiz_lessons]
GO
ALTER TABLE [dbo].[lesson_has_quiz]  WITH CHECK ADD  CONSTRAINT [FK_lesson_has_quiz_quizs] FOREIGN KEY([quiz_id])
REFERENCES [dbo].[quizs] ([id])
GO
ALTER TABLE [dbo].[lesson_has_quiz] CHECK CONSTRAINT [FK_lesson_has_quiz_quizs]
GO
ALTER TABLE [dbo].[payments]  WITH CHECK ADD  CONSTRAINT [FK_payments_users] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[payments] CHECK CONSTRAINT [FK_payments_users]
GO
ALTER TABLE [dbo].[question_has_answer]  WITH CHECK ADD  CONSTRAINT [FK_question_has_answer_answers] FOREIGN KEY([answer_id])
REFERENCES [dbo].[answers] ([id])
GO
ALTER TABLE [dbo].[question_has_answer] CHECK CONSTRAINT [FK_question_has_answer_answers]
GO
ALTER TABLE [dbo].[question_has_answer]  WITH CHECK ADD  CONSTRAINT [FK_question_has_answer_questions] FOREIGN KEY([question_id])
REFERENCES [dbo].[questions] ([id])
GO
ALTER TABLE [dbo].[question_has_answer] CHECK CONSTRAINT [FK_question_has_answer_questions]
GO
ALTER TABLE [dbo].[quiz_has_question]  WITH CHECK ADD  CONSTRAINT [FK_quiz_has_question_questions] FOREIGN KEY([question_id])
REFERENCES [dbo].[questions] ([id])
GO
ALTER TABLE [dbo].[quiz_has_question] CHECK CONSTRAINT [FK_quiz_has_question_questions]
GO
ALTER TABLE [dbo].[quiz_has_question]  WITH CHECK ADD  CONSTRAINT [FK_quiz_has_question_quizs] FOREIGN KEY([quiz_id])
REFERENCES [dbo].[quizs] ([id])
GO
ALTER TABLE [dbo].[quiz_has_question] CHECK CONSTRAINT [FK_quiz_has_question_quizs]
GO
ALTER TABLE [dbo].[Slider]  WITH CHECK ADD  CONSTRAINT [FK_CreatedBy] FOREIGN KEY([CreatedBy])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[Slider] CHECK CONSTRAINT [FK_CreatedBy]
GO
ALTER TABLE [dbo].[subject_has_lesson]  WITH CHECK ADD  CONSTRAINT [FK_subject_has_lesson_lessons] FOREIGN KEY([lesson_id])
REFERENCES [dbo].[lessons] ([id])
GO
ALTER TABLE [dbo].[subject_has_lesson] CHECK CONSTRAINT [FK_subject_has_lesson_lessons]
GO
ALTER TABLE [dbo].[subject_has_lesson]  WITH CHECK ADD  CONSTRAINT [FK_subject_has_lesson_subjects] FOREIGN KEY([subject_id])
REFERENCES [dbo].[subjects] ([id])
GO
ALTER TABLE [dbo].[subject_has_lesson] CHECK CONSTRAINT [FK_subject_has_lesson_subjects]
GO
ALTER TABLE [dbo].[subject_has_price_package]  WITH CHECK ADD  CONSTRAINT [FK_subject_has_price_package_package_price] FOREIGN KEY([price_package_id])
REFERENCES [dbo].[package_price] ([id])
GO
ALTER TABLE [dbo].[subject_has_price_package] CHECK CONSTRAINT [FK_subject_has_price_package_package_price]
GO
ALTER TABLE [dbo].[subject_has_price_package]  WITH CHECK ADD  CONSTRAINT [FK_subject_has_price_package_subjects] FOREIGN KEY([subject_id])
REFERENCES [dbo].[subjects] ([id])
GO
ALTER TABLE [dbo].[subject_has_price_package] CHECK CONSTRAINT [FK_subject_has_price_package_subjects]
GO
ALTER TABLE [dbo].[subject_has_tag]  WITH CHECK ADD  CONSTRAINT [FK_subject_has_tag_subjects] FOREIGN KEY([subject_id])
REFERENCES [dbo].[subjects] ([id])
GO
ALTER TABLE [dbo].[subject_has_tag] CHECK CONSTRAINT [FK_subject_has_tag_subjects]
GO
ALTER TABLE [dbo].[subject_has_tag]  WITH CHECK ADD  CONSTRAINT [FK_subject_has_tag_tags] FOREIGN KEY([tag_id])
REFERENCES [dbo].[tags] ([id])
GO
ALTER TABLE [dbo].[subject_has_tag] CHECK CONSTRAINT [FK_subject_has_tag_tags]
GO
ALTER TABLE [dbo].[subjects]  WITH CHECK ADD  CONSTRAINT [fk_user] FOREIGN KEY([creator_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[subjects] CHECK CONSTRAINT [fk_user]
GO
ALTER TABLE [dbo].[user_has_subject]  WITH CHECK ADD  CONSTRAINT [FK_user_has_subject_subjects] FOREIGN KEY([subject_id])
REFERENCES [dbo].[subjects] ([id])
GO
ALTER TABLE [dbo].[user_has_subject] CHECK CONSTRAINT [FK_user_has_subject_subjects]
GO
ALTER TABLE [dbo].[user_has_subject]  WITH CHECK ADD  CONSTRAINT [FK_user_has_subject_users] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[user_has_subject] CHECK CONSTRAINT [FK_user_has_subject_users]
GO
ALTER TABLE [dbo].[users]  WITH CHECK ADD  CONSTRAINT [FK_users_roles] FOREIGN KEY([role_id])
REFERENCES [dbo].[roles] ([id])
GO
ALTER TABLE [dbo].[users] CHECK CONSTRAINT [FK_users_roles]
GO
ALTER TABLE [dbo].[users]  WITH CHECK ADD  CONSTRAINT [FK_users_status] FOREIGN KEY([status_id])
REFERENCES [dbo].[status] ([id])
GO
ALTER TABLE [dbo].[users] CHECK CONSTRAINT [FK_users_status]
GO
USE [master]
GO
ALTER DATABASE [SWP391_G6] SET  READ_WRITE 
GO
