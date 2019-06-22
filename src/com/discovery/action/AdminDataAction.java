package com.discovery.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.discovery.model.Admin;
import com.discovery.model.Reply;
import com.discovery.model.Threads;
import com.discovery.model.User;
import com.discovery.service.AdminDataService;
import com.discovery.service.impl.AdminDataServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class AdminDataAction extends ActionSupport{
	private User user;
	HttpServletRequest request = ServletActionContext.getRequest();
	private String delUserId;//执行删除操作的用户ID
	private String delThreadId;//执行删除操作的主题帖ID
	private String delReplyId;//执行删除操作的回复ID
	private String editAdminName;//执行编辑管理员操作的管理员ID，同样用于传递到编辑页面
	private Admin editedAdmin;//用于编辑管理员信息下半部分，传递的已经编辑过的管理员对象
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getDelUserId() {
		return delUserId;
	}
	
	public void setDelUserId(String delUserId) {
		this.delUserId = delUserId;
	}
	
	public String getDelThreadId() {
		return delThreadId;
	}
	
	public void setDelThreadId(String delThreadId) {
		this.delThreadId = delThreadId;
	}
	
	public String getDelReplyId() {
		return delReplyId;
	}
	
	public void setDelReplyId(String delReplyId) {
		this.delReplyId = delReplyId;
	}
	
	public String getEditAdminName() {
		return editAdminName;
	}
	
	public void setEditAdminName(String editAdminName) {
		this.editAdminName = editAdminName;
	}
	
	public String toAllUserPage() throws Exception{
		getUserList();
		return "success";
	}
	
	public void getUserList() throws Exception{
		AdminDataService service_getUserList = new AdminDataServiceImpl();
		List<User> user_data = new ArrayList<User>();
		user_data = service_getUserList.getUserList();
		request.setAttribute("totalUserList", user_data);
	}
	
	public Admin getEditedAdmin() {
		return editedAdmin;
	}
	public void setEditedAdmin(Admin editedAdmin) {
		this.editedAdmin = editedAdmin;
	}
	public String toAllThreadPage() throws Exception{
		getThreadList();
		return "success";
	}
	
	public void getThreadList() throws Exception{
		AdminDataService service_getThreadList = new AdminDataServiceImpl();
		List<Threads> thread_data = new ArrayList<Threads>();
		thread_data = service_getThreadList.getThreadList();
		request.setAttribute("totalThreadList", thread_data);
	}
	
	public String toAllReplyPage() throws Exception{
		getReplyList();
		return "success";
	}
	
	public void getReplyList() throws Exception{
		AdminDataService service_getReplyList = new AdminDataServiceImpl();
		List<Reply> reply_data = new ArrayList<Reply>();
		reply_data = service_getReplyList.getReplyList();
		request.setAttribute("totalReplyList", reply_data);
	}
	
	public String delUser() throws Exception{
		AdminDataService service_delUser = new AdminDataServiceImpl();
		int result = 0;
		try {
			service_delUser.delUser(delUserId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result == 0)
		{
			getUserList();
			return "del_user_success";
		}
		else
		{
			return "del_user_fail";
		}
	}
	
	public String delThread() throws Exception{
		AdminDataService service_delThread = new AdminDataServiceImpl();
		int result = 0;
		try {
			service_delThread.delThread(delThreadId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result == 0)
		{
			getThreadList();
			return "del_thread_success";
		}
		else
		{
			return "del_thread_fail";
		}
	}
	
	public String delReply() throws Exception{
		AdminDataService service_delReply = new AdminDataServiceImpl();
		int result = 0;
		try {
			service_delReply.delReply(delReplyId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result == 0)
		{
			getReplyList();
			return "del_reply_success";
		}
		else
		{
			return "del_reply_fail";
		}
	}
	
	public String toEditAdminPage() throws Exception{
		AdminDataService service_toEditAdminPage = new AdminDataServiceImpl();
		List<Admin> edit_admin = new ArrayList<Admin>();
		edit_admin = service_toEditAdminPage.toEditAdminPage(editAdminName);
		request.setAttribute("edit_admin", edit_admin); 
		
		return "toEdit";
	}
	
	public String editAdmin() throws Exception{
		int result = 1;
		AdminDataService service_editAdmin = new AdminDataServiceImpl();
		result = service_editAdmin.setEditedAdmin(editedAdmin);
		if(result == 0){
			this.addFieldError("editNotice", "信息更新成功");
			return "edit_success";
		}
		else
		{
			return "edit_fail";
		}
	}
}
