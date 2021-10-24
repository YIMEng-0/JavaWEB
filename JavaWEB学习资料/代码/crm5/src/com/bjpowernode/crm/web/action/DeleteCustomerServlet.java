package com.bjpowernode.crm.web.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.crm.util.DBUtil;

public class DeleteCustomerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取删除的客户id
		String id = request.getParameter("id");
		//连接数据库删除数据
		Connection conn = null;
		PreparedStatement ps = null;
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			String sql = "delete from t_customer where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			count = ps.executeUpdate();
			DBUtil.commitTransaction(conn);
		} catch (Exception e) {
			DBUtil.rollbackTransaction(conn);
			e.printStackTrace();
		} finally{
			DBUtil.close(conn, ps, null);
		}
		if(count == 1){
			//删除成功，再次跳转到显示客户列表页面
			//重定向到/list
			response.sendRedirect(request.getContextPath() + "/list");
		}
	}

}
