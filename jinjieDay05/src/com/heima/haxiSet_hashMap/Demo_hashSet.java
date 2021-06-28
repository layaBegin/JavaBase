package com.heima.haxiSet_hashMap;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**Set : HashSet,LinkedHashSet,TreeSet;
 * HashSet : 无序，不重复，增删都很快，底层是 数组 ，链表，红黑树的结合；
 * LinkedHashSet：比HashSet 有序而已
 * TreeSet：底层是红黑树，可排序，而且必须实现排序；
 *
 *  HashSet : 无序、不重复、无索引。
 * LinkedHashSet：有序、不重复、无索引。
 * TreeSet：排序、不重复、无索引。
 */
public class Demo_hashSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Java");
        set.add("Java");
        set.add("MySQL");
        set.add("MyBatis");
        set.add("Html");
        set.add("web");
        System.out.println(set);

        /**
         * hashCode() 取hash值，相当于取内存地址
         * 继承自Object 方法，任何对象都能使用
         */
        System.out.println("web".hashCode());
        System.out.println("".hashCode());


        /**哈希算法
         * 创建一个默认长度16，默认加载因为0.75的数组，数组名table
         * 根据元素的哈希值跟数组的长度计算出应存入的位置
         * 判断当前位置是否为null，如果是null直接存入，如果位置不为null，表示有元素，  则调用equals方法比较属性值，如果一样，则不存，如果不一样，则存入数组。
         * 当数组存满到16*0.75=12时，就自动扩容，每次扩容原先的两倍
         * JDK8 开始 当数组中链表的元素超过8时，自动转为红黑树
         */
    }
}


