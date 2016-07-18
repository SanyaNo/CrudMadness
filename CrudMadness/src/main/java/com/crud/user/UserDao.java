package com.crud.user;

import java.util.List;

public interface UserDao {
	

	List<User> getUsers();

	void updateUser(User user, int id);

	void deleteUser(int id);

	void addUser(User user);
	
	User getUser(int id);
	
	boolean notTaken(String username);
}
