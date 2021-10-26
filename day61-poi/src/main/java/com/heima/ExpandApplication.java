package com.heima;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.heima.dao")
public class ExpandApplication {
    public static void main(String[] args) {

        SpringApplication.run(ExpandApplication.class, args);
    }
}

