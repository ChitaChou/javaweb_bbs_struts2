package com.discovery.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PageUtil {
	public static int getThreadsNum(String by_forum_id) throws Exception{
		int result = 0;
		
		String sql = "select count(*) from `javaweb_bbs`.`thread` where by_forum_id = ?";
		Connection dbConn;
		PreparedStatement countPS;
		ResultSet countRS;

		dbConn = DBUtil.getconn();

		countPS = DBUtil.getState(dbConn, sql);
		countPS.setString(1, by_forum_id);
		countRS = countPS.executeQuery();
		
		while(countRS.next()){
			result = countRS.getInt(1);
		}
		
		return result;
	}
}
