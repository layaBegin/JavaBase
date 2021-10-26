package com.heima.service;


import com.heima.model.Contract;

import java.util.List;
import java.util.Map;

public interface ContractService {


    public List<Contract> findByShipTime(String shipTime);
    public List<Map<String,Object>> getAmount();
    public List<Map<Object,Object>> getHour();

}

