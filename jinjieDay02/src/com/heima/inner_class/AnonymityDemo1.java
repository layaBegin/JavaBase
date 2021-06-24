package com.heima.inner_class;

public class AnonymityDemo1 {
    public static void main(String[] args) {
        Swim teacher = new Swim() {
            @Override
            public void swimming() {
                System.out.println("老师游的很快~~");
            }
        };
        /*Swim student =new Swim() {
            @Override
            public void swimming() {
                System.out.println("学生游的很努力");
            }
        } ;*/
        go(teacher);
        go(new Swim() {
            @Override
            public void swimming() {
                System.out.println("学生游的很努力");
            }
        });
    }

    public  static void go(Swim s){
        System.out.println("===开始游泳====");
        s.swimming();
        System.out.println("===结束游泳====");

    }
}

interface Swim {
    void swimming();
}
