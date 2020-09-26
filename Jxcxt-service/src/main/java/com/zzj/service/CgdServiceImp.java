package com.zzj.service;

import com.github.pagehelper.PageHelper;
import com.zzj.dao.CgdDao;
import com.zzj.vo.Cglj;
import com.zzj.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CgdServiceImp implements CgdService{

    @Autowired
    CgdDao cgdDao;

    @Override
    public List<Cglj> cgdcx(Cglj cglj, int page, int rows) {
        PageHelper.startPage(page, rows);
        return cgdDao.cgdcx(cglj);
    }

    @Override
    public PageVo<Cglj> cgdcxsy(Cglj cglj, int page, int rows) {
        PageVo<Cglj> pageVo = new PageVo<>();

        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(cgdDao.cgdcx(cglj));
        //获取总的记录数量
        pageVo.setTotal(cgdDao.cgdcxsy(cglj));
        return pageVo;
    }

    @Override
    public Cglj cxdg(int cgddid) {
        return cgdDao.cxdg(cgddid);
    }

    @Override
    public List<Cglj> rksqcx(Cglj cglj, int page, int rows) {
        PageHelper.startPage(page, rows);
        return cgdDao.rksqcx(cglj);
    }

    @Override
    public PageVo<Cglj> rksqcxsy(Cglj cglj, int page, int rows) {
        PageVo<Cglj> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(cgdDao.rksqcx(cglj));
        //获取总的记录数量
        pageVo.setTotal(cgdDao.rksqcxsy(cglj));
        return pageVo;
    }

    @Override
    public int cgdjh(int cgddid) {
        return cgdDao.cgdjh(cgddid);
    }


    @Override
    public int cgdth(int cgddid) {
        return cgdDao.cgdth(cgddid);
    }
}
