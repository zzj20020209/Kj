package com.zzj.service;

import com.zzj.vo.PageVo;
import com.zzj.vo.Ywy;

import java.util.List;

public interface YwyService {
    public List<Ywy> ywycx(Ywy ywy, int page, int rows);
    public PageVo<Ywy> ywycxfy(Ywy ywy, int page, int rows);
    public int ywydel(int ywyid);
    public int ywyadd(Ywy ywy);
    public Ywy ywyidcx(int ywyid);
}
