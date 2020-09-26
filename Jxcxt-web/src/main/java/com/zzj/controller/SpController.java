package com.zzj.controller;

import com.zzj.service.SpService;
import com.zzj.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SpController {
    @Autowired
    SpService spService;

    @RequestMapping("/spcx")
    @ResponseBody
    public List<Shangping> spcxs(){
        return spService.spcxs();
    }

    @RequestMapping("/splx")
    @ResponseBody
    public List<Splx> splx(){
        return spService.splx();
    }

    @RequestMapping("/wsplx")
    @ResponseBody
    public List<Splx> wsplx(){
        return spService.wsplx();
    }

    @RequestMapping("/spcd")
    @ResponseBody
    public List<Gys> sp(){
        return spService.spgys();
    }

    @RequestMapping("/spcxsy")
    @ResponseBody
    public List<Shangping> cxsy(Shangping shangping,
                                @RequestParam(value = "page",defaultValue = "1") int page,
                                @RequestParam(value = "rows",defaultValue = "5")int rows){
        return spService.spcx(shangping,page,rows);
    }


    @RequestMapping("/spcxsl")
    @ResponseBody
    public PageVo<Shangping> cxsl(Shangping shangping,
                             @RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "rows",defaultValue = "5")int rows){
        return spService.spcxsy(shangping,page,rows);
    }

    @RequestMapping("/spcxid")
    @ResponseBody
    public Shangping idcx(int spid){
        return spService.spidcx(spid);
    }

    @RequestMapping("/cgys")
    @ResponseBody
    public List<Shangping> cgys(Shangping shangping){
        return spService.cgys(shangping);
    }

    @RequestMapping("/spsc")
    @ResponseBody
    public Map spdel(String ids){
        Map<String,String> map=new HashMap<String,String>();
        String[] midss = ids.split(",");
        int id=0;
        for (int i=0;i<midss.length;i++){
            id=spService.spdel(Integer.parseInt(midss[i]));
        }
        map.put("msg","删除失败");
        if(id!=0){
            map.put("msg","删除成功");
        }
        return map;
    }

    @RequestMapping(value = "/spadd",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String spadd(Shangping shangping){
        System.out.println(shangping);
        spService.spadd(shangping);

        return "添加成功";
    }

    @RequestMapping(value = "/spxg",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String spxg(Shangping shangping){
        int sp=spService.spxg(shangping);
        System.out.println(sp);
        if(sp!=1){
            return "修改失败";
        }
        return "修改成功";
    }
}
