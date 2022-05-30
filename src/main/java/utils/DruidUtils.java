package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author: ymm
 * @date: 2022/5/23
 * @version: 1.0.0
 * @description:
 */
public class DruidUtils {

    // 1.定义成员变量
    private static DataSource dataSource;

    static {
        try {
            // 创建属性集对象
            Properties properties = new Properties();
            // Druid连接池不能够主动加载配置文件，需要指定文件
            InputStream inputStream = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");

            // Properties对象的load方法从字节流中读取配置信息
            properties.load(inputStream);

            // 通过工厂类获取连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }

    /**
     * 获取Druid连接池对象
     *
     * @return
     */
    public static DataSource getDataSource() {
        return dataSource;
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

    public static void close(Connection connection){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
