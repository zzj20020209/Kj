package com.zzj.dao;

import com.zzj.vo.Gys;
import com.zzj.vo.Kh;

import java.util.List;

public interface KhDao {
    public List<Kh> khcx(Kh kh);
    public int khcxfy(Kh kh);
    public int khsc(int khid);
    public int addkh(Kh kh);
    public Kh ckkhid(int khid);
    public int xgkh(Kh kh);
}
