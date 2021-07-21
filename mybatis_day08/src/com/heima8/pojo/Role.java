package com.heima8.pojo;

import java.awt.*;
import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {
    private Integer id;
    private String role_name;
    private String role_desc;
    private List<User> list;

    public Role() {
    }

    public Role(Integer id, String role_name, String role_desc, List<User> list) {
        this.id = id;
        this.role_name = role_name;
        this.role_desc = role_desc;
        this.list = list;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_desc() {
        return role_desc;
    }

    public void setRole_desc(String role_desc) {
        this.role_desc = role_desc;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                ", role_desc='" + role_desc + '\'' +
                ", list=" + list +
                '}';
    }
}
