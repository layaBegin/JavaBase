package com.heima.recursion;

public class Demo01_recursion {
    public static void main(String[] args) {
        //猴子吃桃，第一天吃掉一半，又多吃了一个；第二天又吃了一半，又多吃了一个，第10天刚好只剩一个；
        /*
        f(1) = f(2) *2+2;
        f(2 ) = f(3)* 2 +1;
        f(10) = 1;
        求f（1）
         */

        System.out.println(fun(1));
    }

    public static int fun(int n){
        if (n == 10){
            return 1;
        }else {
            return fun(n+1)*2 +2;
        }

    }
}
