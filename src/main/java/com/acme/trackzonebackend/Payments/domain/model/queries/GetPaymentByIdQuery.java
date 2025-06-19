package com.acme.trackzonebackend.Payments.domain.model.queries;

public record GetPaymentByIdQuery(Long id) {
    public GetPaymentByIdQuery {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
    }
}
