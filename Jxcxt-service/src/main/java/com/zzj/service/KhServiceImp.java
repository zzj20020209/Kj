package com.zzj.service;

import com.github.pagehelper.PageHelper;
import com.zzj.dao.KhDao;
import com.zzj.vo.Gys;
import com.zzj.vo.Kc;
import com.zzj.vo.Kh;
import com.zzj.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class KhServiceImp implements KhService{

    @Autowired
    KhDao khDao;

    @Override
    public List<Kh> khcx(Kh kh, int page, int rows) {
        PageHelper.startPage(page, rows);
        return khDao.khcx(kh);
    }

    @Override
    public PageVo<Kh> khcxfy(Kh kh, int page, int rows) {
        PageVo<Kh> pageVo = new PageVo<>();

        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(khDao.khcx(kh));
        //获取总的记录数量
        pageVo.setTotal(khDao.khcxfy(kh));
        return pageVo;
    }

    @Override
    public int khsc(int khid) {
        return khDao.khsc(khid);
    }

    @Override
    public int addkh(Kh kh) {
        return khDao.addkh(kh);
    }

    @Override
    public Kh ckkhid(int khid) {
        return khDao.ckkhid(khid);
    }

    @Override
    public int xgkh(Kh kh) {
        return khDao.xgkh(kh);
    }
}
