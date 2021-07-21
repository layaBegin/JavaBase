package com.heima8.pojo;

public class Orders {
    private Integer id;
    private Integer uid;
    private String ordertime;
    private Double money;

    User juser;

    public Orders() {
    }

    public Orders(Integer id, Integer uid, String ordertime, Double money, User user) {
        this.id = id;
        this.uid = uid;
        this.ordertime = ordertime;
        this.money = money;
        this.juser = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public User getUser() {
        return juser;
    }

    public void setUser(User user) {
        this.juser = user;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", uid=" + uid +
                ", ordertime='" + ordertime + '\'' +
                ", money=" + money +
                ", user=" + juser +
                '}';
    }
}
