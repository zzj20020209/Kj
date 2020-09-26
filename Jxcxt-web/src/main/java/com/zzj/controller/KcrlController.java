package com.zzj.controller;

import com.zzj.service.DdbService;
import com.zzj.service.KcrlService;
import com.zzj.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class KcrlController {

    @Autowired
    KcrlService kcrlService;


    @RequestMapping("/kcrlcxfy")
    @ResponseBody
    public PageVo<Kcrlb> kcrlcxfy(Kcrlb kcrlb,
                             @RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "rows",defaultValue = "5")int rows){
        return kcrlService.kcrlcxfy(kcrlb,page,rows);
    }

    @RequestMapping(value = "/kcrladd",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String kcrladd(@RequestParam(value = "cgddid",defaultValue = "0") int cgddid,
                          @RequestParam(value = "kid",defaultValue = "0") int kid){
        Kcrlb kcrlb=new Kcrlb();
        Cglj cglj=kcrlService.idcxs(cgddid);
        if(cglj.getRkzt()==1){
            return "该订单商品已入库";
        }
        kcrlService.sqrk(cgddid);
        List<Ddb> da= kcrlService.ddbcxs(cgddid);
        List<Kcrlb> kc=kcrlService.cxkid(kid);
        for (Ddb d:da){
            kcrlb.setSpname(d.getSpname());
            kcrlb.setSl(d.getSpsl());
            kcrlb.setKid(kid);
            boolean bo =true;
            for (Kcrlb k:kc){
                bo=false;
                if(d.getSpname().equals(k.getSpname())){
                    kcrlService.xgspsl(kcrlb);
                }
            }
            if (bo){
                kcrlService.kcrladd(kcrlb);
            }
        }
        return "入库成功";
    }
}
