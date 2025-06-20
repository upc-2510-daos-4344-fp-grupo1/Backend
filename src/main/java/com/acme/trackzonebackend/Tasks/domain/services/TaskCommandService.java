package com.acme.trackzonebackend.Tasks.domain.services;

import com.acme.trackzonebackend.Tasks.domain.models.aggregates.Task;
import com.acme.trackzonebackend.Tasks.domain.models.commands.CreateTaskCommand;
import com.acme.trackzonebackend.Tasks.domain.models.commands.UpdateTaskCommand;
import org.springframework.stereotype.Service;

@Service
public interface TaskCommandService {
    Task createTask (CreateTaskCommand command);
    Task updateTask (UpdateTaskCommand command);
}
