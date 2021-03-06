package com.heima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // 启用eureka-server功能
@SpringBootApplication
public class EurekaServerApplication {
    public static void main(String[] args){

        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
