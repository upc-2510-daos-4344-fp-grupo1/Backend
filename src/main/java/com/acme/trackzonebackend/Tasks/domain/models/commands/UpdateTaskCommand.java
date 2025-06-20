package com.acme.trackzonebackend.Tasks.domain.models.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskCommand {
    private Long id;
    private String description;
    private int supervisorId;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;
    private int status;
    private int workerId;
    private int workingGroupId;
    private int evidenceId;
}
