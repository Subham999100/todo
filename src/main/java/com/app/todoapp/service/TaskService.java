package com.app.todoapp.service;

import com.app.todoapp.model.Task;
import com.app.todoapp.repositry.TaskRepositry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepositry taskRepositry;

    public TaskService(TaskRepositry taskRepositry) {
        this.taskRepositry = taskRepositry;
    }

    public List<Task> getAllTasks() {
        return taskRepositry.findAll();
    }

    public void createTitle(String title) {
        Task task =new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepositry.save(task);
    }
}

