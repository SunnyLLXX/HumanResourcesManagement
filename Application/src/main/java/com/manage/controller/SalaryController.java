package com.manage.controller;

import com.manage.pojo.AtdResult;
import com.manage.pojo.Salary;
import com.manage.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/salary")
public class SalaryController {
    @Autowired
    SalaryService salaryService;

    //访问薪酬页面
    @RequestMapping("/base")
    public String list(Salary salary, ModelMap modelMap) {
        // 查询分页数据
        HashMap<String, Object> map=salaryService.select(salary);
        // 把数据传给前端
        modelMap.put("info", map);
        return "salary/salary-info";
    }

    // 打开修改页面
    @RequestMapping("/editPage")
    public String editPage(Salary salary, ModelMap modelMap) {
        //根据userId查询
        Salary e = salaryService.selectById(salary);
        //数据传递给前端
        modelMap.addAttribute("info", e);
        return "salary/salary-edit";

    }

    //打开新增页面
    @RequestMapping("/addPage")
    public String addPage() {
        return "salary/salary-add";
    }

    //
    //访问饼图页面
    @RequestMapping("/bing")
    public String bing(){
        return "salary/picture";
    }

    //处理饼图的ajax数据
    @RequestMapping("/bingAjax")
    @ResponseBody
    public HashMap<String,Object> bingAjax(Salary salary){return salaryService.bing(salary); }


    //处理修改的ajax请求
    @RequestMapping("/edit")
    @ResponseBody
    public HashMap<String,Object> edit(Salary salary){
        HashMap<String,Object> map = new HashMap<String,Object>();
        String info = salaryService.update(salary);
        map.put("info",info);
        return map;
    }

    //处理表格的ajax数据
    @RequestMapping("/listAjax")
    @ResponseBody
    public HashMap<String,Object> listAjax(Salary salary){
        return salaryService.select(salary);
    }

    // 处理增加员工数据的Ajax请求
    @RequestMapping("/addInfo")
    @ResponseBody
    public HashMap<String, Object> addInfo(Salary salary) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        String info = salaryService.addInfo(salary);
        map.put("info", info);
        return map;
    }

    //处理删除的ajax请求
    @RequestMapping("/del")
    @ResponseBody
    public HashMap<String,Object> del(Salary salary){
        HashMap<String,Object> map = new HashMap<String,Object>();
        String info = salaryService.del(salary);
        map.put("info",info);
        return map;
    }
}
