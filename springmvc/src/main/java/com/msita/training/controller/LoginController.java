package com.msita.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.msita.training.database.DatabaseConnector;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	DatabaseConnector databaseConnector;
	
	@RequestMapping(method = RequestMethod.GET)
	public String login(ModelMap model) {
		
		return "login";
	}
	
	@RequestMapping(value="authenticate",method = RequestMethod.POST)
	public String authenticate(@RequestParam("username1") String username,
			@RequestParam("password1") String pass,ModelMap model) {
		System.out.println(username+"::::::"+pass);
		boolean rs=databaseConnector.login(username,pass);
		if(rs) 
			return "redirect:/home";
		else
			return "error";
	}
}
