package com.liuhan.smartcampus.entity;

import java.math.BigDecimal;

public class Goods {
    private int goods_id;
    private String goods_name;
    private String goods_miaoshu;
    private String goods_pic;
    private int goods_tejia;
    private int goods_isnottejia;
    private String goods_tupian;
    private int goods_catelog_id;
    private int goods_shichangjia;
    private String goods_type;


    public Goods() {
        super();
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_miaoshu='" + goods_miaoshu + '\'' +
                ", goods_pic='" + goods_pic + '\'' +
                ", goods_tejia=" + goods_tejia +
                ", goods_isnottejia=" + goods_isnottejia +
                ", goods_tupian='" + goods_tupian + '\'' +
                ", goods_catelog_id=" + goods_catelog_id +
                ", goods_shichangjia=" + goods_shichangjia +
                ", goods_type='" + goods_type + '\'' +
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

    public String getGoods_miaoshu() {
        return goods_miaoshu;
    }

    public void setGoods_miaoshu(String goods_miaoshu) {
        this.goods_miaoshu = goods_miaoshu;
    }

    public String getGoods_pic() {
        return goods_pic;
    }

    public void setGoods_pic(String goods_pic) {
        this.goods_pic = goods_pic;
    }

    public int getGoods_tejia() {
        return goods_tejia;
    }

    public void setGoods_tejia(int goods_tejia) {
        this.goods_tejia = goods_tejia;
    }

    public int getGoods_isnottejia() {
        return goods_isnottejia;
    }

    public void setGoods_isnottejia(int goods_isnottejia) {
        this.goods_isnottejia = goods_isnottejia;
    }

    public String getGoods_tupian() {
        return goods_tupian;
    }

    public void setGoods_tupian(String goods_tupian) {
        this.goods_tupian = goods_tupian;
    }

    public int getGoods_catelog_id() {
        return goods_catelog_id;
    }

    public void setGoods_catelog_id(int goods_catelog_id) {
        this.goods_catelog_id = goods_catelog_id;
    }

    public int getGoods_shichangjia() {
        return goods_shichangjia;
    }

    public void setGoods_shichangjia(int goods_shichangjia) {
        this.goods_shichangjia = goods_shichangjia;
    }

    public String getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }

    public Goods(int goods_id, String goods_name, String goods_miaoshu, String goods_pic, int goods_tejia, int goods_isnottejia, String goods_tupian, int goods_catelog_id, int goods_shichangjia, String goods_type) {
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_miaoshu = goods_miaoshu;
        this.goods_pic = goods_pic;
        this.goods_tejia = goods_tejia;
        this.goods_isnottejia = goods_isnottejia;
        this.goods_tupian = goods_tupian;
        this.goods_catelog_id = goods_catelog_id;
        this.goods_shichangjia = goods_shichangjia;
        this.goods_type = goods_type;
    }
}
