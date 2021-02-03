package com.manage.service;

import com.manage.pojo.EmployeeContract;
import com.manage.pojo.EmployeeDeployment;
import com.manage.pojo.EmployeeInfo;
import com.manage.pojo.EmployeeRecords;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * 模块1.2.3 & 1.2.4所用
 * 员工基本信息维护页面链接 http://localhost:8080/empInfo/baseInfoManagement
 * 员工档案管理页面链接 http://localhost:8080/empInfo/recordsManagement
 * 员工合同管理页面链接 http://localhost:8080/empInfo/contractManagement
 * 人事调配管理页面链接 http://localhost:8080/empInfo/deploymentManagement
 *
 * @author 张杰
 */
@Service
public interface EmpInfoService {
    HashMap<String, Object> selectInfo(EmployeeInfo employeeInfo);

    EmployeeInfo selectInfoById(EmployeeInfo employeeInfo);

    // 修改
    String updateInfo(EmployeeInfo employeeInfo);

    String addInfo(EmployeeInfo employeeInfo);

    String deleteInfo(EmployeeInfo employeeInfo);

    // ===================================
    // 员工档案所用

    HashMap<String, Object> selectRecords(EmployeeRecords employeeRecords);

    EmployeeRecords selectRecordsByRecordsId(EmployeeRecords employeeRecords);

    // 修改
    String updateRecords(EmployeeRecords employeeRecords);

    String addRecords(EmployeeRecords employeeRecords);

    String deleteRecords(EmployeeRecords employeeRecords);

    // Excel导出 通用
    void excelExport(HttpServletResponse response, String type);

    // ===================================
    // 员工合同所用

    HashMap<String, Object> selectContract(EmployeeContract employeeContract, String sortType);

    EmployeeContract selectContractByContractId(EmployeeContract employeeContract);

    // 修改
    String updateContract(EmployeeContract employeeContract);

    String addContract(EmployeeContract employeeContract);

    String deleteContract(EmployeeContract employeeContract);

    // ===================================
    // 人事调配所用

    HashMap<String, Object> selectDeployment(EmployeeDeployment employeeDeployment, String sortType);

    List<EmployeeDeployment> selectDeploymentByEmpId(EmployeeDeployment employeeDeployment);

    // 修改
    String updateDeployment(EmployeeDeployment employeeDeployment);

    String addDeployment(EmployeeDeployment employeeDeployment);

    String deleteDeployment(EmployeeDeployment employeeDeployment);

    // 查询所有部门
    List<String> selectDeploymentDep();

    // 查询所有员工ID
    List<Object> selectEmployees();
}
