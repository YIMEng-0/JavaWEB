package com.bjpowernode.javaweb.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet implements Servlet {

	public LoginServlet(){
		System.out.println("LoginServlet's Constructor execute!");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoginServlet's init method execute!");
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginServlet's service method execute!");
	}

	@Override
	public void destroy() {
		System.out.println("LoginServlet's destroy method execute!");
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
