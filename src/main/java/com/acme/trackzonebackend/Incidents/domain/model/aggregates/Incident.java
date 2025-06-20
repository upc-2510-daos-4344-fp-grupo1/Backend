package com.acme.trackzonebackend.Incidents.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "incident")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(name = "started_at", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "resolved_at")
    private LocalDateTime endDate;

    @Column(nullable = false)
    private boolean resolved;

    @Column(name = "working_group_id")
    private int workingGroupId;

    @Column(name = "worker_id")
    private int workerId;

    @OneToOne
    @JoinColumn(name = "evidence_id")
    private Evidence evidence;
}
