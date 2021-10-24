prj-servlet-05
	
	研究javax.servlet.ServletConfig接口:
		
		1、javax.servlet.ServletConfig是接口
		
		2、apache Tomcat服务器对ServletConfig接口的实现类完整类名是：
			org.apache.catalina.core.StandardWrapperFacade
			
			public class org.apache.catalina.core.StandardWrapperFacade 
				implements javax.servlet.ServletConfig{
			
			}
			
			注意：
				对于javaweb程序员来说，我们不需要关心ServletConfig接口的实现类是什么！！！！
				我们只需要面向ServletConfig接口调用即可。
				这就是面向接口编程
				ServletConfig接口的调用者：javaweb程序员
				ServletConfig接口的实现者：web容器/web服务器/Tomcat服务器
				
				Tomcat容器实现了Servlet+JSP规范。
		
		3、ServletConfig对象中保存了什么信息?ServletConfig是干什么的?
			ServletConfig对象是“Servlet对象的配置信息对象”
			Servlet对象的配置信息在web.xml文件中的<servlet></servlet>标签内部
			ServletConfig对象封装了当前Servlet对象的配置信息。
			通过ServletConfig对象可以获取该Servlet对象的相关配置信息。
		
		4、一个Servlet对象对应一个ServletConfig对象,100个Servlet对象对应100个ServletConfig对象。
		
		5、ServletConfig接口中常用方法有哪些？
			- String getInitParameter(String name)  通过初始化参数的name获取value
			- Enumeration getInitParameterNames()	获取所有初始化参数的name
			- ServletContext getServletContext()	获取ServletContext对象【ServletContext后面讲】
			- String getServletName() 【使用较少】
		
		6、ServletConfig在init方法中，怎么样能在service方法中使用ServletConfig呢？
			1、提供一个实例变量:private ServletConfig config;
			2、在init方法中编写：this.config = config;
			3、实现getServletConfig方法，直接返回：config
		