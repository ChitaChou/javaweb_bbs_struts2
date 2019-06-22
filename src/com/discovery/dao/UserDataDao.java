package com.discovery.dao;

import java.util.List;

import com.discovery.model.Admin;
import com.discovery.model.Reply;
import com.discovery.model.Threads;
import com.discovery.model.User;

public interface UserDataDao {
	public List getAreaList() throws Exception;
	public List getForumList() throws Exception;
	public int createUser(User newUser) throws Exception;
	public List getUserSearchResultList(String search_condition,String search_content) throws Exception;
	public List getForumInfo(String forum_id) throws Exception;
	public List getThreadList(String forum_id,int page,int pageSize) throws Exception;
	public List getThreadInfo(String thread_id) throws Exception;
	public List getReplyList(String thread_id) throws Exception;
	public int publishNewThread(Threads newThread) throws Exception;
	public int publishNewReply(Reply newReply) throws Exception;
	public List toEditUserPage(String edit_user_id) throws Exception;
	public int setEditedUser(User edited_user) throws Exception;
	public List toUserAllThread(String pc_user_id) throws Exception;
	public List toUserAllReply(String pc_user_id) throws Exception;
	public int setEditedUserAvatar(User edited_user) throws Exception;
}
