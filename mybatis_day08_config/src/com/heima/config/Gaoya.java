package com.heima.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)//声明作用范围为属性
@Retention(RetentionPolicy.RUNTIME) //运行时，才能被反射所解析，.java, .class ,执行
public @interface Gaoya {
    /*
    有且仅有一个属性需要赋值，且名为value value= 可以省略
     */
    String value();
}
