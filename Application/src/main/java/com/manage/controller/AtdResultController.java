package com.manage.controller;

import com.manage.pojo.AtdResult;
import com.manage.service.AtdResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/atdresult")
public class AtdResultController {

    @Autowired
    AtdResultService atdResultService;

    //访问饼图页面
    @RequestMapping("/bing")
    public String bing(){
        return "atdresult/picture";
    }

    //处理饼图的ajax数据
    @RequestMapping("/bingAjax")
    @ResponseBody
    public HashMap<String,Object> bingAjax(AtdResult atdResult){
        return atdResultService.bing(atdResult);
    }

}
