package com.github.Belblu.ToDo.service;

import com.github.Belblu.ToDo.dao.ToDoDao;
import com.github.Belblu.ToDo.dao.ToDoRepo;
import com.github.Belblu.ToDo.exceptions.ToDoNotFoundException;
import com.github.Belblu.ToDo.model.ToDoItem;
import com.github.Belblu.ToDo.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ToDoService {
    private final ToDoRepo toDoDao;

    @Autowired
    public ToDoService(ToDoRepo toDoDao) {
        this.toDoDao = toDoDao;
    }

    public ToDoItem save(ToDoItem toDoItem, User author) {
        return toDoDao.save(toDoItem);
    }

    public void delete(UUID id) {
        toDoDao.deleteById(id);
    }

    public ToDoItem update(UUID id, ToDoItem newToDo) {
        return toDoDao.findById(id)
                .map(todo -> {
                    todo.setTitle(newToDo.getTitle());
                    todo.setDescription(newToDo.getDescription());
                    todo.setDateUntil(newToDo.getDateUntil());
                    return toDoDao.save(todo);
                })
                .orElseGet(() -> {
                    newToDo.setId(id);
                    return toDoDao.save(newToDo);
                });
    }

    /*public String getOne(UUID id, Model model) {
        model.addAttribute("todo", toDoDao.findById(id));
        return "index";
    }*/

    public ToDoItem getOne(UUID id) {
        return toDoDao.findById(id)
                .orElseThrow(() -> new ToDoNotFoundException(id));
    }

    public List<ToDoItem> selectAll() {
        return toDoDao.findAll();
    }
}
