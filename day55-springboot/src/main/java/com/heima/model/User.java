package com.heima.model;

import lombok.Data;

@Data
public class User {

    private Long id; //id

    private String username; //用户名

    private String password; //密码

    private Integer age; //年龄

    private String email; //邮箱

    private Integer sex; //性别


}
