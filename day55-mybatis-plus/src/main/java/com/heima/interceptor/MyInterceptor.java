package com.heima.interceptor;


import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyInterceptor {

    //定义一个mybatis-plus的拦截器，该拦截器的作用就是在执行sql语句之前拦截，然后拼接limit的语句
    @Bean
    public MybatisPlusInterceptor createPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //添加一个分页的插件给拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }

}
