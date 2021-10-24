package com.bjpowernode.javaweb.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取用户表单提交的用户信息
		String username = request.getParameter("username");
		//JDBC连接数据库完成保存操作
		Connection conn = null;
		PreparedStatement ps = null;
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3366/bjpowernode", "root", "123");
			conn.setAutoCommit(false);
			String sql = "insert into t_user(username) values(?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			count = ps.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			if(conn != null){
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally{
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if( conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		//保存成功跳转到成功页面
		if(count == 1){
			//转发
			//request.getRequestDispatcher("/saveSuccess.html").forward(request, response);
			//重定向
			response.sendRedirect(request.getContextPath() + "/saveSuccess.html");
		}
	}

}
