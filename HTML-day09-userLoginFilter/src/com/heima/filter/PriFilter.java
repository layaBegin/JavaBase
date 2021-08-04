package com.heima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * 注意：urlPatterns = "/admin/*" 必须添加、admin
 * 如果设置成 /* 会导致永远无法登录
 * 否则死循环

 */
@WebFilter(filterName = "PriFilter",urlPatterns = "/admin/*")
public class PriFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        HttpSession session = httpServletRequest.getSession();
        String user = (String)session.getAttribute("user");

        if (user == null){
            System.out.println("拦截到了非法请求" + httpServletRequest.getRemoteAddr());

            httpServletResponse.sendRedirect("/index.jsp");
            return;
        }else {
            //放行
            chain.doFilter(req, resp);

        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
