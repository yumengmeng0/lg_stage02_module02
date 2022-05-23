package com.lagou.entity;

/**
 *   product表
 *   `pid` VARCHAR(32) NOT NULL,
 *   `pname` VARCHAR(50) DEFAULT NULL,
 *   `price` DOUBLE DEFAULT NULL,
 *   `pdesc` VARCHAR(255) DEFAULT NULL,
 *   `pflag` INT(11) DEFAULT NULL,
 *   `cid` VARCHAR(32) DEFAULT NULL,
 *
 * */
public class Product {

    private String pid;

    private String pname;

    private double price;

    private String pdesc;

    private int pflag; //是否上架 1 上架, 0 下架

    //外键
    private String cid;

    private Category category; //保存分类的详细信息

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
