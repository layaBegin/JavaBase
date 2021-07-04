package com.heima.demo05_annotest2;


/*@TestAnno(name = "lishi",age = 1,3)
public class Student {


    @TestAnno(name = "wn",age = 2,5)
    public void eat(){

    }
}*/

public class Student {
    @MyTest
    public void eat(){
        System.out.println("====执行eat");
    }


    public void study(){
        System.out.println("执行study");
    }
}