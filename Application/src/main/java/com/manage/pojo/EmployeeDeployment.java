package com.manage.pojo;

/**
 * 模块1.2.3 & 1.2.4所用
 * 员工基本信息维护页面链接 http://localhost:8080/empInfo/baseInfoManagement
 * 员工档案管理页面链接 http://localhost:8080/empInfo/recordsManagement
 * 员工合同管理页面链接 http://localhost:8080/empInfo/contractManagement
 * 人事调配管理页面链接 http://localhost:8080/empInfo/deploymentManagement
 *
 * @author 张杰
 */
public class EmployeeDeployment extends EIPage {
    private int deploymentId;
    private int empId;
    private String originalDep;
    private String originalJob;
    private String newDep;
    private String newJob;
    private String deployDate;
    private String deployReason;

    //入职时间，外键为 EmployeeContract 中的 startDate
    private String startDate;
    // 外键
    private String empName;

    //描述查询条件condition的参数
    private String condition;
    //描述查询条件conValue的参数
    private String conValue;

    public int getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(int deploymentId) {
        this.deploymentId = deploymentId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getOriginalDep() {
        return originalDep;
    }

    public void setOriginalDep(String originalDep) {
        this.originalDep = originalDep;
    }

    public String getOriginalJob() {
        return originalJob;
    }

    public void setOriginalJob(String originalJob) {
        this.originalJob = originalJob;
    }

    public String getNewDep() {
        return newDep;
    }

    public void setNewDep(String newDep) {
        this.newDep = newDep;
    }

    public String getNewJob() {
        return newJob;
    }

    public void setNewJob(String newJob) {
        this.newJob = newJob;
    }

    public String getDeployDate() {
        return deployDate;
    }

    public void setDeployDate(String deployDate) {
        this.deployDate = deployDate;
    }

    public String getDeployReason() {
        return deployReason;
    }

    public void setDeployReason(String deployReason) {
        this.deployReason = deployReason;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getConValue() {
        return conValue;
    }

    public void setConValue(String conValue) {
        this.conValue = conValue;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
