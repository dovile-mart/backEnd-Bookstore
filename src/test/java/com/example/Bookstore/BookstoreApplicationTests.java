package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Bookstore.controller.BookController;

@SpringBootTest
class BookstoreApplicationTests {

	
	@Autowired
	BookController bookController;
	
	@Autowired
	BookController categoryController;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
		assertThat(categoryController).isNotNull();
	}
}
