package com.heima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"com.heima.dao","com.heima.service"})
@Import(JDBCConfig.class)
public class SpringConfig {
}
