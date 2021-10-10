package org.yeasheng.multithread;

import org.yeasheng.componet.ProductRepository;
import org.yeasheng.entity.Consumer;
import org.yeasheng.entity.Producer;

public class ProducerConsumerTest {


    /**
     * 一个生产者，一个消费者
     * @throws InterruptedException
     */
    public static void oneProducerAndOneConsumer() throws InterruptedException {
        ProductRepository repository = new ProductRepository();
        Consumer consumer1 = new Consumer(repository);
        Consumer consumer2 = new Consumer(repository);
        Consumer consumer3 = new Consumer(repository);
        Producer producer = new Producer(repository);
        Thread t1 = new Thread(producer,"producer-A");
        Thread t2 = new Thread(consumer1,"consumer-B");
        Thread t3 = new Thread(consumer2,"consumer-C");
        Thread t4 = new Thread(consumer3,"consumer-D");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join(); //join(): 主线程等待t1线程和禾t2线程都执行完
        t3.join();
        t4.join();
    }
    public static void main(String[] args) throws InterruptedException {
           oneProducerAndOneConsumer();
        System.out.println("执行完了");
    }
}
