package com.heima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

import java.sql.Timestamp;
import java.util.Arrays;

public class LogAspect {


    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("获取目标对象的方法名："+ name);
        String declaringTypeName = signature.getDeclaringTypeName();
        System.out.println("获取目标对象名字：" + declaringTypeName);
        Object[] args = joinPoint.getArgs();
        if ("saveAccount".equals(name)){
            args[0] = "jack";
        }
        System.out.println(Arrays.toString(args));
        //注释掉 可以拦截目标方法的执行
        Object result = joinPoint.proceed(args);
        //修改返回值
        return 56;
    }
}
