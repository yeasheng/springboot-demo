package org.yeasheng.multithread;

/**
 * @author yansh
 * @version 2021/6/9
 **/
public class ApplicationDemo {


    public static void main(String[] args) throws InterruptedException {

        RunnableDemo runnableDemo = new RunnableDemo();
        for (int i =0 ; i<100000;i++){
            Thread th = new Thread(runnableDemo,"线程"+i);
            th.start();
            th.join();
        }
        System.out.println("结束啦："+runnableDemo.k);

    }


}
