package com.heima.entity;

import lombok.Data;

@Data
public class Order {
    private Integer oid;
    private String address;
    private Double total;
    private User user;  //包含了用户对象
}
