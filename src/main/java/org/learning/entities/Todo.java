package org.learning.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

import java.time.LocalDate;

@Entity
public class Todo extends AbstractEntity {

    private String task;

    private LocalDate dueDate;

    private boolean completed;

    private boolean archived;

    @ManyToOne
    private TodoUser todoUser;

    @Transient
    private String transientMember;

    public TodoUser getTodoUser() {
        return todoUser;
    }

    public Todo setTodoUser(TodoUser todoUser) {
        this.todoUser = todoUser;
        return this;
    }

    public String getTransientMember() {
        return transientMember;
    }

    public Todo setTransientMember(String transientMember) {
        this.transientMember = transientMember;
        return this;
    }

    public String getTask() {
        return task;
    }

    public Todo setTask(String task) {
        this.task = task;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Todo setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Todo setCompleted(boolean completed) {
        this.completed = completed;
        return this;
    }

    public boolean isArchived() {
        return archived;
    }

    public Todo setArchived(boolean archived) {
        this.archived = archived;
        return this;
    }
}
