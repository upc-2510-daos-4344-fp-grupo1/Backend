package com.acme.trackzonebackend.Incidents.domain.services;

import com.acme.trackzonebackend.Incidents.domain.model.aggregates.Incident;
import com.acme.trackzonebackend.Incidents.domain.model.queries.GetIncidentByIdQuery;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface IncidentQueryService {
    Incident getById(GetIncidentByIdQuery query);
    List<Incident> getAllIncidents();
    List<Incident> filterByStartDateBetween(LocalDateTime start, LocalDateTime end);
    List<Incident> filterByWorkingGroupId(long groupId);
    List<Incident> filterByResolved(boolean status);
}
