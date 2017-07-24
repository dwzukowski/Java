package com.dave.login.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dave.login.models.User;
import com.dave.login.services.UserService;

@Controller
public class Users {
	private UserService userService;
	
	public Users(UserService userService){
		this.userService = userService;
	}
	@RequestMapping("/")
	public String index(@Valid @ModelAttribute("user") User user){
		return "index.jsp";
	}
	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session){
		System.out.println("Reached registration post route");
		if(result.hasErrors()){
			System.out.println("registration errors");
			return "index.jsp";
		}
		System.out.println(user);
		userService.saveWithUserRole(user);
		return "redirect:/";
	}
}
