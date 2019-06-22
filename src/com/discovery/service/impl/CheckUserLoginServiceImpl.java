package com.discovery.service.impl;

import com.discovery.dao.CheckAdminLoginDao;
import com.discovery.dao.CheckUserLoginDao;
import com.discovery.dao.impl.CheckAdminLoginDaoImpl;
import com.discovery.dao.impl.CheckUserLoginDaoImpl;
import com.discovery.model.Admin;
import com.discovery.model.User;
import com.discovery.service.CheckAdminLoginService;
import com.discovery.service.CheckUserLoginService;

public class CheckUserLoginServiceImpl implements CheckUserLoginService{

	public User checkUser(User user) {
		User currentLoginUser = new User();
		CheckUserLoginDao userLoginDao = new CheckUserLoginDaoImpl();
		try {
			currentLoginUser = userLoginDao.checkUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentLoginUser;
	}

}
