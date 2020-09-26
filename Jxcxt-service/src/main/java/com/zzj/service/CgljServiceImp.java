package com.zzj.service;

import com.github.pagehelper.PageHelper;
import com.zzj.dao.CgljDao;
import com.zzj.vo.Cglj;
import com.zzj.vo.PageVo;
import com.zzj.vo.YgVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CgljServiceImp implements CgljService{

    @Autowired
    CgljDao cgljDao;

    @Override
    public List<Cglj> cx(Cglj cglj, int page, int rows) {
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        return cgljDao.cx(cglj);
    }

    @Override
    public PageVo<Cglj> cxsy(Cglj cglj, int page, int rows) {
        PageVo<Cglj> pageVo = new PageVo<>();

        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(cgljDao.cx(cglj));
        //获取总的记录数量
        pageVo.setTotal(cgljDao.cxsy(cglj));
        return pageVo;
    }

    @Override
    public int zjghq(int cgddid) {
        return cgljDao.zjghq(cgddid);
    }

    @Override
    public int add(Cglj cglj) {
        return cgljDao.add(cglj);
    }

    @Override
    public int xg(Cglj cglj) {
        return cgljDao.xg(cglj);
    }

    @Override
    public Cglj idcx(int cgddid) {
        return cgljDao.idcx(cgddid);
    }

    @Override
    public int del(int cgddid) {
        return cgljDao.del(cgddid);
    }

    @Override
    public int dddel(int cgddid) {
        return cgljDao.dddel(cgddid);
    }

    @Override
    public int ty(int cgddid) {
        return cgljDao.ty(cgddid);
    }

    @Override
    public int jj(int cgddid) {
        return cgljDao.jj(cgddid);
    }

    @Override
    public int xgcgsj(Cglj cglj) {
        return cgljDao.xgcgsj(cglj);
    }

    @Override
    public int csl(int cgddid) {
        return cgljDao.csl(cgddid);
    }
}
