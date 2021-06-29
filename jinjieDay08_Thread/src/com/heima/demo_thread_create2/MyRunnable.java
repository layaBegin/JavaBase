package com.heima.demo_thread_create2;


/**
 * 创建一个线程任务类，实现Runnable 接口
 * 优点：线程任务类只是实现了Runnale接口，可以继续继承和实现。
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程0：====>" + i);

        }
    }
}
