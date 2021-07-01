package com.heima.thread_pool;

import java.util.concurrent.*;

public class Demo_Mannual_Thread {
    public static void main(String[] args) {
        /**
         * 手动创建线程池
         *  public ThreadPoolExecutor(int corePoolSize,
         *                               int maximumPoolSize,
         *                               long keepAliveTime,
         *                               TimeUnit unit,
         *                               BlockingQueue<Runnable> workQueue,
         *                               ThreadFactory threadFactory,
         *                               RejectedExecutionHandler handler) {
         */
        ExecutorService e = new ThreadPoolExecutor(3,5,5, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(4), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        /**
         * 提交Runnable任务
         */
        Runnable target = new MyRunnable();
        e.execute(target);
        e.execute(target);
        e.execute(target);//前3个使用固定线程
        e.execute(target);
        e.execute(target);
        e.execute(target);
        e.execute(target);
        e.execute(target);//必须超过ArrayBlockingQueue 等待的线程数。临时线程才会启用
        e.execute(target);//启用第二个临时线程
        e.execute(target);//拒绝超过的线程，抛异常

    }
}
/**任务拒绝策略
 * ThreadPoolExecutor.AbortPolicy	丢弃任务并抛出RejectedExecutionException异常。是默认的策略
 * ThreadPoolExecutor.DiscardPolicy： 	丢弃任务，但是不抛出异常 这是不推荐的做法
 * ThreadPoolExecutor.DiscardOldestPolicy	抛弃队列中等待最久的任务 然后把当前任务加入队列中
 * ThreadPoolExecutor.CallerRunsPolicy	调用任务的run()方法绕过线程池直接执行
 */
