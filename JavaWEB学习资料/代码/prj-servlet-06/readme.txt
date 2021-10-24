prj-servlet-06
	
	研究javax.servlet.ServletContext接口
	
		1、javax.servlet.ServletContext是一个接口
		
		2、apache Tomcat服务器对ServletContext接口的实现，实现类的完整类名:org.apache.catalina.core.ApplicationContextFacade
			public class org.apache.catalina.core.ApplicationContextFacade implements javax.servlet.ServletContext{
			
			}
			注意：javaweb程序员不需要关心具体的实现类，还是面向ServletContext接口调用方法即可。实现类是服务器负责的。
			Tomcat就是一个实现了Servlet+JSP规范的容器。
		
		3、ServletContext对象的个数?
			在同一个webapp中，ServletContext对象只有一个
			在web服务器启动阶段被创建
			在web服务器关闭的时候被销毁
			ServletContext对象是一个应用级别的对象。
			注：100个app对应100个ServletContext
			
			一个Servlet对应一个ServletConfig，所有的Servlet共享一个ServletContext
		
		4、ServletContext怎么理解,它是什么,主要作用是什么?
			- ServletContext是一个Servlet上下文对象
			- ServletContext对象是所有Servlet共享的一个四周环境对象
			- Context单词翻译：上下文  
			- 例如：contextPath就是上下文路径: /prj-servlet-06 【webapp的根路径】
			- ServletContext可以完成多个Servlet之间共享同一些数据。
			- ServletContext对象中封装了web.xml文件中所有信息，
			ServletContext对象只有一个，web.xml文件也是只有一个
			web.xml文件也是在服务器启动阶段被解析，ServletContext也是在服务器启动阶段被创建。
		
		5、ServletContext接口中常用的方法：
		
			- void setAttribute(String name, Object object)  //向Servlet上下文中绑定一个数据object，起名name (map.put(key,value))
			- Object getAttribute(String name) //从Servlet上下文中取object，通过name (Object value = map.get(key))
			- void removeAttribute(String name) //移除Servlet上下文中的某个数据，通过name  (map.remove(key))
			
			- String getInitParameter(String name) //通过上下文参数的name获取上下文参数value
			- Enumeration getInitParameterNames() //获取所有上下文参数的name
			
			- String getRealPath(String path) //获取绝对路径
			- InputStream getResourceAsStream(String path) //直接获取文件输入流
			
		6、通过ServletContext对象可以完成：
			- 跨用户传递数据	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			