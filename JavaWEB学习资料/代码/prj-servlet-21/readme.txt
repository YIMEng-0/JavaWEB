prj-servlet-21

	关于web编程中的Session：
		1、Session表示会话，不止是在javaweb中存在，只要是web开发，都有会话这种机制。
		2、在java中会话对应的类型是：javax.servlet.http.HttpSession，简称session/会话
		3、Cookie可以将会话状态保存在客户端，HttpSession可以将会话状态保存在服务器端。
		4、HttpSession对象是一个会话级别的对象，一次会话对应一个HttpSession对象。
		5、什么是一次会话?
			“目前”可以这样理解：用户打开浏览器，在浏览器上发送多次请求，直到最终关闭浏览器，表示一次完整的会话。
		6、在会话进行过程中，web服务器一直为当前这个用户维护着一个会话对象/HttpSession
		7、在WEB容器中，WEB容器维护了大量的HttpSession对象，换句话说，在WEB容器中应该有一个“session列表”，
		思考：为什么当前会话中的每一次请求可以获取到属于自己的会话对象? session的实现原理?
			- 打开浏览器，在浏览器上发送首次请求
			- 服务器会创建一个HttpSession对象，该对象代表一次会话
			- 同时生成HttpSession对象对应的Cookie对象，并且Cookie对象的name是JSESSIONID，Cookie的value是32位长度的字符串
			- 服务器将Cookie的value和HttpSession对象绑定到session列表中
			- 服务器将Cookie完整发送给浏览器客户端
			- 浏览器客户端将Cookie保存到缓存中
			- 只要浏览器不关闭，Cookie不会消失
			- 当再次发送请求的时候，会自动提交缓存当中的Cookie
			- 服务器接收到Cookie，验证该Cookie的name确实是：JSESSIONID，然后获取该Cookie的value
			- 通过Cookie的value去session列表中检索对应的HttpSession对象。
			
		8、和HttpSession对象关联的这个Cookie的name是比较特殊的，在java中就叫做：jsessionid
		
		9、浏览器禁用Cookie会出现什么问题？怎么解决？
			- 浏览器禁用Cookie，则浏览器缓存中不再保存Cookie
			- 导致在同一个会话中，无法获取到对应的会话对象
			- 禁用Cookie之后，每一次获取的会话对象都是新的
			
			浏览器禁用Cookie之后，若还想拿到对应的Session对象，必须使用URL重写机制,怎么重写URL:
				http://localhost/prj-servlet-21/user/accessMySelfSession;jsessionid=D3E9985BC5FD4BD05018BF2966863E94
			
			重写URL会给编程带来难度/复杂度，所以一般的web站点是不建议禁用Cookie的。建议浏览器开启Cookie
		
		10、浏览器关闭之后，服务器端对应的session对象会被销毁吗?为什么?
			- 浏览器关闭之后，服务器不会销毁session对象
			- 因为B/S架构的系统基于HTTP协议，而HTTP协议是一种无连接/无状态的协议
			- 什么是无连接/无状态?
				* 请求的瞬间浏览器和服务器之间的通道是打开的，请求响应结束之后，通道关闭
				* 这样做的目的是降低服务器的压力。
				
		11、session对象在什么时候被销毁?
			- web系统中引入了session超时的概念。
			- 当很长一段时间（这个时间可以配置）没有用户再访问该session对象，此时session对象超时，web服务器自动回收session对象。
			- 可配置:web.xml文件中，默认是30分钟
				<session-config>
					<session-timeout>120</session-timeout>
				</session-config>
			
		12、什么是一次会话呢？
			- 一般多数情况下，是这样描述的：用户打开浏览器，在浏览器上进行一些操作，然后将浏览器关闭，表示一次会话结束。
			- 本质上的描述：从session对象的创建，到最终session对象超时之后销毁，这个才是真正意义的一次完整会话。
			
		13、关于javax.servlet.http.HttpSession接口中常用方法：
				-void setAttribute(String name, Object value)
				-Object getAttribute(String name)
				-void removeAttribute(String name)
				-void invalidate()   销毁session
		
		14、ServletContext、HttpSession、HttpServletRequest接口的对比：
		
			14.1 以上都是范围对象:
				ServletContext application; 是应用范围
				HttpSession session; 是会话范围
				HttpServletRequest request; 是请求范围
				
			14.2 三个范围的排序：
				application > session > request
				
			14.3 
				application完成跨会话共享数据、
				session完成跨请求共享数据，但是这些请求必须在同一个会话当中、
				request完成跨Servlet共享数据，但是这些Servlet必须在同一个请求当中【转发】
			
			14.4 使用原则：有小到大尝试，优先使用小范围。
			例如：登录成功之后，已经登录的状态需要保存起来，可以将登录成功的这个状态保存到session对象中。
			登录成功状态不能保存到request范围中，因为一次请求对应一个新的request对象。
			登录成功状态也不能保存到application范围中，因为登录成功状态是属于会话级别的，不能所有用户共享。
		
		15、补充HttpServletRequest中的方法：
			- HttpSession session = request.getSession();  获取当前的session，获取不到，则新建session
			- HttpSession session = request.getSession(true);  获取当前的session，获取不到，则新建session
			- HttpSession session = request.getSession(false);  获取当前的session，获取不到，则返回null
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
			
			
			