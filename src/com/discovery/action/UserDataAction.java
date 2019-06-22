package com.discovery.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.discovery.model.*;
import com.discovery.service.*;
import com.discovery.service.impl.AdminDataServiceImpl;
import com.discovery.service.impl.UserDataServiceImpl;
import com.discovery.utils.DateUtil;
import com.discovery.utils.GetExtention;
import com.discovery.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

public class UserDataAction extends ActionSupport{
	private User newUser;
	private User newUser_confirm;
	private String condition;
	private String content;
	private String forum_id;
	private String thread_id;
	private String writer_id;
	private Threads newThread;
	private String new_thread_forum_id;
	private String new_thread_writer_id;
	private Reply newReply;
	private String new_by_thread_id;
	private String new_reply_writer_id;
	private String second_reply_id;
	private int page;
	private int pageSize;
	private String pcUserId;
	private User editedUser;
	private String avatarUserId;
	private User editedUser1;
	private File upload;//得到上传的文件
	private String uploadContentType;//得到文件的类型
	private String uploadFileName;//得到文件的名称
	HttpServletRequest request = ServletActionContext.getRequest();

	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}

	public User getNewUser_confirm() {
		return newUser_confirm;
	}

	public void setNewUser_confirm(User newUser_confirm) {
		this.newUser_confirm = newUser_confirm;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getForum_id() {
		return forum_id;
	}

	public void setForum_id(String forum_id) {
		this.forum_id = forum_id;
	}

	public String getThread_id() {
		return thread_id;
	}

	public void setThread_id(String thread_id) {
		this.thread_id = thread_id;
	}

	public String getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}

	public Threads getNewThread() {
		return newThread;
	}

	public void setNewThread(Threads newThread) {
		this.newThread = newThread;
	}

	public String getNew_thread_forum_id() {
		return new_thread_forum_id;
	}

	public void setNew_thread_forum_id(String new_thread_forum_id) {
		this.new_thread_forum_id = new_thread_forum_id;
	}

	public String getNew_thread_writer_id() {
		return new_thread_writer_id;
	}

	public void setNew_thread_writer_id(String new_thread_writer_id) {
		this.new_thread_writer_id = new_thread_writer_id;
	}

	public Reply getNewReply() {
		return newReply;
	}

	public void setNewReply(Reply newReply) {
		this.newReply = newReply;
	}

	public String getNew_by_thread_id() {
		return new_by_thread_id;
	}

	public void setNew_by_thread_id(String new_by_thread_id) {
		this.new_by_thread_id = new_by_thread_id;
	}

	public String getNew_reply_writer_id() {
		return new_reply_writer_id;
	}

	public void setNew_reply_writer_id(String new_reply_writer_id) {
		this.new_reply_writer_id = new_reply_writer_id;
	}

	public String getSecond_reply_id() {
		return second_reply_id;
	}

	public void setSecond_reply_id(String second_reply_id) {
		this.second_reply_id = second_reply_id;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getPcUserId() {
		return pcUserId;
	}

	public void setPcUserId(String pcUserId) {
		this.pcUserId = pcUserId;
	}

	public User getEditedUser() {
		return editedUser;
	}

	public void setEditedUser(User editedUser) {
		this.editedUser = editedUser;
	}

	public String getAvatarUserId() {
		return avatarUserId;
	}

	public void setAvatarUserId(String avatarUserId) {
		this.avatarUserId = avatarUserId;
	}

	public User getEditedUser1() {
		return editedUser1;
	}

	public void setEditedUser1(User editedUser1) {
		this.editedUser1 = editedUser1;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String toIndexPage() throws Exception{
		getAreaList();
		getForumList();
		return "success";
	}
	
	public void getAreaList() throws Exception{
		UserDataService service_getAreaList = new UserDataServiceImpl();
		List<Area> area_data = new ArrayList<Area>();
		area_data = service_getAreaList.getAreaList();
		request.setAttribute("totalAreaList", area_data);
	}
	
	public void getForumList() throws Exception{
		UserDataService service_getForumList = new UserDataServiceImpl();
		List<Forum> forum_data = new ArrayList<Forum>();
		forum_data = service_getForumList.getForumList();
		request.setAttribute("totalForumList", forum_data);
	}
	
	public String toRegisterPage() throws Exception{
		return "success";
	}
	
	public String createUser() throws Exception{
		int result = 1;
		UserDataService service_createUser = new UserDataServiceImpl();
		if(newUser.getUser_sex().equals("m"))
			newUser.setUser_sex("男");
		else{
			if(newUser.getUser_sex().equals("f")){
				newUser.setUser_sex("女");
			}
			else{
				newUser.setUser_sex("未知");
			}
		}
		result = service_createUser.createUser(newUser);
		if(result == 0){
			return "create_success";
		}
		else
		{
			return "create_fail";
		}
	}
	
	public void validateCreateUser(){
		if(newUser.getUser_name().trim().equals("") || newUser.getUser_name()==null)
		{
			this.addFieldError("username_error", "用户名不能为空");
		}
		if(newUser.getUser_nickname().trim().equals("") || newUser.getUser_nickname()==null)
		{
			this.addFieldError("nickname_error", "昵称不能为空");
		}
		if(newUser.getUser_password().trim().equals("") || newUser.getUser_password()==null)
		{
			this.addFieldError("password_error", "密码不能为空");
		}
		if(newUser_confirm.getUser_password().trim().equals("") || newUser_confirm.getUser_password()==null || newUser_confirm.getUser_password().trim().equals(newUser.getUser_password().trim())==false)
		{
			this.addFieldError("passwordCfm_error", "两次输入的密码不一致");
		}
		if(newUser.getUser_sex()==null){
			this.addFieldError("sex_error", "请选择性别");
		}
	}
	
	public String toUserSearchResult() throws Exception{
		getUserSearchResultList(condition,content);
		if(getUserSearchResultList(condition,content)!=0)
			return "user_search_success";
		else
			return "user_search_fail";
	}
	
	public int getUserSearchResultList(String search_condition,String search_content) throws Exception{
		UserDataService service_getUserSearchResultList = new UserDataServiceImpl();
		List<User> userSearchResult_data = new ArrayList<User>();
		userSearchResult_data = service_getUserSearchResultList.getUserSearchResultList(search_condition,search_content);
		request.setAttribute("userSearchResultList", userSearchResult_data);
		System.out.println(userSearchResult_data.size());
		return userSearchResult_data.size();
	}
	
	public String toForum() throws Exception{
		getForumInfo(forum_id);
		getThreadList(forum_id,page,pageSize);
		int threadsNum = getThreadsNumber(forum_id);
		request.setAttribute("threads_Num", threadsNum);
		if(threadsNum%pageSize !=0){
			int pages = (threadsNum/pageSize)+1;
			request.setAttribute("pageNumber", pages);
		}
		else{
			int pages = threadsNum/pageSize;
			request.setAttribute("pageNumber", pages);
		}
		return "forum_success";
	}
	
	public void getForumInfo(String forum_id) throws Exception{
		UserDataService service_getForumInfo = new UserDataServiceImpl();
		List<Forum> forumInfo_data = new ArrayList<Forum>();
		forumInfo_data = service_getForumInfo.getForumInfo(forum_id);
		request.setAttribute("forum_Info", forumInfo_data);
	}
	
	public void getThreadList(String forum_id,int page,int pageSize) throws Exception{
		UserDataService service_getThreadList = new UserDataServiceImpl();
		List<Threads> ThreadList_data = new ArrayList<Threads>();
		ThreadList_data = service_getThreadList.getThreadList(forum_id,page,pageSize);
		request.setAttribute("threads_List", ThreadList_data);
	}
	
	public int getThreadsNumber(String forum_id) throws Exception{
		int threadsNum = PageUtil.getThreadsNum(forum_id);
		return threadsNum;
	}
	
	public String toThread() throws Exception{
		getThreadInfo(thread_id);
		getReplyList(thread_id);
		return "thread_success";
	}
	
	public void getThreadInfo(String thread_id) throws Exception{
		UserDataService service_getThreadInfo = new UserDataServiceImpl();
		List<Threads> threadInfo_data = new ArrayList<Threads>();
		threadInfo_data = service_getThreadInfo.getThreadInfo(thread_id);
		request.setAttribute("thread_Info", threadInfo_data);
	}
	
	public void getReplyList(String thread_id) throws Exception{
		UserDataService service_getReplyList = new UserDataServiceImpl();
		List<Reply> ReplyList_data = new ArrayList<Reply>();
		ReplyList_data = service_getReplyList.getReplyList(thread_id);
		request.setAttribute("Reply_List", ReplyList_data);
	}
	
	public String toNewThreadPage() throws Exception{
		request.setAttribute("new_thread_forum_id", new_thread_forum_id);
		return "success";
	}
	
	public String publishNewThread() throws Exception{
		int result = 1;
		UserDataService service_publishNewThread = new UserDataServiceImpl();
		result = service_publishNewThread.publishNewThread(newThread);
		request.setAttribute("success_forum_id",newThread.getBy_forum_id());
		if(result == 0){
			return "publish_success";
		}
		else
		{
			return "publish_error";
		}
	}
	
	public String toNewReplyPage() throws Exception{
		request.setAttribute("new_by_thread_id",new_by_thread_id);
		return "success";
	}
	
	public String publishNewReply() throws Exception{
		int result = 1;
		UserDataService service_publishNewReply = new UserDataServiceImpl();
		result = service_publishNewReply.publishNewReply(newReply);
		request.setAttribute("success_thread_id",newReply.getBy_thread_id());
		if(result == 0){
			return "reply_success";
		}
		else
		{
			return "reply_error";
		}
	}
	
	public String toNewReplyPage2() throws Exception{
		request.setAttribute("new_by_thread_id",new_by_thread_id);
		request.setAttribute("second_reply_id",second_reply_id);
		return "success";
	}
	
	public String toPersonalCenterPage() throws Exception{
		UserDataService service_toPersonalCenterPage = new UserDataServiceImpl();
		List<User> edit_user = new ArrayList<User>();
		edit_user = service_toPersonalCenterPage.toEditUserPage(pcUserId);
		request.setAttribute("edit_user", edit_user); 
		
		return "toPC";
	}
	
	public String editUser() throws Exception{
		int result = 1;
		UserDataService service_editUser = new UserDataServiceImpl();
		result = service_editUser.setEditedUser(editedUser);
		if(result == 0){
			return "pc_edit_success";
		}
		else
		{
			return "pc_edit_fail";
		}
	}
	
	public String toUpdateAvatarPage() throws Exception{
		UserDataService service_toUpdateAvatarPage = new UserDataServiceImpl();
		List<User> edit_user = new ArrayList<User>();
		edit_user = service_toUpdateAvatarPage.toEditUserPage(avatarUserId);
		request.setAttribute("edit_userAvatar", edit_user); 
		
		return "toUAP";
	}
	
	public String editAvatar() throws Exception{
		try {
			String realPath = ServletActionContext.getServletContext().getRealPath("/user_avatar");
			System.out.println(realPath);
			System.out.println(ClassLoader.getSystemResource(""));
			File file = new File(realPath);
			if(!file.exists()) file.mkdirs();
			String ext = GetExtention.getExt(uploadFileName);
			String fileName = editedUser1.getUser_id()+"_"+DateUtil.generateUserID()+"_avatar"+ext;
			FileUtils.copyFile(upload, new File(file.getAbsolutePath(), fileName));
			editedUser1.setUser_avatar_path("user_avatar/"+fileName);
		} catch (Exception e) {
			return "avatar_edit_fail";
		}
		int result = 1;
		UserDataService service_editAvatar = new UserDataServiceImpl();
		result = service_editAvatar.setEditedUserAvatar(editedUser1);
		if(result == 0){
			return "avatar_edit_success";
		}
		else
		{
			return "avatar_edit_fail";
		}
	}
	
	public String toUserAllThread() throws Exception{
		UserDataService service_toUserAllThread = new UserDataServiceImpl();
		List<Threads> user_threads = new ArrayList<Threads>();
		user_threads = service_toUserAllThread.toUserAllThread(pcUserId);
		request.setAttribute("user_threads", user_threads); 
		
		return "toAllThraed";
	}
	
	public String toUserAllReply() throws Exception{
		UserDataService service_toUserAllReply = new UserDataServiceImpl();
		List<Reply> user_reply = new ArrayList<Reply>();
		user_reply = service_toUserAllReply.toUserAllReply(pcUserId);
		request.setAttribute("user_reply", user_reply); 
		
		return "toAllReply";
	}
}
