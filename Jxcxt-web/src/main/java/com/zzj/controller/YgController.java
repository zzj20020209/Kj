package com.zzj.controller;

import com.zzj.service.YgService;
import com.zzj.vo.PageVo;
import com.zzj.vo.Shangping;
import com.zzj.vo.YgVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class YgController {
    @Autowired
    YgService ygService;


    @RequestMapping("/cxid")
    @ResponseBody
    public YgVo idcx(int yid){
        return ygService.idcx(yid);
    }


    @RequestMapping("/cxsy")
    @ResponseBody
    public List<YgVo> cxsy(YgVo ygVo,String sex,
                           @RequestParam(value = "page",defaultValue = "1") int page,
                           @RequestParam(value = "rows",defaultValue = "5")int rows){
        return ygService.cx(ygVo,page,rows);
    }


    @RequestMapping("/cxsl")
    @ResponseBody
    public PageVo<YgVo> cxsl(YgVo ygVo,String sex,
                             @RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "rows",defaultValue = "5")int rows){
        return ygService.cxsy(ygVo,page,rows);
    }

    @RequestMapping(value = "/add",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String add(YgVo ygVo){
        ygService.add(ygVo);
        return "添加成功";
    }

    @RequestMapping(value = "/dl",produces = {"application/json;charset=utf-8"})
    public String dl(HttpServletRequest request , YgVo ygVo){

        HttpSession session=request.getSession();

        ygVo=ygService.dl(ygVo);
        String str="dl.jsp";
        if(ygVo!=null){
            session.setAttribute("username",ygVo.getYname());
            session.setAttribute("yid",ygVo.getYid());
            session.setAttribute("yg",ygVo);
            str="Shouye.jsp";
        }
        if(str=="dl.jsp"){
            session.setAttribute("dlxx","账号或密码错误，请重新登录！！！");
        }else {
            session.setAttribute("dlxx","登录成功");
        }
        return str;
    }
    @RequestMapping("/ygsc")
    @ResponseBody
    public Map ygdel(String ids,HttpServletRequest request){
        HttpSession session=request.getSession();
        Map<String,String> map=new HashMap<String,String>();
        String[] midss = ids.split(",");
        int id=0;
        YgVo ygVo= (YgVo) session.getAttribute("yg");

        for (int i=0;i<midss.length;i++){
            if(Integer.parseInt(midss[i])==ygVo.getYid()){
                System.out.println("aaa");
                map.put("msg","不能解雇自己");
                break;
            }else {
                id=ygService.del(Integer.parseInt(midss[i]));
            }
        }
        if(id!=0){
            map.put("msg","已解雇");
        }
        return map;
    }

    @RequestMapping(value = "/xg",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String xg(YgVo ygVo){
        int sp=ygService.xg(ygVo);
        System.out.println(sp);
        if(sp!=1){
            return "修改失败";
        }
        return "修改成功";
    }
}
