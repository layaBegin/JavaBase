package com.heima.Demo_Lambda;

public class Demo_lambdo {
    public static void main(String[] args) {
        //函数式接口
        Run baozhi = new Run() {
            @Override
            public void run() {
                System.out.println("跑的很快");
            }
        };
        Run lishi =  () ->{
            System.out.println("李氏跑的很快");
            };

        Run zhangshan = ()-> System.out.println("张山跑的很快");
        baozhi.run();
        zhangshan.run();
        lishi.run();
    }
}

@FunctionalInterface // 函数式接口的标志，即只有一个抽象方法的接口，Lambda 表达式只能简化函数式接口
interface Run{
    void run();
}