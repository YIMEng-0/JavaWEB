prj-servlet-13
	
	javax.servlet.http.HttpServletRequest接口
		- Object 	getAttribute(String name)
		- void 	setAttribute(String name, Object o)
		- void 	removeAttribute(String name)
		- RequestDispatcher 	getRequestDispatcher(String path)
	
		注：
			request对象：
				只要用户发送一个请求，底层就会对应一个request对象。
				发送100个请求，底层则对应有100个不同的request对象。
		
		request对象只能完成在同一次请求中数据的共享
		无法完成跨请求传递数据/共享数据
		
		request是一个请求范围的对象
		
	javax.servlet.RequestDispatcher接口
		- void forward(ServletRequest request,ServletResponse response);
	
	回顾：javax.servlet.ServletContext接口 (ServletContext application = config.getServletContext();)
		- Object 	getAttribute(String name)
		- void 	setAttribute(String name, Object o)
		- void 	removeAttribute(String name)
		ServletContext可以完成跨用户传递数据，跨用户共享数据。
		
		ServletContext是一个应用范围的对象
			
