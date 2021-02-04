package com.manage.pojo;

public class EmployInfo extends MyPage{
    private int employId;
    private String employName;
    private String college;
    private String group;
    private String employPosition;
    private String employDate;
    private String employState;
    //描述查询条件的列
    private String condition;
    private String conValue;

    public int getEmployId() {
        return employId;
    }

    public void setEmployId(int employId) {
        this.employId = employId;
    }

    public String getEmployName() {
        return employName;
    }

    public void setEmployName(String employName) {
        this.employName = employName;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getEmployPosition() {
        return employPosition;
    }

    public void setEmployPosition(String employPosition) {
        this.employPosition = employPosition;
    }

    public String getEmployDate() {
        return employDate;
    }

    public void setEmployDate(String employDate) {
        this.employDate = employDate;
    }

    public String getEmployState() {
        return employState;
    }

    public void setEmployState(String employState) {
        this.employState = employState;
    }

    public String getCondition() {
        if(condition == null){
            return "";
        }
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getConValue() {
        if(conValue == null){
            return "";
        }
        return conValue;
    }

    public void setConValue(String conValue) {
        this.conValue = conValue;
    }
}
