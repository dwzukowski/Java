package com.dave.review.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dave.review.models.Ring;
import com.dave.review.models.User;
import com.dave.review.services.RingService;
import com.dave.review.services.UserService;
import com.dave.review.validator.UserValidator;


@Controller
public class Users {
	private UserService userService;
	private UserValidator userValidator;
	private RingService ringService;
	
	public Users(UserService userService, UserValidator userValidator, RingService ringService){
		this.userService = userService;
		this.userValidator = userValidator;
		this.ringService = ringService;
	}

	@RequestMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("user") User user){
		return "registrationPage.jsp"; 
	}
	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){
		userValidator.validate(user, result);
		if(result.hasErrors()){
			return "registrationPage.jsp";
		}
		userService.saveWithUserRole(user);
		//userService.saveUserWithAdminRole(user);
		return "redirect:/login";
	}
	@RequestMapping("/login")
	public String login(@Valid @ModelAttribute("user") User user,@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model){
		//login error message 
		if (error != null){
			model.addAttribute("errorMessage", "Invalid Credentials, Please try again");
		}
		//logout message
		if (logout != null){
			model.addAttribute("logoutMessage", "Logout Successful");
		}
		return "loginPage.jsp";
	}	
	//successful login
	@RequestMapping(value = {"/","/home"})
	public String home(Principal principal, Model model, @ModelAttribute("ring") Ring ring){
		//home method accepts GET requests to / and /home; after authentication we get name of our principal (current user) via .getName() 
		String username = principal.getName();
		model.addAttribute("currentUser", userService.findByUsername(username));
		//List<Ring> Allrings = ringService.allRings();
		List<Ring> Allrings = ringService.getRingsWherePickedUp(false);
		//System.out.println(testrings);
		model.addAttribute("Allrings", Allrings);
		return "homePage.jsp";
	}
	//admin page
	@RequestMapping("/admin")
	public String adminPage(Principal principal, Model model){
		String username = principal.getName();
		model.addAttribute("currentUser", userService.findByUsername(username));
		return "adminPage.jsp";
	}
	@RequestMapping("/admin/createRing")
	public String createRing(@ModelAttribute("ring") Ring ring){

		return "createRing.jsp";
	}
	@PostMapping("/admin/createRing")
	public String createRing(@Valid @ModelAttribute("ring") Ring ring, BindingResult result){
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "createRing.jsp";
		}
		else{
			System.out.println(ring.getName());
			ringService.addRing(ring);
			return "redirect:/home";
		}
	}
	@PostMapping("/home/findRing")
	public String findRing(Principal principal, @ModelAttribute("ring") Ring ring, BindingResult result){

		System.out.println(ring.getName());
		//String username = principal.getName();
		Ring ringForUpdate = ringService.findById(ring.getName());
		User userToUpdate = userService.findByUsername(principal.getName());
		userService.AddRingToUser(ringForUpdate, userToUpdate);
		return "redirect:/home";
	}
	@RequestMapping("/loseRing/{id}")
	public String loseRing(@PathVariable("id") long id){
		System.out.println(id);
		ringService.dropRing(id);
		return "redirect:/home";
	}
	@RequestMapping("/test")
	public String thisIsJustATest(Principal principal, Model model, @ModelAttribute("test") User user){
		String username = principal.getName();
		model.addAttribute("currentUser", userService.findByUsername(username));
		return "testPage.jsp";
	}
	@PostMapping("/test/test")
	public String thisIsATest(@ModelAttribute("test") User user){
		System.out.println(user.getUsername());
		System.out.println(user.getEmail());
		return "redirect:/test";
	}
}
