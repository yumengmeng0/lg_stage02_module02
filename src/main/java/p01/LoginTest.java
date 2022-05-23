package p01;

import utils.JDBCUtils;

import java.sql.*;

/**
 * @author: ymm
 * @date: 2022/5/22
 * @version: 1.0.0
 * @description:
 */
public class LoginTest {

    /**
     * 用户登录
     *
     * @param args
     */
    public static void main(String[] args) {
        String username = "jack";
        String password = "123456";

        Connection connection = JDBCUtils.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 拼接sql
        String sql = "select * from jdbc_user where username = '" + username + "' and password = '" + password + "';";
        System.out.println("sql = " + sql);

        try {
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                System.out.println("登录成功");
            } else {
                System.out.println("登录失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        JDBCUtils.close(connection, statement, resultSet);
    }

}
