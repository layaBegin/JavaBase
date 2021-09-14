package com.heima.domain;

import java.sql.Date;

public class User {
    private Integer id;
    private String username;
    private Date birthday;
    private char sex;
    private String address;
    private Integer dept_id;  // user.dept.deptName
    // 添加部门属性
    private Dept dept;  //因为样子我可以直接访问该用户的部门信息



    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDeptId(Integer deptId) {
        this.dept_id = deptId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", dept_id=" + dept_id +
                ", dept=" + dept +
                '}';
    }
}
