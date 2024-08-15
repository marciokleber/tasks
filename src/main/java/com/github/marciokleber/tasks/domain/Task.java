package com.github.marciokleber.tasks.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "TASK")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TASKS")
    @SequenceGenerator(name = "SEQ_TASKS", sequenceName = "SEQ_TASKS")
    private Long id;

    @NotNull(message = "title is mandatory")
    @NotEmpty
    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "varchar(255)")
    private String description;

    @Column(columnDefinition = "boolean default false")
    private Boolean completed;

    @CreationTimestamp
    private LocalDate created_at;

    @UpdateTimestamp
    private LocalDate update_at;
}
