package com.zzj.service;

import com.zzj.vo.Gys;
import com.zzj.vo.Kc;
import com.zzj.vo.Kh;
import com.zzj.vo.PageVo;

import java.util.List;

public interface KhService {
    public List<Kh> khcx(Kh kh, int page, int rows);
    public PageVo<Kh> khcxfy(Kh kh, int page, int rows);
    public int khsc(int khid);
    public int addkh(Kh kh);
    public Kh ckkhid(int khid);
    public int xgkh(Kh kh);
}
