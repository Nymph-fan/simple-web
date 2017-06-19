package com.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author anyun
 * @date 2017/6/19
 * @time 15:52
 * @description
 */
public class MyHttpSessionListener implements HttpSessionListener {


    public void sessionCreated(HttpSessionEvent se){
        System.out.println( se.getSession() + "创建了！！");
    }

    public void sessionDestroyed(HttpSessionEvent se){
        System.out.println("session销毁了！！");
    }
}
