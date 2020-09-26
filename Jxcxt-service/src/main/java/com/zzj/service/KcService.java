package com.zzj.service;

import com.zzj.vo.Kc;
import com.zzj.vo.PageVo;
import com.zzj.vo.Shangping;

import java.util.List;

public interface KcService {
    public List<Kc> kccx(Kc kc, int page, int rows);
    public PageVo<Kc> kccxfy(Kc kc, int page, int rows);
    public List<Kc> kccxsy();
    public int kcdel(int kid);
    public int kcadd(Kc kc);
    public Kc kcidcx(int kid);
}
