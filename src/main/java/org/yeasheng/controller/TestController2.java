package org.yeasheng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yansh
 * @version 2021/6/27
 **/
@Controller
public class TestController2 {

    public HttpServletRequest request;

    public HttpServletResponse response;

    /**
     * ModelAttribute 注解代表只要调用TestController类的方法，就一定会先执行该方法，
     * 此处在方法内初始化了Servlet对象。
     * @param request
     * @param response
     */
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
    }

    @RequestMapping(value = "/test2")
    public void thread1(HttpServletRequest req, HttpServletResponse response) throws Exception{
        System.out.println("开始");
        Map<String, Object> param = new HashMap<>();
        param.put(null,"2");
        param.put("1", "1");
        param.put("2", "2");
        param.put("3", "3");
        param.put("4", "3");
        System.out.println(param.size());

        // System.out.println("客户端：" + request.getHeader("Thread"));
    }

}
