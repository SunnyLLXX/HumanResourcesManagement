package com.manage.pojo;

public class UserInfo extends EIPage{
    //描述userId列的
    private int userId;
    //描述userName列的
    private String username;
    //描述userPwd列的
    private String password;

    //描述查询条件condition的参数
    private String condition;
    //描述查询条件conValue的参数
    private String conValue;

    //描述修改密码的旧密码
    private String oldPwd;
    //描述修改密码的新密码
    private String newPwd;

    //描述url列
    private String url;

    // 描述盐值salt的列
    private String salt;

    private String role;
    private String permission;
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCondition() {
        if(condition==null){
            return "";
        }
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getConValue() {
        if(conValue==null){
            return "";
        }
        return conValue;
    }

    public void setConValue(String conValue) {
        this.conValue = conValue;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
