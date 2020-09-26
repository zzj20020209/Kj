package com.zzj.service;

import com.github.pagehelper.PageHelper;
import com.zzj.dao.SpDao;
import com.zzj.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpServiceImp implements SpService{

    @Autowired
    SpDao spDao;

    @Override
    public List<Splx> wsplx() {
        List<Splx> list=spDao.splx();
        Splx s = list.get(0);
        list.add(s);
        Splx ss = new Splx();
        ss.setText("请选择");
        ss.setId(0);
        list.set(0,ss);
        return list;
    }

    @Override
    public List<Splx> splx() {
        return spDao.splx();
    }

    @Override
    public List<Gys> spgys() {
        return spDao.spgys();
    }

    @Override
    public List<Shangping> spcx(Shangping shangping, int page, int rows) {
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        return spDao.spcx(shangping);
    }

    @Override
    public List<Shangping> spcxs() {
        return spDao.spcxs();
    }

    @Override
    public List<Shangping> cgys(Shangping shangping) {
        return spDao.cgys(shangping);
    }

    @Override
    public PageVo<Shangping> spcxsy(Shangping shangping, int page, int rows) {
        PageVo<Shangping> pageVo = new PageVo<>();

        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(spDao.spcx(shangping));
        //获取总的记录数量
        pageVo.setTotal(spDao.spcxsy(shangping));
        return pageVo;
    }

    @Override
    public int spadd(Shangping shangping) {
        return spDao.spadd(shangping);
    }

    @Override
    public int spxg(Shangping shangping) {
        return spDao.spxg(shangping);
    }

    @Override
    public Shangping spidcx(int spid) {
        return spDao.spidcx(spid);
    }

    @Override
    public int spdel(int spid) {
        return spDao.spdel(spid);
    }

}
