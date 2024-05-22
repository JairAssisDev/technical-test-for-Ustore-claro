package com.claro.managerTask.web.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskCreateDto {

    @NotBlank
    @Size(min = 4, max = 255)
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private boolean completed;
}
