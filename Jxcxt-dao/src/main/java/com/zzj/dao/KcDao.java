package com.zzj.dao;

import com.zzj.vo.Kc;

import java.util.List;
import java.util.Map;

public interface KcDao {
    public List<Kc> kccx(Kc kc);
    public int kccxfy(Kc kc);
    public List<Kc> kccxsy();
    public int kcdel(int kid);
    public int kcadd(Kc kc);
    public Kc kcidcx(int kid);
}
