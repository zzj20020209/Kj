package com.zzj.service;

import com.github.pagehelper.PageHelper;
import com.zzj.dao.YwyDao;
import com.zzj.vo.Kc;
import com.zzj.vo.PageVo;
import com.zzj.vo.Ywy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YwyServiceImp implements YwyService{

    @Autowired
    YwyDao ywyDao;

    @Override
    public List<Ywy> ywycx(Ywy ywy, int page, int rows) {
        PageHelper.startPage(page, rows);
        return ywyDao.ywycx(ywy);
    }

    @Override
    public PageVo<Ywy> ywycxfy(Ywy ywy, int page, int rows) {
        PageVo<Ywy> pageVo = new PageVo<>();

        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(ywyDao.ywycx(ywy));
        //获取总的记录数量
        pageVo.setTotal(ywyDao.ywycxfy(ywy));
        return pageVo;
    }

    @Override
    public int ywydel(int ywyid) {
        return ywyDao.ywydel(ywyid);
    }

    @Override
    public int ywyadd(Ywy ywy) {
        return ywyDao.ywyadd(ywy);
    }

    @Override
    public Ywy ywyidcx(int ywyid) {
        return ywyDao.ywyidcx(ywyid);
    }
}
