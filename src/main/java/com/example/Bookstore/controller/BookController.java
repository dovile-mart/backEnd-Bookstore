package com.example.Bookstore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;


@Controller
public class BookController {
	
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/index") // http://localhost:8080/index
	public String greetingFormBooks(Model model) {
		return "index"; // kutsuu index.html
	}

	@GetMapping("/booklist") // http://localhost:8080/booklist
	public String booklistForm(Model model) {
		model.addAttribute("kirjat", bookRepository.findAll());
		return "booklist"; // kutsuu booklist.html
	}

	@GetMapping("/addBook")
	public String addBook(Model model) {
		model.addAttribute("uusiKirja", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addbook";
	}

	@GetMapping("editBook/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("editBook", bookRepository.findById(id));
		model.addAttribute("categories", categoryRepository.findAll());
		return "editbook";
	}

	@PostMapping("/saveBook")
	public String saveBook(Book book) {
		bookRepository.save(book);
		return "redirect:booklist";
	}

	@GetMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		bookRepository.deleteById(id);
		return "redirect:/booklist";
	}
}