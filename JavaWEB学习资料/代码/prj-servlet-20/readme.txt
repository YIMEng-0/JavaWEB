prj-servlet-20
	
	关于url-pattern的编写方式和路径的总结
		
		1、路径的编写形式：
		
			- <a href="/项目名/资源路径"></a>
			- <form action="/项目名/资源路径"></form>
			- 重定向：response.sendRedirect("/项目名/资源路径");
			- 转发：request.getRequestDispatcher("/资源路径").forward(request,response);
			- 欢迎页面
				<welcome-file-list>
					<welcome-file>资源路径</welcome-file>
				</welcome-file-list>
			- servlet路径
				<servlet>
					<servlet-name>hello</servlet-name>
					<servlet-class>com.bjpowernode.javaweb.servlet.HelloServlet</servlet-class>
				</servlet>
				<servlet-mapping>
					<servlet-name>hello</servlet-name>
					<url-pattern>/资源路径</url-pattern>
				</servlet-mapping>
			- Cookie设置path
				cookie.setPath("/项目名/资源路径");
			- ServletContext
				ServletContext application = config.getServletContext();
				application.getRealPath("/WEB-INF/classes/db.properties");
				application.getRealPath("/资源路径");
				
		2、url-pattern的编写方式
			2.1 url-pattern可以编写多个
			2.2 精确匹配
				<url-pattern>/hello</url-pattern>
				<url-pattern>/system/hello</url-pattern>
			2.3 扩展匹配
				<url-pattern>/abc/*</url-pattern>
			2.4 后缀匹配
				<url-pattern>*.action</url-pattern>
				<url-pattern>*.do</url-pattern>
			2.5 全部匹配
				<url-pattern>/*</url-pattern>
			
			
			
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
							