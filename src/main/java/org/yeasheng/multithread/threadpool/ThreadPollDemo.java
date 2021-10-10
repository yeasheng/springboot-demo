package org.yeasheng.multithread.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author yansh
 * @version 2021/6/14
 **/
public class ThreadPollDemo {

    private static final int CORE_POOL_SIZE = 50;
    private static final int MAX_POOL_SIZE = 100;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 120L;

    public static void main(String[] args) {
        // 线程池工厂
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").
                        build();
        // 阻塞队列
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
        // 回调策略
        ThreadPoolExecutor.CallerRunsPolicy callerRunsPolicy = new ThreadPoolExecutor.CallerRunsPolicy();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                workQueue, callerRunsPolicy);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.MINUTES,
                workQueue, threadFactory, callerRunsPolicy);

        for (int i = 0; i < 10; i++) {
            Runnable worker = new RunnableDemo("线程：" + i);
            threadPoolExecutor.execute(worker);
        }
        //threadPoolExecutor.shutdown();
        threadPoolExecutor.shutdownNow();
        boolean isTerminated = threadPoolExecutor.isTerminated();
        System.out.println(isTerminated);
    }
}
