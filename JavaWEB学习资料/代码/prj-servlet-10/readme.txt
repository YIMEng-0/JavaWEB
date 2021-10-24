prj-servlet-10
	
	1、从此之后不再继承javax.servlet.GenericServlet，直接继承javax.servlet.http.HttpServlet
		POST请求，请重写doPost方法
		GET请求，请重写doGet方法	
	
	2、405错误：表示前端发送的请求方式和后台要求的请求方式不同。请求方式错误