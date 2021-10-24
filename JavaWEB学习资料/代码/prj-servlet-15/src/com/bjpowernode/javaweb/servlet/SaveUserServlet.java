package com.bjpowernode.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveUserServlet extends HttpServlet {

	//实例变量,在堆中存储,Servlet对象是单例的,username这个变量只有一个
	private String username;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		synchronized(this){
			//解决请求体中的乱码问题
			request.setCharacterEncoding("UTF-8");
			
			//获取数据(局部变量)
			String username = request.getParameter("username");
			
			//实例变量
			//username = request.getParameter("username");
			
			//输出到浏览器
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("恭喜你"+username+"注册成功");
		}
		
		
	}

}
