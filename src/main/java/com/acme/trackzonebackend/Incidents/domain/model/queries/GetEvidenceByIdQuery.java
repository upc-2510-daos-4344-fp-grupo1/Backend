package com.acme.trackzonebackend.Incidents.domain.model.queries;

public record GetEvidenceByIdQuery(Long id) {
    public GetEvidenceByIdQuery {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }
}
