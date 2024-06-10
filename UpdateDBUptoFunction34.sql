


-----------------------12
Drop table Subject_Register;

CREATE TABLE Subject_Register (
    Id INT PRIMARY KEY IDENTITY(1,1),            -- Khóa chính tự tăng
    SubjectId INT NOT NULL,                      -- Khóa ngoại SubjectId
    UserId INT NOT NULL,                         -- Khóa ngoại UserId
    PackageId INT NOT NULL,                      -- Khóa ngoại PackageId
    CreatedAt DATETIME DEFAULT GETDATE(),        -- Ngày tạo, mặc định là ngày hiện tại
    UpdatedAt DATETIME DEFAULT GETDATE(),        -- Ngày cập nhật, mặc định là ngày hiện tại
    UpdatedBy INT,                     -- Người cập nhật
    Status NVARCHAR(50) NOT NULL,                -- Trạng thái
    FOREIGN KEY (SubjectId) REFERENCES subjects(id),        -- Khóa ngoại tham chiếu đến bảng subjects
    FOREIGN KEY (UserId) REFERENCES users(id),              -- Khóa ngoại tham chiếu đến bảng Users
    FOREIGN KEY (PackageId) REFERENCES package_price(id) ,   -- Khóa ngoại tham chiếu đến bảng package_price
	FOREIGN KEY (UpdatedBy) REFERENCES users(id), 
);



----------------14
CREATE TABLE Practices (
    Id INT PRIMARY KEY IDENTITY(1,1),          -- Khóa chính tự tăng
    UserId INT NOT NULL,                       -- Khóa ngoại UserId
    SubjectId INT NOT NULL,                    -- Khóa ngoại SubjectId
    LessonName NVARCHAR(255),         -- Tên bài học
    NumberQuestion INT NULL,               -- Số câu hỏi
    CreatedAt DATETIME DEFAULT GETDATE(),      -- Ngày tạo, mặc định là ngày hiện tại
    NumberCorrect INT NULL,                -- Số câu trả lời đúng
    Duration INT NULL,                     -- Thời gian làm bài
    FOREIGN KEY (UserId) REFERENCES users(id),             -- Khóa ngoại tham chiếu đến bảng Users
    FOREIGN KEY (SubjectId) REFERENCES subjects(id)        -- Khóa ngoại tham chiếu đến bảng Subjects
);



CREATE TABLE Practice_Question (
    Id INT PRIMARY KEY IDENTITY(1,1),         -- Khóa chính tự tăng
    PracticeId INT NOT NULL,                  -- Khóa ngoại PracticeId
    QuestionId INT NOT NULL,                  -- Khóa ngoại QuestionId
    YourAnswer INT,                           -- Khóa ngoại YourAnswer
    FOREIGN KEY (PracticeId) REFERENCES Practices(Id),   -- Tham chiếu khóa ngoại đến bảng Practices
    FOREIGN KEY (QuestionId) REFERENCES questions(Id),   -- Tham chiếu khóa ngoại đến bảng questions
    FOREIGN KEY (YourAnswer) REFERENCES answers(Id)      -- Tham chiếu khóa ngoại đến bảng answers
);



-----------15
drop table lesson_has_quiz;

CREATE TABLE Lesson_Has_Question (
    Id INT PRIMARY KEY IDENTITY(1,1),               -- Khóa chính tự tăng
    LessonId INT NOT NULL,                          -- Khóa ngoại LessonId
    QuestionId INT NOT NULL,                        -- Khóa ngoại QuestionId
    FOREIGN KEY (LessonId) REFERENCES lessons(id),  -- Tham chiếu khóa ngoại đến bảng Lessons
    FOREIGN KEY (QuestionId) REFERENCES questions(id) -- Tham chiếu khóa ngoại đến bảng Questions
);


Drop table quiz_has_question;
Drop table quizs;
CREATE TABLE Quizs (
    Id INT PRIMARY KEY IDENTITY(1,1),    -- Khóa chính tự tăng
    Name NVARCHAR(255) NOT NULL,         -- Tên của quiz
    Level NVARCHAR(50) ,         -- Mức độ của quiz
    NumberQuestion INT ,         -- Số câu hỏi
    Duration INT ,               -- Thời lượng (phút)
    Type NVARCHAR(50) ,          -- Loại quiz
    CreatedAt DATETIME DEFAULT GETDATE(),-- Ngày tạo, mặc định là ngày hiện tại
    CreatedBy INT ,              -- Người tạo
    UpdatedAt DATETIME DEFAULT GETDATE(),-- Ngày cập nhật, mặc định là ngày hiện tại
    UpdatedBy INT   ,        -- Người cập nhật
	 FOREIGN KEY (CreatedBy) REFERENCES users(id),
	 FOREIGN KEY (UpdatedBy) REFERENCES users(id)
);

CREATE TABLE Quiz_Has_Question (
    Id INT PRIMARY KEY IDENTITY(1,1),               -- Khóa chính tự tăng
    QuizId INT NOT NULL,                            -- Khóa ngoại QuizId
    QuestionId INT NOT NULL,                        -- Khóa ngoại QuestionId
    FOREIGN KEY (QuizId) REFERENCES Quizs(Id),      -- Tham chiếu khóa ngoại đến bảng Quizs
    FOREIGN KEY (QuestionId) REFERENCES Questions(Id) -- Tham chiếu khóa ngoại đến bảng Questions
);

CREATE TABLE Subject_Has_Quiz (
    Id INT PRIMARY KEY IDENTITY(1,1),               -- Khóa chính tự tăng
    SubjectId INT NOT NULL,                         -- Khóa ngoại SubjectId
    QuizId INT NOT NULL,                            -- Khóa ngoại QuizId
    FOREIGN KEY (SubjectId) REFERENCES Subjects(Id), -- Tham chiếu khóa ngoại đến bảng Subjects
    FOREIGN KEY (QuizId) REFERENCES Quizs(Id)        -- Tham chiếu khóa ngoại đến bảng Quizs
);

----------------------16
CREATE TABLE User_Quiz (
    Id INT PRIMARY KEY IDENTITY(1,1),           -- Khóa chính tự tăng
    UserId INT NOT NULL,                         -- Khóa ngoại UserId
    QuizId INT NOT NULL,                         -- Khóa ngoại QuizId
    NumberCorrect INT ,                  -- Số câu trả lời đúng
    CreatedAt DATETIME DEFAULT GETDATE(),        -- Ngày tạo, mặc định là ngày hiện tại
    FOREIGN KEY (UserId) REFERENCES Users(Id),   -- Tham chiếu khóa ngoại đến bảng Users
    FOREIGN KEY (QuizId) REFERENCES Quizs(Id)    -- Tham chiếu khóa ngoại đến bảng Quizs
);

CREATE TABLE User_Quiz_Answer (
    Id INT PRIMARY KEY IDENTITY(1,1),              -- Khóa chính tự tăng
    User_Quiz_Id INT NOT NULL,                     -- Khóa ngoại User_Quiz_Id
    QuestionId INT NOT NULL,                       -- Khóa ngoại QuestionId
    YourAnswer INT,                                -- Khóa ngoại YourAnswer
    FOREIGN KEY (User_Quiz_Id) REFERENCES User_Quiz(Id),  -- Tham chiếu khóa ngoại đến bảng User_Quiz
    FOREIGN KEY (QuestionId) REFERENCES Questions(Id),    -- Tham chiếu khóa ngoại đến bảng Questions
    FOREIGN KEY (YourAnswer) REFERENCES Answers(Id)       -- Tham chiếu khóa ngoại đến bảng Answers
);



--------------------17
ALTER TABLE lessons
ADD LessonIndex INT;


ALTER TABLE questions
ADD Suggestion NVARCHAR(MAX);


-------------20
ALTER TABLE blogs
ADD CategoryId INT;

ALTER TABLE blogs
ADD CONSTRAINT FK_blog_Categories FOREIGN KEY (CategoryId) REFERENCES categories(id);



----------------------------26
CREATE TABLE Dimension (
    DimensionId INT PRIMARY KEY IDENTITY(1,1),  -- Khóa chính tự tăng
    DimensionName NVARCHAR(MAX),               -- Tên của dimension
    Type NVARCHAR(255),                         -- Loại của dimension
    Description NVARCHAR(MAX)                   -- Mô tả của dimension
);


--------------------------28
ALTER TABLE lessons
ADD Type NVARCHAR(255);


----------------------31
ALTER TABLE questions
ADD Status INT,
    Media NVARCHAR(MAX);


----------------thêm
ALTER TABLE Subjects
ADD  dimensionId INT;

ALTER TABLE Subjects
ADD CONSTRAINT FK_Subjects_Dimension FOREIGN KEY (dimensionId) REFERENCES Dimension(DimensionID);