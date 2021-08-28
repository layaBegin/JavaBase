package com.heima.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

/**
 * 学生对象
 */
public class Student {

    private int id;  //编号
    private String name; //名字
    private String sex; //性别
    //时区，东八区
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birthday; //生日
    private double score; //分数

    public Student() {
    }

    public Student(int id, String name, String sex, Date birthday, double score) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.score = score;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", score=" + score +
                '}';
    }
}