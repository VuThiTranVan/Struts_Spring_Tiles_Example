package com.framgia.action;

import java.util.List;

import com.framgia.model.User;
import com.framgia.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	private List<User> users;

	public String homePage() {
		String username = "t";
		users = userService.getUsers(username);
		User user = new User("username", "first_name", "last_name");
		System.out.println(userService.createUser(user));
			
		return SUCCESS;
	}
	
	public String create() {
		User user = new User("username", "first_name", "last_name");
		if(userService.createUser(user))
			return SUCCESS;
		else
			return INPUT;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}