package com.test.entity;

public class Page {
    //每页条数
    private Integer pageSize = 0;
    //第几页
    private Integer pageNo = 0;
    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
