package com.zzj.dao;

import com.zzj.vo.Cd;
import com.zzj.vo.Juese;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CdDao {
    public List<Cd> cx(@Param("zid") int zid, @Param("yid") int yid);

    //根据角色id，去权限表 查询 拥有的菜单列表
    public  List<Cd> cxjid(int jid);

    public List<Cd> kscd(int zid);
}
