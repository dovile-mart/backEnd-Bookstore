package com.example.Bookstore;
//mm. mockMvc:n get- ja post-metodit
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@SpringBootTest
public class BookRestTests {
	@Autowired
	private WebApplicationContext webAppContext;
	
	private MockMvc mockMvc;
	
	@BeforeEach //JUnit5
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
	
	//onnistuuko /books palautus
	@Test
	public void checkStatus() throws Exception {
		mockMvc.perform(get("/books")).andExpect(status().isOk());
	}
	
	//onko sisältö JSON-muodossa
	@Test
	public void checkResponseTypeJson() throws Exception {
		mockMvc.perform(get("/books")).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	//yhden kirjan tiedot JSON-muodossa
	@Test
	public void checkResponseTypeJson2() throws Exception {
		mockMvc.perform(get("/books/1")).andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}


}
