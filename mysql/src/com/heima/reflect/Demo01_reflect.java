package com.heima.reflect;

import com.heima.entity.User;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo01_reflect {
    //1）类加载器，将.class 文件加载到内存中，形成class 对象
    @Test
    public void test1() throws IOException {
        Class<User> userClass = User.class;
        ClassLoader classLoader = userClass.getClassLoader();
        //用加载器 可以获取 文件的IO流，路径时全路径（即src下的路径）
        InputStream is = classLoader.getResourceAsStream("pro_jdbc.properties");
        byte[] bytes = new byte[1024];


        int len ;
        while ((len = is.read(bytes)) != -1 ) {
            System.out.println(new String(bytes,0,len));
        }
        is.close();
    }

    @Test
    public void test2() throws Exception {
        Class<?> aClass = Class.forName("com.heima.entity.User");
        //默认会调用空参构造
        User user = (User)aClass.newInstance();
        // 等同于下面的方式
        Constructor<?> constructor = aClass.getConstructor();
        Object o = constructor.newInstance();
        System.out.println(user);
        System.out.println(o);
    }
    /*反射：在运行时操作类
       反射的作用：解耦
     */
    public static void main(String[] args) {
        /*
        1,类
            java 生命周期的3个阶段
            源码（java类）---------->编译（字节码文件.class）------->运行（class文件，运行时 .class 文件会解释成机器码文件）
            Demo1.java              Demo1.class (类加载器)             Demo1.class

            编译器：将.java 文件转换成.class 文件
            1）类加载器， 主要作用：将.class 文件加载到内存中，形成class 对象
                        次要作用：加载src 下的配置文件
            2）Class对象，类在运行时的描述
                class 对象我们无法创建，只能获取
                获取Class 对象的3种方式
                    1 类名.class
                    Class<User> userClass = User.class;
                    2,对象名.getClass
                    User user = new User();
                    user.getClass();
                    3,Class.forName(全类名);
         */


        //反射的3大对象
       // Method
        //  Constructor
        //Field
        /**
         * 获取class 字节码文件的3种方式，即反射
         *
         */


    }
}
