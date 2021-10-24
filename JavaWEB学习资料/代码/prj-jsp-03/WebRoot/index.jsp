<%@page contentType="text/html; charset=UTF-8"%>

<%
	doSome();
%>

<%!
	int i = 100;
%>

<%-- 
	JSP的声明语法格式：
		<%!
			实例变量;
			静态变量;
			方法;
			静态语句块;
			构造函数;
			.....
		%>
		
		注：
			声明块中的java程序会被JSP翻译引擎翻译到service方法之外
			声明块中不能直接编写java语句，除非是变量的声明
--%>

<%!
	//java语句不能直接出现在类体中
	//System.out.println("Hello World!");

	public void doSome(){
		System.out.println("do some!");
	}
%>

<%
	System.out.println("servlet's service method execute!");
%>

<%!
	static{
		System.out.println("Class Loader!");
	}
%>

<%
	int j = 100;
%>

<%!
	public static void doOther(){
		System.out.println("do other!");
	}
%>

<%
	System.out.println("j = " + j);
	System.out.println("i = " + i);
%>



















