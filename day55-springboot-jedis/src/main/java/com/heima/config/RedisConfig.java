package com.heima.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="my")
@Data
public class RedisConfig {

    private String host;
    private Integer port;
}
