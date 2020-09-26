package com.zzj.service;

import com.zzj.vo.PageVo;
import com.zzj.vo.YgVo;

import java.util.List;

public interface YgService {
    public YgVo dl(YgVo ygVo);
    public List<YgVo> cx(YgVo ygVo,int page,int rows);
    public PageVo<YgVo> cxsy(YgVo ygVo, int page, int rows);
    public int add(YgVo ygVo);
    public int xg(YgVo ygVo);
    public YgVo idcx(int yid);
    public int del(int yid);
}
