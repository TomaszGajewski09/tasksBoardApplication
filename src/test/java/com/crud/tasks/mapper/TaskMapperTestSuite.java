package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskMapperTestSuite {

    TaskMapper taskMapper = new TaskMapper();

    @Test
    void shouldMapToTask() {
        // Given
        TaskDto taskDto = new TaskDto(1l, "test_task", "Test Content");
        // When
        Task result = taskMapper.mapToTask(taskDto);
        // Then
        assertEquals(taskDto.getId(), result.getId());
        assertEquals(taskDto.getTitle(), result.getTitle());
        assertEquals(taskDto.getContent(), result.getContent());

    }

    @Test
    void shouldMapToTaskDto() {
        // Given
        Task task = new Task(1l, "test_task", "Test Content");
        // When
        TaskDto result = taskMapper.mapToTaskDto(task);
        // Then
        assertEquals(task.getId(), result.getId());
        assertEquals(task.getTitle(), result.getTitle());
        assertEquals(task.getContent(), result.getContent());

    }

    @Test
    void shouldMapToTaskDtoList() {
        // Given
        Task task = new Task(1l, "test_task1", "Test Content");
        List<Task> taskList = List.of(task);
        // When
        List<TaskDto> result = taskMapper.mapToTaskDtoList(taskList);
        // Then
        assertNotNull(result);
        result.forEach(taskDto -> {
            assertEquals(task.getId(), taskDto.getId());
            assertEquals(task.getTitle(), taskDto.getTitle());
            assertEquals(task.getContent(), taskDto.getContent());
        });
    }

    @Test
    void shouldMapToTaskDtoListForEmptyList() {
        // Given
        List<Task> taskList = List.of();
        // When
        List<TaskDto> result = taskMapper.mapToTaskDtoList(taskList);
        // Then
        assertNotNull(result);
        assertEquals(0, result.size());
    }
}
