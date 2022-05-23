package p01;

import java.sql.*;

/**
 * @author: ymm
 * @date: 2022/5/20
 * @version: 1.0.0
 * @description:
 */
public class QueryTest {

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 1.注册驱动（可省略）
            Class<?> driver = Class.forName("com.mysql.jdbc.Driver");

            // 2.获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");

            // 3.获取语句执行对象Statement
             statement = connection.createStatement();

            // 3.1查询操作
            String sql = "select * from jdbc_user;";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                System.out.println("id = " + id);
                int id1 = resultSet.getInt("id");
                System.out.println("id1 = " + id1);

                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                Date birthday = resultSet.getDate("birthday");

                System.out.println("id1 = " + id1);
                System.out.println("username = " + username);
                System.out.println("password = " + password);
                System.out.println("birthday = " + birthday);


            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭流

            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement !=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
