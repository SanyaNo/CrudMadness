package com.crud.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/displayAll")
	public String displayAll(Model model) {

		List<User> users = null;
		users = userService.getUsers();
		model.addAttribute("users", users);
		return "displayAll";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@Valid User user, BindingResult result, Model m) {

		if (result.hasErrors()) {
			return "addUser";
		}

		userService.addUser(user);

		return "redirect:displayAll.html";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUser(@ModelAttribute("user") User user, Model model) {

		return "addUser";
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET, params = "id")//TODO Change to delete..somehow
	public String deleteUser(@RequestParam(value = "id") int id) {
	
		userService.deleteUser(id);

		return "redirect:displayAll.html";
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.GET, params = "id") 
	public String editUser(@RequestParam(value = "id") int id, Model model) {
		
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		System.out.println(user.toString() + " in the service + Get");
		
		return "editUser";
	}
	
	@RequestMapping(value = "/editUser", method = RequestMethod.POST) //TODO make it a put method...somehow
	public String editUser(@Valid User user, @RequestParam(value = "id") int id, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "editUser";
		}
		System.out.println(user.toString() + " in the service + Post");
		userService.updateUser(user, id);
		return "redirect:displayAll.html";
	}
}
