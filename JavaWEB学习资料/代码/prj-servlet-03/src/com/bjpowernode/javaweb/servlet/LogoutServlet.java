package com.bjpowernode.javaweb.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogoutServlet implements Servlet {

	public LogoutServlet(){
		System.out.println("LogoutServlet's constructor invoke!");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LogoutServlet's init method invoke!");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("LogoutServlet's service method invoke!");
	}

	@Override
	public void destroy() {
		System.out.println("LogoutServlet's destroy method invoke!");
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
