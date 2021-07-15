package com.heima.reflect;

import com.heima.entity.User;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class Demo02_reflect {

    public static void main(String[] args) throws Exception {
        /*
        反射+配置文件 解耦
           1）反射，封装规律相同的代码
            Class clazz = Class.forName(xxx);
            LzConnection c = clazz.newInstance;
           2）配置文件可以解耦代码中的参数

         */

        LzConnection con = ConnectFactory.getCon();
        con.connection();


    }
}
