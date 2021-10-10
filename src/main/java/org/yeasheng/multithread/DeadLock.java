package org.yeasheng.multithread;

/**
 * @author yansh
 * @version 2021/6/8
 **/
public class DeadLock {

    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (obj1) {
                System.out.println(Thread.currentThread().getName() +"获取了obj1开始 执行");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +"开始等待获取obj2");
                synchronized (obj2) {
                    System.out.println(Thread.currentThread().getName() +"获取了obj2开始 执行");
                }
            }
        },"线程1").start();

        new Thread(() -> {
            synchronized (obj1) {
                System.out.println(Thread.currentThread().getName() +"获取了obj1开始 执行");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +"开始等待获取obj2");
                synchronized (obj1) {
                    System.out.println((Thread.currentThread().getName() +"获取了obj2开始 执行"));
                }
            }
        },"线程2").start();


    }
}
