package com.formation.todo;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.formation.todo.controler.TodoResource;

public class Main {
	public static final URI BASE_URI = URI.create("http://localhost:8084");

    // Starts Grizzly HTTP server
    public static HttpServer startHttpServer() {

        final ResourceConfig config = new ResourceConfig();
        config.register(TodoResource.class);
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, config);
    }

    public static void main(String[] args) {
    	try {

            final HttpServer server = startHttpServer();

            server.start();

            // shut down hook
            Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow));

            System.out.println(
              String.format("Application started.%n"+BASE_URI+"%nStop the application using CTRL+C"));

            // block and wait shut down signal, like CTRL+C
            Thread.currentThread().join();

        } catch (InterruptedException | IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 


}
