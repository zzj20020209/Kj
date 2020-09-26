package com.zzj.controller;

import com.zzj.service.ThServcie;
import com.zzj.vo.Cglj;
import com.zzj.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ThController {

    @Autowired
    ThServcie thServcie;
    @RequestMapping("/thcx")
    @ResponseBody
    public List<Cglj> cgdcxsy(Cglj cglj,
                              @RequestParam(value = "page",defaultValue = "1") int page,
                              @RequestParam(value = "rows",defaultValue = "5")int rows){
        System.out.println(cglj);
        return thServcie.cgdcx(cglj,page,rows);
    }


    @RequestMapping("/thcxsy")
    @ResponseBody
    public PageVo<Cglj> cgdcxsl(Cglj cglj,
                                @RequestParam(value = "page",defaultValue = "1") int page,
                                @RequestParam(value = "rows",defaultValue = "5")int rows){
        System.out.println(cglj);
        return thServcie.cgdcxsy(cglj,page,rows);
    }

}
