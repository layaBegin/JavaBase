package com.heima.travel.service.impl;

import com.heima.travel.dao.AddressDao;
import com.heima.travel.domain.Address;
import com.heima.travel.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;
    @Override
    public List<Address> findAddressByUid(Integer uid) {
        return addressDao.findAddressByUid(uid);
    }

    @Override
    public Address findByAid(Integer aid) {
        return addressDao.findByAid(aid);
    }


}
