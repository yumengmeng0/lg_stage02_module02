package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: ymm
 * @date: 2022/5/23
 * @version: 1.0.0
 * @description: C3P0连接池配置
 */
public class C3P0Utils {


    // 1.创建连接池对象
    // 使用自定义配置
    public static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql"); // c3p0-config.xml文件中的配置

    // 2.获取连接
    public static Connection getConnection() throws SQLException {
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
