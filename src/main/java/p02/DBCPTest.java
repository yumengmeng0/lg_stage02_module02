package p02;

import utils.DBCPUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: ymm
 * @date: 2022/5/23
 * @version: 1.0.0
 * @description: 测试DBCP连接池
 */
public class DBCPTest {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBCPUtils.getConnection();
            String sql = "select * from employee";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String ename = resultSet.getString("ename");
                System.out.println("ename = " + ename);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBCPUtils.close(connection, preparedStatement, resultSet);
        }


    }
}
