package org.yeasheng.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yeasheng.service.MyService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yansh
 * @version 2021/6/27
 **/
@RestController
public class TestController3 {

    @Resource
    private HttpServletRequest request;

    @Resource
    private HttpServletResponse response;

    @Resource
    private MyService myService;


    @RequestMapping(value = "/test3")
    public void thread1(HttpServletRequest req, HttpServletResponse response) throws Exception{

        System.out.println("客户端：" + request.getHeader("Thread"));
    }

    @RequestMapping(value = "/test4")
    public void thread2(){
        int i = 5;
        int result = myService.increase(i);
        System.out.println("相加之后" +Thread.currentThread().getName()+"*****"+result);
    }


}
