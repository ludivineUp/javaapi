package com.live.todo.todo.entites;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Pseudo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String pseudo;
	
	@ManyToMany
	@JoinTable(name = "userspseudo") // notation juste en sql
	private List<User> users;
	
	public Pseudo() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String name) {
		this.pseudo = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
