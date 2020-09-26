package com.zzj.vo;

public class Shangping {
    int spid;
    String spname;
    int gid;
    String gname;
    String text;
    int splx;
    String spscph;
    String spms;
    Float price;
    int zt;

    public Shangping(int spid, String spname, int gid, String gname, String text, int splx, String spscph, String spms, Float price, int zt) {
        this.spid = spid;
        this.spname = spname;
        this.gid = gid;
        this.gname = gname;
        this.text = text;
        this.splx = splx;
        this.spscph = spscph;
        this.spms = spms;
        this.price = price;
        this.zt = zt;
    }

    public Shangping(){}

    public int getSpid() {
        return spid;
    }

    public void setSpid(int spid) {
        this.spid = spid;
    }

    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSplx() {
        return splx;
    }

    public void setSplx(int splx) {
        this.splx = splx;
    }

    public String getSpscph() {
        return spscph;
    }

    public void setSpscph(String spscph) {
        this.spscph = spscph;
    }

    public String getSpms() {
        return spms;
    }

    public void setSpms(String spms) {
        this.spms = spms;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getZt() {
        return zt;
    }

    public void setZt(int zt) {
        this.zt = zt;
    }

    @Override
    public String toString() {
        return "Shangping{" +
                "spid=" + spid +
                ", spname='" + spname + '\'' +
                ", gid=" + gid +
                ", gname='" + gname + '\'' +
                ", text='" + text + '\'' +
                ", splx=" + splx +
                ", spscph='" + spscph + '\'' +
                ", spms='" + spms + '\'' +
                ", price=" + price +
                ", zt=" + zt +
                '}';
    }
}
