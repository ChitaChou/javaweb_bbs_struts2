package com.discovery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.discovery.dao.CheckAdminLoginDao;
import com.discovery.model.Admin;
import com.discovery.utils.DBUtil;


public class CheckAdminLoginDaoImpl implements CheckAdminLoginDao{

	public int checkAdmin(Admin adm) throws Exception {
		int result = 0;
		
		String sql = "SELECT * FROM `javaweb_bbs`.`admin` where admin_name= ? and admin_password= ?";
		Connection checkConn;
		PreparedStatement checkPS;
		ResultSet checkRS;
		
		checkConn = DBUtil.getconn();
		checkPS = DBUtil.getState(checkConn, sql);
		checkPS.setString(1, adm.getAdmin_name());
		checkPS.setString(2, adm.getAdmin_password());
		
		checkRS = checkPS.executeQuery();
		
		if(checkRS.next())
		{
			result = 1;
		}
			
		DBUtil.close(checkRS);
		DBUtil.close(checkPS);
		DBUtil.close(checkConn);
		
		return result;
	}

}
