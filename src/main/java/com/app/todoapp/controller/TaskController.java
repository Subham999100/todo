package com.app.todoapp.controller;

import org.springframework.ui.Model;

import com.app.todoapp.model.Task;
import com.app.todoapp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping()
    public String getTask(Model model){
        List<Task> tasks=taskService.getAllTasks();
        model.addAttribute("tasks" , tasks);
        return "tasks";
    }
    @PostMapping
    public String createTitle(@RequestParam String  title){
        taskService.createTitle(title);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String DeletTask(@PathVariable Long id){
        taskService.deletetask(id);
        return "redirect:/";
    }
    @GetMapping("/{id}/toggle")
    public String ToogleTask(@PathVariable Long id){
        taskService.toogletask(id);
        return "redirect:/";
    }
}
