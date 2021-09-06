package com.heima.travel.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heima.travel.domain.ResultInfo;
import com.heima.travel.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "UserLoginFilter",urlPatterns = {"/cart/*","/order/*"})
public class UserLoginFilter implements Filter {


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        if (user == null){
            ResultInfo resultInfo = new ResultInfo(false, "未登录");
            String json = new ObjectMapper().writeValueAsString(resultInfo);
            //设置响应格式为json
            response.setContentType("application/json; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(json);
        }else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }
    public void destroy() {
    }

}
