-- 元数据相关的命令介绍
-- 1.查看服务器当前状态
SHOW STATUS;

-- 2.查看MySQl的版本信息
SELECT VERSION();

-- 3.查询表中的详细信息
SHOW COLUMNS FROM employee;

-- 4.显示数据表的详细索引信息
SHOW INDEX FROM employee;

-- 5.列出所有数据库
SHOW DATABASES;

-- 6.显示当前数据库的所有表
SHOW TABLES;

-- 7.获取当前的数据库名
SELECT DATABASE();
