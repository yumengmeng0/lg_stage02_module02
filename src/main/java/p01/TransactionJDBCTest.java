package p01;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author: ymm
 * @date: 2022/5/23
 * @version: 1.0.0
 * @description:
 */
public class TransactionJDBCTest {

    // 使用JDBC操作事务
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 1.获取连接
            connection = JDBCUtils.getConnection();

            // 2.开启事务
            connection.setAutoCommit(false); // 手动提交事务
            // 3.获取预处理对象，执行SQL（两次修改）
            String sql = "update account set money = money - ? where name = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, 500);
            preparedStatement.setString(2, "tom");
            preparedStatement.executeUpdate();

            // 模拟转账过程中出现异常
            System.out.println(1 / 0);

            sql = "update account set money = money + ? where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, 500);
            preparedStatement.setString(2, "jack");
            preparedStatement.executeUpdate();

            // 4.提交事务
            connection.commit();
            System.out.println("转账成功");

        } catch (Exception e) {

            // 5.出现异常就回滚事务
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            System.out.println("转账失败"); // 出现异常并没有执行
        } finally {
            // 6.释放资源
            JDBCUtils.close(connection, preparedStatement);
        }

    }

}
