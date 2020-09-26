package com.zzj.vo;

import java.util.List;

public class Juese {
    int id;
    int jid;
    String jname;
    List<Cd> cd;

    public Juese(int id, int jid, String jname, List<Cd> cd) {
        this.id = id;
        this.jid = jid;
        this.jname = jname;
        this.cd = cd;
    }

    public Juese(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Cd> getCd() {
        return cd;
    }

    public void setCd(List<Cd> cd) {
        this.cd = cd;
    }

    @Override
    public String toString() {
        return "Juese{" +
                "id=" + id +
                ", jid=" + jid +
                ", jname='" + jname + '\'' +
                ", cd=" + cd +
                '}';
    }
}
