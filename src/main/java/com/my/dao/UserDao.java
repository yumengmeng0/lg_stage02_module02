package com.my.dao;

import com.my.entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DruidUtils;

import java.sql.SQLException;

/**
 * @author: ymm
 * @date: 2022/6/6
 * @version: 1.0.0
 * @description:
 */
public class UserDao {

    // 需求1：编写一个注册用户的方法，接收的参数是一个User对象

    /**
     * 注册
     *
     * @param user
     * @return
     */
    public int register(User user) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "insert into user values (?,?,?,?,?,?)";
        Object[] param = {
                user.getUid(),
                user.getUsername(),
                user.getPassword(),
                user.getTelephone(),
                user.getBirthday(),
                user.getSex()
        };

        int update = queryRunner.update(sql, param);
        return update;
    }

    // 需求2：编写一个用户登录方法，接收参数是用户名，密码返回值是用户对

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());


        String sql = "select * from user where username = ? and password = ?";

        Object[] param = {
                username, password
        };

        User user = queryRunner.query(sql, new BeanHandler<>(User.class), param);

        return user;
    }

}
