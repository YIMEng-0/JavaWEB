<%@page contentType="text/html; charset=UTF-8" %>

<%--以下程序编译报错，无法访问i变量 --%>
<%--
	System.out.println(i);
--%>

<%--
	1、这是JSP的专业注释，使用这种注释方式，不会被翻译到java源文件中
	2、在JSP文件中所编写的所有的html、css、javascript都会被自动翻译到Servlet的service方法中的out.write("翻译到这里");
	3、关于JSP的小脚本scriptlet：
		<%
			java语句;
			java语句;
			java语句;
			java语句;
			java语句;
			java语句;
		%>
	4、小脚本中的java语句被翻译到Servlet的service方法中，所以小脚本中必须编写“java语句”，java语句以分号结尾。
	5、所谓的JSP规范，就是SUN制定好的一些翻译规则，按照翻译规则进行翻译，生成对应的java源程序。不同的web服务器，翻译的结果是完全相同的，
	因为这些服务器在翻译的时候，都遵守了JSP翻译规范。
	6、小脚本的数量随意，可以多个。
	7、小脚本中编写java程序出现在service方法中，service方法的代码是有执行顺序的，所以小脚本中的程序也是有顺序的。
--%>
<%
	int i = 10;
%>
<html>
	<%
		System.out.println(i);
	%>
	<head>
		<%
			double d = 3.0;
		%>
		<title>my jsp page</title>
		<%
			System.out.println(d + i);
		%>
	</head>
	<body>
		hello jsp!
		<%
			System.out.println(d * i);
		%>
	</body>
	<%
		System.out.println(d / i);
	%>
</html>
<%
	String ename = "king";
	System.out.println("ename = " + ename);
%>
