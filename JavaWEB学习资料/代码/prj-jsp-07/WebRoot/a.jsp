<%@page contentType="text/html; charset=UTF-8"%>

<html>
	<head>
		<title>include动作</title>
	</head>
	<body>
		<%--
			关于JSP中的include动作：
				1、a.jsp包含b.jsp，底层会分别生成两个java源文件，两个class字节码文件
				2、编译阶段并没有包含，编译阶段是两个独立的class字节码文件，生成两个Servlet，两个独立的service方法
				3、使用include动作属于运行阶段包含， 实际上是在运行阶段a中的service方法调用了b中的service方法，达到了包含效果
				4、a.jsp包含b.jsp，若两个jsp文件中有重名的变量，只能使用动态包含。其余都可以使用静态包含。
				5、include动作完成的动态包含，被称为动态联编。
		--%>
		<jsp:include page="/b.jsp"></jsp:include>
	</body>
</html>

