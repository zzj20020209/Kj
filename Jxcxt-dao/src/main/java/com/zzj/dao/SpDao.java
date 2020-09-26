package com.zzj.dao;


import com.zzj.vo.Gys;
import com.zzj.vo.Shangping;
import com.zzj.vo.Spcd;
import com.zzj.vo.Splx;

import java.util.List;

public interface SpDao {
    //商品类型查询
    public List<Splx> splx();
    //商品产地查询
    public List<Gys> spgys();
    public List<Shangping> spcx(Shangping shangping);
    public List<Shangping> spcxs();
    public List<Shangping> cgys(Shangping shangping);
    public int spcxsy(Shangping shangping);
    public int spadd(Shangping shangping);
    public int spxg(Shangping shangping);
    public Shangping spidcx(int spid);
    public int spdel(int spid);
}
