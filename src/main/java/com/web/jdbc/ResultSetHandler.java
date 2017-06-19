package com.web.jdbc;

import java.sql.ResultSet;

/**
 * @author anyun
 * @date 2017/6/19
 * @time 11:16
 * @description
 */
public interface ResultSetHandler {

    public Object handler(ResultSet rs);
}
