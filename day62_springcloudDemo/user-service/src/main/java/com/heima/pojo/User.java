package com.heima.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 用户实体类
 */
@TableName("tb_user") // 指定表名
@Data
public class User {
    @TableId(type = IdType.AUTO)  // 指定主键自增
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
