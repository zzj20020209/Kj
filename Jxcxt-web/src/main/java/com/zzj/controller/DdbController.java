package com.zzj.controller;

import com.zzj.service.DdbService;
import com.zzj.vo.Ddb;
import com.zzj.vo.Gys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DdbController {

    @Autowired
    DdbService ddbService;

    @RequestMapping("/ddbcx")
    @ResponseBody
    public List<Ddb> ddvcx(int cgddid){
        return ddbService.ddbcx(cgddid);
    }

    @RequestMapping("/ddbsc")
    @ResponseBody
    public Map ddvsc(String ids){
        Map<String,String> map=new HashMap<String,String>();
        String[] midss = ids.split(",");
        int id=0;
        for (int i=0;i<midss.length;i++){
            id=ddbService.ddbdel(Integer.parseInt(midss[i]));
        }
        map.put("msg","删除失败");
        if(id!=0){
            map.put("msg","删除成功");
        }
        return map;
    }

    @RequestMapping(value = "/ddbadd",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String ddvadd(Ddb ddb){
        int num=ddbService.ddbadd(ddb);
        if(num==1){
            return "添加成功";
        }
        return "添加失败";
    }
}
