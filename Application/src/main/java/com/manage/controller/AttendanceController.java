package com.manage.controller;

import com.manage.pojo.AttendanceInfo;
import com.manage.service.AttendanceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller//加上这个的类表示这个类和前端页面进行交互
@RequestMapping("/attendance")//定义映射地址
public class AttendanceController {

    //创建一个AttendanceInfoService的实现类对象
    @Autowired
    AttendanceInfoService attendanceInfoService;

    //访问考勤管理考勤记录信息页面
    @RequestMapping("/base")
    public String list(AttendanceInfo attendance, ModelMap modelMap) {
        // 查询分页数据
        HashMap<String, Object> map=attendanceInfoService.select(attendance);
        // 把数据传给前端
        modelMap.put("info", map);
        return "attendance/attendance-info";
    }

    // 打开修改页面
    @RequestMapping("/editPage")
    public String editPage(AttendanceInfo attendance, ModelMap modelMap) {
        //根据userId查询
        AttendanceInfo e = attendanceInfoService.selectByAttendanceId(attendance);
        //数据传递给前端
        modelMap.addAttribute("info", e);
        return "attendance/attendance-edit";

    }

    //打开新增页面
    @RequestMapping("/addPage")
    public String addPage(AttendanceInfo attendance, ModelMap modelMap) {
        return "attendance/attendance-add";
    }

    //处理修改的ajax请求
    @RequestMapping("/edit")
    @ResponseBody
    public HashMap<String,Object> edit(AttendanceInfo attendance){
        HashMap<String,Object> map = new HashMap<String,Object>();
        String info = attendanceInfoService.update(attendance);
        map.put("info",info);
        return map;
    }

    //处理表格的ajax数据
    @RequestMapping("/listAjax")
    @ResponseBody
    public HashMap<String,Object> listAjax(AttendanceInfo attendance){
        return attendanceInfoService.select(attendance);
    }

    // 处理增加员工数据的Ajax请求
    @RequestMapping("/addInfo")
    @ResponseBody
    public HashMap<String, Object> addInfo(AttendanceInfo attendance, ModelMap modelMap) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        String info = attendanceInfoService.addInfo(attendance);
        map.put("info", info);
        return map;
    }

    //处理删除的ajax请求
    @RequestMapping("/del")
    @ResponseBody
    public HashMap<String,Object> del(AttendanceInfo attendance){
        HashMap<String,Object> map = new HashMap<String,Object>();
        String info = attendanceInfoService.del(attendance);
        map.put("info",info);
        return map;
    }

}
