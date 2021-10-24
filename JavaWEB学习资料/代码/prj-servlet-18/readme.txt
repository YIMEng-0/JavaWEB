prj-servlet-18
	
	Cookie
	
		1、Cookie是什么? Cookie作用? Cookie保存在哪里?
			- 翻译过来：曲奇饼干
			- Cookie可以保存会话状态，但是这个会话状态是保留在客户端上。
			- 只要Cookie清除，或者Cookie失效，这个会话状态就没有了。
			- Cookie是保存在浏览器客户端上的
			- Cookie可以保存在浏览器的缓存中，浏览器关闭Cookie消失
			- Cookie也可以保存在客户端的硬盘文件中，浏览器关闭Cookie还在，除非Cookie失效。
		
		2、Cookie只有在javaweb中有吗?
			- Cookie不止是在javaweb中存在
			- 只要是web开发，只要是B/S架构的系统，只要是基于HTTP协议，就有Cookie的存在。
			- Cookie这种机制是HTTP协议规定的。
		
		3、Cookie实现的功能，常见的有哪些?
			- 保留购物车商品的状态在客户端上
			- 十天内免登录
			.......
		
		4、在java中Cookie被当做类来处理，使用new运算符可以创建Cookie对象,而且Cookie由两部分组成，
		分别是Cookie的name和value，name和value都是字符串类型String。
		
		5、在java程序中怎么创建Cookie?
			Cookie cookie = new Cookie(String cookieName,String cookieValue);
		
		6、服务器可以一次向浏览器发送多个Cookie
		
		7、默认情况下，服务器发送Cookie给浏览器之后，浏览器将Cookie保存在缓存当中，只要不关闭浏览器，Cookie永远存在，并且有效。
		当浏览器关闭之后，缓存中的Cookie被清除。
		
		8、在浏览器客户端无论是硬盘文件中还是缓存中保存的Cookie，什么时候会再次发送给服务器呢？
			- 浏览器会不会提交发送这些Cookie给服务器，和请求路径有关系。
			- 请求路径和Cookie是紧密关联的。
			- 不同的请求路径会发送提交不同的Cookie
		
		9、默认情况下Cookie会和哪些路径绑定在一起????
			/prj-servlet-18/test/createAndSendCookieToBrowser   请求服务器，服务器生成Cookie，并将Cookie发送给浏览器客户端
			这个浏览器中的Cookie会默认和“test/”这个路径绑定在一起。
			也就是说，以后只要发送“test/”请求，Cookie一定会提交给服务器。
			
			/prj-servlet-18/a 请求服务器，服务器生成Cookie，并将Cookie发送给浏览器客户端
			这个浏览器中的Cookie会默认和“prj-servlet-18/”这个路径绑定在一起。
			也就是说，以后只要发送“prj-servlet-18/”请求，Cookie一定会提交给服务器。
		
		10、其实路径是可以指定的，可以通过java程序进行设置，保证Cookie和某个特定的路径绑定在一起。
			假设，执行了这样的程序：cookie.setPath("/prj-servlet-18/king");
			那么：Cookie将和"/prj-servlet-18/king"路径绑定在一起
			只有发送“/prj-servlet-18/king”请求路径，浏览器才会提交Cookie给服务器。
		
		11、默认情况下，没有设置Cookie的有效时长，该Cookie被默认保存在浏览器的缓存当中，只要浏览器不关闭Cookie存在，
		只要关闭浏览器Cookie消失，我们可以通过设置Cookie的有效时长，以保证Cookie保存在硬盘文件当中。但是这个有效时长
		必须是>0的。换句话说，只要设置Cookie的有效时长大于0，则该Cookie会被保存在客户端硬盘文件当中。有效时长过去之后，
		则硬盘文件当中的Cookie失效。
				cookie有效时长 = 0 直接被删除
				cookie有效时长 < 0 不会被存储
				cookie有效时长 > 0 存储在硬盘文件当中 
				
				cookie.setMaxAge(60 * 60);  1小时有效
			
		12、浏览器提交Cookie给服务器，服务器怎么接收Cookie?
			Cookie[] cookies = request.getCookies();
			
			if(cookies != null){
				for(Cookie cookie : cookies){
					String cookieName = cookie.getName();
					String cookieValue = cookie.getValue();
					System.out.println(cookieName + "=" + cookieValue);
				}
			}
		
		13、浏览器是可以禁用Cookie,什么意思？
			- 表示服务器发送过来的Cookie，我浏览器不要，不接收。
			- 服务器还是会发送Cookie的，只不过浏览器不再接收。
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		