package com.acme.trackzonebackend.Incidents.domain.services;

import com.acme.trackzonebackend.Incidents.domain.model.aggregates.Evidence;
import com.acme.trackzonebackend.Incidents.domain.model.commands.CreateEvidenceCommand;
import com.acme.trackzonebackend.Incidents.domain.model.commands.UpdateEvidenceCommand;
import com.acme.trackzonebackend.Incidents.domain.model.queries.GetEvidenceByIdQuery;
import com.acme.trackzonebackend.Incidents.infrastructure.persistence.EvidenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EvidenceService implements EvidenceQueryService, EvidenceCommandService {
    private final EvidenceRepository repository;

    @Override
    public Evidence createEvidence (CreateEvidenceCommand command) {
        Evidence evidence = new Evidence();
        evidence.setDescription(command.getDescription());
        evidence.setImage(command.getImage());
        evidence.setCreatedAt(command.getCreatedAt());
        return repository.save(evidence);
    }

    @Override
    public Evidence updateEvidence(UpdateEvidenceCommand command) {
        Evidence existing = repository.findById(command.getId())
                .orElseThrow(() -> new IllegalArgumentException("Evidence not found"));
        existing.setDescription(command.getDescription());
        existing.setImage(command.getImage());
        existing.setCreatedAt(command.getCreatedAt());
        return repository.save(existing);
    }

    @Override
    public  Evidence getEvidenceById(GetEvidenceByIdQuery query) {
        return repository.findById(query.id())
                .orElseThrow(() -> new IllegalArgumentException("Evidence not found"));
    }

    @Override
    public List<Evidence> getAllEvidences() {
        return repository.findAll();
    }

}
