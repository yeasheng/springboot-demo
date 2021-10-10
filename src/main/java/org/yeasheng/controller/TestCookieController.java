package org.yeasheng.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;
import org.yeasheng.service.MyService;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * @author yansh
 * @version 2020/12/12
 **/
@RestController
@RequestMapping(value = "/")
@Log4j2
public class TestCookieController {

    @Resource
    private MyService myService;


    @GetMapping(value = "/setCookie")
    public String getAddress(HttpServletResponse response) {
        Cookie cookie = new Cookie("current_time", System.currentTimeMillis() + "");
        // 设置生命周期为MAX_VALUE
        cookie.setMaxAge(Integer.MAX_VALUE);
        cookie.setDomain("yeasheng.com");
        response.addCookie(cookie);
        return "success";
    }

    @GetMapping(value = "/getCookie")
    public String getCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        if (null == cookies) {
            return "cookie is null";
        }
        for (Cookie ck : cookies) {
            cookie = ck;
            break;
        }
        if (null != cookie) {
            // 删除一个cookie
            cookie.setMaxAge(0);
            response.addCookie(cookie);

        }
        Cookie newCookie = new Cookie("username", "yeasheng");
        newCookie.setMaxAge(Integer.MAX_VALUE);
        newCookie.setDomain("yeasheng.com");
        response.addCookie(newCookie);
        assert cookie != null;
        return cookie.getValue();
    }

    @GetMapping(value = "/getSession")
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //使用request对象的getSession()获取session，如果session不存在则创建一个
         HttpSession session = request.getSession();
        //获取session的Id
        String sessionId = session.getId();

        //判断session是不是新创建的
        if (session.isNew()) {
            //将数据存储到session中
            session.setAttribute("Jack", "风清扬");
            response.getWriter().print("session创建成功，session的id是：" + sessionId);
        } else {
            System.out.println(session.getAttribute("Jack"));
            response.getWriter().print("服务器已经存在该session了，session的id是：" + sessionId);
        }
    }

}
