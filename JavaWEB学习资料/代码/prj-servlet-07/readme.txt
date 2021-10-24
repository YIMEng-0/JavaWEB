prj-servlet-07
	
	1、抽取Servlet适配器类型，以后所有的Servlet类不再直接实现Servlet接口了，因为这样代码很丑陋。
	可以让以后所有的Servlet继承“Servlet适配器类型”，这样代码会很优雅。
	
	2、Servlet适配器类型除了完成优雅的效果，尽量在该类中提供更多的更方便的方法，供程序员使用。
	
	3、我们这个适配器类起名：GenericServlet【通用的Servlet】
	
	4、测试GenericServlet适配器是否可用