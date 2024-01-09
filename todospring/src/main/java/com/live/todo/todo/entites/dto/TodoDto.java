package com.live.todo.todo.entites.dto;

import com.live.todo.todo.entites.Todo;

public class TodoDto {
	
	private String todo;
	
	public TodoDto() {}
	
	public TodoDto(Todo todo) {
		this.todo = todo.getTodo();
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}
	
	

}
