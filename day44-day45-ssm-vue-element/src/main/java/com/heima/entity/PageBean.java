package com.heima.entity;

import java.util.List;

/**
 * 分页对象，封装页面上所有的数据
 */
public class PageBean<T> {

    /*
    一共有8个属性，分成三类：
    1. 从数据库中查询获取
    2. 由用户从浏览器提交
    3. 由其它的属性计算出来的
     */
    //1. 从数据库中查询获取
    private List<T> data;   //这一页显示的数据
    private int count;   //一共有多少条记录

    //2. 由用户从浏览器提交
    private int current;  //当前是第几页
    private int size;    //每页大小

    //3. 由其它的属性计算出来的, 在get方法中去计算
    private int first;  //第1页
    private int previous;  //上一页
    private int next;   //下一页
    private int total;   //总页数 和 最后一页是一样

    //创建一个构造方法输入上面4个属性值
    public PageBean(List<T> data, int count, int current, int size) {
        this.data = data;
        this.count = count;
        this.current = current;
        this.size = size;
    }

    public PageBean() {
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 第一页
     */
    public int getFirst() {
        return 1;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    /**
     * 上一页 = 当前页 - 1
     * @return
     */
    public int getPrevious() {
        //如果当前页大于1则减1，否则等于1
        if (getCurrent() > 1) {
            return getCurrent() - 1;
        }
        else {
            return 1;
        }
    }

    public void setPrevious(int previous) {
        this.previous = previous;
    }

    /**
     * 如果当前页 < 最后一页
     *    下一页= 当前页 + 1
     * 否则 就等于最后一页
     */
    public int getNext() {
        if (getCurrent() < getTotal()) {
            return getCurrent() + 1;
        }
        else {
            return getTotal();
        }
    }

    public void setNext(int next) {
        this.next = next;
    }

    /**
     * 总页数 = 总计数 / 页面大小
     * 如果能整除就正好是这么多页，不能整除就加1
     */
    public int getTotal() {
        if (getCount() % getSize() == 0) {
            return getCount() / getSize();
        }
        else {
            return getCount() / getSize() + 1;
        }
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
