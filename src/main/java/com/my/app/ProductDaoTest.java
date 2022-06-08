package com.my.app;

import com.my.dao.ProductDao;
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
public class ProductDaoTest {

    public ProductDao productDao = new ProductDao();

    @Test
    public void testFindProductById() throws SQLException {
        Product product = productDao.findProductById("10");
        if (product!=null){
            System.out.println("product = " + product + "\n商品分类："  + product.getCategory().getCname());
        }
    }

    @Test
    public void testGetCountByCategoryId() throws SQLException {
        int count = productDao.getCountByCategoryId("1");

        System.out.println("count = " + count);
    }

    @Test
    public void testFindProductsByCid() throws SQLException {
        List<Product> productList = productDao.findProductsByCid("3");

        for (Product product : productList) {
            System.out.println("product = " + product);
        }
    }

}
