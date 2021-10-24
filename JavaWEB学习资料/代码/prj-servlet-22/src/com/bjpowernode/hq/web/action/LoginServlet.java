package com.bjpowernode.hq.web.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjpowernode.hq.entity.User;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//连接数据库验证用户名和密码
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3366/bjpowernode", "root", "123");
			String sql = "select id,username,password from t_user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()){
				//登录成功，将用户信息包装到实体对象User中。
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(user != null){
			
			//登录成功，将登录成功的状态保存，跳转到index.html页面
			
			//获取session对象
			HttpSession session = request.getSession();
			//将登录成功的用户存储到会话范围
			session.setAttribute("user", user);
			//重定向
			response.sendRedirect(request.getContextPath() + "/index.html");
		}else{
			//登录失败跳转到失败页面
			response.sendRedirect(request.getContextPath() + "/login-error.html");
		}
		
	}

}
