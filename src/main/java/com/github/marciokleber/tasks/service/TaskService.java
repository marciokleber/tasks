package com.github.marciokleber.tasks.service;

import com.github.marciokleber.tasks.domain.Task;
import com.github.marciokleber.tasks.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
     *
     * @return
     */
    public Task updateTask(Long id, Task task) {
        if (taskRepository.findById(id).isEmpty()) throw new EntityNotFoundException();
        return taskRepository.save(task);
    }

    /**
     * Delete task
     */
    public void deleteTaskById(Long id) {
        taskRepository.findById(id)
                .ifPresentOrElse(taskRepository::delete, () -> { throw new EntityNotFoundException(); });
    }

    /**
     * Find task by attribute id
     */
    public Task findTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    /**
     * Find all tasks
     */
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }
}
