package com.zzj.dao;

import com.zzj.vo.PageVo;
import com.zzj.vo.YgVo;

import java.util.List;

public interface YgDao {
    public YgVo dl(YgVo ygVo);
    public List<YgVo> cx(YgVo ygVo);
    public int cxsy(YgVo ygVo);
    public int add(YgVo ygVo);
    public int xg(YgVo ygVo);
    public YgVo idcx(int yid);
    public int del(int yid);
}
