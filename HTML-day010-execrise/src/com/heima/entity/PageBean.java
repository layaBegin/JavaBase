package com.heima.entity;

import java.util.List;

public class PageBean {
    private List<Contact> data;//这页要显示的数据


    private Integer firstPage = 1;
    private Integer previousPage;
    private Integer nextPage;
    private Integer size;
    private Integer currentPage;//当前是第几页
    private Integer totalPage;//总页数
    private Integer totalCount;//总条数


    public PageBean() {
    }
    public PageBean(List<Contact> data, Integer previousPage, Integer nextPage, Integer size, Integer currentPage, Integer totalPage, Integer totalCount) {
        this.data = data;
        this.firstPage = 1;
        this.previousPage = previousPage;
        this.nextPage = nextPage;
        this.size = size;
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
    }


    public List<Contact> getData() {
        return data;
    }

    public void setData(List<Contact> data) {
        this.data = data;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(Integer firstPage) {
        this.firstPage = firstPage;
    }

    public Integer getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(Integer previousPage) {
        this.previousPage = previousPage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }


    @Override
    public String toString() {
        return "PageBean{" +
                "data=" + data +
                ", firstPage=" + firstPage +
                ", previousPage=" + previousPage +
                ", nextPage=" + nextPage +
                ", size=" + size +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                '}';
    }
}
