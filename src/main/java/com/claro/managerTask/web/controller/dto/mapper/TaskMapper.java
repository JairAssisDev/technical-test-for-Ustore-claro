package com.claro.managerTask.web.controller.dto.mapper;

import com.claro.managerTask.entity.TaskItem;
import com.claro.managerTask.web.controller.dto.TaskCreateDto;
import com.claro.managerTask.web.controller.dto.TaskResponseDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class TaskMapper {
    public static TaskItem toTaskItem(TaskCreateDto createDto) {
            return new ModelMapper().map(createDto, TaskItem.class);
    }
    public static TaskResponseDto toDto(TaskItem task) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(task, TaskResponseDto.class);
        return modelMapper.map(task, TaskResponseDto.class);

    }
    public static List<TaskResponseDto> toListDtoTask(List<TaskItem> tasks) {
        return tasks.stream().map(task ->toDto(task) ).collect(Collectors.toUnmodifiableList());
    }



}
