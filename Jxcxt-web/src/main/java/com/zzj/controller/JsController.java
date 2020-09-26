package com.zzj.controller;

import com.zzj.service.JueseService;
import com.zzj.vo.Juese;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Arrays;
import java.util.List;

@Controller
public class JsController {
    @Autowired
    JueseService jueseService;

    //首页显示左边菜单的
    @RequestMapping("/queryallroles.action")
    @ResponseBody
    public List<Juese> jscxsy() {
        return jueseService.jscxsy();
    }

    @RequestMapping(value = "/shouquan.action", produces = "text/json;charset=utf-8")
    @ResponseBody
    public String shouquan(Integer jid, String mids) {
        String[] midss = mids.split(",");   //演示需要  该代码 放入service层
        jueseService.del(jid);
        System.out.println(Arrays.toString(midss));
        for (int i=0;i<midss.length;i++) {
            jueseService.add(jid, Integer.parseInt(midss[i]));
        }

        //service
        //  根据rid  删除权限表所有数据
        //  rid   mid数组  插入数据库
        return "授权成功";
    }
}
