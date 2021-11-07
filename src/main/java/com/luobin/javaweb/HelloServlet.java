package com.luobin.javaweb;

// javaEE9 是 jakartaEE9 就不是javax
import javax.servlet.*;
import java.io.IOException;

/**
 * @author Doraemon
 * @version 1.0
 * @date 2021/11/7 9:56 下午
 */
public class HelloServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("My first servlet , Hello Servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
