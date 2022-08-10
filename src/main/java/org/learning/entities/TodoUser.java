package org.learning.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = TodoUser.GET_ALL_USERS, query = "select user from TodoUser user order by user.name")
public class TodoUser extends AbstractEntity {

    public static final String GET_ALL_USERS = "TodoUser.getAllUsers";

    private String name;

    private String email;

    public String getName() {
        return name;
    }

    public TodoUser setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public TodoUser setEmail(String email) {
        this.email = email;
        return this;
    }
}
