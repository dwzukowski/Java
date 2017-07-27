package com.dave.belt.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dave.belt.models.Pack;
import com.dave.belt.models.User;
import com.dave.belt.services.PackService;
import com.dave.belt.services.UserService;
import com.dave.belt.validator.UserValidator;



@Controller
public class Main {
	private UserService userService;
	private UserValidator userValidator;
	private PackService packService;
	
	public Main(UserService userService, UserValidator userValidator, PackService packService){
		this.userService = userService;
		this.userValidator = userValidator;
		this.packService = packService;
	}

	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){
		userValidator.validate(user, result);
		if(result.hasErrors()){
			return "loginPage.jsp";
		}
		List<User> allUsers = userService.allUsers();
		//first user created is automatically an admin 
		if (allUsers.size() == 0){
			userService.saveUserWithAdminRole(user);
		}
		else{
			userService.saveWithUserRole(user);
		}
		return "redirect:/login";
	}
	@RequestMapping("/login")
	public String login(@Valid @ModelAttribute("user") User user,@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model){
		//login error message 
		List<User> allUsers = userService.allUsers();
		System.out.println(allUsers.size());
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
	public String home(Principal principal, Model model){
		String username = principal.getName();
		User user = userService.findByUsername(username);
		//if user is an admin, redirect to admin page
		if(user.getRoles().get(0).getName().contentEquals("ROLE_ADMIN")){
			return "redirect:/admin";
		}
		model.addAttribute("currentUser", user);
		return "redirect:/selection";
	}
	//admin page
	@RequestMapping("/admin")
	public String adminPage(Principal principal, Model model, @ModelAttribute("pack") Pack pack){
		String username = principal.getName();
		model.addAttribute("currentUser", userService.findByUsername(username));
		List<Pack> allPacks = packService.allPacks();
		//System.out.println(allPacks);
		model.addAttribute("allPacks", allPacks);
		List<User> allCustomers = userService.findCustomers();
		System.out.println(allCustomers);
		model.addAttribute("allCustomers", allCustomers);
		return "adminPage.jsp";
	}
	@PostMapping("/admin/createPack")
	public String createPack(@ModelAttribute("pack") Pack pack, BindingResult result){
		packService.addPack(pack);
		return "redirect:/admin";
	}
	@RequestMapping("/admin/activatePack/{name}")
	public String activatePack(@PathVariable("name") String name){
		Pack pack = packService.findByName(name);
		//System.out.println(pack.getPrice());
		packService.activatePack(pack);
		return "redirect:/admin";
	}
	@RequestMapping("/admin/deactivatePack/{name}")
	public String deactivatePack(@PathVariable("name") String name){
		Pack pack = packService.findByName(name);
		//System.out.println(pack.getPrice());
		packService.deactivatePack(pack);
		return "redirect:/admin";
	}
	@RequestMapping("/admin/destroyPack/{name}")
	public String destroyPack(@PathVariable("name") String name){
		Pack pack = packService.findByName(name);
		//System.out.println(pack.getPrice());
		if(pack.getUsers().size() != 0){
			return "redirect:/admin";
		}
		packService.destroyPack(pack);
		return "redirect:/admin";
	}
	@RequestMapping("/selection")
	public String selectPack(@ModelAttribute("user") User user, Model model, Principal principal){
		String username = principal.getName();
		model.addAttribute("currentUser", userService.findByUsername(username));
		List<Pack> availablePacks = packService.getPacksWhereAvailable(true);
		model.addAttribute("availablePacks", availablePacks);
		return "selectionPage.jsp";
	}
	@PostMapping("userSelectPack")
	public String userSelectPack(@ModelAttribute("user") User user, Principal principal){
		System.out.println(user.getPack());
		String username = principal.getName();
		userService.addPackToUser(user.getPack(), userService.findByUsername(username));
		
		return "redirect:/profile";
	}
	@RequestMapping("/profile")
	public String userProfile(Model model, Principal principal){
		String username = principal.getName();
		model.addAttribute("currentUser", userService.findByUsername(username));
		return "profilePage.jsp";
	}
	@RequestMapping("/admin/edit/{id}")
	public String updateUser(Model model, @PathVariable("id") long id, @ModelAttribute("user") User user){
		User selectedUser = userService.findById(id);
		//System.out.println(selectedUser);
		model.addAttribute("user", selectedUser);
		List<Pack> availablePacks = packService.getPacksWhereAvailable(true);
		model.addAttribute("availablePacks", availablePacks);
		return "updatedUser.jsp";
	}
	@PostMapping("/admin/edit/{id}")
	public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") long id){
		userService.updateUser(user);
		return "redirect:/admin";
	}
}

