package com.bjpowernode.crm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC工具类，方便JDBC操作
 * @author Administrator
 */
public class DBUtil {
	
	//工具类中的构造函数一般都是私有的，因为工具类中的方法都是静态的，不需要new对象
	private DBUtil(){
		
	}
	
	//静态代码块中的程序在类加载时执行，只执行一次
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接对象
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		String url = "jdbc:mysql://localhost:3366/bjpowernode";
		String user = "root";
		String password = "123";
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	
	/**
	 * 关闭资源
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void close(Connection conn,Statement ps,ResultSet rs){
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
	
	/**
	 * 开启事务
	 * @param conn
	 * @throws SQLException
	 */
	public static void beginTransaction(Connection conn) throws SQLException{
		if(conn != null){
			conn.setAutoCommit(false);
		}
	}
	
	
	/**
	 * 提交事务
	 * @param conn
	 * @throws SQLException
	 */
	public static void commitTransaction(Connection conn) throws SQLException{
		if(conn != null){
			conn.commit();
		}
	}
	
	/**
	 * 回滚事务
	 * @param conn
	 */
	public static void rollbackTransaction(Connection conn) {
		if(conn != null){
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}













