package com.heima.demo_thread_create1;
/**多线程的创建方式
 * 方式一：继承Thread类方式实现
 * 方式二：实现Runnable接口
 * 方式三：实现Callable接口
 */

/**
 * 并发：cpu 是在很多个进程之间来回切换执行的。
 * 并行：多核cpu 可以同时 一起并发多个进程
 * 线程：不考虑cpu的核数和线程，相当于在在一个进程中并发执行；
 *
 */

/**
 * 1、为什么要重写run()方法？
 * 因为run()是用来封装被线程执行的代码。
 *
 * 2、run()方法和start()方法的区别？
 * run()：封装线程执行的代码，直接调用，相当于普通方法的调用，并没有开启线程。
 * start()：启动线程；然后由JVM调用此线程的run()方法。
 *
 * 3、为什么要先启动子线程，再执行主线程任务
 * 避免主线程任务提前执行完毕了。
 */
public class Demo_Thread {
    //主线程
    public static void main(String[] args) {

        Thread t = new MyThread();
        /**
         * 启动子线程,必须用start（）方法，向cpu注册线程，
         * 子线程必须先与主线程代码
         */
        t.start();
        /**
         * 多线程之间是随机并发执行的；
         */
        for (int i = 0; i < 100; i++) {
            System.out.println("mian线程："+ i);
        }
    }
}
