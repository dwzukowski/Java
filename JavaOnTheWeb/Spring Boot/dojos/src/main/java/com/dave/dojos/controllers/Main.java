package com.dave.dojos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dave.dojos.models.Dojo;
import com.dave.dojos.models.Ninja;
import com.dave.dojos.services.DojoService;
import com.dave.dojos.services.NinjaService;

@Controller
public class Main {
	private DojoService dojoService;
	private NinjaService ninjaService;
	public Main(DojoService dojoService, NinjaService ninjaService){
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
		
	}
	@RequestMapping("/")
	public String index(){
		return "index.jsp";
	}
	@RequestMapping("/dojos/new")
	public String createDojo(@ModelAttribute("dojo") Dojo dojo){
		return "createdojo.jsp";
	}
	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result){
		System.out.println("Reached create dojo method, name field is: " + result.getFieldValue("name"));
		dojoService.addDojo(dojo);
		return "redirect:/"; 
	}
	@RequestMapping("/ninjas/new")
	public String createNinja(@ModelAttribute("ninja") Ninja ninja, Model model){
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "createninja.jsp";
	}
	@PostMapping("/ninjas/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model){
		if (result.hasErrors()){
			//if errors, need to retrieve dojos again or dropdown menu won't populate
			List<Dojo> dojos = dojoService.allDojos();
			model.addAttribute("dojos", dojos);
			return "createninja.jsp";
		}
		else{
			ninjaService.addNinja(ninja);
			return "redirect:/";
		}
	}
	@RequestMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") long id, Model model){
		//List<Ninja> ninjas = ninjaService.findByDojoEquals(id);
		Dojo dojo = dojoService.findByDojoById(id);
		System.out.println(dojo.getNinjas());
		List<Ninja> ninjas = dojo.getNinjas();
		model.addAttribute("ninjas", ninjas);
		return "showdojo.jsp";
	}
}
