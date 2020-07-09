package com.github.Belblu.ToDo.controller;

import com.github.Belblu.ToDo.model.User;
import com.github.Belblu.ToDo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {
    private final ToDoService toDoService;

    @Value("${spring.profiles.active}")
    private String profile;

    @Autowired
    public MainController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }


    @GetMapping
    public String selectAll(Model model,
                            @AuthenticationPrincipal User user) {
        HashMap<Object, Object> data = new HashMap<>();

        if(user != null) {
            data.put("profile", user);
            data.put("todos", toDoService.selectAll());
        }
        model.addAttribute("frontendData", data);

        model.addAttribute("todo", toDoService.selectAll());

        model.addAttribute("isDevMode", "dev".equals(profile));

        return "index";
    }
}
