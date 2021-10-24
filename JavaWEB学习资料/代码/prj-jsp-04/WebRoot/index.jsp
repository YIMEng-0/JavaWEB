<%@page contentType="text/html; charset=UTF-8"%>

<%--
	关于JSP的九大内置对象:
		1、什么是内置对象?
			可以直接在JSP文件中拿来使用的引用。
		2、九大内置对象都有哪些?
			内置对象名称						完整类名
			---------------------------------------------------------------
			pageContext				javax.servlet.jsp.PageContext				页面范围
			request					javax.servlet.http.HttpServletRequest		请求范围
			session					javax.servlet.http.HttpSession				会话范围
			application				javax.servlet.ServletContext				应用范围
			
			out						javax.servlet.jsp.JspWriter
			response				javax.servlet.http.HttpServletResponse
			
			config					javax.servlet.ServletConfig
			
			exception				java.lang.Throwable
			
			page					java.lang.Object [page = this;]
			
		3、以上内置对象只能在service方法中“直接”使用，在其它方法中无法“直接”使用，可以间接使用。
--%>

<%
	out.print("pageContext = " + pageContext);
%>
<br>
<%
	out.print("request = " + request);
%>
<br>
<%
	out.print("session = " + session);
%>
<br>
<%
	out.print("application = " + application);
%>
<br>
<%
	out.print("out = " + out);
%>
<br>
<%
	out.print("response = " + response);
%>
<br>
<%
	out.print("config = " + config);
%>
<br>
<%
	out.print("page = " + page);
%>

