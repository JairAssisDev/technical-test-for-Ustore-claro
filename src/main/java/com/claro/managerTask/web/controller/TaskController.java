package com.claro.managerTask.web.controller;

import com.claro.managerTask.entity.TaskItem;
import com.claro.managerTask.exception.ResourceNotFoundException;
import com.claro.managerTask.service.TaskService;
import com.claro.managerTask.web.controller.dto.TaskCreateDto;
import com.claro.managerTask.web.controller.dto.TaskResponseDto;
import com.claro.managerTask.web.controller.dto.mapper.TaskMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("claro/api/task")
@Tag(name = "Task API", description = "API para gerenciar tarefas")
public class TaskController {
    private final TaskService taskService;

    @Operation(summary = "Cria uma nova tarefa", description = "Cria uma nova tarefa com base nas informações fornecidas")
    @PostMapping
    public ResponseEntity<TaskResponseDto> create(@Valid @RequestBody TaskCreateDto taskCreateDto) {
        TaskItem task = taskService.createTask(TaskMapper.toTaskItem(taskCreateDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(TaskMapper.toDto(task));
    }

    @Operation(summary = "Lista todas as tarefas", description = "Retorna uma lista de todas as tarefas")
    @GetMapping
    public List<TaskResponseDto> listAllTasks() {
        List<TaskItem> tasks = taskService.getAllTask();
        return ResponseEntity.ok(TaskMapper.toListDtoTask(tasks)).getBody();
    }

    @Operation(summary = "Remove uma tarefa", description = "Remove a tarefa especificada pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeTask(
            @PathVariable Long id) {
        try {
            taskService.removeTask(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Operation(summary = "Marca uma tarefa como concluída", description = "Marca a tarefa especificada pelo ID como concluída")
    @PatchMapping("/{id}")
    public ResponseEntity<TaskResponseDto> markTaskAsCompleted(
            @PathVariable Long id) {
        try {
            TaskItem taskItem = taskService.finishTask(id);
            return ResponseEntity.ok(TaskMapper.toDto(taskItem));
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
