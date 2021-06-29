package com.heima.demo_thread_create1;

/**
 * 自定义线程必须继承Thread，并重写 run（）方法，
 * 但是开启的时候调用的是 start（）方法：代表向cpu注册
 *缺点：线程类已经继承Thread，无法继承其他类，不利于扩展
 */
public class MyThread extends Thread {
    /**
     * 必须重写run 方法，线程的任务方法
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("子线程："+i);
        }
    }
}
