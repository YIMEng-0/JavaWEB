package com.bjpowernode.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理用户登录的Servlet
 * @author Administrator
 *
 */
public class LoginServlet extends GenericServlet {
	
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		/**
		 * LoginServlet处理的请求是一个登录请求，服务器端的java程序有义务检查该请求是否是POST请求，
		 * 若是POST请求，则继续处理请求。
		 * 若是GET请求，则应该提示错误信息。
		 * 服务器端程序有必要做请求方式的检查
		 */
		//1、获取请求方式
		//请求方式在请求协议的请求行上的第一部分中，请求协议的全部数据都被Tomcat服务器自动封装到request对象中
		//可以从request这个请求对象中获取请求方式
		String method = request.getMethod();
		
		//2、判断请求方式是否是POST
		if("GET".equals(method)){
			//报错
			//前端显示错误消息
			out.print("405-您必须在前端发送POST请求");
			//后台显示错误消息
			throw new RuntimeException("405-前端发送的请求方式要求是POST，您发送的是GET");
		}else if("POST".equals(method)){
			//继续处理请求
			out.print("正在身份认证，请稍后...");
		}
		
	}

}
