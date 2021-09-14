package com.heima.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.heima.model.enums.SexEnum;
import lombok.Data;

/**
 * 注意：因为以后单表sql语句是自动生成，所以需要指定表名
 * 如果实体类没有与表名对应，需要使用@TableName指定表名。
 */
//@TableName("tb_user")
@Data
public class User {

    //如果主键自增，建议带上TableId 主键自增改成Long 就不行了
    //@TableId(type=IdType.AUTO)//不管基本数据类型还是包装数据类型都可以实现自增
    private Long id;

    private String userName;

    //如果实体类的属性名与数据库的列名不对应，需要使用@TableField注解指定列名是什么
    @TableField("password")
    private String password1;

    private String name;

    private Integer age;

    private String email;

    private SexEnum sex;
    //如果该属性在数据库中是没有对应列名，要使用@TableField(exist = false)
    @TableField(exist = false)//指定该属性在数据库中是没有对应列名
    private String info;


}
