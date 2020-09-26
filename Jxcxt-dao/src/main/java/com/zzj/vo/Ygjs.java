package com.zzj.vo;

public class Ygjs {
    int id;
    int yid;
    String yname;
    int jid;
    String jname;

    public Ygjs() { }

    public Ygjs(int id, int yid, String yname, int jid, String jname) {
        this.id = id;
        this.yid = yid;
        this.yname = yname;
        this.jid = jid;
        this.jname = jname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYid() {
        return yid;
    }

    public void setYid(int yid) {
        this.yid = yid;
    }

    public String getYname() {
        return yname;
    }

    public void setYname(String yname) {
        this.yname = yname;
    }

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    @Override
    public String toString() {
        return "Ygjs{" +
                "id=" + id +
                ", yid=" + yid +
                ", yname='" + yname + '\'' +
                ", jid=" + jid +
                ", jname='" + jname + '\'' +
                '}';
    }
}
