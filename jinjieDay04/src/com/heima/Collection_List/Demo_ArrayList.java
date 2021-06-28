package com.heima.Collection_List;

import java.util.ArrayList;
import java.util.List;

/**
 * List集合特性：有序，可重复，有索引
 * List 最重要的实现类是ArrayList 和LinkedList
 * ArrayList 底层是基于数组的，查询相对快，增删相对慢
 * LinkedList 底层是基于链表的，查询相对慢，增删头尾特别快
 */
public class Demo_ArrayList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("d");
        list.add("ef");
        list.add("r");
        System.out.println(list);
        list.remove(2);
        list.remove("d");
        System.out.println(list);
        list.add(1,"1");
        list.add(0,"0");
        System.out.println(list);
        System.out.println(list.get(2));
        list.set(0,"000");
        System.out.println(list);

        /**
         * List 遍历有4中方式
         * 1，迭代器
         * 2，增强for
         * 3，Lambda表达式
         * 4，for循环
         *
         */
        /**
         * ArrayList new 的时候就会创建10个 格子
         * ArrayList.size 只 是反映元素的个数，并不是空间的多少
         */

    }
}
