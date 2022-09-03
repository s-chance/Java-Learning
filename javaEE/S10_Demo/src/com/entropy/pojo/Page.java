package com.entropy.pojo;

import java.util.List;

public class Page<T> {
    //当前页
    private Integer pageNow;
    //总页数
    private Integer pageTotal;
    //当前页显示记录数
    private Integer pageSize;
    //总记录数
    private Integer count;
    //当前页数据
    private List<T> pageList;

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNow=" + pageNow +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", count=" + count +
                ", pageList=" + pageList +
                '}';
    }
}
