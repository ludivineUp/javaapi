package com.live.todo.todo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.live.todo.todo.entites.Todo;
import com.live.todo.todo.entites.dto.TodoDto;
import com.live.todo.todo.services.TodoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/todo")
@Tag(name = "toto controlleur", description = "the todo API")
public class TodoController implements HealthIndicator{
	
	@Autowired
	private TodoService service;
	
	// une route sale
	@GetMapping("/beurk")
	public List<Todo> getSale(){
		return service.get();
	}
	
	// une route propre
	// response entité nous donne la main sur le réponse HTTP : code, status, header
	@GetMapping("/all")
	@Operation(summary = "toutes les todo", description = "all todo") 
	@ApiResponses(value = {
		@ApiResponse(responseCode = "201", description = "get all todo"),
		@ApiResponse(responseCode = "404", description = "no todo found"),
	}) 
	public ResponseEntity<List<Todo>> get(){
		// on supprime grâce à la gestion des erreurs le if
		//if(service.get() == null)
		//	return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		return ResponseEntity.ok().body(service.get());
	}

	// récupérer un paramètre de l'url
	@GetMapping("/{id}")
	@Operation(summary = "une todo", description = "one todo")
	public ResponseEntity<Todo> get(@PathVariable("id") @Parameter(description = "id of the todo")int id){
		return ResponseEntity.ok().body(service.get(id));		
	}
	
	// save
	@PostMapping("/add")
	@Operation(summary = "add todo", description = "add todo")
	public ResponseEntity<TodoDto> add(@RequestBody TodoDto todo){
		return ResponseEntity.ok().body(service.create(todo));		
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@Override
	public Health health() {
		// TODO Auto-generated method stub
		return service != null ? Health.up().build() : Health.down().build();
	}
}
