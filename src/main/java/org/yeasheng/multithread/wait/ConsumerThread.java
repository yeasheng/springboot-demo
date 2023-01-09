package org.yeasheng.multithread.wait;

/**
 * . 功能说明
 *
 * @author yansh
 * @version 2022/1/18
 **/
public class ConsumerThread implements Runnable {

    private Account account;

    public ConsumerThread(Account account){
        this.account = account;
    }

    @Override
    public void run() {
        while(true) {
            try {
                account.takeMoney(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
