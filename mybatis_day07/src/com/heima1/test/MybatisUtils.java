package com.heima1.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    public static SqlSessionFactory factory;
    static {
        //1. 得到输入流对象
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            //2. 创建会话工厂建造类
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //3. 通过建造类得到会话工厂类
            factory = builder.build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SqlSession openSession() throws IOException {
        //4. 通过会话工厂得到会话对象
        SqlSession session = factory.openSession();
        return  session;
    }

    public static void commitAndClose(SqlSession session){
        session.commit();
        session.close();
    }

    public static void rollBackAndClose(SqlSession session){
        session.rollback();
        session.close();
    }
}
