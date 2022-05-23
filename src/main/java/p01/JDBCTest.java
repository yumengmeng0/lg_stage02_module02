package p01;

import java.sql.*;

/**
 * @author: ymm
 * @date: 2022/5/20
 * @version: 1.0.0
 * @description:
 */
public class JDBCTest {

    public static void main(String[] args) {
        try {
            // 1.注册驱动（可省略）
            Class<?> driver = Class.forName("com.mysql.jdbc.Driver");

            // 2.获取连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");

            // 3.获取语句执行对象Statement
            Statement statement = connection.createStatement();

            // 3.1创建一张表

            String sql = "create table test(id int, name varchar(20), age int);";
            int i = statement.executeUpdate(sql);
            System.out.println("i = " + i);


            // 关闭流
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
