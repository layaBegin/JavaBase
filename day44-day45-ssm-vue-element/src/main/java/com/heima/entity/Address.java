package com.heima.entity;

import java.io.Serializable;

/**
 * 地址实体类
 */
public class Address implements Serializable {

    private Integer aid;

    private String contact;

    private String address;

    private String telephone;

    private String isdefault;

    private Integer uid;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(String isdefault) {
        this.isdefault = isdefault;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", isdefault='" + isdefault + '\'' +
                ", uid=" + uid +
                '}';
    }
}
