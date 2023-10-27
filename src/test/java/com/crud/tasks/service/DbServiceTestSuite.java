package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DbServiceTestSuite {

    @InjectMocks
    DbService dbService;

    @Mock
    TaskRepository repository;

    private Task testTask;

    @BeforeEach
    public void setUp() {
        testTask = new Task(1L, "Test Task", "Sample content");
    }

    @Test
    void shouldGetAllTasks() {
      // Given
        when(repository.findAll()).thenReturn(List.of(testTask));
      // When
        List<Task> tasks = dbService.getAllTasks();
      // Then
        assertNotNull(tasks);
        assertEquals(1, tasks.size());
        tasks.forEach(result -> {
            assertEquals(testTask.getId(), result.getId());
            assertEquals(testTask.getTitle(), result.getTitle());
            assertEquals(testTask.getContent(), result.getContent());
        });
    }

    @Test
    void shouldGetTaskById() throws TaskNotFoundException {
        // Given
        Long taskId = 1l;
        when(repository.findById(taskId)).thenReturn(Optional.of(testTask));
        // When
        Task result = dbService.getTask(taskId);
        // Then
        assertNotNull(result);
        assertEquals(taskId, testTask.getId());
    }

    @Test
    void shouldThrowExceptionWhenGettingNonExistentTask() {
        // Given
        Long nonExistentTaskId = 999l;
        when(repository.findById(nonExistentTaskId)).thenReturn(Optional.empty());
        // When Then
        assertThrows(TaskNotFoundException.class, () -> dbService.getTask(nonExistentTaskId));
    }

    @Test
    void shouldSaveTask() {
        // Given
        when(repository.save(testTask)).thenReturn(testTask);
        // When
        Task result = dbService.saveTask(testTask);
        // Then
        assertNotNull(result);
        assertEquals(testTask.getId(), result.getId());
        assertEquals(testTask.getTitle(), result.getTitle());
        assertEquals(testTask.getContent(), result.getContent());
    }

    @Test
    void shouldDeleteTask() {
        // Given
        Long taskId = 1l;
        // When
        dbService.deleteTask(taskId);
        // Then
        verify(repository, times(1)).deleteById(taskId);
    }
}
