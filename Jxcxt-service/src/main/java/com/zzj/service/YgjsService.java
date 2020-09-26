package com.zzj.service;

import com.zzj.vo.PageVo;
import com.zzj.vo.Ygjs;

import java.util.List;

public interface YgjsService {
    public List<Ygjs> ygjscx(Ygjs ygjs, int page, int rows);
    public PageVo<Ygjs> ygjscxsy(Ygjs ygjs, int page, int rows);
    public List<Ygjs> ygjscxid(int yid);
    public int ygjsadd(Ygjs ygjs);
    public int ygjsdel(int id);
}
