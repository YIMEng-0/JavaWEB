prj-servlet-04
	
	关于一个web站点的欢迎页面的设置
		
		1、设置欢迎页面的作用：
			在访问该web站点的时候，没有提供任何资源路径，直接访问的是该web站点的欢迎页面
			若欢迎页面没有进行相关的设置，会出现404
			例如：访问 http://localhost:8080/prj-servlet-04/
			直接跳转到欢迎页面，但是没有设置欢迎页面的时候，出现404错误
		
		2、当修改web.xml文件的时候，保存之后，Tomcat服务器会自动重新解析web.xml文件，
		这个时候，就相当于项目重新部署了。
		
		2、怎么设置欢迎页面?
			修改web.xml文件：
			<welcome-file-list>
				<welcome-file>login.html</welcome-file>
				<welcome-file>save.html</welcome-file>
				<welcome-file>welcome.html</welcome-file>
				<welcome-file>html/welcome.html</welcome-file>
			</welcome-file-list>
			注意：
				欢迎页面可以设置多个，第一个优先级最高，以此类推
				欢迎页面路径问题：不需要以“/”开始，但是从WebRoot作为起点
		
		3、欢迎页面必须是一个HTML吗?可以是Servlet吗？
			欢迎页面也可以是一个Servlet
			例如：
			<servlet>
				<servlet-name>deleteServlet</servlet-name>
				<servlet-class>com.bjpowernode.javaweb.servlet.DeleteServlet</servlet-class>
			</servlet>
			<servlet-mapping>
				<servlet-name>deleteServlet</servlet-name>
				<url-pattern>/user/delete</url-pattern>
			</servlet-mapping>
			<welcome-file-list>
				<welcome-file>user/delete</welcome-file>
			</welcome-file-list>
		
		4、当前web站点没有设置任何欢迎页面的话，欢迎页面是：index.html、index.htm、index.jsp
		这是怎么回事？
			是因为在CATALINA_HOME/conf/web.xml文件中有全局配置：
			<welcome-file-list>
		        <welcome-file>index.html</welcome-file>
		        <welcome-file>index.htm</welcome-file>
		        <welcome-file>index.jsp</welcome-file>
		    </welcome-file-list>
		   	在当前webapp中配置的欢迎页面属于局部配置，局部优先(就近原则)
			
			
			
			
			
			
			