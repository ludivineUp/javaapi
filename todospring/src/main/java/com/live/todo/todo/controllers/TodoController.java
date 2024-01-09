package com.live.todo.todo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.live.todo.todo.entites.Todo;
import com.live.todo.todo.entites.dto.TodoDto;
import com.live.todo.todo.services.TodoService;

@RestController("api/todo")
public class TodoController {
	
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
	public ResponseEntity<List<Todo>> get(){
		// on supprime grâce à la gestion des erreurs le if
		//if(service.get() == null)
		//	return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		return ResponseEntity.ok().body(service.get());
	}

	// récupérer un paramètre de l'url
	@GetMapping("/{id}")
	public ResponseEntity<Todo> get(@PathVariable("id") int id){
		return ResponseEntity.ok().body(service.get(id));		
	}
	
	// save
	@PostMapping("")
	public ResponseEntity<TodoDto> add(@RequestBody TodoDto todo){
		return ResponseEntity.ok().body(service.create(todo));		
	}
}
