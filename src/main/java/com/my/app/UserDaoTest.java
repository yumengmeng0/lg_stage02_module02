package com.my.app;

import com.my.dao.UserDao;
import com.my.entity.User;
import com.my.utils.UUIDUtils;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @author: ymm
 * @date: 2022/6/6
 * @version: 1.0.0
 * @description:
 */
public class UserDaoTest {
    UserDao userDao = new UserDao();

    @Test
    public void testRegister() throws SQLException {
        User user = new User();
        user.setUid(UUIDUtils.getUUID());
        user.setUsername("张三");
        user.setPassword("123456");
        user.setSex("男");
        user.setBirthday("1992/5/20");
        user.setTelephone("13000000000");
        int register = userDao.register(user);
        System.out.println("register = " + register);
        if (register > 0) {
            System.out.println("注册成功");
        } else {
            System.out.println("注册失败");
        }
    }


    @Test
    public void testLogin() throws SQLException {
        User user = userDao.login("张三", "12456");

        if (user != null) {
            System.out.println("user = " + user);
        } else {
            System.out.println("登录失败");
        }

    }
}
