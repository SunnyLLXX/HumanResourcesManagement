package com.manage.dao;

import com.manage.pojo.EmployeeContract;
import com.manage.pojo.EmployeeDeployment;
import com.manage.pojo.EmployeeInfo;
import com.manage.pojo.EmployeeRecords;
import org.apache.ibatis.annotations.*;

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
@Mapper
public interface EmployeeInfoDao {

    // 查询所有员工基本信息
    @Select("SELECT * FROM employee_info")
    List<EmployeeInfo> selectInfo();

    // 按ID查询所有员工基本信息
    @Select("SELECT * FROM employee_info WHERE id = #{id}")
    List<EmployeeInfo> selectInfoById(EmployeeInfo employeeInfo);

    // 按名字查询所有员工基本信息
    @Select("SELECT * FROM employee_info WHERE empName = #{empName}")
    List<EmployeeInfo> selectInfoByEmpName(EmployeeInfo employeeInfo);

    // 修改员工信息
    @Update("UPDATE employee_info SET empName = #{empName}, gender = #{gender}, birthDay = #{birthDay}," +
            "telNum = #{telNum}, mailNum = #{mailNum}, qualification = #{qualification}, " +
            "department = #{department}, job = #{job}, hireDate = #{hireDate}, state = #{state}," +
            "remarks = #{remarks}  WHERE id = #{id}")
    int updateInfo(EmployeeInfo employeeInfo);

    // 增加员工信息
    @Insert("INSERT INTO employee_info SET empName = #{empName}, gender = #{gender}, birthDay = #{birthDay}," +
            "telNum = #{telNum}, mailNum = #{mailNum}, qualification = #{qualification}, " +
            "department = #{department}, job = #{job}, hireDate = #{hireDate}, state = #{state}," +
            "remarks = #{remarks}")
    int addInfo(EmployeeInfo employeeInfo);

    // 按ID删除员工信息
    @Delete("DELETE FROM employee_info WHERE id = #{id}")
    int delInfo(EmployeeInfo employeeInfo);

    // ===================================
    // 员工档案所用
    // 查询所有员工档案
    @Select("SELECT * FROM employee_records")
    List<EmployeeRecords> selectRecords();

    // 按recordsId查询所有档案信息
    @Select("SELECT * FROM employee_records WHERE recordsId = #{recordsId}")
    List<EmployeeRecords> selectRecordsByRecordsId(EmployeeRecords employeeRecords);

    // 按empId查询所有档案信息
    @Select("SELECT * FROM employee_records WHERE empId = #{empId}")
    List<EmployeeRecords> selectRecordsByEmpId(EmployeeRecords employeeRecords);

    // 修改档案信息
    @Update("UPDATE employee_records SET recordsName = #{recordsName}, summary = #{summary}, remarks = #{remarks}" +
            " WHERE recordsId = #{recordsId}")
    int updateRecords(EmployeeRecords employeeRecords);

    // 增加档案信息
    @Insert("INSERT INTO employee_records SET empId = #{empId},recordsName = #{recordsName}, summary = #{summary}, " +
            "remarks = #{remarks}")
    int addRecords(EmployeeRecords employeeRecords);

    // 按recordsId删除档案信息
    @Delete("DELETE FROM employee_records WHERE recordsId = #{recordsId}")
    int delRecords(EmployeeRecords employeeRecords);

    // ===================================
    // 员工合同所用
    // 查询所有合同信息
    @Select("SELECT * FROM employee_contract")
    List<EmployeeContract> selectContract();

    // 按contractId查询所有合同信息
    @Select("SELECT * FROM employee_contract WHERE contractId = #{contractId}")
    List<EmployeeContract> selectContractByContractId(EmployeeContract employeeContract);

    // 按empId查询所有合同信息
    @Select("SELECT * FROM employee_contract WHERE empId = #{empId}")
    List<EmployeeContract> selectContractByEmpId(EmployeeContract employeeContract);

    // 修改合同信息
    @Update("UPDATE employee_contract SET startDate = #{startDate}, endDate = #{endDate}, job = #{job}," +
            "content = #{content}, remarks = #{remarks} WHERE contractId = #{contractId}")
    int updateContract(EmployeeContract employeeContract);

    // 增加合同信息
    @Insert("INSERT INTO employee_contract SET empId = #{empId}, startDate = #{startDate}, endDate = #{endDate}, " +
            "job = #{job}, content = #{content}, remarks = #{remarks}")
    int addContract(EmployeeContract employeeContract);

    // 按contractId删除合同信息
    @Delete("DELETE FROM employee_contract WHERE contractId = #{contractId}")
    int delContract(EmployeeContract employeeContract);

    // ===================================
    // 人事调配所用
    // 查询所有信息
    @Select("SELECT a.*,b.startDate FROM employee_deployment a,employee_contract b WHERE a.empId = b.empId")
    List<EmployeeDeployment> selectDeployment();

    // 按员工名称查询所有信息
    @Select("SELECT a.*,b.startDate FROM employee_deployment a,employee_contract b WHERE a.empId = b.empId " +
            "AND a.empId IN (SELECT id FROM employee_info WHERE empName LIKE \"%${empName}%\")")
    List<EmployeeDeployment> selectDeploymentByEmpName(EmployeeDeployment employeeDeployment);

    // 按empId查询所有信息
    @Select("SELECT a.*,b.startDate FROM employee_deployment a,employee_contract b WHERE a.empId = #{empId} " +
            "AND a.empId = b.empId")
    List<EmployeeDeployment> selectDeploymentByEmpId(EmployeeDeployment employeeDeployment);

    @Select("SELECT DISTINCT(department) FROM employee_info")
    List<String> selectDeploymentDep();

    @Select("SELECT id FROM employee_info")
    List<Object> selectEmployees();

    // 修改信息
    @Update("UPDATE employee_deployment SET originalDep = #{originalDep}, originalJob = #{originalJob}, newDep = #{newDep}," +
            "newJob = #{newJob}, deployDate = #{deployDate}, deployReason = #{deployReason} " +
            "WHERE deploymentId = #{deploymentId}")
    int updateDeployment(EmployeeDeployment employeeDeployment);

    // 增加信息
    @Update("INSERT INTO employee_deployment SET empId = #{empId}, originalDep = #{originalDep}, originalJob = #{originalJob}, " +
            "newDep = #{newDep}, newJob = #{newJob}, deployDate = #{deployDate}, deployReason = #{deployReason}")
    int addDeployment(EmployeeDeployment employeeDeployment);

    // 按contractId删除信息
    @Delete("DELETE FROM employee_deployment WHERE deploymentId = #{deploymentId}")
    int delDeployment(EmployeeDeployment employeeDeployment);
}
