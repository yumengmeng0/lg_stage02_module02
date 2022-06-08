package com.my.app;

import com.my.dao.OrdersDao;
import com.my.entity.Orders;
import com.my.entity.Product;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: ymm
 * @date: 2022/6/7
 * @version: 1.0.0
 * @description:
 */
public class OrdersDaoTest {

    public OrdersDao ordersDao = new OrdersDao();

    @Test
    public void testOrdersDao() throws SQLException {
        List<Orders> allOrders = ordersDao.findAllOrders("001");
        for (Orders allOrder : allOrders) {
            System.out.println("allOrder = " + allOrder);
        }
    }

    @Test
    public void testFindProductsByOid() throws SQLException {
        List<Product> productList = ordersDao.findProductsByOid("order001");

        for (Product product : productList) {
            System.out.println("product = " + product);
        }
    }

}
