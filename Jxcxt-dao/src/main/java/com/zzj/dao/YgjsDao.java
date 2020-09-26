package com.zzj.dao;

import com.zzj.vo.YgVo;
import com.zzj.vo.Ygjs;

import java.util.List;

public interface YgjsDao {
    public List<Ygjs> ygjscx(Ygjs ygjs);
    public int ygjscxsy(Ygjs ygjs);
    public List<Ygjs> ygjscxid(int yid);
    public int ygjsadd(Ygjs ygjs);
    public int ygjsdel(int id);
}
