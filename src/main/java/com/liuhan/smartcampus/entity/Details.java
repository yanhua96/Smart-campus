package com.liuhan.smartcampus.entity;

import java.math.BigDecimal;

public class Details {
    private String goods_name;
    private BigDecimal goods_pic;
    private int goods_quantity;
    private BigDecimal good_sum;

    public Details() {
        super();
    }

    @Override
    public String toString() {
        return "Details{" +
                "goods_name='" + goods_name + '\'' +
                ", goods_pic=" + goods_pic +
                ", goods_quantity=" + goods_quantity +
                ", good_sum=" + good_sum +
                '}';
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public BigDecimal getGoods_pic() {
        return goods_pic;
    }

    public void setGoods_pic(BigDecimal goods_pic) {
        this.goods_pic = goods_pic;
    }

    public int getGoods_quantity() {
        return goods_quantity;
    }

    public void setGoods_quantity(int goods_quantity) {
        this.goods_quantity = goods_quantity;
    }

    public BigDecimal getGood_sum() {
        return good_sum;
    }

    public void setGood_sum(BigDecimal good_sum) {
        this.good_sum = good_sum;
    }

    public Details(String goods_name, BigDecimal goods_pic, int goods_quantity, BigDecimal good_sum) {
        this.goods_name = goods_name;
        this.goods_pic = goods_pic;
        this.goods_quantity = goods_quantity;
        this.good_sum = good_sum;
    }
}
