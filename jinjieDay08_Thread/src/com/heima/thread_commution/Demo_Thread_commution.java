package com.heima.thread_commution;

/** 线程同步的方式
 * 方式一：同步代码块
 * 方式二：同步方法
 *
 */
public class Demo_Thread_commution {
    public static void main(String[] args) {
        //一个账户 5个人用  ，爸爸，干爹，岳父 存钱 ，小明，小红取钱
        Account acc = new Account(0);
        new DrawThread(acc,"小明").start();
        new DrawThread(acc,"小红").start();
        new SaveThread(acc,"爸爸").start();
        new SaveThread(acc,"干爹").start();
        new SaveThread(acc,"岳父").start();


    }
}


