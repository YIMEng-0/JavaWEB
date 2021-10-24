/*
	连接数据库，查询所有员工信息，将员工信息显示到浏览器上，以表格形式
*/
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class ListEmpServlet implements Servlet
{
	public void init(ServletConfig config) throws ServletException{
	
	}
	public void service(ServletRequest request,ServletResponse response)
		throws ServletException,IOException{

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>员工信息列表</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<table border='1px'>");
		out.print("<tr>");
		out.print("<th>员工编号</th>");
		out.print("<th>员工姓名</th>");
		out.print("<th>员工薪水</th>");
		out.print("</tr>");

		//编写JDBC代码，连接数据库，查询所有员工信息按照薪资升序排
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3366/bjpowernode","root","123");
			String sql = "select empno,ename,sal from emp order by sal asc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String empno = rs.getString("empno");
				String ename = rs.getString("ename");
				String sal = rs.getString("sal");

				out.print("<tr>");
				out.print("<td>"+empno+"</td>");
				out.print("<td>"+ename+"</td>");
				out.print("<td>"+sal+"</td>");
				out.print("</tr>");
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			if(rs != null){
				try{
					rs.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(ps != null){
				try{
					ps.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(conn != null){
				try{
					conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}


		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
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