<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@page import="java.util.Date" %>
<%@page import="java.util.*,java.text.SimpleDateFormat" %>

<%--
	关于JSP的指令：
		1、指令的作用，是指导JSP的翻译引擎如何翻译JSP代码。
		2、JSP中共三个指令：
			* page			页面指令
			* include		包含指令
			* taglib		标签库指令【以后讲】
		3、指令的使用语法格式：
			<%@指令名  属性名=属性值  属性名=属性值.....%>
		3、关于JSP的page指令,page指令中常用的属性：
			* contentType		设置JSP的响应内容类型，同时在响应的内容类型后面也可以指定响应的字符编码方式
			* pageEncoding		设置JSP响应时的字符编码方式
			
			* import			组织导入
			
			* session			设置当前JSP页面中是否可以直接使用session内置对象
			
			* errorPage			错误页面
			* isErrorPage		是否是错误页面
			
			* isELIgnored		是否忽略EL表达式【后期讲】
--%>

<%
	Date nowTime = new Date();
%>

<%=nowTime %>
<br>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<%=sdf.format(nowTime) %>























