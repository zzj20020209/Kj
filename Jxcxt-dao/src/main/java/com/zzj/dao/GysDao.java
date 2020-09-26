package com.zzj.dao;

import com.zzj.vo.Gys;
import com.zzj.vo.Kc;

import java.util.List;
import java.util.Map;

public interface GysDao {
    public List<Gys> gyscx(Gys gys);
    public int gyscxfy(Gys gys);
    public int gysdel(int gid);
    public int gysdelsp(int gid);
    public int gysadd(Gys gys);
    public Gys gysidcx(int gid);
    public int gysxg(Gys gys);
}
