package com.zzj.service;

import com.github.pagehelper.PageHelper;
import com.zzj.dao.GysDao;
import com.zzj.vo.Gys;
import com.zzj.vo.Kc;
import com.zzj.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GysServiceImp implements GysService{

    @Autowired
    GysDao gysDao;

    @Override
    public List<Gys> gyscx(Gys gys, int page, int rows) {
        PageHelper.startPage(page, rows);
        return gysDao.gyscx(gys);
    }

    @Override
    public PageVo<Gys> gyscxfy(Gys gys, int page, int rows) {
        PageVo<Gys> pageVo = new PageVo<>();

        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(gysDao.gyscx(gys));
        //获取总的记录数量
        pageVo.setTotal(gysDao.gyscxfy(gys));
        return pageVo;
    }

    @Override
    public int gysdel(int gid) {
        return gysDao.gysdel(gid);
    }

    @Override
    public int gysdelsp(int gid) {
        return gysDao.gysdelsp(gid);
    }

    @Override
    public int gysadd(Gys gys) {
        return gysDao.gysadd(gys);
    }

    @Override
    public Gys gysidcx(int gid) {
        return gysDao.gysidcx(gid);
    }

    @Override
    public int gysxg(Gys gys) {
        return gysDao.gysxg(gys);
    }

}
