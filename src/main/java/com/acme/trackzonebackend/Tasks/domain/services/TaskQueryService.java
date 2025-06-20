package com.acme.trackzonebackend.Tasks.domain.services;

import com.acme.trackzonebackend.Tasks.domain.models.aggregates.Task;
import com.acme.trackzonebackend.Tasks.domain.models.queries.GetTaskByIdQuery;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface TaskQueryService {
    Task findTaskById (GetTaskByIdQuery query);
    List<Task> findAllTasks ();
    List<Task> findByWorkerId(int workerId);
    List<Task> findByWorkingGroupId(int workingGroupId);
    List<Task> findByStatus(int status);
    List<Task> findByCreatedAt(LocalDateTime createdAt);
}
