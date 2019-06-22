package com.discovery.utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.discovery.model.Area;
import com.discovery.utils.DBUtil;

public class GetUserNickname{
	public static String getUserNicknameByID(String userID) throws Exception{
		String sql = "SELECT user_nickname FROM `javaweb_bbs`.`user` where user_id = ?";
		Connection dbConn;
		PreparedStatement nicknamePS;
		ResultSet nicknameRS;

		dbConn = DBUtil.getconn();

		nicknamePS = DBUtil.getState(dbConn, sql);
		nicknamePS.setString(1, userID);
		nicknameRS = nicknamePS.executeQuery();
		
		if(nicknameRS.next()){
			String userNickname = (String)nicknameRS.getObject(1);
			DBUtil.close(nicknameRS);
			DBUtil.close(nicknamePS);
			DBUtil.close(dbConn);
			return userNickname;
		}
		else{
			DBUtil.close(nicknameRS);
			DBUtil.close(nicknamePS);
			DBUtil.close(dbConn);
			return "noResult";
		}
	}
	
	public static String getUserNicknameByReplyID(String replyID) throws Exception{
		String sql = "SELECT user_nickname FROM `javaweb_bbs`.`user` where user_id = (SELECT reply_writer_id FROM `javaweb_bbs`.`reply` where reply_id = ?)";
		Connection dbConn;
		PreparedStatement nicknamePS;
		ResultSet nicknameRS;

		dbConn = DBUtil.getconn();

		nicknamePS = DBUtil.getState(dbConn, sql);
		nicknamePS.setString(1, replyID);
		nicknameRS = nicknamePS.executeQuery();
		
		if(nicknameRS.next()){
			String userNickname = (String)nicknameRS.getObject(1);
			DBUtil.close(nicknameRS);
			DBUtil.close(nicknamePS);
			DBUtil.close(dbConn);
			return userNickname;
		}
		else{
			DBUtil.close(nicknameRS);
			DBUtil.close(nicknamePS);
			DBUtil.close(dbConn);
			return "noResult";
		}
	}
}
