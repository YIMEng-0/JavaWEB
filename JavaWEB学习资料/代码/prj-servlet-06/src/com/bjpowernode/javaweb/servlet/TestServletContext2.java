package com.bjpowernode.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestServletContext2 implements Servlet {

	private ServletConfig config;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		ServletContext application = config.getServletContext();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//org.apache.catalina.core.ApplicationContextFacade@152dedc
		out.print("application = " + application);
		
		//从Servlet上下文中获取某个数据
		Object obj = application.getAttribute("user");
		System.out.println(obj);
	}

	@Override
	public void destroy() {
	}
	
	@Override
	public ServletConfig getServletConfig() {
		return config;
	}
	
	@Override
	public String getServletInfo() {
		return null;
	}


}
