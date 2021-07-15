package com.heima.demo06_desion_decorate;

import java.util.List;

public class MyArrayList {
    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    private List list;
    public MyArrayList(List list){
        this.list = list;
    }


    public boolean add(Object o){
        if (!list.contains(o)){
            list.add(o);
        }else {
            return false;
        }
        return true;
    }
}
