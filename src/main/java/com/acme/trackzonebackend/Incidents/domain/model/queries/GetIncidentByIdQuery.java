package com.acme.trackzonebackend.Incidents.domain.model.queries;

public record GetIncidentByIdQuery(Long id) {
    public GetIncidentByIdQuery {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }
}
