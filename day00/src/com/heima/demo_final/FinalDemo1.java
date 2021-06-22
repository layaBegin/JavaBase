package com.heima.demo_final;
/*
* final 是最终的意思，修饰方法，变量，类
* 修饰方法：表示该方法为最终方法，不能被重写
* 修饰变量：表示该变量是常量，第一次赋值后不能再次被赋值
* 修饰类：表示该类是最终类，不能被继承
* */
public class FinalDemo1 {
    public static final String  SCHOOL = "黑马程序猿";
    //常量会进行宏替换，编译后不会出现SCHOOL 字段，直接全部替换成”黑马程序员“；，这样效率会更高
    public static void main(String[] args) {
        final double PI = 3.14;//常量，有且只能被赋值一次
        //SCHOOL = "传智教育";//第二次赋值，报错
        System.out.println(SCHOOL);
    }

    public static void buy(final double rate){
        //rate = 0.1;//第二次赋值，报错
    }
}
class Cat extends Animal{
//    @Override
//    public void run(){
//
//    }
}

//final class Animal{
//
//}
class Animal{
    final public  void  run(){

    }
}
