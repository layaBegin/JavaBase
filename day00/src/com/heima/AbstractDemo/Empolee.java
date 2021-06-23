package com.heima.AbstractDemo;

public abstract class Empolee {
    public String name;
    public double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    //抽象方法，子类必须实现，抽象方法必须在抽象类中
    public abstract void work();


}
