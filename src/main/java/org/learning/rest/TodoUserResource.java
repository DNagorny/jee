package org.learning.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.learning.entities.TodoUser;
import org.learning.service.PersistenceService;
import org.learning.service.QueryService;

@Path("todo-user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoUserResource {

    @Inject
    private QueryService queryService;

    @Inject
    private PersistenceService persistenceService;

    @POST
    public Response save(TodoUser todoUser) {
        System.out.println(todoUser);
        var user = persistenceService.save(todoUser);
        return Response.ok(user).build();
    }

    @GET
    public Response getAllTodos(@QueryParam("userId") Long userId) {
        System.out.println(userId);
        var result = queryService.getAllTodos(userId);
        return result != null ? Response.ok(result).build() : Response.status(Response.Status.NOT_FOUND).build();
    }
}
