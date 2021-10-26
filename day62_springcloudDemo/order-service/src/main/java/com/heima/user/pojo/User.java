package com.heima.user.pojo;

import lombok.Data;

import java.sql.Date;

/** 实体类 */
@Data
public class User {
    // 编号
    private Long id;
    // 账号
    private String username;
    // 密码
    private String password;
    // 姓名
    private String name;
    // 年龄
    private Integer age;
    // 性别
    private Integer sex;
    // 生日
    private Date birthday;
    // 创建日期
    private Date created;
    // 修改日期
    private Date updated;
}
