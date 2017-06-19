package com.web.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author anyun
 * @date 2017/6/19
 * @time 10:56
 * @description
 */
public class JdbcUtils {

    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    static {
        try {
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties prop = new Properties();
            prop.load(in);
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            Class.forName(driver);

        }catch (Exception e){
            throw new ExceptionInInitializerError(e);
        }
    }


    /*
    * 获取数据库连接
    * */
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, username,password);
    }

    public static void release(Connection conn, Statement st, ResultSet rs){
        if(rs!=null){
            try{
                //关闭存储查询结果的ResultSet对象
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(st!=null){
            try{
                //关闭负责执行SQL命令的Statement对象
                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try{
                //关闭Connection数据库连接对象
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void update(String sql,Object params[]) throws SQLException{
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = getConnection();
            st = conn.prepareStatement(sql);
            for(int i=0;i<params.length;i++){
                st.setObject(i+1, params[i]);
            }
            st.executeUpdate();

        }finally{
            release(conn, st, rs);
        }
    }


    public static Object query(String sql,Object params[],ResultSetHandler rsh) throws SQLException{

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            conn = getConnection();
            st = conn.prepareStatement(sql);
            for(int i=0;i<params.length;i++){
                st.setObject(i+1, params[i]);
            }
            rs = st.executeQuery();
            /**
             * 对于查询返回的结果集处理使用到了策略模式，
             * 在设计query方法时，query方法事先是无法知道用户对返回的查询结果集如何进行处理的，即不知道结果集的处理策略，
             * 那么这个结果集的处理策略就让用户自己提供，query方法内部就调用用户提交的结果集处理策略进行处理
             * 为了能够让用户提供结果集的处理策略，需要对用户暴露出一个结果集处理接口ResultSetHandler
             * 用户只要实现了ResultSetHandler接口，那么query方法内部就知道用户要如何处理结果集了
             */
            return rsh.handler(rs);

        }finally{
            release(conn, st, rs);
        }
    }








}
