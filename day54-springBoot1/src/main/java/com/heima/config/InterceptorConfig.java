package com.heima.config;

import com.heima.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//第二步: 自定义配置类实现WebMvcConfigurer接口,注册拦截器
@Configuration //表示是一个配置类，并创建了该类的对象
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/prop2");
    }
}
