package com.example.Bookstore.controller;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@RestController
public class RestBookController {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(RestBookController.class);
	
	//Injektoi repository interface RestBookController-luokalle
	@Autowired
	BookRepository bookRepository;
	
	//näyttää kaikki kirjat
	@GetMapping("/books")
	public Iterable<Book> getBooks(){
		log.info("Palauttaa kaikki kirjat");
		return bookRepository.findAll();
	}
	
	//lisää uuden kirjan
	@PostMapping("books")
	Book newBook(@RequestBody Book newBook) {
		log.info("Tallenna uusi kirja " + newBook);
		return bookRepository.save(newBook);
	}
	
	//etsii kirja id:n perusteella
	@GetMapping("books/{id}")
	Optional<Book> getBook(@PathVariable Long id){
		log.info("Etsi kirja id:n mukaan: " + id);
		return bookRepository.findById(id);
	}
	
	//muuttaa tietyn kirjan tietoja
	@PutMapping("books/{id}")
	Book editBook(@RequestBody Book editedBook, @PathVariable Long id) {
		log.info("Muokkaa kirja " + editedBook);
		editedBook.setId(id);
		return bookRepository.save(editedBook);
	}
	
	//poistaa kirjan sen id:n mukaan
	@DeleteMapping("books/{id}")
	public Iterable<Book> deleteBook(@PathVariable Long id){
		log.info("Poista kirja id:n mukaan: " + id);
		bookRepository.deleteById(id);
		return bookRepository.findAll();
	}
	
}