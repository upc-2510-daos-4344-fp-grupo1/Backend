package com.acme.trackzonebackend.Incidents.infrastructure.persistence;

import com.acme.trackzonebackend.Incidents.domain.model.aggregates.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvidenceRepository extends JpaRepository<Evidence, Long> {
}
