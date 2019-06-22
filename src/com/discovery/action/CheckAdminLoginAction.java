package com.discovery.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.discovery.model.Admin;
import com.discovery.service.CheckAdminLoginService;
import com.discovery.service.impl.CheckAdminLoginServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class CheckAdminLoginAction extends ActionSupport implements SessionAware{
	private Admin admin;
	
	private SessionMap<String,Object> session;

	@Override
	public void setSession(Map<String, Object> map) {
		session = (SessionMap)map;
	}
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public String execute() throws Exception {
		CheckAdminLoginService checkAdmin = new CheckAdminLoginServiceImpl();
		
		int result = 0;
		try {
			result = checkAdmin.checkAdmin(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result == 1)
		{
			session.put("currentAdmin",admin.getAdmin_name());
			return "success";
		}
		else
		{
			this.addFieldError("loginError", "用户名/密码错误");
			return "fail";
		}
	}
	
	public String logout() throws Exception{
		session.invalidate();
		return "logout_success";
	}
}
