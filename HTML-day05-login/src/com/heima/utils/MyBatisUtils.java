package com.heima.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 创建会话的工具类
 */
public class MyBatisUtils {

    private static SqlSessionFactory factory;  //会话工厂

    static {
        try {
            //读取src类路径下配置文件，返回输入流对象。捕获异常，快捷键：ctrl+alt+t
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            // SqlSessionFactoryBuilder ->  SqlSessionFactory -> SqlSession
            //创建会话工厂建造类
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //创建会话工厂
            factory = builder.build(in);//传入配置文件的输入流对象
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取一个会话对象
     */
    public static SqlSession getSession() {
        return factory.openSession();
    }

}