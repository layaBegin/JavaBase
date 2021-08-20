package com.heima.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Account {

    private Integer id;
    private String name;
    private Address address;  //POJO包装类
    private List<String> list;
    private List<Address> listAddress;
    private Map<String,Address> mapAddress;

}
