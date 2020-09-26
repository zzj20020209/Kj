package com.zzj.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class Cglj {
    int cgddid;
    String bz;
    int ddid;
    String yname;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    Date cgsj;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    Date cgdsj;
    float zjg;
    int zt;
    String spname;
    int spid;
    float spjg;
    int spsl;
    int cgzt;
    int rkzt;
    int th;


    public Cglj() { }

    public Cglj(int cgddid, String bz, int ddid, String yname, Date cgsj, Date cgdsj, float zjg, int zt, String spname, int spid, float spjg, int spsl, int cgzt, int rkzt, int th) {
        this.cgddid = cgddid;
        this.bz = bz;
        this.ddid = ddid;
        this.yname = yname;
        this.cgsj = cgsj;
        this.cgdsj = cgdsj;
        this.zjg = zjg;
        this.zt = zt;
        this.spname = spname;
        this.spid = spid;
        this.spjg = spjg;
        this.spsl = spsl;
        this.cgzt = cgzt;
        this.rkzt = rkzt;
        this.th = th;
    }

    public int getCgddid() {
        return cgddid;
    }

    public void setCgddid(int cgddid) {
        this.cgddid = cgddid;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public int getDdid() {
        return ddid;
    }

    public void setDdid(int ddid) {
        this.ddid = ddid;
    }

    public String getYname() {
        return yname;
    }

    public void setYname(String yname) {
        this.yname = yname;
    }

    public Date getCgsj() {
        return cgsj;
    }

    public void setCgsj(Date cgsj) {
        this.cgsj = cgsj;
    }

    public Date getCgdsj() {
        return cgdsj;
    }

    public void setCgdsj(Date cgdsj) {
        this.cgdsj = cgdsj;
    }

    public float getZjg() {
        return zjg;
    }

    public void setZjg(float zjg) {
        this.zjg = zjg;
    }

    public int getZt() {
        return zt;
    }

    public void setZt(int zt) {
        this.zt = zt;
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

    public int getCgzt() {
        return cgzt;
    }

    public void setCgzt(int cgzt) {
        this.cgzt = cgzt;
    }

    public int getRkzt() {
        return rkzt;
    }

    public void setRkzt(int rkzt) {
        this.rkzt = rkzt;
    }

    public int getTh() {
        return th;
    }

    public void setTh(int th) {
        this.th = th;
    }

    @Override
    public String toString() {
        return "Cglj{" +
                "cgddid=" + cgddid +
                ", bz=" + bz +
                ", ddid=" + ddid +
                ", yname='" + yname + '\'' +
                ", cgsj=" + cgsj +
                ", cgdsj=" + cgdsj +
                ", zjg=" + zjg +
                ", zt=" + zt +
                ", spname='" + spname + '\'' +
                ", spid=" + spid +
                ", spjg=" + spjg +
                ", spsl=" + spsl +
                ", cgzt=" + cgzt +
                ", rkzt=" + rkzt +
                ", th=" + th +
                '}';
    }
}
