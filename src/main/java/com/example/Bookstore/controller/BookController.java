package com.example.Bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
	
	@GetMapping("/index")
	public String indexPage() {
		return "index";
	//@RequestParam(name= "book", required=false) String book, Model model) {
	//@RequestMapping(value = "/index", method = RequestMethod.GET)
	
	//public String greetingFormBooks(Model model) {	
	//ArrayList<Book> books = new ArrayList<>();
	//	model.addAttribute("books", books);
	//	return "books";
	}
}