package com.manage.pojo;
//描述表salary
public class Salary extends EIPage{
    private int salaryID;
    private int staffID;
    private String staffName;
    private int jiben;
    private int jixiao;
    private int jiangjing;
    private int fakuan;
    private int sum;
    private String time;
    //描述查询条件的列
    private String condition;
    private String conValue;
    public int getStaffID() {
        return staffID;
    }

    //
    private String type;
    private String con;
    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getJiben() {
        return jiben;
    }

    public void setJiben(int jiben) {
        this.jiben = jiben;
    }

    public int getJixiao() {
        return jixiao;
    }

    public void setJixiao(int jixiao) {
        this.jixiao = jixiao;
    }

    public int getJiangjing() {
        return jiangjing;
    }

    public void setJiangjing(int jiangjing) {
        this.jiangjing = jiangjing;
    }

    public int getFakuan() {
        return fakuan;
    }

    public void setFakuan(int fakuan) {
        this.fakuan = fakuan;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getSalaryID() {
        return salaryID;
    }

    public void setSalaryID(int salaryID) {
        this.salaryID = salaryID;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }
}
