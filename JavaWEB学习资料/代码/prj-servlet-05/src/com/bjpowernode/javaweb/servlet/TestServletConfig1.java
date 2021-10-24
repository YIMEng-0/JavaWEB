package com.bjpowernode.javaweb.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestServletConfig1 implements Servlet {

	private ServletConfig config;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//org.apache.catalina.core.StandardWrapperFacade@146a8d2
		//System.out.println("TestServletConfig1 = " + config);
		
		this.config = config;
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		
		//1、通过初始化参数的name获取value
		String driver = config.getInitParameter("driver");
		String url = config.getInitParameter("url");
		String user = config.getInitParameter("user");
		String password = config.getInitParameter("password");
		
		System.out.println(driver);
		System.out.println(url);
		System.out.println(user);
		System.out.println(password);
		
		//2、获取所有初始化参数的name
		Enumeration<String> names = config.getInitParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			String value = config.getInitParameter(name);
			System.out.println(name+"=" +value);
		}
		
		//3、通过ServletConfig获取ServletContext对象
		ServletContext application = config.getServletContext();
		//org.apache.catalina.core.ApplicationContextFacade@1b7f4c6
		System.out.println("application = " + application);
		
		
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
