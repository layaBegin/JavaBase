package com.heima.methed;

import java.util.Random;
//栈内存（Stack）方法运行时使用的内存，存放方法中的变量和参数。
//堆内存（Heap）存储对象或数组，new出来的数据，都存储在堆内存。
//方法区存储已加载的class文件信息。

public class MethdeDemo1 {
    public static void main(String[] args) {
        int num =12;
        isEvenNumber(num);
        Boolean b = getBoolen(num);
        System.out.println(b);
    }
    public static void isEvenNumber(int a){
        if (a%2 == 0 ){
            System.out.println("%d是偶数");
        }else {
            System.out.println("是奇数");
        }

    }
    public static boolean getBoolen(int num){
        if (num%2 == 0 ){
            return true;
        }else {
            return  false;
        }
    }
}
