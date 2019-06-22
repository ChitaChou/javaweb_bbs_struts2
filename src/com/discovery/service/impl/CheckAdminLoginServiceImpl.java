package com.discovery.service.impl;

import com.discovery.dao.CheckAdminLoginDao;
import com.discovery.dao.impl.CheckAdminLoginDaoImpl;
import com.discovery.model.Admin;
import com.discovery.service.CheckAdminLoginService;

public class CheckAdminLoginServiceImpl implements CheckAdminLoginService{

	public int checkAdmin(Admin adm) {
		CheckAdminLoginDao adminLoginDao = new CheckAdminLoginDaoImpl();
		int result = 0;
		try {
			result = adminLoginDao.checkAdmin(adm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
