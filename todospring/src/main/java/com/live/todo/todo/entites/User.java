package com.live.todo.todo.entites;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class User {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		
		private String name;
		
		// un user peut avoir pls pseudo : relation  n-a-n
		// il y a un lien avec la classe Pseudo
		@ManyToMany(mappedBy = "users")
		private List<Pseudo> pseudos;
		
		public User() {}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Pseudo> getPseudos() {
			return pseudos;
		}

		public void setPseudos(List<Pseudo> pseudos) {
			this.pseudos = pseudos;
		}
		
		
}
