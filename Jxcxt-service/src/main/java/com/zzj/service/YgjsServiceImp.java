package com.zzj.service;

import com.github.pagehelper.PageHelper;
import com.zzj.dao.YgjsDao;
import com.zzj.vo.PageVo;
import com.zzj.vo.YgVo;
import com.zzj.vo.Ygjs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class YgjsServiceImp implements YgjsService{

    @Autowired
    YgjsDao ygjsDao;

    @Override
    public List<Ygjs> ygjscx(Ygjs ygjs, int page, int rows) {
        PageHelper.startPage(page, rows);
        return ygjsDao.ygjscx(ygjs);
    }

    @Override
    public PageVo<Ygjs> ygjscxsy(Ygjs ygjs, int page, int rows) {
        PageVo<Ygjs> pageVo = new PageVo<>();

        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(ygjsDao.ygjscx(ygjs));
        //获取总的记录数量
        pageVo.setTotal(ygjsDao.ygjscxsy(ygjs));
        return pageVo;
    }

    @Override
    public List<Ygjs> ygjscxid(int yid) {
        return ygjsDao.ygjscxid(yid);
    }

    @Override
    public int ygjsadd(Ygjs ygjs) {
        return ygjsDao.ygjsadd(ygjs);
    }

    @Override
    public int ygjsdel(int id) {
        return ygjsDao.ygjsdel(id);
    }
}
