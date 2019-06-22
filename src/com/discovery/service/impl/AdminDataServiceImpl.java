package com.discovery.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.discovery.dao.AdminDataDao;
import com.discovery.dao.impl.AdminDataDaoImpl;
import com.discovery.model.Admin;
import com.discovery.model.Reply;
import com.discovery.model.Threads;
import com.discovery.model.User;
import com.discovery.service.AdminDataService;

public class AdminDataServiceImpl implements AdminDataService{

	public List getUserList() throws Exception {
		AdminDataDao dataDao = new AdminDataDaoImpl();
		List<User> user_data = new ArrayList<User>();
		user_data = dataDao.getUserList();
		return user_data;
	}

	public List getThreadList() throws Exception {
		AdminDataDao dataDao = new AdminDataDaoImpl();
		List<Threads> thread_data = new ArrayList<Threads>();
		thread_data = dataDao.getThreadList();
		return thread_data;
	}

	public List getReplyList() throws Exception {
		AdminDataDao dataDao = new AdminDataDaoImpl();
		List<Reply> reply_data = new ArrayList<Reply>();
		reply_data = dataDao.getReplyList();
		return reply_data;
	}

	public int delUser(String user_id) throws Exception {
		AdminDataDao dataDao = new AdminDataDaoImpl();
		int result = 0;
		try {
			dataDao.delUser(user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int delThread(String thread_id) throws Exception {
		AdminDataDao dataDao = new AdminDataDaoImpl();
		int result = 0;
		try {
			dataDao.delThread(thread_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int delReply(String reply_id) throws Exception {
		AdminDataDao dataDao = new AdminDataDaoImpl();
		int result = 0;
		try {
			dataDao.delReply(reply_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List toEditAdminPage(String edit_admin_name) throws Exception {
		AdminDataDao dataDao = new AdminDataDaoImpl();
		List<Admin> edit_admin = new ArrayList<Admin>();
		edit_admin = dataDao.toEditAdminPage(edit_admin_name);
		
		return edit_admin;
	}

	public int setEditedAdmin(Admin edited_admin) throws Exception {
		int result = 1;
		AdminDataDao dataDao = new AdminDataDaoImpl();
		try {
			result = dataDao.setEditedAdmin(edited_admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
