package com.heima.utils;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Proxy;

public class DaoInstanceFactory {

    public static <T> T getBean(Class<T> daoInterface){
        return (T) Proxy.newProxyInstance(
                DaoInstanceFactory.class.getClassLoader(),
                new Class[]{daoInterface},
                (proxy,method,args)->{
                    SqlSession session = MyBatisUtils.getSession();
                    T mapper = session.getMapper(daoInterface);
                    Object ret = method.invoke(mapper,args);
                    session.commit();
                    session.close();
                    return ret;
                }
        );

    }
}
