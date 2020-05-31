package com.liuhan.smartcampus.entity;

public class Catelog {
    private int catelog_id;
    private String catelog_name;
    private String catelog_del;

    public Catelog() {
        super();
    }

    @Override
    public String toString() {
        return "Catelog{" +
                "catelog_id=" + catelog_id +
                ", catelog_name='" + catelog_name + '\'' +
                ", catelog_del='" + catelog_del + '\'' +
                '}';
    }

    public int getCatelog_id() {
        return catelog_id;
    }

    public void setCatelog_id(int catelog_id) {
        this.catelog_id = catelog_id;
    }

    public String getCatelog_name() {
        return catelog_name;
    }

    public void setCatelog_name(String catelog_name) {
        this.catelog_name = catelog_name;
    }

    public String getCatelog_del() {
        return catelog_del;
    }

    public void setCatelog_del(String catelog_del) {
        this.catelog_del = catelog_del;
    }

    public Catelog(int catelog_id, String catelog_name, String catelog_del) {
        this.catelog_id = catelog_id;
        this.catelog_name = catelog_name;
        this.catelog_del = catelog_del;
    }
}
