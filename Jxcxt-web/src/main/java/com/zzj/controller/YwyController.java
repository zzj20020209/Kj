package com.zzj.controller;

import com.zzj.service.YwyService;
import com.zzj.vo.Kc;
import com.zzj.vo.PageVo;
import com.zzj.vo.Ywy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class YwyController {
    @Autowired
    YwyService ywyService;
    @RequestMapping("/ywycx")
    @ResponseBody
    public List<Ywy> ywycx(Ywy ywy,
                           @RequestParam(value = "page",defaultValue = "1") int page,
                           @RequestParam(value = "rows",defaultValue = "5")int rows){
        return ywyService.ywycx(ywy,page,rows);
    }


    @RequestMapping("/ywycxfy")
    @ResponseBody
    public PageVo<Ywy> kccxfy(Ywy ywy,
                             @RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "rows",defaultValue = "5")int rows){
        return ywyService.ywycxfy(ywy,page,rows);
    }


    @RequestMapping("/ywysc")
    @ResponseBody
    public Map ywydel(String ids){
        Map<String,String> map=new HashMap<String,String>();
        String[] midss = ids.split(",");
        int id=0;
        for (int i=0;i<midss.length;i++){
            id=ywyService.ywydel(Integer.parseInt(midss[i]));
        }
        map.put("msg","删除失败");
        if(id!=0){
            map.put("msg","删除成功");
        }
        return map;
    }

    @RequestMapping(value = "/ywyadd",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String ywyadd(Ywy ywy){
        System.out.println(ywy);
        int num=ywyService.ywyadd(ywy);
        if(num==1){
            return "添加成功";
        }
        return "添加失败";
    }
}
