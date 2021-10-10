package org.yeasheng.multithread.syn;

public class SyncMain {

    public static void main(String[] agrs) throws InterruptedException {
        //incr同步方法执行
        SyncTest syncTest = new SyncTest();
        Thread thread = new Thread(() -> syncTest.incr());
        Thread threadTwo = new Thread(() -> syncTest.incr());
        /*thread.start();
        threadTwo.start();
        thread.join();
        threadTwo.join();
        //最终打印结果是20000
        System.out.println(syncTest.getJ());*/

        //incrTwo同步块执行
        thread = new Thread(syncTest::incrTwo);
        threadTwo = new Thread(syncTest::incrTwo);
        thread.start();
        threadTwo.start();
        thread.join();
        threadTwo.join();
        //最终打印结果是40000
        System.out.println(syncTest.getJ());
    }

}