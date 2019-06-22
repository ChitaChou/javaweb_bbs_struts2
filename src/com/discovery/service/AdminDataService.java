package com.discovery.service;

import java.util.List;

import com.discovery.model.Admin;

public interface AdminDataService {
	public List getUserList() throws Exception;
	public List getThreadList() throws Exception;
	public List getReplyList() throws Exception;
	public int delUser(String user_id) throws Exception;
	public int delThread(String thread_id) throws Exception;
	public int delReply(String reply_id) throws Exception;
	public List toEditAdminPage(String edit_admin_name) throws Exception;
	public int setEditedAdmin(Admin edited_admin) throws Exception;
}
