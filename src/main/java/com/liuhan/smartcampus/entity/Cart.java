package com.liuhan.smartcampus.entity;

public class Cart {
    private int goods_id;
    private String goods_name;
    private String goods_pic;
    private int goods_num;

    public Cart() {
        super();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_pic='" + goods_pic + '\'' +
                ", goods_num=" + goods_num +
                '}';
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_pic() {
        return goods_pic;
    }

    public void setGoods_pic(String goods_pic) {
        this.goods_pic = goods_pic;
    }

    public int getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(int goods_num) {
        this.goods_num = goods_num;
    }

    public Cart(int goods_id, String goods_name, String goods_pic, int goods_num) {
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_pic = goods_pic;
        this.goods_num = goods_num;
    }
}
