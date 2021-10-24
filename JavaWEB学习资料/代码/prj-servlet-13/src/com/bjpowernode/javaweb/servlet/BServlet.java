package com.bjpowernode.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//从request范围中取数据
		Object obj = request.getAttribute("pro");
		
		//将request范围中获取到的数据输出到浏览器上
		PrintWriter out = response.getWriter();
		out.print("obj = " + obj);
		
	}

}
