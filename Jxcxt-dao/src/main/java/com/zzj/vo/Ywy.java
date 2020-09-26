package com.zzj.vo;

public class Ywy {
    int ywyid;
    String ywyname;
    int ywyage;
    String ywysex;

    public Ywy(int ywyid, String ywyname, int ywyage, String ywysex) {
        this.ywyid = ywyid;
        this.ywyname = ywyname;
        this.ywyage = ywyage;
        this.ywysex = ywysex;
    }

    public Ywy(){}

    public int getYwyid() {
        return ywyid;
    }

    public void setYwyid(int ywyid) {
        this.ywyid = ywyid;
    }

    public String getYwyname() {
        return ywyname;
    }

    public void setYwyname(String ywyname) {
        this.ywyname = ywyname;
    }

    public int getYwyage() {
        return ywyage;
    }

    public void setYwyage(int ywyage) {
        this.ywyage = ywyage;
    }

    public String getYwysex() {
        return ywysex;
    }

    public void setYwysex(String ywysex) {
        this.ywysex = ywysex;
    }

    @Override
    public String toString() {
        return "Ywy{" +
                "ywyid=" + ywyid +
                ", ywyname='" + ywyname + '\'' +
                ", ywyage=" + ywyage +
                ", ywysex='" + ywysex + '\'' +
                '}';
    }
}
