package org.yeasheng.multithread.threadpool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author yansh
 * @version 2021/6/14
 **/
public class RunnableDemo implements Runnable {

    private String command;

    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));


    public RunnableDemo(String param){
        this.command = param;
    }

    @Override
    public void run() {

        String startTime = formatter.get().format(new Date());
        System.out.println(Thread.currentThread().getName() + " Start. Time = " +startTime);
        processCommand();
        String endTime = formatter.get().format(new Date());
        System.out.println(Thread.currentThread().getName() + " End. Time = " + endTime);
    }

    private void processCommand() {
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
