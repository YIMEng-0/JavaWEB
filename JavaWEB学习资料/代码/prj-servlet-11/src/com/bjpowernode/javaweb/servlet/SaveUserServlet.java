package com.bjpowernode.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//org.apache.catalina.connector.RequestFacade
		//out.print("request = " + request);
		
		//从request请求对象中获取表单提交的数据
		//浏览器表单提交的数据格式：
		//username=jack&password=123&sex=m&interest=sport&interest=music&interest=food&grade=db&introduce=jackok
		//以上数据放到了request对象中，以Map形式存储的，HttpServletRequest对象中有一个Map属性，专门存储表单中提交的数据
		/*
		 * Map<String,String[]>
		 * ---key-------------value---------------------
		 * username			{"jack"}
		 * password			{"123"}
		 * sex				{"m"}
		 * interest			{"sport","music","food"}
		 * grade			{"db"}
		 * introduce		{"jackok"}
		 * 
		 * 以上Map集合的value是一个String类型的一维数组，这个一维数组中多数情况下都是一个元素。
		 */
		//通过request获取参数Map集合
		Map<String,String[]> parameterMap = request.getParameterMap();
		Set<String> parameterNames = parameterMap.keySet();
		for(String parameterName : parameterNames){
			String[] parameterValues = parameterMap.get(parameterName);
			System.out.println(parameterName + "=" + parameterValues);
		}
		
		//通过参数的name获取参数的value【实际上：获取Map集合中一维数组的首元素】
		//这个方法使用最多，因为一维数组多数情况下只有一个元素。
		//这个方法不适合获取复选框的数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String interest = request.getParameter("interest");
		String grade = request.getParameter("grade");
		String introduce = request.getParameter("introduce");
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(sex);
		System.out.println(interest);
		System.out.println(grade);
		System.out.println(introduce);
		
		//通过参数Map集合的key获取value，返回的是一个一维数组
		//这个方法使用比较多，适合于checkbox数据的获取
		String[] interests = request.getParameterValues("interest");
		for(String in : interests){
			System.out.println(in);
		}
		
		//获取所有参数name
		//获取Map集合的所有的key
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			System.out.println(name);
		}
		
		
		
	}

}
