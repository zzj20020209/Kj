package com.zzj.vo;

public class Kh {
    int khid;
    String khname;
    String khyx;
    String khgsdz;
    String khgsdh;
    String lxr;
    String lxrdh;

    public Kh(int khid, String khname, String khyx, String khgsdz, String khgsdh, String lxr, String lxrdh) {
        this.khid = khid;
        this.khname = khname;
        this.khyx = khyx;
        this.khgsdz = khgsdz;
        this.khgsdh = khgsdh;
        this.lxr = lxr;
        this.lxrdh = lxrdh;
    }
    public Kh(){}

    public int getKhid() {
        return khid;
    }

    public void setKhid(int khid) {
        this.khid = khid;
    }

    public String getKhname() {
        return khname;
    }

    public void setKhname(String khname) {
        this.khname = khname;
    }

    public String getKhyx() {
        return khyx;
    }

    public void setKhyx(String khyx) {
        this.khyx = khyx;
    }

    public String getKhgsdz() {
        return khgsdz;
    }

    public void setKhgsdz(String khgsdz) {
        this.khgsdz = khgsdz;
    }

    public String getKhgsdh() {
        return khgsdh;
    }

    public void setKhgsdh(String khgsdh) {
        this.khgsdh = khgsdh;
    }

    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }

    public String getLxrdh() {
        return lxrdh;
    }

    public void setLxrdh(String lxrdh) {
        this.lxrdh = lxrdh;
    }

    @Override
    public String toString() {
        return "Kh{" +
                "khid=" + khid +
                ", khname='" + khname + '\'' +
                ", khyx='" + khyx + '\'' +
                ", khgsdz='" + khgsdz + '\'' +
                ", khgsdh='" + khgsdh + '\'' +
                ", lxr='" + lxr + '\'' +
                ", lxrdh='" + lxrdh + '\'' +
                '}';
    }
}
