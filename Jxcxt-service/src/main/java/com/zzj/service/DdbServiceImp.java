package com.zzj.service;

import com.zzj.dao.DdbDao;
import com.zzj.vo.Ddb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DdbServiceImp implements DdbService{

    @Autowired
    DdbDao ddbDao;

    @Override
    public List<Ddb> ddbcx(int cgddid) {
        return ddbDao.ddbcx(cgddid);
    }

    @Override
    public int ddbdel(int ddid) {
        return ddbDao.ddbdel(ddid);
    }

    @Override
    public int ddbadd(Ddb ddb) {
        return ddbDao.ddbadd(ddb);
    }
}
