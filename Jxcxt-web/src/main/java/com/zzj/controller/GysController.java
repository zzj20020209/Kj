package com.zzj.controller;


import com.zzj.service.GysService;
import com.zzj.vo.Gys;
import com.zzj.vo.Kc;
import com.zzj.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GysController {

    @Autowired
    GysService gysService;

    @RequestMapping("/gyscx")
    @ResponseBody
    public List<Gys> gyscx(Gys gys,
                          @RequestParam(value = "page",defaultValue = "1") int page,
                          @RequestParam(value = "rows",defaultValue = "5")int rows){
        return gysService.gyscx(gys,page,rows);
    }


    @RequestMapping("/gyscxfy")
    @ResponseBody
    public PageVo<Gys> gyscxfy(Gys gys,
                             @RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "rows",defaultValue = "5")int rows){
        return gysService.gyscxfy(gys,page,rows);
    }

    @RequestMapping("/gyssc")
    @ResponseBody
    public Map gysdel(String ids){
        Map<String,String> map=new HashMap<String,String>();
        String[] midss = ids.split(",");
        int id=0;
        for (int i=0;i<midss.length;i++){
            id=gysService.gysdel(Integer.parseInt(midss[i]));
            gysService.gysdelsp(Integer.parseInt(midss[i]));
        }
        map.put("msg","删除失败");
        if(id!=0){
            map.put("msg","删除成功");
        }
        return map;
    }

    @RequestMapping(value = "/gysadd",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String gysadd(Gys gys){
        System.out.println(gys);
        Gys g= gysService.gysidcx(gys.getGid());
            System.out.println(g);
            int num=gysService.gysadd(gys);
            if(num==1){
                return "添加成功";
            }
        return "添加失败";
    }

    @RequestMapping("/gyscxid")
    @ResponseBody
    public Gys gyscxid(int gid){
        return gysService.gysidcx(gid);
    }

    @RequestMapping(value = "/gysxg",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String gysxg(Gys gys ){
        int sp=gysService.gysxg(gys);
        if(sp!=1){
            return "修改失败";
        }
        return "修改成功";
    }
}
