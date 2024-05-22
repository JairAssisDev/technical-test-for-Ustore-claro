package com.claro.managerTask.web.controller;

import com.claro.managerTask.entity.TaskItem;
import com.claro.managerTask.service.TaskService;
import com.claro.managerTask.web.controller.dto.TaskCreateDto;
import com.claro.managerTask.web.controller.dto.TaskResponseDto;
import com.claro.managerTask.web.controller.dto.mapper.TaskMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("claro/api/task")
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponseDto> create(@Valid @RequestBody TaskCreateDto taskCreateDto) {
        TaskItem task = taskService.createTask(TaskMapper.toTaskItem(taskCreateDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(TaskMapper.toDto(task));
    }

    @GetMapping
    public List<TaskResponseDto> listAllTasks() {
        List<TaskItem> tasks = taskService.getAllTask();
        return ResponseEntity.ok(TaskMapper.toListDtoTask(tasks)).getBody();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeTask(@PathVariable Long id) {
        taskService.removeTask(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<TaskResponseDto> markTaskAsCompleted(@PathVariable Long id) {
        TaskItem taskItem = taskService.finishTask(id);
        return ResponseEntity.ok(TaskMapper.toDto(taskItem));
    }
}
