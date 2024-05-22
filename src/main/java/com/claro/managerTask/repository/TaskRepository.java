package com.claro.managerTask.repository;

import com.claro.managerTask.entity.TaskItem;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface TaskRepository extends JpaRepository<TaskItem, Long> {

}
