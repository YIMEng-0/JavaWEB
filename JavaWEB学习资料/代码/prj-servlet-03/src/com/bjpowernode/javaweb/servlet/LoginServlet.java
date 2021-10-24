package com.bjpowernode.javaweb.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet implements Servlet {

	public LoginServlet(){
		System.out.println("LoginServlet's constructor invoke!");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoginServlet's init method invoke!");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("LoginServlet's service method invoke!");
	}

	@Override
	public void destroy() {
		System.out.println("LoginServlet's destroy method invoke!");
	}
	
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}
	
	@Override
	public String getServletInfo() {
		return null;
	}

}
