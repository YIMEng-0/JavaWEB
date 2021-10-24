package com.bjpowernode.javaweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//public class LoginServlet extends HttpServlet {
public class LoginServlet extends javax.servlet.http.HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().print("login..........");
	}

}
