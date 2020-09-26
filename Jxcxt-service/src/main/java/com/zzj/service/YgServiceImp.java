package com.zzj.service;


import com.github.pagehelper.PageHelper;
import com.zzj.dao.YgDao;
import com.zzj.vo.PageVo;
import com.zzj.vo.YgVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YgServiceImp implements YgService{
    @Autowired
    YgDao ygDao;

    @Override
    public YgVo dl(YgVo ygVo) {
        return ygDao.dl(ygVo);
    }

    @Override
    public List<YgVo> cx(YgVo ygVo, int page, int rows) {
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        return ygDao.cx(ygVo);
    }

    @Override
    public PageVo<YgVo>  cxsy(YgVo ygVo, int page, int rows) {
        PageVo<YgVo> pageVo = new PageVo<>();

        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(ygDao.cx(ygVo));
        //获取总的记录数量
        pageVo.setTotal(ygDao.cxsy(ygVo));
        return pageVo;
    }

    @Override
    public int add(YgVo ygVo) {
        return ygDao.add(ygVo);
    }

    @Override
    public int xg(YgVo ygVo) {
        return ygDao.xg(ygVo);
    }

    @Override
    public YgVo idcx(int yid) {
        return ygDao.idcx(yid);
    }

    @Override
    public int del(int yid) {
        return ygDao.del(yid);
    }
}
