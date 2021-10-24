<%@page import="java.util.List"%>
<%@page import="com.bjpowernode.crm.entity.Customer"%>
<%@page contentType="text/html; charset=UTF-8"%>

<html>
	<head>
		<title>客户列表</title>
	</head>
	<body>
		<table border="1px" width="50%">
			<tr align="center">
				<th>序号</th>
				<th>姓名</th>
				<th>生日</th>
				<th>操作</th>
			</tr>
			<%
				List<Customer> customerList = (List<Customer>)request.getAttribute("customerList");
				int i = 0;
				for(Customer c : customerList){
			%>
					<tr align="center">
						<td><%=++i %></td>
						<td><%=c.getRealname() %></td>
						<td><%=c.getBirth() %></td>
						<td>
							<a href="">详情</a>
							<a href="">删除</a>
						</td>
					</tr>
			<%
				}
			 %>
			
		</table>
	</body>
</html>