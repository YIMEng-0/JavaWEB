prj-servlet-16
	
	1、web系统中资源跳转，怎么做？
		- 需要使用转发机制(forward)和重定向机制(redirect)完成资源跳转
		- 注意：跳转的下一个资源不一定是一个Servlet，下一个资源可能是：JSP、Servlet、html....
		
	2、转发
		- 代码怎么写:
			request.getRequestDispatcher("/b").forward(request,response);
		- 转发是一次请求
		- 转发是request对象触发的
		- 用户点击超链接：http://localhost/prj-servlet-16/a，浏览器地址栏上最终显示的地址也是：http://localhost/prj-servlet-16/a
		- 转发的资源路径中不需要添加contextPath
		- 转发只能完成项目内部资源的跳转
	
	3、重定向
		- 代码怎么写：
			response.sendRedirect("/prj-servlet-16/b");
		- 重定向是两次请求
		- 重定向是response对象触发的
		- 用户点击超链接：http://localhost/prj-servlet-16/a，
		浏览器地址栏上最终显示的地址是：http://localhost/prj-servlet-16/b
		- 重定向的资源路径需要添加contextPath
		- 重定向可以完成跨项目资源跳转
	
	4、转发和重定向的区别
	
	5、什么时候使用转发?什么时候使用重定向?
		- 若跨项目跳转只能用重定向
		- 大部分情况下，重定向使用较多
		- 在上一个程序中向request范围中存储了数据，希望能从下一个程序中将request范围中的数据取出，必须使用转发
		- 重定向可以解决页面刷新问题(F5)
	
	6、这个描述不正确：
		在浏览器上用户点击超链接，到最终网页停下来，是一次请求。这个描述已经不正确了。
		因为这个过程中可能发生重定向操作。
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	