package com.discovery.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.discovery.model.User;
import com.discovery.service.CheckAdminLoginService;
import com.discovery.service.CheckUserLoginService;
import com.discovery.service.impl.CheckAdminLoginServiceImpl;
import com.discovery.service.impl.CheckUserLoginServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class CheckUserLoginAction extends ActionSupport implements SessionAware{
	private User user;
	
	private SessionMap<String,Object> session;
	
	public void setSession(Map<String, Object> map) {
		session = (SessionMap)map;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() throws Exception {
		CheckUserLoginService checkUser = new CheckUserLoginServiceImpl();
		
		User currentLoginUser = new User();
		try {
			currentLoginUser = checkUser.checkUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(currentLoginUser.getUser_id().equals("login error."))
		{
			this.addFieldError("loginError", "用户名/密码错误");
			return "fail";
			
		}
		else
		{
			session.put("currentUser",currentLoginUser);
			return "success";
		}
	}
	
	public String logout() throws Exception{
		session.invalidate();
		return "logout_success";
	}
}
