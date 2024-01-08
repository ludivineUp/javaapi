package com.formation.todo.controler;

import java.util.ArrayList;
import java.util.List;


import com.formation.todo.model.Todo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/todo")
public class TodoResource {
	
	private List<Todo> todos = getTodos();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response allTodos() {
		return Response.status(200).entity(todos).build();
	}

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTodo(@PathParam("id") Integer id) {
		//return todos.get(id);
		Todo t;
		try {
			t = todos.get(id);
		}catch (Exception e) {
			return Response.status(500).entity("Exception inconnue levée").build();
		}
		return Response.status(200).entity(todos.get(id)).build();
	}
	
	@Path("/add")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addTodo(Todo todo) {
		todo.setId(todos.size() + 1);
		todos.add(todo);
		return Response.status(200).entity(todo).build();
	}

	private static List<Todo> getTodos() {
		List<Todo> todos = new ArrayList<Todo>();
		todos.add(new Todo(0,"check grève SNCF"));
		todos.add(new Todo(1,"faire les courses"));
		return todos;
	}
	
	
}
