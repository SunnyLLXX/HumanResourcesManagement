package com.manage.service;

import com.manage.pojo.EmployeeInfo;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * 人员档案及人事调配所用
 *
 * @author 张杰
 */
@Service
public interface EmpInfoService {
    HashMap<String, Object> selectInfo(EmployeeInfo employeeInfo);

    EmployeeInfo selectInfoById(EmployeeInfo employeeInfo);

    //修改
    String updateInfo(EmployeeInfo employeeInfo);
}
