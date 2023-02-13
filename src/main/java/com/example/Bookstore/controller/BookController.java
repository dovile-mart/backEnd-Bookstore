package com.example.Bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	

	@Autowired BookRepository repository;
	
	@GetMapping("/index")		//http://localhost:8080/index
	public String greetingFormBooks(Model model) {	
			return "index";			//kutsuu index.html
	}
	@GetMapping("/booklist") 	//http://localhost:8080/booklist
	public String booklistForm(Model model) {
		model.addAttribute("kirjat", repository.findAll());
		return "booklist";			//kutsuu booklist.html
	}
	@GetMapping("/addBook")
	public String addBook(Model model) {
		model.addAttribute("uusiKirja", new Book());
		return "newBook";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:/booklist";
	}
}