/*
	连接池
	
*/

#创建数据库
DROP DATABASE IF EXISTS db5 ;
CREATE DATABASE db5 CHARACTER SET utf8;

#使用数据库
USE db5;

#创建员工表
 CREATE TABLE employee (
  eid INT PRIMARY KEY AUTO_INCREMENT,
  ename VARCHAR (20),
  -- 员工姓名
   age INT,
  -- 员工年龄
   sex VARCHAR (6),
  -- 员工性别
   salary DOUBLE,
  -- 薪水
   empdate DATE-- 入职日期
);

#插入数据
INSERT INTO employee (eid, ename, age, sex, salary, empdate) VALUES(NULL,'李清照',22,'女',4000,'2018-11-12');
INSERT INTO employee (eid, ename, age, sex, salary, empdate) VALUES(NULL,'林黛玉',20,'女',5000,'2019-03-14');
INSERT INTO employee (eid, ename, age, sex, salary, empdate) VALUES(NULL,'杜甫',40,'男',6000,'2020-01-01');
INSERT INTO employee (eid, ename, age, sex, salary, empdate) VALUES(NULL,'李白',25,'男',3000,'2017-10-01');