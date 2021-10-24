package com.bjpowernode.javaweb.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public abstract class GenericServlet implements Servlet {

	private ServletConfig config;
	
	@Override
	public final void init(ServletConfig config) throws ServletException {
		this.config = config;
		this.init();
	}

	/**
	 * 子类若希望在初始化的时候执行一段特殊的程序，建议重写没有参数的init方法
	 */
	public void init() {
	}

	@Override
	public abstract void service(ServletRequest req, ServletResponse res) throws ServletException, IOException ;

	@Override
	public void destroy() {
	}
	
	@Override
	public ServletConfig getServletConfig() {
		return config;
	}
	
	@Override
	public String getServletInfo() {
		return "";
	}
	
	//--------------------------------------扩展方法，方便子类的使用-----------------------------------------------
	public ServletContext getServletContext(){
		return getServletConfig().getServletContext();
	}
	
	//.................
	

}
