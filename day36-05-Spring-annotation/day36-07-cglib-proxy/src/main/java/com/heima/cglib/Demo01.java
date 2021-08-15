package com.heima.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Demo01 {
    public static void main(String[] args) {
        SuperStar superStar = new SuperStar();
        superStar.actor(500);

        SuperStar s2 = (SuperStar) Enhancer.create(SuperStar.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                if ("actor".equals(method.getName())){
                    double arg = (double) args[0];
                    if (arg < 1000){
                        System.out.println("没有档期");
                        return null;
                    }
                }
                return method.invoke(superStar,args);
            }
        });

        s2.actor(100);
        s2.actor(2000);
        System.out.println(s2 instanceof SuperStar);
        System.out.println(s2.getClass());

    }


}
