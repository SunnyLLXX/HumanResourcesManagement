package com.manage.pojo;
//描述attendanceInfo的信息
public class AttendanceInfo extends EIPage {
    //描述attendanceID列的
    private int attendanceID;
    //描述staffID列的
    private int staffID;
    //描述type列的
    private String type;
    //描述amount列的
    private int amount;
    //描述staffName列的
    private String staffName;
    //描述mouth列的
    private int mouth;

    //统计迟到次数
    private int lateCount;


    public int getMouth() {
        return mouth;
    }

    public void setMouth(int mouth) {
        this.mouth = mouth;
    }

    public int getAttendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(int attendanceID) {
        this.attendanceID = attendanceID;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getLateCount() {
        return lateCount;
    }

    public void setLateCount(int lateCount) {
        this.lateCount = lateCount;
    }
}
