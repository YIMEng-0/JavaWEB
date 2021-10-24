<%@page contentType="text/html; charset=UTF-8"%>

<%--
	关于JSP中的九大内置对象
		内置对象						完整类名
		-------------------------------------------
		pageContext					javax.servlet.jsp.PageContext							页面范围【页面上下文】
		request						javax.servlet.http.HttpServletRequest					请求范围
		session						javax.servlet.http.HttpSession							会话范围
		application					javax.servlet.ServletContext							应用范围
		
		response					javax.servlet.http.HttpServletResponse					响应对象
		out							javax.servlet.jsp.JspWriter								标准输出流
		
		config						javax.servlet.ServletConfig								Servlet配置信息对象
			
		exception					java.lang.Throwable										异常引用(isErrorPage="true")
		
		page						javax.servlet.http.HttpServlet  (page = this)			很少用
--%>

<%--
	主要研究下JSP中的四个作用域对象/范围对象：
		pageContext < request < session < application
		
		pageContext : 在同一个JSP页面中共享数据，不能跨JSP页面
		request ： 在同一个请求中共享数据  【使用较多】
		session : 在同一个会话中共享数据  【使用较多】
		application : 所有用户共享的数据可以放到应用范围中
--%>

<%
	pageContext.setAttribute("pageContext" , "pageContextData");
	request.setAttribute("request","requestData");
	session.setAttribute("session","sessionData");
	application.setAttribute("application","applicationData");
%>

<%=pageContext.getAttribute("pageContext") %>
<br>
<%=request.getAttribute("request") %>
<br>
<%=session.getAttribute("session") %>
<br>
<%=application.getAttribute("application") %>


<%--
<jsp:forward page="/index2.jsp"></jsp:forward>
 --%>

<%
	response.sendRedirect(request.getContextPath() + "/index2.jsp");
%>















