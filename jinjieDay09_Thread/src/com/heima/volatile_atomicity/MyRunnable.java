package com.heima.volatile_atomicity;

/**
 * Volatile可以保证操作的原子性吗？
 * 只能保证线程每次在使用共享数据的时候是最新值。
 * 但是不能保证原子性。
 * Volatile与Synchronized的区别
 * 都能保证可见性。
 * volatile不可以保证原子性，但是synchronized可以保证线程安全。
 * volatile是无锁机制，只能修饰成员变量
 * synchronized是加锁机制，可以修饰方法，代码块，不能修饰变量。
 */
public class MyRunnable implements Runnable{
    private volatile int  n;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            /**
             * synchronized 加锁可以保证原子性，但是会影响性能
             * 加速可以保证可见性，所以可以去掉volatile
             */
            synchronized(this){
                n++;
                System.out.println(Thread.currentThread().getName() + "输出---->："+ n);
            }

        }
    }
}
