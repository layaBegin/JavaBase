package com.heima.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors.newCachedThreadPool()	创建一个可根据需要创建新线程的线程池 
 * Executors.newFixedThreadPool(n)	创建一个可重用固定线程数的线程池 
 * Executors.newSingleThreadExecutor() 	创建一个只有一个线程的线程池
 * Executors.newScheduledThreadPool(n)	创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求
 */


/**
 * 创建一个可重用固定线程数的线程池
 */
public class Demo_ThreadPool {
    public static void main(String[] args) {
        //自动创建固定线程池
        ExecutorService e = Executors.newFixedThreadPool(3);
        /**
         * 提交Runnable任务
         */
        Runnable target = new MyRunnable();
        e.execute(target);
        e.execute(target);
        e.execute(target);
        e.execute(target);

        //e.shutdownNow();//立即关闭线程池，不管任务是否执行完毕
        e.shutdown();//，任务执行完之后关闭线程池
    }
}
