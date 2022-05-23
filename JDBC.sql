DROP DATABASE IF EXISTS jdbc;
CREATE DATABASE jdbc CHARACTER SET utf8;
USE jdbc;

-- 创建 jdbc_user表
 CREATE TABLE jdbc_user (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR (50),
  PASSWORD VARCHAR (50),
  birthday DATE
);

-- 添加数据
INSERT INTO jdbc_user (username, PASSWORD,birthday)
VALUES('admin1', '123','1991/12/24'),
('admin2','123','1995/12/24'),
('test1', '123','1998/12/24'),
('test2', '123','2000/12/24');


SELECT DATABASE();



# sql注入
# 插入2条数据
INSERT INTO jdbc_user VALUES(NULL,'jack','123456','2020/2/24');
INSERT INTO jdbc_user VALUES(NULL,'tom','123456','2020/2/24');


# 查询用户
SELECT * FROM jdbc_user WHERE  username = 'jack' AND PASSWORD = '123456';

# 查询用户
SELECT * FROM jdbc_user WHERE  username = 'jack' AND PASSWORD = '1' OR 1=1;



### JDBC事务控制
 -- 创建账户表
 CREATE TABLE account (
  -- 主键
   id INT PRIMARY KEY AUTO_INCREMENT,
  -- 姓名
   NAME VARCHAR (10),
  -- 转账金额
   money DOUBLE
);

-- 添加两个用户
INSERT INTO account (NAME, money) VALUES ('tom', 1000), ('jack', 1000);


