package com.zzj.service;

import com.zzj.dao.JueseDao;
import com.zzj.vo.Juese;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JueseServiceImp implements JueseService{

    @Autowired
    JueseDao jueseDao;

    @Override
    public List<Juese> jscxsy() {
        return jueseDao.jscxsy();
    }

    @Override
    public List<Juese> jsidcx(int yid) {
        return jueseDao.jsidcx(yid);
    }

    @Override
    public int del(int jid) {
        return jueseDao.del(jid);
    }

    @Override
    public int add(int jid,int cid) {
        Map map = new HashMap();
        map.put("jid",jid);
        map.put("cid",cid);
        return jueseDao.add(map);
    }
}
