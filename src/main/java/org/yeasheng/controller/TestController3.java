package org.yeasheng.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yeasheng.service.MyService;
import org.yeasheng.service.RedisService;

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
    private RedisService redisService;


    @RequestMapping(value = "/test3")
    public String test4() {
        redisService.set("test", "12345678");
        String result = redisService.get("test").toString();
        System.out.println(result);
        return result;
    }


}
