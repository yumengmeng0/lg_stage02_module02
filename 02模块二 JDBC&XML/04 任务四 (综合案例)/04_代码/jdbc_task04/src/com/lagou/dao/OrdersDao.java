package com.lagou.dao;

import com.lagou.entity.OrderItem;
import com.lagou.entity.Orders;
import com.lagou.entity.Product;
import com.lagou.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersDao {

    //需求1: 获取 uid为 001 的用户的所有订单信息
    public List<Orders>  findAllOrders(String uid) throws SQLException {

        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        String sql = "select * from orders where uid = ?";

        //一个用户所有的订单信息
        List<Orders> ordersList = qr.query(sql, new BeanListHandler<Orders>(Orders.class), uid);

        return ordersList;
    }

    //需求2: 获取订单编号为 order001的订单中的所有商品信息
    public List<Product> findOrderById(String oid) throws SQLException {

        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        //1.查询订单项表 获取订单项表中 订单ID为order001的数据
        String sql = "SELECT pid FROM orderitem WHERE oid = ? ";

        //2.查询的结果是 多条订单项数据
        List<OrderItem> list = qr.query(sql, new BeanListHandler<OrderItem>(OrderItem.class), oid);

        //3.创建集合保存商品信息
        List<Product> productList = new ArrayList<>();

        ProductDao productDao = new ProductDao();

        //4.遍历订单项集合 获取Pid
        for (OrderItem orderItem : list) {

            //4.1从orderitem中获取 pid
            String pid = orderItem.getPid();

            //4.2 调用productDao
            Product product = productDao.findProductById(pid);

            //4.3 保存到集合
            productList.add(product);
        }

        //返回 订单中对应的商品信息
        return productList;
    }


}

