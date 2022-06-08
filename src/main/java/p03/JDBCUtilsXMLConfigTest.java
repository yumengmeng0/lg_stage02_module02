package p03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: ymm
 * @date: 2022/6/6
 * @version: 1.0.0
 * @description:
 */
public class JDBCUtilsXMLConfigTest {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtilsXMLConfig.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from employee");

            while (resultSet.next()){
                String ename = resultSet.getString("ename");
                System.out.println("员工姓名：" + ename);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtilsXMLConfig.close(connection, statement, resultSet);
        }


    }
}
