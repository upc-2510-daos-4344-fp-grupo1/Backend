package com.acme.trackzonebackend.Incidents.domain.services;

import com.acme.trackzonebackend.Incidents.domain.model.aggregates.Incident;
import com.acme.trackzonebackend.Incidents.domain.model.commands.CreateIncidentCommand;
import com.acme.trackzonebackend.Incidents.domain.model.commands.UpdateIncidentCommand;
import org.springframework.stereotype.Service;

@Service
public interface IncidentCommandService {
    Incident createIncident(CreateIncidentCommand command);
    Incident updateIncident(UpdateIncidentCommand command);
}
