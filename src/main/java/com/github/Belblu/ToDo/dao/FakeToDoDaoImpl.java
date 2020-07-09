package com.github.Belblu.ToDo.dao;

import com.github.Belblu.ToDo.model.ToDoItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fake")
public class FakeToDoDaoImpl implements ToDoDao {
    private static List<ToDoItem> DB = new ArrayList<>();

    @Override
    public int save(UUID id, ToDoItem toDoItem) {
        //DB.add(new ToDoItem(id, toDoItem.getTitle(), toDoItem.getDescription()));
        return 1;
    }

    @Override
    public List<ToDoItem> selectAll() {
        return DB;
    }
}
