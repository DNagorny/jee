package org.learning.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.learning.entities.Todo;
import org.learning.entities.TodoUser;

import java.util.List;

@Transactional
@ApplicationScoped
public class QueryService {

    @PersistenceContext(unitName = "pu")
    private EntityManager entityManager;

    public List<Todo> getAllTodos() {
        return entityManager.createQuery("select todo from Todo todo order by todo.dueDate", Todo.class)
                .getResultList();
    }

    public List<Todo> getAllTodos(Long userId) {
        var user = findById(userId);
        if (user != null) {
            return entityManager.createQuery("select todo from Todo todo where todo.todoUser = :user", Todo.class)
                    .setParameter("user", user)
                    .getResultList();
        }
        return null;
    }

    public List<TodoUser> getAllTodoUsers() {
        return entityManager.createNamedQuery(TodoUser.GET_ALL_USERS, TodoUser.class)
                .getResultList();
    }

    public TodoUser findById(Long id) {
        return entityManager.find(TodoUser.class, id);
    }
}
