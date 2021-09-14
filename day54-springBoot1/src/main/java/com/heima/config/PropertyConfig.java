package com.heima.config;

import com.heima.entity.User;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "my")
public class PropertyConfig {

    private String host;
    private Integer port;
    private User user;//@Value注解不能读取引用类型数据,所以用 ConfigurationProperties

    private String address[];
    private List<User> userList;

    public PropertyConfig() {
    }

    public PropertyConfig(String host, Integer port, User user, String[] address, List<User> userList) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.address = address;
        this.userList = userList;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
