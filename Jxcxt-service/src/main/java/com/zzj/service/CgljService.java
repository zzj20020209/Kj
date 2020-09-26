package com.zzj.service;

import com.zzj.vo.Cglj;
import com.zzj.vo.PageVo;
import com.zzj.vo.YgVo;

import java.util.List;

public interface CgljService {
    public List<Cglj> cx(Cglj cglj, int page, int rows);
    public PageVo<Cglj> cxsy(Cglj cglj, int page, int rows);
    public int zjghq(int cgddid);
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
