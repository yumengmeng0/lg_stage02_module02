package utils;

import org.apache.commons.dbcp.BasicDataSource;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: ymm
 * @date: 2022/5/23
 * @version: 1.0.0
 * @description: DBCP连接池工具类
 */
public class DBCPUtils {

    // 1.将连接信息定义为字符串常量
    public static final String DRIVERNAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/db5?characterEncoding=UTF-8";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123456";

    // 2.创建连接池对象（由DBCP提供实现类）
    public static BasicDataSource dataSource = new BasicDataSource();

    // 3.使用静态代码块进行配置
    static {
        dataSource.setDriverClassName(DRIVERNAME);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
    }

    // 4.获取连接方法
    public static Connection getConnection() throws SQLException {
        // 从连接池中获取
        Connection connection = dataSource.getConnection();
        return connection;
    }

    // 5.释放资源
    public static void close(Connection connection, Statement statement) {

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        close(connection, statement);
    }
}
