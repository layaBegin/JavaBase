package com.heima.service;

import com.heima.entity.Address;
import com.heima.entity.PageBean;

public interface AddressService {

    /**
     * 通过aid查询一个地址
     */
    Address findByAid(int aid);

    /**
     * 通过uid查询某个用户1页的地址
     * @param current 第几页
     * @param size 每页大小
     * @param uid 用户id
     */
    PageBean<Address> findAddress(int current, int size, int uid,String address,String telephone);

    //PageBean<Address> findLikeAddress(String address, String telephone, int uid);

    /**
     * 保存地址
     * @param address
     */
    void save(Address address);

    /**
     * 更新地址信息
     * @param address
     */
    void update(Address address);

    /**
     * 删除
     * @param aid
     */
    void delete(Integer aid);

    /**
     * 设置默认地址
     * @param uid 用户id
     * @param aid 地址id
     */
    void changeDefaultAddress(Integer uid, Integer aid);
}
