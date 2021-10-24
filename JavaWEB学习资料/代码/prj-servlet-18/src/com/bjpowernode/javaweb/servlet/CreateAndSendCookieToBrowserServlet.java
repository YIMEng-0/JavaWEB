package com.bjpowernode.javaweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAndSendCookieToBrowserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//创建Cookie对象
		Cookie cookie1 = new Cookie("username","zhangsan");
		Cookie cookie2 = new Cookie("password","123");
		
		//设置Cookie的关联路径
		//cookie1.setPath(request.getContextPath() + "/king");
		//cookie2.setPath(request.getContextPath() + "/king");
		
		//设置Cookie的有效期
		cookie1.setMaxAge(60 * 60);
		cookie2.setMaxAge(60 * 60 * 24);
		
		//将Cookie对象发送给浏览器客户端
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		
	}

}
