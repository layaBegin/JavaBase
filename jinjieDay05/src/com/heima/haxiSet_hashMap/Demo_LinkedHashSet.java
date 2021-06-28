package com.heima.haxiSet_hashMap;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * LinkedHashSet 有序，不重复，无索引
 * 底层使用哈希表，使用双链表记录添加顺序
 */
public class Demo_LinkedHashSet {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("Java");
        set.add("Java");
        set.add("MySQL");
        set.add("MyBatis");
        set.add("Html");
        set.add("web");
        System.out.println(set);
    }
}
