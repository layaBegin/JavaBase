package com.heima.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
@EnableConfigurationProperties(RedisConfig.class)
public class RedisAutoConfiguration {

    @Autowired //从容器中取
    private RedisConfig redisConfig;


    @Bean
    public Jedis getJedis(){
        return new Jedis(redisConfig.getHost(),redisConfig.getPort());
    }
}
