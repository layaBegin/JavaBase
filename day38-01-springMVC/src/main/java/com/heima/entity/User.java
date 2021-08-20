package com.heima.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class User {
    private String name;
    private Integer age;

    private Address address; //POJO类

    private List<String> hobby;  //字符串集合

    private List<Address> addressList;  //POJO类集合

    private Map<String, Address> map;  //Map集合

}