package com.zzj.controller;

import com.zzj.service.CgdService;
import com.zzj.service.CgljService;
import com.zzj.vo.Cglj;
import com.zzj.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CgdController {

    @Autowired
    CgdService cgdService;

    @RequestMapping("/cgdcxsy")
    @ResponseBody
    public List<Cglj> cgdcxsy(Cglj cglj,
                               @RequestParam(value = "page",defaultValue = "1") int page,
                               @RequestParam(value = "rows",defaultValue = "5")int rows){
        System.out.println(cglj);
        return cgdService.cgdcx(cglj,page,rows);
    }


    @RequestMapping("/cgdcxsl")
    @ResponseBody
    public PageVo<Cglj> cgdcxsl(Cglj cglj,
                                 @RequestParam(value = "page",defaultValue = "1") int page,
                                 @RequestParam(value = "rows",defaultValue = "5")int rows){
        System.out.println(cglj);
        return cgdService.cgdcxsy(cglj,page,rows);
    }


    @RequestMapping("/rksqcx")
    @ResponseBody
    public PageVo<Cglj> rksqcx(Cglj cglj,
                                @RequestParam(value = "page",defaultValue = "1") int page,
                                @RequestParam(value = "rows",defaultValue = "5")int rows){
        return cgdService.rksqcxsy(cglj,page,rows);
    }


    @RequestMapping(value = "/cgdjh",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String cgdjh(int cgddid){
        Cglj cglj=cgdService.cxdg(cgddid);
        if(cglj.getCgzt()==2){
            return "此订单已作废!";
        }else if (cglj.getCgzt()==1){
            return "不能继续采购已采购完成的订单";
        }
        cgdService.cgdjh(cgddid);
        return "进货完成";
    }

    @RequestMapping(value = "/cgdth",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String cgdth(int cgddid){
        Cglj cglj=cgdService.cxdg(cgddid);
        if(cglj.getCgzt()==0){
            return "此订单商品还未到货!";
        }
        cgdService.cgdth(cgddid);
        return "退货完成";
    }
}
