package com.zzj.dao;

import com.zzj.vo.Cglj;
import com.zzj.vo.YgVo;

import java.util.Date;
import java.util.List;

public interface CgljDao {
    public List<Cglj> cx(Cglj cglj);
    public int zjghq(int cgddid);
    public int cxsy(Cglj cglj);
    public int add(Cglj cglj);
    public int xg(Cglj cglj);
    public Cglj idcx(int cgddid);
    public int del(int cgddid);
    public int dddel(int cgddid);
    public int ty(int cgddid);
    public int jj(int cgddid);
    public int xgcgsj(Cglj cglj);
    public int csl(int cgddid);
}
