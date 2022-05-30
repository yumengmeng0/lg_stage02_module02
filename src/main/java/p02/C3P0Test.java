package p02;

import utils.C3P0Utils;
import utils.DBCPUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: ymm
 * @date: 2022/5/23
 * @version: 1.0.0
 * @description: C3P0连接池测试
 */
public class C3P0Test {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = C3P0Utils.getConnection();
            String sql = "select * from employee";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String ename = resultSet.getString("ename");
                System.out.println("ename = " + ename);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0Utils.close(connection, preparedStatement, resultSet);
        }

    }
}
