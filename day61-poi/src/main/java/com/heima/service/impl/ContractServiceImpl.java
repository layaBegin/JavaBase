package com.heima.service.impl;

import com.heima.dao.ContractDao;
import com.heima.model.Contract;
import com.heima.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractDao contractDao;

    @Override
    public List<Contract> findByShipTime(String shipTime) {
        return contractDao.findByShipTime(shipTime);
    }

    @Override
    public List<Map<String,Object>> getAmount() {
        return contractDao.getAmount();
    }

    public List<Map<Object,Object>> getHour(){
        return contractDao.getHour();
    }

}
