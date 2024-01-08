package com.live.todo.todo.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// les todo sont en base
@Entity
// ATTENTION : les conventions de nommage sont différentes en Java et SQL
@Table(name = "todos")
public class Todo {
	
	// une table a forcément une clé primaire
	@Id
	// autoincrement
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idtodo")
	private int id;
	
	@Column(name = "todotext")
	private String todo;
	
	public Todo() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}
	
	
}
