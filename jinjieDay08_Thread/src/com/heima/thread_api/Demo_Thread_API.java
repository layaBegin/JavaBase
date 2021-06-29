package com.heima.thread_api;

public class Demo_Thread_API {
    public static void main(String[] args) {
        /*Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());

            }
        });
        t1.setName("1hao线程");

        t1.start();
        //System.out.println(t1.getName());

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t2.setName("2hao线程");
        t2.start();
        //System.out.println(t2.getName());
        //在哪个线程中就显示哪个线程的名字
        Thread main =  Thread.currentThread();
        System.out.println("主线程："+main.getName());*/

        Thread t1 = new MyThread("1hao");
        Thread t2 = new MyThread("2hao");
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName());

    }
}

class MyThread extends Thread{
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("子线程==="+Thread.currentThread().getName());
    }
}
