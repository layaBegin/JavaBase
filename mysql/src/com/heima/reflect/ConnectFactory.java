package com.heima.reflect;

import java.io.InputStream;
import java.util.Properties;

public class ConnectFactory {
    //静态代码块，加载类时加载，只加载一次
    static Properties p;
    static {
        try {
            Class<?> aClass = Class.forName("com.heima.reflect.Demo02_reflect");
            ClassLoader classLoader = aClass.getClassLoader();
            p = new Properties();
            InputStream resourceAsStream = classLoader.getResourceAsStream("connection.properties");
            p.load(resourceAsStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  static LzConnection getCon(){
        try {
            String con = p.getProperty("con");
            Class<?> aClass1 = Class.forName(con);
            LzConnection c = (LzConnection)aClass1.newInstance();
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
