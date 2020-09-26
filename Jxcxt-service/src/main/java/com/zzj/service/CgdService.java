package com.zzj.service;

import com.zzj.vo.Cglj;
import com.zzj.vo.PageVo;

import java.util.List;

public interface CgdService {
    public List<Cglj> cgdcx(Cglj cglj, int page, int rows);
    public PageVo<Cglj> cgdcxsy(Cglj cglj, int page, int rows);
    public Cglj cxdg(int cgddid);
    public List<Cglj> rksqcx(Cglj cglj, int page, int rows);
    public PageVo<Cglj> rksqcxsy(Cglj cglj, int page, int rows);
    public int cgdjh(int cgddid);
    public int cgdth(int cgddid);
}
