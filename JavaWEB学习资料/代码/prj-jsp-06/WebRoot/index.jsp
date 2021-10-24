
<%@page contentType="text/html; charset=UTF-8"%>

<html>
	<head>
		<title>include指令</title>
	</head>
	<body>
		<%-- 
			关于include指令：
				1、a.jsp可以将b.jsp包含进来，当然被包含的资源不一定是jsp，也可能是其它的网络资源
				2、include作用：
					在网页中有一些主体框架，例如：网页头、网页脚，这些都是固定不变的，
					我们可以将网页头、网页脚等固定不变的单独编写到某个JSP文件中，
					在需要页面使用include指令包含进来。
					优点：
						代码量少了
						便于维护【修改一个文件就可以作用于所有的页面】
				3、在一个jsp中可以使用多个include指令
				4、include实现原理：
					4.1 编译期包含
					4.2 a.jsp包含b.jsp，底层共生成一个java源文件，一个class字节码文件,翻译期包含/编译期包含/静态联编
				
				5、静态联编的时候，多个jsp中可以共享同一个局部变量。
				因为最终翻译之后service方法只有一个。
		 --%>
		<%@include file="/index2.jsp" %>
		
		<%=i%>
	</body>
</html>