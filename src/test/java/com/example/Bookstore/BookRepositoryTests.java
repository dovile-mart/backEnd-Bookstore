package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;


@DataJpaTest
class BookRepositoryTests {
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	/*@Test
	void test() {
		fail("Not yet implemented");
	}*/
	
	//toimiiko Book findByTitle-metodi
	@Test
	public void findByTitleShouldReturnTitle() {
		List<Book> books = bookRepository.findByTitle("Huonetoveri");
		assertThat(books.get(0).getTitle().equalsIgnoreCase("huonetoveri"));
	}
	
	//toimiiko Book findByAuthor-metodi
	@Test
	public void findByAuthorShouldReturnBooks() {
		List<Book> books = bookRepository.findByAuthor("Jenna Kostet");
		assertEquals(books.size(), 1);
	}

	//toimiiko Book findByCategoryName-metodi
	@Test
	public void findByCategoryNameShouldReturnBooks() {
		List<Book> books = bookRepository.findByCategoryName("Tietokirjat");
		assertEquals(books.size(), 2);
	}
	
	//toimiiko Category findByName-metodi
	@Test
	public void findCategoryByName() {
		List<Category> categories = categoryRepository.findByName("Tietokirjat");
		assertThat(categories).hasSize(1);
	}
	
	@Test
	public void findBooksCategoryShouldReturnOneCategory() {
		Category category = bookRepository.findById((long)3).get().getCategory();
		System.out.println("Haetaan id=3 kirjan kategoriaa: " + category);
		assertEquals(category.getName(), "Lasten kirjat");
	}
	
	@Test
	public void saveBook() {
		Book book = new Book();
		bookRepository.save(book);
		assertNotEquals(book.getId(), null);
	}
	
	@Test
	public void saveNewBook() {
		Book book = new Book("Testititle", "TestiAuthor", "111111111", 2022, 11.95);
		bookRepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void saveNewBook2() {
		Book book = new Book("Testititle", "TestiAuthor", "111111111", 2022, 11.95, new Category ("Testikirjat"));
		bookRepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void updateBook() {
		Optional<Book> book = bookRepository.findById((long)1);
		assertNotEquals(book.get().getId(), null);
		book.get().setTitle("Testi Title");
		List<Book> books = bookRepository.findByTitle("Testi Title");
		assertThat(books).hasSize(1);
	}

	@Test
	public void saveNewCategory() {
		Category category = new Category("Testikirjat");
		categoryRepository.save(category);
		assertThat(category.getId()).isNotNull();
	}
	
	@Test
	public void updateCategory() {
		Optional<Category> category = categoryRepository.findById((long)1);
		assertNotEquals(category.get().getId(), null);
		category.get().setName("Testi Title");
		List<Category> categories = categoryRepository.findByName("Testi Title");
		assertThat(categories).hasSize(1);
	}

	@Test
	public void deleteCategoryById() throws Exception {
		Category category = new Category("Poistettava kategoria");
		categoryRepository.save(category);
		assertThat(category.getId()).isNotNull();
	}
	
	@Test
	public void deleteCategory() {
		Optional<Category> category = categoryRepository.findById((long)1);
		System.out.println("Haetaan kategoriaa id:llä 1: " + category);
		assertNotEquals(category.get().getId(), null);
		category.get().setName("Testikategoria");
		System.out.println("Haetaan kategoriaa setName Testikategoria jälkeen: " + category);
		category.get().setName(null);
		System.out.println("Haetaan kategoriaa setName null jälkeen: " + category);
		List<Category> categories = categoryRepository.findByName("Testikategoria");
		System.out.println("Haetaan kategoriaa nimellä Testikategoria: " + category);
		assertThat(categories).hasSize(0);
	}
}
