package com.heima.travel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户实体类
 * Serializable : java 对象以2进制形式进行传输都需要实现这个接口 1，对象写入文件；2，网络传输java对象（duboo技术）
 */
@Data
@NoArgsConstructor  //几乎spring所有的框架都依赖无参构造，如果写有参构造，一定要写无参构造
@AllArgsConstructor
public class User implements Serializable {

    private int uid;//用户id
    private String username;//用户名，账号
    private String password;//密码
    private String telephone;//手机号
    private String salt; // 盐

}
