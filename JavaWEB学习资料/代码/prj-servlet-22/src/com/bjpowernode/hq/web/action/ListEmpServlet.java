package com.bjpowernode.hq.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListEmpServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//验证用户是否已经登录
		//已登录的标志是：session这个会话对象中保存了User
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("user") != null){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.print("<!doctype html>");
			out.print("<html>");
			out.print("<head>");
			out.print("    <meta charset='UTF-8'>");
			out.print("    <title>后台管理</title>");
			out.print("    <link rel='stylesheet' type='text/css' href='css/common.css'/>");
			out.print("    <link rel='stylesheet' type='text/css' href='css/main.css'/>");
			out.print("    <script type='text/javascript' src='js/libs/modernizr.min.js'></script>");
			out.print("</head>");
			out.print("<body>");
			out.print("<div class='topbar-wrap white'>");
			out.print("    <div class='topbar-inner clearfix'>");
			out.print("        <div class='topbar-logo-wrap clearfix'>");
			out.print("            <h1 class='topbar-logo none'><a href='index.html' class='navbar-brand'>后台管理</a></h1>");
			out.print("            <ul class='navbar-list clearfix'>");
			out.print("                <li><a class='on' href='index.html'>首页</a></li>");
			out.print("                <li><a href='#' target='_blank'>网站首页</a></li>");
			out.print("            </ul>");
			out.print("        </div>");
			out.print("        <div class='top-info-wrap'>");
			out.print("            <ul class='top-info-list clearfix'>");
			out.print("                <li><a href='http://www.jscss.me'>管理员</a></li>");
			out.print("                <li><a href='http://www.jscss.me'>修改密码</a></li>");
			out.print("                <li><a href='http://www.jscss.me'>退出</a></li>");
			out.print("            </ul>");
			out.print("        </div>");
			out.print("    </div>");
			out.print("</div>");
			out.print("<div class='container clearfix'>");
			out.print("    <div class='sidebar-wrap'>");
			out.print("        <div class='sidebar-title'>");
			out.print("            <h1>菜单</h1>");
			out.print("        </div>");
			out.print("        <div class='sidebar-content'>");
			out.print("            <ul class='sidebar-list'>");
			out.print("                <li>");
			out.print("                    <a href='#'><i class='icon-font'>&#xe003;</i>常用操作</a>");
			out.print("                    <ul class='sub-menu'>");
			out.print("                        <li><a href='design.html'><i class='icon-font'>&#xe008;</i>作品管理</a></li>");
			out.print("                        <li><a href='design.html'><i class='icon-font'>&#xe005;</i>博文管理</a></li>");
			out.print("                        <li><a href='design.html'><i class='icon-font'>&#xe006;</i>分类管理</a></li>");
			out.print("                        <li><a href='design.html'><i class='icon-font'>&#xe004;</i>留言管理</a></li>");
			out.print("                        <li><a href='design.html'><i class='icon-font'>&#xe012;</i>评论管理</a></li>");
			out.print("                        <li><a href='design.html'><i class='icon-font'>&#xe052;</i>友情链接</a></li>");
			out.print("                        <li><a href='design.html'><i class='icon-font'>&#xe033;</i>广告管理</a></li>");
			out.print("                    </ul>");
			out.print("                </li>");
			out.print("                <li>");
			out.print("                    <a href='#'><i class='icon-font'>&#xe018;</i>系统管理</a>");
			out.print("                    <ul class='sub-menu'>");
			out.print("                        <li><a href='system.html'><i class='icon-font'>&#xe017;</i>系统设置</a></li>");
			out.print("                        <li><a href='system.html'><i class='icon-font'>&#xe037;</i>清理缓存</a></li>");
			out.print("                        <li><a href='system.html'><i class='icon-font'>&#xe046;</i>数据备份</a></li>");
			out.print("                        <li><a href='system.html'><i class='icon-font'>&#xe045;</i>数据还原</a></li>");
			out.print("                    </ul>");
			out.print("                </li>");
			out.print("            </ul>");
			out.print("        </div>");
			out.print("    </div>");
			out.print("    <!--/sidebar-->");
			out.print("    <div class='main-wrap'>");
			out.print("        <div class='crumb-wrap'>");
			out.print("            <div class='crumb-list'><i class='icon-font'></i><a href='/jscss/admin'>首页</a><span class='crumb-step'>&gt;</span><span class='crumb-name'>作品管理</span></div>");
			out.print("        </div>");
			out.print("        <div class='search-wrap'>");
			out.print("            <div class='search-content'>");
			out.print("                <form action='/jscss/admin/design/index' method='post'>");
			out.print("                    <table class='search-tab'>");
			out.print("                        <tr>");
			out.print("                            <th width='120'>选择分类:</th>");
			out.print("                            <td>");
			out.print("                                <select name='search-sort' id=''>");
			out.print("                                    <option value=''>全部</option>");
			out.print("                                    <option value='19'>精品界面</option><option value='20'>推荐界面</option>");
			out.print("                                </select>");
			out.print("                            </td>");
			out.print("                            <th width='70'>关键字:</th>");
			out.print("                            <td><input class='common-text' placeholder='关键字' name='keywords' value='' id='' type='text'></td>");
			out.print("                            <td><input class='btn btn-primary btn2' name='sub' value='查询' type='submit'></td>");
			out.print("                        </tr>");
			out.print("                    </table>");
			out.print("                </form>");
			out.print("            </div>");
			out.print("        </div>");
			out.print("        <div class='result-wrap'>");
			out.print("            <form name='myform' id='myform' method='post'>");
			out.print("                <div class='result-title'>");
			out.print("                    <div class='result-list'>");
			out.print("                        <a href='insert.html'><i class='icon-font'></i>新增作品</a>");
			out.print("                        <a id='batchDel' href='javascript:void(0)'><i class='icon-font'></i>批量删除</a>");
			out.print("                        <a id='updateOrd' href='javascript:void(0)'><i class='icon-font'></i>更新排序</a>");
			out.print("                    </div>");
			out.print("                </div>");
			out.print("                <div class='result-content'>");
			out.print("                    <table class='result-tab' width='100%'>");
			out.print("                        <tr>");
			out.print("                            <th class='tc' width='5%'><input class='allChoose' name='' type='checkbox'></th>");
			out.print("                            <th>排序</th>");
			out.print("                            <th>ID</th>");
			out.print("                            <th>员工编号</th>");
			out.print("                            <th>员工姓名</th>");
			out.print("                            <th>员工薪水</th>");
			out.print("                            <th>雇用日期</th>");
			out.print("                            <th>操作</th>");
			out.print("                        </tr>");
			
			
			
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3366/bjpowernode", "root", "123");
				String sql = "select empno,ename,sal,hiredate from emp order by sal asc";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					String empno = rs.getString("empno");
					String ename = rs.getString("ename");
					String sal = rs.getString("sal");
					String hiredate = rs.getString("hiredate");
					
					out.print("                        <tr>");
					out.print("                            <td class='tc'><input name='id[]' value='59' type='checkbox'></td>");
					out.print("                            <td>");
					out.print("                                <input name='ids[]' value='59' type='hidden'>");
					out.print("                                <input class='common-input sort-input' name='ord[]' value='0' type='text'>");
					out.print("                            </td>");
					out.print("                            <td>59</td>");
					out.print("                            <td title='员工编号'><a target='_blank' href='#' title='员工编号'>"+empno+"</a>");
					out.print("                            </td>");
					out.print("                            <td>"+ename+"</td>");
					out.print("                            <td>"+sal+"</td>");
					out.print("                            <td>"+hiredate+"</td>");
					out.print("                            <td>");
					out.print("                                <a class='link-update' href='#'>修改</a>");
					out.print("                                <a class='link-del' href='#'>删除</a>");
					out.print("                            </td>");
					out.print("                        </tr>");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				if(rs != null){
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(ps != null){
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(conn != null){
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
			out.print("                    </table>");
			out.print("                    <div class='list-page'> 2 条 1/1 页</div>");
			out.print("                </div>");
			out.print("            </form>");
			out.print("        </div>");
			out.print("    </div>");
			out.print("    <!--/main-->");
			out.print("</div>");
			out.print("</body>");
			out.print("</html>");
		}else{
			response.sendRedirect(request.getContextPath() + "/login.html");
		}
	}

}
