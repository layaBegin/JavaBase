package com.heima.Demo_Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Collection_demo2 {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("赵敏");
        arrayList1.add("小昭");
        arrayList1.add("殷素素");
        arrayList1.add("周芷若");
        System.out.println(arrayList1);

        /**
         * Collection 遍历的方式
         * 1，迭代器
         */
        //迭代器
        Iterator<String> i = arrayList1.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }

        /**
         * 2,foreach--增强for 循环，既可以遍历集合，也可以遍历数组
         * 底层也是迭代器
         */
        for (String s : arrayList1) {
            System.out.println(s);
        }
        arrayList1.forEach(s -> System.out.println(s));
    }
}
