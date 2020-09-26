package com.zzj.vo;

public class Ddb {
    int cgddid;
    int ddid;
    String spname;
    int spid;
    float spjg;
    int spsl;

    public Ddb(int cgddid, int ddid, String spname, int spid, float spjg, int spsl) {
        this.cgddid = cgddid;
        this.ddid = ddid;
        this.spname = spname;
        this.spid = spid;
        this.spjg = spjg;
        this.spsl = spsl;
    }

    public Ddb(){}

    public int getCgddid() {
        return cgddid;
    }

    public void setCgddid(int cgddid) {
        this.cgddid = cgddid;
    }

    public int getDdid() {
        return ddid;
    }

    public void setDdid(int ddid) {
        this.ddid = ddid;
    }

    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
    }

    public int getSpid() {
        return spid;
    }

    public void setSpid(int spid) {
        this.spid = spid;
    }

    public float getSpjg() {
        return spjg;
    }

    public void setSpjg(float spjg) {
        this.spjg = spjg;
    }

    public int getSpsl() {
        return spsl;
    }

    public void setSpsl(int spsl) {
        this.spsl = spsl;
    }

    @Override
    public String toString() {
        return "Ddb{" +
                "cgddid=" + cgddid +
                ", ddid=" + ddid +
                ", spname='" + spname + '\'' +
                ", spid=" + spid +
                ", spjg=" + spjg +
                ", spsl=" + spsl +
                '}';
    }
}
