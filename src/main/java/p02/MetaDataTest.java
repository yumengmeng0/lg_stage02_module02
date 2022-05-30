package p02;

import edu.princeton.cs.algs4.ST;
import org.junit.Test;
import utils.DruidUtils;

import java.sql.*;

/**
 * @author: ymm
 * @date: 2022/5/30
 * @version: 1.0.0
 * @description:
 */
public class MetaDataTest {

    public static void main(String[] args) {

    }

    /**
     * 获取数据库元数据
     *
     * @throws SQLException
     */
    @Test
    public void testDatabaseMetaData() throws SQLException {

        Connection connection = connection = DruidUtils.getConnection();

        // 获取数据库元数据
        DatabaseMetaData metaData = connection.getMetaData();

        String url = metaData.getURL();
        System.out.println("url = " + url);

        String userName = metaData.getUserName();
        System.out.println("userName = " + userName);

        String databaseProductName = metaData.getDatabaseProductName();
        System.out.println("databaseProductName = " + databaseProductName);


        DruidUtils.close(connection);
    }

    @Test
    public void testResultSetMetaData() throws SQLException {
        Connection connection = connection = DruidUtils.getConnection();

        String sql = "select * from employee";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        // 获取结果集元数据
        ResultSetMetaData resultSetMetaData = preparedStatement.getMetaData();

        int columnCount = resultSetMetaData.getColumnCount();
        System.out.println("columnCount = " + columnCount);

        String columnName = resultSetMetaData.getColumnName(1);
        System.out.println("columnName = " + columnName);

        DruidUtils.close(connection, preparedStatement, resultSet);

    }


}
