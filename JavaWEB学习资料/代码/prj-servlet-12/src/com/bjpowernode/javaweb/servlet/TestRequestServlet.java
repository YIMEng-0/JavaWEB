package com.bjpowernode.javaweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestRequestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//通过request对象获取客户端IP地址
		//String remoteAddr = request.getRemoteAddr();
		//System.out.println("IP = " + remoteAddr);
		
		//获取应用程序的根路径
		//contextPath (上下文根路径)
		//String contextPath = request.getContextPath();
		//System.out.println("contextPath = " + contextPath); //   /prj-servlet-12
		
		//获取URI
		//String uri = request.getRequestURI();
		//System.out.println("uri = " + uri);//   /prj-servlet-12/test/request
		
		//获取URL
		//String url = request.getRequestURL().toString();
		//System.out.println("url = " + url); // http://localhost:8080/prj-servlet-12/test/request
		
		//获取servlet path (url-pattern标签中的路径)
		String servletPath = request.getServletPath();
		System.out.println("servletPath = " + servletPath); //  /test/request
		
	}

}
