package com.manage.pojo;

/**
 * 描述分页对象
 * 人员档案及人事调配所用
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
