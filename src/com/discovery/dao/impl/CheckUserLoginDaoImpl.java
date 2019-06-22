package com.discovery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.discovery.dao.CheckAdminLoginDao;
import com.discovery.dao.CheckUserLoginDao;
import com.discovery.model.Admin;
import com.discovery.model.User;
import com.discovery.utils.DBUtil;


public class CheckUserLoginDaoImpl implements CheckUserLoginDao{

	public User checkUser(User user) throws Exception {
		
		String sql = "SELECT * FROM `javaweb_bbs`.`user` where user_name= ? and user_password= ?";
		Connection checkConn;
		PreparedStatement userPS;
		ResultSet userRS;
		
		checkConn = DBUtil.getconn();
		userPS = DBUtil.getState(checkConn, sql);
		userPS.setString(1, user.getUser_name());
		userPS.setString(2, user.getUser_password());
		
		userRS = userPS.executeQuery();
		
		User currentLoginUser = new User();
		if(userRS.next())
		{
			currentLoginUser.setUser_id(userRS.getString(1));
			currentLoginUser.setUser_name(userRS.getString(2));
			currentLoginUser.setUser_nickname(userRS.getString(3));
			currentLoginUser.setUser_password(userRS.getString(4));
			currentLoginUser.setUser_sex(userRS.getString(5));
			currentLoginUser.setUser_email(userRS.getString(6));
			currentLoginUser.setUser_phone(userRS.getString(7));
			currentLoginUser.setUser_hobby(userRS.getString(8));
			currentLoginUser.setUser_avatar_path(userRS.getString(9));
		}
		else
		{
			currentLoginUser.setUser_id("login error.");
		}
			
		DBUtil.close(userRS);
		DBUtil.close(userPS);
		DBUtil.close(checkConn);
		
		return currentLoginUser;
		
	}

}
