package com.acme.trackzonebackend.Tasks.domain.models.aggregates;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column (name = "supervisor_id")
    // connect with table
    private int supervisorId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    private int status;

    @Column(name = "worker_id")
    //connect
    private int workerId;

    @Column(name = "working_group_id")
    private int workingGroupId;

    @Column(name = "evidence_id")
    private int evidenceId;

}
