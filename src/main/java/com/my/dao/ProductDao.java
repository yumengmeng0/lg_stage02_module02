package com.my.dao;

import com.my.entity.Category;
import com.my.entity.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DruidUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: ymm
 * @date: 2022/6/6
 * @version: 1.0.0
 * @description:
 */
public class ProductDao {

    /**
     * 根据商品id获取商品信息
     *
     * @param pid
     * @return
     * @throws SQLException
     */
    public Product findProductById(String pid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

        String sql = "select * from product where pid = ?";
        Product product = queryRunner.query(sql, new BeanHandler<>(Product.class), pid);

        // 获取外键的值对应分类id
        String cid = product.getCid();
        Category category = findCategoryById(cid);

        product.setCategory(category);

        return product;
    }

    /**
     * 根据分类id查询分类信息
     *
     * @param cid
     * @return
     * @throws SQLException
     */
    public Category findCategoryById(String cid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

        String sql = "select * from category where cid = ?";
        Category category = queryRunner.query(sql, new BeanHandler<>(Category.class), cid);

        return category;
    }


    /**
     * 根据分类id查询该分类下所有商品种类
     *
     * @param cid
     * @return
     * @throws SQLException
     */
    public int getCountByCategoryId(String cid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

        String sql = "select count(*) from product where cid = ?";

        // 获取单列数据，使用ScalarHandler封装
        Long count = queryRunner.query(sql, new ScalarHandler<>(), cid);

        return count.intValue();
    }


    /**
     * 查询指定分类id下所有商品信息
     *
     * @param cid
     * @return
     * @throws SQLException
     */
    public List<Product> findProductsByCid(String cid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from product where cid = ?";

        List<Product> productList = queryRunner.query(sql, new BeanListHandler<>(Product.class), cid);

        return productList;
    }
}
