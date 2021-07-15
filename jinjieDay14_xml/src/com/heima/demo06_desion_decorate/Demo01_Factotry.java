package com.heima.demo06_desion_decorate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Demo01_Factotry {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList(new ArrayList());
        myArrayList.add("ere");
        myArrayList.add("ere");
        myArrayList.add("ere");
        myArrayList.add("ere");
        myArrayList.add("ere");
        List list = myArrayList.getList();
        list.forEach(i ->{
            System.out.println(i);
        });
        //System.out.println(Arrays.toString(myArrayList.getList()));
    }
}
