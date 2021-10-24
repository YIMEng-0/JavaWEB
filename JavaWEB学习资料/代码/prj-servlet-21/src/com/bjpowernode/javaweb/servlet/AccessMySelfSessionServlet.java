package com.bjpowernode.javaweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccessMySelfSessionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ip = request.getRemoteAddr();
		HttpSession session = request.getSession();
		System.out.println(ip + "'s session = " + session);
		
		//向会话范围中存储一个数据
		session.setAttribute("username", "zhangsan");
	}

}
