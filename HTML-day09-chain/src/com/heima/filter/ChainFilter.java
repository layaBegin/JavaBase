package com.heima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 过滤器链脚本的执行顺序
 * 1，注解方式：根据 className 是首字母顺序
 * 2，xml配置方式：根据配置的先后顺序
 */
@WebFilter(filterName = "ChainFilter",urlPatterns = "/chain",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})
public class ChainFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        System.out.println("过滤器1开始");
        chain.doFilter(req, resp);
        System.out.println("过滤器1结束");

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
