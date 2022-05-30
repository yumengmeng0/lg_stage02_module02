package p02;

import org.junit.Test;
import utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author: ymm
 * @date: 2022/5/30
 * @version: 1.0.0
 * @description:
 */
public class BatchTest {

    public static void main(String[] args) {

    }


    /**
     * 使用批处理向表中添加数据
     */
    @Test
    public void testBatchInsert() throws SQLException {
        Connection connection = DruidUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into testBatch(uname) value(?)");

        for (int i = 0; i < 10000; i++) {
            preparedStatement.setString(1, "name = " + i);

            // 将SQL添加到批处理列表
            preparedStatement.addBatch();
        }

        long start = System.currentTimeMillis();

        // 统一执行批量操作
        int[] ints = preparedStatement.executeBatch();
        long end = System.currentTimeMillis();

        System.out.println("批处理耗时 = " + (end - start));
        System.out.println("ints = " + ints);

        for (int i = 0; i < ints.length; i++) {
            System.out.println("ints = " + ints[i]);
        }

        DruidUtils.close(connection, preparedStatement);
    }
}
