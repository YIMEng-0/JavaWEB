package com.bjpowernode.crm.web.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.crm.entity.Customer;
import com.bjpowernode.crm.util.DBUtil;

public class ListCustomerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			conn = DBUtil.getConnection();
			String sql = "select id,realname,birth,sex,tel from t_customer";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				
				String id = rs.getString("id");
				String realname = rs.getString("realname");
				String birth = rs.getString("birth");
				String sex = rs.getString("sex");
				String tel = rs.getString("tel");
				
				Customer customer = new Customer();
				customer.setId(id);
				customer.setRealname(realname);
				customer.setSex(sex);
				customer.setBirth(birth);
				customer.setTel(tel);
				
				customerList.add(customer);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(conn, ps, rs);
		}
		
		//转发
		request.setAttribute("customerList", customerList);
		request.getRequestDispatcher("/list.jsp").forward(request, response);
		
	}

}

















