package com.github.Belblu.ToDo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table
@ToString(of = {"id", "title", "description"})
@EqualsAndHashCode(of = {"id"})
@Data
public class ToDoItem {
    @Id
    @GeneratedValue
    @Type(type="pg-uuid")
    private UUID id;
    private String title;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateUntil;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User author;
}
