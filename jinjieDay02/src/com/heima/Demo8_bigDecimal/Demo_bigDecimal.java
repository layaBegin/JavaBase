package com.heima.Demo8_bigDecimal;

import java.math.BigDecimal;

public class Demo_bigDecimal {
    public static void main(String[] args) {
        /*//浮点运算的时候可能会出现失真
        System.out.println(0.09 + 0.01);//0.09999999999999999
        System.out.println(1.0-0.32);
        System.out.println(1.015 * 100);
        System.out.println(1.301/100);*/
        //包装浮点型成为大数据对象 BigDecimal
        double a = 0.09;
        double b = 0.01;
        double c  = a + b;
        System.out.println(c);
        BigDecimal a1 = BigDecimal.valueOf(a);
        BigDecimal b1 = BigDecimal.valueOf(b);
        System.out.println(a1.add(b1));
        BigDecimal c1 = BigDecimal.valueOf(1.0);
        BigDecimal c2 = BigDecimal.valueOf(0.32);
        System.out.println(c1.subtract(c2));
        System.out.println(BigDecimal.valueOf(1.015).multiply(BigDecimal.valueOf(100)));
        System.out.println(BigDecimal.valueOf(1.301).divide(BigDecimal.valueOf(100)));
        //处不尽的BigDecimal 会报错,但可以使用它的重载
        //System.out.println(BigDecimal.valueOf(1).divide(BigDecimal.valueOf(3)));
        System.out.println(BigDecimal.valueOf(1).divide(BigDecimal.valueOf(3),2,BigDecimal.ROUND_HALF_UP));
    }
}


