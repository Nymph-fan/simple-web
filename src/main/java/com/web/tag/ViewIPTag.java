package com.web.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import java.io.IOException;

/**
 * @author anyun
 * @date 2017/6/15
 * @time 11:48
 * @description 自定义标签主要用于移除Jsp页面中的java代码
 */
public class ViewIPTag implements Tag {

    //接收传递进来的PageContext对象
    private PageContext pageContext;

    public int doEndTag() throws JspException {
        System.out.println("调用doEndTag()方法");
        return 0;
    }


    public int doStartTag() throws JspException {
        System.out.println("调用doStartTag()方法");
        HttpServletRequest request =(HttpServletRequest) pageContext.getRequest();
        JspWriter out = pageContext.getOut();
        String ip = request.getRemoteAddr();
        try {
            //这里输出的时候会抛出IOException异常
            out.write(ip);
        } catch (IOException e) {
            //捕获IOException异常后继续抛出
            throw new RuntimeException(e);
        }
        return 0;
    }


    public Tag getParent() {
        return null;
    }


    public void release() {
        System.out.println("调用release()方法");
    }


    public void setPageContext(PageContext pageContext) {
        System.out.println("setPageContext(PageContext pageContext)");
        this.pageContext = pageContext;
    }


    public void setParent(Tag arg0) {

    }
}
