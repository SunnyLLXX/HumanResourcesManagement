package com.manage.controller;

import com.manage.pojo.EmployeeContract;
import com.manage.pojo.EmployeeInfo;
import com.manage.pojo.EmployeeRecords;
import com.manage.service.EmpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * 1.2.3 人员档案所用
 * 员工基本信息维护页面链接 http://localhost:8080/empInfo/baseInfoManagement
 * 员工档案管理页面链接 http://localhost:8080/empInfo/recordsManagement
 * 员工合同管理页面链接
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
    public String baseInfoList(EmployeeInfo employeeInfo, ModelMap modelMap) {
        // 查询分页数据
        HashMap<String, Object> map = empInfoService.selectInfo(employeeInfo);
        // 把数据传给前端
        modelMap.put("info", map);
        return "empInfo/baseInfo/base-info-management";
    }

    // 打开修改页面
    @RequestMapping("/editPage")
    public String editPage(EmployeeInfo employeeInfo, ModelMap modelMap) {
        //根据userId查询
        EmployeeInfo e = empInfoService.selectInfoById(employeeInfo);
        //数据传递给前端
        modelMap.addAttribute("info", e);
        return "empInfo/baseInfo/edit-info";
    }

    // 打开添加页面
    @RequestMapping("/addInfoPage")
    public String addInfoPage() {
        return "empInfo/baseInfo/add-info";
    }

    // 处理修改员工数据的Ajax请求
    @RequestMapping("/editInfo")
    @ResponseBody
    public HashMap<String, Object> editInfo(EmployeeInfo employeeInfo) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        String info = empInfoService.updateInfo(employeeInfo);
        map.put("info", info);
        return map;
    }

    // 处理增加员工数据的Ajax请求
    @RequestMapping("/addInfo")
    @ResponseBody
    public HashMap<String, Object> addInfo(EmployeeInfo employeeInfo) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        String info = empInfoService.addInfo(employeeInfo);
        map.put("info", info);
        return map;
    }

    // 处理删除员工数据的Ajax请求
    @RequestMapping("/delInfo")
    @ResponseBody
    public HashMap<String, Object> delInfo(EmployeeInfo employeeInfo) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        String info = empInfoService.deleteInfo(employeeInfo);
        map.put("info", info);
        return map;
    }

    // ===================================
    // 员工档案所用
    // 访问员工基本信息维护页面
    @RequestMapping("/recordsManagement")
    public String recordsList(EmployeeRecords employeeRecords, ModelMap modelMap) {
        // 查询分页数据
        HashMap<String, Object> map = empInfoService.selectRecords(employeeRecords);
        // 把数据传给前端
        modelMap.put("info", map);
        return "empInfo/records/records-management";
    }

    // 打开添加页面
    @RequestMapping("/addRecordsPage")
    public String addRecordsPage() {
        return "empInfo/records/add-records";
    }

    // 打开修改页面
    @RequestMapping("/editRecordsPage")
    public String editRecordsPage(EmployeeRecords employeeRecords, ModelMap modelMap) {
        //根据userId查询
        EmployeeRecords e = empInfoService.selectRecordsByRecordsId(employeeRecords);
        //数据传递给前端
        modelMap.addAttribute("info", e);
        return "empInfo/records/edit-records";
    }

    // 处理增加员工档案的Ajax请求
    @RequestMapping("/addRecords")
    @ResponseBody
    public HashMap<String, Object> addRecords(EmployeeRecords employeeRecords) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        String info = empInfoService.addRecords(employeeRecords);
        map.put("info", info);
        return map;
    }

    // 处理修改员工档案的Ajax请求
    @RequestMapping("/editRecords")
    @ResponseBody
    public HashMap<String, Object> editRecords(EmployeeRecords employeeRecords) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        String info = empInfoService.updateRecords(employeeRecords);
        map.put("info", info);
        return map;
    }

    // 处理删除员工档案的Ajax请求
    @RequestMapping("/delRecords")
    @ResponseBody
    public HashMap<String, Object> delRecords(EmployeeRecords employeeRecords) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        String info = empInfoService.deleteRecords(employeeRecords);
        map.put("info", info);
        return map;
    }

    //excel导出
    @RequestMapping("/excelExport")
    public void excelExport(HttpServletResponse response, String type) {
        empInfoService.excelExport(response, type);
    }

    // ===================================
    // 员工合同管理所用

    // 访问合同管理页面
    @RequestMapping("/contractManagement")
    public String contractList(EmployeeContract employeeContract, ModelMap modelMap, String sortType) {
        // 查询分页数据
        HashMap<String, Object> map = empInfoService.selectContract(employeeContract,sortType);
        // 把数据传给前端
        modelMap.put("info", map);
        modelMap.put("sortType",sortType);
        return "empInfo/contractManagement/contract-management";
    }

    // 打开添加页面
    @RequestMapping("/addContractPage")
    public String addContractPage() {
        return "empInfo/contractManagement/add-contract";
    }

    // 打开修改页面
    @RequestMapping("/editContractPage")
    public String editContractPage(EmployeeContract employeeContract, ModelMap modelMap) {
        EmployeeContract e = empInfoService.selectContractByContractId(employeeContract);
        //数据传递给前端
        modelMap.addAttribute("info", e);
        return "empInfo/contractManagement/edit-contract";
    }

    @RequestMapping("/addContract")
    @ResponseBody
    public HashMap<String, Object> addContract(EmployeeContract employeeContract) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        String info = empInfoService.addContract(employeeContract);
        map.put("info", info);
        return map;
    }

    @RequestMapping("/editContract")
    @ResponseBody
    public HashMap<String, Object> editContract(EmployeeContract employeeContract) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        String info = empInfoService.updateContract(employeeContract);
        map.put("info", info);
        return map;
    }

    @RequestMapping("/delContract")
    @ResponseBody
    public HashMap<String, Object> delContract(EmployeeContract employeeContract) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        String info = empInfoService.deleteContract(employeeContract);
        map.put("info", info);
        return map;
    }
}
