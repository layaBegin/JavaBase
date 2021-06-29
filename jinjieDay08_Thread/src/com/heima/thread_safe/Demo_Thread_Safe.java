package com.heima.thread_safe;
/** 线程同步的方式
 * 方式一：同步代码块
 * 方式二：同步方法
 *
 */
public class Demo_Thread_Safe {
    public static void main(String[] args) {
        Account acc = new Account(10000);
        Thread t1 = new DrawThread(acc,"小明");
        Thread t2 = new DrawThread(acc,"小红");
        t1.start();
        t2.start();

    }
}


