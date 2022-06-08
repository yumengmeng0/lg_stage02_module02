package p03;

import org.dom4j.Document;

import org.dom4j.io.SAXReader;

import java.sql.*;

/**
 * @author: ymm
 * @date: 2022/6/6
 * @version: 1.0.0
 * @description:
 */
public class JDBCUtilsXMLConfig {

    // 1.定义字符串变量，保存连接信息
    public static String DRIVERNAME;
    public static String URL;
    public static String USER;
    public static String PASSWORD;

    // 2.静态代码块
    static {
        // 使用XPath解析xml配置文件
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            document = saxReader.read("E:\\lagou\\lg_stage02_module02\\resources\\jdbc-config.xml");

            DRIVERNAME = document.selectSingleNode("/jdbc/property[@name='driverClass']").getText();
            URL = document.selectSingleNode("/jdbc/property[@name='jdbcUrl']").getText();
            USER = document.selectSingleNode("/jdbc/property[@name='user']").getText();
            PASSWORD = document.selectSingleNode("/jdbc/property[@name='password']").getText();

            Class.forName(DRIVERNAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

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
