package com.bjpowernode.crm.web.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.crm.util.DBUtil;

public class SaveCustomerServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取客户信息
		request.setCharacterEncoding("UTF-8");
		String realname = request.getParameter("realname");
		String birth = request.getParameter("birth");
		String sex = request.getParameter("sex");
		String tel = request.getParameter("tel");
		//JDBC连接数据库保存数据
		Connection conn = null;
		PreparedStatement ps = null;
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			String sql = "insert into t_customer(realname,sex,birth,tel) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, realname);
			ps.setString(2, sex);
			ps.setString(3, birth);
			ps.setString(4, tel);
			count = ps.executeUpdate();
			DBUtil.commitTransaction(conn);
		} catch (Exception e) {
			DBUtil.rollbackTransaction(conn);
			e.printStackTrace();
		} finally{
			DBUtil.close(conn, ps, null);
		}
		//保存成功跳转到成功页面
		if(count == 1){
			response.sendRedirect(request.getContextPath() + "/list.jsp");
		}
	}

}
