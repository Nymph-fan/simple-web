package com.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @author anyun
 * @date 2017/6/18
 * @time 11:18
 * @description  带属性的标签
 */
public class SimpleTagDemo5 extends SimpleTagSupport {

    private int count;

    public void setCount(int count) {
        this.count=count;
    }

    @Override
    public void doTag() throws JspException, IOException {
        for (int i = 0; i < count; i++) {
            this.getJspBody().invoke(null);
        }
    }
}
