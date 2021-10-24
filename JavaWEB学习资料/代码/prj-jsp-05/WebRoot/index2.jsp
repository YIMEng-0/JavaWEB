<%--
<%@page contentType="text/html; charset=UTF-8" session="true"%>

<%=session %>
 --%>

<%--
	关于page指令中的session属性：
		- session="true"
			* 表示在当前JSP中可以直接使用内置对象session
			* 程序执行的时候获取当前的session会话对象，若获取不到则新建session对象
			
		- session="false"
			* 表示在当前JSP中不能直接使用内置对象session
			* 但是有一些业务可能要求在当前JSP页面中获取当前的session对象，没有获取到则不新建session对象，此时需要编写以下程序
			
		- 若session这个属性没有指定，默认值就是session="true"
		
--%>
<%@page contentType="text/html; charset=UTF-8" session="false"%>
<%
	HttpSession session = request.getSession(false);
%>
<%=session%>