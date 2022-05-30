package p02.dbutilstest;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;
import p02.entity.Employee;
import utils.DBCPUtils;
import utils.DruidUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author: ymm
 * @date: 2022/5/24
 * @version: 1.0.0
 * @description: 使用QueryRunner对象，完成增删改
 */
public class DBUtilsTest02 {

    @Test
    public void testInsert() throws SQLException {
        // 1.方式1：手动模式

        QueryRunner queryRunner = new QueryRunner();

        String sql = "insert into employee values (?,?,?,?,?,?)";

        Object[] param = {null, "张三", 21, "男", 10000, "1990-12-12"};

        Connection connection = DruidUtils.getConnection();
        queryRunner.update(connection, sql, param);


        DbUtils.close(connection);
    }


    @Test
    public void testUpdate() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

        String sql = "update employee set salary = ? where ename = ?";
        Object[] param = {8888, "张三"};
        Connection connection = DruidUtils.getConnection();

        queryRunner.update(connection, sql, param);

        DbUtils.close(connection);
    }

    @Test
    public void testDelete() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();

        String sql = "delete from employee where eid = ?";

//        Object[] param = {1};

        Connection connection = DruidUtils.getConnection();

        queryRunner.update(connection, sql, 8);

        DbUtils.close(connection);
    }


    @Test
    public void testQuery() {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from employee";
    }


    /**
     * ResultHandler测试
     */

    /**
     * ArrayHandler
     * <p>
     * [7, 张三, 21, 男, 8888.0, 1990-12-12]
     *
     * @throws SQLException
     */
    @Test
    public void findById() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from employee where eid = ?";
        Object[] query = queryRunner.query(sql, new ArrayHandler(), 7);
        System.out.println("query = " + Arrays.toString(query));
    }

    /**
     * ArrayListHandler
     * <p>
     * [2, 林黛玉, 20, 女, 5000.0, 2019-03-14]
     * [3, 杜甫, 40, 男, 6000.0, 2020-01-01]
     * [4, 李白, 25, 男, 3000.0, 2017-10-01]
     * [7, 张三, 21, 男, 8888.0, 1990-12-12]
     *
     * @throws SQLException
     */

    @Test
    public void findAll() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from employee";
        List<Object[]> query = queryRunner.query(sql, new ArrayListHandler());
        for (Object[] objects : query) {
            System.out.println(Arrays.toString(objects));

        }
    }


    /**
     * BeanHandler
     * Employee{eid=7, ename='张三', age=21, sex='男', salary=8888.0, empdate=1990-12-12}
     *
     * @throws SQLException
     */
    @Test
    public void beanHandler() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from employee where eid = ?";
        Object query = queryRunner.query(sql, new BeanHandler<>(Employee.class), 7);
        System.out.println(query);
    }

    /**
     * BeanListHandler
     * <p>
     * Employee{eid=2, ename='林黛玉', age=20, sex='女', salary=5000.0, empdate=2019-03-14}
     * Employee{eid=3, ename='杜甫', age=40, sex='男', salary=6000.0, empdate=2020-01-01}
     * Employee{eid=4, ename='李白', age=25, sex='男', salary=3000.0, empdate=2017-10-01}
     * Employee{eid=7, ename='张三', age=21, sex='男', salary=8888.0, empdate=1990-12-12}
     *
     * @throws SQLException
     */
    @Test
    public void beanListHandler() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from employee";
        List<Employee> query = queryRunner.query(sql, new BeanListHandler<>(Employee.class));
        for (Employee employee : query) {
            System.out.println(employee);
        }
    }


    /**
     * MapHandler
     * <p>
     * <p>
     * {eid=7, ename=张三, age=21, sex=男, salary=8888.0, empdate=1990-12-12}
     *
     * @throws SQLException
     */
    @Test
    public void mapHandler() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from employee where ename = ?";

        Map<String, Object> emp = queryRunner.query(sql, new MapHandler(), "张三");

        System.out.println(emp);

    }

    /**
     * ScalarHandler
     *
     * @throws SQLException
     */
    @Test
    public void scalarHandler() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select count(*) from employee";
        Object query = queryRunner.query(sql, new ScalarHandler<>());
        System.out.println("query = " + query);
    }

}
