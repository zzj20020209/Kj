package com.zzj.service;

import com.github.pagehelper.PageHelper;
import com.zzj.dao.KcrlDao;
import com.zzj.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KcrlServiceImp implements KcrlService{

    @Autowired
    KcrlDao kcrlDao;

    @Override
    public List<Kcrlb> kcrlcx(Kcrlb kcrlb, int page, int rows) {
        PageHelper.startPage(page, rows);
        return kcrlDao.kcrlcx(kcrlb);
    }

    @Override
    public PageVo<Kcrlb> kcrlcxfy(Kcrlb kcrlb, int page, int rows) {
        PageVo<Kcrlb> pageVo = new PageVo<>();

        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(kcrlDao.kcrlcx(kcrlb));
        //获取总的记录数量
        pageVo.setTotal(kcrlDao.kcrlcxfy(kcrlb));
        return pageVo;
    }

    @Override
    public Cglj idcxs(int cgddid) {
        return kcrlDao.idcxs(cgddid);
    }

    @Override
    public List<Kcrlb> cxkid(int kid) {
        return kcrlDao.cxkid(kid);
    }

    @Override
    public int xgspsl(Kcrlb kcrlb) {
        return kcrlDao.xgspsl(kcrlb);
    }


    @Override
    public List<Ddb> ddbcxs(int cgddid) {
        return kcrlDao.ddbcxs(cgddid);
    }

    @Override
    public int kcrladd(Kcrlb kcrlb) {
        return kcrlDao.kcrladd(kcrlb);
    }

    @Override
    public int sqrk(int cgddid) {
        return kcrlDao.sqrk(cgddid);
    }
}
