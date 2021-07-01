package com.heima.volatile_atomicity;

/**
 * volatile 虽然线程可见，但并非线程安全
 * synchronized 加锁可以保证原子性，可见性，但是会影响性能
 */
public class Demo_volatile_atomicity {
    public static void main(String[] args) {
        /*MyRunnable runnable = new MyRunnable();
        for (int i = 0; i < 100; i++) {
            new Thread(runnable).start();
        }*/

        /**
         * 原子性 - 先和主工作区（堆）比较，如果不一样则更新该副工作区的值，再运算
         */
        MyRunnable_Atomicity runnable = new MyRunnable_Atomicity();
        for (int i = 0; i < 100; i++) {
            new Thread(runnable).start();
        }

    }
}
/**synchronized和CAS的区别

 相同点：
 在多线程情况下，都可以保证共享数据的安全性。

 Synchronized是悲观锁
 synchronized总是从最坏的角度出发，认为每次获取数据的时候，别人都有可能修改。
 所以在每次操作共享数据之前，都会上锁。

 CAS是乐观锁
 cas是从乐观的角度出发，假设每次获取数据别人都不会修改，所以不会上锁。
 只不过在修改共享数据的时候，会检查一下，别人有没有修改过这个数据。
 如果别人修改过，那么我再次获取现在最新的值。
 如果别人没有修改过，那么我现在直接修改共享数据的值。
**/