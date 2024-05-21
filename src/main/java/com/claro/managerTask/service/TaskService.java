package com.claro.managerTask.service;

import com.claro.managerTask.entity.TaskItem;
import com.claro.managerTask.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Transactional
    public TaskItem createTask(TaskItem task) {
        return taskRepository.save(task);
    }

    @Transactional(readOnly = true)
    public List<TaskItem> getAll() {
        return taskRepository.findAll();
    }

    @Transactional
    public TaskItem finishTask(String descricao) {
        TaskItem task = taskRepository.findByDescription(descricao).orElseThrow(
                () -> new RuntimeException("Tarefa não encontrada.")
        );
        task.setCompleted(true);
        return task;
    }

    @Transactional
    public void removeTask(String descricao) {
        TaskItem task = taskRepository.findByDescription(descricao).orElseThrow(
                () -> new RuntimeException("Tarefa não encontrada.")
        );
        taskRepository.delete(task);
    }
}
