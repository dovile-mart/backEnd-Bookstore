package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.AppUser;
import com.example.Bookstore.domain.AppUserRepository;
import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
//public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	// we need repository interfaces to put demo data to db 

	@Autowired
	BookRepository bookRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	AppUserRepository appusRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	
	}
	//demodatan syöttö}
	/*@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository, AppUserRepository appusRepository) {
	return (args) -> {
	// Your code...add some demo data to db
		//String title, String author, String isbn, int publicationYear, double price
		log.info("Demokategorioiden luonti");
		categoryRepository.save(new Category("Tietokirjat"));
		categoryRepository.save(new Category("Lasten kirjat"));
		categoryRepository.save(new Category("Kaunokirjat"));
		
		log.info("Demokirjojen luonti");
		bookRepository.save(new Book("Huonetoveri", "Ruth Ware", "9789511450337", 2023, 27.95, categoryRepository.findByName("Kaunokirjat").get(0)));
		bookRepository.save(new Book("Sota vai rauha", "Mihail Shishkin", "9789510491850", 2023, 33.95, categoryRepository.findByName("Tietokirjat").get(0)));
		bookRepository.save(new Book("Pipsa ja unen lähtölaskenta", "Virve Lehväs", "9789511393924", 2021, 14.95, categoryRepository.findByName("Lasten kirjat").get(0)));
		bookRepository.save(new Book("Neulottu Kalevala", "Jenna Kostet", "9789527468418", 2022, 34.95, categoryRepository.findByName("Tietokirjat").get(0)));
		
		log.info("Demokäyttäjien luonti");
		AppUser user1 = new AppUser("user", "$2a$10$mR2WmGjLXN3t6v.cjNWY8upoHecRvcGjmq7slGq.9wwY83BD3yJkK", "user@mail.com", "USER");
		AppUser user2 = new AppUser("admin", "$2a$10$jzx/BIs9sqsRfAaJOeGWeuqFbH/GG4Uxuz82ysgG5gn0ygew53GuW", "admin@mail.com", "ADMIN");
		appusRepository.save(user1);
		appusRepository.save(user2);
		
		
		log.info("Tulostetaan kaikki kategoriat:");
		for (Category category : categoryRepository.findAll()) {
			log.info(category.toString());
		}
		log.info("Tulostetaan kaikki kirjat:");
		for (Book book : bookRepository.findAll()) {
			log.info(book.toString());
		}
		log.info("Tulostetaan kaikki käyttäjät:");
		for (AppUser user : appusRepository.findAll()) {
			log.info(user.toString());
		}
	};
	}*/

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	/*	log.info("LUODAAN DEMODATAA");
		bookRepository.save(new Book("Toinen", "Kirjailija", "456898", 2023, 14.56));
		log.info("Tulostetaan IDEn konsoliin kirjat:");
		for (Book book : bookRepository.findAll()) {
			log.info(book.toString());
		}*/
	
	}
}
