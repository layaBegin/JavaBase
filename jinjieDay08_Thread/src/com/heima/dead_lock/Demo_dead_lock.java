package com.heima.dead_lock;

public class Demo_dead_lock {
    public static Object resources1 = new Object();
    public static Object resources2 = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public  void run() {
                synchronized(resources1){
                    try {
                        System.out.println("线程1 抢占资源1");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (resources2){
                        System.out.println("线程1 占用资源1 且占用资源2");
                    }

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public  void run() {
                synchronized(resources2){
                    try {
                        System.out.println("线程2 抢占资源2");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (resources1){
                        System.out.println("线程2 占用资源2 且占用资源1");
                    }

                }
            }
        }).start();
    }
}
