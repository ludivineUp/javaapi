package com.live.todo.todo.reposotiries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.live.todo.todo.entites.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
	
	// toutes les méthodes du CRUD classique sont automatiquement générées
	
	// pour les méthodes spécifiques : méthode abstraite avec les mots clés de SQL
	
	public Todo findByTodoStartingWith(String begin);

	/*
	 	Commence toujours par find[Distinct]By
		findDistinctByLastnameAndFirstname
		findByLastnameAndFirstname
		findByLastnameOrFirstname
		findByFirstname,findByFirstnameIs,findByFirstnameEquals
		findByStartDateBetween
		findByAgeLessThan
		findByAgeLessThanEqual
		findByAgeGreaterThan
		findByAgeGreaterThanEqual
		etc...
	 */
}
