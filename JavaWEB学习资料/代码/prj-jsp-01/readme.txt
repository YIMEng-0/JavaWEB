prj-jsp-01
	
	1、JSP是什么？
		- JavaServer Pages
		- 基于java语言实现的服务器端页面
		- JSP是JavaEE规范之一
		
	2、jsp文件通常存放在什么位置?
		- JSP可以放到WEB-INF目录外，目前我们是这样做的
		- 在实际开发中，有很多项目是将JSP放到WEB-INF目录中，保护JSP
		- WEB-INF目录中的数据是相对安全的
	
	3、jsp文件后缀是什么?
		- 默认是.jsp
		- 但是jsp文件的后缀也可以修改的，通过修改CATALINA_HOME/conf/web.xml文件
	
	4、JS和JSP的区别?
		- JS : JavaScript，运行在浏览器中，和服务器没有关系，和java也没有关系
		- JSP : JavaServer Pages，运行在服务器中，JSP底层就是java程序，运行在JVM中。
	
	5、JSP的执行原理?
		- 浏览器上访问的路径虽然是以.jsp结尾，访问的是某个jsp文件，其实底层执行的是jsp对应的java程序
		- Tomcat服务器负责将.jsp文件翻译生成.java源文件，并且将java源文件编译生成.class字节码文件
		- 访问jsp，其实底层还是执行了.class文件中的程序。
		- Tomcat服务器内置了一个JSP翻译引擎,专门负责翻译JSP文件，编译java源文件
		- index.jsp会被翻译生成index_jsp.java，编译生成index_jsp.class
		- index_jsp这个类继承了HttpJspBase，而HttpJspBase继承了HttpServlet
		- jsp就是Servlet，只不过职责不同，JSP的强项做页面展示。
	
	6、在JSP文件中编写的所有的HTML、CSS、JavaScript，对于JSP来说，只是普通的字符串。被翻译到：out.write("翻译到这里");
	
	7、jsp文件修改之后，不需要重新部署，也不需要重新启动Tomcat服务器。
	
	8、jsp文件第一次访问的时候为什么非常慢?
		- 启动JSP翻译引擎
		- 需要一个翻译的过程
		- 需要一个编译的过程
		- 需要Servlet对象的创建过程
		- init方法调用
		- service方法调用.....
		
		为什么第2+次访问JSP的时候非常快?
			- 不需要重新翻译
			- 不需要重新编译
			- 不需要创建Servlet对象
			- 直接调用Servlet对象的service方法
		
		jsp也是单实例多线程环境下运行的一个Servlet对象。
	
	9、jsp文件在什么时候会被重新翻译?
		- jsp文件被修改之后会被重新的翻译
		- 怎么确定jsp文件修改了呢? Tomcat服务器会记录jsp文件的最后修改时间。
	