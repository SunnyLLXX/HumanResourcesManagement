package com.manage.pojo;

public class MyPage {
    //页码赋初值
    private int page = 1;
    //页容量赋初值
    private int row = 2;

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
