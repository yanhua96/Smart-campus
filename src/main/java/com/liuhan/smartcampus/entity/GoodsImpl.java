package com.liuhan.smartcampus.entity;

/**
 * 订单明细
 */
public class GoodsImpl {
    private String name;
    private int num;
    private String pic;

    public GoodsImpl() {
        super();
    }

    @Override
    public String toString() {
        return "GoodsImpl{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", pic='" + pic + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public GoodsImpl(String name, int num, String pic) {
        this.name = name;
        this.num = num;
        this.pic = pic;
    }
}
