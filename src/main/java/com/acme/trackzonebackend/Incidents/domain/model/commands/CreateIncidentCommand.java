package com.acme.trackzonebackend.Incidents.domain.model.commands;

import com.acme.trackzonebackend.Incidents.domain.model.aggregates.Evidence;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateIncidentCommand {
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean resolved;
    private int workingGroupId;
    private int workerId;
    private Evidence evidence;
}
