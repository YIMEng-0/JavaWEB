prj-servlet-15
	
	关于Servlet的线程安全问题
	
		1、Servlet在什么环境下运行？
			- Servlet在“单实例”多线程的环境下运行。
			- 某种类型的Servlet对象在容器中只有一个。
		
		2、什么情况下程序会存在线程安全问题？
			- 多线程环境
			- 有共享数据
			- 共享数据涉及到修改操作
		
		3、对于多线程来说,JVM内存中哪些内存空间是共享的，哪些内存空间是独立的?
			- 方法区和堆区内存共享
			- 栈内存独立，一个线程一个栈
			
			- 局部变量内存不共享，所以局部变量不存在线程安全问题
			- 静态变量和实例变量，静态变量在方法区中，实例变量堆内存的java对象内部，静态变量和实例变量存在线程安全问题
		
		4、怎么解决线程安全问题呢？
			第一种方案：尽量使用局部变量代替实例变量
			第二种方案：若必须使用实例变量，那么可以考虑，让对象变成多例，不再是单例。
			第三种方案：若必须使用实例变量，必须是单例的，这个时候必须使用线程同步机制：synchronized
		
		5、注意：使用线程同步机制，是不得以的时候再使用，因为这种方式会让程序的吞吐量降低，用户排队访问，用户体验差。
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			