package com.github.Belblu.ToDo.controller;

import com.github.Belblu.ToDo.model.ToDoItem;
import com.github.Belblu.ToDo.model.User;
import com.github.Belblu.ToDo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RequestMapping("todo")
@RestController
public class ToDoController {
    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping
    public ToDoItem save(@RequestBody ToDoItem toDoItem,
                         @AuthenticationPrincipal User user
    ) {
        user.addItem(toDoItem);
        return toDoService.save(toDoItem, user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") UUID id, @AuthenticationPrincipal User user) {
        user.deleteById(id);
        toDoService.delete(id);
    }

    @PutMapping("{id}")
    public ToDoItem update(@PathVariable("id") UUID id,
                           @RequestBody ToDoItem currentItem,
                           @AuthenticationPrincipal User user
                           ){

        return toDoService.update(id, currentItem, user);
    }

    @GetMapping("{id}")
    public ToDoItem getOne(@PathVariable UUID id) {
        return toDoService.getOne(id);
    }

    @GetMapping
    public List<ToDoItem> selectAll(@AuthenticationPrincipal User user) {
        return toDoService.selectAll(user);
    }

}
