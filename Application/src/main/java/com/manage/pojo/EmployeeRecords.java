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
public class EmployeeRecords extends EIPage {
    private int recordsId;
    private int empId;
    private String recordsName;
    private String summary;
    private String remarks;

    //描述查询条件condition的参数
    private String condition;
    //描述查询条件conValue的参数
    private String conValue;

    public int getRecordsId() {
        return recordsId;
    }

    public void setRecordsId(int recordsId) {
        this.recordsId = recordsId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getRecordsName() {
        return recordsName;
    }

    public void setRecordsName(String recordsName) {
        this.recordsName = recordsName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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
