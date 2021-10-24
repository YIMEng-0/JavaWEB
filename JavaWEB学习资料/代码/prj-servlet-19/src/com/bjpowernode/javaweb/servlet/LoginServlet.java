package com.bjpowernode.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取用户名和密码
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//JDBC连接数据库验证用户名和密码
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean loginSuccess = false;
		String realName = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3366/bjpowernode", "root", "123");
			String sql = "select id,username,password,realname from t_user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()){
				loginSuccess = true;
				realName = rs.getString("realname");
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
		
		if(loginSuccess){
			//登录成功之后，获取用户是否选择了十天内免登录
			String tenDayAutoLoginFlag = request.getParameter("tenDayAutoLoginFlag");
			if("ok".equals(tenDayAutoLoginFlag)){
				//创建Cookie对象
				Cookie cookie1 = new Cookie("username",username);
				Cookie cookie2 = new Cookie("password",password);
				//设置有效时间
				cookie1.setMaxAge(60 * 60 * 24 * 10);
				cookie2.setMaxAge(60 * 60 * 24 * 10);
				//设置关联路径
				cookie1.setPath(request.getContextPath());
				cookie2.setPath(request.getContextPath());
				//发送Cookie给浏览器
				response.addCookie(cookie1);
				response.addCookie(cookie2);
			}
			
			//登录成功跳转到成功页面
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<head>");
			out.print("<title>欢迎页面</title>");
			out.print("</head>");
			out.print("<body>");
			out.print("欢迎");
			out.print(realName);
			out.print("访问");
			out.print("</body>");
			out.print("</html>");
		}else{
			//登录失败跳转到失败页面
			response.sendRedirect(request.getContextPath() + "/login-error.html");
		}
		
	}

}










