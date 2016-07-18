package com.crud.user;

import java.util.List;

public interface UserService {

	List<User> getUsers();

	void updateUser(User user, int id);

	void deleteUser(int id);

	void addUser(User user);
	
	boolean notTaken(String username);
	
	User getUser(int id);

}