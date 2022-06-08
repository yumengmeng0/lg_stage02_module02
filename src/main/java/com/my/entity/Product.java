package com.my.entity;

/**
 * @author: ymm
 * @date: 2022/6/6
 * @version: 1.0.0
 * @description: 商品表
 * <p>
 * pid VARCHAR(32)  PRIMARY KEY,	-- 商品id
 * pname VARCHAR(50) , -- 商品名称
 * price DOUBLE, -- 商品价格
 * pdesc VARCHAR(255), -- 商品描述
 * pflag INT(11) , -- 商品状态 1 上架 ,0 下架
 * cid VARCHAR(32) , -- 外键对应 分类表id
 */
public class Product {

    private String pid;
    private String pname;
    private double price;
    private String pdesc;
    private int pflag;

    // 商品分类id
    private String cid;
    private Category category;

    public Product() {
    }

    public Product(String pid, String pname, double price, String pdesc, int pflag, String cid) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.pdesc = pdesc;
        this.pflag = pflag;
        this.cid = cid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public int getPflag() {
        return pflag;
    }

    public void setPflag(int pflag) {
        this.pflag = pflag;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", pdesc='" + pdesc + '\'' +
                ", pflag=" + pflag +
                ", cid='" + cid + '\'' +
                '}';
    }
}
