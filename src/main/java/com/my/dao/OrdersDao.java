package com.my.dao;

import com.my.entity.OrderItem;
import com.my.entity.Orders;
import com.my.entity.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DruidUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: ymm
 * @date: 2022/6/7
 * @version: 1.0.0
 * @description:
 */
public class OrdersDao {

    /**
     * 根据uid查询用户的所有订单
     *
     * @param uid
     * @return
     * @throws SQLException
     */
    public List<Orders> findAllOrders(String uid) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

        String sql = "select * from orders where uid = ?";
        List<Orders> ordersList = queryRunner.query(sql, new BeanListHandler<>(Orders.class), uid);

        return ordersList;
    }

    /**
     * 根据订单编号查询商品信息
     *
     * @param oid
     * @return
     * @throws SQLException
     */
    public List<Product> findProductsByOid(String oid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        // 根据订单项订单id查询商品id
        String sql = "select pid from orderitem where oid = ?";

        List<OrderItem> orderItemList = queryRunner.query(sql, new BeanListHandler<>(OrderItem.class), oid);


        ArrayList<Product> productList = new ArrayList<>();

        for (OrderItem orderItem : orderItemList) {
            String pid = orderItem.getPid();
            ProductDao productDao = new ProductDao();
            Product product = productDao.findProductById(pid);
            productList.add(product);
        }

        return productList;
    }
}
