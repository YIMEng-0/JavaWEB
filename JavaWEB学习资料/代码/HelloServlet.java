
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import java.io.IOException;

public class HelloServlet implements Servlet
{
	public void init(ServletConfig config) throws ServletException{
	
	}

	public void service(ServletRequest request,ServletResponse response) 
		throws IOException,ServletException{
		//输出到Tomcat服务器控制台
		System.out.println("Hello World!");
	}
	
	public void destroy(){
	
	}

	public String getServletInfo(){
		return null;
	}

	public ServletConfig getServletConfig(){
		return null;
	}

}