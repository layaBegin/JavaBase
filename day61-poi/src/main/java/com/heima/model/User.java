package com.heima.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_user")
public class User {

    private Long id; //id

    private String userName; //用户名

    private String password; //密码

    private String name; //姓名

    private Integer age; //年龄

    private String email; //邮箱

    private Integer sex; //性别
}

