package com.heima.Collection_List;

import java.util.LinkedList;

/**
 * 底层数据结构是 双链表，查询慢，增删快，首尾增删极快
 * 既可以用来做栈，也可以做队列
 */
public class Demo_LinkedList {
    public static void main(String[] args) {
        //队列
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("第一个人");
        linkedList.addLast("第二个人");
        linkedList.addLast("第三个人");

        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);

        //栈（弹夹）
        LinkedList<String> zhan = new LinkedList<>();
        /*zhan.addFirst("第一个子弹");
        zhan.addFirst("第二个子弹");
        zhan.addFirst("第三个子弹");*/
         zhan.push("第一个子弹");
        zhan.push("第二个子弹");
        zhan.push("第三个子弹");
        System.out.println(zhan);
        //zhan.removeFirst();
        zhan.pop();
        System.out.println(zhan);

        /**
         * 查询多，增删少用ArrayList
         * 查询少，增删多用LinkedList
         */
    }
}
