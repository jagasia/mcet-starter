package org.mcet.demo.controller;

import org.mcet.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@GetMapping("/showSignup")
	public String showSignupPage()
	{
		return "signup";
	}
	
	//post method to accept the signup form submission
	@PostMapping("/register")
	@ResponseBody
	public User signup(User user)
	{
		return user;
	}
	
	@GetMapping("/showLogin")
	public String showLoginPage()
	{
		return "login";
	}
	
}
