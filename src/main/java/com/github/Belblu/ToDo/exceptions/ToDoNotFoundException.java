package com.github.Belblu.ToDo.exceptions;

import java.util.UUID;

public class ToDoNotFoundException extends RuntimeException {
    public ToDoNotFoundException(UUID id) {
        super("Couldn't find ToDo item : " + id);
    }
}
