package com.heima.entity;

public class Contact {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private String county;
    private Integer qq;
    private String mail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Contact() {
    }

    public Contact(Integer id, String name, String sex, Integer age, String county, Integer qq, String mail) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.county = county;
        this.qq = qq;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", county='" + county + '\'' +
                ", qq=" + qq +
                ", mail='" + mail + '\'' +
                '}';
    }
}
