package com.zzj.controller;

import com.zzj.service.CgljService;
import com.zzj.service.DdbService;
import com.zzj.vo.Cglj;
import com.zzj.vo.PageVo;
import com.zzj.vo.YgVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CgljController {
    @Autowired
    CgljService cgljService;

    @RequestMapping("/cgljcxsy")
    @ResponseBody
    public List<Cglj> cgljcxsy(Cglj cglj,
                               @RequestParam(value = "page",defaultValue = "1") int page,
                               @RequestParam(value = "rows",defaultValue = "5")int rows){
        System.out.println(cglj);
        return cgljService.cx(cglj,page,rows);
    }


    @RequestMapping("/cgljcxsl")
    @ResponseBody
    public PageVo<Cglj> cgljcxsl(Cglj cglj,
                             @RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "rows",defaultValue = "5")int rows){
        System.out.println(cglj);
        return cgljService.cxsy(cglj,page,rows);
    }

    @RequestMapping(value = "/cgljadd",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String cgljadd(Cglj cglj){
        System.out.println(cglj);
        cglj.setCgsj(new Date());
        cgljService.add(cglj);
        return "添加成功";
    }

    @RequestMapping(value = "/czjg",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String ccjg(int cgddid){
        cgljService.zjghq(cgddid);
        return "申请完毕";
    }

    @RequestMapping(value = "/ty",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String ty(int cgddid){
        Cglj cglj= cgljService.idcx(cgddid);
        if(cglj.getZt()==1 ||cglj.getZt()==2){
            return "审批过的不能再次审批";
        }
        cgljService.ty(cgddid);
        cglj.setCgdsj(new Date());
        cgljService.xgcgsj(cglj);
        return "已同意";
    }

    @RequestMapping(value = "/jj",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String jj(int cgddid){
        Cglj cglj= cgljService.idcx(cgddid);
        cgljService.jj(cgddid);
        if(cglj.getZt()==1 ||cglj.getZt()==2){
            return "审批过的不能再次审批";
        }
        return "已拒绝";
    }

    @RequestMapping("/cgljsc")
    @ResponseBody
    public Map cgljdel(String ids){
        Map<String,String> map=new HashMap<String,String>();
        String[] midss = ids.split(",");
        int id=0;
        for (int i=0;i<midss.length;i++){
            Cglj cglj= cgljService.idcx(Integer.parseInt(midss[i]));
            if(cglj.getZt()==1){
                map.put("msg","不能删除正在采购中的订单");
            }else {
                id=cgljService.del(Integer.parseInt(midss[i]));
                cgljService.dddel(Integer.parseInt(midss[i]));
            }
        }
        if(id!=0){
            map.put("msg","删除成功");
        }
        return map;
    }
}
