package com.zzj.service;

import com.zzj.dao.SpDao;
import com.zzj.vo.*;

import java.util.List;

public interface SpService {
    //商品类型查询
    public List<Splx> wsplx();
    public List<Splx> splx();
    //供应商查询
    public List<Gys> spgys();
    public List<Shangping> spcx(Shangping shangping, int page, int rows);
    public List<Shangping> spcxs();
    public List<Shangping> cgys(Shangping shangping);
    public PageVo<Shangping> spcxsy(Shangping shangping, int page, int rows);
    public int spadd(Shangping shangping);
    public int spxg(Shangping shangping);
    public Shangping spidcx(int spid);
    public int spdel(int spid);
}
