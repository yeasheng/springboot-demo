package org.yeasheng.multithread.wait;

import lombok.extern.slf4j.Slf4j;

/**
 * . 功能说明
 *
 * @author yansh
 * @version 2022/1/18
 **/
@Slf4j
public class Account {

    static int balance = 100;

    /**
     * 取钱
     * @param money
     */
    public void takeMoney(int money) {
        synchronized (this) {
            log.info("取钱获得了锁");
            while (balance <= money) {
                log.info("余额不足,需要取钱：{} 元， 当前余额:{}",money, balance);
                this.notify();
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (balance > money) {
                balance -= money;
                log.info("取了：{}元，还剩：{} 元",money, balance);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 存钱
     * @param money
     */
    public void addMoney(int money) {
        synchronized (this) {
            log.info("存钱获得了锁");
            while (balance <= money) {
                balance += money;
                log.info("存入 :{}元，当前余额为：{}", money,balance);
                this.notify();
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
