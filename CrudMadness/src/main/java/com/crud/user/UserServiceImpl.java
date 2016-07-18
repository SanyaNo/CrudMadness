package com.crud.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;

	public List<User> getUsers() {

		return dao.getUsers();
	}

	public User getUser(int id) {

		return dao.getUser(id);

	}

	public void updateUser(User user, int id) {

		dao.updateUser(user, id);

	}

	public void deleteUser(int id) {

		dao.deleteUser(id);

	}

	public void addUser(User user) {

		dao.addUser(user);

	}

	public boolean notTaken(String username) {

		return dao.notTaken(username);
	}
}
