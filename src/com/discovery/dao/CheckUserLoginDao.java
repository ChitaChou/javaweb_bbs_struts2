package com.discovery.dao;

import com.discovery.model.Admin;
import com.discovery.model.User;

public interface CheckUserLoginDao {
	public User checkUser (User user) throws Exception;
}
