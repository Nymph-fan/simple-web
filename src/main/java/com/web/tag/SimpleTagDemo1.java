package com.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @author anyun
 * @date 2017/6/18
 * @time 11:08
 * @description  控制jsp页面某一部分内容是否执行
 */
public class SimpleTagDemo1 extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        JspFragment jspFragment = this.getJspBody();
        jspFragment.invoke(null);
    }
}
