package com.acme.trackzonebackend.Incidents.domain.services;

import com.acme.trackzonebackend.Incidents.domain.model.aggregates.Evidence;
import com.acme.trackzonebackend.Incidents.domain.model.commands.CreateEvidenceCommand;
import com.acme.trackzonebackend.Incidents.domain.model.commands.UpdateEvidenceCommand;
import org.springframework.stereotype.Service;

@Service
public interface EvidenceCommandService {
    Evidence createEvidence(CreateEvidenceCommand command);
    Evidence updateEvidence(UpdateEvidenceCommand command);
}
