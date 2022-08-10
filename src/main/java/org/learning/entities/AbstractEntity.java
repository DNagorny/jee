package org.learning.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDate;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    protected Long id;

    protected LocalDate created;

    protected LocalDate lastEdited;

    public LocalDate getCreated() {
        return created;
    }

    public LocalDate getLastEdited() {
        return lastEdited;
    }

    public AbstractEntity setLastEdited(LocalDate lastEdited) {
        this.lastEdited = lastEdited;
        return this;
    }

    public AbstractEntity setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public Long getId() {
        return id;
    }

    public AbstractEntity setId(Long id) {
        this.id = id;
        return this;
    }
}
