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
 * 要求前端发送的请求必须是GET请求，发送POST请求应该报错
 * @author Administrator
 *
 */
public class HelloServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String method = request.getMethod();
		if("POST".equals(method)){
			out.print("405-您必须在前端发送GET请求");
			throw new RuntimeException("405-前端发送的请求方式要求是GET，您发送的是POST");
		}else if("GET".equals(method)){
			out.print("hello servlet!");
		}
	}

}
