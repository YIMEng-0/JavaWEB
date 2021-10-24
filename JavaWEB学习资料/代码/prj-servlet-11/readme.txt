prj-servlet-11
	
	研究：javax.servlet.http.HttpServletRequest接口
	
		1、javax.servlet.http.HttpServletRequest是一个接口，代表了请求
		它的父接口：javax.servlet.ServletRequest
		
		2、javax.servlet.http.HttpServletRequest接口的实现类是：org.apache.catalina.connector.RequestFacade
		在Tomcat服务器中：
			public org.apache.catalina.connector.RequestFacade implements javax.servlet.http.HttpServletRequest{}
		
		3、HttpServletRequest是一个请求对象，该对象中包装了HTTP请求协议的全部信息。
		表单提交的数据都在request对象中，面向request可以获取表单中的数据。
		
		4、一次请求对应一个request对象。10次请求对应10个不同的request对象。
		什么是一次请求？
			“目前为止”，在浏览器上点击超链接，到最终浏览器网页停止下来，可以视为一次完整的请求。
		
		5、javax.servlet.http.HttpServletRequest接口中有哪些常用的方法?
		
				- String 	getParameter(String name) 
				- String[] 	getParameterValues(String name)
				- Map 	getParameterMap()
				- Enumeration 	getParameterNames()
				
				
				- Object 	getAttribute(String name)
				- void 	setAttribute(String name, Object o)
				- void 	removeAttribute(String name)
				- RequestDispatcher 	getRequestDispatcher(String path)
				
				- String 	getRemoteAddr()

				- String 	getContextPath()
				
				- String 	getMethod()
				
				- String 	getRequestURI()
				- StringBuffer 	getRequestURL()
				
				- String 	getServletPath()
				
				------------------------以后讲-------------------------------
				
				- HttpSession 	getSession()
				- HttpSession 	getSession(boolean create)
				
				- void 	setCharacterEncoding(String env)
				
				- Cookie[] 	getCookies()
				
