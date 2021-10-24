<%@page contentType="text/html; charset=UTF-8"%>

<%-- 
	关于JSP中的动作：
		语法格式：<jsp:动作名  属性名=属性值   属性名=属性值....></jsp:动作名>
--%>
<%
	request.setAttribute("username","wangwu");
%>

<%-- 转发是一次请求 --%>
<%--
<jsp:forward page="/index2.jsp"></jsp:forward>
 --%>
 
<%-- 以上JSP的动作可以编写为对应的java程序进行实现 --%>
<%--
<%
	request.getRequestDispatcher("/index2.jsp").forward(request,response);
%>
 --%>

<%-- 编写java程序完成重定向 --%>
<%
	response.sendRedirect(request.getContextPath() + "/index2.jsp");
%>

<%-- 
	JSP主要是完成页面的展示，最好在JSP文件中少的编写java源代码：
		以后会通过EL表达式 + JSTL标签库来代替JSP中的java源代码
		当然，使用某些动作也能代替java源代码
 --%>
























