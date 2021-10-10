package org.yeasheng.componet;

import org.yeasheng.entity.Product;

import java.util.Vector;

public class ProductRepository {

    private final Vector<Product> products = new Vector<>();
    private static final int MAX_NUM = 100;

    public void produce(){
        synchronized (products){
            if (products.size() == MAX_NUM){ //如果仓库已经满了
                try {
                    System.out.println("包子铺满了，暂停生产");
                    products.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //products.size() < MAX_NUM 如果仓库还没有满
            Product product = new Product("包子", System.currentTimeMillis());
            products.add(product);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ " 生产了： "+ product+" ,产品仓库当前数量： "+ products.size());
            //通知等待的消费者来消费
            products.notifyAll();
        }
    }


    public void consume(){
        synchronized (products){
            if (products.size() == 0){ //产品仓库空了，等待生产者生产
                try {
                    System.out.println("包子铺空了，生产了再消费吧");
                    products.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Product product = products.firstElement();
            products.remove(0);
            System.out.println(Thread.currentThread().getName()+ " 消费了： " + product+" ,产品仓库当前数量： "+ products.size());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //通知生产者生产
            products.notify();
        }
    }

}
