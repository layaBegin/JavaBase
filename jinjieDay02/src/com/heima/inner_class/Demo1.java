package com.heima.inner_class;

public class Demo1 {
    public static void main(String[] args) {
        People.Heart h = new People.Heart();
        People.Eye leftEye = new People().new Eye();

    }
}

 class People{
    int age = 18;
    public static String SCHOOL = "sdsdf";
    //内部类可以用private修饰，而外部类不行
    private class A{

    }
    //静态内部类和外部类差别不大
    static class Heart{
        String name = "";
        public void show(){
            People p = new People();
            System.out.println(SCHOOL);
        }

    }
    /*
    实例内部类，属于外部类内部，必须和实例对象一起加载
    * */
    public class Eye{
        public  String name;
        // 实例内部类不能 定义静态成员变量
        //public static String SCHOOL = "sdsdf";
        //但是可以定义常量
        public static final String SCHOOL = "sdsdf";

        public void setName(String name) {
            this.name = name;
        }

        public Eye(){

        }
        public String getName() {
            return name;
        }

        public void  show(){

        }
    }
}
