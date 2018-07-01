package com.framgia.dao;

import java.util.List;

import com.framgia.model.User;

public interface UserDAO {

	List<User> getUsers(String username);
	void createUsser(User user);
}
