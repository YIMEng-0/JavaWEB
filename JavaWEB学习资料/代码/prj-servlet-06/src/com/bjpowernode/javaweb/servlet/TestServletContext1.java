package com.bjpowernode.javaweb.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.bjpowernode.javaweb.entity.User;

public class TestServletContext1 implements Servlet {

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
		
		//测试ServletContext接口中常用方法
		//获取上下文参数中所有的name
		Enumeration<String> names = application.getInitParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			//通过上下文参数的name获取value
			String value = application.getInitParameter(name);
			System.out.println(name + "=" + value);
		}
		
		//获取文件在web服务器中的绝对路径
		String absolutePath = application.getRealPath("/index.html");
		System.out.println(absolutePath);
		
		String dbFilePath = application.getRealPath("/WEB-INF/classes/db.properties");
		System.out.println(dbFilePath);
		
		//直接获取文件输入流
		InputStream in = application.getResourceAsStream("/WEB-INF/classes/db.properties");
		Properties pro = new Properties();
		pro.load(in);
		in.close();
		
		String driver = pro.getProperty("driver");
		String url = pro.getProperty("url");
		String user = pro.getProperty("user");
		String password = pro.getProperty("password");
		
		System.out.println(driver);
		System.out.println(url);
		System.out.println(user);
		System.out.println(password);
		
		//向ServletContext上下文对象中绑定数据
		User u = new User();
		u.setId(120);
		u.setName("zhangsan");
		application.setAttribute("user", u);
		
		
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
