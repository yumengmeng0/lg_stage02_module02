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


## 三、XML