package com.claro.managerTask.web.controller;

import com.claro.managerTask.entity.TaskItem;
import com.claro.managerTask.service.TaskService;
import com.claro.managerTask.web.controller.dto.TaskCreateDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @MockBean
    TaskService taskService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void create() throws Exception {
        TaskItem task = new TaskItem("compra no supermercado","1- sal 2- carne",false);
        when(this.taskService.createTask(any(TaskItem.class))).thenReturn(task);

        TaskCreateDto taskCreateDto = new TaskCreateDto();
        taskCreateDto.setTitle("compra no supermercado");
        taskCreateDto.setDescription("1- sal 2- carne");
        taskCreateDto.setCompleted(false);

        mockMvc.perform(post("/claro/api/task")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(taskCreateDto)))
                .andExpect(status().isCreated());
    }

    @Test
    void listAllTasks() throws Exception {
        List<TaskItem> tasks = new ArrayList<>();
        tasks.add(new TaskItem("compra no supermercado","1- sal 2- carne",false));
        when(this.taskService.getAllTask()).thenReturn(tasks);

        mockMvc.perform(get("/claro/api/task")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void removeTask() throws Exception {
        Long id = 1L;
        doNothing().when(this.taskService).removeTask(id);

        mockMvc.perform(delete("/claro/api/task/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void markTaskAsCompleted() throws Exception {
        Long id = 1L;
        TaskItem task = new TaskItem("compra no supermercado","1- sal 2- carne",true);
        when(this.taskService.finishTask(id)).thenReturn(task);

        mockMvc.perform(patch("/claro/api/task/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}