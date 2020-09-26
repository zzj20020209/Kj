package com.zzj.dao;

import com.zzj.vo.Ywy;

import java.util.List;

public interface YwyDao {
    public List<Ywy> ywycx(Ywy ywy);
    public int ywycxfy(Ywy ywy);
    public int ywyadd(Ywy ywy);
    public int ywyxg(Ywy ywy);
    public Ywy ywyidcx(int ywyid);
    public int ywydel(int ywyid);
}
