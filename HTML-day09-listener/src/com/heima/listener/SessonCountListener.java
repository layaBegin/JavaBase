package com.heima.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.sql.Timestamp;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class SessonCountListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

     private AtomicInteger count =  new AtomicInteger(0);
    // Public constructor is required by servlet spec
    public SessonCountListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("新来了一个用户 ："+ new Timestamp(System.currentTimeMillis()));
        System.out.println("新来了一个用户 id 是 ："+ session.getId());
        count.incrementAndGet();
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("count",count);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("这个用户跑路了："+ new Timestamp(System.currentTimeMillis()));
        count.decrementAndGet();
        ServletContext servletContext = se.getSession().getServletContext();
        servletContext.setAttribute("count",count);

    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attribute
         is replaced in a session.
      */
    }
}
