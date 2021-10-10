package org.yeasheng.jvm.chapter03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author yansh
 * @version 2021/5/22
 **/
public class HeapInitial {

    byte[] buffer = new byte[new Random().nextInt(1024 * 200)];

    public static void main(String[] args) throws InterruptedException {
        List<HeapInitial> list = new ArrayList<>();
        while (true) {
            list.add(new HeapInitial());
            Thread.sleep(100);
        }

    }


}
