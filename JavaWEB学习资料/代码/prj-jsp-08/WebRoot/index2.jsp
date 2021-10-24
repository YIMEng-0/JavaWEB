<%@page contentType="text/html; charset=UTF-8"%>

<%=pageContext.getAttribute("pageContext") %>
<br>
<%=request.getAttribute("request") %>
<br>
<%=session.getAttribute("session") %>
<br>
<%=application.getAttribute("application") %>

<%--
	pageContext只能在同一个JSP页面中共享数据。范围是最小的。
	通过pageContext这个页面上下文对象，可以获取当前页面中的其它对象。
--%>
<%=pageContext.getRequest() %>
<%=pageContext.getSession() %>
<%=pageContext.getServletContext() %>
<%=pageContext.getServletConfig() %>



