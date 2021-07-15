package com.heima.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    static String driver;
    static String url;
    static String user;
    static String password;

    static {
        try {
            //类加载器，类加载器的工作是将字节码加载到内存中
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            //pro_jdbc.properties 配置文件必须放在src 下面
            InputStream resourceAsStream = classLoader.getResourceAsStream("pro_jdbc.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;

    }

    public  static void release(ResultSet resultSet, Statement statement, Connection connection){
        //5，释放连接
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
