package com.heima.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/** 自定义全局过滤器 */
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("==全局过滤器MyGlobalFilter==");
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (StringUtils.isBlank(token)){
            // 设置响应状态码: 401 未授权
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            // 返回响应完成
            return exchange.getResponse().setComplete();
        }
        // 放行，让其它的过滤器继续执行
        return chain.filter(exchange);
    }
    @Override
    public int getOrder() {
        // 值越小越先执行
        return 1;
    }
}
