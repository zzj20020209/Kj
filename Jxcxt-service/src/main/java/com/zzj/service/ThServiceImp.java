package com.zzj.service;

import com.github.pagehelper.PageHelper;
import com.zzj.dao.ThDao;
import com.zzj.vo.Cglj;
import com.zzj.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThServiceImp implements ThServcie{

    @Autowired
    ThDao thDao;

    @Override
    public List<Cglj> cgdcx(Cglj cglj, int page, int rows) {
        PageHelper.startPage(page, rows);
        return thDao.cgdcx(cglj);
    }

    @Override
    public PageVo<Cglj> cgdcxsy(Cglj cglj, int page, int rows) {
        PageVo<Cglj> pageVo = new PageVo<>();

        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(thDao.cgdcx(cglj));
        //获取总的记录数量
        pageVo.setTotal(thDao.cgdcxsy(cglj));
        return pageVo;
    }
}
