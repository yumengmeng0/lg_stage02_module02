package com.my.entity;

/**
 * @author: ymm
 * @date: 2022/6/6
 * @version: 1.0.0
 * @description: 订单项表：表示订单中一个订单中所有的商品信息
 * <p>
 * itemid VARCHAR(32) PRIMARY KEY, -- 订单项ID
 * pid VARCHAR(32),  -- 外键 对应商品表 id
 * oid VARCHAR(32), -- 外键 对应订单表 id
 */
public class OrderItem {
    private String itemid;
    private String pid;
    private String oid;

    private Product product; // 订单项中商品的详细信息
    private Orders orders; // 订单项中订单的详细信息

    public OrderItem() {
    }

    public OrderItem(String itemid, String pid, String oid) {
        this.itemid = itemid;
        this.pid = pid;
        this.oid = oid;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemid='" + itemid + '\'' +
                ", pid='" + pid + '\'' +
                ", oid='" + oid + '\'' +
                '}';
    }
}
