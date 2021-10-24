package com.bjpowernode.javaweb.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestServletConfig2 implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		//org.apache.catalina.core.StandardWrapperFacade@1f1ce01
		System.out.println("TestServletConfig2 = " + config);
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	public void destroy() {
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
