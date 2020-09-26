package com.zzj.vo;

public class Splx {
    int id;
    String text;

    public Splx(int id, String text) {
        this.id = id;
        this.text = text;
    }
    public Splx(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Splx{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
