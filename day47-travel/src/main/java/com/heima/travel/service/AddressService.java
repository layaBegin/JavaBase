package com.heima.travel.service;

import com.heima.travel.domain.Address;

import java.util.List;

public interface AddressService {

    List<Address> findAddressByUid(Integer uid);
    Address findByAid(Integer aid);

}
