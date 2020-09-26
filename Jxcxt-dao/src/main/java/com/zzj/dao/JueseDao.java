package com.zzj.dao;

import com.zzj.vo.Juese;

import java.util.List;
import java.util.Map;

public interface JueseDao {
    //查询所有角色信息
    public List<Juese> jscxsy();

    //根据用户id，查询所拥有的角色
    public List<Juese> jsidcx(int yid);

    //根据角色ID来删除该角色下的菜单
    public int del(int jid);

    //根据角色ID增加菜单权限
    public int add(Map map);
}
