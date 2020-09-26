package com.zzj.controller;


import com.zzj.service.KcService;
import com.zzj.vo.Kc;
import com.zzj.vo.PageVo;
import com.zzj.vo.Shangping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class KcController {
    @Autowired
    KcService kcService;

    @RequestMapping("/kccx")
    @ResponseBody
    public List<Kc> kccx(){
        return kcService.kccxsy();
    }


    @RequestMapping("/kccxfy")
    @ResponseBody
    public PageVo<Kc> kccxfy(Kc kc,
                                  @RequestParam(value = "page",defaultValue = "1") int page,
                                  @RequestParam(value = "rows",defaultValue = "5")int rows){
        return kcService.kccxfy(kc,page,rows);
    }

    @RequestMapping("/kcsc")
    @ResponseBody
    public Map kcdel(String ids){
        Map<String,String> map=new HashMap<String,String>();
        String[] midss = ids.split(",");
        int id=0;
        for (int i=0;i<midss.length;i++){
            id=kcService.kcdel(Integer.parseInt(midss[i]));
        }
        map.put("msg","删除失败");
        if(id!=0){
            map.put("msg","删除成功");
        }
        return map;
    }

    @RequestMapping(value = "/kcadd",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String kcadd(Kc kc){
        System.out.println(kc);
        Kc kk= kcService.kcidcx(kc.getKid());
        if(kk==null){
            System.out.println(kk);
            int num=kcService.kcadd(kc);
            if(num==1){
                return "添加成功";
            }
        }
        return "添加失败";
    }
}
