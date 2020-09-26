package com.zzj.service;

import com.zzj.vo.Ddb;

import java.util.List;

public interface DdbService {
    public List<Ddb> ddbcx(int cgddid);
    public int ddbdel(int ddid);
    public int ddbadd(Ddb ddb);
}
