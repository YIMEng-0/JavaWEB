prj-servlet-02
	
	研究Servlet对象的生命周期
	
		1、在myeclipse中设置文件的默认打开方式：
			Window-->Preferences-->file associations-->找到对应扩展名选项-->设置默认打开方式default
		
		2、什么是Servlet生命周期？
			Servlet对象的生命周期表示：Servlet对象从最初的创建，到最终的销毁，经历了哪些不同的过程。
		
		3、Servlet对象的创建，Servlet对象的方法被调用，Servlet对象的销毁，都是由WEB容器来负责管理的，
		javaweb程序员是不需要管理这些的。
			javaweb程序员主要负责：
				Servlet类的编写，
				service方法的实现，
				Servlet类在web.xml文件中的配置。
		
		4、myeclipse快捷键：
			alt + /			自动补全
			ctrl + 1		纠错
			ctrl + o		查看类的属性和方法
			ctrl + shift + t	查找类
			ctrl + shift + o	组织导入
			ctrl + /			注释和取消注释
			tab					缩进
			shift + tab			取消缩进
			ctrl + shift + f	格式化【不建议使用】
			ctrl + alt + 向下箭头	复制一行
			ctrl + z	撤销
			ctrl + y	重做
			ctrl + s	时刻记住这个“保存”
			ctrl + c
			ctrl + x
			ctrl + v
			ctrl + d	删除光标所在行
		
		5、web.xml文件在服务器启动阶段被解析，若web.xml文件编写有错误，启动Tomcat服务器的时候，当前webapp启动失败。
		
		6、Servlet对象“默认情况”下，在服务器启动阶段是不会实例化的。不会创建对象
		
		7、Servlet对象的生命周期
			1) 用户打开浏览器在浏览器地址栏上输入URL：http://localhost:8080/oa/save，回车
			2) WEB服务器截取请求路径，得知用户要访问的资源是：/oa/save
			3) WEB服务器从整个容器中检索/oa/save请求路径对应的Servlet对象
			4) 若找到了该Servlet对象
				4-1) web容器负责调用该Servlet对象的service方法提供服务，处理请求
			5) 若没有找到该Servlet对象
				5-1) 通过请求路径/save找到对应的Servlet完整类名（web.xml文件支持的,web.xml文件在服务器启动阶段解析，路径和类名已经绑定在一起了）
				5-2) 通过反射机制调用Servlet类的无参数构造方法完成Servlet对象的实例化操作。（Servlet对象已经创建完毕）
				5-3) web容器调用该Servlet对象的init方法完成初始化操作。
				5-4) web容器调用该Servlet对象的service方法提供服务，处理请求
			6) 若“服务器关闭”或“webapp重新部署”或“长时间没有用户再访问该Servlet”，WEB容器
			会销毁该Servlet对象占用的内存空间，web容器在销毁该Servlet对象之前，web容器负责
			调用该Servlet对象的destroy方法，完成销毁之前的准备工作。
				
		
		8、Servlet对象是单实例的，不符合单例模式，是一种伪单例，真单例的构造方法必须是私有化的。
		Servlet对象是在多线程环境下运行的一个对象。【单实例多线程环境下运行的一个java对象】
		之所以Servlet对象是单实例的，是因为该对象的创建是由WEB容器负责的，javaweb程序员不能干涉
		
		9、单例分类：
			- 真单例
			- 伪单例
		
		10、总结：
			1) 无参数构造方法只调用一次，对象只创建一个，对象是单例的
			2) init方法只被调用一次，在对象创建之后马上执行它，完成初始化操作
			3) service方法，只要用户发送请求一次，则执行一次
			4) destroy方法也是只执行一次
			注意：
				init方法在执行的时候，对象已经存在了。
				destroy方法在执行的时候，对象还没有被回收，还存在。
		
		11、分析Servlet中重要的三个方法：
			init
			service
			destroy
			
			问题：你觉得哪个方法使用最多?  
					service方法，因为在这个方法中需要提供服务，处理当前的请求，这是核心方法，用户访问的每一次都是要执行的。
					
			问题：你觉得init方法和destroy,SUN公司为什么在Servlet接口中设计这两个方法，这两个方法什么时候使用?
					其实init、destroy方法都是SUN公司为javaweb程序员准备的特殊的时刻，初始化时刻/销毁时刻
					一般这两个方法中是不需要编写任何代码的，但是在特殊的情况下，例如：需求要求在对象被初始化
					的那一刻记录日志，那么记录日志的代码就编写到init方法中，例如：需求要求在该Servlet对象
					被销毁的那一刻记录日志，那么记录日志的代码就需要编写到destroy方法。自然会被服务器调用
					并执行。
		
		12、重点：
			在Servlet类中最好不要手动编写任何构造函数，这样做可能会导致无参数构造函数不存在，
			这样通过反射机制创建对象的时候，会出现实例化异常。Servlet对象创建失败。
		
		13、错误代号：【HTTP状态号】
			404	- 资源找不到，通常是路径问题,还有可能是项目本身启动失败
			500 - 服务器内部错误，通常是服务器中的java程序出现了异常。
			.....
			
			
			
			
			
			
			
			