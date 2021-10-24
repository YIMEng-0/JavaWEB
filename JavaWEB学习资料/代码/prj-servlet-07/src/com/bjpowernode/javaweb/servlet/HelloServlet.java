package com.bjpowernode.javaweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//public class HelloServlet extends GenericServlet {
public class HelloServlet extends javax.servlet.GenericServlet {

	@Override
	public void init() {
		System.out.println("HelloServlet's init method execute");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("HelloServlet's service method execute!");
	}

}
