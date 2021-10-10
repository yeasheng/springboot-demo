package org.yeasheng.multithread.syn;

public class SyncTest {

    private static int j = 0;


    /**
     * 同步库数据，比较耗时，代码资源不涉及共享资源读写操作。
     */
    public void syncDbData() {
        System.out.println(Thread.currentThread().getName()+"db数据开始同步------------");
        try {
            //同步时间需要2秒
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"db数据开始同步完成------------");
    }

    //自增方法
    public synchronized void incr() {
        //start--临界区代码
        //同步库数据
        syncDbData();
        for (int i = 0; i < 2000; i++) {
            j++;
        }
        //end--临界区代码
    }

    //自增方法
    public void incrTwo() {
        //同步库数据
        syncDbData();
        System.out.println(Thread.currentThread().getName()+"准备获取锁......");
        synchronized (this) {
            System.out.println(Thread.currentThread().getName()+"获得了锁");
            //start--临界区代码
            for (int i = 0; i < 1000; i++) {
                j++;
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //end--临界区代码
            System.out.println(Thread.currentThread().getName()+"准备释放锁......");
        }
        System.out.println(Thread.currentThread().getName()+"释放了了锁");

    }

    public int getJ() {
        return j;
    }

}