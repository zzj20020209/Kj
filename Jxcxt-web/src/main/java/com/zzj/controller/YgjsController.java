package com.zzj.controller;

import com.zzj.service.YgjsService;
import com.zzj.vo.PageVo;
import com.zzj.vo.Shangping;
import com.zzj.vo.YgVo;
import com.zzj.vo.Ygjs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class YgjsController {

    @Autowired
    YgjsService ygjsService;

    @RequestMapping("/ygjscxsy")
    @ResponseBody
    public List<Ygjs> cxsy(Ygjs ygjs,
                           @RequestParam(value = "page",defaultValue = "1") int page,
                           @RequestParam(value = "rows",defaultValue = "5")int rows){
        return ygjsService.ygjscx(ygjs,page,rows);
    }


    @RequestMapping("/ygjscxsl")
    @ResponseBody
    public PageVo<Ygjs> cxsl(Ygjs ygjs,
                             @RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "rows",defaultValue = "5")int rows){
        return ygjsService.ygjscxsy(ygjs,page,rows);
    }

    @RequestMapping("/ygjscxid")
    @ResponseBody
    public List<Ygjs> cxid(int yid){
        return ygjsService.ygjscxid(yid);
    }

    @RequestMapping(value = "/ygjsadd",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String ygjsadd(Ygjs ygjs){
        List<Ygjs> yg=ygjsService.ygjscxid(ygjs.getYid());
        for (Ygjs y:yg){
            if(ygjs.getJid()==y.getJid()){
                return "该员工已有该角色";
            }
        }
        ygjsService.ygjsadd(ygjs);
        return "添加成功";
    }

    @RequestMapping("/ygjssc")
    @ResponseBody
    public Map ygdel(String ids){
        Map<String,String> map=new HashMap<String,String>();
        String[] midss = ids.split(",");
        int id=0;
        for (int i=0;i<midss.length;i++){
            id=ygjsService.ygjsdel(Integer.parseInt(midss[i]));
        }
        map.put("msg","删除失败");
        if(id!=0){
            map.put("msg","删除成功");
        }
        return map;
    }
}
