package com.manage.controller;

import com.manage.pojo.ApplyInfo;
import com.manage.service.ApplyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/recruit")
public class RecruitController {
    @Autowired
    ApplyInfoService applyInfoService;


    //访问recruit页面

    @RequestMapping("/list")
    public String list(ApplyInfo apply, ModelMap m){
        //查询分页
        HashMap<String,Object> map = applyInfoService.select(apply);
        //数据局传到前端
        m.put("info",map);
        //将用户输入的条件传到前端
        m.put("vv",apply.getConValue());
        return "recruitment/recruit";
    }

    @RequestMapping("/down")
    @ResponseBody
    public HashMap<String,Object> down(ApplyInfo apply){
        HashMap<String,Object> map = new HashMap<String,Object>();
        HashMap<String,Object> m= applyInfoService.findAll(apply);
        //数据局传到前端
        map.put("info",m);
        return map;
    }

    //打开修改页面
    @RequestMapping("/editPage")
    public String editPage(ApplyInfo apply, ModelMap m){
        //根据applyid查询
        ApplyInfo u = applyInfoService.selectByApplyId(apply);
        //把数据传到前端
        m.addAttribute("apply",u);

        return "recruitment/editPage";
    }

    //打开评价页面
    @RequestMapping("/evaluatePage")
    public String evaluatePage(ApplyInfo apply, ModelMap m){
        //根据applyid查询
        ApplyInfo u = applyInfoService.selectByApplyId(apply);
        //把数据传到前端
        m.addAttribute("apply",u);

        return "recruitment/evaluatePage";
    }

    //打开添加页面
    @RequestMapping("/addPage")
    public String addPage(){

        return "recruitment/addPage";
    }

    //修改
    @RequestMapping("/edit")
    @ResponseBody
    public HashMap<String,Object> edit(ApplyInfo apply){
        HashMap<String,Object> map=new HashMap<String,Object>();
        String info=applyInfoService.update(apply);
        map.put("info",info);
        return map;
    }

    //评价
    @RequestMapping("/evaluate")
    @ResponseBody
    public HashMap<String,Object> evaluate(ApplyInfo apply){
        HashMap<String,Object> map=new HashMap<String,Object>();
        String info=applyInfoService.evaluate(apply);
        map.put("info",info);
        return map;
    }

    //删除
    @RequestMapping("/del")
    @ResponseBody
    public HashMap<String,Object> del(ApplyInfo apply){
        HashMap<String,Object> map = new HashMap<String,Object>();
        String info = applyInfoService.del(apply);
        map.put("info",info);
        return map;
    }


    //添加
    @RequestMapping("/addApply")
    @ResponseBody()
    public HashMap<String,Object> addApply(ApplyInfo apply){
        HashMap<String,Object> map = new HashMap<String,Object>();
        String info = applyInfoService.add(apply);
        map.put("info",info);
        return map;
    }
}
