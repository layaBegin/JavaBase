package com.heima.service.impl;

import com.heima.dao.AddressDao;
import com.heima.entity.Address;
import com.heima.entity.PageBean;
import com.heima.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;
    @Override
    public Address findByAid(int aid) {
        return null;
    }

    @Override
    public PageBean<Address> findAddress(int current, int size, int uid,String address, String telephone) {
        //int count = addressDao.findCount(uid);
        int begin = (current - 1)*size;
        List<Address> data = null;
        if (address.isEmpty() && telephone.isEmpty()){
            data = addressDao.findByUid(uid, begin, size);
        }else {
            data = addressDao.findLikeAddress(address,telephone,uid);
        }
        int count = data.size();
        PageBean<Address> addressPageBean = new PageBean<>(data,count,current,size);

        return addressPageBean;
    }

    /*@Override
    public PageBean<Address> findLikeAddress(String address, String telephone, int uid) {
        return addressDao.findLikeAddress(address,telephone,uid);
    }*/

    @Override
    public void save(Address address) {
        address.setIsdefault("0");
        addressDao.save(address);
    }

    @Override
    public void update(Address address) {
        addressDao.update(address);

    }

    @Override
    public void delete(Integer aid) {
        addressDao.delete(aid);
    }

    @Override
    @Transactional
    public void changeDefaultAddress(Integer uid, Integer aid) {
        addressDao.updateAddressIsNotDefault(uid);
        addressDao.updateAddressIsDefault(aid);
    }
}
