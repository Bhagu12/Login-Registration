package com.example.MyApplicaition.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.MyApplicaition.model.User;
import com.example.MyApplicaition.services.UserService;


@Controller
public class ApplicationController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping ("/welcome")
	public String Welcome(HttpServletRequest request)
	{
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	@RequestMapping ("/register")
	public String register(HttpServletRequest request)
	{
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}
	
	@PostMapping ("/save-user")
	public String registerUser(@ModelAttribute User user, BindingResult bindingresult, HttpServletRequest request)
	{
		userService.saveUser(user);
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	@GetMapping("/allusers")
	public String allusers(HttpServletRequest request)
	{
		request.setAttribute("list", userService.listAllUser());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomepage";
	}
	
	@RequestMapping("/delete-user")
	public String deleteuser(@RequestParam int id,HttpServletRequest request)
	{
		userService.deleteMyUser(id);
		request.setAttribute("list", userService.listAllUser());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomepage";
	}
	
	@RequestMapping("/edit-user")
	public String editUser(@RequestParam int id, HttpServletRequest request)
	{
		request.setAttribute("user", userService.editUser(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "welcomepage";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
	}
	
	@RequestMapping ("/login-user")
	public String loginUser(@ModelAttribute User user, HttpServletRequest request) {
		if(userService.findByUsernameAndPassword(user.getUsername(), user.getPasword())!=null) {
			return "homepage";
		}
		else {
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";
			
		}
	}
}
