package org.learning.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.learning.entities.Todo;
import org.learning.entities.TodoUser;

@Transactional
@RequestScoped
public class PersistenceService {

    @Inject
    private QueryService queryService;

    @PersistenceContext(unitName = "pu")
    private EntityManager entityManager;

    public TodoUser save(TodoUser todoUser) {
        entityManager.persist(todoUser);
        return todoUser;
    }

    public TodoUser update(TodoUser todoUser) {
        return entityManager.merge(todoUser);
    }

    public Todo save(Todo todo, Long todoUserId) {
        var user = queryService.findById(todoUserId);
        if (user != null) {
            todo.setTodoUser(user);
            entityManager.persist(todo);
        }
        return todo;
    }
}
