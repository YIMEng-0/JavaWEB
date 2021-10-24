import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeServlet implements Servlet
{
	public void init(ServletConfig config) throws ServletException{
	
	}

	public void service(ServletRequest request,ServletResponse response) 
		throws ServletException,IOException{
		//解决响应的时候中文乱码问题
		//设置响应的内容类型和字符编码方式
		//响应内容类型采用text/html
		//字符编码方式采用UTF-8
		//获取响应流之前设置有效果
		response.setContentType("text/html;charset=UTF-8");

		//将消息输出到浏览器上
		//输出到浏览器属于响应，和response对象有关系
		//查阅ServletResponse的帮助文档
		//1、获取标准输出流，该输出流可以响应文本到指定客户端
		PrintWriter out = response.getWriter();
		//response.setContentType("text/html;charset=UTF-8");
		//2、调用PrintWriter中的print方法打印文本
		//提醒：浏览器只能执行html css javascript，所以我们Servlet
		//响应的文本也应该是html css javascript
		out.print("<html>");
		out.print("<head>");
		out.print("<title>welcome servlet</title>");
		out.print("<script type='text/javascript'>function sayHello(){alert('hello world');}</script>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1 align='center'><font color='red'>welcome servlet!</font></h1>");
		out.print("<h1 align='center'><font color='red'>中文有事吗？</font></h1>");
		out.print("<input type='button' value='hello' onclick='sayHello();'/>");
		//在HTML中做到换行效果，需要使用<br>标签
		out.print("abc");
		out.print("<br>");
		out.print("def");
		out.print("</body>");
		out.print("</html>");
		
		
		/*
		//PrintWriter的println方法作用：将源代码换行
		//这样反而体积会增大，不建议使用
		out.println("<html>");
		out.println("<head>");
		out.println("<title>welcome servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align='center'><font color='red'>welcome servlet!</font></h1>");
		out.println("<h1 align='center'><font color='red'>中文有事吗？</font></h1>");
		out.println("abc");
		out.println("def");
		out.println("</body>");
		out.println("</html>");
		*/
		//注意：PrintWriter标准输出流不需要手动关闭,也不需要手动刷新
	}

	public void destroy(){
	
	}

	public String getServletInfo(){
		return "";
	}
	
	public ServletConfig getServletConfig(){
		return null;
	}
}