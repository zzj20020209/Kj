package com.zzj.service;

import com.zzj.vo.Cglj;
import com.zzj.vo.PageVo;

import java.util.List;

public interface ThServcie {
    public List<Cglj> cgdcx(Cglj cglj, int page, int rows);
    public PageVo<Cglj> cgdcxsy(Cglj cglj, int page, int rows);
}
