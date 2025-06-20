package com.acme.trackzonebackend.Incidents.domain.services;

import com.acme.trackzonebackend.Incidents.domain.model.aggregates.Evidence;
import com.acme.trackzonebackend.Incidents.domain.model.queries.GetEvidenceByIdQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EvidenceQueryService {
    Evidence getEvidenceById(GetEvidenceByIdQuery query);
    List<Evidence> getAllEvidences();
}
