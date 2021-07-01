package com.heima.demo8_concurrentHashmap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Demo_ConcurrentHashmap {
    /**
     * HashMap 线程不安全
     */
    //public static Map<String,Integer> map = new HashMap<>();

    /**
     * HashTable 效率低
     */
    //public static Map<String,Integer> map = new Hashtable<>();

    /**
     * ConcurrentHashMap 线程安全且效率较高
     * 基于 CAS 添加首元素，悲观锁（synchronized）操作链表和红黑树
     */
    public static Map<String,Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws Exception {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
        t1.join();//保证该线程在执行完之前不会往下走
        t2.join();
        System.out.println(map.size());

    }
}
