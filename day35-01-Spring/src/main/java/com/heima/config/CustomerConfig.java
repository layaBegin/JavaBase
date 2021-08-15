package com.heima.config;

import com.heima.service.CustomerService;
import com.heima.service.impl.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean("customer")
    public CustomerService getCustomerServiceImpl(){
        return  new CustomerServiceImpl();
    }
}
