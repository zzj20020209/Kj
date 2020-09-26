package com.zzj.dao;

import com.zzj.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KcrlDao {
    public List<Kcrlb> kcrlcx(Kcrlb kcrlb);
    public int kcrlcxfy(Kc kc);
    public Cglj idcxs(int cgddid);
    public List<Kcrlb> cxkid(int kid);
    public int xgspsl(Kcrlb kcrlb);
    public List<Ddb> ddbcxs(int cgddid);
    public int kcrladd(Kcrlb kcrlb);
    public int kcrlcxfy(Kcrlb kcrlb);
    public int sqrk(int cgddid);
}
