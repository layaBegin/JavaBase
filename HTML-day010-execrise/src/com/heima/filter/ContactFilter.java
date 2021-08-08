package com.heima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "ContactFilter",urlPatterns = "/*",dispatcherTypes = {DispatcherType.FORWARD ,DispatcherType.REQUEST,DispatcherType.INCLUDE})
public class ContactFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        chain.doFilter(req,resp);
        System.out.println("通过过滤器");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器初始化");
    }

}
