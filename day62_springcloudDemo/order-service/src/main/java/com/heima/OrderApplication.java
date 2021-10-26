package com.heima;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient // 开启Eureka客户端
@SpringBootApplication
@EnableCircuitBreaker // 开启熔断器
@EnableFeignClients // 开启Feign客户端
public class OrderApplication {

    public static void main(String[] args){
        SpringApplication.run(OrderApplication.class, args);
    }
    @Bean
    @LoadBalanced // 负载均衡注解
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    // Feign日志级别
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
