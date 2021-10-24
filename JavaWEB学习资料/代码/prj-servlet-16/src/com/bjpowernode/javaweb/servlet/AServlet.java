package com.bjpowernode.javaweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//向request范围对象中存储数据
		request.setAttribute("usercode", "110");
		
		//转发forward
		//request.getRequestDispatcher("/b").forward(request, response);
		
		//重定向redirect
		response.sendRedirect("/prj-servlet-16/b");
	}

}
