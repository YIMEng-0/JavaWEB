package com.bjpowernode.javaweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		String username = request.getParameter("username");
		//将username通过ISO-8859-1的编码方式进行解码还原，回归最原始的二进制码
		byte[] bytes = username.getBytes("ISO-8859-1");
		//再找一种编码方式，要求这种编码方式和浏览器上的编码方式一致，进行重新编码【重新组装】
		username = new String(bytes,"UTF-8");
		System.out.println(username);
		*/
		
		//以下无法解决GET请求中的乱码问题
		/*
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		System.out.println(username);
		*/
		
		String username = request.getParameter("username");
		System.out.println(username);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*
		String username = request.getParameter("username");
		//将username通过ISO-8859-1的编码方式进行解码还原，回归最原始的二进制码
		byte[] bytes = username.getBytes("ISO-8859-1");
		//再找一种编码方式，要求这种编码方式和浏览器上的编码方式一致，进行重新编码【重新组装】
		username = new String(bytes,"UTF-8");
		System.out.println(username);
		*/
		
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		System.out.println(username);
	}

}
