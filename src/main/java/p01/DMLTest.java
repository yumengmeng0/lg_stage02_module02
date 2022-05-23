package p01;

import org.junit.Test;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: ymm
 * @date: 2022/5/22
 * @version: 1.0.0
 * @description:
 */
public class DMLTest {

    /**
     * 插入数据
     */
    @Test
    public void testInsert() throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        Statement statement = connection.createStatement();
        String sql = "insert into jdbc_user values(null,'张三','123','2022/5/22')";

        int i = statement.executeUpdate(sql);
        System.out.println("i = " + i);

        JDBCUtils.close(connection,statement);
    }

    @Test
    public void testUpdate() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        Statement statement = connection.createStatement();
        String sql = "update jdbc_user set username = '李四' where id = 1";
        int i = statement.executeUpdate(sql);
        System.out.println("i = " + i);
        JDBCUtils.close(connection, statement);
    }

    @Test
    public void testDelete() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        Statement statement = connection.createStatement();
        String sql = "delete from jdbc_user where username = '张三'";
        int i = statement.executeUpdate(sql);
        System.out.println("i = " + i);
        JDBCUtils.close(connection,statement);
    }

    @Test
    public void testQuery() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        Statement statement = connection.createStatement();
        String sql ="select * from jdbc_user where id = 3";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            System.out.println("id  = " + id + ",username = " + username);
        }

        JDBCUtils.close(connection,statement,resultSet);
    }

}
