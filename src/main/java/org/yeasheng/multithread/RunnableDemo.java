package org.yeasheng.multithread;

/**
 * @author yansh
 * @version 2021/6/11
 **/
public class RunnableDemo implements Runnable {

    public int k = 0;

    @Override
    public void run() {
        System.out.println("当前线程："+Thread.currentThread().getName());
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "-----" + i);
            if (i == 50&&"线程1".equals(Thread.currentThread().getName())) {
                Thread.yield();
            }
        }
    }

    public void add() {
        k++;
    }
}
