package com.heima.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/order")
@DefaultProperties(defaultFallback = "defaultFallback")  // 指定默认降级方法
public class OrderController {

    /** 注入发现者 */
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    /** 根据主键id查询用户 */
    @GetMapping("/{id}")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),// 触发熔断的最小请求次数，默认20次
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="20000"),//休眠时长，默认是5000毫秒
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="50")// 触发熔断的失败请求最小占比，默认50%
    })
    public String findOne(@PathVariable("id")Long id){

        /*// 根据服务id获取该服务的全部服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        // 获取第一个服务实例(因为目前我们只有一个服务实例)
        ServiceInstance serviceInstance = instances.get(0);

        // 获取服务实例所在的主机
        String host = serviceInstance.getHost();
        // 获取服务实例所在的端口
        int port = serviceInstance.getPort();

        // 定义服务实例访问URL
        String url = "http://" + host + ":" + port + "/user/" + id;
        System.out.println("服务实例访问URL: " + url);
        return restTemplate.getForObject(url, User.class);*/

        /*// 定义服务实例访问URL
        String url = "http://user-service/user/" + id;
        return restTemplate.getForObject(url, String.class);*/

        if (id == 1){
            throw new RuntimeException("太忙了！");
        }
        // 定义服务实例访问URL
        String url = "http://user-service/user/" + id;
        return restTemplate.getForObject(url, String.class);
    }
    /**
     * 降级方法：返回值和参数必须和接口的方法保持一致
     * @param id
     * @return
     */
    public String findOneFallback(Long id){
        return "对不起，网络太拥挤了！";
    }
    /**
     * 默认降级方法，返回值类型必须是String
     * @return
     */
    public String defaultFallback(){
        return "默认提示：对不起，网络太拥挤了！";
    }
}
