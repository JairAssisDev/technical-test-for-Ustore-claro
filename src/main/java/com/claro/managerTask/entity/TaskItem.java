package com.claro.managerTask.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
@Entity
@Table(name = "tasks")
public class TaskItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false, unique = true, length = 255)
    private String title;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @Column(name = "completed")
    private boolean completed = false;

    @Column(name = "created_At", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_At")
    private LocalDateTime updatedAt;
}
