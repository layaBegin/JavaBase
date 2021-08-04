package com.heima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "DhainFilter",urlPatterns = "/chain",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})
public class DhainFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        System.out.println("过滤器2开始");
        chain.doFilter(req, resp);
        System.out.println("过滤器2结束");

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
