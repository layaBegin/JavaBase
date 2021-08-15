package com.heima.entity;

import java.util.Date;

/**
 * 客户对象
 */
public class Customer {

    private int id;
    private String name;
    private boolean male;
    private Date birthday;

    public Customer() {
    }

    public Customer(int id, String name, boolean male, Date birthday) {
        this.id = id;
        this.name = name;
        this.male = male;
        this.birthday = birthday;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", male=" + male +
                ", birthday=" + birthday +
                '}';
    }
}
