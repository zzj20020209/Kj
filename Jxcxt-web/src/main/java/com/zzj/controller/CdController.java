package com.zzj.controller;

import com.zzj.service.CdService;
import com.zzj.vo.Cd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CdController {
    @Autowired
    CdService cdService;

    @RequestMapping("/cxcd")
    @ResponseBody
    public List<Cd> cxsy(@RequestParam(value = "id", defaultValue = "0") int id,int yid){
        return cdService.cx(id,yid);
    }

    //授权页面  显示菜单所有数据  包含子节点的选中状态
    @RequestMapping("/qxcd")
    @ResponseBody
    public List<Cd> querymenus(
            @RequestParam(value = "jid", defaultValue = "0") int jid) {
        System.out.println("角色id："+jid);
        List<Cd> cds=cdService.cxcd(jid);
        for (Cd c:cds) {
            System.out.println(c);
        }
        return cdService.cxcd(jid);
    }
}
