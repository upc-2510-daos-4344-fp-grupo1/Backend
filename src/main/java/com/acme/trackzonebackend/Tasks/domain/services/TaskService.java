package com.acme.trackzonebackend.Tasks.domain.services;

import com.acme.trackzonebackend.Tasks.domain.models.aggregates.Task;
import com.acme.trackzonebackend.Tasks.domain.models.commands.CreateTaskCommand;
import com.acme.trackzonebackend.Tasks.domain.models.commands.UpdateTaskCommand;
import com.acme.trackzonebackend.Tasks.domain.models.queries.GetTaskByIdQuery;
import com.acme.trackzonebackend.Tasks.infrastructure.persistence.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService implements TaskCommandService, TaskQueryService {
    private final TaskRepository repository;

    @Override
    public Task createTask (CreateTaskCommand command) {
        Task task = new Task();
        task.setDescription(command.getDescription());
        task.setSupervisorId(command.getSupervisorId());
        task.setCreatedAt(command.getCreatedAt());
        task.setCompletedAt(command.getCompletedAt());
        task.setStatus(command.getStatus());
        task.setWorkerId(command.getWorkerId());
        task.setWorkingGroupId(command.getWorkingGroupId());
        task.setEvidenceId(command.getEvidenceId());
        return repository.save(task);
    }

    @Override
    public Task updateTask (UpdateTaskCommand command) {
        Task existing = repository.findById(command.getId())
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        existing.setDescription(command.getDescription());
        existing.setSupervisorId(command.getSupervisorId());
        existing.setCreatedAt(command.getCreatedAt());
        existing.setCompletedAt(command.getCompletedAt());
        existing.setStatus(command.getStatus());
        existing.setWorkerId(command.getWorkerId());
        existing.setWorkingGroupId(command.getWorkingGroupId());
        existing.setEvidenceId(command.getEvidenceId());
        return repository.save(existing);
    }

    @Override
    public Task findTaskById (GetTaskByIdQuery query) {
        return repository.findById(query.id())
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
    }

    @Override
    public List<Task> findAllTasks () {
        return repository.findAll();
    }

    @Override
    public List<Task> findByWorkerId(int workerId) {
        return repository.findByWorkerId(workerId);
    }

    @Override
    public List<Task> findByWorkingGroupId(int workingGroupId) {
        return repository.findByWorkingGroupId(workingGroupId);
    }

    @Override
    public List<Task> findByStatus(int status) {
        return repository.findByStatus(status);
    }

    @Override
    public List<Task> findByCreatedAt(LocalDateTime createdAt) {
        return repository.findByCreatedAt(createdAt);
    }

}
