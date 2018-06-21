package com.framgia.service;

import java.util.List;

import com.framgia.model.User;

public interface UserService {
	List<User> getUsers(String username);
}
