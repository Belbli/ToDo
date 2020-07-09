package com.github.Belblu.ToDo.dao;

import com.github.Belblu.ToDo.model.ToDoItem;

import java.util.List;
import java.util.UUID;

public interface ToDoDao {
    int save(UUID id, ToDoItem toDoItem);

    default int save(ToDoItem toDoItem) {
        return save(UUID.randomUUID(), toDoItem);
    }

    List<ToDoItem> selectAll();
}
