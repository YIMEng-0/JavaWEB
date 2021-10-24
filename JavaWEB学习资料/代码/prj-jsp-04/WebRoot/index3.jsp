<%@page contentType="text/html; charset=UTF-8"%>

<html>
	<head>
		<title>表达式语法</title>
	</head>
	<body>
		
		<h1>标题字</h1>
		<h2>标题字</h2>
		<h3>标题字</h3>
		<h4>标题字</h4>
		<h5>标题字</h5>
		<h6>标题字</h6>
		
		<%
			for(int i=1;i<=6;i++){
		%>
				<h<%=i %>>标题字</h<%=i %>>
		<%
			}
		%>
		
	</body>
</html>
