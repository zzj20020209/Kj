package com.zzj.controller;

import com.zzj.service.KhService;
import com.zzj.vo.Gys;
import com.zzj.vo.Kh;
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
public class KhController {

    @Autowired
    KhService khService;

    @RequestMapping("/khcx")
    @ResponseBody
    public List<Kh> gyscx(Kh kh,
                           @RequestParam(value = "page",defaultValue = "1") int page,
                           @RequestParam(value = "rows",defaultValue = "5")int rows){
        return khService.khcx(kh,page,rows);
    }


    @RequestMapping("/khcxfy")
    @ResponseBody
    public PageVo<Kh> gyscxfy(Kh kh,
                               @RequestParam(value = "page",defaultValue = "1") int page,
                               @RequestParam(value = "rows",defaultValue = "5")int rows){
        return khService.khcxfy(kh,page,rows);
    }

    @RequestMapping("/ckkhid")
    @ResponseBody
    public Kh khcxid(int khid){
        return khService.ckkhid(khid);
    }

    @RequestMapping("/khsc")
    @ResponseBody
    public Map khsc(String ids){
        Map<String,String> map=new HashMap<String,String>();
        String[] midss = ids.split(",");
        int id=0;
        for (int i=0;i<midss.length;i++){
            id=khService.khsc(Integer.parseInt(midss[i]));
        }
        map.put("msg","删除失败");
        if(id!=0){
            map.put("msg","删除成功");
        }
        return map;
    }

    @RequestMapping(value = "/khadd",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String khadd(Kh kkh){
        khService.addkh(kkh);
        return "添加成功";
    }

    @RequestMapping(value = "/khxg",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String khxg(Kh kh){
        int sp=khService.xgkh(kh);
        if(sp!=1){
            return "修改失败";
        }
        return "修改成功";
    }
}
