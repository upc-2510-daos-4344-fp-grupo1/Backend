package com.acme.trackzonebackend.Tasks.infrastructure.persistence;

import com.acme.trackzonebackend.Tasks.domain.models.aggregates.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByWorkerId(int workerId);
    List<Task> findByWorkingGroupId(int workingGroupId);
    List<Task> findByStatus(int status);
    List<Task> findByCreatedAt(LocalDateTime createdAt);
}
