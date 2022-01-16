package org.yeasheng.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 队列
 *
 * @author yansh
 * @version 2022/1/5
 **/
public class MyQueue {

    ArrayBlockingQueue<String> arrayQueue = new ArrayBlockingQueue(Integer.MAX_VALUE);


    LinkedBlockingQueue linkedQueue = new LinkedBlockingQueue();

    ConcurrentLinkedQueue clqueue = new ConcurrentLinkedQueue();



    public void operator1(){
        arrayQueue.offer("hello");
        clqueue.add("");

        AtomicInteger aInteger = new AtomicInteger();
        aInteger.getAndAdd(5);

    }
}
