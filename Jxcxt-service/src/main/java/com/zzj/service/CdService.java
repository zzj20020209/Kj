package com.zzj.service;

import com.zzj.vo.Cd;
import com.zzj.vo.Juese;

import java.util.List;

public interface CdService {
    public List<Cd> cx(int zid,int yid);

    //查询所有的菜单数据 组装好的 父子菜单数据
    //根据角色id 设置子菜单的选中状态
    public List<Cd> cxcd(int jid);

    public List<Cd> kscd(int zid);
}
