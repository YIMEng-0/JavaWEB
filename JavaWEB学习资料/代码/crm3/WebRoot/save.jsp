<%@page contentType="text/html; charset=UTF-8"%>

<html>
	<head>
		<title>保存客户信息</title>
	</head>
	<body>
		<form action="<%=request.getContextPath()                %>/save" method="post">
			客户名字：
				<input type="text" name="realname">
				<br>
			生日：
				<input type="text" name="birth">
				<br>
			性别：
				<input type="radio" name="sex" value="m"> 男
				<input type="radio" name="sex" value="f"> 女
				<br>
			联系电话：
				<input type="text" name="tel">
				<br>
			<input type="submit" value="保存">
		</form>
	</body>
</html>