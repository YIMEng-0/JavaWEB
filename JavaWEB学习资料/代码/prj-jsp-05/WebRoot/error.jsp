<%@page contentType="text/html; charset=UTF-8" isErrorPage="true"%>

<html>
	<head>
		<title>错误页面</title>
	</head>
	<body>
		<img src="/prj-jsp-05/images/error.gif" />
	</body>
</html>

<%--
	关于page指令中的isErrorPage属性：
		- isErrorPage = "false" 表示内置对象exception无法使用【缺省情况下是false】
		- isErrorPage = "true"  表示内置对象exception可以使用
 --%>
<%-- 使用内置对象exception打印异常堆栈追踪信息 --%>
<%-- exception引用指向了抛出的异常 --%>
<%
	exception.printStackTrace();
%>

