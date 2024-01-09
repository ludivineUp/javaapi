package com.live.todo.todo.entites;

import com.live.todo.todo.entites.dto.TodoDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// les todo sont en base
@Entity
// ATTENTION : les conventions de nommage sont différentes en Java et SQL
@Table(name = "todos")
// pour gérer la persistance des classes filles
@Inheritance(strategy = InheritanceType.JOINED)
public class Todo {
	
	// une table a forcément une clé primaire
	@Id
	// autoincrement
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idtodo")
	private int id;
	
	@Column(name = "todotext")
	private String todo;
	
	// une relation n à 1
	// cascade en sql : si je manipule une todo, je manipule aussi l'utilisateur de la todo
	// si on crée un todo d'un nouvel user on crée l'utilisateur en même temps
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="iduser")	// syntaxe sql en base
	private User user;
	
	public Todo() {}

	public Todo(TodoDto todo2) {
		this.todo = todo2.getTodo();
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
