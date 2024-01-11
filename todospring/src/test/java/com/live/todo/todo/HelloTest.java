package com.live.todo.todo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.live.todo.todo.controllers.TodoController;
import com.live.todo.todo.entites.Todo;
import com.live.todo.todo.entites.dto.TodoDto;
import com.live.todo.todo.reposotiries.TodoRepository;
import com.live.todo.todo.services.TodoService;

import jakarta.persistence.EntityManager;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
//@TestPropertySource(locations="classpath:test.resources.properties")
class HelloTest {

	//@Autowired
	//private TodoController controller;
	
	// fausse appli
	@Autowired
	private MockMvc mock;

	@Autowired
	private TodoRepository repo;
	
	//@Test
	//void contextLoads() {
	//	assertThat(controller).isNotNull();
	//}
	
	//testerle retour de la route hello
	@Test
	void statusRouteHello() throws Exception {
		mock.perform(get("http://localhost:8080/api/todo/hello")).andDo(print()).andExpect(content().string(containsString("hello")));
	}
	
	@Test
	void notodo() throws Exception{
		mock.perform(get("http://localhost:8080/api/todo/all")).andDo(print()).andExpect(status().isNotFound());
	} 
	
	@Test
	void add() throws Exception{
		Todo t = new Todo();
		t.setTodo("test");
		repo.saveAndFlush(t);
		System.out.println(t.getId());
		mock.perform(get("http://localhost:8080/api/todo/1")).andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value(1))
		.andExpect(jsonPath("$.todo").value("test"));
	}

	@After(value = "")
	void clear() {
		repo.deleteAll();
	}
}
