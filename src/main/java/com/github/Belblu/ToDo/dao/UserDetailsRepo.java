package com.github.Belblu.ToDo.dao;


import com.github.Belblu.ToDo.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepo extends JpaRepository<User, String> {
    @EntityGraph(attributePaths = { "toDoItems" })
    Optional<User> findById(String s);
}
