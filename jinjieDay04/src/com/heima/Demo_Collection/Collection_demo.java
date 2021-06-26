package com.heima.Demo_Collection;

import java.util.*;
import java.util.function.IntFunction;

public class Collection_demo {
    public static void main(String[] args) {
        //HashSet 无序，不重复，无索引
        Collection<String> set = new HashSet<>();
        set.add("MySQL");
        set.add("MySQL");
        set.add("java");
        set.add("MyBatis");
        set.add("MyBatis");
        set.add("HTML");
        System.out.println(set);

        //ArrayList 有序，可重复，有索引
        Collection<Integer> arrayList = new ArrayList<>();
        arrayList.add(32);//自动装箱
        arrayList.add(32);
        arrayList.add(19);
        arrayList.add(1);
        arrayList.add(0);
        System.out.println(arrayList);

        //报错，集合不支持基本类型，只支持对象
        //ArrayList<int> arrayList1 = new ArrayList<>();

        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("MySQL");
        arrayList1.add("MySQL");
        arrayList1.add("java");
        arrayList1.add("MyBatis");
        arrayList1.add("MyBatis");
        arrayList1.add("HTML");
        System.out.println(arrayList1);

        System.out.println(set.size());
        //set.clear();//清空集合
        System.out.println(set);
        System.out.println(set.isEmpty());
        System.out.println(set.size());
        System.out.println(set.contains("xi"));
        set.remove("MySQL");
        System.out.println(set);
        Object[] o =  set.toArray();
        System.out.println(Arrays.toString(o));
        String[] stArr = set.toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });
        String[] arr2 = set.toArray(v-> new String[v]);
        String[] arr3 = set.toArray(String[] :: new);

    }
}
