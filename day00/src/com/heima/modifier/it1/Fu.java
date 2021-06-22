package com.heima.modifier.it1;
//private --> 缺省（同一个包的其他类中可访问）-->protected ---> public
public class Fu {
    private void  show1(){
        System.out.println("show1");
    }
    //缺省：本类 || 同一个包中可访问
    void  show2(){
        System.out.println("缺省");
    }
    protected void  show3(){
        System.out.println("show3 protected");
    }
    public void  show4(){
        System.out.println("show4 public");
    }
}
