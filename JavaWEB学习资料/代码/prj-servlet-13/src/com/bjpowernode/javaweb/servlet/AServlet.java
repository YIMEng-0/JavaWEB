package com.bjpowernode.javaweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.javaweb.entity.Product;

public class AServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//创建商品对象
		Product product = new Product();
		product.setId("123456");
		product.setName("Note");
		
		//将商品对象存储到request范围中
		request.setAttribute("pro", product);
		
		//AServlet执行结束之后，跳转到BServlet继续执行
		//将AServlet和BServlet执行放到同一个请求当中
		//需要使用转发机制forward
		//要完成转发需要两步【转发是一次请求】
		//1.获取请求转发器，转发器指向要转发的路径
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/b");
		//2.调用转发器对象的forward方法，完成请求转发
		//dispatcher.forward(request, response);
		
		//转发
		request.getRequestDispatcher("/b").forward(request, response);
	}

}
