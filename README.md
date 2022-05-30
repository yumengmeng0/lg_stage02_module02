# lg_stage02_module02
JDBC & XML

## 一、JDBC（Java Database Connectivity） 
*  JDBC是访问数据库标准规范（接口）。

### 1.1 SQL注入
* 使用预处理对象PreparedStatement解决sql注入问题。

### 1.2 PreparedStatement与Statement
* Statement对象每执行一条SQL语句，就会发给数据库，数据库要先编译再执行。
* PreparedStatement将SQL发给数据库进行一个预编译，然后将预编译的SQL保存起来，
这样只需要编译一次。
* 多次操作只需设置参数。

### 1.3 事务API（Connection）
| 方法 | 说明 |
| --- | --- |
| void setAutoCommit(boolean autoCommit) | 参数是 true 或 false 如果设置为 false，表示关闭自动提交，相当于开启事务 |
| void commit() | 提交事务 |
| void rollback() | 回滚事务 |


## 二、数据库连接池和DBUtils
### 2.1 连接池
* 连接池管理数据库连接，可以重复使用连接，关闭连接，不代表销毁Connection，只是将连接进行归还。

#### 2.1.1 使用连接池
* Java为数据库连接池提供了公共接口：java.sql.DataSource，各个厂商需要让自己的连接池实现这个接口。
* 常见的连接池：DBCP连接池、C3P0连接池、Druid连接池

##### 2.1.2 DBCP连接池
* 常见配置项

| 属性 | 描述 |
| --- | --- |
| driverClassName | 数据库驱动名称 |
| url | 数据库地址 |
| username | 用户名 |
| password | 密码 |
| maxActive | 最大连接数量 |
| maxIdle | 最大空闲连接 |
| minIdle | 最小空闲连接 |
| initialSize | 初始化连接 |


#### 2.1.3 C3P0连接池

#### 2.1.4 Druid连接池


### 2.2 DbUtils工具类
#### 2.2.1 Dbutils核心功能介绍
    1. QueryRunner 中提供对sql语句操作的API.
    2. ResultSetHandler接口，用于定义select操作后，怎样封装结果集.
    3. DbUtils类,他就是一个工具类,定义了关闭资源与事务处理相关方法.

#### 2.2.2 表和类之间的关系
* 可以将一张表看作一个类
* 一条数据对应一个对象

### 2.3 JavaBean组件
    1. 需要实现序列化接口（Serializable）
    2. 提供私有字段
    3. 提供getter和setter
    4. 提供空参构造 
    
### 2.4 DBUtils增删改查操作

### 2.5 ResultHandler

### 2.6 批处理
####  2.6.1 批处理
* 批处理指的是一次操作中执行多条SQL语句。

#### 2.6.2 实现批处理
* Statement和PreparedStatement都支持批处理

| 方法 | 说明 |
| --- | --- |
| void addBatch() | 将给定的SQL命令添加到此Statement对象的当前命令列表中。通过调用方法executeBatch可以批量执行此列表中的命令。 |
| int[] executeBatch() | 每次提交一批命令到数据库中执行，如果所有的命令都成功执行了，那么返回一个数组，这个数组是说明每条命令所影响的行数 |

### 2.7 MySql元数据

#### 2.7.1 什么是元数据
* 除了表之外的数据都是元数据。可分为3类：
    1. 查询结果信息：UPDATE或DELETE语句受影响的记录数
    2. 数据库和数据表的信息：包含数据库及数据表的结构信息
    3. MySQL服务器信息：包含服务器当前的状态，版本号等


## 三、XML