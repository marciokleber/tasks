package com.github.marciokleber.tasks.service;

import com.github.marciokleber.tasks.domain.Task;
import com.github.marciokleber.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    /**
     * Create a new task
     */
    public Task createNewTask(Task task) {
        return taskRepository.save(task);
    }

    /**
     * Update task
     */
    public void updateTask() {}

    /**
     * Delete task
     */
    public void deleteTaskById(Long id) {
        taskRepository.findById(id).ifPresentOrElse(taskRepository::delete, () -> {});
    }

    /**
     * Find task by attribute id
     */
    public Task findTaskById(Long id) {
        return taskRepository.findById(id)
                .isPresent() ?
                taskRepository.findById(id).get() : null;
    }

    /**
     * Find all tasks
     */
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }
}
