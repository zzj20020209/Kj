package com.zzj.vo;

public class Kc {
    int kid;
    String kcname;
    int sl;

    public Kc(){}

    public Kc(int kid, String kcname, int sl) {
        this.kid = kid;
        this.kcname = kcname;
        this.sl = sl;
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public String getKcname() {
        return kcname;
    }

    public void setKcname(String kcname) {
        this.kcname = kcname;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    @Override
    public String toString() {
        return "Kc{" +
                "kid=" + kid +
                ", kcname='" + kcname + '\'' +
                ", sl=" + sl +
                '}';
    }
}

