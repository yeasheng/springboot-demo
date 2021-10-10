package org.yeasheng.service.impl;

import org.springframework.stereotype.Service;
import org.yeasheng.service.MyService;

/**
 * @author yansh
 * @version 2020/12/12
 **/
@Service
public class MyServiceImpl implements MyService {

    private ThreadLocal<Integer>  count = new ThreadLocal<>();

    @Override
    public String getAddress() {
        return "WH";
    }

    @Override
    public int increase(int i) {
        count.set(6);
        System.out.println("相加之前："+Thread.currentThread().getName()+"*****"+this.count.get());
        int ret = count.get() + 6;
        return ret;
    }



}
