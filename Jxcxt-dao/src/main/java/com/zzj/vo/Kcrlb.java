package com.zzj.vo;

public class Kcrlb {
    int id;
    int kid;
    int sl;
    String kcname;
    String spname;

    public Kcrlb(int id, int kid, int sl, String kcname, String spname) {
        this.id = id;
        this.kid = kid;
        this.sl = sl;
        this.kcname = kcname;
        this.spname = spname;
    }

    public Kcrlb(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public String getKcname() {
        return kcname;
    }

    public void setKcname(String kcname) {
        this.kcname = kcname;
    }

    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
    }

    @Override
    public String toString() {
        return "Kcrlb{" +
                "id=" + id +
                ", kid=" + kid +
                ", sl=" + sl +
                ", kcname='" + kcname + '\'' +
                ", spname='" + spname + '\'' +
                '}';
    }
}
