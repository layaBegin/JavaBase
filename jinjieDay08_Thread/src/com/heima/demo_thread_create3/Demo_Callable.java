package com.heima.demo_thread_create3;

import java.util.concurrent.*;

/**
 * 多线程的实现方案三：实现Callable接口。可以得到线程执行的结果
 */
public class Demo_Callable {
    public static void main(String[] args)  {

        Callable callable = new MyCallable(10);
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread t1 = new Thread(futureTask);
        t1.start();

        Callable callable2 = new MyCallable(20);
        FutureTask<String> futureTask2 = new FutureTask<>(callable2);
        Thread t2 = new Thread(futureTask2);
        t2.start();

        try {
            String sum1 =  futureTask.get();
            System.out.println("线程1结果"+sum1);
            System.out.println("线程2结果"+futureTask2.get());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
