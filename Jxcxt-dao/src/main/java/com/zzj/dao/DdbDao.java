package com.zzj.dao;

import com.zzj.vo.Cglj;
import com.zzj.vo.Ddb;
import com.zzj.vo.Gys;

import java.util.List;

public interface DdbDao {
    public List<Ddb> ddbcx(int cgddid);
    public int ddbdel(int ddid);
    public int ddbadd(Ddb ddb);
}
