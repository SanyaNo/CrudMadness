package com.crud.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoH2 implements UserDao {

	@Autowired
	DataSource ds;

	public List<User> getUsers() {

		List<User> users = new ArrayList<User>();
		try {

			Connection connection = ds.getConnection();

			String sql = "select id, fName, lName, username, gender, age, email from user";

			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				User user = new User();
				user.setId(result.getInt("id"));
				user.setAge(result.getInt("age"));
				user.setfName(result.getString("fName"));
				user.setEmail(result.getString("email"));
				user.setGender(result.getString("gender"));
				user.setlName(result.getString("lName"));
				user.setUsername(result.getString("username"));
				users.add(user);

			}
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();

		}
		return users;

	}

	@Override
	public void updateUser(User user, int id) {
		try {
			Connection connection = ds.getConnection();

			StringBuilder sql = new StringBuilder();

			sql.append("update user set fName = '");
			sql.append(user.getfName());
			sql.append("', lName = '");
			sql.append(user.getlName());
			sql.append("', username = '");
			sql.append(user.getUsername());
			sql.append("', gender = '");
			sql.append(user.getGender());
			sql.append("', age = '");
			sql.append(user.getAge());
			sql.append("', email = '");
			sql.append(user.getEmail());
			sql.append("' where id = '");
			sql.append(id);
			sql.append("'");

			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql + "");

			System.out.println(user.toString() + " in the dao");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int id) {
		try {
			Connection connection = ds.getConnection();

			String sql = "delete from user where id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	@Override
	public void addUser(User user) {
		try {
			Connection connection = ds.getConnection();

			String sql = "insert into user (fName, lName, username, gender, age, email) values (?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, user.getfName());
			stmt.setString(2, user.getlName());
			stmt.setString(3, user.getUsername());
			stmt.setString(4, user.getGender());
			stmt.setInt(5, user.getAge());
			stmt.setString(6, user.getEmail());

			stmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUser(int id) {

		User user = new User();
		try {
			Connection connection = ds.getConnection();
			String sql = "select id, fName, lName, username, gender, age, email from user where id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				user.setId(result.getInt("id"));
				user.setAge(result.getInt("age"));
				user.setfName(result.getString("fName"));
				user.setEmail(result.getString("email"));
				user.setGender(result.getString("gender"));
				user.setlName(result.getString("lName"));
				user.setUsername(result.getString("username"));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;

	}

	public boolean notTaken(String username) {
		try {
			Connection connection = ds.getConnection();
			String sql = "select count(*) as count from user where username = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			int count = 0;
			while (rs.next()) {
				count = rs.getInt("count");
			}
			connection.close();
			if (count >= 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}
