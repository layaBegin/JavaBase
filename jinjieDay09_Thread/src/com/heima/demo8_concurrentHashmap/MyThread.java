package com.heima.demo8_concurrentHashmap;

public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            Demo_ConcurrentHashmap.map.put(Thread.currentThread().getName() + i,i);

        }
    }
}
