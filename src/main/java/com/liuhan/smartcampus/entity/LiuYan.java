package com.liuhan.smartcampus.entity;

import java.util.Date;

public class LiuYan {
    private int liuyan_id;
    private String liuyan_title;
    private String liuyan_content;
    private Date liuyan_date;
    private String liuyan_user;

    public LiuYan() {
        super();
    }

    @Override
    public String toString() {
        return "LiuYan{" +
                "liuyan_id=" + liuyan_id +
                ", liuyan_title='" + liuyan_title + '\'' +
                ", liuyan_content='" + liuyan_content + '\'' +
                ", liuyan_date=" + liuyan_date +
                ", liuyan_user='" + liuyan_user + '\'' +
                '}';
    }

    public int getLiuyan_id() {
        return liuyan_id;
    }

    public void setLiuyan_id(int liuyan_id) {
        this.liuyan_id = liuyan_id;
    }

    public String getLiuyan_title() {
        return liuyan_title;
    }

    public void setLiuyan_title(String liuyan_title) {
        this.liuyan_title = liuyan_title;
    }

    public String getLiuyan_content() {
        return liuyan_content;
    }

    public void setLiuyan_content(String liuyan_content) {
        this.liuyan_content = liuyan_content;
    }

    public Date getLiuyan_date() {
        return liuyan_date;
    }

    public void setLiuyan_date(Date liuyan_date) {
        this.liuyan_date = liuyan_date;
    }

    public String getLiuyan_user() {
        return liuyan_user;
    }

    public void setLiuyan_user(String liuyan_user) {
        this.liuyan_user = liuyan_user;
    }

    public LiuYan(int liuyan_id, String liuyan_title, String liuyan_content, Date liuyan_date, String liuyan_user) {
        this.liuyan_id = liuyan_id;
        this.liuyan_title = liuyan_title;
        this.liuyan_content = liuyan_content;
        this.liuyan_date = liuyan_date;
        this.liuyan_user = liuyan_user;
    }
}
