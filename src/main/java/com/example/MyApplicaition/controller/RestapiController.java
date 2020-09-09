package com.example.MyApplicaition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyApplicaition.model.User;
import com.example.MyApplicaition.services.UserService;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class RestapiController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String hello()
	{
		return "This is home page";
	}
	
	@GetMapping("/saveuser")
	public String saveUser(@RequestParam String username, @RequestParam String firstname, @RequestParam String lastname, @RequestParam int age, @RequestParam String pasword)
	{
		User user  = new User(username, firstname, lastname, age, pasword);
		userService.saveUser(user);
		return "User is saved";
	}

}
