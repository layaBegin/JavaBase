package com.heima.decorate;

import com.heima.reflect.Demo02_reflect;

import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Demo02_dynamic {
    public static void main(String[] args) {
        BaoQiang baoQiang = new BaoQiang();
        ClassLoader classLoader = baoQiang.getClass().getClassLoader();
        System.out.println(classLoader);
        // 加载器 只有一个，地址都是一样的
        System.out.println(Demo02_reflect.class.getClassLoader());
        Class<?>[] interfaces = baoQiang.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            /*

             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String name = method.getName();
                if ("play".equals(name)){
                    int money = (int)args[0];
                    if (money > 100){
                        baoQiang.play(money);
                    }else {
                        System.out.println("钱太少了，play不干");
                    }

                }else if ("show".equals(name)){
                    int money = (int)args[0];
                    if (money > 200){
                        baoQiang.show(money);
                    }else {
                        System.out.println("钱太少了，show不干");
                    }
                }else {//不想增强的，默认执行其他方法
                    method.invoke(baoQiang,args);
                }

                return null;
            }
        };

        Actor o = (Actor)Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);

        o.show(300);

    }
}
