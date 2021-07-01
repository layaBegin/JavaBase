package com.heima.volatile_atomicity;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1. 原子类的原理：CAS 算法
 * 在修改共享数据的时候，把原来的旧值记录下来了。
 * 如果现在内存中的值跟原来的旧值一样，证明没有其他线程操作过，则修改成功。
 *
 * 如果现在内存中的值跟原来的旧值不一样了，证明已经有其他线程操作过了。
 * 则修改失败，需要获取现在最新的值，再次进行操作，这个重新获取就是自旋。
 */
public class MyRunnable_Atomicity implements Runnable{


    private AtomicInteger count = new AtomicInteger();



    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            ;
            System.out.println(Thread.currentThread().getName() + "输出---->："+ count.incrementAndGet());


        }
    }
}
