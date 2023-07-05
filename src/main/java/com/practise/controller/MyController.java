package com.practise.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.practise.entities.LoginData;

import jakarta.validation.Valid;


@Controller
public class MyController {

	@GetMapping(value="/about")
	public String about(Model model){
		System.out.println("Inside about handler..");
		//model.addAllAttributes("name","Durgesh Tiwari");
		model.addAttribute("name", "Durgesh Tiwari");
		//model.addAllAttributes("CurrentDate",new Date().toLocalString());
		model.addAttribute("currentDate", new Date().toLocaleString());
		return"about";
	}
	//handling iteration
	@GetMapping("/example-loop")
	public String iterateHandler(Model m) {
		//create a list,set collection
		List<String> names = List.of("Ankit","Laxmi","karan","John");
	//m.addAllAttributes("names",names);
		m.addAttribute("names", names);
		return "iterate";
	}
	//handler for conditional statement
	@GetMapping("/condition")
	public String conditionHandler(Model m2) {
		System.out.println("conditional statement in Thymeleaf");
		m2.addAttribute("isActive", false);
		m2.addAttribute("Gender", "f");
		List<Integer> list = List.of();
		
		m2.addAttribute("myList", list);
		return "condition";
	}
	//handler for including fragment
	@GetMapping("/service")
	public String serviceHandler(Model m) {
		
		m.addAttribute("title","I like to eat Samosas");
		m.addAttribute("subtitle",LocalDateTime.now().toString());
		 // m.addAttribute("subtitle","hi");)
		//processing logic
		return "service";
	}
	//for newabout
	@GetMapping("/newabout")
	public String newAbout() {
		return "aboutnew";
	}
	//for contact
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

	/*
	 * @GetMapping("/form2") 
	 * public String openForm2()
	 *  { return "form"; 
	 *  }
	 */
	@GetMapping("/form")
	public String openForm2(Model m) {
		System.out.println("Opening form...");
		m.addAttribute("loginData",new LoginData());	
	    return "form";
	}
	//handler for processing form
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("LoginData")LoginData loginData,BindingResult result) {
		System.out.println(result);
		return "form";
	}
	







}
