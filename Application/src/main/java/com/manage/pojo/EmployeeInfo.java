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
public class EmployeeInfo extends EIPage {
    private int id;
    private String empName;
    private String gender;
    private String birthDay;
    private String telNum;
    private String mailNum;
    // 学历
    private String qualification;
    private String department;
    private String job;
    private String hireDate;
    // 人员状态（在职/兼职/离职）
    private String state;
    // 备注
    private String remarks;

    //描述查询条件condition的参数
    private String condition;
    //描述查询条件conValue的参数
    private String conValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getMailNum() {
        return mailNum;
    }

    public void setMailNum(String mailNum) {
        this.mailNum = mailNum;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
}
