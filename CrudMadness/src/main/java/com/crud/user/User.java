package com.crud.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class User {
	
	private int id;

	@NotEmpty
	@Size(min = 4, max = 25)
	private String fName;

	@NotEmpty
	@Size(min = 4, max = 25)
	private String lName;

	@NotEmpty
	@Size(min = 4, max = 25)
	//@Username
	private String username;

	@NotEmpty
	@Size(min = 4, max = 10)
	private String gender;

	@NotNull
	@Range(min = 1, max = 115)
	private int age;

	@NotEmpty
	@Email
	private String email;

	public User() {

	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [fName=" + fName + ", lName=" + lName + ", username=" + username + ", gender=" + gender + ", age="
				+ age + ", email=" + email + "]";
	}

}
