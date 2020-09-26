package com.zzj.dao;

import com.zzj.vo.Cglj;
import com.zzj.vo.Kcrlb;

import java.util.List;

public interface CgdDao {
    public List<Cglj> cgdcx(Cglj cglj);
    public int cgdcxsy(Cglj cglj);
    public Cglj cxdg(int cgddid);
    public int cgdjh(int cgddid);
    public int cgdth(int cgddid);
    public List<Cglj> rksqcx(Cglj cglj);
    public int rksqcxsy(Cglj cglj);
}
