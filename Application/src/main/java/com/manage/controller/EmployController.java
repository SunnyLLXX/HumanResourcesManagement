package com.manage.controller;

import com.manage.pojo.ApplyInfo;
import com.manage.pojo.EmployInfo;
import com.manage.service.ApplyInfoService;
import com.manage.service.EmployInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/employ")
public class EmployController {
    @Autowired
    EmployInfoService employInfoService;


    //访问employPage页面

    @RequestMapping("/list")
    public String list(EmployInfo employ, ModelMap m){
        //查询分页
        HashMap<String,Object> map = employInfoService.select(employ);
        //数据局传到前端
        m.put("info",map);
        //将用户输入的条件传到前端
        m.put("vv",employ.getConValue());
        return "recruitment/employPage";
    }

    @RequestMapping("/down")
    @ResponseBody
    public HashMap<String,Object> down(EmployInfo employ){
        HashMap<String,Object> map = new HashMap<String,Object>();
        HashMap<String,Object> m= employInfoService.findAll(employ);
        //数据局传到前端
        map.put("info",m);
        return map;
    }

    //删除
    @RequestMapping("/del")
    @ResponseBody
    public HashMap<String,Object> del(EmployInfo employ){
        HashMap<String,Object> map = new HashMap<String,Object>();
        String info = employInfoService.del(employ);
        map.put("info",info);
        return map;
    }

    //入岗
    @RequestMapping("/position")
    @ResponseBody()
    public HashMap<String,Object> position(EmployInfo employ){
        HashMap<String,Object> map = new HashMap<String,Object>();
        String info = employInfoService.position(employ);
        map.put("info",info);
        return map;
    }

    @RequestMapping("/data")
    public String data(){
        return "recruitment/dataCount";
    }

    //处理柱状图ajax
    @RequestMapping("/count")
    @ResponseBody
    public HashMap<String, Object> count(){
        return employInfoService.count();
    }
}
