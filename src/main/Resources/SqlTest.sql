# 创建数据库 默认字符集设置为utf8
# 执行时候防止需要加上--default-character-set=utf8防止乱码
CREATE DATABASE IF NOT EXISTS Student
  CHARACTER SET utf8;

USE Student;

# 禁止外键约束检查 不建议
SET FOREIGN_KEY_CHECKS = 0;

-- 学生信息表
CREATE TABLE IF NOT EXISTS Students (
  #   id
  Stu_id   INT PRIMARY KEY AUTO_INCREMENT,
  #   名称
  name     VARCHAR(50) NOT NULL,
  #   班级
  Class_id INT,
  FOREIGN KEY (Class_id) REFERENCES Classes (Class_id)
);

-- 班级表
CREATE TABLE IF NOT EXISTS Classes (
  #   班级id
  Class_id INT PRIMARY KEY AUTO_INCREMENT,
  #   班级名称
  name     VARCHAR(50) NOT NULL
);

-- 课程表
CREATE TABLE IF NOT EXISTS Courses (
  Course_id INT PRIMARY KEY AUTO_INCREMENT,
  name      VARCHAR(50) NOT NULL
);

-- 选课
CREATE TABLE IF NOT EXISTS SC (
  SC_id     INT PRIMARY KEY AUTO_INCREMENT,
  Stu_id    INT NOT NULL,
  Course_id INT NOT NULL,
  Score     INT NOT NULL,
  FOREIGN KEY (Stu_id) REFERENCES Students (Stu_id),
  FOREIGN KEY (Course_id) REFERENCES Courses (Course_id)
);

-- 插入一些测试用数据

INSERT INTO Students VALUES (1, 'ZY', 1);
INSERT INTO Students VALUES (2, 'WT', 2);
INSERT INTO Students VALUES (3, 'LX', 3);
INSERT INTO Students VALUES (4, 'YY', 3);
INSERT INTO Students VALUES (5, 'WQQ', 1);

INSERT INTO Classes VALUES (1, 'FirstClass');
INSERT INTO Classes VALUES (2, 'SecondClass');
INSERT INTO Classes VALUES (3, 'ThirdClass');

INSERT INTO Courses VALUES (1, '数据结构');
INSERT INTO Courses VALUES (2, '算法');
INSERT INTO Courses VALUES (3, '网络');
INSERT INTO Courses VALUES (4, '计算机组成');

INSERT INTO SC VALUES (1, 1, 1, 100);
INSERT INTO SC VALUES (2, 1, 2, 100);
INSERT INTO SC VALUES (3, 1, 3, 100);
INSERT INTO SC VALUES (4, 1, 4, 100);
INSERT INTO SC VALUES (5, 2, 1, 90);
INSERT INTO SC VALUES (6, 2, 2, 90);
INSERT INTO SC VALUES (7, 2, 3, 90);
INSERT INTO SC VALUES (8, 3, 1, 70);
INSERT INTO SC VALUES (9, 3, 2, 70);
INSERT INTO SC VALUES (10, 4, 1, 60);

# 查询分数最高人姓名
-- select students.*,temp.Course_id from students,
-- (select Stu_id,Course_id from SC group by Course_id)
-- AS temp where students.Stu_id=temp.Stu_id;
