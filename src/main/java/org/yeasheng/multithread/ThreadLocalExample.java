package org.yeasheng.multithread;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yansh
 * @version 2021/6/12
 **/
public class ThreadLocalExample implements Runnable {

    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    public static ExecutorService threadPool = Executors.newFixedThreadPool(16);

    // 线程安全的全局变量
    static Map<Integer, String> usersCache = Collections.synchronizedMap(new HashMap<>());

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "***" + formatter.get().toPattern());
        try {
            // 随机睡眠时间 [0,100)
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        formatter.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        System.out.println(Thread.currentThread().getName() + "###" + formatter.get().toPattern());
    }

    public static void main(String[] args) {
        /*
        ThreadLocalExample example = new ThreadLocalExample();
        for (int i =0;i<10;i++){
            Thread thread = new Thread(example, "线程" + i);
            thread.start();
        }
         */
        ThreadLocalExample example = new ThreadLocalExample();
        for (int i =0;i<100;i++){
            threadPool.submit(example);
        }
        threadPool.shutdown();
    }
}
