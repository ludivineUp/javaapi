package com.live.todo.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication

@OpenAPIDefinition(info = @Info(title = "Todo API", version = "beta", description = "Api de démonstration"))
public class TodoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

}