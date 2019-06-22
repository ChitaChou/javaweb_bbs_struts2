package com.discovery.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.discovery.dao.AdminDataDao;
import com.discovery.dao.UserDataDao;
import com.discovery.dao.impl.AdminDataDaoImpl;
import com.discovery.dao.impl.UserDataDaoImpl;
import com.discovery.model.Admin;
import com.discovery.model.Area;
import com.discovery.model.Forum;
import com.discovery.model.Reply;
import com.discovery.model.Threads;
import com.discovery.model.User;
import com.discovery.service.UserDataService;

public class UserDataServiceImpl implements UserDataService{

	public List getAreaList() throws Exception {
		UserDataDao dataDao = new UserDataDaoImpl();
		List<Area> area_data = new ArrayList<Area>();
		area_data = dataDao.getAreaList();
		return area_data;
	}

	public List getForumList() throws Exception {
		UserDataDao dataDao = new UserDataDaoImpl();
		List<Forum> forum_data = new ArrayList<Forum>();
		forum_data = dataDao.getForumList();
		return forum_data;
	}

	public int createUser(User newUser) throws Exception {
		int result = 1;
		UserDataDao dataDao = new UserDataDaoImpl();
		try {
			result = dataDao.createUser(newUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List getUserSearchResultList(String search_condition,String search_content) throws Exception {
		UserDataDao dataDao = new UserDataDaoImpl();
		List<User> userSearchResult_data = new ArrayList<User>();
		userSearchResult_data = dataDao.getUserSearchResultList(search_condition,search_content);
		return userSearchResult_data;
	}

	public List getForumInfo(String forum_id) throws Exception {
		UserDataDao dataDao = new UserDataDaoImpl();
		List<Forum> forumInfo_data = new ArrayList<Forum>();
		forumInfo_data = dataDao.getForumInfo(forum_id);
		return forumInfo_data;
	}

	public List getThreadList(String forum_id,int page,int pageSize) throws Exception {
		UserDataDao dataDao = new UserDataDaoImpl();
		List<Threads> ThreadList_data = new ArrayList<Threads>();
		ThreadList_data = dataDao.getThreadList(forum_id,page,pageSize);
		return ThreadList_data;
	}

	public List getThreadInfo(String thread_id) throws Exception {
		UserDataDao dataDao = new UserDataDaoImpl();
		List<Threads> threadInfo_data = new ArrayList<Threads>();
		threadInfo_data = dataDao.getThreadInfo(thread_id);
		return threadInfo_data;
	}

	public List getReplyList(String thread_id) throws Exception {
		UserDataDao dataDao = new UserDataDaoImpl();
		List<Reply> ReplyList_data = new ArrayList<Reply>();
		ReplyList_data = dataDao.getReplyList(thread_id);
		return ReplyList_data;
	}

	public int publishNewThread(Threads newThread) throws Exception {
		int result = 1;
		UserDataDao dataDao = new UserDataDaoImpl();
		try {
			result = dataDao.publishNewThread(newThread);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int publishNewReply(Reply newReply) throws Exception {
		int result = 1;
		UserDataDao dataDao = new UserDataDaoImpl();
		try {
			result = dataDao.publishNewReply(newReply);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List toEditUserPage(String edit_user_id) throws Exception {
		UserDataDao dataDao = new UserDataDaoImpl();
		List<User> edit_user = new ArrayList<User>();
		edit_user = dataDao.toEditUserPage(edit_user_id);		
		return edit_user;
	}

	public int setEditedUser(User edited_user) throws Exception {
		int result = 1;
		UserDataDao dataDao = new UserDataDaoImpl();
		try {
			result = dataDao.setEditedUser(edited_user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List toUserAllThread(String pc_user_id) throws Exception {
		UserDataDao dataDao = new UserDataDaoImpl();
		List<Threads> user_threads = new ArrayList<Threads>();
		user_threads = dataDao.toUserAllThread(pc_user_id);
		
		return user_threads;
	}

	public List toUserAllReply(String pc_user_id) throws Exception {
		UserDataDao dataDao = new UserDataDaoImpl();
		List<Reply> user_reply = new ArrayList<Reply>();
		user_reply = dataDao.toUserAllReply(pc_user_id);
		
		return user_reply;
	}

	public int setEditedUserAvatar(User edited_user) throws Exception {
		int result = 1;
		UserDataDao dataDao = new UserDataDaoImpl();
		try {
			result = dataDao.setEditedUserAvatar(edited_user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
