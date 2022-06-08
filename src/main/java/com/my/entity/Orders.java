package com.my.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ymm
 * @date: 2022/6/6
 * @version: 1.0.0
 * @description: 订单表
 * <p>
 * oid VARCHAR(32)   PRIMARY KEY, -- 订单id
 * ordertime DATETIME ,	-- 下单时间
 * total DOUBLE , -- 总金额
 * NAME VARCHAR(20), -- 收货人姓名
 * telephone VARCHAR(20) , -- 收货人电话
 * address VARCHAR(30) , -- 地址
 * state INT(11) ,  -- 订单状态
 * uid VARCHAR(32), -- 外键字段 对应用户表id
 * CONSTRAINT ofk_0001 FOREIGN KEY (uid) REFERENCES USER (uid)
 */
public class Orders {
    // 订单id
    private String oid;
    // 下单时间
    private String ordertime;
    // 订单总金额
    private double total;
    // 收货人姓名
    private String name;
    // 收货人电话
    private String telephone;
    // 收货地址
    private String address;
    // 订单状态 0 代表未支付 1 代表已支付
    private int state;
    // 外键id
    private String uid;
    // uid对应的User对象
    private User user;

    // 一个订单中包含多个订单项信息
    List<OrderItem> list = new ArrayList<>();


    public Orders() {
    }

    public Orders(String oid, String ordertime, double total, String name, String telephone, String address, int state, String uid, User user) {
        this.oid = oid;
        this.ordertime = ordertime;
        this.total = total;
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.state = state;
        this.uid = uid;
        this.user = user;
    }


    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getList() {
        return list;
    }

    public void setList(List<OrderItem> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oid='" + oid + '\'' +
                ", ordertime='" + ordertime + '\'' +
                ", total=" + total +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", state=" + state +
                ", uid='" + uid + '\'' +
                '}';
    }
}
