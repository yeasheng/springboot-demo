package org.yeasheng.controller;

import lombok.extern.log4j.Log4j2;
import org.checkerframework.checker.units.qual.A;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;
import org.yeasheng.service.MyService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yansh
 * @version 2020/12/12
 **/
@RestController
@RequestMapping(value = "/")
@Log4j2
public class MyController {

    @Resource
    private MyService myService;

    public MyController(){
        System.out.println("创建了MyController");
    }


    @RequestMapping(value = "getAddress",method = RequestMethod.GET)
    public String getAddress(@RequestParam(value = "name")String name, HttpServletRequest request){
        log.info("参数姓名："+name);
        HttpSession oldSession = request.getSession(false);
        if (null != oldSession ) {
            oldSession.invalidate();
        }

        List<String> list = new ArrayList<>();
        List<String> list1 =  Collections.synchronizedList(list);

        WebUtils.setSessionAttribute(request,"name",name);
        System.out.println("session_id: "+WebUtils.getSessionId(request));
        return myService.getAddress();


    }

}
