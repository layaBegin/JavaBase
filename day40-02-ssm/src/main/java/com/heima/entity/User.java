package com.heima.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class User {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    private Integer deptId;
    private Dept dept;
}
