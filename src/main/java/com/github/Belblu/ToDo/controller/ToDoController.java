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
        return toDoService.save(toDoItem, user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") UUID id) {
        toDoService.delete(id);
    }

    @PutMapping("{id}")
    public ToDoItem update(@PathVariable("id") UUID id,
                       @RequestBody ToDoItem currentItem
    ){

        return toDoService.update(id, currentItem);
    }

    /*@GetMapping("{id}")
    public String getOne(@PathVariable UUID id, Model model) {
        return toDoService.getOne(id, model);
    }*/

    @GetMapping("{id}")
    public ToDoItem getOne(@PathVariable UUID id) {
        return toDoService.getOne(id);
    }

    /*@GetMapping
    public String selectAll(Model model) {
        model.addAttribute("todo", toDoService.selectAll());
        return "index";
    }*/

    @GetMapping
    public List<ToDoItem> selectAll() {
        return toDoService.selectAll();
    }

}
