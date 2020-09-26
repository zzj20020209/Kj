package com.zzj.vo;

public class Gys {
    int gid;
    String gname;
    String gyx;
    String gsdz;
    String gsdh;

    public Gys(int gid, String gname, String gyx, String gsdz, String gsdh) {
        this.gid = gid;
        this.gname = gname;
        this.gyx = gyx;
        this.gsdz = gsdz;
        this.gsdh = gsdh;
    }

    public Gys(){}

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

    public String getGyx() {
        return gyx;
    }

    public void setGyx(String gyx) {
        this.gyx = gyx;
    }

    public String getGsdz() {
        return gsdz;
    }

    public void setGsdz(String gsdz) {
        this.gsdz = gsdz;
    }

    public String getGsdh() {
        return gsdh;
    }

    public void setGsdh(String gsdh) {
        this.gsdh = gsdh;
    }

    @Override
    public String toString() {
        return "Gys{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", gyx='" + gyx + '\'' +
                ", gsdz='" + gsdz + '\'' +
                ", gsdh='" + gsdh + '\'' +
                '}';
    }
}
