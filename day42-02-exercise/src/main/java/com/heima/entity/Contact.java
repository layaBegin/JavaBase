package com.heima.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

/**
 * 联系人实体类
 */
public class Contact {

    private int id;  //编号
    private String name;  //姓名
    private String phone;  //电话
    private String email;  //邮箱
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date birthday;  //生日

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                '}';
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}