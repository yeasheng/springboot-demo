package org.yeasheng.multithread;

/**
 * @author yansh
 * @version 2021/6/9
 **/
public class SynchronizeDemo {

    private int i = 1;


    public synchronized void testSyn() {
        i++;
    }

    public synchronized static void testStaticSyn(){
        System.out.println("testStaticSyn");
    }

    public void testSynBlock(){
        synchronized (this){
            System.out.println("testSynBlock");
        }
    }


}
