package com.heima.static_field;

public class Student {
    private String name;
    private int age;
    //静态成员变量，static修饰，内存中只会存在一份，与类一起加载，所有实例共享访问
    public  static String country = "中国";
    public static void main(String[] args) {
//        System.out.println(name);//报错
        Student st = new Student();
        st.name = "zhanghsns";
        st.age = 18;
        System.out.println(st.country);//实力也可访问静态属性，只是不推荐
        System.out.println(country);
        System.out.println(Student.country);
        Student.getMax(5,6);
        st.getMax(3,5);//静态方法不建议用实例调用      11
    }

    public void run(){
        System.out.println("run===");
    }

    public static int getMax(int a ,int b){
        int c =  a > b ? a : b;
        System.out.println(c);
        return c;
    }
}
