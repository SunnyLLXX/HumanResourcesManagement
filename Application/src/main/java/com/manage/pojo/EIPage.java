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
public class EIPage {
    //定义页码，并赋初值1，表示第一页
    private int page = 1;
    //定义每页显示的数据条数，并赋初值2，表示每页显示两条数据
    private int row = 5;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
