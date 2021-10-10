package org.yeasheng.multithread;

/**
 * 双重锁校验的单例
 *
 * @author yansh
 * @version 2021/6/9
 **/
public class Singleton {

    // 使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行
    private volatile static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        // 先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (null == instance) {
            synchronized (Singleton.class) {
                // 防止多线程情况下，都阻塞在获取锁的情况系，第一个线程先获取锁后先实例化了对象，第二个线程又重新实例化一次
                if (null == instance) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    /*
    * instance = new Singleton 其实分为3步
    * 1. 为 instance分配内存空间
    * 2. 初始化instance
    * 3. 将instance指向分配的内存地址
    * 但是由于JVM的指令重排的特性，执行顺序可能会变为 1 -> 3 -> 2。指令重排在单线程环境下不会出现问题，但是在多线程环境下会
    * 导致另外一个线程还没有获得初始化的实例。
    * 比如线程T1执行了1和3，此时T2调用getInstance()后，发现instance!=null，因此返回instance,但是此时instance还未初始化。
    *
    *
    * */

}
