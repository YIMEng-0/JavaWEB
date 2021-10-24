<%@page contentType="text/html; charset=UTF-8"%>


<%
	String username = "jack";
	out.print("登录成功,欢迎"+username+"回来");
%>

<br>

登录成功，欢迎
<% out.print(username); %>
回来

<br>

登录成功，欢迎
<%=username%>
回来

<%--
	<% out.print(); %>
	等同于
	<%= %>
--%>
<br>
<%
	int i = 100;
	out.print(i);
%>

<br>

<%-- 表达式语法，具有输出功能，输出到浏览器上 --%>
<%=i %>



















