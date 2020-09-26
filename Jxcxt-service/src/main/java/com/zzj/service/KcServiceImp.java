package com.zzj.service;

import com.github.pagehelper.PageHelper;
import com.zzj.dao.KcDao;
import com.zzj.vo.Kc;
import com.zzj.vo.PageVo;
import com.zzj.vo.Shangping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KcServiceImp implements KcService{

    @Autowired
    KcDao kcDao;

    @Override
    public List<Kc> kccx(Kc kc, int page, int rows) {
        PageHelper.startPage(page, rows);
        return kcDao.kccx(kc);
    }

    @Override
    public PageVo<Kc> kccxfy(Kc kc, int page, int rows) {
        PageVo<Kc> pageVo = new PageVo<>();

        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(kcDao.kccx(kc));
        //获取总的记录数量
        pageVo.setTotal(kcDao.kccxfy(kc));
        return pageVo;
    }

    @Override
    public List<Kc> kccxsy() {
        return kcDao.kccxsy();
    }

    @Override
    public int kcdel(int kid) {
        return kcDao.kcdel(kid);
    }

    @Override
    public int kcadd(Kc kc) {
        return kcDao.kcadd(kc);
    }

    @Override
    public Kc kcidcx(int kid) {
        return kcDao.kcidcx(kid);
    }

}
