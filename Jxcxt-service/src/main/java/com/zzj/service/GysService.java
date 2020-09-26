package com.zzj.service;

import com.zzj.vo.Gys;
import com.zzj.vo.Kc;
import com.zzj.vo.PageVo;

import java.util.List;

public interface GysService {
    public List<Gys> gyscx(Gys gys, int page, int rows);
    public PageVo<Gys> gyscxfy(Gys gys, int page, int rows);
    public int gysdel(int gid);
    public int gysdelsp(int gid);
    public int gysadd(Gys gys);
    public Gys gysidcx(int gid);
    public int gysxg(Gys gys);
}
