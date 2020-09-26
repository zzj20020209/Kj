package com.zzj.service;

import com.zzj.dao.CdDao;
import com.zzj.dao.YgDao;
import com.zzj.vo.Cd;
import com.zzj.vo.Juese;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CdServiceImp implements CdService{

    @Autowired
    CdDao cdDao;

    @Override
    public List<Cd> cx(int zid,int yid) {
        List<Cd> menus =  cdDao.cx(zid,yid);
        //将url的值 存入attributes属性中
        for (Cd menu: menus ) {
            if(menu.getUrl()!=null && menu.getUrl()!=""){
                menu.getAttributes().put("url",menu.getUrl());
            }
        }
        return menus;
    }

    @Override
    public List<Cd> cxcd(int jid) {
        //获取当前角色id所拥有的菜单信息
        List<Cd> privmenus = cdDao.cxjid(jid);

        //获取所有的父菜单
        List<Cd> parentmenus = cdDao.kscd(0);

        System.out.println(parentmenus);
        //循环  每一个父菜单 根据id，查询出所有的子菜单
        for (Cd pmenu: parentmenus) {

            List<Cd> childmenus = cdDao.kscd(pmenu.getId());
            //循环  查询该菜单 是否选中
            for(Cd child : childmenus){
                //循环权限菜单
                for(Cd privmenu:privmenus){
                    if(child.getId() ==privmenu.getId()){  //子菜单id  == 权限表 菜单id
                        child.setChecked(true);
                        break;
                    }
                }
            }

            pmenu.setChildren(childmenus);
        }
        return parentmenus;
    }

    @Override
    public List<Cd> kscd(int zid) {
        return cdDao.kscd(zid);
    }
}
