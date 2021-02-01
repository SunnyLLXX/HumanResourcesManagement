package com.manage.controller;

import com.manage.pojo.EmployeeInfo;
import com.manage.service.EmpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

/**
 * 人员档案及人事调配所用
 *
 * @author 张杰
 */
@Controller
@RequestMapping("/empInfo")
public class EmpInfoController {
    @Autowired
    EmpInfoService empInfoService;

    // 访问员工基本信息维护页面
    @RequestMapping("/baseInfoManagement")
    public String list(EmployeeInfo employeeInfo, ModelMap modelMap) {
        // 查询分页数据
        HashMap<String, Object> map = empInfoService.selectInfo(employeeInfo);
        // 把数据传给前端
        modelMap.put("info",map);
        return "empInfo/base-info-management";
    }

    // 打开修改页面
    @RequestMapping("/editPage")
    public String editPage(EmployeeInfo employeeInfo, ModelMap modelMap) {
        //根据userId查询
        EmployeeInfo e = empInfoService.selectInfoById(employeeInfo);
        //数据传递给前端
        modelMap.addAttribute("info",e);
        return "empInfo/edit-info";
    }

    // 处理修改员工数据的Ajax请求
    @RequestMapping("/editAjax")
    public HashMap<String,Object> editAjax(EmployeeInfo employeeInfo){
        HashMap<String ,Object> map = new HashMap<String,Object>();
        String info = empInfoService.updateInfo(employeeInfo);
        map.put("info",info);
        return map;
    }
}
