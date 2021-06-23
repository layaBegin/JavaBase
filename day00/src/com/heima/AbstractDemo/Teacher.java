package com.heima.AbstractDemo;

public class Teacher extends Empolee{
    @Override
    public void work() {
        System.out.println(this.name+"需要授课");
    }
}
