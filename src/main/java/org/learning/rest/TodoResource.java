package org.learning.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.learning.entities.Todo;
import org.learning.service.PersistenceService;
import org.learning.service.QueryService;

import java.util.List;

@Path("todo-resource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {

    @Inject
    private QueryService queryService;

    @Inject
    private PersistenceService persistenceService;

    @GET
    public List<Todo> getAllTodo() {
        System.out.println("getAllTodo");
        return queryService.getAllTodos();
    }

    @POST
    public Response save(Todo todo, @QueryParam("userId") Long userId) {
        System.out.println(todo);
        System.out.println(userId);
        var result = persistenceService.save(todo, userId);
        return Response.ok(result).build();
    }
}
