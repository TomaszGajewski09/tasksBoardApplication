package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {

    @GetMapping(name = "")
    public List<TaskDto> getTasks() {
        return new ArrayList<>();
    }

    @GetMapping
    public TaskDto getTask(Long taskId) {

        return new TaskDto(1l, "test title", "test_content");
    }

    @DeleteMapping
    public void deleteTask(Long taskId) {

    }

    @PutMapping
    public TaskDto updateTask(TaskDto taskDto) {

        return new TaskDto(1l, "Edited test title", "Test content");
    }

    @PostMapping
    public void createTask(TaskDto taskDto) {

    }
}


