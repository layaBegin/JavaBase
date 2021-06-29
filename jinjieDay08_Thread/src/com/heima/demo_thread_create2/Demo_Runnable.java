package com.heima.demo_thread_create2;

/**
 * 并发，随机，推进执行
 */
public class Demo_Runnable {
    public static void main(String[] args) {
        //创建线程任务
        MyRunnable runnable = new MyRunnable();
        //把线程任务包装成线程 启动
        Thread t = new Thread(runnable);
        t.start();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("子线程1：====>" + i);

                }
            }
        };
        Thread t1 = new Thread(runnable1);
        t1.start();

        new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println("子线程2：====>" + i);

                }
            }
        ).start();

        for (int i = 0; i < 10; i++) {
            System.out.println("mian线程：====>" + i);

        }
    }
}
