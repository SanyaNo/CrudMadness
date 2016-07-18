package com.crud.user;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class UsernameConstraintValidator implements ConstraintValidator<Username, String> {

	@Autowired
	UserService service;

	@Override
	public void initialize(Username username) {

	}

	@Override
	public boolean isValid(String usernameField, ConstraintValidatorContext ctx) {

		return service.notTaken(usernameField);

	}

}
