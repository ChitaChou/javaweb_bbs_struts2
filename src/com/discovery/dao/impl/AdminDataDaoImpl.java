package com.discovery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.discovery.dao.AdminDataDao;
import com.discovery.model.Admin;
import com.discovery.model.Reply;
import com.discovery.model.Threads;
import com.discovery.model.User;
import com.discovery.utils.DBUtil;

public class AdminDataDaoImpl implements AdminDataDao{

	public List getUserList() throws Exception {
		int num_users = 0;
		List<User> user_data = new ArrayList<User>();
		
		String sql = "SELECT * FROM `javaweb_bbs`.`user`";
		Connection dbConn;
		PreparedStatement userPS;
		ResultSet userRS;

		dbConn = DBUtil.getconn();

		userPS = DBUtil.getState(dbConn, sql);
		userRS = userPS.executeQuery();
		
		while (userRS.next()) {
			User temp = new User();
			temp.setUser_id((String)userRS.getObject(1));
			temp.setUser_name((String)userRS.getObject(2));
			temp.setUser_nickname((String)userRS.getObject(3));
			temp.setUser_password((String)userRS.getObject(4));
			temp.setUser_sex((String)userRS.getObject(5));
			temp.setUser_email((String)userRS.getObject(6));
			temp.setUser_phone((String)userRS.getObject(7));
			temp.setUser_hobby((String)userRS.getObject(8));
			temp.setUser_avatar_path((String)userRS.getObject(9));
			user_data.add(temp);
			num_users++;
		}
		
		
		DBUtil.close(userRS);
		DBUtil.close(userPS);
		DBUtil.close(dbConn);
		
		return user_data;
	}

	public List getThreadList() throws Exception {
		int num_threads = 0;
		List<Threads> thread_data = new ArrayList<Threads>();
		
		String sql = "SELECT * FROM `javaweb_bbs`.`thread`";
		Connection dbConn;
		PreparedStatement userPS;
		ResultSet userRS;

		dbConn = DBUtil.getconn();

		userPS = DBUtil.getState(dbConn, sql);
		userRS = userPS.executeQuery();
		
		while (userRS.next()) {
			Threads temp = new Threads();
			temp.setThread_id((String)userRS.getObject(1));
			temp.setWriter_id((String)userRS.getObject(2));
			temp.setBy_forum_id((String)userRS.getObject(3));
			temp.setCreate_time((String)userRS.getObject(4));
			temp.setLatest_post_time((String)userRS.getObject(5));
			temp.setThread_title((String)userRS.getObject(6));
			temp.setThread_text((String)userRS.getObject(7));
			thread_data.add(temp);
			num_threads++;
		}
		
		
		DBUtil.close(userRS);
		DBUtil.close(userPS);
		DBUtil.close(dbConn);
		
		return thread_data;
	}

	public List getReplyList() throws Exception {
		int num_replies = 0;
		List<Reply> reply_data = new ArrayList<Reply>();
		
		String sql = "SELECT * FROM `javaweb_bbs`.`reply`";
		Connection dbConn;
		PreparedStatement userPS;
		ResultSet userRS;

		dbConn = DBUtil.getconn();

		userPS = DBUtil.getState(dbConn, sql);
		userRS = userPS.executeQuery();
		
		while (userRS.next()) {
			Reply temp = new Reply();
			temp.setReply_id((String)userRS.getObject(1));
			temp.setReply_writer_id((String)userRS.getObject(2));
			temp.setBy_thread_id((String)userRS.getObject(3));
			temp.setReply_time((String)userRS.getObject(4));
			temp.setReply_text((String)userRS.getObject(5));
			temp.setSecond_reply_id((String)userRS.getObject(6));
			reply_data.add(temp);
			num_replies++;
		}
		
		
		DBUtil.close(userRS);
		DBUtil.close(userPS);
		DBUtil.close(dbConn);
		
		return reply_data;
	}

	public int delUser(String user_id) throws Exception {
		int result = 0;
		
		String sql = "delete from `javaweb_bbs`.`user` where user_id = ?";
		Connection delConn;
		PreparedStatement delPS;
		
		delConn = DBUtil.getconn();
		delPS = DBUtil.getState(delConn, sql);
		delPS.setString(1, user_id);
		
		try {
			delPS.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			result = 1;
		}
			
		DBUtil.close(delPS);
		DBUtil.close(delConn);
		
		return result;
	}

	public int delThread(String thread_id) throws Exception {
		int result = 0;
		
		String sql = "delete from `javaweb_bbs`.`thread` where thread_id = ?";
		Connection delConn;
		PreparedStatement delPS;
		
		delConn = DBUtil.getconn();
		delPS = DBUtil.getState(delConn, sql);
		delPS.setString(1, thread_id);
		
		try {
			delPS.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			result = 1;
		}
			
		DBUtil.close(delPS);
		DBUtil.close(delConn);
		
		return result;
	}

	public int delReply(String reply_id) throws Exception {
		int result = 0;
		
		String sql = "delete from `javaweb_bbs`.`reply` where reply_id = ?";
		Connection delConn;
		PreparedStatement delPS;
		
		delConn = DBUtil.getconn();
		delPS = DBUtil.getState(delConn, sql);
		delPS.setString(1, reply_id);
		
		try {
			delPS.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			result = 1;
		}
			
		DBUtil.close(delPS);
		DBUtil.close(delConn);
		
		return result;
	}

	public List toEditAdminPage(String edit_admin_name) throws Exception {
		List<Admin> edit_admin = new ArrayList<Admin>();
		
		String sql = "SELECT * from `javaweb_bbs`.`admin` where admin_name = ?";
		Connection dbConn;
		PreparedStatement userPS;
		ResultSet userRS;

		dbConn = DBUtil.getconn();

		userPS = DBUtil.getState(dbConn, sql);
		userPS.setString(1, edit_admin_name);
		userRS = userPS.executeQuery();
		
		while (userRS.next()) {
			Admin temp = new Admin();
			temp.setAdmin_id((String)userRS.getObject(1));
			temp.setAdmin_name((String)userRS.getObject(2));
			temp.setAdmin_password((String)userRS.getObject(3));
			temp.setAdmin_email((String)userRS.getObject(4));
			edit_admin.add(temp);
		}
		
		
		DBUtil.close(userRS);
		DBUtil.close(userPS);
		DBUtil.close(dbConn);
		
		return edit_admin;
	}

	public int setEditedAdmin(Admin edited_admin) throws Exception {
		int result = 1;
		
		String sql = "update `javaweb_bbs`.`admin` set admin_password = ? , admin_email = ? where admin_name = ?";
		Connection editConn;
		PreparedStatement editPS;
		
		editConn = DBUtil.getconn();
		editPS = DBUtil.getState(editConn, sql);
		editPS.setString(1, edited_admin.getAdmin_password());
		editPS.setString(2, edited_admin.getAdmin_email());
		editPS.setString(3, edited_admin.getAdmin_name());
		
		try {
			editPS.executeUpdate();
			result = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		DBUtil.close(editPS);
		DBUtil.close(editConn);
		
		return result;
	}

}
