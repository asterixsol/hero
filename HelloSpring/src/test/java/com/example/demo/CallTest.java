package com.example.demo;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.BookController;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.StubBookRepository;


public class CallTest {

	
	MockMvc mvc;
	
	
	@Before
	public void setup()
	{
		mvc=MockMvcBuilders.standaloneSetup(new BookController(new StubBookRepository())).build();
	}
	
	@Test
	public void testStatus() throws Exception
	{
		mvc.perform(get("/helloName?name=tom")).andExpect(status().isOk());
	
	}
	
}
