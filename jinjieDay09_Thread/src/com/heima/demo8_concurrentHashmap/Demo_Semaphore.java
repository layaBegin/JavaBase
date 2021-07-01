package com.heima.demo8_concurrentHashmap;

import java.time.LocalDateTime;
import java.util.concurrent.Semaphore;

public class Demo_Semaphore {
    public static void main(String[] args) {
        Cave cave = new Cave();
        for (int i = 0; i < 10; i++) {
            new Thread(new MyRunnable(cave),"人"+i).start();
        }
    }
}

class MyRunnable implements Runnable{
    private Cave cave;
    public Cave getCave() {
        return cave;
    }

    public MyRunnable(Cave cave){
        this.cave = cave;
    }
    public void setCave(Cave cave) {
        this.cave = cave;
    }

    @Override
    public void run() {
        cave.go();
    }
}

class Cave{
    /**
     * 同时让3个人进去
     */
    private Semaphore semaphore = new Semaphore(3);
    public void go() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+"进山洞" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName()+"出山洞"+ System.currentTimeMillis());
            semaphore.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
