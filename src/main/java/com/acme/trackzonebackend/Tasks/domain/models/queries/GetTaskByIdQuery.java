package com.acme.trackzonebackend.Tasks.domain.models.queries;

public record GetTaskByIdQuery(Long id) {
    public GetTaskByIdQuery {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }
}
