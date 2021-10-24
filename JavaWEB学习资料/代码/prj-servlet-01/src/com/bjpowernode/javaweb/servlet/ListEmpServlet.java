package com.bjpowernode.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ListEmpServlet implements Servlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>                  ");
		out.print("<head>                  ");
		out.print("<title>员工信息</title>     ");
		out.print("</head>                 ");
		out.print("<body>                  ");
		out.print("员工信息列表                  ");
		out.print("<br>");
		out.print("员工信息列表                  ");
		out.print("</body>                 ");
		out.print("</html>                 ");
	}

	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}
}
