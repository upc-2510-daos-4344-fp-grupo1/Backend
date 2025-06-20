package com.acme.trackzonebackend.Incidents.infrastructure.persistence;

import com.acme.trackzonebackend.Incidents.domain.model.aggregates.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
    List<Incident> findByStartDateBetween(LocalDateTime start, LocalDateTime end);
    List<Incident> findByResolved(boolean resolved);
    List<Incident> findByWorkingGroupId(long groupId);
}
