package com.github.Belblu.ToDo.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "usr")
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.StringIdGenerator.class,
        property = "id"
)
public class User implements Serializable{
    @Id
    private String id;
    private String name;
    private String userpic;
    private String email;
    private String gender;
    private String locale;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastVisit;

    @OneToMany(mappedBy = "author", orphanRemoval = true)
    private List<ToDoItem> toDoItems = new ArrayList<>();

    public void addItem(ToDoItem toDoItem) {
        this.toDoItems.add(toDoItem);
    }

    public void deleteById(UUID id) {
        ToDoItem itemToDelete = toDoItems.stream()
                .filter(toDoItem -> toDoItem.getId().equals(id))
                .findFirst().get();
        this.toDoItems.remove(itemToDelete);
    }

    public void updateById(UUID id, ToDoItem toDoItem) {
        toDoItems.stream()
                .filter(item -> item.getId().equals(id))
                .forEach(item -> {
                    item.setTitle(toDoItem.getTitle());
                    item.setDescription(toDoItem.getDescription());
                    item.setDateUntil(toDoItem.getDateUntil());
                });
    }
}
