package org.yeasheng.multithread.wait;

/**
 * . 功能说明
 *
 * @author yansh
 * @version 2022/1/18
 **/
public class ProducerThread implements Runnable {

    private Account account;

    public ProducerThread(Account account){
        this.account = account;
    }
    @Override
    public void run() {
        while (true) {
            account.addMoney(5);
        }
    }
}
