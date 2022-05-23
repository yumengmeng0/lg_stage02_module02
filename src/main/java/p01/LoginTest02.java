package p01;

import utils.JDBCUtils;

import java.sql.*;

/**
 * @author: ymm
 * @date: 2022/5/22
 * @version: 1.0.0
 * @description:
 */
public class LoginTest02 {

    /**
     * 用户登录（解决sql注入）
     * <p>
     * 不能让用户输入的数据和我们的sql直接进行拼接
     * <p>
     * 使用预处理对象PreparedStatement（Statement对象子接口）
     * 1.它有预编译功能，提高SQL执行效率
     * 2.通过占位符的方式设置参数，防止sql注入
     *
     * @param args
     */
    public static void main(String[] args) {
        String username = "jack";
        String password = "123456";

        Connection connection = JDBCUtils.getConnection();

        ResultSet resultSet = null;
        PreparedStatement statement = null;

        // 拼接sql，使用 ? 占位符设置参数
        String sql = "select * from jdbc_user where username = ? and password = ?";

        try {

            // 获取预处理对象
            statement = connection.prepareStatement(sql); // 加入参数ssql

            // 设置参数
            statement.setString(1, username);
            statement.setString(2, password);

            resultSet = statement.executeQuery(); // 这里不需要参数

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
