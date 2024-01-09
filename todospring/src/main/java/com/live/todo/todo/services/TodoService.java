package com.live.todo.todo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.live.todo.todo.entites.Todo;
import com.live.todo.todo.exceptions.NoDataFoundException;
import com.live.todo.todo.reposotiries.TodoRepository;

@Service
public class TodoService {
	
	// Injection le repo
	@Autowired
	private TodoRepository repo;
	
	public List<Todo> get(){
		List<Todo> todos = repo.findAll();
		if(todos == null || todos.isEmpty()) {
			throw new NoDataFoundException("aucun todo enregistré");
		}
		return repo.findAll();
	}
	
	public Todo get(int id) {
		return repo.findById(id).orElseThrow(() -> new NoDataFoundException("pas de todo avec l'id "+id));
	}
	
	public Todo create(Todo todo) {
		repo.save(todo);
		return todo;
	}

}
