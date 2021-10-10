package org.yeasheng.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程操作资源类
 */
class SharedResource {
    /**
     * 1代表A线程
     * 2代表B线程
     * 3代表C线程
     */
    private volatile int number = 1;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition c1 = lock.newCondition();
    private final Condition c2 = lock.newCondition();
    private final Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            System.out.println("p5获得锁");
            // 判断
            while (number != 1) {
                System.out.println("p5等待1");
                // 等待
                c1.await();
                System.out.println("p5等待2");
            }
            // 干活
            System.out.println("p5工作***");
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            // 通知
            number = 2;// 修改标志位
            System.out.println("通知p10");
            c2.signal();// 通知B
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            System.out.println("p10获得锁");
            // 判断
            while (number != 2) {
                // 等待
                System.out.println("p10等待1");
                c2.await();
                System.out.println("p10等待2");
            }
            // 干活
            System.out.println("p10工作***");
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            // 通知
            number = 3;// 修改标志位
            c3.signal();// 通知C
            System.out.println("通知p15");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            // 判断
            while (number != 3) {
                // 等待
                System.out.println("p15等待1");
                c3.await();
                System.out.println("p15等待2");
            }
            // 干活
            System.out.println("p15工作***");
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            // 通知
            number = 1;// 修改标志位
            c1.signal();// 通知A
            System.out.println("通知p5");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * @Description
 *
 * 题目：多线程之前按顺序调用，实现A->B->C三个线程启动，要求如下：
 * A打印5次，B打印10次，C打印15次
 * 紧接着
 * A打印5次，B打印10次，C打印15次
 * ......
 * 来5轮
 *
 * @Author lyluo
 * @Date 2021/2/2
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        int num = 5;
        for (int i = 1; i <= num; i++) {
            new Thread(() -> {
                sharedResource.print5();
            }, "A").start();
        }
        for (int i = 1; i <= num; i++) {
            new Thread(() -> {
                sharedResource.print10();
            }, "B").start();
        }
        for (int i = 1; i <= num; i++) {
            new Thread(() -> {
                sharedResource.print15();
            }, "C").start();
        }
    }
}

