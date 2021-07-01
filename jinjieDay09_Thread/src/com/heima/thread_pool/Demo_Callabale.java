package com.heima.thread_pool;

import java.util.concurrent.*;

/**
 * ExecutorService的submit方法可以提交Callable任务，
 * 并可以通过返回的 Future 对象得到线程的结果
 */
public class Demo_Callabale {
    public static void main(String[] args) {
        //一次3个线程同时执行，未完成的任务由这3个线程执行完之后再复用
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<String> f1 = executorService.submit(new MyCallable(100));
        Future<String> f2 = executorService.submit(new MyCallable(200));
        Future<String> f3 = executorService.submit(new MyCallable(300));
        Future<String> f4 = executorService.submit(new MyCallable(400));

        try {
            System.out.println(f1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(f2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(f3.get());;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(f4.get());;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
