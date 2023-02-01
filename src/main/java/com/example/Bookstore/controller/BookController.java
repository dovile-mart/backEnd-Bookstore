package com.example.Bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
	
	@GetMapping("/index")		//http://localhost:8080/index
	public String greetingFormBooks(Model model) {	
	
		return "index";			//kutsuu index.html
	}
}