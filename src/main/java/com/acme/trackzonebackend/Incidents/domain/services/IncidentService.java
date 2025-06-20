package com.acme.trackzonebackend.Incidents.domain.services;

import com.acme.trackzonebackend.Incidents.domain.model.aggregates.Incident;
import com.acme.trackzonebackend.Incidents.domain.model.commands.CreateIncidentCommand;
import com.acme.trackzonebackend.Incidents.domain.model.commands.UpdateIncidentCommand;
import com.acme.trackzonebackend.Incidents.domain.model.queries.GetIncidentByIdQuery;
import com.acme.trackzonebackend.Incidents.infrastructure.persistence.IncidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IncidentService implements IncidentCommandService, IncidentQueryService {
    private final IncidentRepository incidentRepository;

    @Override
    public Incident createIncident (CreateIncidentCommand command) {
        Incident incident = new Incident();
        incident.setDescription(command.getDescription());
        incident.setStartDate(command.getStartDate());
        incident.setEndDate(command.getEndDate());
        incident.setResolved(command.isResolved());
        incident.setWorkingGroupId(command.getWorkingGroupId());
        incident.setWorkerId(command.getWorkerId());
        incident.setEvidence(command.getEvidence());
        return incidentRepository.save(incident);
    }

    @Override
    public Incident updateIncident (UpdateIncidentCommand command) {
        Incident existing = incidentRepository.findById(command.getId())
                .orElseThrow(()-> new IllegalArgumentException("Incident not found"));
        existing.setDescription(command.getDescription());
        existing.setStartDate(command.getStartDate());
        existing.setEndDate(command.getEndDate());
        existing.setResolved(command.isResolved());
        existing.setWorkingGroupId(command.getWorkingGroupId());
        existing.setWorkerId(command.getWorkerId());
        existing.setEvidence(command.getEvidence());
        return incidentRepository.save(existing);
    }

    @Override
    public Incident getById (GetIncidentByIdQuery query) {
        return incidentRepository.findById(query.id())
                .orElseThrow(()-> new IllegalArgumentException("Incident not found"));
    }

    @Override
    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    @Override
    public List<Incident> filterByStartDateBetween(LocalDateTime start, LocalDateTime end) {
        return incidentRepository.findByStartDateBetween(start, end);
    }

    @Override
    public List<Incident> filterByWorkingGroupId(long groupId) {
        return incidentRepository.findByWorkingGroupId(groupId);
    }

    @Override
    public List<Incident> filterByResolved(boolean status) {
        return incidentRepository.findByResolved(status);
    }
}
