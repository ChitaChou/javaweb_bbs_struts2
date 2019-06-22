package com.discovery.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	private static Properties props = new Properties();
	static {
		InputStream is = null;
		is = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			props.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(is != null){
				try {
					is.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Connection getconn() throws Exception{
		Class.forName(props.getProperty("driver"));
		Connection conn = DriverManager.getConnection(props.getProperty("url"),props.getProperty("username"),props.getProperty("password"));
		return conn;
	}
	
	public static PreparedStatement getState(Connection conn,String sql) throws SQLException{
		PreparedStatement ps = conn.prepareStatement(sql);
		return ps;
	}
	
	public static void close(Connection conn) throws SQLException{
		if(conn != null){
			conn.close();
		}
	}
	
	public static void close(PreparedStatement ps) throws SQLException{
		if(ps != null){
			ps.close();
		}
	}
	
	public static void close(ResultSet rs) throws SQLException{
		if(rs != null){
			rs.close();
		}
	}
}
