package com.manage.service;

import com.manage.pojo.EmployeeContract;
import com.manage.pojo.EmployeeInfo;
import com.manage.pojo.EmployeeRecords;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * 人员档案所用
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
}
