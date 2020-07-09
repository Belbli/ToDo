package com.github.Belblu.ToDo.dao;

import com.github.Belblu.ToDo.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ToDoRepo extends JpaRepository<ToDoItem, UUID> {
}
