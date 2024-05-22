package com.claro.managerTask.service;

import com.claro.managerTask.entity.TaskItem;
import com.claro.managerTask.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
    public List<TaskItem> getAllTask() {
        return taskRepository.findAll();
    }

    @Transactional
    public TaskItem finishTask(Long id) {
        TaskItem task = taskRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Tarefa não encontrada.")
        );
        //task.setCompleted(true);
        task.setUpdatedAt(LocalDateTime.now());
        return task;
    }

    @Transactional
    public void removeTask(Long id) {
        TaskItem task = taskRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Tarefa não encontrada.")
        );
        taskRepository.delete(task);
    }

}
