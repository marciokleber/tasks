package com.github.marciokleber.tasks.controller;

import com.github.marciokleber.tasks.domain.Task;
import com.github.marciokleber.tasks.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<Task>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findTaskById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping()
    public ResponseEntity<Task> create(@RequestBody @Valid Task task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createNewTask(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody @Valid Task task) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.updateTask(id, task));
    }

}
