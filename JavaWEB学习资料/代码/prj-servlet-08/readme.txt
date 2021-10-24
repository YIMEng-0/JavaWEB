prj-servlet-08
	
	Http协议详解与GET请求和POST请求的区别
	
		1、HTTP协议是什么?
			- HTTP协议是一种超文本传输协议
			- W3C制定的
			- 浏览器和服务器之间提前制定好的一种数据传送格式
		
		2、HTTP协议包括：请求协议和响应协议
			- 请求协议：浏览器向服务器发送数据的时候，数据传送格式
			- 响应协议：服务器向浏览器发送数据的时候，数据传送格式
		
		3、安装httpwatch[IE浏览器的插件]/httplook工具，监测并深度剖析HTTP协议的详细内容。
		【javaweb程序员必须精通HTTP协议，只有精通了HTTP协议，才知道在网络中传送的到底是哪些数据】
		
		4、请求协议包括以下四部分：
			- 请求行
			- 消息报头
			- 空白行
			- 请求体
		
		5、请求协议：基于get方式
			GET /prj-servlet-08/user/login?username=admin&password=123 HTTP/1.1					请求行
			Accept: text/html, application/xhtml+xml, */*										消息报头
			Referer: http://localhost:8080/prj-servlet-08/										消息报头
			Accept-Language: zh-CN																消息报头
			User-Agent: Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)			消息报头
			Accept-Encoding: gzip, deflate														消息报头
			Host: localhost:8080																消息报头
			Connection: Keep-Alive																消息报头
																								空白行
																								请求体
			注：
				第一：请求行由三部分组成：请求方式、URI、协议版本号
				第二：若请求是GET请求，在请求行中发送数据，格式：uri?name=value&name=value.....
				第三：GET请求最终浏览器地址栏上会将提交的数据显示出来
				
		6、请求协议：基于POST方式
			POST /prj-servlet-08/user/login HTTP/1.1											请求行
			Accept: text/html, application/xhtml+xml, */*										消息报头
			Referer: http://localhost:8080/prj-servlet-08/
			Accept-Language: zh-CN
			User-Agent: Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)
			Content-Type: application/x-www-form-urlencoded
			Accept-Encoding: gzip, deflate
			Host: localhost:8080
			Content-Length: 27
			Connection: Keep-Alive
			Cache-Control: no-cache
																								空白行
			username=admin&password=123															请求体
			
			注：
				第一：请求行由三部分组成：请求方式、URI、协议版本号
				第二：若请求是POST请求，在请求体中发送数据，格式：name=value&name=value.....
				第三：POST请求最终浏览器地址栏上不会将提交的数据显示出来，因为不是在请求行上发送的数据
		
		7、什么时候请求方式是基于POST?
			- 只有一种方式是POST请求，使用form表单提交数据，并且同时form标签的method属性设置为method="POST"
			- 剩下任何一种请求，一律都是GET方式
		
		8、响应协议包括以下四部分：
			- 状态行
			- 消息报头
			- 空白行
			- 响应体[响应正文]
		
		9、GET和POST只和请求有关系，和响应无关。无论发送的请求是GET请求还是POST请求，响应协议只有一种格式：
			HTTP/1.1 200 OK																	状态行
			Server: Apache-Coyote/1.1														消息报头
			Content-Type: text/html;charset=UTF-8
			Content-Length: 129
			Date: Sat, 30 Jan 2016 03:28:29 GMT
																							空白行
			<html><head><title>login result</title></head><body><h1 align='center'>			响应体
			<font color='red'>login success!</font></h1></body></html>
			
			注：
				第一：状态行由三部分组成：协议版本号、响应状态号、状态描述信息
					* 响应状态号：【HTTP协议规定的】
						- 404		资源找不到	
						- 500		服务器内部错误
						- 200		请求响应完整成功结束
						...
				第二：消息报头包括
					* 响应的服务器版本
					* 响应的内容类型以及字符编码方式
					* 响应长度，字节为单位
					* 响应时间
				
				第三：空白行
					分离消息报头和响应体的关建行
				
				第四：响应体会显示到网页中。浏览器解释执行HTML代码
		
		10、GET请求和POST请求有什么区别？怎么选用?
		
			GET请求和POST请求在表面上的区别：
			
				- GET请求最终提交的数据会显示到浏览器地址栏上，在请求行上提交数据
				- POST请求在请求体中提交数据，不会显示到浏览器地址栏上
				
				- GET请求只能提交普通字符串，因为GET请求在请求行上提交数据
				- POST请求不但可以提交普通字符串，而且还可以提交图片等文件
				
				- GET请求提交的字符串长度有限制，只能提交少量数据，这也是因为GET请求在请求行上提交数据
				- POST请求提交数据理论上无长度限制，可以提交大数据，这也是因为POST请求在请求体中提交数据
				
				- GET请求最终的请求结果，会存放到浏览器缓存中。【支持Cache】
				- POST请求最终的请求结果，不会被放到浏览器缓存中。【不支持Cache：no cache】
				注：缓存是一种优化策略，减少IO，提高程序执行效率的重要手段，浏览器也不例外，为了降低服务器的压力，浏览器也是支持缓存机制的。
			
			GET请求和POST请求怎么选择呢？
				- 大多数都是使用GET请求
				- 提交的数据中有敏感信息，必须使用POST
				- 提交的数据不是普通字符串，例如文件上传，必须使用POST
				- 提交的数据长度过长，必须使用POST
				- 若请求是读取服务器端的资源，一般都是使用GET请求。读取的资源不会频繁的发生变化，所以这种请求有必要缓存起来。以提高访问效率
				- 若请求是修改服务器端的资源，一般都是使用POST请求。因为每一次修改之后的结果大部分都是不一样的，没有必要缓存。
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		