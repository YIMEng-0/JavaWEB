prj-servlet-03
	
	研究服务器启动阶段怎么实例化Servlet对象呢？
		在web.xml文件的<servlet>标签内部添加：<load-on-startup>1</load-on-startup>
		该标签表示在服务器启动阶段加载Servlet，完成实例化和初始化。
		数字越小，优先级越高。