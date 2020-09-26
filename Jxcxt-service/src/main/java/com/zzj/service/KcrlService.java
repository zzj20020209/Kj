package com.zzj.service;

import com.zzj.vo.*;

import java.util.List;

public interface KcrlService {
    public List<Kcrlb> kcrlcx(Kcrlb kcrlb, int page, int rows);
    public PageVo<Kcrlb> kcrlcxfy(Kcrlb kcrlb, int page, int rows);
    public Cglj idcxs(int cgddid);
    public List<Kcrlb> cxkid(int kid);
    public int xgspsl(Kcrlb kcrlb);
    public List<Ddb> ddbcxs(int cgddid);
    public int kcrladd(Kcrlb kcrlb);
    public int sqrk(int cgddid);
}
