package com.manage.pojo;

public class ApplyInfo extends MyPage{
    private int applyId;
    private String applyName;
    private String applySex;
    private String applyPhone;
    private String applyBirth;
    private String applyDate;
    private String applyEmail;
    private String applyPosition;
    private String evaluate;
    private int penScore;
    private int faceScore;
    private String applyState="未处理";
    private String applyGroup;
    private String applyCollege;
    //描述查询条件的列
    private String condition;
    private String conValue;

    public int getApplyId() {
        return applyId;
    }

    public void setApplyId(int applyId) {
        this.applyId = applyId;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public String getApplySex() {
        return applySex;
    }

    public void setApplySex(String applySex) {
        this.applySex = applySex;
    }

    public String getApplyPhone() {
        return applyPhone;
    }

    public void setApplyPhone(String applyPhone) {
        this.applyPhone = applyPhone;
    }

    public String getApplyBirth() {
        return applyBirth;
    }

    public void setApplyBirth(String applyBirth) {
        this.applyBirth = applyBirth;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getApplyEmail() {
        return applyEmail;
    }

    public void setApplyEmail(String applyEmail) {
        this.applyEmail = applyEmail;
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

    public String getApplyPosition() {
        return applyPosition;
    }

    public void setApplyPosition(String applyPosition) {
        this.applyPosition = applyPosition;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public int getPenScore() {
        return penScore;
    }

    public void setPenScore(int penScore) {
        this.penScore = penScore;
    }

    public int getFaceScore() {
        return faceScore;
    }

    public void setFaceScore(int faceScore) {
        this.faceScore = faceScore;
    }

    public String getApplyState() {
        return applyState;
    }

    public void setApplyState(String applyState) {
        this.applyState = applyState;
    }

    public String getApplyGroup() {
        return applyGroup;
    }

    public void setApplyGroup(String applyGroup) {
        this.applyGroup = applyGroup;
    }

    public String getApplyCollege() {
        return applyCollege;
    }

    public void setApplyCollege(String applyCollege) {
        this.applyCollege = applyCollege;
    }
}
