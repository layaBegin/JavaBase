package com.heima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebFilter(filterName = "WordFilter",urlPatterns = "/word")
public class WordFilter implements Filter {
    List<String> words = new ArrayList<>();

    public void init(FilterConfig config) throws ServletException {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/words.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream,"utf-8"))) {
            String l;
            while ((l = bufferedReader.readLine()) != null ){
                words.add(l);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("所有敏感词汇：" + words);
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest hReq = (HttpServletRequest) req;
        HttpServletResponse hResp = (HttpServletResponse) resp;
        hResp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = hResp.getWriter();
        String message = hReq.getParameter("message");
        for (String word : words){
            if (message.contains(word)){

                writer.println("dfd");
                return;
            }
        }
        chain.doFilter(req, resp);
    }


    public void destroy() {

    }

}
