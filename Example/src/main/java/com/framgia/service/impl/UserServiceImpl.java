package com.framgia.service.impl;

import java.util.List;

import com.framgia.dao.UserDAO;
import com.framgia.model.User;
import com.framgia.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;

	@Override
	public List<User> getUsers(String username) {
		try {
			return getUserDAO().getUsers(username);
		} catch (Exception e) {
			throw e;
		}
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
